package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import br.unimontes.ccet.dcc.pg1.model.entity.Aluno;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;

public class AlunoDao implements Dao<Aluno> {

    private Connection conn;

    public AlunoDao() throws SQLException {
        conn = DBSingleton.getInstancia().getConexao();
    }

    @Override
    public int save(Aluno entidade) throws DAOException {
        int linhasGravadas = 0;

        try {
            String iQuery = "INSERT INTO alunos (cpf, nome, ano_nascimento) VALUES (?,?,?)";

            PreparedStatement st = conn.prepareStatement(iQuery);
            st.setString(1, entidade.getCpf());
            st.setString(2, entidade.getNome());
            st.setInt(3, entidade.getAnoNascimento());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                System.out.println("no update");
                //TODO:
                //popup de confirmação
                return update(entidade);
            } else {
                throw new DAOException("Erro ao tentar gravar entidade Aluno. SQLSTATE: " + ex.getSQLState());
            }
        }

        return linhasGravadas;

    }

    @Override
    public int update(Aluno entidade) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String uQuery = "UPDATE alunos SET nome = ?, ano_nascimento = ? WHERE cpf = ?";

            PreparedStatement st = conn.prepareStatement(uQuery);
            st.setString(1, entidade.getNome());
            st.setInt(2, entidade.getAnoNascimento());
            st.setString(3, entidade.getCpf());

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar atualizar entidade Aluno. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public int delete(Aluno entidade) throws DAOException {
        int linhasAfetadas = 0;

        try {
            String delQuery = "DELETE from alunos WHERE cpf = ?";

            PreparedStatement st = conn.prepareStatement(delQuery);
            st.setString(1, entidade.getCpf());
            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar deletar entidade Aluno. SQLSTATE: " + ex.getSQLState());
        }

        return linhasAfetadas;
    }

    @Override
    public List<Aluno> findAll() throws DAOException {
        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            String query = "SELECT * FROM alunos order by nome asc";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Aluno aluno = new Aluno();
                String cpf = res.getString("cpf");
                String nome = res.getString("nome");
                Integer anoNascimento = res.getInt("ano_nascimento");
                aluno.setCpf(cpf);
                aluno.setNome(nome);
                aluno.setAnoNascimento(anoNascimento);
                alunos.add(aluno);

            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar todos Alunos: " + ex.getMessage());
        }

        return alunos;
    }

    @Override
    public Aluno findOne(Aluno entidade) throws DAOException {
        Aluno aluno = new Aluno(entidade.getCpf());

        try {
            String query = "SELECT * FROM alunos WHERE cpf = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, entidade.getCpf());
            ResultSet res = st.executeQuery();
            if (res.next()) {
                aluno.setCpf(res.getString("cpf"));
                aluno.setNome(res.getString("nome"));
                aluno.setAnoNascimento(res.getInt("ano_nascimento"));
                return aluno;
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar um Aluno: " + ex.getMessage());
        }

        return null;
    }

    public Aluno findCpf(Aluno entidade) throws DAOException {
        Aluno aluno = new Aluno(entidade.getCpf());

        try {
            String query = "SELECT * FROM alunos WHERE nome LIKE '%" + entidade.getNome() + "%' order by nome";
            PreparedStatement st = conn.prepareStatement(query);
            //st.setString(1, entidade.getNome());
            ResultSet res = st.executeQuery();
            if (res.next()) {
                aluno.setCpf(res.getString("cpf"));
                aluno.setNome(res.getString("nome"));
                aluno.setAnoNascimento(res.getInt("ano_nascimento"));
                return aluno;
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar encontrar um Aluno: " + ex.getMessage());
        }

        return null;
    }

    public ArrayList<Aluno> Consulta(Aluno entidade) throws DAOException {
        ArrayList<Aluno> alunos = new ArrayList();
        PreparedStatement st = null;
        try {
            String query = "SELECT * FROM alunos WHERE nome LIKE '%" + entidade.getNome() + "%' order by nome";
            st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            if (res != null) {
//                alunos = new ArrayList<>();
                while (res.next()) {
                    Aluno a = new Aluno();
                    String cpf = res.getString("cpf");
                    String nome = res.getString("nome");
                    Integer anoNascimento = res.getInt("ano_nascimento");
                    a.setCpf(cpf);
                    a.setNome(nome);
                    a.setAnoNascimento(anoNascimento);
                    alunos.add(a);

                }
            }

//        } catch (DAOException e) {
//          System.err.println("DAO Exceprion: " + e.getMessage());
        } catch (SQLException e2) {
            System.err.println("SQL Exception: " + e2.getMessage() + " SQL state: " + e2.getSQLState());
        }
        if (alunos.isEmpty()) {
            return null;

        }
        return alunos;
    }

}
