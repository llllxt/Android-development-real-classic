package com.xfhy.qqlogin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 1.����SharedPreferences����,��ʼ��(getSharedPreferences("config",MODE_PRIVATE);)
 *��һ�������Ǳ������ݵ��ļ���,�ڶ�����ֻ���Լ��ĳ���ſ��Է���
 *2.Editor editor = sp.edit();ͨ��SharedPreferences�ļ���edit()��������һ��Editor����
 *��ͨ����Editor����putString()����
 * @author XFHY
 *
 */

public class MainActivity extends Activity {

	private EditText qq=null;
	private EditText password=null;
	private CheckBox cb_jizhu=null;
	private Button bt_ok=null;
	private Button bt_region=null;
	
	/**
	 * androidϵͳ���������ݴ洢��һ�������api
	 */
	private SharedPreferences sp;  
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //��ʼ��,�����洢���ݵ�,config���ļ���,MODE_PRIVATE��ʾ�����ֻ���Լ���Ӧ�ó���ſ��Է����������
        sp = getSharedPreferences("config",MODE_PRIVATE);
        
        qq = (EditText)findViewById(R.id.qq);
        password = (EditText)findViewById(R.id.password);
        cb_jizhu = (CheckBox)findViewById(R.id.cb_jizhu);
        
        //��ȡsp����洢������
        String saveqq = sp.getString("qqnumber","0");
        String savepass = sp.getString("password1", "0");
        if(!saveqq.equals("0"))
        {
        	qq.setText(saveqq);
            password.setText(savepass);
        }
        
        bt_ok = (Button)findViewById(R.id.bt_ok);
        bt_region = (Button)findViewById(R.id.bt_region);
        
        bt_ok.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String qqnumber = qq.getText().toString();
				String password1 = password.getText().toString();
				if(TextUtils.isEmpty(qqnumber) || TextUtils.isEmpty(password1))
				{
					Toast.makeText(MainActivity.this, "QQ�����������Ϊ��", 0).show();
				}
				else
				{
					//����û��Ƿ�ѡ�˼�ס����ѡ��,��ѡ������û����������¼����
					if(cb_jizhu.isChecked())
					{
						//��ȡ��һ�������ļ��ı༭��
						Editor editor = sp.edit();
						
						//��SharedPreferences�ļ��д洢����
						editor.putString("qqnumber", qqnumber);
						editor.putString("password1", password1);
						editor.commit();  //�����ݱ��浽sp����
						Toast.makeText(getApplicationContext(), "�û���Ϣ�Ѿ�����", 0).show();
					}
				}
			}
        });
    }
}
