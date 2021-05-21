package shinepilates.app.pilatesapp.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import shinepilates.app.pilatesapp.model.UserModel;
import shinepilates.app.pilatesapp.objects.Abonement;
import shinepilates.app.pilatesapp.objects.NewsItem;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;
import shinepilates.app.pilatesapp.objects.TrenersItem;
import shinepilates.app.pilatesapp.objects.User;

public interface API {

    //users
    @GET("users")
    default Call<List<User>> getAll() {
        return null;
    }

    @POST("user")
    Call<User> getUser(@Body User user);

    @POST("users")
    Call<User> postUser(@Body User user);

    @DELETE("/users/{id}")
    Call<User> deleteUser(@Path("id") Long id);

    @PUT("/users")
    Call<User> updateUser(@Body UserModel user);

    //reports
    @GET("reports")
    Call<List<Report>> getReports();

    @POST("reports")
    Call<Report> postReport(@Body Report report);

    @DELETE("/reports/{id}")
    Call<Report> deleteReport(@Path("id") Long id);

    //notifications
    @POST("/notifications/{userId}")
    Call<Notification> postNotification(@Body Notification notification, @Path("userId") Long userId);

    @PUT("/notifications/{id}")
    Call<Notification> updateNotification(@Path("id") Long id);

    @DELETE("/notifications/{id}")
    Call<Notification> deleteNotification(@Path("id") Long id);

    @GET("/notifications/{id}")
    Call<List<Notification>> getNotifications(@Path("id") Long id);

    //news
    @GET("news")
    Call<List<NewsItem>> getNews();

    @POST("news")
    Call<NewsItem> postNews(@Body NewsItem news);

    @DELETE("/news/{id}")
    Call<NewsItem> deleteNews(@Path("id") Long id);

    //treners
    @GET("treners")
    Call<List<TrenersItem>> getTreners();

    @POST("treners")
    Call<TrenersItem> postTreners(@Body TrenersItem treners);

    @DELETE("/treners/{id}")
    Call<TrenersItem> deleteTreners(@Path("id") Long id);

    //abonements
    @POST("/abonements/{userId}")
    Call<Abonement> postAbonement(@Body Abonement abonement, @Path("id") Long userId);

    @DELETE("/abonements/{id}")
    Call<Abonement> deleteAbonement(@Path("id") Long id);

    @PUT("/abonements/{id}")
    Call<Abonement> updateAbonement(@Path("id") Long id);
}