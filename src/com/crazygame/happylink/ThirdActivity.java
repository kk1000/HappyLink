package com.crazygame.happylink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.happylink.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ThirdActivity extends Activity {
	
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	Integer scores[];
	Button record_return;
	
	private int[] recordImage = new int[]{
		R.drawable.one,
		R.drawable.two,
		R.drawable.three,
		R.drawable.four,
		R.drawable.five
	};

	@SuppressLint("CommitPrefEdits")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		
		ListView listView = (ListView) findViewById(R.id.list);
		
		preferences = getSharedPreferences("scores", MODE_PRIVATE);
		editor = preferences.edit();
		
		scores = new Integer[5];
		
		int count = preferences.getInt("count", 5);
		
		for (int i = count-1,j=0; i >= 0; i--,j++) {
			scores[j] = preferences.getInt("gametime"+i, 0);
		}
		
		
		//数组适配器实现简单的列表
		//ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, R.layout.scores,scores);
		
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String,Object>>();
		
		for (int i = 0; i < recordImage.length; i++) {
			Map<String,Object> listItem = new HashMap<String,Object>();
			listItem.put("number", recordImage[i]);
			listItem.put("score", scores[i]);
			
			listItems.add(listItem);
		}
		
		//创建SimpleAdapter		
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.scores, new String[]{"number", "score"},new int[]{R.id.number,R.id.score});
		listView.setAdapter(adapter);	
		
		//获取返回组件
		record_return = (Button) findViewById(R.id.record_return);
		//为返回按钮设置监听事件
		record_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
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
