package com.example.studream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener{
TextView read,write;
boolean canr,canw;
String state;
String[] paths={"Music","Picture","Download"};
Spinner sp;
File file=null;
File filename=null;
EditText saveas;
Button save,confirm;

   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.externaldata);
	read=(TextView)findViewById(R.id.tvread);
	write=(TextView)findViewById(R.id.tvwrite);
	saveas=(EditText)findViewById(R.id.etsave);
	   save=(Button)findViewById(R.id.bSave);
	   confirm=(Button)findViewById(R.id.bConfirm);
	   save.setOnClickListener(this);
	   confirm.setOnClickListener(this);
     checkState();
	ArrayAdapter<String> ad=new ArrayAdapter<String>(ExternalData.this,android.R.layout.simple_spinner_item,paths);
    sp=(Spinner)findViewById(R.id.spinner1);
    sp.setAdapter(ad);
   sp.setOnItemSelectedListener(this);
      }
private void checkState() {
	// TODO Auto-generated method stub
	state=Environment.getExternalStorageState();
	if(state.equals(Environment.MEDIA_MOUNTED)){
		read.setText("True");
		write.setText("True");
		canr=true;
		canw=true;
	}else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
		read.setText("True");
		write.setText("False");
		canr=true;
		canw=false;
	}else{
		read.setText("False");
		write.setText("False");
		canr=false;
		canw=false;
	}
}
@Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
	int position=sp.getSelectedItemPosition();
	switch(position){
	case 0:
		file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
		break;
	case 1:
		file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		break;
	case 2:
		file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		break;
	}
}
@Override
public void onNothingSelected(AdapterView<?> arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	switch(arg0.getId()){
	case R.id.bSave:
		String f=saveas.getText().toString();
		filename=new File(file,f+".png");
		checkState();
		if(canr==canw==true){
			file.mkdirs();
			try {
				InputStream is=getResources().openRawResource(R.drawable.arrow_up);
				OutputStream os=new FileOutputStream(filename);
			byte[] data=new byte[is.available()];
			is.read(data);
			os.write(data);
			is.close();
			os.close();
		Toast t=Toast.makeText(ExternalData.this, "The file has been Saved",Toast.LENGTH_LONG);
			t.show();
			MediaScannerConnection.scanFile(ExternalData.this,
					new String[] {filename.toString()},
					null,
					new MediaScannerConnection.OnScanCompletedListener(){

						@Override
						public void onScanCompleted(String arg0, Uri arg1) {
							// TODO Auto-generated method stub
							Toast t=Toast.makeText(ExternalData.this,"Scan Completed",Toast.LENGTH_SHORT);
						t.show();
						}
				
			});
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		break;
	case R.id.bConfirm:
		save.setVisibility(View.VISIBLE);
		break;
	}
}

}
