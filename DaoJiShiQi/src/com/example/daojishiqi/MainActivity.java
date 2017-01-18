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
	//ʱ�����
	private long hour = 0;//ʱ
	private long minute = 0;//��
	private long second = 0;//��  
	private long time = 0;//��ʱ��  
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
		time = (hour * 3600 + minute * 60 + second) * 1000;  //��Ϊ��msΪ��λ�����Գ���1000.
		count = new MyCount(time, 1000);//��ʱʱ��Ϊ1s
		txt_time.setText("ʣ��ʱ��00��00��00");
		txt_time.setTextSize(30);


	}
	public void startTime(View view){
		count.start();  //��ʼ��ʱ  ��������������������
	}

	public void restartTime(View view){
		count.resume();//���¼�ʱ
	}
	public void cancleTime(View view){
		count.cancel();//ȡ����ʱ
	}

	/**
	 * ʵ�ֵ���ʱ���ܵ���
	 */
	class MyCount extends AdvancedCountdownTimer{
		public MyCount(long millisInFuture, long countDownInterval) {  //������������AdvancedCountdownTimer.java�о���(�ڡ����캯������).
			super(millisInFuture, countDownInterval);  
		}  

		@Override  
		public void onFinish() {   
//			txt_time.setText("ʣ��ʱ��00��00��00");   

			Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
			startActivity(intent);
			finish();

		}

		//����ʣ��ʱ��  
		String a = null;
		@Override  
		public void onTick(long millisUntilFinished, int percent) {  
			long myhour = (millisUntilFinished / 1000) / 3600;  
			long myminute = ((millisUntilFinished / 1000) - myhour * 3600) / 60;  
			long mysecond = millisUntilFinished / 1000 - myhour * 3600  
					- myminute * 60; 
			if(mysecond<10){
				a = "0" + mysecond;
				txt_time.setText("ʣ��ʱ��" + "0"+ myhour + ":" +"0"+myminute + ":" + a);
			}else{
				
				txt_time.setText("ʣ��ʱ��" + "0"+ myhour + ":" +"0"+myminute + ":" + mysecond);
			}
			 
			txt_time.setTextSize(30);
		} 

	}
}



