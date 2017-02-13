package com.xfhy.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity {

	private ImageButton open2;
	Camera m_Camera;
	int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        open2 = (ImageButton)findViewById(R.id.open2);
        
        //���������
        open2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				if(count%2==0)   //���������
				{
					try{
					    m_Camera = Camera.open();
			            Camera.Parameters parameters = m_Camera.getParameters();           
			            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON); // ʹ�������
			            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH); // �������ģʽ����
			            m_Camera.setParameters(parameters);  
			        }
				 catch(Exception e)
			        {
			            e.printStackTrace();
			        }
				}
				else if(count%2!=0)//�ر������
				{
					try
					{   
						Camera.Parameters mParameters;  
						mParameters = m_Camera.getParameters();  
						mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);  
						m_Camera.setParameters(mParameters);  
						m_Camera.release();
					} 
					catch(Exception ex)
					{
						 ex.printStackTrace();
					} 
				}
				count++;
			}
        	
        });
        
        
        
    }
}
