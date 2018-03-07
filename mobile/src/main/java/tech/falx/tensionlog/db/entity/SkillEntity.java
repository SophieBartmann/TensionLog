/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

@Entity(nameInDb = "Skill")
public class SkillEntity extends BaseEntity {
    @Id
    protected Long id;

    @NotNull
    protected Date created;
    @NotNull
    protected Date updated;
    @NotNull
    private String title;
    private String description;
    private String category;

    @Generated(hash = 279545775)
    public SkillEntity(Long id, @NotNull Date created, @NotNull Date updated,
                       @NotNull String title, String description, String category) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    @Generated(hash = 1054172247)
    public SkillEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
