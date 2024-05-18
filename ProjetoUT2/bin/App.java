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
// import java.util.Date;

public class App {

    public static void main(String[] args) {
        String arquivoEntrada = "C:\\Users\\johna\\OneDrive\\Documentos\\VSprojetos\\Avulços\\ProjetoUT2\\src\\games.csv";        ;
        String arquivoSaida = "C:\\Users\\johna\\OneDrive\\Documentos\\VSprojetos\\Avulços\\ProjetoUT2\\src\\games_formated_release_data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {

            String linha;
            boolean isFirstLine = true;

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");

                if (isFirstLine) {
                    bw.write(String.join(",", campos));
                    isFirstLine = false;
                } else {
                    String[] campo = new String[linha.length()];
                    System.arraycopy(campos, 0, campo, 0, 3);
                    campos[2] = retornaData(campos[2], campos[3]);
                    bw.write(String.join(",", campos));
                }
                bw.newLine();
            }

            System.out.println("Conversão concluída com sucesso");

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

    }

    public static String retornaData(String diaMes, String ano){
        String[] diaMes_alt = diaMes.split(" ");
        String data;

        data = "\"" + diaMes_alt[1];
    
        if(diaMes_alt[0].replace("\"","").equals("Jan")){
            data = data + "/01/";
        }else if(diaMes_alt[0].replace("\"","").equals("Feb")){
            data = data + "/02/";
        }else if(diaMes_alt[0].replace("\"","").equals("Mar")){
            data = data + "/03/";
        }else if(diaMes_alt[0].replace("\"","").equals("Apr")){
            data = data + "/04/";
        }else if(diaMes_alt[0].replace("\"","").equals("May")){
            data = data + "/05/";
        }else if(diaMes_alt[0].replace("\"","").equals("Jun")){
            data = data + "/06/";
        }else if(diaMes_alt[0].replace("\"","").equals("Jul")){
            data = data + "/07/";
        }else if(diaMes_alt[0].replace("\"","").equals("Aug")){
            data = data + "/08/";
        }else if(diaMes_alt[0].replace("\"","").equals("Sep")){
            data = data + "/09/";
        }else if(diaMes_alt[0].replace("\"","").equals("Oct")){
            data = data + "/10/";
        }else if(diaMes_alt[0].replace("\"","").equals("Nov")){
            data = data + "/11/";
        }else{
            data = data + "/12/";
        }

        data = data + ano.replace(" ", "");

        return data;
    }
}
