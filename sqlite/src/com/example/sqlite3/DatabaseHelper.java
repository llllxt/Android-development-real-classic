package com.example.sqlite3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * DatabaseHelper��Ϊһ������SQLite��������,�ṩ2������Ĺ���
 * ��һ:getReadableDatabase(),getWritableDatabase()���Ի��SQLiteDatabase����,ͨ���ö������ʵ����ɾ���
 * �ڶ�:�ṩ��onCreate()��onUpgrade()�����ص�����,���������ڴ������������ݿ�ʱ,���в���
 * */
public class DatabaseHelper extends SQLiteOpenHelper{

	//�������ݿ�İ汾
	private static final int VERSION = 1;
	//��SQLiteOpenHelper���൱�б����иù��캯��
	//����(����):Activity����,�������,��ʱ������(�����ֵ����),���ݿ�汾
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		//����ͨ��super���ø���Ĺ��캯��
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	//���캯��2
	public DatabaseHelper(Context context,String name) {
		super(context,name,null, VERSION);
		// TODO Auto-generated constructor stub
	}
	//���캯��3
	public DatabaseHelper(Context context, String name,int version) {
		super(context, name, null, version);
	}
	//�������ݿ� ��һ�ε�������getReadableDatabase()����getWritableDatabase()ִ�к�
	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("create a Database");
		//execSQLִ�е���sql���
		db.execSQL("create table user(id int,name varchar(20))");
	}

	//�������ݿ�
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("update a Database");
	}

}
