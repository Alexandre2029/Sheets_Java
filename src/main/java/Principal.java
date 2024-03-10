import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String... args) throws Exception {

        final String spreadsheetId = "1T5RJguZdYc_OGCud0eTlv0vkU8doZizyABBYbajEGRk";
        final String range = "engenharia_de_software!A4:I27";
        int totalAulas = 0;


        Sheets service = ServiceBuilder.buildSheetsService();

        ValueRange response = SheetsValues.GetValues(service, spreadsheetId,range);

        List<List<Object>> values = response.getValues();


        // OBTENDO TOTAL DE AULAS
        for (List row : values ) {
            totalAulas = Integer.parseInt((String) row.get(8));
            break;
        }

        List<List<Object>> valoresAdicionar = new ArrayList<>();

        for (List row : values ) {
            String notaParaAprovacao ;

            int faltas = Integer.parseInt((String) row.get(2));
            int p1 = Integer.parseInt((String) row.get(3));
            int p2 = Integer.parseInt((String) row.get(4));
            int p3 = Integer.parseInt((String) row.get(5));

            int media = (p1 + p2 + p3)/3;

          String  situacao = calculos.calculaSituacao(media, faltas, totalAulas);

            if (situacao.equals("Exame final")) {
                notaParaAprovacao = calculos.calcualrNaf(media);

            } else  notaParaAprovacao = "00";

            valoresAdicionar.add(List.of(situacao, notaParaAprovacao));
        }

        List<ValueRange> data = new ArrayList<>();
        data.add(new ValueRange()
                .setRange("G4").setValues(valoresAdicionar));

        SheetsValues.setValues(data,service,spreadsheetId);


    }

}
