/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.falx.tensionlog.App;
import tech.falx.tensionlog.R;
import tech.falx.tensionlog.ui.Navigator;
import tech.falx.tensionlog.ui.fragment.CalendarOverviewFragment;
import tech.falx.tensionlog.ui.fragment.EntryDetailFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    private Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Navigator.createInstance(this);
        this.navigator = Navigator.getInstance();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener((view) -> {
            this.navigator.navigateTo(new EntryDetailFragment(), true);
            ((App) this.getApplication()).setCurrentState(App.State.DETAILS);
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        // Create new fragment and transaction
        Fragment itemDetailFragment = new EntryDetailFragment();
        this.navigator.navigateTo(itemDetailFragment, true);
        ((App) getApplication()).setCurrentState(App.State.DETAILS);

    }

    @Override
    public void onBackPressed() {
        if (this.drawer.isDrawerOpen(GravityCompat.START)) {
            this.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        App app = ((App) getApplication());
        App.State state = app.getCurrentState();
        Fragment nextFragment = null;
        int titleId = -1;
        if (id == R.id.nav_today_overview && !state.equals(App.State.TODAY_OVERVIEW)) {
            app.setCurrentState(App.State.TODAY_OVERVIEW);
            nextFragment = new EntryListFragment();
            titleId = R.string.title_item_list;
        } else if (id == R.id.nav_cal_overview && !state.equals(App.State.CAL_OVERVIEW)) {
            app.setCurrentState(App.State.CAL_OVERVIEW);
            nextFragment = new CalendarOverviewFragment();
            titleId = R.string.title_calendar_overview;
        } else if (id == R.id.nav_statistics && !state.equals(App.State.STATISTICS)) {
            app.setCurrentState(App.State.STATISTICS);
            titleId = R.string.title_statistics;
        } else if (id == R.id.nav_settings && !state.equals(App.State.SETTINGS)) {
            app.setCurrentState(App.State.SETTINGS);
            titleId = R.string.title_settings;
        } else if (id == R.id.nav_share && !state.equals(App.State.SHARE)) {
            app.setCurrentState(App.State.SHARE);
            titleId = R.string.title_share;
        } else if (id == R.id.nav_send && !state.equals(App.State.SEND)) {
            app.setCurrentState(App.State.SEND);
        } else if (id == R.id.nav_export && !state.equals(App.State.EXPORT)) {
            app.setCurrentState(App.State.EXPORT);
        }

        drawer.closeDrawer(GravityCompat.START);
        if (nextFragment != null) {
            this.navigator.navigateTo(nextFragment, true);
            this.setTitle(titleId);
        }
        return true;
    }
}
