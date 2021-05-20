package shinepilates.app.pilatesapp.objects;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM UserModelRoom ")
    UserModelRoom getUser ();

    @Insert
    void insert (UserModelRoom user);

    @Update
    void update (UserModelRoom user);

    @Delete
    void delete (UserModelRoom user);



}
