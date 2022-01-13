package entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Trip")
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    private String tripName;

    private String date;
    private String time;
    private String location;
    private String Duration;
    private String packingList;

    @ManyToMany
    private List<User> userList;

    @ManyToOne
    private Guide guide;


    public Trip() {
    }

    public Trip(String tripName, String date, String time, String location, String duration, String packingList) {
        this.tripName = tripName;
        this.date = date;
        this.time = time;
        this.location = location;
        Duration = duration;
        this.packingList = packingList;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripName='" + tripName + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", Duration='" + Duration + '\'' +
                ", packingList='" + packingList + '\'' +
                ", userList=" + userList +
                ", guide=" + guide +
                '}';
    }
}
