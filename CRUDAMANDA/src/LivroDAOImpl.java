import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/crudLivraria";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "123456";
	private Connection con = null;
	
	LivroDAOImpl(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void salvar(Livro l) {
		String sql = "INSERT INTO livro (codigo, nome, autor, genero, qtdPagina, preco) ";
		sql += " VALUES ('" + l.getCodigo() + "', ";
		sql += " '" + l.getNome() + "',";
		sql += " '" + l.getAutor() + "',";
		sql += " '" + l.getGenero() + "',";
		sql += " '" + l.getQtdPagina() + "',";
		sql += " '" + l.getPreco() + "')";
		System.out.println("Query preparada: " + sql);
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Livro> listar(String nome) {
		String sql = "SELECT * FROM livro";
		List<Livro> livros = new ArrayList<>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Livro l = new Livro();
				l.setCodigo(rs.getString("Codigo"));
				l.setNome(rs.getString("Nome"));
				l.setAutor(rs.getString("Autor"));
				l.setGenero(rs.getString("Genero"));
				l.setQtdPagina(rs.getString("QtdPagina"));
				l.setPreco(rs.getString("Preco"));
				livros.add(l);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	@Override
	public void excluir(Livro l) {
		String sql = "DELETE FROM livro WHERE codigo = ";
		sql += "'" + l.getCodigo() + "'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Livro l) {
		String sql = "UPDATE livro SET ";
		sql += " nome = '" + l.getNome() + "', ";
		sql += " autor = '" + l.getAutor() + "', ";
		sql += " genero = '" + l.getGenero() + "', ";
		sql += " qtdPagina = '" + l.getQtdPagina() + "', ";
		sql += " preco = '" + l.getPreco() + "' ";
		sql += " WHERE codigo = ";
		sql += "'" + l.getCodigo() + "'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

}
