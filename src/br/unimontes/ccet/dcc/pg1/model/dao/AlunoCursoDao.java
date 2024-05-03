package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.entity.AlunoCurso;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class AlunoCursoDao implements Dao<AlunoCurso> {

    private Connection conn;

    public AlunoCursoDao() throws SQLException {
        conn = DBSingleton.getInstancia().getConexao();
    }

    @Override
    public int save(AlunoCurso entidade) throws DAOException {
        int linhasGravadas = 0;

        try {
            String iQuery = "insert into alunoscursos values (?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setString(1, entidade.getCpf());
            st.setInt(2, entidade.getIdCurso());
            st.setInt(3, entidade.getCreditos());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                //System.out.println("no update");
                //TODO:
                //popup de confirmação
                return 2;
            } else {
                throw new DAOException("Erro ao tentar gravar entidade AlunoCurso. SQLSTATE: " + ex.getSQLState());
            }
        }

        return linhasGravadas;
    }

    @Override
    public int update(AlunoCurso entidade) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE alunoscursos SET cpf_aluno = ?, id_curso = ?, creditos_cursados = ? "
                    + "where cpf_aluno = ? and id_curso = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getCpf());
            st.setInt(2, entidade.getIdCurso());
            st.setInt(3, entidade.getCreditos());
            st.setString(4, entidade.getCpf());
            st.setInt(5, entidade.getIdCurso());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar atualizar entidade AlunoCurso. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(AlunoCurso entidade) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from alunoscursos WHERE cpf_aluno = ? and id_curso = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setString(1, entidade.getCpf());
            st.setInt(2, entidade.getIdCurso());
            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar deletar entidade AlunoCurso. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    public int deleteFromCpf(String cpf) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from alunoscursos WHERE cpf_aluno = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setString(1, cpf);
            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar deletar entidade AlunoCurso. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    public int deleteFromId(Integer id) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from alunoscursos WHERE id_curso = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, id);
            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar deletar entidade AlunoCurso. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public List<AlunoCurso> findAll() throws DAOException {
        ArrayList<AlunoCurso> aCursos = new ArrayList<>();

        try {
            String query = "SELECT * FROM alunoscursos order by cpf_aluno asc, id_curso asc";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                AlunoCurso aCurso = new AlunoCurso();
                String cpfAluno = res.getString("cpf_aluno");
                Integer idCurso = res.getInt("id_curso");
                Integer creditos = res.getInt("creditos_cursados");
                aCurso.setCpf(cpfAluno);
                aCurso.setIdCurso(idCurso);
                aCurso.setCreditos(creditos);
                aCursos.add(aCurso);

            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar todos AlunosCursos: " + ex.getMessage());
        }

        return aCursos;
    }

    public String findCpf(Integer dado) throws DAOException {
        String cpf = null;
        try {
            String query = "SELECT cpf_aluno FROM alunoscursos where id_curso = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, dado);
            ResultSet res = st.executeQuery();
            if (res.next()) {

                cpf = res.getString("cpf_aluno");

            }

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar por cpf: " + ex.getMessage());
        }
        return cpf;
    }

    @Override
    public AlunoCurso findOne(AlunoCurso entidade) throws DAOException {
        return null;
    }

    public ArrayList<AlunoCurso> ConsultaCpf(AlunoCurso entidade) throws DAOException {
        ArrayList<AlunoCurso> aCursos = new ArrayList();
        PreparedStatement st = null;
        try {
            String query = "SELECT * FROM alunoscursos WHERE cpf_aluno LIKE '%" + entidade.getCpf() + "%' order by cpf_aluno asc, id_curso asc";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
//                alunos = new ArrayList<>();
                while (res.next()) {
                    AlunoCurso ac = new AlunoCurso();
                    Integer idCurso = res.getInt("id_curso");
                    Integer creditos = res.getInt("creditos_cursados");
                    String cpf = res.getString("cpf_aluno");
                    ac.setCpf(cpf);
                    ac.setIdCurso(idCurso);
                    ac.setCreditos(creditos);
                    aCursos.add(ac);

                }
            }

//        } catch (DAOException e) {
//          System.err.println("DAO Exceprion: " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception em ConsultaCpf: " + e2.getMessage() + " SQL state: " + e2.getSQLState());
        }
        if (aCursos.isEmpty()) {
            return null;

        }
        return aCursos;
    }

    public ArrayList<AlunoCurso> ConsultaId(AlunoCurso entidade) throws DAOException {
        ArrayList<AlunoCurso> aCursos = new ArrayList();
        PreparedStatement st;
        try {
            String query = "SELECT * FROM alunoscursos WHERE id_curso = ? order by cpf_aluno asc, id_curso asc";
            st = conn.prepareStatement(query);
            st.setInt(1, entidade.getIdCurso());
            ResultSet res = st.executeQuery();
            if (res != null) {
//                alunos = new ArrayList<>();
                while (res.next()) {
                    AlunoCurso ac = new AlunoCurso();
                    Integer idCurso = res.getInt("id_curso");
                    Integer creditos = res.getInt("creditos_cursados");
                    String cpf = res.getString("cpf_aluno");
                    ac.setCpf(cpf);
                    ac.setIdCurso(idCurso);
                    ac.setCreditos(creditos);
                    System.out.println("cpf " + ac.getCpf());
                    aCursos.add(ac);
                    System.out.println("Adicionou: " + ac.getCpf() + " " + ac.getIdCurso() + " " + ac.getCreditos());

                }
            }

//        } catch (DAOException e) {
//          System.err.println("DAO Exceprion: " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception em ConsultaId: " + e2.getMessage() + " SQL state: " + e2.getSQLState());
        }
        if (aCursos.isEmpty()) {
            return null;

        }
        return aCursos;
    }

}
