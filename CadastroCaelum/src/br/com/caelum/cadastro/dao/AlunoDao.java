package br.com.caelum.cadastro.dao;

import br.com.caelum.cadastro.modelo.Aluno;
import android.app.DownloadManager.Query;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDao extends SQLiteOpenHelper {
	private static final int VERSAO = 1;
	private static final String TABELA = "FJ57";
	private static final String DATABASE = "CadastroCaelum";

	public AlunoDao(Context context) {
		super(context, DATABASE, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddlCreateTable = "CREATE TABLE "+ TABELA 
				+ "(id INTEGER PRIMARY KEY, " + "nome TEXT UNIQUE NOT NULL, "
				+ "telefone TEXT, " + "endereco TEXT, " + "site TEXT, "
				+ "nota REAL, " + "foto TEXT);";
		db.execSQL(ddlCreateTable);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String ddlDropTable = "DROP TABLE IF EXISTS "+ TABELA +";";
		db.execSQL(ddlDropTable);
		this.onCreate(db);

	}
	
	public void insere(Aluno aluno){
		ContentValues values = toValues(aluno);
		getWritableDatabase().insert(TABELA, null, values);
		
	}

	private ContentValues toValues(Aluno aluno) {
		ContentValues values = new ContentValues();
		values.put("nome", aluno.getNome());
		values.put("nota", aluno.getNota());
		values.put("telefone", aluno.getTelefone());
		values.put("endereco", aluno.getEndereco());
		values.put("site", aluno.getSite());
		values.put("nota", aluno.getNota());
		return values;
	}	

}
