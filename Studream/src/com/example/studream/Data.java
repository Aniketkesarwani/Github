package com.example.studream;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener,OnCheckedChangeListener{
TextView Ques;
TextView Ans;
Button returndata;
RadioGroup Radio;
String gotQues;
String setdata;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		methods();
		//Bundle gotbundle=getIntent().getExtras();
		//gotQues=gotbundle.getString("key");
		//Ques.setText(gotQues);
		SharedPreferences gets=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String gt=gets.getString("edit","My GrandMom is...");
		String values=gets.getString("list","4");
		if(values.contentEquals("1")){
			Ques.setText(gt);
		}
}
	private void methods() {
		// TODO Auto-generated method stub
		Ques=(TextView)findViewById(R.id.ques);
		Ans=(TextView)findViewById(R.id.answer);
		Radio=(RadioGroup)findViewById(R.id.rg);
		returndata=(Button)findViewById(R.id.ret);
		returndata.setOnClickListener(this);
		Radio.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		Bundle bread=new Bundle();
		bread.putString("ans",setdata);
		intent.putExtras(bread);
		setResult(RESULT_OK,intent);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case R.id.rCrazy:
		setdata="Correct hai";
			break;
		case R.id.rSexy:
			setdata="Sahi hai!!";
			break;
		case R.id.rBoth:
			setdata="ha bhai";
			break;
		}
		Ans.setText(setdata);
	}

}
