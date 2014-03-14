package br.com.caelum.cadastro.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {
	
	
	public SqlHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddlCreateTable = "CREATE TABLE Aluno"
				+ "(id INTEGER PRIMARY KEY, " + "nome TEXT UNIQUE NOT NULL, "
				+ "telefone TEXT, " + "endereco TEXT, " + "site TEXT, "
				+ "nota REAL, " + "foto TEXT);";
		db.execSQL(ddlCreateTable);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String ddlDropTable = "DROP TABLE IF EXISTS Aluno;";
		db.execSQL(ddlDropTable);
		this.onCreate(db);

	}

}
