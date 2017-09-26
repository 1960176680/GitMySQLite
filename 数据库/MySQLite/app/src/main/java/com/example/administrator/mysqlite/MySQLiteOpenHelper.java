package com.example.administrator.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016-08-19.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    public MySQLiteOpenHelper(Context context){
        super(context, ConstantDB.DATABASE_NAME, null, ConstantDB.DATABASE_VERSION);
    }
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


//留仓件数据表
    String leaveDeliverySQL="create table "+ ConstantDB.TABLE_NAME_LEAVE_DELIVERY+"("+
        ConstantDB.LEAVE_DELIVERY_CODE + " char(13)," +
        ConstantDB.LEAVE_DELIVERY_PERSON+" varchar(20),"+
        ConstantDB.LEAVE_DELIVERY_PERSON_Num+" varchar(20),"+
        ConstantDB.LEAVE_DELIVERY_REASON+" varchar(3),"+
        ConstantDB.LEAVE_DELIVERY_SCAN_TIME+" TIMESTAMP not null default (datetime('now','localtime')),"+
        ConstantDB.LEAVE_DELIVERY_UPLOAD_TIME+" varchar(20),"+
        ConstantDB.LEAVE_DELIVERY_STATUS+" Integer)";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(leaveDeliverySQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
