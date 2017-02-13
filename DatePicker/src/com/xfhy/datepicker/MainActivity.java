package com.xfhy.datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;


public class MainActivity extends Activity {

	private DatePicker mydp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mydp = (DatePicker)findViewById(R.id.dp2);
        
        /**
         * Update the current date.
			
			������
			year The year.
			month The month which is starting from zero.    �·ݴ�0��ʼ
			dayOfMonth The day of the month.    ����
         */
        mydp.updateDate(1995, 7, 28);   //1995.8.28
    }
}
