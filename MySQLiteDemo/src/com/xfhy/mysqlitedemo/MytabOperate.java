package com.xfhy.mysqlitedemo;

import android.database.sqlite.SQLiteDatabase;

public class MytabOperate {

	private static final String TABLENAME="mytab";   //������
	private SQLiteDatabase db = null;                //SQLiteDatabase
	public MytabOperate(SQLiteDatabase db)   //���췽��
	{
		this.db = db;
	}
	
	 //���
	public void insert(String name,String birthday) 
	{
		String sql = "INSERT INTO " + TABLENAME +"(name,birthday) VALUES('"+
				name+"','"+birthday+"')";   //sql���
		this.db.execSQL(sql);     //ִ��SQL���
		this.db.close();    //�������ݿ�,�ǵùر�
	}
	
	//����
	public void update(int id,String name,String birthday)
	{
		String sql = "UPDATE "+TABLENAME+" SET name='"+name+"',birthday='"+birthday+"' WHERE id="+id;
		this.db.execSQL(sql);  //ִ��SQL���
		this.db.close();   //�������ݿ�,�ǵùر�
	}
	
	//ɾ��
	public void delete(int id)
	{
		String sql = "delete from "+TABLENAME+" WHERE id="+id;
		this.db.execSQL(sql);
		this.db.close();
	}
}
