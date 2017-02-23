package com.example.studream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener{
EditText sendEt;
Button start,startFor;
TextView gotit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getdata);
		method();
	}
	private void method() {
		// TODO Auto-generated method stub
		sendEt=(EditText)findViewById(R.id.edit);
		start=(Button)findViewById(R.id.sa);
		startFor=(Button)findViewById(R.id.safr);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
		}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	switch(v.getId()){
	case R.id.sa:
		String str=sendEt.getText().toString();
		Bundle bun=new Bundle();
		bun.putString("Key",str);
		Intent i=new Intent(OpenedClass.this,Data.class);
		i.putExtras(bun);
		startActivity(i);
		break;
	case R.id.safr:
			Intent open=new Intent(OpenedClass.this,Data.class);
			startActivityForResult(open,0);
		break;
	}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	if(resultCode==RESULT_OK){
	Bundle bund=data.getExtras();
	String s=bund.getString("ans");
	gotit.setText(s);
	}
	}
	
	}
