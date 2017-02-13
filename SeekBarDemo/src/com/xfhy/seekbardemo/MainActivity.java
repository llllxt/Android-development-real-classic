package com.xfhy.seekbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/*
 * ��SeekBar�������϶��Ľ�����
 * 
 * �����϶������Ա��û�����,������Ҫ��������¼�����,�����Ҫʵ��
 * SeekBar.OnSeekBarChangeListener�ӿ�,�˽ӿڹ���Ҫ���������¼�
 * ��ֵ�ı�(onProgressChanged)
 * ��ʼ�϶�(onStartTrackingTouch)
 * ֹͣ�϶�(onStopTrackingTouch)
 * 
 * */
public class MainActivity extends Activity implements OnSeekBarChangeListener{

	private SeekBar seekBar = null;
	private TextView tv1 = null;
	private TextView tv2 = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        
        seekBar.setOnSeekBarChangeListener(this);
    }
    
    //��ֵ�ı�
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		tv1.setText("��ֵ�ı���,����  \n"+"����:"+progress+"\n�û��϶�:"+fromUser);
	}
	
	//��ʼ�϶�ʱ����
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		tv2.setText("��ʼ�϶�");
	}
	
	//ֹͣ�϶�ʱ����
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		tv2.setText("ֹͣ�϶�");
	}
}
