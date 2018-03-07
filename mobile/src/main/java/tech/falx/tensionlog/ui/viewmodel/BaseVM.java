/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.viewmodel;

import tech.falx.tensionlog.db.entity.DaoSession;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public abstract class BaseVM {
    public abstract void saveEntities(DaoSession daoSession);
}
