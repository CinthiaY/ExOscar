package mappers;

import model.DadosOscar;
import model.Sex;

import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class DadosOscarMapper implements Function<String, DadosOscar> {

    private Sex sex;

    public DadosOscarMapper(Sex sex){
        this.sex= sex;
    }

    //    Index; Year; Age; Name; Movie
     public DadosOscar apply(String l){
         var dadosLinha = l.split("; ");
         var year = parseInt(dadosLinha[1]); //tem que importar "import static java.lang.Integer.parseInt;"
         var age = Integer.parseInt(dadosLinha[2]);
         var name = dadosLinha[3];
         var movie = dadosLinha[4];

         return new DadosOscar(year, age, name, movie, sex);
     }

}
