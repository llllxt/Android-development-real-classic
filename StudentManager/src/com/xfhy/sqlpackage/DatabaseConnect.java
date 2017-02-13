package com.xfhy.sqlpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * �������ݿ��õ�
 * 
 * @author XFHY
 * 
 */
public class DatabaseConnect {
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL = "jdbc:sqlserver://localhost:1433; DatabaseName=StudMan";
	public static final String DBUSER = "XFHY";
	public static final String DBPASSEORD = "w122567";

	// �������ݿ�
	public static Connection connDatabase() {
		Connection conn = null;
		try {
			Class.forName(DBDRIVER); // ��������
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSEORD); // �������ݿ�
		} catch (Exception e) {
			System.out.println("Connection");
			JOptionPane.showMessageDialog(null, "�������ݿ�ʧ�ܣ�����", "�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return conn;
	}
    
	//ר�������ر�Connection�����
	public static void closeConnection(Connection conn) {
		if(conn!=null){
			try {
				conn.close(); // �ر����ݿ�
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "�ر����ݿ�ʧ�ܣ�����", "�����ʾ��Ϣ���",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
    
	//�ر�Statement�����
	public static void closeStatement(Statement stat) {
		if (stat != null){
			try {
				stat.close(); // �ر����ݿ�
			} catch (Exception e2) {
				System.out.println("Statement");
				JOptionPane.showMessageDialog(null, "�ر����ݿ�ʧ�ܣ�����", "�����ʾ��Ϣ���",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//�ر�
	public static void closeResultset(ResultSet results) {
		if (results != null){
			try {
				results.close(); // �ر����ݿ�
			} catch (Exception e2) {
				System.out.println("ResultSet");
				JOptionPane.showMessageDialog(null, "�ر����ݿ�ʧ�ܣ�����", "�����ʾ��Ϣ���",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
