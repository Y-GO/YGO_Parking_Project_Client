package com.ygo.ygo_parking_project;

import java.io.Serializable;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button buttonFavorites = (Button)findViewById(R.id.buttonFavorites);
		buttonFavorites.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v)
			{
				swichToFavorites();
			}
		});
		final PackageManager pm = getPackageManager();
		//get a list of installed apps.
		List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

		for (ApplicationInfo packageInfo : packages) {
		    System.out.println("Installed package :" + packageInfo.packageName);
		    //System.out.println("Source dir : " + packageInfo.sourceDir);
		    //System.out.println("Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName)); 
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	private void swichToFavorites() {
		Intent favoritesIntent = new Intent(this,FavoritesActivity.class);
		startActivity(favoritesIntent);
	}
}
