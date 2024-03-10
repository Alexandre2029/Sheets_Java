public class calculos {

    public static String calcualrNaf(int media){

        String naf = Integer.toString((100 - media ));
        return naf;

    }

    public static String calculaSituacao(int media, int faltas, int totalAulas){
        String situacao;
        if(faltas > 0.25* totalAulas){
            situacao = "Reprovado por Faltas";
        } else if(media < 50){
            situacao = "Reprovado por Nota";
        } else if (50 <= media && media <70 ) {
            situacao = "Exame final";
        }else
            situacao = "Aprovado";

        return situacao;
    }
}
