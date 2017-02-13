package com.xfhy.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/*
 * ������б����ж�����ʽ����ʹ��ListView������Ƕ��ж�����״��ʽ������ʹ��GridView
 * 
 * 1��׼������Դ

2���½�������

3��GridView����������

4.GridView�����¼�������(OnItemClickListener)

�����õ���������SimpleAdapter
 * */
public class MainActivity extends Activity implements OnItemClickListener{

	private GridView gridView = null;
	private List<Map<String,Object>>dataList;
	private int[] icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera
			,R.drawable.clock,R.drawable.games_control,R.drawable.messenger,
			R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,
			R.drawable.weather,R.drawable.world,R.drawable.youtube};
	private String[] iconName = {"ͨѶ¼","����","�����","ʱ��","��Ϸ","����","����","����",
			"����","����","�����","��Ƶ"};
	private SimpleAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gridView = (GridView)findViewById(R.id.gridView);
        dataList = new ArrayList<Map<String,Object>>();
        adapter = new SimpleAdapter(this, getData(),R.layout.item, new String[]{"image","text"}, 
        		new int[]{R.id.image,R.id.text});
        
        gridView.setAdapter(adapter);
        //gridView.setNumColumns(4);   ���ö�����
        
        gridView.setOnItemClickListener(this);   //���ؼ�����
    }
	private List<Map<String,Object>> getData() {
		for (int i = 0; i < icon.length; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("image",icon[i]);
			map.put("text",iconName[i]);
			dataList.add(map);
		}
		
		return dataList;
	}
	
	//��������¼�   position�ǵ����λ��
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(MainActivity.this, "����"+iconName[position], 
				0).show();
		if(position==0)
		{
			Intent t = new Intent(MainActivity.this,Phone.class);
			startActivity(t);
		}
	}
}
