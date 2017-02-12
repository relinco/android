package com.example.clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastClock extends BroadcastReceiver {
	private int hour;
	private int minute;
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		hour = arg1.getIntExtra("hour", 0);
		minute = arg1.getIntExtra("minute", 0);
		Toast.makeText(arg0, "闹钟时间到：" + hour + ":" + minute, Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(arg0, AlarmRemindsActivity.class);      //第一个参数是Context
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		arg0.startActivity(intent);
	}

}			
