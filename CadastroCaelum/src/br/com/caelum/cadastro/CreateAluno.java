package br.com.caelum.cadastro;

import br.com.caelum.cadastro.dao.AlunoDao;
import br.com.caelum.cadastro.modelo.Aluno;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CreateAluno extends Activity{

	private CadastroHelper helper;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);
		this.helper = new CadastroHelper(this);
		
		Button botao = (Button)findViewById(R.id.botao);
		botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Aluno aluno = helper.pegaAlunoDoFormulario();
				AlunoDao alunoDAO = new AlunoDao(CreateAluno.this);
				alunoDAO.insere(aluno);
				alunoDAO.close();
				
				finish();
			}
		});
	}

}
