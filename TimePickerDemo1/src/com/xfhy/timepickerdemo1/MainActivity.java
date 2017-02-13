package com.xfhy.timepickerdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends Activity {

	private TimePicker mydp = null;
	private TextView tv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mydp = (TimePicker)findViewById(R.id.timer2);
        tv = (TextView)findViewById(R.id.text);
        mydp.setIs24HourView(true);    //���ڶ���ʱ��ѡ��������Ϊ24Сʱ��
        mydp.setCurrentHour(18);    //����Сʱ
        mydp.setCurrentMinute(30);   //���÷���
        
        
        
        String hour = mydp.getCurrentHour().toString();   //���Сʱ
        String minute  = mydp.getCurrentMinute().toString();  //��÷���
        tv.setText("ʱ���� "+hour+":"+minute);
    }
}
