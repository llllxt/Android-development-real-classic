package com.example.sqlite;

import com.example.sqlite3.DatabaseHelper;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SQLiteActivity extends ActionBarActivity {

	private Button create = null;
	private Button updateData = null;
	private Button insert = null;
	private Button update = null;
	private Button query = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        create = (Button)findViewById(R.id.create);
        updateData = (Button)findViewById(R.id.updateData);
        insert = (Button)findViewById(R.id.insert);
        update = (Button)findViewById(R.id.update);
        query = (Button)findViewById(R.id.query);
        create.setOnClickListener(new createListener());  //���ü�����
        updateData.setOnClickListener(new updateDaListen()); 
        insert.setOnClickListener(new insertListener()); 
        update.setOnClickListener(new updateListener()); 
        query.setOnClickListener(new queryListener()); 
    }
    
    //���ݿ��ַdata/data/com.example.sqlite/databases
    //�������ݿⰴť�ļ�����
    class createListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		                                             //���Activity,���ݿ�汾
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		//��һ�δ������ݿ�,�����onCreate()
    		SQLiteDatabase sq = dbHelper.getReadableDatabase();
    	}
    }
    
    //updateData��ť�ļ�����
    class updateDaListen implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		                                            //�����ݿ�İ汾������,Ҫ����onUpgrade()
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db",2);
    		SQLiteDatabase sq = dbHelper.getReadableDatabase();
    	}
    }
    
    //������ݿⰴť�ļ�����
    class insertListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		//����ContentValues����,�����ݿ�����Ӷ���ʱ,��Ҫ��ContentValues
    		ContentValues values = new ContentValues();
    		//��ö����в����ֵ��,���м�������,ֵ��ϣ�������е�Ԫ��,ֵ������е���������ƥ��
    		values.put("id", 1);
    		values.put("name", "zhangsan");
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		SQLiteDatabase db = dbHelper.getWritableDatabase();
    		//����insert����,�����ݲ����ȥ���ݿ�
    		//����                                          ��Ҫ��ӵ�����
    		db.insert("user", null, values);
    		System.out.println("insert");
    	}
    }
    
    //�������ݿⰴť�ļ�����
    //���²��� :�൱��ִ��SQL�е�update���
    //update table_name SET XXCOL=XX where XXOL=XXX
    class updateListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		//ͨ��������,�õ�һ�����Բ��������ݿ�
    		SQLiteDatabase db = dbHelper.getWritableDatabase(); 
    		ContentValues values = new ContentValues();
    		values.put("name", "xfhy");
    		
    		//�������
    		//����,ֵ,idλ��(where�Ӿ�),id��ֵ
    		db.update("user", values, "id=?", new String[]{"1"});
    		System.out.println("update success!");
    	}
    }
    
    //��ѯ���ݿⰴť�ļ�����
    class queryListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v) {
    		Log.d("mydebug", "myfirstdebugMsg");  //ǰ��������,��������Ϣ
    		// TODO Auto-generated method stub
    		DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this,"test_db");
    		SQLiteDatabase db = dbHelper.getReadableDatabase();
    		/*�����б�:��,��ѯ��Щ��,λ��,id=����,����,��������������,�Բ�ѯ�����Ľ����������
    		 * query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
    		 * */
    		Cursor cursor = db.query("user", new String[]{"id","name"}, "id=?", new String[]{"1"}, null, null, null);
    		
    		//�����ݿ�������ƶ�,һ��һ�е�,�����ڲ���,�ҵ�ʱ������
    		while(cursor.moveToNext())
    		{ 
    			                               //����к�
    			String name = cursor.getString(cursor.getColumnIndex("name"));
    			System.out.println("query---->"+name);
    		}
    		System.out.println("query---->success!");
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sqlite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	
}
