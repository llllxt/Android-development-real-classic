package com.xfhy.spinnerdemo1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * �����б��
 * ����ֱ����main.xml�ļ��ж���<Spinner>�ڵ�,�����ڶ����Ԫ��ʱȴ����ֱ����������ʾ���б���
 * �����������б����2�����÷�ʽ
 * ��ʽ1:
 * ֱ��ͨ����Դ�ļ�����,���綨��һ��values\city_data.xml�ļ�,�ڶ�����������ʱ��Ҫʹ��<string-array>
 * Ԫ��ָ��.�����layout\main.xml�ļ��ж���<Spinner>�ڵ�ʱ,ֱ��ʹ��
 * android:entries="@array/city_labels"���Լ��ɶ�ȡ��Ϣ
 * 
 * ��ʽ2:
 * �ڳ����б���,����Ҫʹ��ArrayAdapter,��ȡ��Դ�ļ�����ָ���������õ�����,������2����Ҫ����,��ȡ��Դ�ļ�
 * �ж�����б��������ͨ��List���������б���
 * @author XFHY
 *
 */
public class MainActivity extends Activity {

	private Spinner spiColor = null;   //�����ʾ��ɫ���б��
	private Spinner spiEdu = null;     //�����ʾѧ�����б��
	private ArrayAdapter<CharSequence> adapterColor = null;  //�����б�����������
	private ArrayAdapter<CharSequence> adapterEdu = null;    //�����б�����������
	private List<CharSequence> dataEdu = null;   //���ϱ��������б�ѡ��
	private Spinner mycity = null;
	private TextView text = null;
	
	private String[][] areaData = new String[][]{  //���������˵���
			{"����","����","����","����","ƽ��"},       //��һ����ѡ��
			{"����","����","����"},                   //�ڶ�����ѡ��
			{"����"}                                //��������ѡ��
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mycity = (Spinner)findViewById(R.id.mycity);
        text = (TextView)findViewById(R.id.text);
        this.spiColor = (Spinner)super.findViewById(R.id.mycolor);
        this.spiColor.setPrompt("��ѡ����ϲ������ɫ");     //������ʾ����Ϣ
        this.adapterColor = ArrayAdapter.createFromResource(this,
        		R.array.color_lables, 
        		android.R.layout.simple_spinner_item);  //����Դ�ļ���ȡѡ��
        
        this.adapterColor.setDropDownViewResource(android.
        		R.layout.simple_spinner_dropdown_item);   //�����б���ʾ���
        
        this.spiColor.setAdapter(this.adapterColor);   //���������б�ѡ��
        this.dataEdu = new ArrayList<CharSequence>();  //ʵ����List����
        this.dataEdu.add("��ѧ");
        this.dataEdu.add("�о���");
        this.dataEdu.add("����");
        this.spiEdu = (Spinner)super.findViewById(R.id.myedu);
        this.spiEdu.setPrompt("��ѡ��ϲ����ѧ��");
        this.adapterEdu = new ArrayAdapter<CharSequence>(this,
        		android.R.layout.simple_spinner_item,this.dataEdu);  //���������б���
        this.adapterEdu.setDropDownViewResource(android.
        		R.layout.simple_spinner_dropdown_item);   //�����б���ʾ���
        this.spiEdu.setAdapter(adapterEdu);   //���������б�ѡ��
        
        mycity.setOnItemSelectedListener(new OnItemSelectedListenerlmpl());
    }
    
    private class OnItemSelectedListenerlmpl implements OnItemSelectedListener
    {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			//�õ���ǰѡ���ѡ��
			String str = parent.getItemAtPosition(position).toString();  
			text.setText("��ϲ���ĳ�����"+str);
		}
		@Override
		public void onNothingSelected(AdapterView<?> parent) {   //û��ѡ��ʱ����
			text.setText("��û��ϲ���ĳ�����?");
		}
    }
}
