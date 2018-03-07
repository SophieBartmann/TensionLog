/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import tech.falx.tensionlog.db.entity.DaoMaster;
import tech.falx.tensionlog.db.entity.DaoSession;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class App extends Application {
    public static final boolean IS_DB_ENCRYPTED = false;
    private static final String ENCRYPTED_DB = "tension_db_encrypted";
    private static final String NON_ENCRYPTED_DB = "tension_db_unencrypted";
    private DaoSession daoSession;


    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper dbHelper = null;
        Database db = null;
        if (IS_DB_ENCRYPTED) {
            dbHelper = new DaoMaster.DevOpenHelper(this, ENCRYPTED_DB);
            // TODO: CHANGE!
            db = dbHelper.getEncryptedWritableDb("Super-Secret-PW");
            this.daoSession = new DaoMaster(db).newSession();
        } else {
            dbHelper = new DaoMaster.DevOpenHelper(this, NON_ENCRYPTED_DB);
            db = dbHelper.getWritableDb();
            this.daoSession = new DaoMaster(db).newSession();
        }
    }

    /**
     * This method is for use in emulated process environments.  It will
     * never be called on a production Android device, where processes are
     * removed by simply killing them; no user code (including this callback)
     * is executed when doing so.
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
