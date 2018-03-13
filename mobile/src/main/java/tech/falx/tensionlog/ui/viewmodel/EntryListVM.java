package tech.falx.tensionlog.ui.viewmodel;

import tech.falx.tensionlog.db.entity.DaoSession;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class EntryListVM extends BaseVM {
    public EntryListVM(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public void saveEntities() {

    }
}
