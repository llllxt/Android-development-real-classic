package com.xfhy.mylistviewdemo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * ��ListView��ʾ����,�õ���SimpleAdapter.
 * ���������ȶ�����һ��data����,���ж�������Ҫ��ʵ������,Ҫ����ȷ��ͨ��ListView��ʾ���е�����,��
 * ��Ҫ�����ݷ�װ��SimpleAdapter����,��SimpleAdapter����Զ�����List�����б����������
 * �涨��ģ��data_list�������ݵ��б�.
 * @author XFHY
 *
 */
public class MyListViewDemo2 extends ActionBarActivity {

	//��Ҫ��ʾ�����ݷ�װ���ַ���������
	private String data[][] = {{"01","Ь�ӣ�����Ь"},
			{"02","��ɫ�и���"},
			{"03","���ߵİ��"},
			{"04","˹�����˵���ս����"},
			{"05","���׷���װ�������׻򷴼�"},
			{"06","��������װ�����������"}};
	
	//�������е�List����
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	private ListView datalist;                     //����ListView���
	private SimpleAdapter simpleAdapter = null;    //������
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view_demo2);
        
        //ȡ��ListView���
        this.datalist = (ListView)findViewById(R.id.datalist);
        
        //ѭ����������
        for (int x = 0; x < this.data.length; x++) {
			Map<String,String> map = new HashMap<String,String>();  //����Map����
			map.put("_id",data[x][0]);   //����_id�����ʾ���
			map.put("name", data[x][1]); //����name�����ʾ����
			this.list.add(map);          //��������
		}
        
        this.simpleAdapter = new SimpleAdapter(this,   //ʵ����SimpleAdapter
        		this.list,                             //Ҫ��װ�����ݼ���
        		R.layout.data_list,                    //Ҫʹ�õ���ʾģ��
        		new String[]{"_id","name"},            //����Ҫ��ʾ��Map��key
        		new int[]{R.id._id,R.id.name});        //��ģ���е����ƥ��
        this.datalist.setAdapter(this.simpleAdapter);  //������ʾ����
    }
}
