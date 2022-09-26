package whatsapp.clone.azka.noreen.callhistory;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import whatsapp.clone.azka.noreen.ChatEntity;

@Dao
public interface CallHistoryDAO {
    @Insert
    void insertCallHistory(CallHistoryEntity callHistoryEntity);

//    @Delete
//    void deleteStudent(StudentEntity student);

    @Query("SELECT * FROM CallHistoryEntity")
    List<CallHistoryEntity> getAll();
}
