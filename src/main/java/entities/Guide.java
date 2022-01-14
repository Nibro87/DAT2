package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Guide implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guideId;


    private String guideName;
    private String gender;
    private String birthYear;
    private String profile;
    private String image;

    @OneToMany
    private List<Trip> tripList;

    public Guide() {
    }

    public Guide(String guideName, String gender, String birthYear, String profile, String image) {
        this.guideName = guideName;
        this.gender = gender;
        this.birthYear = birthYear;
        this.profile = profile;
        this.image = image;

    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getGuideId() {
        return guideId;
    }

    public void setGuideId(long guideId) {
        this.guideId = guideId;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
