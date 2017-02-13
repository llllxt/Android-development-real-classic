package com.example.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

	private ImageView imageView=null;
	private ToggleButton toggleButton=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.image);
        toggleButton=(ToggleButton)findViewById(R.id.tbtn);
        
        toggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				//toggleButton.setChecked(isChecked);
				imageView.setImageResource(isChecked? R.drawable.windows:R.drawable.j2);
			}
        	
        });
    }

    
    //�˵�ѡ����ʾ����(�û���menu��ť��ʱ����ø÷���)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, 1, 1, R.string.menu1);   // �˵�id,����˵�id,����,��ť��ʾ������
    	menu.add(0, 2, 2, R.string.menu2);
    	menu.add(0, 3, 4, R.string.menu3);   //3��4��˳�����
    	menu.add(0, 4, 3, R.string.menu4);
    	menu.add(0, 5, 5, R.string.exit);
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //�˵�ѡ����֮��,ִ�е���Ӧ�Ĳ���
    //������˲˵��е�ĳһѡ��֮����ø÷���
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        /*if (id == R.id.action_settings) {
            return true;
        }
        if(id == 5)
        {
        	finish();
        	//System.exit(0);
        }*/
        switch(id)
        {
            case 1:
            	Toast.makeText(this, "��ӭ�����˵�1", Toast.LENGTH_LONG).show();
            	break;
            case 2:
            	Toast.makeText(this, "��ӭ�����˵�2", Toast.LENGTH_LONG).show();
            	break;
            case 3:
            	Toast.makeText(this, "��ӭ�����˵�4", Toast.LENGTH_LONG).show();
            	break;
            case 4:
            	Toast.makeText(this, "��ӭ�����˵�3", Toast.LENGTH_LONG).show();
            	break;
            case 5:
            	System.exit(0);
            	break;
        }
        return super.onOptionsItemSelected(item);
    }
}
