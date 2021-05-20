package shinepilates.app.pilatesapp.objects;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserModelRoom.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDAO getUserDao();

    private static UserDataBase instance;

    static UserDataBase getDatabase (final Context context){
        if (instance == null){
            synchronized (UserDataBase.class){
                instance = Room.databaseBuilder(context, UserDataBase.class, "DATABASE").build();
            }
        }
        return instance;
    }
}
