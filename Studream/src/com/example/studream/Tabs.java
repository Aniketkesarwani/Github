package com.example.studream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener{
TabSpec specs,ourspec;
TabHost th;
TextView showResult;
long start,stop;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
	th=(TabHost) findViewById(R.id.tabhost);
	Button tabbutton=(Button)findViewById(R.id.startbutton);
	Button button=(Button)findViewById(R.id.stopbutton);
	Button addbutton=(Button)findViewById(R.id.bAddTab);
	showResult=(TextView) findViewById(R.id.tv1);
	TextView t2=(TextView) findViewById(R.id.tv2);
	th.setup();
	specs=th.newTabSpec("tag1");
	specs.setContent(R.id.tab1);
	specs.setIndicator("StopWatch");
	th.addTab(specs);
	specs=th.newTabSpec("tag2");
	specs.setContent(R.id.tab2);
	specs.setIndicator("Tab");
	th.addTab(specs);
	specs=th.newTabSpec("tag3");
	specs.setContent(R.id.tab3);
	specs.setIndicator("Add a Tab");
	th.addTab(specs);
	button.setOnClickListener(this);
	tabbutton.setOnClickListener(this);
	addbutton.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bAddTab:
			ourspec=th.newTabSpec("tag1");
			ourspec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub
					TextView text=new TextView(Tabs.this);
					text.setText("Your Text is Added");
					return(text);
				}
			});
			ourspec.setIndicator("New");
			th.addTab(ourspec);
			break;
		case R.id.startbutton:
			start=System.currentTimeMillis();
			break;
		case R.id.stopbutton:
			stop=System.currentTimeMillis();
			if(start!=0){
				long result=stop-start;
				int millis=(int) result;
				int second=(int) result/1000;
				int minute=second/60;
				second=second%60;
				millis=millis%100;
				showResult.setText(String.format("%d:%02d:%02d",minute,second,millis));
			}
			break;
		}
	}

}
