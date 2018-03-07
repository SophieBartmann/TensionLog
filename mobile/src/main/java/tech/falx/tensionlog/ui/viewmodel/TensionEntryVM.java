/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import tech.falx.tensionlog.db.entity.DaoSession;
import tech.falx.tensionlog.db.entity.TensionEntryEntity;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class TensionEntryVM extends BaseVM {
    public final TensionEntryEntity tensionEntry;

    public final ObservableInt tension;
    public final ObservableField<String> location;
    public final ObservableField<String> situation;
    public final ObservableField<String> skillUsed;
    public final ObservableInt skillDuration;
    public final ObservableInt tensionAfterSkill;

    public TensionEntryVM(TensionEntryEntity tensionEntry) {
        this.tensionEntry = tensionEntry;
        this.tension = new ObservableInt(this.tensionEntry.getTension());
        this.location = new ObservableField<>(this.tensionEntry.getLocation());
        this.situation = new ObservableField<>(this.tensionEntry.getSituation());
        this.skillUsed = new ObservableField<>(this.tensionEntry.getSkill());
        this.tensionAfterSkill = new ObservableInt(this.tensionEntry.getTensionAfter());
        this.skillDuration = new ObservableInt(this.tensionEntry.getSkillDuration());
    }


    @Override
    public void saveEntities(DaoSession daoSession) {

    }
}
