package elastic.code;

import java.sql.*;

public class DataSource {

    private Connection connection;

    public DataSource() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/escola?useSSL=false", "root", "root");
            System.out.println("Conexão estabelecida!!");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Erro Driver Jdbc!" + cnfe.getLocalizedMessage());
        } catch (SQLException sqle) {
            System.out.println("Conexão falhou!");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public String getDadosProfessorPorDisciplina(String pesquisaDisciplina) {
        String sqlConsulta = "Select * from professor where disciplina like ?";

        PreparedStatement prepareStmt = null;
        ResultSet retQuery = null;
        StringBuffer dadodRet = new StringBuffer();

        try {
            prepareStmt = (PreparedStatement) this.getConnection().prepareStatement(sqlConsulta);
            prepareStmt.setString(1, "%" + pesquisaDisciplina + "%");
            retQuery = prepareStmt.executeQuery();

            if (retQuery.isBeforeFirst()) {
                while (retQuery.next()) {
                    int cod_aluno = retQuery.getInt("cod_prof"); // se sua tabela tiver essa coluna
                    String nome = retQuery.getString("nome");
                    String disciplina = retQuery.getString("disciplina");
                    Integer idade = retQuery.getInt("idade");

                    dadodRet.append("\n ID: ").append(cod_aluno).append(", Nome: ").append(nome).append(", Disciplina: ").append(disciplina)
                            .append(", Idadde: ").append(idade);
                }
            }else {
                dadodRet.append("não deu certo");
            }

        } catch (Exception e) {
            dadodRet.append("Dado não encontrado: ").append(e.getMessage());
        }
        return dadodRet.toString();
    }

    public String getDadosAlunoPorNome(String pesquisaNome) {
        String sqlConsulta = "Select * from aluno where nome like ?";

        PreparedStatement prepareStmt = null;
        ResultSet retQuery = null;
        StringBuffer dadodRet = new StringBuffer();

        try {
            prepareStmt = (PreparedStatement) this.getConnection().prepareStatement(sqlConsulta);
            prepareStmt.setString(1, "%" + pesquisaNome + "%");
            retQuery = prepareStmt.executeQuery();

            if (retQuery.isBeforeFirst()) {
                while (retQuery.next()) {
                    int cod_aluno = retQuery.getInt("cod_aluno"); // se sua tabela tiver essa coluna
                    String nome = retQuery.getString("nome");
                    String matricula = retQuery.getString("matricula");
                    Integer numdisciplinas = retQuery.getInt("numdisciplinas");

                    dadodRet.append("\n ID: ").append(cod_aluno).append(", Nome: ").append(nome).append(", Matrícula: ").append(matricula)
                            .append(", Número de disciplinas: ").append(numdisciplinas);
                }
            }else {
                dadodRet.append("não deu certo");
            }

        } catch (Exception e) {
            dadodRet.append("Dado não encontrado: ").append(e.getMessage());
        }
        return dadodRet.toString();
    }



//    public void criarTabelaAlunos() throws SQLException {
//
//        Statement stat = (Statement) connection.createStatement();
//
//        stat.executeUpdate("drop table if exists alunos;");
//        stat.executeUpdate(
//                "create table alunos (id int not null auto_increment, nome varchar(50), curso varchar(50), "
//                        + "primary key (id));");
//
//        // Verificar se existe a tabela cafes no banco de dados
//        DatabaseMetaData dbm = (DatabaseMetaData) connection.getMetaData();
//        ResultSet tabela = dbm.getTables(null, null, "alunos", null);
//
//        if (tabela.next()) {
//            System.out.println("Tabela Criada Com Sucesso!!");
//        } else {
//            System.out.println("Tabela Não Existe");
//        }
//        // connection.close();
//    }

//    public void criarTabelaProfessores() throws SQLException {
//
//        Statement stat = (Statement) connection.createStatement();
//
//        stat.executeUpdate("drop table if exists professores;");
//        stat.executeUpdate(
//                "create table professores (id int not null auto_increment, nome varchar(50), disciplina varchar(50), "
//                        + "primary key (id));");
//
//        // Verificar se existe a tabela cafes no banco de dados
//        DatabaseMetaData dbm = (DatabaseMetaData) connection.getMetaData();
//        ResultSet tabela = dbm.getTables(null, null, "professores", null);
//
//        if (tabela.next()) {
//            System.out.println("Tabela Criada Com Sucesso!!");
//        } else {
//            System.out.println("Tabela Não Existe");
//        }
//        // connection.close();
//    }
//
//    public void inserirAluno(String nome, String curso) {
//
//        try{
//            PreparedStatement prep = (PreparedStatement) connection
//                    .prepareStatement("INSERT INTO alunos (nome,curso) values (?, ?);");
//
//            prep.setString(1, nome);
//            prep.setString(2, curso);
//            prep.addBatch();
//
//            connection.setAutoCommit(false);
//            prep.executeBatch();
//            connection.setAutoCommit(true);
//
//            getDadosLimit5Alunos();
//        } catch (SQLException e){
//            System.out.println("O cadastro de dados deu errado.");
//        }
////        connection.close();
//    }
//
//    public void inserirProfessor(String nome, String disciplina) {
//
//        try{
//            PreparedStatement prep = (PreparedStatement) connection
//                    .prepareStatement("INSERT INTO professores (nome,disciplina) values (?, ?);");
//
//            prep.setString(1, nome);
//            prep.setString(2, disciplina);
//            prep.addBatch();
//
//            connection.setAutoCommit(false);
//            prep.executeBatch();
//            connection.setAutoCommit(true);
//
//            getDadosLimit5Alunos();
//        } catch (SQLException e){
//            System.out.println("O cadastro de dados deu errado.");
//        }
////        connection.close();
//    }

//    public String getDadosLimit5Alunos() {
//        StringBuffer dadodRet = new StringBuffer();
//        try {
//            PreparedStatement consultaDadosInseridos = connection.prepareStatement("SELECT * FROM alunos ORDER BY id DESC limit 5");
//            ResultSet rs = consultaDadosInseridos.executeQuery();
//
//            System.out.println("Dados na tabela alunos:");
//            while (rs.next()) {
//                int id = rs.getInt("id"); // se sua tabela tiver essa coluna
//                String nome = rs.getString("nome");
//                String curso = rs.getString("curso");
//
//                System.out.println("ID: " + id + ", Nome: " + nome + ", Curso: " + curso);
//            }
//        } catch (Exception e) {
//            dadodRet.append("Erro ao executar a consulta: "+e.getMessage());
//        }
//        return dadodRet.toString();
//    }
//
//    public void getDadosLimit5Professores() {
//        StringBuffer dadodRet = new StringBuffer();
//        try {
//            PreparedStatement consultaDadosInseridos = connection.prepareStatement("SELECT * FROM professores ORDER BY id DESC limit 5");
//            ResultSet rs = consultaDadosInseridos.executeQuery();
//
//            System.out.println("Dados na tabela professores:");
//            while (rs.next()) {
//                int id = rs.getInt("id"); // se sua tabela tiver essa coluna
//                String nome = rs.getString("nome");
//                String disciplina = rs.getString("disciplina");
//
//                System.out.println("ID: " + id + ", Nome: " + nome + ", Disciplina: " + disciplina);
//            }
//        } catch (Exception e) {
//            dadodRet.append("Erro ao executar a consulta: "+e.getMessage());
//        }
//        System.out.println(dadodRet);
//    }
//
//    public String getDadosPorNome(String tabela, String pesquisaNome) {
//        String sqlConsulta = "Select * from " + tabela + " where nome = ?";
//
//        PreparedStatement prepareStmt = null;
//        ResultSet retQuery = null;
//        StringBuffer dadodRet = new StringBuffer();
//
//        try {
//            prepareStmt = (PreparedStatement) this.getConnection().prepareStatement(sqlConsulta);
//            prepareStmt.setString(1, pesquisaNome);
//            retQuery = prepareStmt.executeQuery();
//
//            if (retQuery.isBeforeFirst()) {
//
//                while (retQuery.next()) {
//                    int id = retQuery.getInt("id"); // se sua tabela tiver essa coluna
//                    String nome = retQuery.getString(2);
//                    String cursoOuDisciplina = retQuery.getString(3);
//
//                    dadodRet.append("ID: ").append(id).append(", Gênero: ").append(nome).append(", Curso ou disciplina: ").append(cursoOuDisciplina);
//                }
//            }else {
//                dadodRet.append("Não encontrado.");
//            }
//
//        } catch (Exception e) {
//            dadodRet.append("Dado não encontrado: ").append(e.getMessage());
//        }
//        return dadodRet.toString();
//    }

}
