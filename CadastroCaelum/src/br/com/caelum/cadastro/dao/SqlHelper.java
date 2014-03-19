package br.com.caelum.cadastro.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {
	private String ddlCreateString;
	private String ddlUpgradeString;
	
	public SqlHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	
	public void setDdlCreateString(String ddlCreateString) {
		this.ddlCreateString = ddlCreateString;
	}


	public void setDdlUpgradeString(String ddlUpgradeString) {
		this.ddlUpgradeString = ddlUpgradeString;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ddlCreateString);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(ddlUpgradeString);
		this.onCreate(db);

	}

}
