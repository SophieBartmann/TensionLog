package tech.falx.tensionlog.ui.viewmodel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import tech.falx.tensionlog.db.entity.DaoSession;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class EntryListVM extends BaseVM {
    public final String date;
    private final Date dateField;

    public EntryListVM(Date date, DaoSession daoSession) {
        super(daoSession);
        this.dateField = date;
        DateFormat dateFormat = SimpleDateFormat.getDateInstance();
        this.date = dateFormat.format(this.dateField);
    }

    @Override
    public void saveEntities() {

    }

    public void add() {

    }
}
