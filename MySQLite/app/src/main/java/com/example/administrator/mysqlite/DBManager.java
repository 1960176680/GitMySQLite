package com.example.administrator.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-14.
 *
 * 用于数据库操作的类
 */
public class DBManager<T> {

    private T model;

//  新的数据库
    private static MySQLiteOpenHelper sqLiteOpenHelper;


    public DBManager(){

    }

    /**
     * 获取helper类的对象
     */
    public static MySQLiteOpenHelper getIntance(Context context){
        if(sqLiteOpenHelper==null){
            sqLiteOpenHelper=new MySQLiteOpenHelper(context);
        }
        return sqLiteOpenHelper;
    }

    /**
     * 根据提供的sql语句在数据库中执行语句
     */
    public  void execSql(SQLiteDatabase db,String sql){
        if(db!=null){
            if(sql!=null && !"".equals(sql)){// sql  null ""
                db.execSQL(sql);
            }
        }
    }
    /**
     * 根据具体条件插入指定表数据
     * @param db  数据库对象
     * @param table  数据表名称
     * @param nullColumnHack  为了避免数据表中出现完全为null的记录
     * @param values  以键值对的形式插入数据   键表示数据表的字段名称  值表示数据表中对应字段的值
     * 返回值表示插入新行的行id
     * insert into 表名(字段1....) values(值1...)
     */
    public  long insertData(SQLiteDatabase db,String table,
                                      String nullColumnHack, ContentValues values){
        long rowId=0;
        if(db!=null){
            rowId=db.insert(table, nullColumnHack, values);
        }
        return rowId;
    }
    /**
     * 根据条件删除数据
     * @param db 数据库对象
     * @param table  数据表的名称
     * @param whereClause  删除的条件
     * @param whereArgs  删除条件的占位符
     * @return  删除成功的数据条目
     * //delete form 表名 where 条件
     */
    public   int deleteData(SQLiteDatabase db,String table,String whereClause,String[] whereArgs){
        int count=0;
        if(db!=null){
            count=db.delete(table, whereClause, whereArgs);
        }
        return count;
    }
    /**
     * 根据sql查询语句获取查询cursor结果
     * @param db  数据库对象
     * @param sql sql语句
     * @param selectionArgs sql语句中的占位符
     * @return  查询的结果集cusor对象
     */
    public   List<T> queryData(SQLiteDatabase db,String sql,String[] selectionArgs){
        Cursor cursor = db.rawQuery(sql, null);
        List<T> list=CursorToList(cursor);
        return list;
    }
    /**
     *  根据条件修改数据库数据
     * @param db  数据库对象
     * @param table  数据表的名称
     * @param values  修改数据的键以及新值     键表示数据表的字段  值表示需要修改的新值
     * @param whereClause  修改的条件
     * @param whereArgs    修改条件的占位符的取值
     * @return  修改的条数
     * //update 表名 set 字段名=值,字段名=值 where 条件
    //update person age=20 where _id=? and age>?;  new String[]{"1","25"}
     */
    public static int updateDataToDb(SQLiteDatabase db,String table,ContentValues values,
                                     String whereClause,String[] whereArgs){
        int count=0;
        if(db!=null){
            count=db.update(table, values, whereClause, whereArgs);
        }
        return count;
    }

    /**
     * 将cursor对象转换成具体的集合数据
     * @param cursor 需要转换的cursor游标对象
     * @return  集合
     */
    public List<T> CursorToList(Cursor cursor){
        List<T> list=new ArrayList<T>();
        //moveToNext() 如果返回true表示下一条记录存在   否则游标中的数据读取完毕
        while(cursor.moveToNext()){
            //getColumnIndex(String columnName) 表示根据参数中的字段名称获取当前字段对应的下标值
            if(model instanceof LeaveDeliveryData){
                LeaveDeliveryData leaveDeliveryData = new LeaveDeliveryData();
                leaveDeliveryData.setLeaveDeliveryCode(cursor.getString(0));
                leaveDeliveryData.setLeaveDeliveryPerson(cursor.getString(1));
                leaveDeliveryData.setLeaveDeliveryPersonNum(cursor.getString(2));
                leaveDeliveryData.setLeaveDeliveryReason(cursor.getString(3));
                leaveDeliveryData.setScanTime(cursor.getString(4));
                leaveDeliveryData.setUploadTime(cursor.getString(5));
                leaveDeliveryData.setStatus(cursor.getInt(6));
                list.add(((T) leaveDeliveryData));
            }
        }
        return list;
    }

    /**
     * 根据条件查询指定的表获取数据
     * @param db 数据库对象
     * @param table 数据表名称
     * @param columns 查询的数据表中的字段  如果设置为null表示查询表中所有字段  相当于 select *
     * @param selection 查询条件 where字句 如果为null 查询表中的所有  select * from xx
     * @param selectionArgs  查询条件中占位符的取值
     * @param groupBy  查询中的分组   group by子句
     * @param having    查询中筛选条件   having子句
     * @param orderBy   查询中排序条件  order By子句
     * @return   查询的结果集对象
     * // select 列名,列名  from 表名 where 条件  group by 分组  having 筛选  order by 排序
     */
    public static Cursor selectDataByApi(SQLiteDatabase db, String table, String[] columns,
                                         String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        Cursor cursor=null;
        if(db!=null){
            cursor=db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
        }
        return cursor;
    }

}
