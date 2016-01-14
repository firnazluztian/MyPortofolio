package com.firnazluztian.myportofolio;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firnazluztian.myportofolio.fragments.ContactMeFragment;
import com.firnazluztian.myportofolio.fragments.ProfileFragment;
import com.firnazluztian.myportofolio.fragments.SendEmailFragment;
import com.firnazluztian.myportofolio.fragments.SkillsFragment;
import com.firnazluztian.myportofolio.fragments.WorksFragment;

public class NavigationProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set menu title
        toolbarTitle = (TextView)findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Profile");

        // set font title toolbar
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");
        toolbarTitle.setTypeface(myCustomFont);

        // default display profile fragment
        FragmentManager fm;
        FragmentTransaction ft;
        ProfileFragment profileFragment = new ProfileFragment();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.flfragment,profileFragment).commit();

        // floating button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] receiver = {"firnazadinasyah@gmail.com"};
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, receiver);
                    Intent mailer = Intent.createChooser(intent, "Send email to Developer using:");
                    startActivity(mailer);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(NavigationProfileActivity.this, "the necessary application could not be found ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.navigation_profile, menu);
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

            // do direct users to google play
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ooops")
                    .setMessage("Do you want to be directed to GooglePlay?");
            builder.setPositiveButton(
                    "Yes Please",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // direct to google play
                            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=firnaz luztian&c=apps" + appPackageName)));
                            } catch (android.content.ActivityNotFoundException e) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                            }
                        }
                    });

            builder.setNegativeButton(
                    "Stay",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        switch (id) {
            case R.id.nav_profile:
                fragmentClass = ProfileFragment.class;
                // set title
                toolbarTitle.setText("Profile");
                break;
            case R.id.nav_skills:
                fragmentClass = SkillsFragment.class;
                // set title
                toolbarTitle.setText("Technical Skills");
                break;
            case R.id.nav_works:
                fragmentClass = WorksFragment.class;
                // set title
                toolbarTitle.setText("Projects");
                break;
            case R.id.nav_contact:
                fragmentClass = ContactMeFragment.class;
                // set title
                toolbarTitle.setText("Social Media");
                break;
            case R.id.nav_send:
                fragmentClass = SendEmailFragment.class;
                // set title
                toolbarTitle.setText("Send me an email!");
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flfragment, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
