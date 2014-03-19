package br.com.caelum.cadastro.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.caelum.cadastro.modelo.Aluno;

public class AlunoDao { 
	private static final String DATABASE = "CadastroCaelum";
	private static final String TABELA = "Aluno";
	private static final int VERSAO = 1;
	 private static final String[] COLUNAS = { "id", "nome","telefone", "endereco", "site", "nota", "foto" };
	private SqlHelper DaoSQLHelper;

	public AlunoDao(Context context) {
		
		this.DaoSQLHelper = new SqlHelper(context, DATABASE, null, VERSAO);
		this.DaoSQLHelper.setDdlCreateString( "CREATE TABLE Aluno (id INTEGER PRIMARY KEY, nome TEXT UNIQUE NOT NULL, "
				+ "telefone TEXT, endereco TEXT, site TEXT, nota REAL, foto TEXT);");
		
		this.DaoSQLHelper.setDdlUpgradeString("DROP TABLE IF EXISTS Aluno;");
	}


	
	
	public void insere(Aluno aluno){
		ContentValues values = toValues(aluno);
		this.DaoSQLHelper.getWritableDatabase().insert("Aluno", null, values);
		this.DaoSQLHelper.close();
		
	}
	
	public List<Aluno> getLista() {
         List<Aluno> alunos = new ArrayList<Aluno>();

         Cursor c = this.DaoSQLHelper.getWritableDatabase().query(TABELA, COLUNAS, null,
             null, null, null, null);

         while (c.moveToNext()) {
             Aluno aluno = new Aluno();

             aluno.setId(c.getLong(0));
             aluno.setNome(c.getString(1));
             aluno.setTelefone(c.getString(2));
             aluno.setEndereco(c.getString(3));
             aluno.setSite(c.getString(4));
             aluno.setNota(c.getDouble(5));
             aluno.setFoto(c.getString(6));

             alunos.add(aluno);
         }
         c.close();

         return alunos;
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
