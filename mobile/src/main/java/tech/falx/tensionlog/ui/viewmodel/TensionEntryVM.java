/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import tech.falx.tensionlog.db.entity.DaoSession;
import tech.falx.tensionlog.db.entity.TensionEntryEntity;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class TensionEntryVM extends BaseVM {
    public final ObservableInt tension;
    public final ObservableField<String> location;
    public final ObservableField<String> situation;
    public final ObservableField<String> skillUsed;
    public final ObservableInt skillDuration;
    public final ObservableInt tensionAfterSkill;
    public final String date;
    private final TensionEntryEntity tensionEntry;

    public TensionEntryVM(TensionEntryEntity tensionEntry, DaoSession daoSession) {
        super(daoSession);
        this.tensionEntry = tensionEntry;
        this.tension = new ObservableInt();
        this.location = new ObservableField<>();
        this.situation = new ObservableField<>();
        this.skillUsed = new ObservableField<>();
        this.tensionAfterSkill = new ObservableInt();
        this.skillDuration = new ObservableInt();
        DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();
        this.date = dateFormat.format(this.tensionEntry.getDate());
        this.init();
    }

    public TensionEntryVM(DaoSession daoSession) {
        this(new TensionEntryEntity(), daoSession);
    }

    public void init() {
        this.tension.set(this.tensionEntry.getTension());
        this.location.set(this.tensionEntry.getLocation());
        this.situation.set(this.tensionEntry.getSituation());
        this.skillUsed.set(this.tensionEntry.getSkill());
        this.tensionAfterSkill.set(this.tensionEntry.getTensionAfter());
        this.skillDuration.set(this.tensionEntry.getSkillDuration());
    }

    public void delete() {

    }

    @Override
    public void saveEntities() {
        this.tensionEntry.setTension(this.tension.get());
        this.tensionEntry.setEmotion("");
        this.tensionEntry.setLocation(this.location.get());
        this.tensionEntry.setSituation(this.situation.get());
        this.tensionEntry.setSkill(this.skillUsed.get());
        this.tensionEntry.setSkillDuration(this.skillDuration.get());
        this.tensionEntry.setTensionAfter(this.tensionAfterSkill.get());
        this.tensionEntry.setUpdated(new Date());
        this.daoSession.getTensionEntryEntityDao().insertOrReplace(this.tensionEntry);
    }
}
