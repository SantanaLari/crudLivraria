import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LivroBoundary extends Application {

	private Label lblCodigo = new Label("Codigo: ");
	private Label lblNome = new Label("Nome: ");
	private Label lblAutor = new Label("Autor: ");
	private Label lblGenero = new Label("Genero: ");
	private Label lblQtdPagina = new Label("qtdPaginas: ");
	private Label lblPreco = new Label("Preco: ");
	private TextField txtCodigo = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtAutor = new TextField();
	private TextField txtGenero = new TextField();
	private TextField txtQtdPagina = new TextField();
	private TextField txtPreco  = new TextField();
	private Button btnSalvar = new Button("Salvar");
	private Button btnListar = new Button("Listar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnAtualizar = new Button("Atualizar");
	private LivroControl control = new LivroControl();
	private TableView<Livro> table = new TableView<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane principal = new BorderPane();
		GridPane grid = new GridPane(); 
		principal.setTop(grid); 
		principal.setCenter(table); 
		Scene scn = new Scene(principal, 400,400);
		
		grid.add(lblCodigo, 0, 0);
		grid.add(lblNome, 0, 1);
		grid.add(lblAutor, 0, 2);
		grid.add(lblGenero, 0, 3);
		grid.add(lblQtdPagina, 0, 4);
		grid.add(lblPreco, 0, 5);
		
		grid.add(txtCodigo, 1, 0);
		grid.add(txtNome, 1, 1);
		grid.add(txtAutor, 1, 2);
		grid.add(txtGenero, 1, 3);
		grid.add(txtQtdPagina, 1, 4);
		grid.add(txtPreco, 1, 5);
		
		grid.add(btnSalvar, 0, 6);
		grid.add(btnListar, 1, 6);
		grid.add(btnExcluir, 2, 6);
		grid.add(btnAtualizar, 3, 6);
		
		Bindings.bindBidirectional(control.codigoProperty(), txtCodigo.textProperty());
		Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
		Bindings.bindBidirectional(control.autorProperty(), txtAutor.textProperty());
		Bindings.bindBidirectional(control.generoProperty(), txtGenero.textProperty());
		Bindings.bindBidirectional(control.qtdPaginaProperty(), txtQtdPagina.textProperty());
		Bindings.bindBidirectional(control.precoProperty(), txtPreco.textProperty());
		
		TableColumn<Livro, String> col1 = new TableColumn<>("Codigo");
		col1.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		
		TableColumn<Livro, String> col2 = new TableColumn<>("Nome");
		col2.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Livro, String> col3 = new TableColumn<>("Autor");
		col3.setCellValueFactory(new PropertyValueFactory<>("autor"));
		
		TableColumn<Livro, String> col4 = new TableColumn<>("Genero");
		col4.setCellValueFactory(new PropertyValueFactory<>("genero"));
		
		TableColumn<Livro, String> col5 = new TableColumn<>("qtdPagina");
		col5.setCellValueFactory(new PropertyValueFactory<>("qtdPagina"));
		
		TableColumn<Livro, String> col6 = new TableColumn<>("Preco");
		col6.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		table.getColumns().addAll(col1, col2, col3, col4, col5, col6);
		
		table.setItems(control.getLivro());
		
		btnSalvar.setOnAction((e) -> {
			control.salvar();
		});
		
		btnListar.setOnAction((e) -> {
			control.listar();
		});	
		
		btnExcluir.setOnAction((e) -> {
			control.excluir();
		});
		
		btnAtualizar.setOnAction((e) -> {
			control.atualizar();
		});
		
		stage.setScene(scn);
		stage.setTitle("Cadastro de livros");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
