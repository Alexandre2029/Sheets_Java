
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class ServiceBuilder {

    public static Sheets buildSheetsService() throws Exception {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT,SheetsCredential.getJsonFactory(),
                SheetsCredential.getCredentials(HTTP_TRANSPORT))
                .setApplicationName(SheetsCredential.getApplicationName())
                .build();

        return service;
    }

}
