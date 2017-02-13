package com.example.scrollviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{

	private TextView tv = null;
	private ScrollView scroll = null;
	private Button up_btn = null;
	private Button down_btn = null;
	int height=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView)findViewById(R.id.tv);
        scroll = (ScrollView)findViewById(R.id.scroll);
        up_btn = (Button)findViewById(R.id.up_btn);
        down_btn = (Button)findViewById(R.id.down_btn);   //ͨ����ť����  ͨ���������ƹ���������λ��������
        up_btn.setOnClickListener(this);
        down_btn.setOnClickListener(this);       //���ü�����
        
        //��ȡ��Դ�ļ�,����ı���Դ,���id
        tv.setText(getResources().getString(R.string.content));
        scroll.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {    //��ö���
				case MotionEvent.ACTION_UP:
					
					break;
				case MotionEvent.ACTION_DOWN:
					
					break;
				case MotionEvent.ACTION_MOVE:   //���ƶ�ʱ 
					/*
					 * 1.getScrollY()  -----�����������ľ���
					 * 2.getMeasuredHeight()   --��ù������ĳ���
					 * 3.getHeight()           --������ݵĳ���	(һ��Ļ�ĸ߶�)
					 * */
					if(scroll.getScrollY()<=0)
					{
						Toast.makeText(MainActivity.this, "�Ѿ��Ƕ�����", 0).show();
					}
					
					//�ײ�״̬
					//TextView���ܸ߶�<=һ��Ļ�ĸ߶�+�������Ĺ�������
					else if(scroll.getChildAt(0).getMeasuredHeight() <= 
							scroll.getHeight()+scroll.getScrollY())
					{
						Toast.makeText(MainActivity.this, "�Ѿ��ǵײ���", 0).show();
						Log.i("tag",Integer.toString(scroll.getChildAt(0).getMeasuredHeight()));
						tv.append(MainActivity.this.getResources().getString(R.string.content));
					}
					break;

				default:
					break;
				}
				return false;
			}
        });
    }
    
	@Override
	public void onClick(View v) {
		/*
		 * 1.scrollTo   �ο���׼�ǹ�������ʼ��λ��
		 * 2.scrollBy   
		 * */
		switch (v.getId()) {
		case R.id.up_btn:
			//scroll.scrollTo(0, height-30);
			scroll.scrollBy(0,-30);
			//height = height-30;
			break;
		case R.id.down_btn:
			//scroll.scrollTo(0, height+30);
			scroll.scrollBy(0,30);
			//height = height+30;
			break;
		default:
			
			break;
		}
	}
}
