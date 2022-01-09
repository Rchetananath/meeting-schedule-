package com.example.meetingschedule;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper
{
    private static final String dbname = "medicine.db";
    public DbManager(Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qry="create table tabl_meeting(date text, time text, location text, meetingAgenda text,name text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS tabl_meeting");
        onCreate(db);
    }
    public String addRecord(String p1,String p2,String p3,String p4,String p5)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("date",p1);
        cv.put("time",p2);
        cv.put("location",p3);
        cv.put("meetingAgenda",p4);
        cv.put("name",p5);

        long res=db.insert("tabl_meeting",null,cv);
        if(res==-1)
            return "Failed";
        else
            return  "MEETING SCHEDULED!";
    }
}