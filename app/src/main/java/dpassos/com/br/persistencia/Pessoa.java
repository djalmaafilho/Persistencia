package dpassos.com.br.persistencia;

/**
 * Created by djalma on 10/06/2015.
 */
public class Pessoa {

    private String nome;
    private int idade;
    private String rg;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, String rg) {
        this.nome = nome;
        this.idade = idade;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
