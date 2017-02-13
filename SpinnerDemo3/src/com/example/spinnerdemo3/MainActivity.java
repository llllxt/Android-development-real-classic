package com.example.spinnerdemo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/*
 * �����б�Spinner
 * 
 * 1.׼������Դ
 * 2.��������������
 * 3.Ϊ���������������б�����ʱ�Ĳ˵���ʽ
 * 4.�����������������б���
 * 5.Ϊ�����б����ø����¼�����Ӧ,����¼���Ӧ�˵���ѡ��
 * 
 * ������:OnItemSelectedListener
 * 
 * 
 * Spinnerʵ�������б�
 1.��������Դ List<String>����List<Map<String,Object>>
 2.�½������� ArrayAdapter<String>����SimpleAdapter
 3.adapter����һ�������б���ʽ adapter.setDropDownViewResource(resourse);
 4.spinner���������� spinner.setAdapter(adapter);
 5.Ϊspinner�趨������ spinner.setOnItemSelectedListener
 (new spinner.OnItemSelectedListener(){@Override @Override });
 * */
public class MainActivity extends Activity implements OnItemSelectedListener {

	private Spinner spin = null;
	private List<String> dataList;
	private ArrayAdapter adapter;
	private TextView text = null;

	private SimpleAdapter simAdapter;
	private List<Map<String, Object>> dataList2;
	private int imageid = R.drawable.ic_launcher ;
	private String[] citys = { "����", "�Ϻ�", "����", "����" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spin = (Spinner) findViewById(R.id.spin);
		text = (TextView) findViewById(R.id.text);

		/*----------��һ�ַ�ʽ,ArrayAdapter-------*/
		/*
		 * dataList = new ArrayList<String>(); adapter = new
		 * ArrayAdapter<String>(this, //��������Ϣ
		 * android.R.layout.simple_list_item_1, //����android�Դ�����ʽ getData());
		 * //�õ�����Դ
		 * 
		 * //Ϊ���������������б�����ʱ�Ĳ˵���ʽ
		 * adapter.setDropDownViewResource(android.R.layout.
		 * simple_spinner_dropdown_item);
		 * 
		 * spin.setAdapter(adapter); //��������Դ
		 * 
		 * //���ü����� spin.setOnItemSelectedListener(this);
		 */

		/*----------�ڶ��ַ�ʽ,SimpleAdapter-------*/
		// ��ʼ��SimpleAdapter
		dataList2 = new ArrayList<Map<String, Object>>();
		simAdapter = new SimpleAdapter(this, getSimData(), // ��������
				R.layout.item, // ��ʾ��ͼ
				new String[] { "image", "city" }, // ����
				new int[] { R.id.image, R.id.city }); // id
		
		simAdapter.setDropDownViewResource(R.layout.item);
		spin.setAdapter(simAdapter); // ��������Դ

		// ���ü�����
		spin.setOnItemSelectedListener(this);
	}

	private List<Map<String, Object>> getSimData() {
		for (int i = 0; i < citys.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", imageid);
			map.put("city", citys[i]);
			dataList2.add(map);
		}
		return dataList2;
	}

	// ׼������Դ
	private List<String> getData() {
		dataList.add("����");
		dataList.add("�Ϻ�");
		dataList.add("����");
		dataList.add("����");
		return dataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
			text.setText("����ȥ�ĳ�����" + simAdapter.getItem(position)); // �����ı�
		
		
		/*
		 * switch (position) { case 0: text.setText("����ȥ�ĳ����Ǳ���"); break; case 1:
		 * text.setText("����ȥ�ĳ������Ϻ�"); break; case 2: text.setText("����ȥ�ĳ����ǹ���");
		 * break; case 3: text.setText("����ȥ�ĳ���������"); break;
		 * 
		 * default: break; }
		 */
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

}
