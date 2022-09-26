package whatsapp.clone.azka.noreen;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ChatEntity.class},version = 3)
public abstract class WhatsAppDatabase extends RoomDatabase {

    public static WhatsAppDatabase whatsAppDatabase;
    public abstract ChatDAO chatDAO();
}
