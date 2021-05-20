package shinepilates.app.pilatesapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;

import shinepilates.app.pilatesapp.network.Network;
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
import java.util.List;

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

    Network network;

    boolean bdcheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        instance = this;

        network = new Network();

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

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                generateUser();
                navController.navigate(R.id.nav_news);
            }
        });
    }


    public void addTreners(){
        TrenersList = new ArrayList<>();
        TrenersList.add( new TrenersItem((long) 1, "Карпов Евгений", "Главный Тренер", "NICEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"));
        TrenersList.add( new TrenersItem((long) 2, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem((long) 3, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem((long) 4, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem((long) 5, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem((long) 6, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem((long) 7, "Имя", "Позиция", "Описание"));
        TrenersList.add( new TrenersItem((long) 8, "Name", "position", "description"));
    }

    public ArrayList<TrenersItem> getTreners(){
        return TrenersList;
    }

    public void addNews(){
        NewsList = new ArrayList<>();
        NewsList.add( new NewsItem((long) 1, "date1", "tag", "main_text"));
        NewsList.add( new NewsItem((long) 2, "date2", "tag", "main_text"));
        NewsList.add( new NewsItem((long) 3, "date3", "tag", "main_text"));
        NewsList.add( new NewsItem((long) 4, "date4", "tag", "main_text"));
    }

    public ArrayList<NewsItem> getNews(){
        return NewsList;
    }

    public void addReports(){
        network.getReports();
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
        network.getUsers();
    }

    public ArrayList<User> getUsers(){
        return users;
    }


    public void addUser(String phone, String password){
        User u = new User(phone, password);
        user = u;
        network.postUser(u);

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
        //Reports.clear();
    }

    public void updateUser(String firstName, String secondName, String lastName, String Password, String Email, String Phone, int role, String birthData, String sex){
        String s = "-";
        if (!user.getPhone().equals(Phone)){
            s = user.getPhone();
        }
        User u = new User(user.getId(), firstName, secondName, lastName, Password, Email, Phone, role, birthData, sex, user.getNotifications());
        network.updateUser(u, s);
    }
    public void updateUser(){
        user = new User();
    }
    public void updateUser(User u){
        user = u;
    }

    int C(){
        return users.size();
    }

    public void setUsers(List<User> u){
        users = (ArrayList) u;
    }

    public void setUser(User u){
        user = u;
    }

    public User getUser(){
        return user;
    }

    public void Authorisation(String phone, String password){
        User u = new User(phone, password);
        network.getUser(u);
    }

    public void setReports(List<Report> r){
        Reports = (ArrayList) r;
    }

    public void setNews(List<NewsItem> news){
        NewsList = (ArrayList) news;
    }

    public void setTreners(List<TrenersItem> treners){
        TrenersList = (ArrayList) treners;
    }
}
