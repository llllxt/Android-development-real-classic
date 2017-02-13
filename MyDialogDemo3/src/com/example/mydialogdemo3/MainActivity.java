package com.example.mydialogdemo3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * ͨ���Ի�����ʾһ�鵥ѡ��ť,��������û�ѡ���ѡ��,���ı�������ʾ����
 * @author XFHY
 *
 */
public class MainActivity extends Activity {

	private Button mybut = null;
	private TextView mych = null;
	private String fruitData[] = new String[]{"ƻ��","����","ˮ����"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mych = (TextView)findViewById(R.id.mych);
        mybut = (Button)findViewById(R.id.mybut);
        mybut.setOnClickListener(new OnClickListenerlmpl());  //���õ����¼�
    }
    
    //ʵ�ּ���
    private class OnClickListenerlmpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			Dialog dialog = new AlertDialog.Builder(MainActivity.this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("��ѡ����ϲ���Ե�ˮ��?")
			.setNegativeButton("ȡ��", 
					new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
						}
				
			})
			//�ڰ�ť��������һ�������¼�,�ὫĬ�ϵ�ѡ����(fruitData,�ַ������鶨��)
			//ֱ���ڶԻ����н�����ʾ
			.setItems(fruitData, new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					//��������
					MainActivity.this.mych.setText("��ѡ���ˮ����:"+fruitData[which]);
				}
				
			}).create();
			dialog.show();   //��ʾ�Ի���
		}
    }
}
/*
 * �˳��򿪷���,����ֱ����Activity�н�������ص���ʾ���ݶ���,����ʵ�ʵĿ�����,�������Ҫ����Ϣ����ʾ
 * �ʹ�����з���,����Ҳ����MVC���ģʽ��Ҫ��.
 * 
 * ���ϳ�����ֱ�ӽ����е�Ҫ��ʾ��������Ϣͨ�������������ʽ��Activity�н����˶���,������ֱ����һ��
 * ��Դ�ļ��ж���.
 * 
 * 
 * */
