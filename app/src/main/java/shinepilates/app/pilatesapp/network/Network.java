package shinepilates.app.pilatesapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shinepilates.app.pilatesapp.MainActivity;
import shinepilates.app.pilatesapp.R;
import shinepilates.app.pilatesapp.fragments.AuthorizationFragment;
import shinepilates.app.pilatesapp.fragments.HomePageFragment;
import shinepilates.app.pilatesapp.fragments.OwnDataFragment;
import shinepilates.app.pilatesapp.fragments.RegistrationFragment;
import shinepilates.app.pilatesapp.model.UserModel;
import shinepilates.app.pilatesapp.objects.Abonement;
import shinepilates.app.pilatesapp.objects.NewsItem;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;
import shinepilates.app.pilatesapp.objects.TrenersItem;
import shinepilates.app.pilatesapp.objects.User;
import shinepilates.app.pilatesapp.objects.UserDAO;
import shinepilates.app.pilatesapp.objects.UserDataBase;
import shinepilates.app.pilatesapp.objects.UserModelRoom;

public class Network {
    Retrofit retrofit;
    API api;
    UserDAO db;
    UserDataBase dataBase;
    UserModelRoom userModelRoom;


    public Network() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://samsung-final-project.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.api = retrofit.create(API.class);
    }

    public void getUsers() {
        Call<List<User>> call = api.getAll();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                /*Message msg = new Message();

                msg.obj = response.body();
                handler.sendMessage(msg);*/
                MainActivity.getInstance().setUsers(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getUser(User user) {
        Call<User> call = api.getUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User u = response.body();
                if (u.getPhone().equals("phone") || u.getPhone().equals("password")){ ///
                    AuthorizationFragment.getInstance().AuthFalse(u);
                } else {
                    AuthorizationFragment.getInstance().AuthRight(u);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void postUser(User user) {
        api.postUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User s = response.body();
                if (s.getFirstName().equals("Пользователь успешно сохранен")){
                    getUsers();
                    HomePageFragment.getInstance().generate();
                    MainActivity.getInstance().goToFragment(R.id.nav_homepage);
                } else {
                    MainActivity.getInstance().Exit();
                    RegistrationFragment.getInstance().wrongTry(s.getFirstName());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                MainActivity.getInstance().Exit();
                t.printStackTrace();
            }
        });
    }

    public void updateUser(User user, String s){
        UserModel userModel = user.UserToModel(s);
        api.updateUser(userModel).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User ss = response.body();
                if (!ss.getPhone().equals("-")){
                    getUsers();
                    MainActivity.getInstance().setUser(ss);
                    HomePageFragment.getInstance().updateUser();
                    MainActivity.getInstance().goToFragment(R.id.nav_homepage);
                } else {
                    MainActivity.getInstance().Exit();
                    OwnDataFragment.getInstance().setPhoneExeption();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    /* ------------------------------------------------------------------------------------
    reports
     ---------------------------------------------------------------------------------------*/
    public void getReports() {
        Call<List<Report>> call = api.getReports();
        call.enqueue(new Callback<List<Report>>() {
            @Override
            public void onResponse(Call<List<Report>> call, Response<List<Report>> response) {
                MainActivity.getInstance().setReports(response.body());
            }

            @Override
            public void onFailure(Call<List<Report>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void postReport(Report report) {
        api.postReport(report).enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {
                getReports();
                MainActivity.getInstance().goToFragment(R.id.nav_report);
            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteReport(Report report) {
        System.out.println(report.getId());
        api.deleteReport(report.getId()).enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {

            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    /* ------------------------------------------------------------------------------------
    notifications
     ---------------------------------------------------------------------------------------*/

    public void getNotifications(User user) {
        Call<List<Notification>> call = api.getNotifications(user.getId());
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                MainActivity.getInstance().setNotifications(response.body());
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void postNotification(Notification notification, User user) {
        api.postNotification(notification, user.getId()).enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {
                // body
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteNotification(Notification notification) {
        api.deleteNotification(notification.getId()).enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {
                //body
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void updateNotification(Notification notification){
        api.updateNotification(notification.getId()).enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {
                //body
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    /* ------------------------------------------------------------------------------------
    news
     ---------------------------------------------------------------------------------------*/

    public void getNews() {
        Call<List<NewsItem>> call = api.getNews();
        call.enqueue(new Callback<List<NewsItem>>() {
            @Override
            public void onResponse(Call<List<NewsItem>> call, Response<List<NewsItem>> response) {
                MainActivity.getInstance().setNews(response.body());
            }

            @Override
            public void onFailure(Call<List<NewsItem>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void postNews(NewsItem news) {
        api.postNews(news).enqueue(new Callback<NewsItem>() {
            @Override
            public void onResponse(Call<NewsItem> call, Response<NewsItem> response) {
                getNews();
                MainActivity.getInstance().goToFragment(R.id.nav_news);
            }

            @Override
            public void onFailure(Call<NewsItem> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteNews(NewsItem news) {
        api.deleteNews(news.getId()).enqueue(new Callback<NewsItem>() {
            @Override
            public void onResponse(Call<NewsItem> call, Response<NewsItem> response) {

            }

            @Override
            public void onFailure(Call<NewsItem> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    /* ------------------------------------------------------------------------------------
    treners
     ---------------------------------------------------------------------------------------*/

    public void getTreners() {
        Call<List<TrenersItem>> call = api.getTreners();
        call.enqueue(new Callback<List<TrenersItem>>() {
            @Override
            public void onResponse(Call<List<TrenersItem>> call, Response<List<TrenersItem>> response) {
                MainActivity.getInstance().setTreners(response.body());
            }

            @Override
            public void onFailure(Call<List<TrenersItem>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void postTreners(TrenersItem treners) {
        api.postTreners(treners).enqueue(new Callback<TrenersItem>() {
            @Override
            public void onResponse(Call<TrenersItem> call, Response<TrenersItem> response) {
                getTreners();
                MainActivity.getInstance().goToFragment(R.id.nav_treners);
            }

            @Override
            public void onFailure(Call<TrenersItem> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteTreners(TrenersItem treners) {
        api.deleteTreners(treners.getId()).enqueue(new Callback<TrenersItem>() {
            @Override
            public void onResponse(Call<TrenersItem> call, Response<TrenersItem> response) {

            }

            @Override
            public void onFailure(Call<TrenersItem> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    /* ------------------------------------------------------------------------------------
    abonements
     ---------------------------------------------------------------------------------------*/

    public void postAbonement(Abonement abonement, User user) {
        api.postAbonement(abonement, user.getId()).enqueue(new Callback<Abonement>() {
            @Override
            public void onResponse(Call<Abonement> call, Response<Abonement> response) {

            }

            @Override
            public void onFailure(Call<Abonement> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteAbonement(Abonement abonement) {
        api.deleteAbonement(abonement.getId()).enqueue(new Callback<Abonement>() {
            @Override
            public void onResponse(Call<Abonement> call, Response<Abonement> response) {

            }

            @Override
            public void onFailure(Call<Abonement> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void updateAbonement(Abonement abonement){
        api.updateAbonement(abonement.getId()).enqueue(new Callback<Abonement>() {
            @Override
            public void onResponse(Call<Abonement> call, Response<Abonement> response) {
                //body
            }

            @Override
            public void onFailure(Call<Abonement> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
