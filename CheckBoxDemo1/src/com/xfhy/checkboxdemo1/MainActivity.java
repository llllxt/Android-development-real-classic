package com.xfhy.checkboxdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * CheckBox�̳���CompoundButton,CompoundButton�̳���Button
 * ����CheckBox������������setOnCheckedChangeListener
 * @author XFHY
 *
 */
public class MainActivity extends Activity{

	private CheckBox basket = null;
	private CheckBox foot = null;
	private CheckBox ping = null;
	private TextView text = null;
	String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        basket = (CheckBox)findViewById(R.id.basket);
        foot = (CheckBox)findViewById(R.id.foot);
        ping = (CheckBox)findViewById(R.id.ping);
        text = (TextView)findViewById(R.id.text);
        
        basket.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked)
				{
					if(!str.contains("����"))
					{
						str = text.getText().toString();
						str = str+"����";
						Log.i("mag",str);   //���
						text.setText(str);
					}
					text.setVisibility(View.VISIBLE);
				}
				else
				{
					if(str.contains("����"))
					{
						/**
						 * substring(int beginIndex, int endIndex) 
                                                            ����һ�����ַ��������Ǵ��ַ�����һ�����ַ�����
                                                            ���ص��ַ��������������Ǹ��ַ�(endIndex)
						 */
						int i = str.indexOf("����");
						str = str.substring(0,i);
						text.setText(str);
					}
				}
			}
        });
        foot.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked)
				{
					if(!str.contains("����"))
					{
						str = text.getText().toString();
						str = str+"����";
						text.setText(str);
					}
					text.setVisibility(View.VISIBLE);
				}
				else
				{
					if(str.contains("����"))
					{
						/**
						 * substring(int beginIndex, int endIndex) 
                                                            ����һ�����ַ��������Ǵ��ַ�����һ�����ַ�����
                                                            ���ص��ַ��������������Ǹ��ַ�(endIndex)
						 */
						int i = str.indexOf("����");
						str = str.substring(0,i);
						text.setText(str);
					}
				}
			}
        });
        ping.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked)
				{
					if(!str.contains("ƹ����"))
					{
						str = text.getText().toString();
						str = str+"ƹ����";
						text.setText(str);
					}
					text.setVisibility(View.VISIBLE);
				}
				else
				{
					if(str.contains("ƹ����"))
					{
						/**
						 * substring(int beginIndex, int endIndex) 
                                                            ����һ�����ַ��������Ǵ��ַ�����һ�����ַ�����
                                                            ���ص��ַ��������������Ǹ��ַ�(endIndex)
						 */
						int i = str.indexOf("ƹ����");
						str = str.substring(0,i);
						text.setText(str);
					}
				}
			}
        });
        //
    }
}
