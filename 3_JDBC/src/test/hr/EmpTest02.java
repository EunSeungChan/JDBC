package test.hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class EmpTest02 {
	public static void main(String[] args) {
		
		EmpManager emp = new EmpManager();
		String[] s = {"President","Programmer"};
		emp.printEmployee(s);

	}
}
