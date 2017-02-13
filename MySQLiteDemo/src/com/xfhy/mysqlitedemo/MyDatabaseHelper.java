package com.xfhy.mysqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	private static final String databasename = "xfhy.db";  //���ݿ�����
	private static final int databaseverson=1;   //���ݿ�汾
	private static final String tablename="mytab";    //���ݱ�����
	
	//���캯��
	public MyDatabaseHelper(Context context) 
	{
		super(context, databasename, null, databaseverson);   
	}

	/**
	 * �������ݿ�
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//create table tablename(id integer primary key,name varchar(50) not null,birthday date not null)
		String sql = "create table "+tablename+"("+"id integer primary key,"+
		"name varchar(50) not null,"+
		"birthday date not null)";
		db.execSQL(sql);

	}

	//�����ݿ���Ҫ����ʱ,���ô˷���,һ���ڴ˷����н����ݱ�ɾ��,������ɾ����֮�����������onCreate()�������´����µ����ݱ�
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "drop table if exists "+tablename;
		db.execSQL(sql);
		this.onCreate(db);    //������

	}

}
