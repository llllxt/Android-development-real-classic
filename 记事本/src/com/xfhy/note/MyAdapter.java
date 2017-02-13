package com.xfhy.note;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Android��Adapter����ʵ���ǰ�����Դ�󶨵�ָ����View�ϣ�Ȼ���ٷ��ظ�View��������
�������View����ListView�е�ĳһ��item�����ﷵ������View���������ǵ�Adapter�е�getVi
ew�������صġ������ͻ������������������һ��һ����ʾ��ListView�еġ�
 * @author XFHY
 *
 */
public class MyAdapter extends BaseAdapter{

	private Context context;    //�н��������õĶ���,�ڹ��캯���б���ʼ��
	
	/*
	 * Cursor ��ÿ�еļ��ϡ�
		ʹ�� moveToFirst() ��λ��һ�С�
		�����֪��ÿһ�е����ơ�
		�����֪��ÿһ�е��������͡�
		Cursor ��һ�����������Դ��
		���е����ݶ���ͨ���±�ȡ�á�
	 * */
	
	private Cursor cursor;      //�������ݿ��
	LinearLayout layout;        //���Բ���
	
	public MyAdapter(Context context,Cursor cursor)
	{
		this.context = context;
		this.cursor = cursor;
	}
	
	@Override
	public int getCount() {
		//���س���
		return cursor.getCount();
	}

	//�õ�λ��
	@Override
	public Object getItem(int position) {
		return cursor.getPosition();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	//�൱�ڷ���һ���е�����
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		/*
		 * ��ʵ�ʿ�����LayoutInflater����໹�Ƿǳ����õģ���������������findViewById()��
		 * ��ͬ����LayoutInflater��������res/layout/�µ�xml�����ļ�������ʵ������
		 * ��findViewById()����xml�����ļ��µľ���widget�ؼ�(��Button��TextView��)��
			�������ã�
			1������һ��û�б����������Ҫ��̬����Ľ��棬����Ҫʹ��LayoutInflater.inflate()�����룻
			2������һ���Ѿ�����Ľ��棬�Ϳ���ʹ��Activiyt.findViewById()������������еĽ���Ԫ�ء�
		 * */
		LayoutInflater inflater = LayoutInflater.from(context);
		//LinearLayout���͵�,���������ó�LinearLayout
		layout = (LinearLayout) inflater.inflate(R.layout.cell, null); 
		
		//����
		TextView contenttv = (TextView)layout.findViewById(R.id.list_content);
		//ʱ��
		TextView timetv = (TextView)layout.findViewById(R.id.list_time);
		
		//ͼƬ
		ImageView imgiv = (ImageView)layout.findViewById(R.id.list_img);
		//��Ƶ
		ImageView videoiv = (ImageView)layout.findViewById(R.id.list_video);
		
		//cursor�����������ݿ��
		cursor.moveToPosition(position);  //�α��ƶ���ָ��λ��  �������ListView����
		
		//���ջ�ȡ������
		String content = cursor.getString(cursor.getColumnIndex("content"));  
		String time = cursor.getString(cursor.getColumnIndex("time"));
		String url = cursor.getString(cursor.getColumnIndex("path"));
		String urlvideo = cursor.getString(cursor.getColumnIndex("video"));
		
		contenttv.setText(content);   //���������õ�LinearLayout������
		timetv.setText(time);         //��ʱ�����õ�LinearLayout������
		videoiv.setImageBitmap(getVideoThumbnail(urlvideo,200,200,
				MediaStore.Images.Thumbnails.MICRO_KIND));   //�����Ƶ����ͼ
		imgiv.setImageBitmap(getImageThumbnail(url,200,200)); //������ͼ�ŵ�������
		return layout;                //���ز���
	}
	
	//�õ�����ͼ                                                    ��ַ,���,�߶�
	public Bitmap getImageThumbnail(String uri,int width,int height)
	{
		Bitmap bitmap = null;   //��ʼ��
		
		//ͨ�����������,ֱ�ӻ�ȡ����ͼ
		BitmapFactory.Options options = new BitmapFactory.Options();
		
		//��ָ��inJustDecodeBoundsʱ��ֻ����ͼƬ�ĳ��ȺͿ�ȣ�������ͼƬ
		options.inJustDecodeBounds = true;   
		bitmap = BitmapFactory.decodeFile(uri,options);    //��ȡ����ͼƬ
		options.inJustDecodeBounds = false;
		
		//��ȡ��ǰ�ĸ߶ȺͿ��,���Ի������ͼ֮��ĸ߶ȺͿ��
		int beWidth = options.outWidth/width;   //����ͼ֮��ĸ߶ȺͿ��
		int beHeight = options.outHeight/height;
		int be=1;
		if(beWidth<beHeight)   //����ͼƬ�ܳ�����
		{
			be = beWidth;
		}
		else
		{
			be = beHeight;
		}
		
		//ͼƬ̫С��
		if(be<=0)
		{
			be=1;
		}
		
		//��ָ��inSampleSize��ʱ�򣬻����inSampleSize����һ������ͼ��
		//����inSampleSize=4�����������ͼ��ԭͼ��С��1/4��
		options.inSampleSize = be;
		
		//���»�ȡͼƬ,���ʱ���������֮���ͼƬ��
		bitmap = BitmapFactory.decodeFile(uri,options); 
		bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
				ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		return bitmap;
	}
	
	private Bitmap getVideoThumbnail(String uri,int width,int height,int kind)
	{
		Bitmap bitmap = null;
		bitmap = ThumbnailUtils.createVideoThumbnail(uri, kind);  //��ȡ����ͼ
		bitmap = ThumbnailUtils.extractThumbnail(
				bitmap, width, height,ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
		
		return bitmap;
	}
}
