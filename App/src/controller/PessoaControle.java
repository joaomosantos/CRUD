package controller;

import object.Pessoa;
import dao.PessoaDao;

public class PessoaControle {
    
    public void addPessoaControle(Pessoa p) {
        PessoaDao dao = new PessoaDao();
        dao.addPessoa(p);
    }
}
