package com.example.studream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class MyBringBack extends View{
Bitmap bit;
float h;
Typeface font;
	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		bit=BitmapFactory.decodeResource(getResources(), R.drawable.comp);
	h=0;
	font=Typeface.createFromAsset(context.getAssets(),"harngton.ttf");
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	canvas.drawColor(Color.WHITE);
	Paint p=new Paint();
	p.setARGB(50, 254, 10, 50);
	p.setTextAlign(Align.CENTER);
	p.setTextSize(50);
	p.setTypeface(font);
	canvas.drawText("Studream",canvas.getWidth()/2,100,p);
	
	canvas.drawBitmap(bit, canvas.getWidth()/2,h,null);
	if(h<canvas.getHeight()){
		h+=10;
	}else{
		h=0;
	}
	invalidate();
	Rect midRect=new Rect();
	midRect.set(0, 400,canvas.getWidth(),550);
	Paint paint=new Paint();
	paint.setColor(Color.BLUE);
	canvas.drawRect(midRect, paint);
	}

}
