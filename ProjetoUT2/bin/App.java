package Application;

/*
== TRANSFORMAÇÕES ==

    Para as transformações utilizaremos apenas o arquivo “games.csv”

    1- Converta todas as datas de lançamento (campo Release date) para o formato DD/MM/AAAA.

    Gerar um arquivo chamado “games_formated_release_data.csv”

    2- Use o arquivo gerado na primeira transformação (games_formated_release_data.csv) para 
    filtrar todos os games compatíveis com o sistema operacional linux. (campo Linux).

    Gerar um arquivo chamado “games_linux.csv”
    
    3- Use o arquivo gerado na primeira transformação (games_formated_release_data.csv) para 
    filtrar todos os games que tem suporte a língua portuguesa. (campo: Supported languages).

    Gerar um arquivo chamado “portuguese_supported_games.csv”.

== ORDENAÇÕES ==

    Para as ordenações, devemos considerar como entrada dos dados o arquivo resultando da pri-
    meira transformação. (o arquivo games_formated_release_data.csv).

    Lembrando que para cada questão abaixo devem ser utilizados todos os algoritmos de ordena-
    ção recomendados na descrição do projeto, sendo assim você deve gerar um arquivo diferente
    para cada algoritmo de ordenação / caso.

    Sobre os casos, para efeito de análise dos algoritmos deve-se trabalhar com 3 casos (melhor,
    médio e pior) para cada um dos algoritmos.

    1- Ordenar o arquivo pela data de lançamento dos games (campo Release date) em ordem crescente.

        1. Atenção existem alguns algoritmos onde essa ordenação pode não se aplicar.
        2. Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo: 
        games_release_date_insertionSort_medioCaso.csv.
    
    2- Ordenar o arquivo pelo preço dos games (campo Price) em ordem crescente.

        1. Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo: 
        games_price_insertionSort_medioCaso.csv.

    3- Ordenar o arquivo de forma decrescente pelo número de conquistas que os games possuem. (campo Achievements).

        1. Deve-se gerar um arquivo para cada algoritmo de ordenação e o tipo de caso. Por exemplo: 
        games_achievements_insertionSort_medioCaso.csv.

*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fixex {

    public static void main(String[] args) {
        String arquivoEntrada = "ProjetoUT2\\bin\\Docs\\games_test.csv";
        String arquivoSaida = "ProjetoUT2\\bin\\Docs\\games_formated_release_data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
                BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {

            String linha;
            boolean isFirstLine = true;

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");

                if (isFirstLine) {
                    bw.write(String.join(",", campos));
                    isFirstLine = false;
                }
                
                if (campos.length > 7) {
                    campos[2] = campos[2] + campos[3];
                    campos[2] = retornaData(campos[2]);
                    List<String> novaLinha = new ArrayList<>();
                    for (int i = 0; i < campos.length; i++) {
                        if (i != 3 && i != 9) {
                            novaLinha.add(campos[i]);
                        }
                    }
                    bw.write(String.join(",", novaLinha));
                    bw.newLine();
                } else {
                    bw.write(linha);
                    bw.newLine();
                }
            }

            System.out.println("Conversão concluída com sucesso");

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

    }

    public static String retornaData(String data) {
        String[] data_alt = data.split(" "); 
        
        if (data_alt[0].equals("\"Jan")) {
            data = data_alt[1] + "/01/" + data_alt[2];
        } else if (data_alt[0].equals("\"Feb")) {
            data = data_alt[1] + "/02/" + data_alt[2];
        } else if (data_alt[0].equals("\"Mar")) {
            data = data_alt[1] + "/03/" + data_alt[2];
        } else if (data_alt[0].equals("\"Apr")) {
            data = data_alt[1] + "/04/" + data_alt[2];
        } else if (data_alt[0].equals("\"May")) {
            data = data_alt[1] + "/05/" + data_alt[2];
        } else if (data_alt[0].equals("\"Jun")) {
            data = data_alt[1] + "/06/" + data_alt[2];
        } else if (data_alt[0].equals("\"Jul")) {
            data = data_alt[1] + "/07/" + data_alt[2];
        } else if (data_alt[0].equals("\"Aug")) {
            data = data_alt[1] + "/08/" + data_alt[2];
        } else if (data_alt[0].equals("\"Sep")) {
            data = data_alt[1] + "/09/" + data_alt[2];
        } else if (data_alt[0].equals("\"Oct")) {
            data = data_alt[1] + "/10/" + data_alt[2];
        } else if (data_alt[0].equals("\"Nov")) {
            data = data_alt[1] + "/11/" + data_alt[2];
        } else if (data_alt[0].equals("\"Dec")) {
            data = data_alt[1] + "/12/" + data_alt[2];
        }

        data = "\"" + data;

        return data;
    }
}
