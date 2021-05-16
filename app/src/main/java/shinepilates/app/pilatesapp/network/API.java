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
import shinepilates.app.pilatesapp.objects.User;

public interface API {
    @GET("users")
    Call<List<User>> getAll();

    @POST("user")
    Call<User> getUser(@Body User user);

    @POST("users/")
    Call<User> postUser(@Body User user);

    @DELETE("/users/{id}")
    Call<User> deleteUser(@Path("id") Long id);

    @PUT("/users")
    Call<User> updateUser(@Body UserModel user);
}