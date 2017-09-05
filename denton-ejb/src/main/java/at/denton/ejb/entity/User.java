package at.denton.ejb.entity;

import at.denton.ejb.entity.company.Location;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mczirfusz
 */
@Entity
@Table(name = "user", schema = "denton")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "email")
    @Size(max = 128, message = "Mail address must have maximum 128 characters!")
    private String email;
    
    @Column(name = "msisdn")
    @Size(max = 32, message = "MSISDN must have maximum 128 characters!")
    private String msisdn;

    @Column(name = "user_alias")
    @Size(max = 64, message = "User alias must have maximum 64 characters!")
    private String userAlias;

    @Column(name = "password")
    @NotNull
    @Size(max = 32, message = "Password must have maximum 32 characters!")
    private String password;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    @NotNull
    private Location location;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", email=" + email + ", msisdn=" + msisdn + ", userAlias=" + userAlias + ", password=" + password + ", location=" + location + '}';
    }

}
