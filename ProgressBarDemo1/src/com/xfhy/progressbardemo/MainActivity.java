package com.xfhy.progressbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

/*
 * ProgressBar:������
 * 
 * ProgressBar�ķ���:
 * 1.���Ծ�ȷ��ʾ����(������ʾ�̶Ȼ��߰ٷֱ�)
 * 2.�����Ծ�ȷ��ʾ����(һֱת��ת,������һ����������)
 * 
 * android:max="100"                  --�����ʾ����
 * android:progress="50"              --��һ��ʾ����
 * android:secondaryProgress="80"     --�ڶ���ʾ����
 * android:indeterminate="true"       --�����Ƿ�ȷ��ʾ
 * true�ǲ���ȷ��ʾ,false��ʾ����ȷ��ʾ����
 * 
 * */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //������������,���ô����ȺͲ������ȵĽ�����
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        
        setContentView(R.layout.activity_main);
        
        //��ʾ���ֽ�����
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(true);
        
        setProgress(1200);   //���ô����ȵĽ������̶�
    }
}
