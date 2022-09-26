package whatsapp.clone.azka.noreen.callhistory;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CallHistoryEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="person_name")
    public String personName;

    @ColumnInfo(name="call_type")
    public String callType;

    @ColumnInfo(name="call_duration")
    public String callDuration;

    @ColumnInfo(name="call_date")
    public Long callDate;

    public CallHistoryEntity() {
    }

    public CallHistoryEntity(String personName, String callType, String callDuration, Long callDate) {
        this.personName = personName;
        this.callType = callType;
        this.callDuration = callDuration;
        this.callDate = callDate;
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

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public Long getCallDate() {
        return callDate;
    }

    public void setCallDate(Long callDate) {
        this.callDate = callDate;
    }
}
