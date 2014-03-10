package br.com.caelum.cadastra.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDao extends SQLiteOpenHelper {
	private static final int VERSAO = 1;
	private static final String TABELA = "CadastroCaelum";
	private static final String DATABASE = "FJ57";
	
	public AlunoDao(Context context) {
		super(context, DATABASE,null ,1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddl = "CREATE TABLE FJ57 ("
				+ "id INTEGER PRIMARY KEY, "
				+ "nome TEXT UNIQUE NOT NULL, "
				+ "telefone TEXT, "
				+ "endereco TEXT, "
				+ "site TEXT, "
				+ "nota REAL, "
				+ "foto TEXT);";
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	
}
