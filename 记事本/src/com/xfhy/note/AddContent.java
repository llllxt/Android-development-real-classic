package com.xfhy.note;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

/**
 * �������
 * @author XFHY
 *
 */
public class AddContent extends ActionBarActivity implements OnClickListener{

	String val;    //���ڽ���MainActivity����
	private Button savebtn,deletebtn;
	private EditText ettext;
	private ImageView c_img;
	private VideoView v_video;
	private NotesDB notesDB;
	private SQLiteDatabase dbWriter;
	private File phoneFile,videoFile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_content);
		
		//��ʼ��
		val = getIntent().getStringExtra("flag");
		savebtn = (Button)findViewById(R.id.save);
		deletebtn = (Button)findViewById(R.id.delete);
		ettext = (EditText)findViewById(R.id.ettext);
		c_img = (ImageView)findViewById(R.id.c_img);
		v_video = (VideoView)findViewById(R.id.v_video);
		
		//�󶨵�����
		savebtn.setOnClickListener(this);  
		deletebtn.setOnClickListener(this);
		
		//��ÿɶ�д���ݿ�
		notesDB = new NotesDB(this);
		dbWriter = notesDB.getWritableDatabase();  //��ȡһ��д�����ݵ�Ȩ��
		initView();
	}
	
	//��ʼ��
	public void initView()
	{
		          /*---------MainActivity(��)���ݹ���������,�����ж�--------*/
		//val��MainActivity(��)���ݹ���������
		if(val.equals("1"))  //���� 
		{
			c_img.setVisibility(View.GONE);   //����ͼƬ����Ƶ�ؼ����ɼ�
			v_video.setVisibility(View.GONE);
		}
		else if(val.equals("2")) //ͼƬ
		{
			c_img.setVisibility(View.VISIBLE); //����ͼƬ�ɼ�
			v_video.setVisibility(View.GONE);  //��Ƶ���ɼ�
			
			    /*------����ϵͳ�������-----*/
			Intent iimg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			phoneFile = new File(Environment.getExternalStorageDirectory().
					getAbsoluteFile()+"/"+getTime()+".jpg");
			iimg.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(phoneFile));
			startActivityForResult(iimg,1);    //������ֵʱ��Ҫ�������
		}
		else if(val.equals("3"))  //��Ƶ
		{
			c_img.setVisibility(View.GONE);      //����ͼƬ���ɼ�
			v_video.setVisibility(View.VISIBLE); //������Ƶ�ɼ�
			
			/*------����ϵͳ�������-----*/
			Intent video = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
			videoFile = new File(Environment.getExternalStorageDirectory().
					getAbsoluteFile()+"/"+getTime()+".mp4");
			video.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(videoFile));
			startActivityForResult(video,2);    //������ֵʱ��Ҫ�������
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1)   //������ݵ���һ��ͼƬ
		{
			//��ȡ·��,չʾ����,����·��
			Bitmap bitmap = BitmapFactory.decodeFile(phoneFile.
					getAbsolutePath());
			c_img.setImageBitmap(bitmap);
			
		}
		else if(requestCode==2)
		{
			v_video.setVideoURI(Uri.fromFile(videoFile));  //��ȡ��Ƶ
			v_video.start();  //����
		}
	}
	
	//�û�����������ȡ��
	@Override
	public void onClick(View v) {
		//����û�����˱��水ť,�򱣴��û��������Ϣ
		if(v.getId()==R.id.save)
		{
			addDB();     //����ı����еĶ���
			finish();   //�رյ�ǰActivity
		}
		else if(v.getId()==R.id.delete)   //�û����ȡ��
		{
			finish();   //�رյ�ǰActivity
		}
	}
	
	//������ݽ����ݿ�
	public void addDB()
	{
		ContentValues values = new ContentValues();   //���ʱ��Ҫ�õ���ContentValues
		values.put(NotesDB.CONTENT,ettext.getText().toString()); //�����������
		values.put(NotesDB.TIME, getTime());     //���ʱ��
		values.put(NotesDB.PATH, phoneFile+"");  //���ͼƬ
		values.put(NotesDB.VIDEO, videoFile+""); //�����Ƶ
		dbWriter.insert(NotesDB.TABLE_NAME, null, values); //��ContentValues�����ݿ�
	}
	
	//��õ�ǰϵͳʱ��
	public String getTime()
	{
		Date da = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(da);
		return time;
	}
}
