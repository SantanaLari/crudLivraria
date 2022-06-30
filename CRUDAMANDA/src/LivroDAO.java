import java.util.List;

public interface LivroDAO {
	void salvar(Livro l);
	List<Livro> listar(String nome);
	void excluir(Livro l);
	void atualizar(Livro l);
}
