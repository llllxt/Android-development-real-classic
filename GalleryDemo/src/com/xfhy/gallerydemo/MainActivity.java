package com.xfhy.gallerydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;

/*
 * 1.�ٷ��ĵ���Gallery�Ѿ����Ƽ�ʹ���ˣ�������HorizontalScroll ��ViewPager����ʵ��
 * 2.ImageSwitcher��ImageView�Ĺ����е�����,���Ƕ�����������ʾͼƬ,��������ImageSwitcher��Ч��
 * ����,������ָ��ͼƬ�л�ʱ�Ķ���Ч��.Ҫ��ImageSwitcher��ʾͼƬ����Ҫʵ��ViewFactory�ӿ�
 * 
 * 
 * Gallery�����Ҫ���ں�����ʾͼ���б�����������������Gallery���ֻ�����޵���ʾָ����ͼ��
 * */
public class MainActivity extends Activity implements OnItemSelectedListener,ViewFactory{

	//׼������Դ
	private int[] res = {R.drawable.a_1,R.drawable.a_2,R.drawable.a_3,R.drawable.a_4,
			R.drawable.a_5,R.drawable.a_6,R.drawable.a_7,
			R.drawable.a_8,R.drawable.a_9,R.drawable.a_10};
	private Gallery gallery;
	private ImageAdapter adapter;
	private ImageSwitcher is = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gallery = (Gallery)findViewById(R.id.gallery);
        is = (ImageSwitcher)findViewById(R.id.is);
        
        
        
        adapter = new ImageAdapter(res,this);
        //����������
        gallery.setAdapter(adapter);
        
        
        gallery.setOnItemSelectedListener(this);
        is.setFactory(this);   //���ع���
        
        //����Ч��
        is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        
        //����Ч��
        is.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    }

    //һ�������,���������Ҫ����ImageView
	@Override
	public View makeView() {
		ImageView image = new ImageView(this);    //��ʼ��ͼƬ,�����ò���(��������Ϣ)
		image.setScaleType(ScaleType.FIT_CENTER);   //����������ͼƬ,���Ҿ�����ʾ
		return image;
	}

	////��ѵ�ǰѡ���ͼƬ���ݽ���,���ᴫ��ͼƬ��λ��
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		is.setBackgroundResource(res[position%res.length]);   //������ʾ,��Դ
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
	}
}
