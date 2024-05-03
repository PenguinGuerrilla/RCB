
package br.unimontes.ccet.dcc.pg1.model.entity;

public class AlunoCurso {
    
    private String cpf;
    private Integer idCurso;
    private Integer creditos;

    public String getCpf() {
        return cpf;
    }

    public AlunoCurso() {
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public AlunoCurso(String cpf, Integer idCurso) {
        this.cpf = cpf;
        this.idCurso = idCurso;
    }

    public AlunoCurso(String cpf, Integer idCurso, Integer creditos) {
        this.cpf = cpf;
        this.idCurso = idCurso;
        this.creditos = creditos;
    }
    
}
