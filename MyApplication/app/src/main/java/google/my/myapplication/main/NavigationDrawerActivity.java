package google.my.myapplication.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import google.my.myapplication.R;
import google.my.myapplication.favourite.FavouriteActivity;
import google.my.myapplication.home.Holiday;
import google.my.myapplication.home.HolidayAdapter;
import google.my.myapplication.trip.NewTripActivity;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerViewHolidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), NewTripActivity.class));
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        initView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
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

        if (id == R.id.nav_home) {
            // Handle the camera action
            NavigationDrawerActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contentID,TripRecyclerView.newInstance()).commit();
        } else if (id == R.id.nav_favourite) {
            NavigationDrawerActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contentID,FavouriteActivity.newInstance()).commit();
        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_contact) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void initView() {
        mRecyclerViewHolidays = findViewById(R.id.recyclerview_holidays);

        //set the layout manager for the current recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewHolidays.setLayoutManager(layoutManager);

        //create the adapter
        HolidayAdapter holidayAdapter = new HolidayAdapter(getHolidaysList());

        //set the adapter to the recycler view
        mRecyclerViewHolidays.setAdapter(holidayAdapter);

        mRecyclerViewHolidays.addOnItemTouchListener(new RecyclerTouchListener(this,
                mRecyclerViewHolidays, new HolidayClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Toast.makeText(NavigationDrawerActivity.this, getString(R.string.single_click) + position,
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(NavigationDrawerActivity.this, getString(R.string.long_click) + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }

    //get the data source
    private List<Holiday> getHolidaysList() {
        List<Holiday> holidays = new ArrayList<>();
        Holiday holiday1 = new Holiday("Spring 2015", "Italy", "4.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday2 = new Holiday("Summer 2015", "Bora Bora", "5.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday3 = new Holiday("Winter 2015", "Switzerland", "4.5/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday4 = new Holiday("Summer 2016", "Italy", "3.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday5 = new Holiday("Winter 2016", "Romania", "4.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday6 = new Holiday("Summer 2017", "Spain", "5.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday7 = new Holiday("Winter 2017", "USA", "5.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday8 = new Holiday("Spring 2018", "Greece", "4.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday9 = new Holiday("Summer 2018", "Bulgaria", "3.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday10 = new Holiday("Winter 2018", "Poland", "3.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        holidays.add(holiday1);
        holidays.add(holiday2);
        holidays.add(holiday3);
        holidays.add(holiday4);
        holidays.add(holiday5);
        holidays.add(holiday6);
        holidays.add(holiday7);
        holidays.add(holiday8);
        holidays.add(holiday9);
        holidays.add(holiday10);
        return holidays;
    }
}
