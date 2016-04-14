package com.inno.modelview.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.inno.modelview.model.CoreEntity;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class Util {

	public static List<String[]> csvToList(String path) {
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("D:/workspace/git/modelviewservice/src/main/resources/initialization/CoreEntity.csv"));
			List<String[]> myEntries = csvReader.readAll();
			csvReader.close();
			return myEntries;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection() {		
		try {
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			String url = "jdbc:derby://localhost:1527/ModelView";
			return DriverManager.getConnection(url);
		} catch (InstantiationException e) {			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		Connection conn = getConnection();
		List<String[]> rowList = Util.csvToList(null);
		for(String[] row : rowList) {
			String str = "insert into ModelView(id,EntityName,TableName,BusinessValue,EntityBuilder,PublicId) VALUES(" + 
					     row[0] + "," +
					     "'" + row[1] + "'," +
					     "'" + row[2] + "'," +
					     "'" + row[3] + "'," +
					     "'" + row[4] + "'," +
					     "'" + row[5] + "'" +
		                 ")";
			System.out.println(str);		
			PreparedStatement statement = conn.prepareStatement(str);
			statement.execute();
		}
		conn.close();
	}

}
