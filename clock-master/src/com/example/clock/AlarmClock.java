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
	public Button confirm;            //ȷ����ť
	private Button cancel;            //ȡ����ť
	private TimePicker timePick;  
	Calendar calender;
	private int currentHour;         //TimePickerDialog��ʾ�ĵ�ǰʱ��
	private int currentMinute;       //TimePickerDialog��ʾ�ĵ�ǰʱ��
	private int flag = 1;           
	private int setHour;            //�����趨��ʱ��
	private int setMinute;          //�����趨��ʱ��
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
		//��ListView�е�ÿ��Item�󶨵���¼�
		clockList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				AlarmManager removeAlarm = (AlarmManager)getSystemService(ALARM_SERVICE); 
				//�Ƴ�����
				removeAlarm.cancel(pendingIntents.get(position));
				//����Ӧ��pendingIntent���������Ƴ���
				pendingIntents.remove(position);
				//�Ƴ���ʾ
				setTime.remove(position);
				//���ݸ���
				simpleAdapter.notifyDataSetChanged();
			}
		});
		
		timePick.setOnTimeChangedListener(new OnTimeChangedListener() {		
			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				if( flag == 1 ) {
					//ʵ����TimePickerDialog���󵯳�ʱ�����õĶԻ���
					new TimePickerDialog(AlarmClock.this, new OnTimeSetListener() {
						//adapter����Դ
						public void addClock( int hour, int minute ) {		
							map = new HashMap<String, Integer>();						
							setHour = Integer.valueOf(hour);
							setMinute = Integer.valueOf(minute);
							map.put("hour", setHour);
							map.put("minute", setMinute);
							setTime.add(map);
							simpleAdapter.notifyDataSetChanged();
						}
						//�趨����ʱ��
						public void setClockTime( int hour, int minute ) {
							
							calender.setTimeInMillis(System.currentTimeMillis());     //��ȡ��ǰʱ�䲢���õ��������� ,��Ҫ���������������պ͵�ǰͬ��              
							calender.set(Calendar.HOUR_OF_DAY,hour);
							calender.set(Calendar.MINUTE, minute);
							calender.set(Calendar.SECOND, 0);         //����Ϊ0
							calender.set(Calendar.MILLISECOND, 0);    //������Ϊ0
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
							//����pendingIntent����							
							PendingIntent pendingintent = PendingIntent.getBroadcast(AlarmClock.this, i-1, intent, PendingIntent.FLAG_ONE_SHOT);
							pendingIntents.add(pendingintent);
							//�жϵ��趨��ʱ��С�ڵ�ǰʱ��ʱ������1
							if( calender.getTimeInMillis() < System.currentTimeMillis() ){
								calender.set(Calendar.DAY_OF_YEAR, calender.get(Calendar.DAY_OF_YEAR ) + 1 );
							}
							//����ʱ��
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
		//����������
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
