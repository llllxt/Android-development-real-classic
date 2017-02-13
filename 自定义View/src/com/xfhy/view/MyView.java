package com.xfhy.view;
/*
 * ������ƽʱ��ͼһ������Ҫ�������ߣ�ֽ�ͱʡ�Paint�����൱�ڱʣ���Canvas����ֽ������л�����

���ԣ����и�ҪҪ���Ķ�����������صģ������С����ϸ��������ɫ��͸���ȣ��������ʽ�ȵȣ�
������Paint�����ã�
ͬ��������Ҫ������Ʒ�Ķ���������Բ�Σ����Σ����ֵ���صĶ�����Canvas�����ɡ�
 * 
 * */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

//�Զ����һ����,�̳���View
/*
 * �½�һ����ͼ�࣬������View��ΪʲôҪ�½���ͼ���أ���Ϊ����Ҫ���ɵ���ʾ��������ȻҪ��д��ͼ���ˣ�
 * ��OnDraw���������з���ʲô��
 * �����ͼ�ͻ᳤ʲô����������˵���½�һ��������View����MyView��Ȼ����дOnDraw()������
 * */
public class MyView extends View {

	private Context m_context;
	//���캯��
	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		m_context = context;
	}
    
	//ʵ��View
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//���廭��
		Paint paint = new Paint();  
		paint.setAntiAlias(true);   //�����Ƿ񿹾��
		paint.setColor(Color.RED);  //���û�����ɫ
		
		/*
		 *  Style.FILL   :����ڲ�
		 *  Style.FILL_AND_STROKE :����ڲ������
		 *  Style.STROKE          :�����
		 * */
		paint.setStyle(Style.STROKE); //���������ʽ
		paint.setStrokeWidth(10);   //���û��ʿ��
		
		//������radius:��Ӱ����б��,dx:ˮƽλ��,dy:��ֱλ��,��ɫ
		paint.setShadowLayer(10, 15, 15, Color.BLUE);   //���û�����Ӱ
		
		//���û���������ɫ
		canvas.drawRGB(255,255,255);
		
		//�ڻ����ϻ�Բ,���������涨���Ǹ�
		/*
		 * Բ��
			void drawCircle (float cx, float cy, float radius, Paint paint)
			
			������
			float cx��Բ�ĵ�X������ 
			float cy��Բ�ĵ�Y������
			float radius��Բ�İ뾶
		 * */
		canvas.drawCircle(190, 200, 150, paint);
		
		//�ڻ����ϻ�һ����,�����(100,400),�յ�(600,800)
		canvas.drawLine(100, 400, 600, 800, paint);
		
		//��������,(10,10)->(100,100) (200,200)->(400,400)��������һ����
		float[] pts = {10,10,100,100,200,200,400,400};
		canvas.drawLines(pts, paint);
		
		//��һ����,��(500,500)��
		canvas.drawPoint(500, 500, paint);
		
		//����������������
		float[] pts2 = {15,15,105,105,205,205,405,405};
		canvas.drawPoints(pts2, paint);
		
		//void drawRect (float left, float top, float right, float bottom, Paint paint)
		//��һ������
		//left�����ε����λ��(��x,y)��top�����ε��ϱ�λ�á�right�����ε��ұ�λ�á�bottom�����ε��±�λ�á�
		canvas.drawRect(200, 200, 400, 400, paint);
		
		//��RectF����һ������
		//RectF rect1 = new RectF(200,400, 400, 600);
		//canvas.drawRect(rect1, paint);
		
		//��Rect����һ������
		//Rect rect2 = new Rect(200,600,400,800);
		//canvas.drawRect(rect2, paint);
		
		/*
		 * 7��Բ�Ǿ���
			void drawRoundRect (RectF rect, float rx, float ry, Paint paint)
			������
			RectF rect:Ҫ���ľ���
			float rx:����Բ�ǵ���Բ��X��뾶
			float ry:����Բ�ǵ���Բ��Y��뾶
		 * */
		//RectF rect3 = new RectF(200,600,400,800);
		//canvas.drawRoundRect(rect3,30,30,paint);
		
		/*
		 * ��Բ

			��Բ�Ǹ��ݾ������ɵģ��Ծ��εĳ�Ϊ��Բ��X�ᣬ���εĿ�Ϊ��Բ��Y�ᣬ��������Բͼ��
			
			void drawOval (RectF oval, Paint paint)
			
			������
			RectF oval������������Բ�ľ���
		 * */
		RectF rect4 = new RectF(200,600,300,800);   //��,��,��,��
		//canvas.drawOval(rect4, paint);
		
		
		/*
		 * ��
		������Բ��һ���֣�����Բ�Ǹ��ݾ��������ɵģ����Ի���ȻҲ�Ǹ��ݾ��������ɵģ�	
		void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)	
		������
		RectF oval:������Բ�ľ���
		float startAngle������ʼ�ĽǶȣ���X��������Ϊ0��
		float sweepAngle���������ĽǶ�
		boolean useCenter:�Ƿ��л������ߣ�True�������ߣ�False��ֻ��һ����
		 * */
		canvas.drawArc(rect4,0,90,false, paint);
	}  

}
