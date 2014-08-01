package com.ygo.ygo_parking_project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class FavoritesActivity extends Activity {
	private List<Favorites> values;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorites);
		Button addFavorites =(Button)findViewById(R.id.buttonAddFavorites);
		
		addFavorites.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				/**
				 * Button for add new favorite screen
				 * */
				switchToAddFavorites();
			}
		});
		
		ListView listFav = (ListView)findViewById(R.id.listFavorites);
		
		
		values = new ArrayList<Favorites>();
		values.add(new Favorites("fav 1","addr 1"));
		values.add(new Favorites("fav 2","addr 2"));
		values.add(new Favorites("fav 3","addr 3"));
		values.add(new Favorites("fav 4","addr 4"));
		registerForContextMenu(listFav);
		popolateList();
		listFav.setOnItemClickListener(new OnItemClickListener() {
		
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				/**
				 * On click ,application will start running with favorite address on waze
				 */
				try
				{
				   String url = "waze://?q=" + values.get(position).getAddrees();
				   Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
				   startActivity( intent );
				}
				catch ( ActivityNotFoundException ex  )
				{
				  Intent intent =
				    new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
				  startActivity(intent);
				}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favorites, menu);
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

	private void switchToAddFavorites() {
		Intent addFavoritesIntent = new Intent(this , AddFavoritesActivity.class);
		startActivityForResult(addFavoritesIntent, 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Serializable extra = data.getSerializableExtra("favorites");
		if(extra != null)
		{
			Favorites newFavorites = (Favorites)extra;
			values.add(newFavorites);
			popolateList();
		}
	}
	
	private void popolateList()
	{
		ListView listFav = (ListView)findViewById(R.id.listFavorites);
		ArrayAdapter<Favorites> adapter = new ArrayAdapter<Favorites>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
		listFav.setAdapter(adapter);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		if (v.getId()==R.id.listFavorites) {
		    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
		    menu.setHeaderTitle(values.get(info.position).getTitle());
		    String[] menuItems = {"Edit","Delete"};
		    for (int i = 0; i<menuItems.length; i++) {
		      menu.add(Menu.NONE, i, i, menuItems[i]);
		    }
		  }
	}
}
