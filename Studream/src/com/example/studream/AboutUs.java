package com.example.studream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends Activity{
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		tv=(TextView)findViewById(R.id.ab);
	}

}
