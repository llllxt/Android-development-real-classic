package com.xfhy.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Phone extends Activity implements OnItemClickListener,
OnItemLongClickListener{

	private SimpleAdapter ph_adapter = null;
	private ListView listView = null;
	private String selectData[]={"������","��绰"};
	
	//����Դ
	private String[] names = {"����","����","����","��������","��������","��ɳ����","�ɶ�����",
			"�������","��������","��ݸ����"};
	private String[] ph_phone = {"10086","13425467854","13548564125",
			"010-66426705","0431-85580020","0731-84302954","028-61816547",
			"023-60363126","0411-39853315","0769-23667819"};
	private List<Map<String,Object>>dataList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone);
		
		listView = (ListView) findViewById(R.id.listView);
		dataList = new ArrayList<Map<String,Object>>();   //��ʼ������Դ
		
		//��ʼ��Adapter
		ph_adapter = new SimpleAdapter(this, getData(), R.layout.item_phone,
				new String[]{"name","hphone"}, new int[]{R.id.name,R.id.hphone});
		listView.setAdapter(ph_adapter);    //����ListView��Adapter
		
		listView.setOnItemClickListener(this);     //ListView����¼�
		listView.setOnItemLongClickListener(this);  //ListView�����¼�
	}

	//Ϊ����Դ�������
	private List<Map<String,Object>> getData() {
		for (int i = 0; i < names.length; i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("name", names[i]);
			map.put("hphone", ph_phone[i]);
			dataList.add(map);
		}
		return dataList;
	}

	//ֱ�ӵ��,��ֱ�Ӳ���绰
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String phonet = ph_phone[position];   //����û��������ϵ�˵ĺ���
		Log.i("tag",phonet);   //��¼��Ҫ����ĵ绰
		
		//��intent��������绰  
        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phonet));
        startActivity(intent);
	}

	//����ListView��ѡ��ʱ ���¼�
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		final String phonet = ph_phone[position];   //����û��������ϵ�˵ĺ���
		
		//����ListView��ʾ�Ի���,�Ի�������2��ѡ��,�����źʹ�绰
		Dialog dialog = new AlertDialog.Builder(Phone.this).
				setIcon(R.drawable.tou)
				.setTitle("��ѡ�����")
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				})
				.setItems(selectData, new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if(which==0)
						{
							            /*----------����ϵͳ�����Ź��ܷ��Ͷ���---------*/
							 /*Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phonet));            
				            intent.putExtra("sms_body", "����");            
				            startActivity(intent); */
				            
							           /*----------ֱ���Լ����Ͷ��Ÿ�ĳ��,��ϵͳ�����¼---------*/
				          //��ȡ���Ź�����   
				            android.telephony.SmsManager smsManager = android.telephony.
				            		SmsManager.getDefault();  
				            //��ֶ������ݣ��ֻ����ų������ƣ�    
				            List<String> divideContents = smsManager.divideMessage("hf");   
				            for (String text : divideContents) {    
				                smsManager.sendTextMessage(phonet, null, text, null, null);    
				            }  
						}
						else if(which==1)
						{
							//��intent��������绰  
					        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phonet));
					        startActivity(intent);
						}
					}
				}).create();
		dialog.show();
				
		return false;
	}

}
