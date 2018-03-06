/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

@Entity(nameInDb = "StrainEntry", indexes = {@Index(value = "date DESC")})
public class TensionEntryEntity extends BaseEntity {
    @NotNull
    private Date date;
    @NotNull
    private Integer strain;
    private String location;
    private String situation;
    private String skill;
    private Integer strainAfter;
    private String emotion;
    private Integer skillDuration;
    private String notes;

    @Generated(hash = 2108906173)
    public TensionEntryEntity(@NotNull Date date, @NotNull Integer strain, String location,
                              String situation, String skill, Integer strainAfter, String emotion, Integer skillDuration,
                              String notes) {
        this.date = date;
        this.strain = strain;
        this.location = location;
        this.situation = situation;
        this.skill = skill;
        this.strainAfter = strainAfter;
        this.emotion = emotion;
        this.skillDuration = skillDuration;
        this.notes = notes;
    }

    @Generated(hash = 606828352)
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
    }

    public Integer getStrain() {
        return this.strain;
    }

    public void setStrain(Integer strain) {
        this.strain = strain;
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

    public Integer getStrainAfter() {
        return this.strainAfter;
    }

    public void setStrainAfter(Integer strainAfter) {
        this.strainAfter = strainAfter;
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


}
