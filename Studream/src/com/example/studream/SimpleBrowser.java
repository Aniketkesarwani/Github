package com.example.studream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener{
	Button go,back,forward,refresh,clear;
	EditText url;
	WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
		go=(Button) findViewById(R.id.bGo);
		back=(Button) findViewById(R.id.bBack);
		forward=(Button) findViewById(R.id.bForward);
		refresh=(Button) findViewById(R.id.bRefresh);
		clear=(Button) findViewById(R.id.bHistory);
		url=(EditText) findViewById(R.id.etURL);
	    wv=(WebView) findViewById(R.id.wvBrowser);
	    wv.getSettings().setJavaScriptEnabled(true);
	    wv.getSettings().setLoadWithOverviewMode(true);
	    wv.getSettings().setUseWideViewPort(true);
	    wv.setWebViewClient(new ourViewClient());
		try{
			wv.loadUrl("http://www.studream.in");
		}catch(Exception e){
			e.printStackTrace();
		}
	go.setOnClickListener(this);
	back.setOnClickListener(this);
	forward.setOnClickListener(this);
	refresh.setOnClickListener(this);
	clear.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bGo:
			String website=url.getText().toString();
			wv.loadUrl(website);
			InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromInputMethod(url.getWindowToken(),0);
			break;
		case R.id.bBack:
			if(wv.canGoBack())
				wv.goBack();
			break;
		case R.id.bForward:
			if(wv.canGoForward())
				wv.goForward();
			break;
		case R.id.bRefresh:
			wv.reload();
			break;
		case R.id.bHistory:
			wv.clearHistory();
			break;
			
		}
	}

}
