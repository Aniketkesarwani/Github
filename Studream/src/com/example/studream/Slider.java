package com.example.studream;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener, OnCheckedChangeListener, OnDrawerOpenListener{
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	CheckBox cb;
	SlidingDrawer sd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
	b1=(Button)findViewById(R.id.h1);
	b2=(Button)findViewById(R.id.h2);
	b3=(Button)findViewById(R.id.h3);
	b4=(Button)findViewById(R.id.h4);
	cb=(CheckBox)findViewById(R.id.cb);
	sd=(SlidingDrawer) findViewById(R.id.slidingD);
	b1.setOnClickListener(this);
	b2.setOnClickListener(this);
	b3.setOnClickListener(this);
	b4.setOnClickListener(this);
	cb.setOnCheckedChangeListener(this);
	sd.setOnDrawerOpenListener(this);

	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if(arg0.isChecked()){
			sd.lock();
		}else{
			sd.unlock();
		}
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.h1:
			sd.open();
			break;
		case R.id.h2:
			
			break;
		case R.id.h3:
		sd.toggle();
			break;
		case R.id.h4:
			sd.close();
			break;
		}
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer mp=MediaPlayer.create(this,R.raw.explosion);
	mp.start();
	}
}
