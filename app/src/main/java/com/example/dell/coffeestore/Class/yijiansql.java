package com.example.dell.coffeestore.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 2017/07/20.
 */

public class yijiansql {
    private static final String DBFEND_NAME="Coffee45.db";///
    private static final String DBFEND_TABLE="peopleInfofeed";
    private static final int DB_VERSION=3;//
    private static final String KEYFEED_ID="_id";
    private static final String KEYFEED_NAME="name";
    private static final String KEYFEED_TYPE="type";
    private static final String KEYFEED_CONTENT="content";
    private static final String KEY_PHONE_NUMBER="e_mail";
    private SQLiteDatabase db;
    private final Context context;
    private yijianl dbOpenHelper;

    private static class yijianl extends SQLiteOpenHelper {
        private static final String DBEDT_CREATE="create table "+DBFEND_TABLE+"("+KEYFEED_ID+" integer primary key autoincrement, "
                +KEYFEED_NAME+" text not null, "+KEYFEED_TYPE+" text,"+KEYFEED_CONTENT+" text,"+KEY_PHONE_NUMBER+" text);";

        public yijianl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            // TODO Auto-generated constructor stub
        }
        @Override
        public void onCreate(SQLiteDatabase arg0) {
            // TODO Auto-generated method stub
            arg0.execSQL(DBEDT_CREATE);

        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub
            arg0.execSQL("DROP TABLE IF EXISTS "+DBEDT_CREATE);

            onCreate(arg0);
            arg0.close();
        }
    }
    public yijiansql(Context _context)
    {
        context=_context;
    }
    public void openDB() throws SQLiteException {
        dbOpenHelper=new yijianl(context, DBFEND_NAME, null, DB_VERSION);
        try{
            db=dbOpenHelper.getWritableDatabase();
        }
        catch(SQLiteException ex)
        {
            db=dbOpenHelper.getReadableDatabase();
        }
    }
    //	public void close()
//	{
//		if(db!=null)
//		{
//			db.close();
//			db=null;
//		}
//	}
//	在忘数据库中插入数据的时候，首先应该有一个ContentValues的对象所以：
//
//	ContentValues initialValues = new ContentValues();
//
//initialValues.put(key,values);
//
//	SQLiteDataBase sdb ;
//
//sdb.insert(database_name,null,initialValues);
//
//	插入成功就返回记录的id否则返回-1；
//
//	就可以插入一行数据，详细见下面代码
//long
    public long Insert(T_feedbackinformation people)
    {
        ContentValues newValue=new ContentValues();
        newValue.put(KEYFEED_NAME,people.Name);
        newValue.put(KEYFEED_TYPE,people.type);
        newValue.put(KEYFEED_CONTENT,people.feedcontent);
        newValue.put(KEY_PHONE_NUMBER,people.fendphone);
        return db.insert(DBFEND_TABLE, null, newValue);
    }

    public long deleteAll()
    {
        return db.delete(DBFEND_TABLE, null, null);
    }

    public long deleteByName(String name)
    {
        return db.delete(DBFEND_TABLE, KEYFEED_NAME + "=" + "'" + name + "'", null);
    }

    public long updateByName(T_feedbackinformation people,String name)
    {
        ContentValues updateValue=new ContentValues();
        updateValue.put(KEYFEED_NAME,people.Name);
        updateValue.put(KEYFEED_TYPE,people.type);
        updateValue.put(KEYFEED_CONTENT,people.feedcontent);
        updateValue.put(KEY_PHONE_NUMBER,people.fendphone);
        return db.update(DBFEND_TABLE, updateValue, KEYFEED_NAME + "=" + "'" + name + "'", null);
    }
    //
//	public PeopleInfo[] queryById(int id)
//	{
//		Cursor result=db.query(DB_TABLE, new String[]{KEY_ID,KEY_NAME,KEY_PHONE_NUMBER,KEY_ADDRESS,KEY_E_MAIL}, KEY_ID+"="+id, null, null, null, null);
//		return ConvertToPeopleInfo(result);
//	}
//    public T_feedbackinformation[] queryByName(String name)
//    {
//        Cursor result=db.query(DBFEND_TABLE, new String[]{KEYFEED_ID,KEYFEED_NAME,KEYFEED_TYPE,KEYFEED_CONTENT,KEY_PHONE_NUMBER},KEYFEED_NAME + "=" + "'" + name + "'", null, null, null, null);
//        return ConvertToPeopleInfo(result);
//    }

    public T_feedbackinformation[] qurryAll()	{
        Cursor result=db.query(DBFEND_TABLE, new String[]{KEYFEED_ID,KEYFEED_NAME,KEYFEED_TYPE,KEYFEED_CONTENT,KEY_PHONE_NUMBER}, null, null, null, null, null);
        return ConvertToPeopleInfo(result);
    }

    private T_feedbackinformation[] ConvertToPeopleInfo(Cursor cursor){
        int resultCounts=cursor.getCount();
        if(resultCounts==0||!cursor.moveToFirst()){
            return null;
        }
        T_feedbackinformation[] peoples=new T_feedbackinformation[resultCounts];
        for(int i=0;i<resultCounts;i++)
        {
            peoples[i] = new T_feedbackinformation(cursor.getString(cursor.getColumnIndex(KEYFEED_NAME)),cursor.getString(cursor.getColumnIndex(KEYFEED_TYPE)), cursor.getString(cursor.getColumnIndex(KEYFEED_CONTENT)),cursor.getString(cursor.getColumnIndex(KEY_PHONE_NUMBER)));
            //	peoples[i].ID = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            cursor.moveToNext();
        }
        return peoples;

    }

//	public ArrayList Query() {
//		//------将更新后的全部数据返回---------
//		//定义一个键值对数组将数据返回到第一个列表Activity中更新进行显示
//		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//		Cursor cursor = db.query(DB_TABLE, new String[]{KEY_ID,KEY_NAME,KEY_PHONE_NUMBER,KEY_ADDRESS,KEY_E_MAIL}, null, null, null, null, null);
//		while(curs
// or.moveToNext()){
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("name", cursor.getString(cursor.getColumnIndex("name")));
//			map.put("phone_number", cursor.getString(cursor.getColumnIndex("phone_number")));
//			map.put("address", cursor.getString(cursor.getColumnIndex("address")));
//			map.put("e_mail", cursor.getString(cursor.getColumnIndex("e_mail")));
//			list.add(map);
//		}
//		return list;   //返回全部数据list用于列表显示
//	}

}

