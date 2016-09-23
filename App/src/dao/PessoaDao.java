package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import object.Pessoa;
import util.HibernateUtil;

public class PessoaDao {
    private Session sessao; // Criando uma sessão do hibernate
    private Transaction trans; // Criando uma transação do hibernate;
    
    public void addPessoa(Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession(); // Iniciando uma nova sessão
            trans = sessao.beginTransaction(); // Iniciando uma nova transação;

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(p.getNome());
            pessoa.setCpf(p.getCpf());
            pessoa.setSenha(p.getSenha());
            pessoa.setNascimento(p.getNascimento());
            pessoa.setEmail(p.getEmail());
            pessoa.setTelefone(p.getTelefone());
            pessoa.setCelular(p.getCelular());

            sessao.save(pessoa); // Salvar dados Pessoa
            trans.commit(); // Gravados Pessoa no banco de dados
        } catch (Exception e) {
            e.printStackTrace(); // Caso de erro, ele me mostre a msg de erro
        } finally {
            sessao.close(); // Por fim, fecha a sessão
        }
    }
}
