package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.facebook.account.Login;
import com.example.facebook.ui.home.HomeFragment;
import com.example.facebook.ui.sports.ItemFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.facebook.databinding.ActivityHomeBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = binding.appBarHome.toolbar;
        setSupportActionBar(toolbar);
        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        drawer = binding.drawerLayout;
        navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);

        }

//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home,
//                R.id.nav_gallary,
//                R.id.nav_slideshow,
//                R.id.nav_sports,
//                R.id.nav_movies
//        )
//                .setOpenableLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (R.id.nav_home == item.getItemId()) {

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (R.id.nav_home == item.getItemId()) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);


        } else if (R.id.nav_logout == item.getItemId()) {
            FirebaseAuth.getInstance().signOut();
            Intent  intent = new Intent(this, Login.class);
            startActivity(intent);


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}