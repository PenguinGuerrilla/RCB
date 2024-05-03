package br.unimontes.ccet.dcc.pg1.model.entity;

public class Aluno implements Comparable<Aluno> {

    private String cpf;
    private String nome;
    private Integer anoNascimento;

    public Aluno(String cpf, String nome, Integer anoNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public Aluno(String cpf) {
        this.cpf = cpf;
        this.nome = null;
        this.anoNascimento = 0;
    }

    public Aluno() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return "Aluno (" + cpf + "): " + nome;
    }

    @Override
    public int compareTo(Aluno t) {
        return cpf.compareTo(t.getCpf());
    }

}
