package br.com.caelum.cadastro.dao;

import br.com.caelum.cadastro.modelo.Aluno;
import android.app.DownloadManager.Query;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDao { 
	private static final String DATABASE = "CadastroCaelum";
	private static final int VERSAO = 1;
	private SqlHelper DaoSQLHelper;

	public AlunoDao(Context context) {
		
		this.DaoSQLHelper = new SqlHelper(context, DATABASE, null, VERSAO);
	}


	
	
	public void insere(Aluno aluno){
		ContentValues values = toValues(aluno);
		this.DaoSQLHelper.getWritableDatabase().insert("Aluno", null, values);
		this.DaoSQLHelper.close();
		
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
