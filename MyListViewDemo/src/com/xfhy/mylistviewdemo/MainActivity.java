package com.xfhy.mylistviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

	//��Ҫ��ʾ�����ݷ�װ���ַ���������
	private String data[] = {"ι�����������㻹��û�����ѣ�","��ô���ء�Ц��","��~��������ô���ѵ�ǰ������˭�أ������ۡ�","�š�����ǰ���������հ׵ģ��������������ȣ�",
			"�������Ǻ����²۵㰡�������հ׵���˭��","����ü��[��ֻ��ʶ�����հ׵ĺ��𡣡���",
			"������Ƴ���ƹ����������ô�����ˣ�","Ҫ��ܣ���","���Ȱ�"};
    private ListView listView;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.listView = new ListView(this);  //��ʼ��ListView
        
        /*
         * ��ArrayAdapter�ཫ���е����ݽ��з�װ
         * ����ÿ������ֻռһ��(simple_expandable_list_item_1)
        */
        this.listView.setAdapter(new ArrayAdapter<String>(
        		this,android.R.layout.simple_expandable_list_item_1,this.data));
        
        //��ListView���뵽�ֻ����������ʾ
        setContentView(this.listView);
    }
}
