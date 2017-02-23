package com.example.studream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends Activity implements View.OnClickListener{
TextView t1,t2,t3,t4,t5,t6;
EditText e1,e2,e3,e4,e5,e6;
Button b1;
AnalogClock c;
String s1,s2,s3,s4,s5,s6;
String message;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emailtext);
	callComponents();
	b1.setOnClickListener(this);
String emailAddress[]={s1};
message="Hello"+s2+"Somethong About MySelf:"+s3+"My mobile no: is"+s4+"and Address is"+s5+"My Special Wish"+s6;
	}
	private void callComponents() {
		// TODO Auto-generated method stub
		t1=(TextView)findViewById(R.id.tv1);
		t2=(TextView)findViewById(R.id.tv2);
		t3=(TextView)findViewById(R.id.tv3);
		t4=(TextView)findViewById(R.id.tv4);
		t5=(TextView)findViewById(R.id.tv5);
		t6=(TextView)findViewById(R.id.tv6);
		e1=(EditText)findViewById(R.id.ed1);
		e2=(EditText)findViewById(R.id.ed2);
		e3=(EditText)findViewById(R.id.ed3);
		e4=(EditText)findViewById(R.id.ed4);
		e5=(EditText)findViewById(R.id.ed5);
		e6=(EditText)findViewById(R.id.ed6);
		b1=(Button)findViewById(R.id.b);
		c=(AnalogClock)findViewById(R.id.ac);
		}

	public void onClick(View v){
		s1=e1.getText().toString();
		s2=e2.getText().toString();
		s3=e3.getText().toString();
		s4=e4.getText().toString();
		s5=e5.getText().toString();
		s6=e6.getText().toString();
		Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,s1);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"I Hate Love Story");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,message);
		emailIntent.setType("plain/text");
		startActivity(emailIntent);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}
