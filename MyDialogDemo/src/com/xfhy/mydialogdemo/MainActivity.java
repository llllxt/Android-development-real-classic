package com.xfhy.mydialogdemo;

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
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button mybut = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mybut = (Button)findViewById(R.id.mybut);
        mybut.setOnClickListener(new OnClickListenerimpl());
    }
    private class OnClickListenerimpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			Dialog dialog = new AlertDialog.Builder(MainActivity.this)
			.setIcon(R.drawable.ic_launcher)  //���öԻ���ͼ��
			.setTitle("ȷ��ɾ��?")              //����
			.setMessage("��ȷ��ɾ��������Ϣ��?")   //����
			.setPositiveButton("ɾ��",          //����һ��ȷ����ť
					new DialogInterface.OnClickListener(){  //�����¼�

						@Override
						public void onClick(DialogInterface dialog, int which) {
							//��������¼�
							Toast.makeText(MainActivity.this, "ɾ��",0).show();
						}
				
			}).setNeutralButton("�鿴����",    //������ͨ��ť
					new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, "�鿴����",0).show();
						}
				
			}).setNegativeButton("ȡ��",    //������ͨ��ť
					new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(MainActivity.this, "ȡ��",0).show();
				}
			}).create();       //����Dialog
			dialog.show();     //��ʾ�Ի���
		}
    }
}
