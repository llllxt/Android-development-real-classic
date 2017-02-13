package com.xfhy.mylistviewdemo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	//��ʾͼƬ
	private int[] pic = new int[]{R.drawable.sansuxie,R.drawable.heiqie,
			R.drawable.landun,R.drawable.riyan,
			R.drawable.nvyao,R.drawable.bingshuang};  
	//������ʾ������
	private String data[][] = new String[][]{{"����Ь","ħ�ֿƼ�"},
			{"��ɫ�и���","���˻�"},{"����֮��","���˻�"},{"����","MLDN"},
			{"Ů����ɴ","���˻�"},{"��˪֮��","����"}};
	private int[] price = new int[]{800,3500,3000,2700,2900,3100};
	//�������е�List����
	private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	private ListView datalist;    //����ListView���
	private SimpleAdapter simpleAdapter = null;
	private TextView info = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        info = (TextView)findViewById(R.id.info);
        this.datalist = (ListView)super.findViewById(R.id.datalist); //���ListView�ؼ�
        for (int x = 0; x < this.data.length; x++) {
        	//����Map����,�������ӽ�List��,simpleAdapter��ҪList
			Map<String,String> map = new HashMap<String,String>(); 
			map.put("pic", String.valueOf(this.pic[x]));  //���ͼƬ��ID(תΪString)
			map.put("goods", this.data[x][0]);            //�����Ʒ
			map.put("author", data[x][1]);                //�������
			map.put("price", String.valueOf(price[x]));    //����շ�����
			map.put("score", String.valueOf(R.drawable.wuxing));  //��������
			this.list.add(map);    //����map��List(�������)
		}
        
        this.simpleAdapter = new SimpleAdapter(this,   //ʵ����SimpleAdapter
        		this.list,                             //Ҫ��װ�����ݼ���
        		R.layout.data_list,                    //Ҫʹ�õ���ʾģ��
        		new String[]{"pic","goods","author","price","score"}, //������ʾkey
        		new int[]{R.id.pic,R.id.goods,R.id.author,R.id.price,R.id.score}); //��ģ���е����ƥ��
        this.datalist.setOnItemClickListener(new OnItemClickListenerlmpl());  //����¼�
        this.datalist.setOnItemLongClickListener(new OnItemClickListenerlong());
        this.datalist.setAdapter(this.simpleAdapter);  //������ʾ����
        
      
    }
    
    //ʵ�ֵ��
    private class OnItemClickListenerlmpl implements OnItemClickListener
    {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Map<String,String> map = (Map<String,String>)MainActivity.
					this.simpleAdapter.getItem(position);
			String title = map.get("goods");
			String author = map.get("author");
			MainActivity.this.info.setText(title+" "+author);
			
		}
    	
    }
    
    private class  OnItemClickListenerlong implements OnItemLongClickListener
    {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			/*Map<String,String> map = (Map<String,String>)MainActivity.
					this.simpleAdapter.getItem(position);
			String title = map.get("goods");
			String price = map.get("price");
			String author = map.get("author");
			MainActivity.this.info.setText(title+" "+price+" "+author);*/
			
			//Ū���Ի�������
			Dialog diglog = new AlertDialog.Builder(MainActivity.this).setTitle("�����賤���Ҹ�ɶ?").
					setMessage("����+40%").setIcon(R.drawable.emoji).create();	
			diglog.show();
			
			return false;
		}
    	
    }
}
