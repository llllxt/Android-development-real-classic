package com.xfhy.returnxx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {

	private Button back = null;
	private String content = "���";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		/*
		 * �ڶ���ҳ��ͨ����ť����һҳ��ش�����
		 * �ش�����һ��ҳ��ʱ��ʵ�ǽ����ݷŵ�Intent����
		 * */
		back = (Button)findViewById(R.id.back);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("data", content);   //��װ������
				
				/*
				 * ����1:�����(��ʾ�ĸ�ҳ��)
				 * ����2:����
				 * */
				setResult(2,data);
				
				finish();   //���ٵ�ǰҳ��    ����Է��ص�һ��ҳ��
			}
		});
	}
}
