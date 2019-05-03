package com.rairmmd.andsqlite;

import android.content.Context;

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

    public static void init(Context context, String dbName, boolean debugged) {
        DataBaseConfig dataBaseConfig = new DataBaseConfig(context, dbName);
        dataBaseConfig.debugged = debugged;
        if (instance == null) {
            instance = AndSQLite.newSingleInstance(dataBaseConfig);
        }
    }

    public static void init(Context context, String dbName) {
        DataBaseConfig dataBaseConfig = new DataBaseConfig(context, dbName);
        dataBaseConfig.debugged = false;
        if (instance == null) {
            instance = AndSQLite.newSingleInstance(dataBaseConfig);
        }
    }

    public static AndSQLite getInstance() {
        return instance;
    }
}
