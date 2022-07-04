import Util.FileUtil;
import mappers.DadosOscarMapper;
import model.DadosOscar;
import model.Sex;
import service.OscarService;

import java.io.File;
import java.io.IOException;

public class Application {
    // exercicios
    // 1 - Importar dataset
    // 2 - Criar model que represente os dados
    // 3 - Transformar os dois arquivos em apenas 1 stream
    // 4 - Ator mais jovem a ser premiado
    // 5 - Ator com maior qtd de prêmios

    public static void main(String[] args) throws IOException {
        var fileUtil = new FileUtil<DadosOscar>("oscar_age_female.csv");
        var dadosOscar = fileUtil.readFile(new DadosOscarMapper(Sex.FEMALE));

        var fileUtil2 = new FileUtil<DadosOscar>("oscar_age_male.csv");
        dadosOscar.addAll(fileUtil2.readFile(new DadosOscarMapper(Sex.MALE)));

        var oscarService = new OscarService(dadosOscar);
        //System.out.println(dadosOscar); //teste
        oscarService.printPremiadoMaisJovem();
        System.out.println();
        oscarService.printMaisPremiado();
        System.out.println();
        oscarService.printMaisPremiado2(); //teste de outra funcao de stream



    }
}
