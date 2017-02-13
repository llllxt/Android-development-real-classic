package com.xfhy.datetimepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

/*
 * ʱ��ѡ����,����ѡ����
 * 1.����Ļ�ķ�ʽ��ʾѡ����
 * 2.�ԶԻ������ʽ��ʾ
 * */
public class MainActivity extends Activity {

	private DatePicker datePicker = null;
	private TimePicker timePicker = null;
	private Button time = null;
	private Button date = null;
	private Calendar cal;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        time = (Button) findViewById(R.id.time);
        date = (Button) findViewById(R.id.date);
        
        //��ȡ������һ������
        cal = Calendar.getInstance();
        
        //�õ����������е���
        year = cal.get(Calendar.YEAR);  
        month = cal.get(Calendar.MONTH)+1;    //month�Ǵ�0��ʼ��,
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour  = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        
        //����Ӧ�õı���
        setTitle(year+"-"+month+"-"+day+" "+hour+":"+minute);
        
        //��ʼ��datePicker,�����ü�����,�����ı�ʱ����
        datePicker.init(year, month, day,new OnDateChangedListener(){
			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				//����Ӧ�õı���
		        setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			}
        });
        
        //����ʱ��
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				setTitle(hourOfDay+":"+minute);
			}
        });
        
        
        date.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
				//����ѡ����,�Ի�����ʽ
		        new DatePickerDialog(MainActivity.this, new OnDateSetListener(){
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						//����Ӧ�õı���
				        setTitle(year+"-"+monthOfYear+"-"+dayOfMonth);
					}
		        }, year, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
			}
        });
        
        time.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
				new TimePickerDialog(MainActivity.this, new OnTimeSetListener(){
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
							int minute) {
						//����Ӧ�õı���
				        setTitle(hourOfDay+":"+minute);
					}
				}, day, minute, true).show();
				//���һ�������Ƿ����Ƿ���24Сʱ��
			}
        });
        
    }
}