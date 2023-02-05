package com.gcq.androidapp.SPYParent.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gcq.androidapp.SPYParent.R;
import com.gcq.androidapp.SPYParent.fragments.LocationPermissionsFragment;
import com.gcq.androidapp.SPYParent.fragments.PermissionsMainFragment;
import com.gcq.androidapp.SPYParent.fragments.PhoneCallsPermissionsFragment;
import com.gcq.androidapp.SPYParent.fragments.SMSPermissionsFragment;
import com.gcq.androidapp.SPYParent.fragments.SettingsPermissionsFragment;
import com.gcq.androidapp.SPYParent.interfaces.OnFragmentChangeListener;
import com.gcq.androidapp.SPYParent.utils.Constant;
import com.gcq.androidapp.SPYParent.utils.SharedPrefsUtils;

public class PermissionsActivity extends AppCompatActivity implements OnFragmentChangeListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_permissions);
		
		getSupportFragmentManager().beginTransaction().replace(R.id.permissionFragmentContainer, new PermissionsMainFragment()).commit();
		
		
	}
	
	@Override
	public void onFragmentChange(int id) {
		Fragment selectedFragment = null;
		switch (id) {
			case Constant.PERMISSIONS_MAIN_FRAGMENT:
				selectedFragment = new PermissionsMainFragment();
				break;
			case Constant.PERMISSIONS_SMS_FRAGMENT:
				selectedFragment = new SMSPermissionsFragment();
				break;
			case Constant.PERMISSIONS_PHONE_CALLS_FRAGMENT:
				selectedFragment = new PhoneCallsPermissionsFragment();
				break;
			case Constant.PERMISSIONS_LOCATION_FRAGMENT:
				selectedFragment = new LocationPermissionsFragment();
				break;
			case Constant.PERMISSIONS_SETTINGS_FRAGMENT:
				selectedFragment = new SettingsPermissionsFragment();
				break;
			case Constant.PERMISSIONS_FRAGMENTS_FINISH:
				SharedPrefsUtils.setBooleanPreference(this, Constant.CHILD_FIRST_LAUNCH, false);
				Intent intent = new Intent(this, ChildSignedInActivity.class);
				startActivity(intent);
				break;
		}
		
		if (selectedFragment != null)
			getSupportFragmentManager().beginTransaction().replace(R.id.permissionFragmentContainer, selectedFragment).commit();
		
	}
	
	@Override
	public void onBackPressed() {
		//NO going back to childSignedIn activity
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}
}
