package com.example.progressdialogdemo1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * �������Ի���
 * @author XFHY
 *�����ݼ�����ɺ�,һ��Ҫ����dismiss()���رնԻ���,�����һֱ����
 */
public class MainActivity extends Activity {

	private Button btn1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
				progressDialog.setTitle("This is ProgressDialog");
				progressDialog.setMessage("��������...");
				progressDialog.setCancelable(true);  //�Ƿ��ܹ�ȡ���Ի���
				progressDialog.show();
			}
		});
    }
}
