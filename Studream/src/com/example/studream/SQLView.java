package com.example.studream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView text=(TextView)findViewById(R.id.tvSQLinfo);
		HotorNot info=new HotorNot(this);
		info.open();
		String data=info.getData();
		info.close();
		text.setText(data);
	}

}