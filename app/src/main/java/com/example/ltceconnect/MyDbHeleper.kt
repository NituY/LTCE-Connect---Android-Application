package com.example.ltceconnect



import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context): SQLiteOpenHelper(context,"USER_DB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE LOGIN(SR_NO INTEGERS,USER_NAME TEXT,PASSWORD INTEGER)")
        db?.execSQL("INSERT INTO LOGIN(USER_NAME,PASSWORD) VALUES('','')")


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}