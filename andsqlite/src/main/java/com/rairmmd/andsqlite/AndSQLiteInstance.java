package com.rairmmd.andsqlite;

import android.content.Context;

import com.rairmmd.andsqlite.assit.SQLiteHelper;
import com.rairmmd.andsqlite.db.DataBaseConfig;

/**
 * @author Rair
 * @date 2019-04-22
 * <p>
 * desc:
 */
public class AndSQLiteInstance {

    private static AndSQLite instance;

    private AndSQLiteInstance() {

    }

    public static void init(Context context, String dbName, int dbVersion) {
        DataBaseConfig dataBaseConfig = new DataBaseConfig(context, dbName);
        dataBaseConfig.dbVersion = dbVersion;
        if (instance == null) {
            instance = AndSQLite.newSingleInstance(dataBaseConfig);
        }
    }

    public static void init(Context context, String dbName, int dbVersion, boolean enableWal) {
        DataBaseConfig dataBaseConfig = new DataBaseConfig(context, dbName);
        dataBaseConfig.dbVersion = dbVersion;
        if (instance == null) {
            instance = AndSQLite.newSingleInstance(dataBaseConfig);
        }
        if (enableWal) {
            instance.getWritableDatabase().enableWriteAheadLogging();
        } else {
            instance.getWritableDatabase().disableWriteAheadLogging();
        }
    }

    public static void init(Context context, String dbName, int dbVersion, boolean debugged,
                            boolean enableWal, SQLiteHelper.OnUpdateListener onUpdateListener) {
        DataBaseConfig dataBaseConfig = new DataBaseConfig(context, dbName, debugged, dbVersion, onUpdateListener);
        if (instance == null) {
            instance = AndSQLite.newSingleInstance(dataBaseConfig);
        }
        if (enableWal) {
            instance.getWritableDatabase().enableWriteAheadLogging();
        } else {
            instance.getWritableDatabase().disableWriteAheadLogging();
        }
    }

    public static AndSQLite getDataBase() {
        return instance;
    }
}
