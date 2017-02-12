package com.example.clock;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ClockView extends View {

	public ClockView(Context context) {
		super(context);
		start();
	}

	public ClockView(Context context, AttributeSet attrs) {
		super(context, attrs);
		start();
	}

	public ClockView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		start();
	}
	
	public void start() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
			@Override
			public void run() {
				postInvalidate();
			}
		}, 0, 1000);
	}
	
	public void onDraw( Canvas canvas) {
		super.onDraw(canvas);
		draw(canvas);
	}
	
	public void draw(Canvas canvas) {
		//����Բ������
		final int x = 230;
		final int y = 250;		
		//��������Բ�İ뾶
		final int outRadius = 150;
		final int inRadius = 75;
		int initHour;
		int initMinute;
		int initSecond;
		float initHourDegree;
		float initMinuteDegree;
		float initSecondDegree;
		
		//��ʼ��ʱ����
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		initHour = calendar.get(Calendar.HOUR_OF_DAY);
		initMinute = calendar.get(Calendar.MINUTE);
		initSecond = calendar.get(Calendar.SECOND);
		
		//��ʼ��ʱ������ĽǶ�,��ʼ��λ�þ�Ϊ0��
		initHourDegree = ((initHour+(float)initMinute/60)/12)*360; 
	    initMinuteDegree = ((initMinute+(float)initSecond/60)/60)*360; 
	    initSecondDegree = ((float)initSecond/60)*360; 
		
    	Paint paint = new Paint();	//��ʼ������
    	paint.setAntiAlias(true);   //���ʿ����
    	paint.setAlpha(220);        //���û���ͼ�ε�͸����

    	//canvas.clipRect(10, 10, 350, 350);  //������ʾ����
    	
    	paint.setColor(Color.WHITE);   //���û�����ɫ 	
    	canvas.drawCircle(x, y, outRadius, paint);   //����һ��Բ����ࣩ
    	
    	paint.setColor(Color.GRAY);
    	canvas.drawCircle(x, y, inRadius, paint);    //����һ��Բ���ڲࣩ
    	
    	//��������
    	paint.setColor(Color.GRAY);
    	paint.setTextSize(24);
    	canvas.drawText("9", x - inRadius - 15, y + 5 , paint);
    	canvas.drawText("3", x + inRadius + 5, y + 5, paint);
    	canvas.drawText("12", x - 11, y - inRadius -5, paint);
    	canvas.drawText("6", x - 10 , y + inRadius + 20, paint);

    	//����ʱ��
    	paint.setColor(Color.BLACK);
    	paint.setStrokeWidth(4);
    	canvas.save();
    	canvas.rotate(initHourDegree, x, y);
    	canvas.drawLine( x, y, x, y - inRadius, paint);
    	canvas.restore();
    	
    	//���Ʒ���
    	paint.setColor(Color.BLACK);
    	paint.setStrokeWidth(4);
    	canvas.save();
    	canvas.rotate(initMinuteDegree, x, y);
    	canvas.drawLine( x, y, x, y - inRadius - 35, paint);
    	canvas.restore();
    	
    	//��������
    	paint.setColor(Color.RED);
    	paint.setStrokeWidth(4);
    	canvas.save();
    	canvas.rotate(initSecondDegree, x, y);
    	canvas.drawLine( x, y + 15, x, y - inRadius - 65, paint);
    	canvas.restore();
    }

}
