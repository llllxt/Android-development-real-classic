package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	private TextView tv;
	private RadioGroup rg;
	private RadioButton rb1;
	private RadioButton rb2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        tv = (TextView)findViewById(R.id.txetview);  //�ҵ��ؼ�
        rg = (RadioGroup)findViewById(R.id.group);
        rb1 = (RadioButton)findViewById(R.id.button1);
        rb2 = (RadioButton)findViewById(R.id.button2);
        
        //��ѡ��ť������¼�
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				//���ѡ�еĿؼ�idΪ��ѡѡ��ĵ�һ���ؼ�
				if(checkedId==R.id.button1)
				{
					tv.setText("Android����");
					rb1.setText("����1");
					String msg = rb1.getText().toString(); //��ȡ��ť1���ı�ֵ
					rb2.setText(msg);
				}
				else
				{
					tv.setText("Android����");
					rb1.setText("����1");
					rb2.setText("����2");
				}
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
