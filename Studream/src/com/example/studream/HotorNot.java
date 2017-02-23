package com.example.studream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HotorNot {

	public static final String KEY_ROWID="_id";
	public static final String KEY_NAME="person_name";
	public static final String KEY_HOTNESS="person_hotness";
	
	private static final String DATABASE_NAME="HotorNotdb";
	private static final String DATABASE_TABLE="person_table";
	private static final int DATABASE_VERSION=1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		
		}

		@Override
		public void onCreate(SQLiteDatabase arg0) {
			// TODO Auto-generated method stub
			arg0.execSQL("CREATE TABLE "+DATABASE_TABLE+" ("+KEY_ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
					KEY_NAME+" TEXT NOT NULL, "+KEY_HOTNESS+" TEXT NOT NULL);");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			arg0.execSQL("DROP TABLE IF EXIST "+DATABASE_TABLE);
			onCreate(arg0);
		}
	}
	public HotorNot(Context c){
		ourContext=c;
	}
	public HotorNot open()throws SQLException{
ourHelper=new DbHelper(ourContext);
ourDatabase=ourHelper.getWritableDatabase();
return this;
	}
	public void close(){
		ourHelper.close();
	}
	public long createEntry(String sname, String shotness) {
		// TODO Auto-generated method stub
	ContentValues cv=new ContentValues();
	cv.put(KEY_NAME,sname);
	cv.put(KEY_HOTNESS, shotness);
	return ourDatabase.insert(DATABASE_TABLE, null, cv);	
	}
	public String getData() {
		// TODO Auto-generated method stub
		String[] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_HOTNESS};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns,null,null,null,null,null);
		String result=" ";
		int irow=c.getColumnIndex(KEY_ROWID);
		int iname=c.getColumnIndex(KEY_NAME);
		int ihotness=c.getColumnIndex(KEY_HOTNESS);
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
		result=result+c.getString(irow)+" "+c.getString(iname)+" "+c.getString(ihotness)+"\n";
		}
		return result;
	}
	public String getName(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_HOTNESS};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID+"="+l,null,null,null,null);
		if(c!=null){
			c.moveToFirst();
			String name=c.getString(1);
			return name;
		}
		return null;
	}
	public String getHotness(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_HOTNESS};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID+"="+l,null,null,null,null);
		if(c!=null){
			c.moveToFirst();
			String hotness=c.getString(2);
			return hotness;
		}
		return null;
	}
	public void change(long n, String mName, String nHotness) throws SQLException{
		// TODO Auto-generated method stub
	ContentValues cvupdate=new ContentValues();
	cvupdate.put(KEY_NAME, mName);
	cvupdate.put(KEY_HOTNESS,nHotness);
	ourDatabase.update(DATABASE_TABLE, cvupdate, KEY_ROWID+"="+n, null);
	}
	public void deleteentry(long p) throws SQLException{
		// TODO Auto-generated method stub
	ourDatabase.delete(DATABASE_TABLE, KEY_ROWID+"="+p, null);	
	}
}