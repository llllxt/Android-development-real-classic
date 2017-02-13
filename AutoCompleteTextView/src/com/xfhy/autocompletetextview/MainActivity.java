package com.xfhy.autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;


public class MainActivity extends Activity {

	private AutoCompleteTextView atv1 = null;
	private String[] resourse = {
			"beijing1","beijing2","beijing3","beijing4",
			"shanghai1","shanghai2","shanghai3","shanghai4"
	};
	private MultiAutoCompleteTextView matv1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*
         * AutoCompleteTextView
         * ��һ��:��ʼ���ؼ�
         * �ڶ���:��Ҫһ��������
         * ������:��ʼ������Դ,ȥƥ���ı��������������
         * ���Ĳ�:��adapter�뵱ǰAutoCompleteTextView��
         * */
        atv1  = (AutoCompleteTextView)findViewById(R.id.atv1);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,    //ϵͳ�Ĳ���
        		resourse);
        atv1.setAdapter(adapter);
        
        
        /*
         * MultiAutoCompleteTextView
         * ��һ��:��ʼ���ؼ�
         * �ڶ���:��Ҫһ��������
         * ������:��ʼ������Դ,ȥƥ���ı��������������
         * ���Ĳ�:��adapter�뵱ǰAutoCompleteTextView��
         * ���岽:���÷ָ���,
         * */
        matv1 = (MultiAutoCompleteTextView)findViewById(R.id.matv1);
        matv1.setAdapter(adapter);
        
        //�����Զ���Ϊ�ָ���Ϊ�����ķ���
        matv1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());  
    }
}
