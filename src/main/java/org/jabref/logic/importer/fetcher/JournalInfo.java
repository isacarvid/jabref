package org.jabref.logic.importer.fetcher;

import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.jabref.model.JournalInfoModel;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class JournalInfo {
    private final String BASE_URL = "https://api.crossref.org/journals";
    private URL url;
    private String title = null;

    public JournalInfo(String title) throws MalformedURLException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("query", title);
        try {
            this.url = new URL(String.format("%s%s", BASE_URL,getParamsString(parameters)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(this.url.toString());
        System.out.println(this.url);

    }

    public JournalInfoModel getJournalFromAPI(){
        StringBuffer response = new StringBuffer();

        try {
            HttpURLConnection con = (HttpURLConnection) this.url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        JournalInfoModel journalInfoModel = gson.fromJson(response.toString(), JournalInfoModel.class);
        System.out.println(gson.toJson(journalInfoModel));
        return journalInfoModel;
    }

    private static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        result.append("?");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length())
                : resultString;
    }


}
