package com.owuor91.weatherapp.activities;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orm.SugarRecord;
import com.owuor91.weatherapp.R;
import com.owuor91.weatherapp.datamodels.Geoname;
import com.owuor91.weatherapp.datamodels.WeatherObservation;
import com.owuor91.weatherapp.services.GeodataService;
import com.owuor91.weatherapp.services.WeatherdataService;

import java.text.DecimalFormat;
import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    public TextView tvPopulation, tvLatitude, tvLongitude, tvTemperature, tvClouds, tvHumidity, tvWindspeed, tvAltitude, tvPressure, tvDewpoint;
    LinearLayout parenthorizontal_ll, ll_clouds, ll_humidity, ll_windspeed, ll_altitude, ll_pressure, ll_dewpoint;
    HorizontalScrollView horizontalScrollView;
    int currentPosition;
    ArrayList<LinearLayout> linearLayoutArrayList;
    ImageView previous, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/GothamRoundedBook.ttf").setFontAttrId(R.attr.fontPath).build());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nairobi Weather");
        toolbar.getBackground().setAlpha(0);

        downloadAPIdata();
        castViews();
        setupHorizontalScrollView();
        bindDataToTextViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void downloadAPIdata(){
        long geodatacount = SugarRecord.count(Geoname.class, null, null);
        if (geodatacount==0){
            new GeodataService().getGeodata();
        }

        long weatherdatacount = SugarRecord.count(WeatherObservation.class, null, null);
        if (weatherdatacount==0){
            new WeatherdataService().getWeatherData();
        }
    }

    private void castViews(){
        tvPopulation = (TextView) findViewById(R.id.tvPopulation);
        tvLatitude = (TextView) findViewById(R.id.tvLatitude);
        tvLongitude = (TextView) findViewById(R.id.tvLongitude);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);
        tvClouds = (TextView) findViewById(R.id.tvClouds);
        tvHumidity = (TextView) findViewById(R.id.tvHumidity);
        tvWindspeed = (TextView) findViewById(R.id.tvWindspeed);
        tvAltitude = (TextView) findViewById(R.id.tvAltitude);
        tvPressure = (TextView) findViewById(R.id.tvPressure);
        tvDewpoint = (TextView) findViewById(R.id.tvDewpoint);

        previous = (ImageView) findViewById(R.id.previous);
        next = (ImageView) findViewById(R.id.next);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);

        parenthorizontal_ll = (LinearLayout) findViewById(R.id.parenthorizontal_ll);
        ll_clouds = (LinearLayout) findViewById(R.id.ll_clouds);
        ll_humidity = (LinearLayout) findViewById(R.id.ll_humidity);
        ll_windspeed = (LinearLayout) findViewById(R.id.ll_windspeed);
        ll_altitude = (LinearLayout) findViewById(R.id.ll_altitude);
        ll_pressure = (LinearLayout) findViewById(R.id.ll_pressure);
        ll_dewpoint = (LinearLayout) findViewById(R.id.ll_dewpoint);
    }

    private void setupHorizontalScrollView(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int displayWidth = size.x;
        final int viewWidth = displayWidth/2;
        linearLayoutArrayList = new ArrayList<LinearLayout>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(viewWidth, ViewGroup.LayoutParams.WRAP_CONTENT);

        ll_clouds.setLayoutParams(params);
        ll_humidity.setLayoutParams(params);
        ll_windspeed.setLayoutParams(params);
        ll_altitude.setLayoutParams(params);
        ll_pressure.setLayoutParams(params);
        ll_dewpoint.setLayoutParams(params);

        linearLayoutArrayList.add(ll_clouds);
        linearLayoutArrayList.add(ll_humidity);
        linearLayoutArrayList.add(ll_windspeed);
        linearLayoutArrayList.add(ll_altitude);
        linearLayoutArrayList.add(ll_pressure);
        linearLayoutArrayList.add(ll_dewpoint);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        horizontalScrollView.smoothScrollTo((int) horizontalScrollView.getScrollX() + viewWidth, (int) horizontalScrollView.getScrollY());
                    }
                }, 100L);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        horizontalScrollView.smoothScrollTo((int) horizontalScrollView.getScrollX() - viewWidth, (int) horizontalScrollView.getScrollY());
                    }
                }, 100L);
            }
        });

        horizontalScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX()< e2.getX()){
                currentPosition = getVisibleViews("left");
            }
            else{
                currentPosition = getVisibleViews("right");
            }
            horizontalScrollView.smoothScrollTo(linearLayoutArrayList.get(currentPosition).getLeft(), 0);
            return true;
        }
    }

    public int getVisibleViews(String direction){
        Rect hitRect = new Rect();
        int position = 0;
        int rightCounter = 0;

        for (int i = 0; i < linearLayoutArrayList.size(); i++) {
            if (linearLayoutArrayList.get(i).getLocalVisibleRect(hitRect)){
                if (direction.equals("left")){
                    position = i;
                    break;
                }
                else if(direction.equals("right")){
                    rightCounter++;
                    position=i;
                    if (rightCounter==2){
                        break;
                    }
                }
            }
        }
        return position;
    }

    private void bindDataToTextViews(){
        Geoname nairobiGeoData = SugarRecord.listAll(Geoname.class).get(0);
        if (nairobiGeoData!=null){
            DecimalFormat decimalformat = new DecimalFormat("#,###");
            tvPopulation.setText(decimalformat.format(nairobiGeoData.getPopulation()));
            tvLongitude.setText("Long. :"+nairobiGeoData.getLng());
            tvLatitude.setText("Lat. :"+nairobiGeoData.getLat());
        }

        WeatherObservation nairobiWeather = SugarRecord.listAll(WeatherObservation.class).get(0);
        if (nairobiWeather!=null){
            tvTemperature.setText(nairobiWeather.getTemperature()+"\u2103");
            tvClouds.setText(nairobiWeather.getClouds());
            tvPressure.setText(nairobiWeather.getHectoPascAltimeter()+" hPa");
            tvDewpoint.setText(nairobiWeather.getDewPoint()+"\u2103");
            tvAltitude.setText(nairobiWeather.getElevation()+" Metres");
            tvHumidity.setText(nairobiWeather.getHumidity()+"%");
            tvWindspeed.setText(nairobiWeather.getWindSpeed()+" mph");
        }
    }
}
