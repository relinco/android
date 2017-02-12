package com.example.inco.ac2017_1_21;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by inco on 2017/2/4.
 */

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_layout);
    }
}
