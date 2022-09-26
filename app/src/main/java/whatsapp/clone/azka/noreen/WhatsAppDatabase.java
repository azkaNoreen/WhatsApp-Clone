package whatsapp.clone.azka.noreen;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import whatsapp.clone.azka.noreen.callhistory.CallHistoryDAO;
import whatsapp.clone.azka.noreen.callhistory.CallHistoryEntity;

@Database(entities = {ChatEntity.class, CallHistoryEntity.class},version = 5)
public abstract class WhatsAppDatabase extends RoomDatabase {

    public static WhatsAppDatabase whatsAppDatabase;
    public abstract ChatDAO chatDAO();
    public abstract CallHistoryDAO callHistoryDAO();

}
