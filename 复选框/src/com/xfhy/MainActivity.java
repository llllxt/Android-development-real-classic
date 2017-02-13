package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox CB1 = (CheckBox)findViewById(R.id.checkBox1);  //��ȡ����
        final CheckBox CB2 = (CheckBox)findViewById(R.id.checkBox2);
        final CheckBox CB3 = (CheckBox)findViewById(R.id.checkBox3);
        final CheckBox CB4 = (CheckBox)findViewById(R.id.checkBox4);
        //��ѡ��ťRadioGroup����ѡ��CheckBox����OnCheckedChangeListener�¼�
        CB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				/*
				 * ������������ڸ�ѡ��ġ���CheckBox��������CheckBox�Ƿ�ѡ�У�isChecked�����ַ���ֵ��
            1 ��CheckBox����ĸ�ѡ��ѡ��ʱ��isChecked()����true����1��
            2 ��CheckBox����ĸ�ѡ��û�б�ѡ��ʱ��isChecked()����false����0.
				 * */
				if(isChecked)  //�����ѡ��
				{
					Toast.makeText(getApplicationContext(), CB1.getText()+"��ѡ��",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB1.getText()+"��ȡ��", Toast.LENGTH_SHORT).show();
			}
		});
        CB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)  //�����ѡ��
				{
					Toast.makeText(getApplicationContext(), CB2.getText()+"��ѡ��",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB2.getText()+"��ȡ��", Toast.LENGTH_SHORT).show();
			}
		});
        CB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub�Զ�������ж�״̬
				if(isChecked)  //�����ѡ��
				{
					Toast.makeText(getApplicationContext(), CB3.getText()+"��ѡ��",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB3.getText()+"��ȡ��", Toast.LENGTH_SHORT).show();
			}
		});
        CB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() 
        {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)  //�����ѡ��
				{
					Toast.makeText(getApplicationContext(), CB4.getText()+"��ѡ��",Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), CB4.getText()+"��ȡ��", Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
