package com.example.clock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{
	
	private TextView time;          //时钟
	private TextView alarmClock;    //闹钟
	private TextView stopwatch;     //秒表
	private TextView calculator;    //计算器
	private Button addClock;       //添加闹钟按钮
	public Calendar mCalendar;     
	private ViewPager pager;         //页卡内容
	private List<View> listViews;     //tab页面列表
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件获取
        time = (TextView)findViewById(R.id.time);
        alarmClock = (TextView)findViewById(R.id.alarm_clock);
        stopwatch = (TextView)findViewById(R.id.stopwatch);
        calculator = (TextView)findViewById(R.id.calculator);     
        //事件绑定
        time.setOnClickListener(new MyOnClickListener(0));
        alarmClock.setOnClickListener(new MyOnClickListener(1));
        stopwatch.setOnClickListener(new MyOnClickListener(2));
        calculator.setOnClickListener(new MyOnClickListener(3));
        //默认选中
        time.setTextColor(0xffffffff);
        initViewPage();
    }
	
    public class MyOnClickListener implements OnClickListener{
     	private int index = 0;    
     	 /**
     	  * 设定页卡项跟导航中的item项对应
     	  * @param i 
     	  */
    	 public MyOnClickListener(int i) {
    		 this.index = i;
    	 }
    	 
    	 @Override
    	 public void onClick(View v) {
    		 //点击导航item项跳转到对应的页卡
    		 pager.setCurrentItem(index);   		 
    			if (v == addClock) {
    				//跳转到添加闹钟页
    				Intent addClockIntent = new Intent(MainActivity.this, AlarmClock.class);
    		        startActivity(addClockIntent);		        
    			} else if (v == time) {
    				time.setTextColor(0xffffffff);
    				stopwatch.setTextColor(0xffff8c00);
    				calculator.setTextColor(0xffff8c00);
    				alarmClock.setTextColor(0xffff8c00);
    			} else if (v == alarmClock) {
    				alarmClock.setTextColor(0xffffffff);
    				time.setTextColor(0xffff8c00);
    				stopwatch.setTextColor(0xffff8c00);
    				calculator.setTextColor(0xffff8c00);
    			} else if (v == stopwatch) {
    				stopwatch.setTextColor(0xffffffff);
    				alarmClock.setTextColor(0xffff8c00);
    				time.setTextColor(0xffff8c00);  				
    				calculator.setTextColor(0xffff8c00);
    			} else if (v == calculator) {
    				calculator.setTextColor(0xffffffff);
    				stopwatch.setTextColor(0xffff8c00);
    				alarmClock.setTextColor(0xffff8c00);
    				time.setTextColor(0xffff8c00);    				    				
    			}
    	 }
    }    
    
    private void initViewPage() {
    	pager = (ViewPager) findViewById(R.id.viewpager);   
    	listViews = new ArrayList<View>();
    	//实例化LayoutInflater对象
    	LayoutInflater mInflater = getLayoutInflater();    
    	//获取view对象并添加到List<View>中(数据)
    	listViews.add(mInflater.inflate(R.layout.show_clock, null));
    	listViews.add(mInflater.inflate(R.layout.activity_alarm_clock, null));
    	listViews.add(mInflater.inflate(R.layout.activity_calculator, null));
    	listViews.add(mInflater.inflate(R.layout.activity_stop_clock, null));
    	
    	MyPagerAdapter pagerAdapter = new MyPagerAdapter(listViews);  
    	pager.setAdapter(pagerAdapter);
    	pager.setCurrentItem(0);
    	pager.setOnPageChangeListener(myPageChangeListener);
    	
    }
    
    public OnPageChangeListener myPageChangeListener = new OnPageChangeListener() {     
        public void onPageScrollStateChanged(int arg0) {      	  
              String.format(ACCOUNT_SERVICE, arg0);
        }  

        public void onPageScrolled(int arg0, float arg1, int arg2) {                
              
        }  

        public void onPageSelected(int position) {  
            Log.v("currentIndex", String.valueOf(position));
            switch (position) {
            case 0:
        		time.setTextColor(0xffffffff);
				stopwatch.setTextColor(0xffff8c00);
				calculator.setTextColor(0xffff8c00);
				alarmClock.setTextColor(0xffff8c00);
				break;
            case 1:
            	alarmClock.setTextColor(0xffffffff);
				time.setTextColor(0xffff8c00);
				stopwatch.setTextColor(0xffff8c00);
				calculator.setTextColor(0xffff8c00);
				addClock = (Button)findViewById(R.id.add_clock);
				addClock.setOnClickListener(new MyOnClickListener(1));
				break;
            case 2:
            	stopwatch.setTextColor(0xffffffff);
				alarmClock.setTextColor(0xffff8c00);
				time.setTextColor(0xffff8c00);  				
				calculator.setTextColor(0xffff8c00);
				break;
            case 3:
            	calculator.setTextColor(0xffffffff);
				stopwatch.setTextColor(0xffff8c00);
				alarmClock.setTextColor(0xffff8c00);
				time.setTextColor(0xffff8c00);
				break;
			default:
				break;
            }
            	
        }
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

