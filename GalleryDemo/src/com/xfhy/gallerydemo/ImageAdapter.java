package com.xfhy.gallerydemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter{

	private int res[];
	private Context context;   //��������Ϣ
	
	//shift+alt+s   ���ٹ���Դ����   ���ɹ��캯��,get������
	public ImageAdapter(int[] res,Context context) {
		this.res = res;
		this.context = context;
	}

	//�����Ѷ��������Դ��������
	@Override
	public int getCount() {
		//return res.length;
		//���������е������,�����ʵ��Gallery��ѭ��
		return Integer.MAX_VALUE;
	}

	//ȡ���������е����ݶ���
	@Override
	public Object getItem(int position) {
		return res[position];
	}

	//ȡ���������е�����ID
	@Override
	public long getItemId(int position) {
		return position;
	}

	//ȡ��Ŀǰ����ʾ��ͼ��View,��������IDֵʹ֮��ȡ�����
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView image = new ImageView(context);      //��ʼ��ImageView
		
		//image.setBackgroundResource(res[position]);
		
		//������Ӧ�������Ǿ��,����%����֮�;ͻ���Galleryѭ��
		image.setBackgroundResource(res[position%res.length]);    //���ñ�����Դ
		Log.i("xfhy",position+"");
		
		//��������ͼ
		image.setLayoutParams(new Gallery.LayoutParams(300,300));   //���ÿ����Ϣ��
		
		//����xy����
		image.setScaleType(ScaleType.FIT_XY);   //����imageView������ģʽ
		return image;
	}

}
