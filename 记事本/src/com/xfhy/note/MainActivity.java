package com.xfhy.note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	private NotesDB notesDB;     //���ݿ�
	private MyAdapter adapter;
	private SQLiteDatabase dbReader;  //��Ҫһ����ȡ��Ȩ��
	private Button textbtn,imgbtn,videobtn;  //3����ť
	private ListView lv;
	Intent intent;
	
	/*
	 * Cursor ��ÿ�еļ��ϡ�
		ʹ�� moveToFirst() ��λ��һ�С�
		�����֪��ÿһ�е����ơ�
		�����֪��ÿһ�е��������͡�
		Cursor ��һ�����������Դ��
		���е����ݶ���ͨ���±�ȡ�á�
	 * */
	Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();     //��ʼ��
    }
    
    //��ʼ��
    public void initView()
    {
    	lv = (ListView)findViewById(R.id.list);
    	textbtn = (Button)findViewById(R.id.text);
        imgbtn = (Button)findViewById(R.id.img);
        videobtn = (Button)findViewById(R.id.video);
        textbtn.setOnClickListener(this);
        imgbtn.setOnClickListener(this);
        videobtn.setOnClickListener(this);
        notesDB = new NotesDB(this);   //ʵ�������ݿ�
        dbReader = notesDB.getReadableDatabase();   //��ÿ��Զ������ݿ�
        lv.setOnItemClickListener(new OnItemClickshort());  //����ListView����¼�
    }
    
    /**
     * ���ʱ�������¼�	
     */
	@Override
	public void onClick(View v) {
		intent = new Intent(this,AddContent.class);   //������һ��Activity
		switch (v.getId()) {
		case R.id.text:   //������ְ�ť
			intent.putExtra("flag", "1");  //����Activity����,1
			startActivity(intent);
			break;
		case R.id.img:   //���ͼ�İ�ť
			intent.putExtra("flag", "2");  //����Activity����,2
			startActivity(intent);
			break;
		case R.id.video:  //�����Ƶ��ť
			intent.putExtra("flag","3");  //����Activity����,3
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	//���ڲ�ѯ,���������onResume�б�����
	public void selectDB()
	{
		cursor = dbReader.query(NotesDB.TABLE_NAME, null, null, null, null, null, null);
		adapter = new MyAdapter(this, cursor);
		lv.setAdapter(adapter);   //��adapter��ListView
	}
	
	/**
	 * protected void onResume() �� Activity �� Pause ״̬ת���� Active
	 *  ״̬ʱ�����á�
      onResume��activity����û����㣬�����û�����
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		selectDB();
	}
	
	private class OnItemClickshort implements OnItemClickListener
	{
		/*
		 *  parent �൱��listview Y��������һ��ָ�룬����ͨ���������Y��װ�ŵ�һ�ж�����
		 *  ��ͨ�׵����˵�����㣬������Y������X - -
		 view �����b item��view�ľ������������������view�������b��Ŀؼ���id������ؼ�
		 position ��b��Y���������λ�ã�����listviewʱ��������һ��һ������item��Ȼ������ǰ�˳���źöӣ�
		 �ڷŵ�listview���˼�������b�ǵ�position�����õģ�
		 id ��b��listview Y��ĵڼ��е�λ�ã��������ǵ�2�У����󲿷�ʱ��position��id��ֵ��һ���ģ�
		 �����Ҫ�Ļ���������Լ��Ӹ�log��position��id��Ū������logcat���򣬿���֮�������̤ʵ��
		 * */
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			cursor.moveToPosition(position);   //�ƶ���ָ����λ��,cursor����װ���ݵ�
			Intent i = new Intent(MainActivity.this,SelectAct.class);  //��Ҫ������Activity
			
			//��Ϊ��Ҫɾ��,������Ҫ�õ���ListView��ID
			i.putExtra(NotesDB.ID, cursor.getInt(cursor.   //ID
					getColumnIndex(NotesDB.ID)));
			i.putExtra(NotesDB.CONTENT, cursor.getString(cursor.   //��������
					getColumnIndex(NotesDB.CONTENT)));
			i.putExtra(NotesDB.TIME,cursor.getString(cursor.       //ʱ��
					getColumnIndex(NotesDB.TIME)));
			i.putExtra(NotesDB.PATH, cursor.getString(cursor.      //ͼƬ
					getColumnIndex(NotesDB.PATH)));
			i.putExtra(NotesDB.VIDEO,
					cursor.getString(cursor.getColumnIndex(NotesDB.VIDEO)));
			startActivity(i);     //�û����֮����ת������ҳ
		}
	}
}

