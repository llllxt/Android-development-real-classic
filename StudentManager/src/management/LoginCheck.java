package com.xfhy.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * ��¼����ļ��
 * �����ݿ����ӵĵ�¼����,�������ݿ�,��������
 * 1.��������(final ����)���ݿ���������,���ݿ�URL,���ݿ��¼��������
 * 2.���췽��,�ӹ��췽���д����û�������û���������
 * 3.��������,ʵ����Connection����,�������ݿ�
 * 4.ʹ��PreparedStatementʵ��ִ��SQL���,�����Ƿ��ܵó����,�ó����¼�ɹ�!����true
 * @author XFHY
 *
 */
public class LoginCheck {
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL = "jdbc:sqlserver://localhost:1433; DatabaseName=StudMan";
	public static final String DBUSER = "XFHY";
	public static final String DBPASSEORD = "w122567";
	private String loginPeople="";
	private String name="";
	private String passwd="";
	public LoginCheck(){}  //�޲ι��캯��
	public LoginCheck(String name,String passwd)  //�вι��캯��
	{
		this.name = name;
		this.passwd = passwd;
	}
	public LoginCheck(String loginPeople,String name,String passwd)  //�вι��캯��
	{
		this.loginPeople = loginPeople;
		this.name = name;
		this.passwd = passwd;
	}
	
	//�������ݿ�
	public Connection connDatabase()
	{
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);  //��������
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSEORD);  //�������ݿ�
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"�������ݿ�ʧ�ܣ�����","�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return conn;
	}
	
	//ʹ��PreparedStatementʵ��ִ��SQL���
	public boolean prepared()
	{
		Connection conn = null;
		PreparedStatement perstat = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = connDatabase();  //��ʼ��Connection����
			if(loginPeople.equals("Student"))
			    sql = "select id,passwrd from student where id=? and passwrd=?";
			else
				sql = "select id,passwrd from teacher where id=? and passwrd=?";
			perstat = conn.prepareStatement(sql);  //����PreparedStatement����
			 //setString�����Ǹ�����и�ֵ�������ܸ�ֱ�Ӹ�����~
			perstat.setString(1, name);   //�����û����������������������SQL�����
			perstat.setString(2, passwd); //�������뵽�����������������SQL�����
			rs = perstat.executeQuery();  //ִ�в�ѯ���,�����շ��ؽ��
			if(rs.next())   //�����ֵ,���ҵ��˺Ϸ����û�
			{
				return true;   
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"��¼��ѯʧ�ܣ�����","�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE);
		} finally {
			try {
				conn.close();   //�ر����ݿ�
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"�ر����ݿ�ʧ�ܣ�����","�����ʾ��Ϣ���",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return false;   //���ݿ����Ҳ����Ϸ����û�
	}
}
