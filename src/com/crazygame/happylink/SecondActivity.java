package com.crazygame.happylink;

import com.example.happylink.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	
	Button begin,record,exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		//获取按钮组件
		begin = (Button) findViewById(R.id.begin);
		record = (Button) findViewById(R.id.record);
		exit = (Button) findViewById(R.id.exit);
		//为按钮组件设置监听器
		begin.setOnClickListener(btnListener);
		record.setOnClickListener(btnListener);
		exit.setOnClickListener(btnListener);	
		
	}
	
	
	private View.OnClickListener btnListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.begin:
				Intent mainIntent = new Intent(SecondActivity.this,MainActivity.class);
				startActivity(mainIntent);
				break;

			case R.id.record:
				Intent recordIntent = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(recordIntent);
				break;
			case R.id.exit:
				finish();
				break;
			default:
				break;
			}
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
