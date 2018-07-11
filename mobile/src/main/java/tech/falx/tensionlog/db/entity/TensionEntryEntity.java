/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Calendar;
import java.util.Date;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

@Entity(nameInDb = "TensionEntry", indexes = {@Index(value = "date DESC")})
public class TensionEntryEntity extends BaseEntity {
    @Id
    protected Long id = -1L;
    @NotNull
    protected Date created = new Date();
    @NotNull
    protected Date updated = new Date();
    @NotNull
    private Date date = new Date();
    @NotNull
    private Integer tension = 0;
    private String location = "";
    private String situation = "";
    private String skill = "";
    private Integer tensionAfter = 0;
    private String emotion = "";
    private Integer skillDuration = 0;
    private String notes = "";

    @Generated(hash = 1368940128)
    public TensionEntryEntity(Long id, @NotNull Date created, @NotNull Date updated,
                              @NotNull Date date, @NotNull Integer tension, String location, String situation,
                              String skill, Integer tensionAfter, String emotion, Integer skillDuration,
                              String notes) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.date = date;
        this.tension = tension;
        this.location = location;
        this.situation = situation;
        this.skill = skill;
        this.tensionAfter = tensionAfter;
        this.emotion = emotion;
        this.skillDuration = skillDuration;
        this.notes = notes;
    }

    @Generated(hash = 938401278)
    public TensionEntryEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
        this.date = date;
    }

    public Integer getTension() {
        return this.tension;
    }

    public void setTension(Integer tension) {
        this.tension = tension;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSituation() {
        return this.situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getTensionAfter() {
        return this.tensionAfter;
    }

    public void setTensionAfter(Integer tensionAfter) {
        this.tensionAfter = tensionAfter;
    }

    public String getEmotion() {
        return this.emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public Integer getSkillDuration() {
        return this.skillDuration;
    }

    public void setSkillDuration(Integer skillDuration) {
        this.skillDuration = skillDuration;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
