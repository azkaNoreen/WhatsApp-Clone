package whatsapp.clone.azka.noreen;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="person_name")
    public String personName;

    @ColumnInfo(name="message_detail")
    public String messageDetail;

    @ColumnInfo(name="time")
    public Long time;

    public ChatEntity() {
    }

    public ChatEntity(String personName, String messageDetail, Long time) {
        this.personName = personName;
        this.messageDetail = messageDetail;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }



}
