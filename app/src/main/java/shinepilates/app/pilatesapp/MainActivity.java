package shinepilates.app.pilatesapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;

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
import androidx.room.Room;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import shinepilates.app.pilatesapp.network.Network;
import shinepilates.app.pilatesapp.objects.MapItem;
import shinepilates.app.pilatesapp.objects.NewsItem;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;
import shinepilates.app.pilatesapp.objects.TrenersItem;
import shinepilates.app.pilatesapp.objects.User;
import shinepilates.app.pilatesapp.objects.UserDAO;
import shinepilates.app.pilatesapp.objects.UserDataBase;
import shinepilates.app.pilatesapp.objects.UserModelRoom;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    private static MainActivity instance;
    private NavController navController;
    private ArrayList<TrenersItem> TrenersList = new ArrayList<>();
    private ArrayList<NewsItem> NewsList =  new ArrayList<>();
    private ArrayList<Report> Reports = new ArrayList<>();
    private ArrayList<Notification> Notifications = new ArrayList<>();
    private ArrayList<MapItem> Map = new ArrayList<>();
    private  ArrayList<User> users = new ArrayList<>();
    UserDAO db;
    UserDataBase dataBase;
    UserModelRoom UserModelRoom;
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
        dataBase = Room.databaseBuilder(this, UserDataBase.class, "User")
                .allowMainThreadQueries().build();
        db = dataBase.getUserDao();
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
        if (db.getUser() != null){
            network.getUser(user);
        }
    }




    public void addTreners(){
        network.getTreners();
    }

    public ArrayList<TrenersItem> getTreners(){
        return TrenersList;
    }

    public void addTrener (TrenersItem trenersItem){
        network.postTreners(trenersItem);
    }

    public void deleteTrener(TrenersItem trenersItem){
        network.deleteTreners(trenersItem);
    }

    public void addMap(){
        Map = new ArrayList<>();
        Map.add (new MapItem("Студия на проспекте Вернадского", "Студия ShinePilates Москва, Ул.Каштоянца, Д.8, К.1", R.drawable.ic_android_test));
        Map.add (new MapItem("Студия на проспекте Вернадского 2", "Студия ShinePilates Москва, Ул.Каштоянца, Д.6, К.1", R.drawable.ic_android_test));
    }

    public ArrayList<MapItem> getMap(){
        return Map;
    }

    public void addNews(){
        network.getNews();
    }

    public ArrayList<NewsItem> getNews(){
        return NewsList;
    }

    public void addNew(NewsItem news){
        network.postNews(news);
    }

    public void deleteNews(NewsItem news){
        network.deleteNews(news);
    }

    public void deleteNotification(Notification notification){
        network.deleteNotification(notification);
    }

    public void addReports(){
        network.getReports();
    }

    public void deleteReport(Report report){
        network.deleteReport(report);
    }

    public void addReport(Report report){
        network.postReport(report);

    }

    public ArrayList<Report> getReports(){
        return Reports;
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

    public void addUserModel(String firstName, String secondName, String lastName, String password, String email, String phone, int role, String birthData, String sex) {
        UserModelRoom = new UserModelRoom(firstName, secondName, lastName, password,email, phone, role, birthData, sex);
        db.insert(UserModelRoom);
    }

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
        addUsers();
        addMap();
    }

    public UserDataBase getDataBase (){
        return dataBase;
    }

    public UserModelRoom getUserModelRoom(){
        return UserModelRoom;
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
        User u = new User(user.getId(), firstName, secondName, lastName, Password, Email, Phone, role, birthData, sex, user.getNotifications(), user.getAbonement());
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

    public void setNotifications(List<Notification> notifications){
        user.setNotifications(notifications);
    }

    public void updateNotifications(){
        network.getNotifications(user);
    }

}
