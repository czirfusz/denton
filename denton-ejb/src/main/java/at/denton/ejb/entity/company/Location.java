package at.denton.ejb.entity.company;

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
@Table(name = "location", schema = "denton")
public class Location implements Serializable {

    @Id
    @Column(name = "location_id")
    private Integer locationId;
    
    @Column(name = "name")
    @NotNull
    @Size(max = 128, message = "Location must have maximum 128 characters!")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    @NotNull
    private Organization organization;
    
    public Location() {}

    public Location(String name, Organization organization) {
        this.name = name;
        this.organization = organization;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Location{" + "locationId=" + locationId + ", name=" + name + ", organization=" + organization + '}';
    }
    
}
