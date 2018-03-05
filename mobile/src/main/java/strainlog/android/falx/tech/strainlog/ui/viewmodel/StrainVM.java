/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package strainlog.android.falx.tech.strainlog.ui.viewmodel;

import strainlog.android.falx.tech.strainlog.db.entity.StrainEntryEntity;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class StrainVM extends BaseVM {
    public final StrainEntryEntity strainEntry;

    public StrainVM(StrainEntryEntity strainEntry) {
        this.strainEntry = strainEntry;
    }
}
