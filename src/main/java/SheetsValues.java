import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.List;

public class SheetsValues {

    public static ValueRange GetValues(Sheets service, String spreadsheetId, String range) throws IOException {

        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();

        List<List<Object>> values = response.getValues();

        return response;
    }

    public static BatchUpdateValuesResponse setValues(List<ValueRange> data,Sheets service,String spreadsheetId) throws IOException {

        BatchUpdateValuesRequest batchBody = new BatchUpdateValuesRequest()
                .setValueInputOption("USER_ENTERED")
                .setData(data);
        BatchUpdateValuesResponse batchResult = service.spreadsheets().values()
                .batchUpdate(spreadsheetId, batchBody)
                .execute();

        return batchResult;
    }

}
