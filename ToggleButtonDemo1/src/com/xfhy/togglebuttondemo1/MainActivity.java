package com.xfhy.togglebuttondemo1;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

//��ToggleButton��ť(2��״̬),ʵ�ֿ����ֵ�Ͳ
public class MainActivity extends Activity {

	private ToggleButton tb1 = null;
	@SuppressWarnings("deprecation")
	Camera m_Camera;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tb1 = (ToggleButton)findViewById(R.id.turn);
        //����ѡ���¼�
        tb1.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				
				/**
				 * buttonView:����ǰ����������
				 * isChecked:����ǰ������������״̬
				 */
				if(isChecked)   //���������
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
				else//�ر������
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
			}
			
        });
    }
}
