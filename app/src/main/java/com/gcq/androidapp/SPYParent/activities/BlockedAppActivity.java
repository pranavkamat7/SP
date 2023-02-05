package com.gcq.androidapp.SPYParent.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gcq.androidapp.SPYParent.R;

import static com.gcq.androidapp.SPYParent.services.MainForegroundService.BLOCKED_APP_NAME_EXTRA;

public class BlockedAppActivity extends AppCompatActivity {
	private TextView txtBlockedAppName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blocked_app);
		
		txtBlockedAppName = findViewById(R.id.txtBlockedAppName);
		Intent intent = getIntent();
		String blockedAppName = intent.getStringExtra(BLOCKED_APP_NAME_EXTRA);
		txtBlockedAppName.setText(blockedAppName);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}
