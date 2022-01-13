package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Guide implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String guideName;

    private String gender;
    private int birthYear;
    private String profile;
    private String image;

    @OneToMany
    private List<Trip> tripList;

    public Guide() {
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
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
