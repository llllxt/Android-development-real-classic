package com.xfhy.note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * �������ݿ�
 * @author XFHY
 *
 */
public class NotesDB extends SQLiteOpenHelper{

	public static final String TABLE_NAME = "notes";  //����
	public static final String CONTENT = "content";   //����
	public static final String PATH = "path";         //ͼƬ
	public static final String VIDEO = "video";       //��Ƶ
	public static final String ID = "_id";            //id
	public static final String TIME = "time";         //ʱ��
	public NotesDB(Context context) {
		super(context, "notes", null, 1);
	}

	/**
	 * �������ݿ�
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//������,ID����,������,ʱ����
		//TABLE_NAME   CONTENT TIME
		String sql = "CREATE TABLE "+TABLE_NAME+"("
				+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				CONTENT+" TEXT NOT NULL,"+
				PATH+" TEXT ,"+
				VIDEO+" TEXT ,"+
				TIME+" TEXT )";
		/*String sql = "CREATE TABLE "+TABLE_NAME+"("
				+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
				CONTENT+" TEXT NOT NULL,"+
				TIME+" TEXT NOT NULL)";*/
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//���ݿ�����
	}

}
