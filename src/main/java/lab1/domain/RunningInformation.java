package lab1.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.mapping.SimpleAuxiliaryDatabaseObject;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "running_analysis")
public class RunningInformation {

    public enum HealthWarningLevel{
        LOW, NORMAL, HIGH
    }
    @Id
    @GeneratedValue
    private int id;
    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private Date timestamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "username")),
            @AttributeOverride(name = "address", column = @Column(name = "address"))
    })
    private UserInfo userInfo;
    private HealthWarningLevel healthWarningLevel;

    public RunningInformation(){

    }

    @JsonCreator
    public RunningInformation(
            @JsonProperty(value = "runningId") String runningId,
            @JsonProperty(value = "latitude") String latitude,
            @JsonProperty(value = "longitude") String longitude,
            @JsonProperty(value = "runningDistance") String runningDistance,
            @JsonProperty(value = "totalRunningTime") String totalRunningTime,
            @JsonProperty(value = "heartRate") int heartRate,
            @JsonProperty(value = "timestamp") String timestamp,
            @JsonProperty(value = "userInfo") UserInfo userInfo
    ) {
        this.runningId = runningId;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTime = Double.parseDouble(totalRunningTime);
        this.heartRate = 60 + new Random().nextInt(141);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            this.timestamp = format.parse(timestamp);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            this.timestamp = new Date();
        }
        this.userInfo = userInfo;

        if (this.heartRate <= 75) {
            this.healthWarningLevel = HealthWarningLevel.LOW;
        } else if (this.heartRate <= 120) {
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
        } else {
            this.healthWarningLevel = HealthWarningLevel.HIGH;
        }
    }
}
