package bsu.comp152;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Model {
    private HttpClient dataGrabber;
    //private String webLocation;


    public Model() {
        dataGrabber = HttpClient.newHttpClient();
    }

    public GoTData GetData(String webLocation) {
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch(IOException e){
            System.out.println("Error connecting to network or site");
        }
        catch (InterruptedException e){
            System.out.println("Connection to site broken");
        }
        if (response == null ){
            System.out.println("Something went terribly wrong, ending program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        var thronesData = jsonInterpreter.fromJson(usefulData, GoTData.class);
        return thronesData;
    }

}

class GoTData{
    String url;
    String name;
    String gender;
    String culture;
    String born;
    String died;
    ArrayList<String> titles;
    ArrayList<String> aliases;
    String father;
    String mother;
    String spouse;
    ArrayList<String> allegiances;
    ArrayList<String> books;
    ArrayList<String> povBooks;
    ArrayList<String> tvSeries;
    ArrayList<String> playedBy;
}