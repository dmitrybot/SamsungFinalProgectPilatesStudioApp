package shinepilates.app.pilatesapp;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.webkit.RenderProcessGoneDetail;
import android.widget.TextView;

import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.fragments.AddReportFragment;
import shinepilates.app.pilatesapp.fragments.ReportFragment;
import shinepilates.app.pilatesapp.objects.NewsItem;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;

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
    private ArrayList<TrenersItem> TrenersList = new ArrayList<>();
    private ArrayList<NewsItem> NewsList =  new ArrayList<>();
    private ArrayList<Report> Reports = new ArrayList<>();
    private ArrayList<Notification> Notifications = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(drawer.LOCK_MODE_LOCKED_CLOSED);
        generateUser();
        addTreners();
        addNews();
        addReports();
        addNotifications();
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

    public void addTreners(){
        TrenersList = new ArrayList<>();
        TrenersList.add( new TrenersItem(R.drawable.ic_android_test, "Карпов Евгений", "Главный Тренер", "Мужик впринципе хороший, тренерует неплохо, но задолбал студаки забирать."));
        TrenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem(R.drawable.ic_android_test, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem(R.drawable.ic_icon_test, "Name", "position", "description"));
    }

    public ArrayList<TrenersItem> getTreners(){
        return TrenersList;
    }

    public void addNews(){
        NewsList = new ArrayList<>();
        NewsList.add( new NewsItem(R.drawable.ic_android_test, "date1", "tag", "main_text"));
        NewsList.add( new NewsItem(0, "date2", "tag", "main_text"));
        NewsList.add( new NewsItem(R.drawable.ic_android_test, "date3", "tag", "main_text"));
        NewsList.add( new NewsItem(0, "date4", "tag", "main_text"));
        NewsList.add( new NewsItem(R.drawable.ic_android_test, "date5", "tag", "main_text"));
        NewsList.add( new NewsItem(R.drawable.ic_android_test, "date6", "tag", "main_text"));
        NewsList.add( new NewsItem(R.drawable.ic_android_test, "date7", "tag", "main_text"));
        NewsList.add( new NewsItem(R.drawable.ic_android_test, "date8", "tag2", "main_text"));
    }

    public ArrayList<NewsItem> getNews(){
        return NewsList;
    }

    public void addReports(){
        Reports = new ArrayList<>();
        Reports.add(new Report("name1", "date1", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 1"));
        Reports.add(new Report("name2", "date2", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 2"));
        Reports.add(new Report("name3", "date3", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 3"));
        Reports.add(new Report("name4", "date4", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 4"));
        Reports.add(new Report("name5", "date5", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 555"));
    }

    public ArrayList<Report> getReports(){
        return Reports;
    }

    public void addNotifications(){
        Notifications = new ArrayList<>();
        Notifications.add(new Notification( "date1", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 1"));
        Notifications.add(new Notification("date2", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 2"));
        Notifications.add(new Notification("date3", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 3"));
        Notifications.add(new Notification("date4", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 444"));
        Notifications.add(new Notification("date5", "Texttttttttttttttttttttttttttttttt" +
                "tttttttttttttt ttttttttttttttttttttttttttt tttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "tttttttttttttttttttttttttttttttttttttttt tttttttttttttttttttttttttt tttttttttttttttttttttttttttttttt 555"));
    }

    public ArrayList<Notification> getNotifications(){
        return Notifications;
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

    /*public void Addclick (MenuItem item){
        Layout layout;
        AddReportFragment SF = new AddReportFragment();
        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.replace(R.id.drawer_layout, SF);
        FT.commit();
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

    private void generateUser(){

    }

}
