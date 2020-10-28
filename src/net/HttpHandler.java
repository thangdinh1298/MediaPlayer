package net;

import entites.LivestreamInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpHandler {
    private static HttpURLConnection connection;
    private static String remoteAddress = "localhost";
    private static String remotePort = "8080";
    private static StringBuilder sb;
    private static BufferedReader reader;

    private static String getRooms() throws Exception {
        try {
            //Create connection
            URL url = new URL("http://" + remoteAddress + ":" + remotePort + "/rooms");
            connection = (HttpURLConnection) url.openConnection();

            //Setup request
            connection.setRequestMethod("GET");

            //Parse response
            int status = connection.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK) {
                throw new Exception("Cannot get rooms");
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            connection.disconnect();
        }
    }

    public static ArrayList<LivestreamInfo> GetRooms() {
        ArrayList<LivestreamInfo> result = new ArrayList<>();
        try {
            String responseBody = getRooms();
            JSONArray roomsinfo = new JSONArray(responseBody);

            for (int i = 0; i < roomsinfo.length(); i++) {
                JSONObject obj = roomsinfo.getJSONObject(i);
                result.add(new LivestreamInfo(obj.getString("RoomName"), obj.getInt("ViewerCount")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<LivestreamInfo> lives =  GetRooms();

        for (LivestreamInfo l : lives) {
            System.out.println(l);
        }
    }
}
