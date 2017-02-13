package com.xfhy;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��layout�����ListView
        ListView list = (ListView)findViewById(R.id.ListView01);
        //���ɶ�̬����,��������
        ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>>();
        for(int i=0; i<10; i++)
        {
        	HashMap<String,Object> map = new HashMap<String,Object>();  //����hash�� map
        	map.put("ItemImage", R.drawable.windows);  //ͼƬ,��drawable�еõ�,�ŵ�hash����
        	map.put("ItemTitle","Level"+(i+1));   //�б����
        	//map.put("ItemText", "Finished in Min 54Secs,70 Moves!");
        	map.put("ItemText", "��"+(i+1)+"����Ŀ");  //�б��ı�
        	listItem.add(map);  //����ǰ�����hash��map��ӵ�listItem�е���һ��Ԫ��
        }
        //������������Item�Ͷ�̬�����Ӧ��Ԫ��
        SimpleAdapter myAdapter = new SimpleAdapter(this,listItem,  //����Դ
        		R.layout.activity_main,     //ListItem��XMLʵ��
        		//��̬������ImageItem��Ӧ������
        		new String[]{"ItemImage","ItemTitle","ItemText"},
        		//ImageItem��XML�ļ������һ��ImageView,����TextView ID
        		new int[]{R.id.ItemImage,R.id.ItemText,R.id.ItemTitle}
        		);
        //��Ӳ�����ʾ
        list.setAdapter(myAdapter);
        //��ӵ��   �����͵��
        list.setOnItemClickListener(new OnItemClickListener()
        {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				setTitle("�����"+(arg2+1)+"����Ŀ");
			}
        	
        });
        
        //��ӳ������
        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener()
        {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				// TODO Auto-generated method stub
				menu.setHeaderTitle("�����˵�-ContextMenu"); //����֮��,�����ı���
				menu.add(0,0,0,"���������˵�0");   //�������������ѡ��
				menu.add(0,1,0,"���������˵�1");
				menu.add(0,2,0,"���������˵�2");
				menu.add(0,3,0,"���������˵�3");
			}
        	
        });
        
        
        
    }
    
    //�����˵���Ӧ����
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
    	setTitle("����˳����˵�����ĵ�"+item.getItemId()+"����Ŀ");
		return super.onContextItemSelected(item);
    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
