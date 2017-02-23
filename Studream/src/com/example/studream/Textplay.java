package com.example.studream;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Textplay extends Activity implements View.OnClickListener{
	Button b;
	ToggleButton tb;
	EditText ed;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
        baconAndEgg();
	tb.setOnClickListener(this);	
     b.setOnClickListener(this);
	}
	private void baconAndEgg() {
		// TODO Auto-generated method stub
		b=(Button) findViewById(R.id.bResult);
		tb=(ToggleButton) findViewById(R.id.tgResult);
		ed=(EditText) findViewById(R.id.edResult);
		tv=(TextView) findViewById(R.id.tvResult);
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
			// TODO Auto-generated method stub
		case R.id.tgResult:
		if(tb.isChecked()){
			ed.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}else{
			ed.setInputType(InputType.TYPE_CLASS_TEXT);
		}
		break;
		case R.id.bResult:
				// TODO Auto-generated method stub
				String check=ed.getText().toString();
				tv.setText(check);
				if(check.contentEquals("left") ){
					tv.setGravity(Gravity.LEFT);
				}else if(check.contentEquals("center") ){
					tv.setGravity(Gravity.CENTER);
				}
			else if(check.contentEquals("right") ){
				tv.setGravity(Gravity.RIGHT);
			}else if(check.contentEquals("blue") ){
				tv.setTextColor(Color.BLUE);
			}else if(check.contains("WTF") ){
			Random crazy=new Random();
			tv.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265),crazy.nextInt(265)));
			tv.setText("WTF!!!");
			tv.setTextSize(crazy.nextInt());
			switch(crazy.nextInt(3)){
			case 0:
				tv.setGravity(Gravity.LEFT);
				break;
			case 1:
				tv.setGravity(Gravity.RIGHT);
				break;
			case 2:
				tv.setGravity(Gravity.CENTER);
				break;	
			}
			}else{
				tv.setText("invalid");
				tv.setGravity(Gravity.CENTER);
				tv.setTextColor(Color.CYAN);
	}
}
	}
}