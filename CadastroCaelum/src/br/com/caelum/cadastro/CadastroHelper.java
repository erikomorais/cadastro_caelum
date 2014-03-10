package br.com.caelum.cadastro;

import android.widget.EditText;
import android.widget.RatingBar;
import br.com.caelum.cadastro.modelo.Aluno;

public class CadastroHelper {

	private EditText editNome;
	private EditText editSite;
	private EditText editTelefone;
	private EditText editEndereco;
	private RatingBar ratingNota;
	private Aluno aluno;

	public CadastroHelper(CreateAluno formulario) {
		aluno = new Aluno();
		editNome = (EditText) formulario.findViewById(R.id.nome);
		editSite = (EditText) formulario.findViewById(R.id.site);
		editTelefone = (EditText) formulario.findViewById(R.id.telefone);
		editEndereco = (EditText) formulario.findViewById(R.id.endereco);
		ratingNota = (RatingBar) formulario.findViewById(R.id.nota);

	}

	public Aluno pegaAlunoDoFormulario() {
		aluno.setNome(editNome.getText().toString());
		aluno.setSite(editSite.getText().toString());
		aluno.setTelefone(editTelefone.getText().toString());
		aluno.setEndereco(editEndereco.getText().toString());
		aluno.setNota(ratingNota.getRating());
		return aluno;

	}

}
