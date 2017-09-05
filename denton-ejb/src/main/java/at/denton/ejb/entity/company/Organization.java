package at.denton.ejb.entity.company;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mczirfusz
 */
@Entity
@Table(name = "organization", schema = "denton")
public class Organization implements Serializable {

    @Id
    @Column(name = "organization_id")
    private Integer organizationId;

    @Column(name = "name")
    @NotNull
    @Size(max = 128, message = "Organization must have maximum 128 characters!")
    private String name;
    
    public Organization() {}

    public Organization(String name) {
        this.name = name;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Organization{" + "organizationId=" + organizationId + ", name=" + name + '}';
    }

}
