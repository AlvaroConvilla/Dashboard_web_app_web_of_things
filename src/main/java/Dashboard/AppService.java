package Dashboard;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

@Service
public class AppService {
    /*//alarmas WeatherStation
    String HighTemperature = "OFF";
    String LowTemperature = "OFF";
    String Rain = "OFF";
    String StrongWind = "OFF";
    //Fin alarmas

    public List<Boolean> alarmas() throws ParseException {
        //Carga de los datos
        String WStemperature  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/alarms/WStemperature.json";
        String WSrain  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/alarms/WSrain.json";
        String WSwind  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/alarms/WSwind.json";
        //Fin carga de datos

        List<Boolean> lista = new LinkedList<Boolean>();
        JSONParser parser = new JSONParser();
        try {
            //Lectura Ficheros JSON
            Object objWStemperature = parser.parse(new FileReader(WStemperature));
            Object objWSrain = parser.parse(new FileReader(WSrain));
            Object objWSwind = parser.parse(new FileReader(WSwind));

            //Convertir en objetos
            JSONObject jsonObjWStemperature = (JSONObject) objWStemperature;
            JSONObject jsonObjWSrain = (JSONObject) objWSrain;
            JSONObject jsonObjWSwind = (JSONObject) objWSwind;

            // HighTemperature--> [0]
            JSONObject data = (JSONObject) jsonObjWStemperature.get("data");
            long temp = (long) data.get("temperature");
            //System.out.println(temp);
            if(temp >= 45){
                //System.out.println(temp);
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //LowTemperature --> [1]
            if(temp<=0){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //Rain --> [2]
            data = (JSONObject) jsonObjWSrain.get("data");
            long rain = (long) data.get("rainfall");
            if(rain >=0){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //Estado CameraDMK --> [3]
            data = (JSONObject) jsonObjWSwind.get("data");
            double wind = (double) data.get("windSpeed");
            if(wind > 30.0){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //FIN alarmas
        } catch (FileNotFoundException e) {
            //manejo de error
        } catch (IOException e) {
            //manejo de error
        } catch (ParseException e) {
            //manejo de error
        }

        return lista;
    }*/

}