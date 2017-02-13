package com.xfhy.returnxx;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class FirstActivity extends Activity {

	private Button first = null;
	private Button second = null;
	private TextView text = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
        first = (Button)findViewById(R.id.first);
        second = (Button)findViewById(R.id.second);
        text = (TextView)findViewById(R.id.text);
        
        //ͨ�����first��ťʵ��ҳ��֮�����ת,
        /*
         * 1.startActivity�ķ�ʽ��ʵ��
         * 2.��ʼ��Intent
         * */
        first.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				/*
				 * ��һ������:�����Ķ���this
				 * �ڶ�������:Ŀ���ļ�
				 * */
				Intent t = new Intent(FirstActivity.this,SecondActivity.class);
				startActivity(t);
			}
        });
        
        /*
         * ͨ��startActivityForresult
         * */
        second.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent t = new Intent(FirstActivity.this,SecondActivity.class);
				/*
				 * ��һ��������Intent����
				 * �ڶ��������������һ����־
				 * */
				startActivityForResult(t, 1);
			}
        });
    }
    
    /*
     * ͨ��startActivityForresult��ת,���շ������ݵķ���
     * requestCode:����ı�ʶ
     * resultCode:�ڶ���ҳ�淵�صı�ʶ 
     * data:�ڶ���ҳ��ش�������
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode==1 && resultCode==2)   //��Second������������
    	{
    		String content = data.getStringExtra("data");
    		text.setText(content);
    	}
    }
}
