package com.example.studream;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener{
ImageView iv;
ImageButton ib;
Button but;
final static int cameraData=0;
Bitmap bmp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		createCompo();
	InputStream inp=getResources().openRawResource(R.drawable.studream);
	bmp=BitmapFactory.decodeStream(inp);
}
	private void createCompo() {
		// TODO Auto-generated method stub
		iv=(ImageView)findViewById(R.id.img);
		ib=(ImageButton)findViewById(R.id.imgB);
		but=(Button)findViewById(R.id.button);
		ib.setOnClickListener(this);
		but.setOnClickListener(this);
		}
	
public void onClick(View v){
	switch(v.getId()){
	case R.id.button:
		try {
			getApplicationContext().setWallpaper(bmp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		break;
	case R.id.imgB:
	Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent,cameraData);
		break;
	}
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	if(resultCode==RESULT_OK){
		Bundle extra=data.getExtras();
		bmp=(Bitmap)extra.get("data");
	iv.setImageBitmap(bmp);
	}
	
}

}
