package br.com.caelum.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem_alunos);
		ListView lista = (ListView) findViewById(R.id.lista_alunos);
		
		int layout = android.R.layout.simple_list_item_1;
		String[] nomes = {"s","Jose","Felipe"};
		ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, layout, nomes);
		
		lista.setAdapter(adapter);
		lista.setOnItemClickListener(  new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,long id) {
				Toast.makeText(ListaAlunos.this, "Clique na posi��o"+posicao, Toast.LENGTH_SHORT).show();
				
			}
			
		});
		
		lista.setOnItemLongClickListener(  new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {
				
				Toast.makeText(ListaAlunos.this, "Clique longo no item "+ adapter.getItemAtPosition(posicao), Toast.LENGTH_SHORT).show();
				return true;
			}

			
			
		});
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.lista_alunos, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		int itemClicado = item.getItemId(); 
		switch (itemClicado) {
		case R.id.novo:
			Intent irParaFormulario =  new Intent(this,CreateAluno.class);
			startActivity(irParaFormulario);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
 