package com.example.studream;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Studream extends Activity{
	MediaPlayer med;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.abc);
	    med=MediaPlayer.create(Studream.this,R.raw.abc );
		SharedPreferences share=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    boolean music=share.getBoolean("checkbox",true);
	    if(music==true)
		med.start();
		Thread timer=new Thread(){
				public void run(){
			try{
				sleep(5000);
				}
catch(InterruptedException e){
				e.printStackTrace();
			}
			finally{
				Intent startnew=new Intent("com.example.studream.MENU");
			startActivity(startnew);
			}
			}
			
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		med.release();
		finish();
	}

}
