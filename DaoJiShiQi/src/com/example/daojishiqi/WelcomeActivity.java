package com.example.daojishiqi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity {

	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		button = (Button) findViewById(R.id.next);
	}

	public void next(View view){
		Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
		startActivity(intent);
		finish();
	}

}
