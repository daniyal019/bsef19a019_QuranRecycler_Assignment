package haqnawaz.org.navigationdrawer;
import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseOpen extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "quran_database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpen(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
