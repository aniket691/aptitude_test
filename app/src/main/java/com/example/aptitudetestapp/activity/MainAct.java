package com.example.aptitudetestapp.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.example.aptitudetestapp.ExampleDialog;
import com.example.aptitudetestapp.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aptitudetestapp.databinding.ActivityMain2Binding;

public class MainAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        ExampleDialog.ExampleDialogListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.startTestFragment, R.id.showScoreFragment)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                break;

            case R.id.exit:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (navController.getCurrentDestination().getId() == R.id.nav_home) {
            openDialog();
        } else if (navController.getCurrentDestination().getId() == R.id.showScoreFragment) {
            navController.navigate(R.id.startTestFragment);
        } else {
            finish();
        }
    }

    public void openDialog() {

        ExampleDialog exampleDialog = new ExampleDialog(navController);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String username, String password) {
        Toast.makeText(getApplicationContext(), username, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();
    }
}