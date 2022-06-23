package com.bude.genericmethods;

import java.io.PrintStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DatabaseFunction
{
  public static Connection con;
  public static String computerName;
  public static String sql;
  public static String Path;
  public String sqlQuery;
  public static String fileType;
  
  public DatabaseFunction()
  {
    try
    {
      //computerName = InetAddress.getLocalHost().getHostName();
      //Path = System.getProperty("user.dir");
      Class.forName("org.relique.jdbc.csv.CsvDriver");
    }
    catch (Exception exc)
    {
      System.out.println("DBConnection Failed" + exc);
    }
  }
  
  public Connection fnGetDbConnection(String FileType)
  {
    String genericPath = System.getProperty("user.dir").concat("/src/main/resources/");
    try
    {
      if ("Input".equals(FileType)) {
        con = DriverManager.getConnection("jdbc:relique:csv:" + genericPath + "TestData/");
      }
      if ("ObjectRepository".equals(FileType)) {
        con = DriverManager.getConnection("jdbc:relique:csv:" + genericPath + "ObjectRep/");
      }
      if ("TestRunner".equals(FileType)) {
        con = DriverManager.getConnection("jdbc:relique:csv:" + genericPath + "TestRunner/TestSuite.csv");
      }
    }
    catch (Exception exc)
    {
      System.out.println("fnGetDbConnectionDBConnection Failed" + exc);
    }
    return con;
  }
  
  public List<String> getTestDataObject(String sqlQuery, String FileType)
  {
    List<String> list = new ArrayList();
    try
    {
      fnGetDbConnection(FileType);
      Statement stmt = con.createStatement();
      ResultSet results = stmt.executeQuery(sqlQuery);
      
      ResultSetMetaData meta = results.getMetaData();
      
	for (int iLoop=1; iLoop < meta.getColumnCount();iLoop++)
      {
        //iLoop = 0; continue;
        list.add(results.getString(iLoop + 1));
      }
      int iLoop = 1;
    }
    catch (Exception exc)
    {
      System.out.println(exc);
    }
    return list;
  }
  
  public Hashtable<String, String> getHashTestData(String sqlQuery, String FileType)
  {
    Hashtable<String, String> htbl = new Hashtable<String, String>();
    try
    {
      fnGetDbConnection("TestRunner");
      Statement stmt = con.createStatement();
      ResultSet results = stmt.executeQuery(sqlQuery);
      
      ResultSetMetaData meta = results.getMetaData();
      while (results.next())
      {
        String TestClass = results.getString("TestClass").trim();
        String Browser = results.getString("Browser").trim();
        htbl.put(TestClass, Browser);
      }
    }
    catch (Exception exc)
    {
      System.out.println(exc);
    }
    return htbl;
  }
}
