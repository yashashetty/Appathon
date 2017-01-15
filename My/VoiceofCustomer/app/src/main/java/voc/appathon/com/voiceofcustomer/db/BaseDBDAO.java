package voc.appathon.com.voiceofcustomer.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class BaseDBDAO {

    protected SQLiteDatabase database;
    private DBHelper dbHelper;
    private Context mContext;

    //static final String WHERE_READ_SYNC_ID_EQUALS = DBHelper.KEY_TILESINFO_ISREAD + " = ? AND " + DBHelper.KEY_TILESINFO_ISSYNCED + " = ?";

    public BaseDBDAO(Context context) {
        this.mContext = context;
        dbHelper = DBHelper.getHelper(mContext);
        open();

    }

    public void open() throws SQLException {
        if (dbHelper == null)
            dbHelper = DBHelper.getHelper(mContext);
        database = dbHelper.getWritableDatabase();
    }


}
