package elastic.code.bcdadosnew;

import java.sql.SQLException;
import java.util.Scanner;

public class ChamadasBancoNovo {
    public static void main(String[] args) throws SQLException {
        AcessoBancoNovo abn = new AcessoBancoNovo();

        abn.criarTabela();
        abn.inserirRegTab("Dinossauro", "Trex");
        abn.alteraRegistro(1,"Yukio", "japones");
//      abn.deletarRegistro(4);
        String resposta = abn.getDadosPorGenero("Yukio");
        System.out.println(resposta);


//        Scanner scan = new Scanner(System.in);
//        System.out.println("Informe o nome do café que deseja pesquisar:");
//        String nomeCafe = scan.nextLine();
//
//        System.out.println(abn.getDadosCafe(nomeCafe));

    }
}
