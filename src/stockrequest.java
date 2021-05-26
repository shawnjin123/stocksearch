import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.net.*;
import java.io.*;

public class stockrequest {

    private String stockCode;
    private String TimeZone;
    private int interval;
    private String units;
    private int mode;


    //API connection constants
    private static final String URL = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY";
    private static final String API_KEY = "2OMRBQQZEZDZIAJV";

    public static String MINUTE = "minute";
    public static String HOUR = "hour";


    public String validateStockCode(String stockCode) {
        if (stockCode.length() == 0) {
            return "Invalid Length: Stock Code must be more than 0 digits";
        }

        return null;
    }

    public String setStockCode(String stockCode) {
        String valid = validateStockCode(stockCode);

        if (valid == null) {
            this.stockCode = stockCode;
        }

        return valid;
    }

    public String validateInterval(int interval) {
        return null;
    }

    public String setinterval(int interval) {
        String valid = validateInterval(interval);

        if (valid == null) {
            this.interval = interval;
        }
        return valid;
    }

    public String validateUnits(String units) {
        if (units.equals(MINUTE) || units.equals(HOUR)) {
            return null;
        } else {
            return "Invalid Units: Must be either " + MINUTE + ", " + HOUR;
        }
    }

    public String setUnits(String units) {
        String valid = validateUnits(units);

        if (valid == null) {
            this.units = units;
        }

        return valid;
    }

    public String getStockCode() {

        return stockCode;
    }

    public stockresponse getStockdata() throws Exception {

        String requestURL;
        requestURL = URL + "&symbol=" + stockCode;
        requestURL += "&apikey=" + API_KEY;

        URL url = new URL(requestURL);
        System.out.println(requestURL);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));



            JSONParser parser = new JSONParser();
            JSONObject stockData = (JSONObject) parser.parse(in);

            Map meta = (Map) stockData.get("Meta Data");
            String dateKey = (String) meta.get("3. Last Refreshed");

            Map allSeries = (Map) stockData.get("Monthly Time Series");
            Map firstSeries = (Map) allSeries.get(dateKey);
            String high = (String) firstSeries.get("2. high");
            String low = (String) firstSeries.get("3. low");
            System.out.println(high);
            System.out.println(low);


            //build the response object and return it
            stockresponse response = new stockresponse(stockCode, Double.parseDouble(high), Double.parseDouble(low), dateKey);
            return response;
    }
}
