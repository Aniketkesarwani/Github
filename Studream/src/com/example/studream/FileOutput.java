package com.example.studream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FileOutput extends Activity implements OnClickListener{
EditText et;
TextView loaddata;
FileOutputStream fos;	
String FILENAME="Internal String";
    protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupvariable();
	}
	

	private void setupvariable() {
		// TODO Auto-generated method stub
		et=(EditText) findViewById(R.id.etSharedPrefs);
		Button save=(Button) findViewById(R.id.bsave);
		Button load=(Button) findViewById(R.id.bload);
		loaddata=(TextView) findViewById(R.id.tvLoadSharedPrefs);	
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try {
			fos=openFileOutput(FILENAME,Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bsave:
			String data=et.getText().toString();
			try {
				fos=openFileOutput(FILENAME,Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;
		case R.id.bload:
			new loadSomeStuff().execute(FILENAME);
			break;
		}
	}
public class loadSomeStuff extends AsyncTask<String, Integer, String>{
ProgressDialog dialog;
	protected void onPreExecute(){
	dialog=new ProgressDialog(FileOutput.this);
	dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	dialog.setMax(100);
	dialog.show();
}
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		String Collected=null;
		FileInputStream fis=null;
		for(int i=0;i<20;i++){
		publishProgress(5);
		try {
			Thread.sleep(88);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		try {
			fis=openFileInput(FILENAME);
			byte[] db=new byte[fis.available()];
			while(fis.read()!=-1){
				Collected=new String(db);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				return Collected;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return null;
	}
    protected void onProgressUpdate(Integer...progress){
	dialog.incrementProgressBy(progress[0]);
    }
    protected void onPostExecute(String result){
	loaddata.setText(result);
    }
}
}

