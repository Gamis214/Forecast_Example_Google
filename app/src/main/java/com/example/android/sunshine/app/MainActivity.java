package com.example.android.sunshine.app;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.sunshine.app.recyclerItemClick.itemClick;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.listview_forecast);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        List<String> weekForecast = new ArrayList<>();
        weekForecast.add("Today - Sunny - 88 / 63");
        weekForecast.add("Tomorrow - Foggy - 70 / 46");
        weekForecast.add("Weds - Cloudy - 72 / 63");
        weekForecast.add("Thurs - Rainy - 64 / 51");
        weekForecast.add("Fri - Foggy - 70 / 46");
        weekForecast.add("Sat - Sunny - 76 / 68");

        AdapterWeekForecast adapter = new AdapterWeekForecast(this,weekForecast,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // Implementacion de onClick a un Recycler
        /*recyclerView.addOnItemTouchListener(new itemClick(this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(getApplicationContext(),"On Click",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View v, int position) {
                Toast.makeText(getApplicationContext(),"Looooong Click",Toast.LENGTH_SHORT).show();
            }
        }) {
        });*/

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        TextView txt = (TextView) v.findViewById(R.id.list_item_forecast_textview);
        Toast.makeText(this,txt.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    /**
     * Interface para la implementacion de OnClick
     */
    /*public interface ClickListener{
        void onClick(View v,int position);
        void onLongClick(View v,int position);
    }*/

}
