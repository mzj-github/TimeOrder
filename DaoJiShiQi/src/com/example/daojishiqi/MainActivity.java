package com.example.daojishiqi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txt_time;
	private MyCount count = null;
	Button breStart;
	Button bcancle;
	//时间变量
	private long hour = 0;//时
	private long minute = 0;//分
	private long second = 0;//秒  
	private long time = 0;//总时间  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txt_time = (TextView) findViewById(R.id.tv_time);
		breStart = (Button) findViewById(R.id.button2);
		bcancle = (Button) findViewById(R.id.button3);


		hour = Long.parseLong("00");  
		minute = Long.parseLong("02");  
		second = Long.parseLong("00");  
		time = (hour * 3600 + minute * 60 + second) * 1000;  //因为以ms为单位，所以乘以1000.
		count = new MyCount(time, 1000);//延时时间为1s
		txt_time.setText("剩余时间00：00：00");
		txt_time.setTextSize(30);


	}
	public void startTime(View view){
		count.start();  //开始计时  ！！！！！！！！！！
	}

	public void restartTime(View view){
		count.resume();//重新计时
	}
	public void cancleTime(View view){
		count.cancel();//取消计时
	}

	/**
	 * 实现倒计时功能的类
	 */
	class MyCount extends AdvancedCountdownTimer{
		public MyCount(long millisInFuture, long countDownInterval) {  //这两个参数在AdvancedCountdownTimer.java中均有(在“构造函数”中).
			super(millisInFuture, countDownInterval);  
		}  

		@Override  
		public void onFinish() {   
//			txt_time.setText("剩余时间00：00：00");   

			Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
			startActivity(intent);
			finish();

		}

		//更新剩余时间  
		String a = null;
		@Override  
		public void onTick(long millisUntilFinished, int percent) {  
			long myhour = (millisUntilFinished / 1000) / 3600;  
			long myminute = ((millisUntilFinished / 1000) - myhour * 3600) / 60;  
			long mysecond = millisUntilFinished / 1000 - myhour * 3600  
					- myminute * 60; 
			if(mysecond<10){
				a = "0" + mysecond;
				txt_time.setText("剩余时间" + "0"+ myhour + ":" +"0"+myminute + ":" + a);
			}else{
				
				txt_time.setText("剩余时间" + "0"+ myhour + ":" +"0"+myminute + ":" + mysecond);
			}
			 
			txt_time.setTextSize(30);
		} 

	}
}



