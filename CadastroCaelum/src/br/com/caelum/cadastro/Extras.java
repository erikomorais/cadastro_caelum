package br.com.caelum.cadastro;

public enum Extras {
	 ALUNO_SELECIONADO("alunoSelecionado");
	
    private Extras(final String text) {
        this.text = text;
    }

    private final String text;

    @Override
    public String toString() {
        return text;
    }
}
