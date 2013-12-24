package com.example.mygps;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private LocationManager locationManager;
	private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button gpsButton = (Button) findViewById(R.id.gpsButton);
        gpsButton.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
        		LoadCoords();
        	}
        } ); 
    }


    public void LoadCoords(){
    	TextView latText = (TextView) findViewById(R.id.latText);
    	TextView lngText = (TextView) findViewById(R.id.lonText);
    	
    	
    	 Criteria criteria = new Criteria();
    	 provider = locationManager.getBestProvider(criteria, false);
    	 Location location = locationManager.getLastKnownLocation(provider);
    	 /*
    	boolean enabled = myManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    	if (!enabled) {
    		  Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    		  startActivity(intent);
    		} */
    	
    	int latPoint = (int) location.getLatitude();
    	int lonPoint = (int) location.getLongitude();
    	latText.setText(String.valueOf(latPoint));
    	lngText.setText(String.valueOf(lonPoint));
    	}
    
}
