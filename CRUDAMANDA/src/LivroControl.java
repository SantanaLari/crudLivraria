import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LivroControl {
	
	private ObservableList<Livro> livros = FXCollections.observableArrayList();
	private LivroDAOImpl dao = new LivroDAOImpl();
	private StringProperty codigo = new SimpleStringProperty();
	private StringProperty nome = new SimpleStringProperty(); 
	private StringProperty autor = new SimpleStringProperty();
	private StringProperty genero = new SimpleStringProperty();
	private StringProperty qtdPagina = new SimpleStringProperty();
	private StringProperty preco = new SimpleStringProperty();
	
	public StringProperty codigoProperty() {
		return codigo;
	}
	public StringProperty nomeProperty() {
		return nome;
	}
	public StringProperty autorProperty() {
		return autor;
	}
	public StringProperty generoProperty() {
		return genero;
	}
	public StringProperty qtdPaginaProperty() {
		return qtdPagina;
	}
	public StringProperty precoProperty() {
		return preco;
	}
	
	public void salvar() {
		Livro l = new Livro();
		l.setCodigo(codigo.get());
		l.setNome(nome.get());
		l.setAutor(autor.get());
		l.setGenero(genero.get());
		l.setQtdPagina(qtdPagina.get());
		l.setPreco(preco.get());
		dao.salvar(l);
	}	
	
	public void listar() {
		List<Livro> encontrados = dao.listar(nome.get());
		livros.clear();
		livros.addAll(encontrados);
	}
	
	public void excluir() {
		Livro l = new Livro();
		l.setCodigo(codigo.get());
		dao.excluir(l);
		listar();
	}
	
	public void atualizar() {
		Livro l = new Livro();
		l.setCodigo(codigo.get());
		l.setNome(nome.get());
		l.setAutor(autor.get());
		l.setGenero(genero.get());
		l.setQtdPagina(qtdPagina.get());
		l.setPreco(preco.get());
		dao.atualizar(l);
		listar();
	}
	
	public ObservableList<Livro> getLivro(){
		return livros;
	}
}
