package com.xfhy.wenben;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private Button save=null;
	private Button read=null;
	private EditText edit = null;
	private static final String FILENAME="mymldn.txt";
	private static final String DIR = "mldndata";
	private String info = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button)findViewById(R.id.save);
        read = (Button)findViewById(R.id.read);
        edit = (EditText)findViewById(R.id.edit);
        
        save.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				info = edit.getText().toString();
				
				//��� sdcard����
		        //Environment.getExternalStorageState():ȡ����չ�洢�豸��״̬
		        //Environment.MEDIA_MOUNTED:�ɶ�д   ��������ȡ��״̬�ǿɶ�д��
		        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		        {
		        	//Environment.getExternalStorageDirectory():ȡ����չ�Ĵ洢Ŀ¼
		        	//File.separator:�ļ��ָ���,��ϵͳ�йص�Ĭ�����Ʒָ��������ֶα���ʼ��Ϊ����ϵͳ���� file.separator ֵ�ĵ�һ���ַ����� UNIX ϵͳ�ϣ����ֶε�ֵΪ '/'���� Microsoft Windows ϵͳ�ϣ���Ϊ '\\'�� 
		        	//����File����
		        	File file = new File(Environment.getExternalStorageDirectory().toString()+
		        			File.separator+DIR+File.separator+FILENAME);
		        	if(!file.getParentFile().exists())  //��������ļ��в�����
		        	{
		        		file.getParentFile().mkdirs();  //�����ļ���
		        	}
		        	PrintStream out = null;           //��ӡ������,�������
		        	try
		        	{
		        		//out = new PrintStream(new FileOutputStream(file,true));  //�ں���׷������
		        		out = new PrintStream(new FileOutputStream(file));  //ֱ�����ļ����������
		        		
		        		//out.println("�����Ǻ������˾");
		        		//edit.setText(file.toString());
		        		out.println(info);
		        		Toast.makeText(MainActivity.this, "����ɹ�!", Toast.LENGTH_LONG).show();
		        	}
		        	catch (Exception e)
		        	{
		        		edit.setText(e.toString());
		        	}
		        	finally
		        	{
		        		if(out!=null)   //����ӡ������ǿ�ʱ�ſ��Բ���,�������Ҫ�ر��ļ���
		        		{
		        			out.close();
		        		}
		        	}
		        }
		        else
		        {
		        	edit.setText("����ʧ��,SD��������!");
		        }
			}
        	
        });
        
        read.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
				{
					File file = new File(Environment.getExternalStorageDirectory().toString()+
							File.separator+DIR+File.separator+FILENAME);
					if(!file.getParentFile().exists())
					{
						file.getParentFile().mkdirs();
					}
					Scanner scan = null;   //ɨ������
					info = "";
					try
					{
						scan = new Scanner(new FileInputStream(file));  //ʵ����Scanner
						while(scan.hasNext())
						{
							info = info+scan.next()+"\n";
						}
						edit.setText(info);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(scan!=null)
						{
							scan.close();   //�رմ�ӡ��
						}
					}
				}
				else
				{
					Toast.makeText(MainActivity.this, "��ȡʧ��,SD��������!", Toast.LENGTH_LONG).show();
				}
			}
        	
        });
    }
}
