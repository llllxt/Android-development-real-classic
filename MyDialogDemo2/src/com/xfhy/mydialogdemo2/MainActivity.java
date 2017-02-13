package com.xfhy.mydialogdemo2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends Activity {

	private ImageButton but = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        but = (ImageButton)findViewById(R.id.but);
        but.setOnClickListener(new OnClickListenerlmpl());
    }
    private class OnClickListenerlmpl implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			exitDialog();
		}
    }
    
    //������ֻ��ϵķ��ؼ�ʱ,��ʾ�˳��Ի���
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if(keyCode==KeyEvent.KEYCODE_BACK)
    	{
    		exitDialog();
    	}
    	return false;
    }
    
    //��ʾ�Ի���
    private void exitDialog()
    {
    	Dialog dialog = new AlertDialog.Builder(MainActivity.this)
    	.setIcon(R.drawable.exit)
    	.setTitle("�����˳�?")
    	.setMessage("��ȷ��Ҫ�˳���������?")
    	.setPositiveButton("ȷ��", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.finish();    //���ȷ��,�������
			}
    		
    	}).setNegativeButton("ȡ��",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
    	}).create();
    	dialog.show();    //��ʾ�Ի���
    }
}
