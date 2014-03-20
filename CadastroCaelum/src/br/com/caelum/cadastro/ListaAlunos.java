package br.com.caelum.cadastro;

import java.util.List;

import br.com.caelum.cadastro.dao.AlunoDao;
import br.com.caelum.cadastro.modelo.Aluno;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunos extends Activity {
	private ListView listaAlunos;
	private Aluno aluno;

	private void carregaLista() {
		int layout = android.R.layout.simple_list_item_1;
		AlunoDao alunoDAO = new AlunoDao(ListaAlunos.this);
		List<Aluno> alunos = alunoDAO.getLista();
		ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(ListaAlunos.this, layout, alunos);
		listaAlunos = (ListView) findViewById(R.id.lista_alunos);
		listaAlunos.setAdapter(adapter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem_alunos);
		carregaLista();
		registerForContextMenu(listaAlunos);
		listaAlunos.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				aluno=(Aluno) adapter.getItemAtPosition(posicao);
				Toast.makeText(ListaAlunos.this, "Clique na posição" + posicao, Toast.LENGTH_SHORT).show();
			}
		});
		listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {
				aluno = (Aluno) adapter.getItemAtPosition(posicao);
				return false;
			}
		});

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuItem ligar = menu.add("Ligar");
		MenuItem sms = menu.add("Enviar SMS");
		MenuItem navegar = menu.add("Ir para o site");
		MenuItem editar = menu.add("Editar");
		MenuItem mapa = menu.add("Ver no mapa");
		MenuItem excluir = menu.add("Excluir");
		editar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent irParaFormulario = new Intent(ListaAlunos.this, Formulario.class);
				irParaFormulario.putExtra("alunoClicado", aluno);
				startActivity(irParaFormulario);
				return false;
			}
		});
		excluir.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				AlunoDao alunoDao = new AlunoDao(ListaAlunos.this);
				alunoDao.excluir(aluno);
				carregaLista();
			    return false;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_novo:
			Intent intent = new Intent(ListaAlunos.this, Formulario.class);
			startActivity(intent);
			return false;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.carregaLista();
	}

}
