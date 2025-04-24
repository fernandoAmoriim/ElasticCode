package elastic.code.bcdadosnew;

import java.sql.*;
import java.util.Scanner;

public class AcessoBancoNovo {
    private Connection connection;

    public AcessoBancoNovo() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/banconovo?useSSL=false", "root", "root");
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

    public void criarTabela() throws SQLException {

        Statement stat = (Statement) connection.createStatement();

        stat.executeUpdate("drop table if exists dinossauros;");
        stat.executeUpdate(
                "create table dinossauros (codigo int not null auto_increment, genero varchar(50), especie varchar(50), "
                        + "primary key (codigo));");

        // Verificar se existe a tabela cafes no banco de dados
        DatabaseMetaData dbm = (DatabaseMetaData) connection.getMetaData();
        ResultSet tabela = dbm.getTables(null, null, "dinossauros", null);

        if (tabela.next()) {
            System.out.println("Tabela Criada Com Sucesso!!");
        } else {
            System.out.println("Tabela Não Existe");
        }
        // connection.close();
    }

    public void inserirRegTab(String genero, String especie) {

        try{
            PreparedStatement prep = (PreparedStatement) connection
                    .prepareStatement("INSERT INTO dinossauros (genero,especie) values (?, ?);");

            prep.setString(1, genero);
            prep.setString(2, especie);
            prep.addBatch();

            connection.setAutoCommit(false);
            prep.executeBatch();
            connection.setAutoCommit(true);

            getDadosLimit5();
        } catch (SQLException e){
            System.out.println("O cadastro de dados deu errado.");
        }
//        connection.close();
    }

    public String getDadosLimit5() {
        StringBuffer dadodRet = new StringBuffer();
        try {
        PreparedStatement consultaDadosInseridos = connection.prepareStatement("SELECT * FROM dinossauros ORDER BY codigo DESC limit 5");
        ResultSet rs = consultaDadosInseridos.executeQuery();

        System.out.println("Dados na tabela dinossauros:");
        while (rs.next()) {
            int id = rs.getInt("codigo"); // se sua tabela tiver essa coluna
            String genero = rs.getString("genero");
            String especie = rs.getString("especie");

            System.out.println("ID: " + id + ", Gênero: " + genero + ", Espécie: " + especie);
        }
    } catch (Exception e) {
            dadodRet.append("Erro ao executar a consulta: "+e.getMessage());
        }
        return dadodRet.toString();
    }

    public void alteraRegistro(int codigo, String genero, String especie) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String sqlConsultaPorCod = "Select codigo, genero, especie from " + "dinossauros where codigo = ?";

        String sqlAlteracao = "update dinossauros set genero = ?, especie = ?" + " where codigo = ?";

        if (genero != null && especie != null) {
            PreparedStatement prep = (PreparedStatement) connection.prepareStatement(sqlConsultaPorCod);
            prep.setInt(1, codigo);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                String confirma = "";
                System.out.println("========================================================");
                System.out.println("Dados dinossauro para Alteração");
                System.out.println("Código..: " + rs.getString("codigo"));
                System.out.println("Gênero..: " + rs.getString("genero"));
                System.out.println("Espécie.: " + rs.getString("especie"));
                System.out.println("========================================================");
                System.out.println("Esses dados que deseja alterar? (Digite sim)");
                confirma = scanner.nextLine();

                if (confirma.equalsIgnoreCase("sim")){
                    try {
                        PreparedStatement prep2 = (PreparedStatement) connection.prepareStatement(sqlAlteracao);
                        prep2.setString(1, genero);
                        prep2.setString(2, especie);
                        prep2.setInt(3, codigo);
                        prep2.execute();

                        System.out.println("Registro alterado com sucesso!");

                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }else {
                    System.out.println("Operação cancelada!");
                    System.exit(0);
                }

            } else {
                System.out.println("Registro não Encontrado!");
                System.exit(0);
            }
        } else{
            System.out.println("Os campos para alteração não podem ser nulos.");
            System.exit(0);
        }

    }

    public void deletarRegistro(int codigo) throws SQLException {
        PreparedStatement prep = (PreparedStatement) connection.prepareStatement("DELETE FROM dinossauros where codigo = ? ");
        connection.setAutoCommit(true);
        prep.setInt(1, codigo);
        prep.executeUpdate();
    }

    public String getDadosPorGenero(String pesquisaGenero) {
        String sqlConsulta = "Select * from dinossauros where genero = ?";

        PreparedStatement prepareStmt = null;
        ResultSet retQuery = null;
        StringBuffer dadodRet = new StringBuffer();

        try {
            prepareStmt = (PreparedStatement) this.getConnection().prepareStatement(sqlConsulta);
            prepareStmt.setString(1, pesquisaGenero);
            retQuery = prepareStmt.executeQuery();

            if (retQuery.isBeforeFirst()) {

                while (retQuery.next()) {
                    int id = retQuery.getInt("codigo"); // se sua tabela tiver essa coluna
                    String genero = retQuery.getString("genero");
                    String especie = retQuery.getString("especie");

                   dadodRet.append("ID: ").append(id).append(", Gênero: ").append(genero).append(", Espécie: ").append(especie);
                }
            }else {
                dadodRet.append("não deu certo");
            }

        } catch (Exception e) {
            dadodRet.append("Dado não encontrado: ").append(e.getMessage());
        }
        return dadodRet.toString();
    }

    public String getDadosPorEspecie(String pesquisaEspecie) {
        String sqlConsulta = "Select * from dinossauros where especie = ?";

        PreparedStatement prepareStmt = null;
        ResultSet retQuery = null;
        StringBuffer dadodRet = new StringBuffer();

        try {
            prepareStmt = (PreparedStatement) this.getConnection().prepareStatement(sqlConsulta);
            prepareStmt.setString(1, pesquisaEspecie);
            retQuery = prepareStmt.executeQuery();

            if (retQuery.isBeforeFirst()) {

                while (retQuery.next()) {
                    int id = retQuery.getInt("codigo"); // se sua tabela tiver essa coluna
                    String genero = retQuery.getString("genero");
                    String especie = retQuery.getString("especie");

                    dadodRet.append("ID: ").append(id).append(", Gênero: ").append(genero).append(", Espécie: ").append(especie);
                }
            }else {
                dadodRet.append("não deu certo");
            }

        } catch (Exception e) {
            dadodRet.append("Dado não encontrado: ").append(e.getMessage());
        }
        return dadodRet.toString();
    }

//    public boolean verificarInsercaoDeDados(String genero, String especie){
//
//    }

}

