package com.example.studream;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener{
	public static String filename="My Shared String";
	EditText et;
	TextView loaddata;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupvariable();
		sp=getSharedPreferences(filename,0);
	}
	

	private void setupvariable() {
		// TODO Auto-generated method stub
		et=(EditText) findViewById(R.id.etSharedPrefs);
		Button save=(Button) findViewById(R.id.bsave);
		Button load=(Button) findViewById(R.id.bload);
		loaddata=(TextView) findViewById(R.id.tvLoadSharedPrefs);	
		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bsave:
			String StringData=et.getText().toString();
			SharedPreferences.Editor editor=sp.edit();
			editor.putString("sharedString",StringData);
			editor.commit();
			break;
		case R.id.bload:
			sp=getSharedPreferences(filename,0);
			String DataReturn=sp.getString("sharedString","Couldn't Load");
			loaddata.setText(DataReturn);
			break;
		}
	}

}
