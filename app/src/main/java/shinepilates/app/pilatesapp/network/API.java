package shinepilates.app.pilatesapp.network;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;
import java.util.Map;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import shinepilates.app.pilatesapp.model.UserModel;
import shinepilates.app.pilatesapp.objects.NewsItem;
import shinepilates.app.pilatesapp.objects.Notification;
import shinepilates.app.pilatesapp.objects.Report;
import shinepilates.app.pilatesapp.objects.TrenersItem;
import shinepilates.app.pilatesapp.objects.User;

public interface API {

    //users
    @GET("users")
    Call<List<User>> getAll();

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

    @DELETE("/reports")
    Call<Report> deleteReport(@Body Report report);

    //notifications
    @POST("/notifications/{userId}")
    Call<Notification> postNotification(@Body Notification notification, @Path("userId") Long userId);

    @PUT("/notifications/{id}")
    Call<Notification> updateNotification(@Path("id") Long id);

    @DELETE("/notifications")
    Call deleteNotification(@Body Notification notification);

    //news
    @GET("news")
    Call<List<NewsItem>> getNews();

    @POST("news")
    Call<NewsItem> postNews(@Body NewsItem news);

    @DELETE("/news")
    Call<NewsItem> deleteNews(@Body NewsItem news);

    //treners
    @GET("treners")
    Call<List<TrenersItem>> getTreners();

    @POST("treners")
    Call<TrenersItem> postTreners(@Body TrenersItem treners);

    @DELETE("/treners")
    Call<TrenersItem> deleteTreners(@Body TrenersItem treners);
}