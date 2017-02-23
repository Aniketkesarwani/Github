package com.example.studream;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class StartingPoint extends Activity {
TextView text,dext;
Button add,sub;
int counter;    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_point);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.starting_point, menu);
        counter=0;
        text=(TextView) findViewById(R.id.t1);
        dext=(TextView) findViewById(R.id.t2);
        add=(Button) findViewById(R.id.b1);
        sub=(Button) findViewById(R.id.b2);
        add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter++;
				dext.setText("Your Total is"+counter);
			}
		});
        sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter--;
				dext.setText("Your Total is"+counter);
			}
		});
return true;

    
    }
    
}
