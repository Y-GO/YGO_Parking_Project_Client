package com.ygo.ygo_parking_project;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddFavoritesActivity extends ActionBarActivity {
	private Button saveFavoritesButton;
	private EditText textAddFavoritesAddress;
	private EditText textAddFavoritesTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_favorites);
		textAddFavoritesAddress = (EditText)findViewById(R.id.editFavoritesAddress);
		textAddFavoritesTitle = (EditText)findViewById(R.id.editFavoritesTitle);
		saveFavoritesButton = (Button)findViewById(R.id.buttonSave);
		saveFavoritesButton.setEnabled(false);
		saveFavoritesButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent saveButtonIntent = new Intent();
				Favorites favorites = new Favorites (textAddFavoritesAddress.getText().toString(), textAddFavoritesTitle.getText().toString());
				saveButtonIntent.putExtra("favorites", favorites);
				setResult(RESULT_OK, saveButtonIntent);
				finish();
			}
		});
		textAddFavoritesAddress.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if(s.toString().length() > 0){
					saveFavoritesButton.setEnabled(true);
				}
				else if(s.toString().length() == 0){
					saveFavoritesButton.setEnabled(false);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_favorites, menu);
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

	public Button getAddFavoritesButton() {
		return saveFavoritesButton;
	}

	public void setAddFavoritesButton(Button addFavoritesButton) {
		this.saveFavoritesButton = addFavoritesButton;
	}


}
