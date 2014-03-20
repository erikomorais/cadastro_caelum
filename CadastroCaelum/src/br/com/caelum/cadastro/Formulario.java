package br.com.caelum.cadastro;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.caelum.cadastro.dao.AlunoDao;
import br.com.caelum.cadastro.modelo.Aluno;

public class Formulario extends Activity{

	private CadastroHelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);
		
		Intent intent = getIntent();
		final Aluno alunoParaSerAlterado = (Aluno)intent.getSerializableExtra("alunoClicado");
		
		
		this.helper = new CadastroHelper(this);
		
		Button botao = (Button)findViewById(R.id.botao);
		if(alunoParaSerAlterado != null){
			botao.setText("Alterar");
			helper.colocaAlunoNoFormulario(alunoParaSerAlterado);
		}
		botao.setOnClickListener(new OnClickListener() {
		
			
			@Override
			public void onClick(View v) {
				Aluno aluno = helper.pegaAlunoDoFormulario();
				AlunoDao alunoDAO = new AlunoDao(Formulario.this);
				
				if(alunoParaSerAlterado == null){
				alunoDAO.insere(aluno);
				}else
				{
					aluno.setId(alunoParaSerAlterado.getId());
					alunoDAO.altera(aluno);
					
				}
				finish();
				//encerra a activity
			}
		});
	}
	

}
