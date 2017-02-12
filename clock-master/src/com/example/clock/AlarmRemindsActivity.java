package com.example.clock;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlarmRemindsActivity extends Activity implements OnClickListener{
	private Button alarmStop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_reminds);
		AudioManager autoManager = (AudioManager)getSystemService(AUDIO_SERVICE);
		autoManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		alarmStop = (Button)findViewById(R.id.alarm_stop);
		alarmStop.setOnClickListener(AlarmRemindsActivity.this);
	}
	
	public void onClick( View v ) {
		if( v == alarmStop ) {
			finish();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm_reminds, menu);
		return true;
	}

}
