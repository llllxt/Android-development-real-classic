package com.xfhy.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import com.xfhy.sqlpackage.DatabaseConnect;

public class AddStudentInfo {

	// ����ѧ������Ϣ
	public static boolean updateSQL(String id, String sname, String passwrd,
			String sex, String haddress, String phone, String dorm) {
		// ����DatabaseConnect��connDatabase()���Ի���������ݿ��Connection����
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null; // ����PreparedStatement����
		int reset = 0;
		// UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson'
		String sql = "update student set sname = ?,passwrd = ?,sex = ?,haddress = ?,phone = ?,dorm = ? where "
				+ "id = ?";
		try {
			conn = dataConnect.connDatabase();
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, sname);
			prestat.setString(2, passwrd);
			prestat.setString(3, sex);
			prestat.setString(4, haddress);
			prestat.setString(5, phone);
			prestat.setString(6, dorm);
			prestat.setString(7, id);
			reset = prestat.executeUpdate(); // �����ܵ�Ӱ�������
			if (reset > 0) {
				return true; // �ܵ�Ӱ���������Ϊ0,��ɹ��޸�
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�޸�ָ���û���Ϣʱ�����쳣", "�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE); // ��ʾ�޸�ָ���û���Ϣʱ�����쳣
		} finally {
			// �Լ�д��,DatabaseConnect���е�һ����̬����,�����ر����ݿ�����
			DatabaseConnect.closeConnection(conn);
		}
		return false;
	}

	// ���ѧ����Ϣ
	public static boolean addStuSQL(String id, String sname, String passwrd,
			String sex, String haddress, String phone, String dorm,
			String result) {
		// ����DatabaseConnect��connDatabase()���Ի���������ݿ��Connection����
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null;
		int count = 0; // �������ݿ��в����ɹ�������
		String addsql = "insert into student values(?,?,?,?,?,?,?,?)";
		try {
			conn = dataConnect.connDatabase(); // ����������ݿ��Connection����
			prestat = conn.prepareStatement(addsql); // ʵ����PreparedStatement����
			prestat.setString(1, id);
			prestat.setString(2, sname);
			prestat.setString(3, passwrd);
			prestat.setString(4, sex);
			prestat.setString(5, haddress);
			prestat.setString(6, phone);
			prestat.setString(7, dorm);
			prestat.setString(8, result);
			/*
			 * �ڴ� PreparedStatement ������ִ�� SQL ��䣬�� ��������һ�� SQL ���ݲ������ԣ�Data
			 * Manipulation Language��DML����䣬 ���� INSERT��UPDATE �� DELETE ��䣻
			 * ����:SQL ���ݲ������� (DML) ��������
			 */
			count = prestat.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ѧ����Ϣʱ�����쳣", "�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE); // ��ʾ�޸�ָ���û���Ϣʱ�����쳣
		} finally {
			DatabaseConnect.closeConnection(conn);
			DatabaseConnect.closeStatement(prestat);
		}
		return false;
	}

	// ����ѧ����ȫ����Ϣ
	public static List<Object> selectStuSQL() {
		Object[] os;
		List<Object> list = new ArrayList<Object>();
		// ����DatabaseConnect��connDatabase()���Ի���������ݿ��Connection����
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet rs = null;
		String selectsql = "select * from student";
		try {
			conn = DatabaseConnect.connDatabase();
			prestat = conn.prepareStatement(selectsql);
			rs = prestat.executeQuery();
			while (rs.next()) {
				os = new Object[8];
				double point = rs.getDouble(8);
				os[0] = rs.getString(1);
				os[1] = rs.getString(2);
				os[2] = rs.getString(3);
				os[3] = rs.getString(4);
				os[4] = rs.getString(5);
				os[5] = rs.getString(6);
				os[6] = rs.getString(7);
				os[7] = new Double(point);
				list.add(os);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��ѯ���ݿⷢ���쳣", "�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE);
		} finally {
			DatabaseConnect.closeConnection(conn);
		}
		return list;
	}

	// ����ƽ���ɼ�
	public static double aveScoreStu() {
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet rs = null;
		double score = 0 ;
		String sql = "select avg(result) from student";
		try {
			conn = DatabaseConnect.connDatabase();
			prestat = conn.prepareStatement(sql);
			rs = prestat.executeQuery();
			while(rs.next())
			{
				score = rs.getDouble(1);   //���صĽ���Ǵ�1��ʼ��
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return score;
	}

	// ɾ��ѧ����Ϣ
	public static boolean deleteStuSQL(String id) {
		DatabaseConnect dataConnect = new DatabaseConnect();
		Connection conn = null;
		PreparedStatement prestat = null;
		String deletesql = "delete student where id=?";
		int count = 0;
		try {
			conn = dataConnect.connDatabase();
			prestat = conn.prepareStatement(deletesql);
			prestat.setString(1, id);
			count = prestat.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�����", "�����ʾ��Ϣ���",
					JOptionPane.INFORMATION_MESSAGE);
		} finally {
			DatabaseConnect.closeConnection(conn);
			DatabaseConnect.closeStatement(prestat);
		}
		return false;
	}
}
