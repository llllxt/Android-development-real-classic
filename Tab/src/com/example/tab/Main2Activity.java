package com.example.tab;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class Main2Activity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		Toast.makeText(this, "����,��ӭʹ��", Toast.LENGTH_LONG).show();
	}

	public boolean onKeyDown(int keyCode,KeyEvent event)
	{
		//�����������
		Log.d("onKeyDown:KeyCode",String.valueOf(keyCode));
		//����������ظ�����
		Log.d("onKeyDown:RepeatCount", String.valueOf(event.getRepeatCount()));
		//����ظ���������200,��ʾ��ʾ��Ϣ
		if( event.getRepeatCount()==200 )
		{
			Toast.makeText(this, "�Ѿ�����һ�����,���˰�,���ɿ���!", Toast.LENGTH_LONG).show();
		}
		//������²˵���ť�����ʾ��Ϣ
		if(keyCode == KeyEvent.KEYCODE_MENU)  //�������˼�ǰ��²˵���ť
		{
			Log.d("onKeyDown","MenuKey Down");
		}
		return super.onKeyDown(keyCode, event);
	}
	
	//�����������׽�����¼�
	/*@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		//���¶���
		if(event.getAction()==KeyEvent.ACTION_DOWN)
		{
			Toast.makeText(this, "����", Toast.LENGTH_SHORT).show();
		}
		//̧����
		if(event.getAction()==KeyEvent.ACTION_UP)
		{
			Toast.makeText(this,"̧��",Toast.LENGTH_SHORT).show();
		}
		return super.dispatchKeyEvent(event);
	}*/
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main2, menu);
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//����״̬
		if(event.getAction()==MotionEvent.ACTION_DOWN)
		{
			Log.d("onTouchEvent","onTouchEvent_Action:Down");
			//��������������
			Toast.makeText(this, "x="+event.getX()+" y="+event.getY(), Toast.LENGTH_SHORT).show();
		}
		if(event.getAction()==MotionEvent.ACTION_UP)
		{
			Log.d("onTouchEvent","onTouchEvent_ACTION:UP");
		}
		
		return super.onTouchEvent(event);
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
