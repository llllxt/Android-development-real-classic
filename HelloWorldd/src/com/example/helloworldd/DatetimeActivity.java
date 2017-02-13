package com.example.helloworldd;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class DatetimeActivity extends ActionBarActivity implements OnClickListener{

	//ͨ�õ���ʾ�Ի���ķ���
	private void showDialog(String title,String msg)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//���öԻ����ͼ��
		builder.setIcon(android.R.drawable.ic_dialog_info);
		//���öԻ���ı���
		builder.setTitle(title);
		//���öԻ�����ʾ����Ϣ
		builder.setMessage(msg);
		//���öԻ���İ�ť
		builder.setPositiveButton("ȷ��", null);
		//��ʾ�Ի���
		builder.create().show();
		Intent intent;
	}
	
	//����¼�,2����ť���õ�һ�������¼�����,ͨ����ť��id���ֵ������ĸ���ť
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())   //��øÿؼ���id
			{
			    case R.id.btnShowDate:
			    {
			    	//����������ʾ��ʽ
			    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    	//��ʾ��ǰ����   ���õ�ǰ�����ʾ�Ի���ķ���,�����ݲ���
			    	showDialog("��ǰ����",sdf.format(new Date()));
			    	break;
			    }
			    case R.id.btnShowTime:
			    {
			    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			    	//��ʾ��ǰʱ��   ���õ�ǰ�����ʾ�Ի���ķ���
			    	showDialog("��ǰʱ��",sdf.format(new Date()));
			    	break;
			    }
			}
		}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //װ��View
        setContentView(R.layout.activity_datetime);
        //��ȡ�ؼ�
        Button btnShowDate = (Button)findViewById(R.id.btnShowDate);
        Button btnShowTime = (Button)findViewById(R.id.btnShowTime);
        //���ÿؼ��ļ���   ��ǰ������Ѿ�ʵ����OnClickListener,so�õ���this
        btnShowDate.setOnClickListener(this);
        btnShowTime.setOnClickListener(this);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.datetime, menu);
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
