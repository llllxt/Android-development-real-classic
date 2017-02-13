package com.xfhy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {
	int[] images = new int[]{
    		R.drawable.j1,
    		R.drawable.j2,
    		R.drawable.j3,
    		R.drawable.j4,
    };
    int current=0;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //��ȡLinearLayout�������� activity_main��id����root
        LinearLayout main = (LinearLayout)findViewById(R.id.root);
      //���򴴽�ImageView���
        final ImageView image = new ImageView(this);
        //��ImageView�����ӵ�����������
        main.addView(image);
        //��ʼ��ʱ��ʾ��һ��
        image.setImageResource(images[0]);
        image.setOnClickListener( new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(current>=4)   //�±곬��4,ѭ������һ��ͼƬ
				{
					current=-1;
				}
				image.setImageResource(images[++current]);
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
