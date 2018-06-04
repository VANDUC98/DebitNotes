package com.hdpsolution.debitnotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hdpsolution.debitnotes.adapter.AdapterMoneyTake;
import com.hdpsolution.debitnotes.fragment.Fragment_Chart;
import com.hdpsolution.debitnotes.fragment.Fragment_Give;
import com.hdpsolution.debitnotes.fragment.Fragment_profit;
import com.hdpsolution.debitnotes.model.Data;

import java.util.ArrayList;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterMoneyTake adapterMoneyTake;
    private ArrayList<Data> dataArrayList;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_take:
                    switchToFragmentProfit();
                    break;
                case R.id.nav_give:
                    switchToFragmentGive();

                    break;
                case R.id.nav_chart:
                    switchToFragmentChart();
                    break;
            }
            return true;
        }

    };


    private void switchToFragmentProfit() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.my_layout, new Fragment_profit()).commit();
    }
    private void switchToFragmentGive() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.my_layout, new Fragment_Give()).commit();
    }
    private void switchToFragmentChart() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.my_layout, new Fragment_Chart()).commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        switchToFragmentProfit();
    }

    private void loadList() {
    adapterMoneyTake=new AdapterMoneyTake(getApplicationContext(),dataArrayList);
    recyclerView.setAdapter(adapterMoneyTake);
    adapterMoneyTake.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
