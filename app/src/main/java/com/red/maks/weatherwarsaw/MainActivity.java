package com.red.maks.weatherwarsaw;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.red.maks.weatherwarsaw.data.Channel;
import com.red.maks.weatherwarsaw.data.Item;
import com.red.maks.weatherwarsaw.services.WeatherServiceCallback;
import com.red.maks.weatherwarsaw.services.YahooWeatherService;




public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView WeatherICON;
    private TextView temperatureTXT;
    private TextView conditionTXT;
    private TextView cityTXT;
    private Button ReBUT;

    private YahooWeatherService service;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherICON = (ImageView)findViewById(R.id.WeatherICON);
        temperatureTXT = (TextView)findViewById(R.id.AmbientTemperatureTXT);
        conditionTXT = (TextView)findViewById(R.id.ConditionTXT);
        cityTXT = (TextView)findViewById(R.id.CityTXT);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Warsaw, PL");
    }
    public void buttonOnClick(View v) {
        setContentView(R.layout.activity_main);

        WeatherICON = (ImageView)findViewById(R.id.WeatherICON);
        temperatureTXT = (TextView)findViewById(R.id.AmbientTemperatureTXT);
        conditionTXT = (TextView)findViewById(R.id.ConditionTXT);
        cityTXT = (TextView)findViewById(R.id.CityTXT);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        service.refreshWeather("Warsaw, PL");
        Button button = (Button) v;
    }
    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();

        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);

        WeatherICON.setImageDrawable(weatherIconDrawable);
        conditionTXT.setText(item.getCondition().getDescription());
        cityTXT.setText(service.getLocation());
        temperatureTXT.setText(item.getCondition().getTemperature()+"\u00B0"+channel.getUnits().getTemperature());
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.setMessage("No connection!");

       }
}
