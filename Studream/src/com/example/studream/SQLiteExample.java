package com.example.studream;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener{
	TextView name,hotness,row;
	EditText sqlname,sqlhotness,getrow;
	Button view,update,information,modify,drop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		implement();
	}

	private void implement() {
		// TODO Auto-generated method stub
		name=(TextView)findViewById(R.id.tvName);
		hotness=(TextView)findViewById(R.id.tvHotness);
		row=(TextView)findViewById(R.id.row);
		sqlname=(EditText)findViewById(R.id.etName);
		sqlhotness=(EditText)findViewById(R.id.etHotness);
		getrow=(EditText)findViewById(R.id.sqlrow);
		view=(Button)findViewById(R.id.bSqlView);
		update=(Button)findViewById(R.id.bSqlUpdate);
		information=(Button)findViewById(R.id.getinfo);
		modify=(Button)findViewById(R.id.edit);
		drop=(Button)findViewById(R.id.delete);
		view.setOnClickListener(this);
	    update.setOnClickListener(this);
	    information.setOnClickListener(this);
	    modify.setOnClickListener(this);
	    drop.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
	case R.id.bSqlUpdate:
		boolean didItwork=true;	
		try{
				String sname=sqlname.getText().toString();
			String shotness=sqlhotness.getText().toString();
			HotorNot entry=new HotorNot(SQLiteExample.this);
			entry.open();
			entry.createEntry(sname,shotness);
			entry.close();
			}catch(Exception e){
				didItwork=false;
				String error=e.toString();
				Dialog d=new Dialog(this);
				d.setTitle("Dang !");
				TextView v=new TextView(this);
				v.setText(error);
				d.setContentView(v);
				d.show();
			}finally{
				if(didItwork){
					Dialog d=new Dialog(this);
					d.setTitle("Hack Yea!");
					TextView v=new TextView(this);
					v.setText("Success");
					d.setContentView(v);
					d.show();
				}
			}
			break;
	case R.id.bSqlView:
			Intent i=new Intent("com.example.studream.SQLView");
			startActivity(i);
			break;
	case R.id.getinfo:
		try{
		String s=getrow.getText().toString();
		long l=Long.parseLong(s);
		HotorNot hot=new HotorNot(this);
		hot.open();
		String returnedName=hot.getName(l);
		String returnedHotness=hot.getHotness(l);
		hot.close();
		sqlname.setText(returnedName);
		sqlhotness.setText(returnedHotness);
		}catch(Exception e){
			String error=e.toString();
			Dialog d=new Dialog(this);
			d.setTitle("Dang !");
			TextView v=new TextView(this);
			v.setText(error);
			d.setContentView(v);
			d.show();
		}
		break;
	case R.id.edit:
		try{
		String mName=sqlname.getText().toString();
		String nHotness=sqlhotness.getText().toString();
		String m=getrow.getText().toString();
		long n=Long.parseLong(m);
		HotorNot hoty=new HotorNot(this);
		hoty.open();
		hoty.change(n,mName,nHotness);
		hoty.close();
	}catch(Exception e){
		String error=e.toString();
		Dialog d=new Dialog(this);
		d.setTitle("Dang !");
		TextView v=new TextView(this);
		v.setText(error);
		d.setContentView(v);
		d.show();
	}
	break;
	case R.id.delete:
		try{
		String o=getrow.getText().toString();
		long p=Long.parseLong(o);
		HotorNot hotn=new HotorNot(this);
		hotn.open();
		hotn.deleteentry(p);
		hotn.close();
}catch(Exception e){
	String error=e.toString();
	Dialog d=new Dialog(this);
	d.setTitle("Dang !");
	TextView v=new TextView(this);
	v.setText(error);
	d.setContentView(v);
	d.show();
}
break;
		}
	}

}
