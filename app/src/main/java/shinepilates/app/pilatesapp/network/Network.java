package shinepilates.app.pilatesapp.network;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
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
import shinepilates.app.pilatesapp.objects.User;

public class Network {
    Retrofit retrofit;
    API api;

    public Network() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:8080/")
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
                /*Message msg = new Message();

                msg.obj = response.body();
                handler.sendMessage(msg);*/
                User u = response.body();
                if (u.getPhone().equals("phone") || u.getPhone().equals("password")){
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
    /*
    public void deleteEmployee(Employee employee, Handler handler) {
        api.deleteEmployee(employee.getId()).enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                getEmployees(handler);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }*/

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
}
