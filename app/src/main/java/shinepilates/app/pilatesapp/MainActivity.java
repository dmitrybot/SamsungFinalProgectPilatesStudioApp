package shinepilates.app.pilatesapp;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.webkit.RenderProcessGoneDetail;
import android.widget.TextView;

import shinepilates.app.pilatesapp.R;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    private static MainActivity instance;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(drawer.LOCK_MODE_LOCKED_CLOSED);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_app_info,R.id.nav_news, R.id.nav_notifications, R.id.nav_report, R.id.nav_maps, R.id.nav_treners, R.id.nav_contacts
                , R.id.nav_homepage, R.id.nav_timetable, R.id.nav_welcom)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                int id = destination.getId();
                switch (id){
                    case R.id.nav_welcom:
                        toolbar.setVisibility(View.GONE);
                        break;
                    default:
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        Menu menu = navigationView.getMenu();
        new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                  navController.navigate(R.id.nav_news);
              }
          }, 8000);
    }


    /*@Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }*/


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.extra_menu, menu);
        return true;
    }*/



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public static MainActivity getInstance() {
        return instance;
    }

    public void goToFragment(int resId){
        navController.navigate(resId);
    }

    /*@Override
    public boolean onOptionsItemSelected (MenuItem item){
        NavController navController = Navigation.findNavController(this, R.id.welcom_image);
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }*/

}
