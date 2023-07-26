package com.example.income_expense_tracker;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1 ;
    private  static  final String DATABASE_NAME = "mydatabase";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public  void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE mytable(id INTEGER PRIMARY KEY AUTOINCREMENT, data TEXT, income TEXT, expenses TEXT)";
        db.execSQL(createQuery);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }


    public void insertData(String date, String income, String expenses) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date",date);
        contentValues.put("income", income);
        contentValues.put("expenses", expenses);
        db.insert("mytable", null,contentValues);
        db.close();
    }

    public Cursor selectData(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM mytable WHERE date=?";
        Cursor cursor =db.rawQuery(query, new String[]{date});
        return cursor;
    }


    public Cursor selectData(String date1, String date2){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM mytable WHERE data BETWEEN ? AND?";
        Cursor cursor = db.rawQuery(query, new String[]{date1, date2});
        return cursor;
    }

    public void updateData(String id, String date, String income, String expenses){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date",date);
        contentValues.put("income",income);
        contentValues.put("expenses",expenses);
        db.update("mytable", contentValues,"id=?", new String[]{id});
        db.close();
    }

    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("mytable", "id=?", new String[] {id});
    }




}