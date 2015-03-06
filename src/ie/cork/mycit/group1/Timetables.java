package ie.cork.mycit.group1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

public class Timetables extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timetables);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timetables, menu);
		getActionBar().setDisplayHomeAsUpEnabled(true);		
		return true;
	}

	public void submit(View v) {
		Spinner spinnerClass = (Spinner)findViewById(R.id.spinnerClasses);
		String classGroup = spinnerClass.getSelectedItem().toString();
		
		Spinner spinnerTime = (Spinner)findViewById(R.id.spinnerTime);
		String time = spinnerTime.getSelectedItem().toString();
		
		String url = "http://timetables.cit.ie:70/reporting/Individual;Student+Set;name;";
		url += classGroup + "%0D%0A?weeks=";
		
		if(time.equalsIgnoreCase("Semester 1")){
			url += "4-16";
		}
		else if(time.equalsIgnoreCase("Semester 2")){
			url += "24-31;34-38";
		}
		url += "&days=1-5&periods=1-40&height=100&width=100";
		
		startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
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
