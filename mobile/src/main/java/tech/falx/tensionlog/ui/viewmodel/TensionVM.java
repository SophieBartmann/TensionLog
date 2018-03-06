/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.viewmodel;

import tech.falx.tensionlog.db.entity.TensionEntryEntity;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class TensionVM extends BaseVM {
    public final TensionEntryEntity strainEntry;

    public TensionVM(TensionEntryEntity strainEntry) {
        this.strainEntry = strainEntry;
    }




}
