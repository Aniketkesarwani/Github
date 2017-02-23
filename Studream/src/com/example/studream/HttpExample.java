package com.example.studream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HttpExample extends Activity{
TextView httpStuff;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpexample);
	httpStuff=(TextView)findViewById(R.id.tvhttp);	
	GetMethod test=new GetMethod();
	String returned;
	try {
	returned=test.getInternalData();
	httpStuff.setText(returned);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
