package com.xfhy.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.xfhy.sqlpackage.DatabaseConnect;

/**
 * ���ݴ�������ID��ѯ���ݿ��еĸ�ID����Ϣ,�ٷ�������
 * @author XFHY
 *
 */
public class StudentIdSelect {

	private String id = "";
	public static Object[] selectID(String id)
	{
		DatabaseConnect dataconnect = new DatabaseConnect();
		Connection conn =  null;
		PreparedStatement prestat = null;
		ResultSet reset = null;
		String sql = "";
		Object[] os = new Object[8];  //8������
		try {
			conn = dataconnect.connDatabase();
			sql = "select id,sname,passwrd,sex,haddress,phone,dorm,result from student where id=?";
			prestat = conn.prepareStatement(sql);  //��id���õ�sql�����
			prestat.setString(1, id);
			reset = prestat.executeQuery();
			while(reset.next())
			{
				double point = reset.getDouble(8);
				os[0] = reset.getString(1);
				os[1] = reset.getString(2);
				os[2] = reset.getString(3);
				os[3] = reset.getString(4);
				os[4] = reset.getString(5);
				os[5] = reset.getString(6);
				os[6] = reset.getString(7);
				os[7] = new Double(point);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��ѯָ���û���Ϣʱ�����쳣", "�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE);		//��ʾ��ѯָ���û���Ϣʱ�����쳣
		} finally {
			DatabaseConnect.closeConnection(conn);
		}
		return os;
	}
	public static Object[] selectName(String name)
	{
		DatabaseConnect dataconnect = new DatabaseConnect();
		Connection conn =  null;
		PreparedStatement prestat = null;
		ResultSet reset = null;
		String sql = "";
		Object[] os = new Object[8];  //8������
		try {
			conn = dataconnect.connDatabase();
			sql = "select id,sname,passwrd,sex,haddress,phone,dorm,result from student where sname=?";
			prestat = conn.prepareStatement(sql);  //��id���õ�sql�����
			prestat.setString(1, name);
			reset = prestat.executeQuery();
			while(reset.next())
			{
				double point = reset.getDouble(8);
				os[0] = reset.getString(1);
				os[1] = reset.getString(2);
				os[2] = reset.getString(3);
				os[3] = reset.getString(4);
				os[4] = reset.getString(5);
				os[5] = reset.getString(6);
				os[6] = reset.getString(7);
				os[7] = new Double(point);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��ѯָ���û���Ϣʱ�����쳣", "�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE);		//��ʾ��ѯָ���û���Ϣʱ�����쳣
		} finally {
			DatabaseConnect.closeConnection(conn);
		}
		return os;
	}
}
