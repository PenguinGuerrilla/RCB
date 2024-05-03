package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Curso;
import java.net.ConnectException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CursoDao implements Dao<Curso> {

    private Connection conn;

    public CursoDao() throws SQLException {
        conn = DBSingleton.getInstancia().getConexao();
    }

    @Override
    public int save(Curso entidade) throws DAOException {
        int linhasGravadas = 0;

        try {
            String iQuery = "INSERT INTO cursos (id, nome, creditos) VALUES (?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setInt(1, entidade.getId());
            st.setString(2, entidade.getNome());
            st.setInt(3, entidade.getCreditos());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                //TODO:
                //popup de confirmação
                System.out.println("no update");
                return update(entidade);
            } else {
                throw new DAOException("Erro ao tentar gravar entidade Curso. SQLSTATE: " + ex.getSQLState());
            }
        }

        return linhasGravadas;

    }

    @Override
    public int update(Curso entidade) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE cursos SET creditos = ?, nome = ? WHERE id = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setInt(1, entidade.getCreditos());
            st.setString(2, entidade.getNome());
            st.setInt(3, entidade.getId());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar atualizar entidade Curso. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Curso entidade) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from cursos WHERE id = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setInt(1, entidade.getId());
            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar deletar entidade Curso. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public ArrayList<Curso> findAll() throws DAOException {
        ArrayList<Curso> cursos = new ArrayList<>();

        try {
            String query = "SELECT * FROM cursos order by id";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Integer id = res.getInt("id");
                String nome = res.getString("nome");
                Integer creditos = res.getInt("creditos"); //n funcion????
                cursos.add(new Curso(id, nome, creditos));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar todos Cursos: " + ex.getMessage());
        }

        return cursos;
    }

    @Override
    public Curso findOne(Curso entidade) throws DAOException {
        Curso curso = new Curso();
        curso.setNome(entidade.getNome());

        try {
            String query = "SELECT * FROM cursos WHERE nome = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, entidade.getNome());
            ResultSet res = st.executeQuery();
            if (res.next()) {
                curso.setId(res.getInt("id"));
                curso.setCreditos(res.getInt("creditos"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar um Curso: " + ex.getMessage());
        }

        return curso;
    }

    public ArrayList<Curso> Consulta(Curso entidade) throws DAOException {
        ArrayList<Curso> cursos = new ArrayList();
        PreparedStatement st = null;
        try {
            String query = "SELECT * FROM cursos WHERE nome LIKE '%" + entidade.getNome() + "%' order by nome";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
//                alunos = new ArrayList<>();
                while (res.next()) {
                    Curso a = new Curso();
                    Integer id = res.getInt("id");
                    String nome = res.getString("nome");
                    Integer creditos = res.getInt("creditos");
                    a.setId(id);
                    a.setNome(nome);
                    a.setCreditos(creditos);
                    cursos.add(a);

                }
            }

//        } catch (DAOException e) {
//          System.err.println("DAO Exceprion: " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception: " + e2.getMessage() + " SQL state: " + e2.getSQLState());
        }
        if (cursos.isEmpty()) {
            return null;

        }
        return cursos;
    }

    public Curso findId(Curso entidade) throws DAOException {
        Curso curso = new Curso();
        try {
            String query = "SELECT * FROM cursos WHERE nome LIKE '%" + entidade.getNome() + "%' order by nome";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res.next()) {
                curso.setId(res.getInt("id"));
                curso.setNome(res.getString("nome"));
                curso.setCreditos(res.getInt("creditos"));
                return curso;
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar um Curso: " + ex.getMessage());
        }

        return null;
    }

}
