package whatsapp.clone.azka.noreen;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface ChatDAO {
    @Insert
    void insertChat(ChatEntity chat);

//    @Delete
//    void deleteStudent(StudentEntity student);

    @Query("SELECT * FROM ChatEntity")
    List<ChatEntity> getAll();
}
