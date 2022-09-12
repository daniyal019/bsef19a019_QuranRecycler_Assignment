package haqnawaz.org.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
public class DbAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DbAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DbAccess(Context context) {
        this.openHelper = new DatabaseOpen(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DbAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DbAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getQuotes(int id) {
ayat ay=new ayat();

        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Arabic_Text FROM tayah  where  SuraID="+id , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getTranslation(int id) {
        ayat ay=new ayat();

        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT \n" +
                "Fateh_Muhammad_Jalandhri FROM tayah  where  SuraID="+id , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getAyatNames() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT SurahNameU FROM tsurah", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getAyatNamesEng() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT SurahNameE FROM tsurah", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getAyatintro(int id) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT SurahIntro FROM tsurah  where  _id="+id , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getAyatTrans(int id) {

        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT \n" +
                "Mufti_Taqi_Usmani FROM tayah  where  SuraID="+id , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

}
