package com.example.studream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener{
	MyBringBackSurface mbbs;
	float x;
	float y;
	float sx;
	float sy;
	float fx;
	float fy;
	float dx,dy,anix,aniy,scaledx,scaledy;
	Bitmap bmp,plus;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mbbs=new MyBringBackSurface(this);
		mbbs.setOnTouchListener(this);
		x=0;
		y=0;
		sx=0;
		sy=0;
		fx=0;
		fy=0;
		dx=dy=anix=aniy=scaledx=scaledy=0;
		bmp=BitmapFactory.decodeResource(getResources(),R.drawable.arrow_up);
		plus=BitmapFactory.decodeResource(getResources(),R.drawable.dribbble);
		setContentView(mbbs);
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	mbbs.pause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mbbs.resume();
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		try {
		Thread.sleep(50);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		x=arg1.getX();
		y=arg1.getY();
		switch(arg1.getAction()){
		case MotionEvent.ACTION_DOWN:
			sx=arg1.getX();
			sy=arg1.getY();
		    dx=dy=anix=aniy=scaledx=scaledy=0;
		break;
		case MotionEvent.ACTION_UP:
			fx=arg1.getX();
		    fy=arg1.getY();
		    dx=fx-sx;
		    dy=fy-sy;
		    scaledx=dx/30;
		    scaledy=dy/30;
		    x=y=0;
		break;
		}	
		return true;

	}
	public class MyBringBackSurface extends SurfaceView implements Runnable{
		SurfaceHolder surf;
		Thread ourThread=null;
		Boolean isrunning=false;
		public MyBringBackSurface(Context context) {
				super(context);
				// TODO Auto-generated constructor stub
				surf=getHolder();
			}
		public void pause(){
			isrunning=false;
			while(true){
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread=null;
		}
		public void resume(){
			isrunning=true;
			ourThread=new Thread(this);
			ourThread.start();
		}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(isrunning){
					if(!surf.getSurface().isValid())
						continue;
						Canvas canvas=surf.lockCanvas();
						canvas.drawRGB(2, 2, 150);
						if(x!=0&&y!=0){
						canvas.drawBitmap(bmp,x-(bmp.getWidth()/2),y-(bmp.getHeight()/2), null);
						}
						if(sx!=0&&sy!=0){
						canvas.drawBitmap(plus,sx-(plus.getWidth()/2),sy-(plus.getHeight()/2), null);
						}
						if(fx!=0&&fy!=0){
						canvas.drawBitmap(bmp,fx-(bmp.getWidth()/2)-anix,fy-(bmp.getHeight()/2)-aniy, null);
						canvas.drawBitmap(plus,fx-(plus.getWidth()/2),fy-(plus.getHeight()/2), null);
						anix=anix+scaledx;
						aniy=aniy+scaledy;
						}
						surf.unlockCanvasAndPost(canvas);
				}
			}

		}

}
