package com.example.administrator.mysqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteOpenHelper helper=DBManager.getIntance(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        String queryAllSQL="select * from "+ ConstantDB.TABLE_NAME_LEAVE_DELIVERY;
        String sql="insert into "+ConstantDB.TABLE_NAME_LEAVE_DELIVERY+"(leaveDeliveryCode,leaveDeliveryPerson,leaveDeliveryPersonNum,leaveDeliveryReason,status) values(\"646446545779\",\"周文广18348088072\",\"21996.3335\",\"1\",0)";
        db.execSQL(sql);
        List list = new DBManager().queryData(db,queryAllSQL,null);

    }
}
