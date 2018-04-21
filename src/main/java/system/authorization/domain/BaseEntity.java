package system.authorization.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by KAI on 4/19/18.
 */
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    private Date createdAt;

    private Date lastUpdatedAt;

    @Version
    private int version;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @PrePersist
    public void onPrePersist() {
        this.createdAt = Calendar.getInstance().getTime();
        this.lastUpdatedAt = Calendar.getInstance().getTime();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.lastUpdatedAt = Calendar.getInstance().getTime();
    }
}
