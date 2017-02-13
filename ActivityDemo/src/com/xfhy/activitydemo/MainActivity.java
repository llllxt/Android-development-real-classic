package com.xfhy.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	final String TAG = "tag";
	private Button to = null;
	//����
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = (Button)findViewById(R.id.to);
        to.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent t = new Intent(MainActivity.this,SecondActivity.class);
				MainActivity.this.startActivity(t);
			}
        });
        //�����־  �����־                           �������
        Log.i(TAG,"MainActivity --> onCreate");
    }
    
    //����
    @Override
    protected void onStart() {
    	super.onStart();
    	Log.i(TAG,"MainActivity --> onStart");
    }
    
    //��ȡ����
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.i(TAG,"MainActivity --> onResume");
    }
    
    //ʧȥ����
    @Override
    protected void onPause() {
    	super.onPause();
    	Log.i(TAG,"MainActivity --> onPause");
    }
    
    //��ͣ,���Ǳ��浱ǰ������״̬��Ϣ,
    @Override
    protected void onStop() {
    	super.onStop();
    	Log.i(TAG,"MainActivity --> onStop");
    }
    
    //���ٵ�ǰActivity
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.i(TAG,"MainActivity --> onDestroy");
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	Log.i(TAG,"MainActivity --> onRestart");
    }
}
