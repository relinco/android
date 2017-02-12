package com.example.clock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class AlarmClock extends Activity {
	public Button confirm;            //确定按钮
	private Button cancel;            //取消按钮
	private TimePicker timePick;  
	Calendar calender;
	private int currentHour;         //TimePickerDialog显示的当前时间
	private int currentMinute;       //TimePickerDialog显示的当前时间
	private int flag = 1;           
	private int setHour;            //闹钟设定的时间
	private int setMinute;          //闹钟设定的时间
	private ListView clockList;
	private List<HashMap<String, Integer>> setTime;
	private ArrayList<PendingIntent> pendingIntents;
	private HashMap<String, Integer> map;
	private SimpleAdapter simpleAdapter;
	private AlarmManager alarm;
	private int i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_clock);
		confirm = (Button)findViewById(R.id.confirm);
		cancel = (Button)findViewById(R.id.cancel);
		timePick = (TimePicker)findViewById(R.id.time_pick);		
		confirm.setOnClickListener(new AlarmChoose());
		cancel.setOnClickListener(new AlarmChoose());
		calender = Calendar.getInstance();		
		calender.setTimeInMillis(System.currentTimeMillis());
		currentHour = calender.get(Calendar.HOUR_OF_DAY);
		currentMinute = calender.get(Calendar.MINUTE);
		clockList = (ListView)findViewById(R.id.clock_show_list);
		pendingIntents = new ArrayList<PendingIntent>();
		i = 0;
		addList();
		//给ListView中的每个Item绑定点击事件
		clockList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				AlarmManager removeAlarm = (AlarmManager)getSystemService(ALARM_SERVICE); 
				//移除闹钟
				removeAlarm.cancel(pendingIntents.get(position));
				//将对应的pendingIntent在数组中移除掉
				pendingIntents.remove(position);
				//移除显示
				setTime.remove(position);
				//数据更新
				simpleAdapter.notifyDataSetChanged();
			}
		});
		
		timePick.setOnTimeChangedListener(new OnTimeChangedListener() {		
			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				if( flag == 1 ) {
					//实例化TimePickerDialog对象弹出时间设置的对话框
					new TimePickerDialog(AlarmClock.this, new OnTimeSetListener() {
						//adapter数据源
						public void addClock( int hour, int minute ) {		
							map = new HashMap<String, Integer>();						
							setHour = Integer.valueOf(hour);
							setMinute = Integer.valueOf(minute);
							map.put("hour", setHour);
							map.put("minute", setMinute);
							setTime.add(map);
							simpleAdapter.notifyDataSetChanged();
						}
						//设定闹铃时间
						public void setClockTime( int hour, int minute ) {
							
							calender.setTimeInMillis(System.currentTimeMillis());     //获取当前时间并设置到日历里面 ,主要是让日历的年月日和当前同步              
							calender.set(Calendar.HOUR_OF_DAY,hour);
							calender.set(Calendar.MINUTE, minute);
							calender.set(Calendar.SECOND, 0);         //秒设为0
							calender.set(Calendar.MILLISECOND, 0);    //毫秒设为0
						}
						
						@Override
						public void onTimeSet(TimePicker arg0, int hourOfDay, int minute) {
							i++;
							setClockTime( hourOfDay, minute );			
							addClock( hourOfDay, minute );									
							Intent intent = new Intent(); 
							intent.putExtra("hour", setHour);
							intent.putExtra("minute", setMinute);
							intent.setClass(AlarmClock.this, BroadcastClock.class);
							alarm = (AlarmManager)getSystemService(ALARM_SERVICE);	
							//创建pendingIntent对象							
							PendingIntent pendingintent = PendingIntent.getBroadcast(AlarmClock.this, i-1, intent, PendingIntent.FLAG_ONE_SHOT);
							pendingIntents.add(pendingintent);
							//判断当设定的时间小于当前时间时天数加1
							if( calender.getTimeInMillis() < System.currentTimeMillis() ){
								calender.set(Calendar.DAY_OF_YEAR, calender.get(Calendar.DAY_OF_YEAR ) + 1 );
							}
							//设置时钟
							alarm.set(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(), pendingIntents.get( pendingIntents.size() -1 )); 
							flag = 1;
						}
						
						
					}, currentHour, currentMinute, true){
						@Override
						public void onStop() {
						    //super.onStop();
						    Log.d("twice", "onStop of starttime TimePickerDialog.");
						}
					}.show();
					flag = 0;
				}
				
			}
			
		});
	}
	public void addList() {
		//数据项数组
		setTime = new ArrayList<HashMap<String, Integer>>();
		//adapter
		simpleAdapter = new SimpleAdapter(AlarmClock.this, setTime, R.layout.clock_show_list_item, new String[]{"hour" ,"minute"}, new int[]{R.id.hour, R.id.minute});
		clockList.setAdapter(simpleAdapter);
		
	}
	
	public class AlarmChoose implements OnClickListener {
		public void onClick(View v) {
			if( v==confirm ) {
				finish();
			}else if ( v==cancel ) {
				finish();
			}else {
				return;
			}						
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm_clock, menu);
		return true;
	}

}
