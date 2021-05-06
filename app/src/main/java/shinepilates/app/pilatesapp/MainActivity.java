package shinepilates.app.pilatesapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;

import shinepilates.app.pilatesapp.objects.NewsItem;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;
import shinepilates.app.pilatesapp.objects.TrenersItem;
import shinepilates.app.pilatesapp.objects.User;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    private static MainActivity instance;
    private NavController navController;
    private ArrayList<TrenersItem> TrenersList = new ArrayList<>();
    private ArrayList<NewsItem> NewsList =  new ArrayList<>();
    private ArrayList<Report> Reports = new ArrayList<>();
    private ArrayList<Notification> Notifications = new ArrayList<>();
    private  ArrayList<User> users = new ArrayList<>();
    User user;
    boolean bdcheck = false;

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

    public void addUsers(){
        users = new ArrayList<>();
        users.add(user = new User("d1", "t", "m", "p1", "e", "+7", 1, "10.20.39", "0"));
        users.add(user = new User("d2", "t", "m", "p2", "e", "+7", 2, "10.20.39", "0"));
        users.add(user = new User("d3", "t", "m", "p3", "e", "+7", 1, "10.20.39", "0"));
        users.add(user = new User("d4", "t", "m", "p4", "e", "+7", 1, "10.20.39", "0"));
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public User getUser(){
        return user;
    }

    public void addUser(String phone, String password){
        User u = new User(phone, password);
        users.add(u);
        user = u;
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
        if (bdcheck){
            getDataFromBD();
        } else {
            user = new User();
        }
        addTreners();
        addNews();
        addReports();
        addNotifications();
        addUsers();
    }

    private void getDataFromBD(){}

    public void Exit(){
        user = new User();
        Reports.clear();
    }

    public void updateUser(String firstName, String secondName, String lastName, String Password, String Email, String Phone, int role, String birthData, String sex){
        user = new User(firstName, secondName, lastName, Password, Email, Phone, role, birthData, sex);
    }
    public void updateUser(){
        user = new User();
    }
    public void updateUser(User u){
        user = u;
    }

}
