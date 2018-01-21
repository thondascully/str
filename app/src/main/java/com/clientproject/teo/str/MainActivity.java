
package com.clientproject.teo.str;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.support.design.widget.NavigationView;

import android.widget.Toast;

import com.clientproject.teo.str.ChatApplication.ChatActivity;
import com.clientproject.teo.str.DrawerFragment.FieldActivity;
import com.clientproject.teo.str.DrawerFragment.HomeActivity;
import com.clientproject.teo.str.DrawerFragment.ManualActivity;
import com.clientproject.teo.str.DrawerFragment.PlaybookActivity;
import com.clientproject.teo.str.DrawerFragment.ScheduleActivity;
import com.clientproject.teo.str.DrawerFragment.WrongActivity;

public class MainActivity extends AppCompatActivity
        //Note : OnFragmentInteractionListener of all the fragments
        implements

        NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //NOTE:  Checks first item in the navigation drawer initially
        //navigationView.setCheckedItem(R.id.nav_home);

        //NOTE:  Open fragment1 initially.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.screen_area, new HomeActivity());
        ft.commit();


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "You are now Home.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Toast.makeText(getApplicationContext(), "Working on it.",
                        Toast.LENGTH_SHORT).show();
                Button homeButton = (Button) findViewById(R.id.homeButton);
                homeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                    }
                });

            }
        });

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




    public void onFragmentInteraction(String title) {
        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(title);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
           fragment = new HomeActivity();
        } else if (id == R.id.nav_playbook) {
            fragment = new PlaybookActivity();
        } else if (id == R.id.nav_schedule) {
            fragment = new ScheduleActivity();
        } else if (id == R.id.nav_field) {
            fragment = new FieldActivity();
        } else if (id == R.id.nav_wrong) {
            fragment = new WrongActivity();
        } else if (id == R.id.nav_manual) {
            fragment = new ManualActivity();
        } else if (id == R.id.nav_chat) {
            fragment = new ChatActivity();
        }

        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area, fragment);

            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
