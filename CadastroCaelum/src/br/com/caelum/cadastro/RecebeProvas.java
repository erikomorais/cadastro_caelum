package br.com.caelum.cadastro;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RecebeProvas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recebe_provas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recebe_provas, menu);
		return true;
	}

}
