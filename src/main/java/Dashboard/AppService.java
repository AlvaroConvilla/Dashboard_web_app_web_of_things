package Dashboard;


import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.XSD;
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
    //alarmas WeatherStation
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
    }
    public List<Boolean> estados() throws ParseException {
        //Carga los Thing
        String weather  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/weatherStation.json";
        String dome  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/dome.json";
        String mount  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/mount.json";
        String cameraDMK  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/cameraDMK.json";
        String cameraIN  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/cameraIN.json";
        String cameraOUT  = "/home/alvaro/Escritorio/dashboard/src/main/resources/dinamic/states/cameraOUT.json";
        //Fin carga de datos
        List<Boolean> lista = new LinkedList<Boolean>();

        JSONParser parser = new JSONParser();
        try {
            //Lectura Ficheros JSON
            Object objWeather = parser.parse(new FileReader(weather));
            Object objDome = parser.parse(new FileReader(dome));
            Object objMount = parser.parse(new FileReader(mount));
            Object objCameraDMK = parser.parse(new FileReader(cameraDMK));
            Object objCameraIN = parser.parse(new FileReader(cameraIN));
            Object objCameraOUT = parser.parse(new FileReader(cameraOUT));

            //Convertir en objetos
            JSONObject jsonObjWeather = (JSONObject) objWeather;
            JSONObject jsonObjDome = (JSONObject) objDome;
            JSONObject jsonObjMount = (JSONObject) objMount;
            JSONObject jsonObjCameraDMK = (JSONObject) objCameraDMK;
            JSONObject jsonObjCameraIN = (JSONObject) objCameraIN;
            JSONObject jsonObjCameraOUT = (JSONObject) objCameraOUT;

            //Estado WeatherStation --> [0]
            JSONObject data = (JSONObject) jsonObjWeather.get("data");
            String state = (String) data.get("state");
            if(state.equals("ON")){
                //System.out.println(state);
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //Estado Dome --> [1]
            data = (JSONObject) jsonObjDome.get("data");
            state = (String) data.get("state");
            if(state.equals("ON")){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //Estado Mount --> [2]
            data = (JSONObject) jsonObjMount.get("data");
            state = (String) data.get("state");
            if(state.equals("ON")){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //Estado CameraDMK --> [3]
            data = (JSONObject) jsonObjCameraDMK.get("data");
            state = (String) data.get("state");
            if(state.equals("ON")){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //Estado CameraIN --> [4]
            data = (JSONObject) jsonObjCameraIN.get("data");
            state = (String) data.get("state");
            if(state.equals("ON")){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //Estado CameraOUT --> [5]
            data = (JSONObject) jsonObjCameraOUT.get("data");
            state = (String) data.get("state");
            if(state.equals("ON")){
                lista.add(true);
            }
            else{
                lista.add(false);
            }
            //FIN dispositivos
        } catch (FileNotFoundException e) {
            //manejo de error
        } catch (IOException e) {
            //manejo de error
        } catch (ParseException e) {
            //manejo de error
        }

        return lista;
    }
    public List<Route> listarRutas(){
        String file  = "src/main/resources/static/rdf/routesautobus-updated.ttl";
        // Create an empty model
        Model model = ModelFactory.createDefaultModel();
        List<Route> lista = new LinkedList<Route>();
        // Read the Turtle file
        model.read(file);

        String queryString = "PREFIX : " + "<http://www.semanticweb.org/group12/ontology#> " +
                "PREFIX rdf: " + "<" + RDF.getURI() + "> " +
                "PREFIX owl: " + "<" + OWL.getURI() + "> " +
                "PREFIX xsd: " + "<" + XSD.getURI() + "> " +
                "PREFIX dbpedia: " + "<http://dbpedia.org/page/> "  +
                "PREFIX foaf: " + "<" + FOAF.getURI() + "> " +
                "SELECT ?ruta ?routeLine ?journey ?routeURL WHERE{ " +
                        " ?ruta a dbpedia:Route ;" +
                        " :routeLine ?routeLine ;" +
                        " :journey ?journey ;" +
                        " :routeURL ?routeURL ." +
                        "}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = qexec.execSelect();
        while (resultSet.hasNext()){
            QuerySolution binding = resultSet.nextSolution();
            Route route = new Route();
            Resource ruta = (Resource) binding.get("ruta");
            route.setIdRoute(ruta.toString());
            Literal routeLine = (Literal) binding.get("routeLine");
            route.setRouteLine(routeLine.toString());
            Literal journey = (Literal) binding.get("journey");
            route.setJourney(journey.toString());
            Literal routeURL = (Literal) binding.get("routeURL");
            route.setRouteURL(routeURL.toString());

            lista.add(route);

        }
        return lista;
    }

    public List<Integer> estadisticas(){

        List<Integer> lista = new LinkedList<Integer>();
        String file = "src/main/resources/static/rdf/stopsautobus-updated.ttl";
        Model model = ModelFactory.createDefaultModel();
        model.read(file);


        // Get the total "A" Bus Stops
        String queryString = "PREFIX geo: " + " <http://www.w3.org/2003/01/geo/wgs84_pos#> " +
                "PREFIX : " + "<http://www.semanticweb.org/group12/ontology#> " +
                "PREFIX dbpedia: " + "<http://dbpedia.org/page/> "  +
                "SELECT (count(*) as ?total) WHERE {" +
                "" +
                "   ?busStop a dbpedia:Bus_stop ;" +
                "   :stopName ?stopName ;" +
                "   :stopAddress ?stopAddress ;" +
                "   geo:lat ?geoLat ;" +
                "   geo:long ?geoLong ;" +
                "   :stopZone \"A\" ." +
                "" +
                "}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = qexec.execSelect();
        QuerySolution binding = resultSet.nextSolution();
        Literal zonaA = (Literal) binding.get("total");
        int a = zonaA.getInt();
        lista.add(a);

        // Get the total "B1" Bus Stops
        queryString = "PREFIX geo: " + " <http://www.w3.org/2003/01/geo/wgs84_pos#> " +
                "PREFIX : " + "<http://www.semanticweb.org/group12/ontology#> " +
                "PREFIX dbpedia: " + "<http://dbpedia.org/page/> "  +
                "SELECT (count(*) as ?total) WHERE {" +
                "" +
                "   ?busStop a dbpedia:Bus_stop ;" +
                "   :stopName ?stopName ;" +
                "   :stopAddress ?stopAddress ;" +
                "   geo:lat ?geoLat ;" +
                "   geo:long ?geoLong ;" +
                "   :stopZone \"B1\" ." +
                "" +
                "}";
        query = QueryFactory.create(queryString);
        qexec = QueryExecutionFactory.create(query, model);
        resultSet = qexec.execSelect();
        binding = resultSet.nextSolution();
        Literal zonaB1 = (Literal) binding.get("total");
        int b1 = zonaB1.getInt();
        lista.add(b1);

        // Get the total "B2" Bus Stops
        queryString = "PREFIX geo: " + " <http://www.w3.org/2003/01/geo/wgs84_pos#> " +
                "PREFIX : " + "<http://www.semanticweb.org/group12/ontology#> " +
                "PREFIX dbpedia: " + "<http://dbpedia.org/page/> "  +
                "SELECT (count(*) as ?total) WHERE {" +
                "" +
                "   ?busStop a dbpedia:Bus_stop ;" +
                "   :stopName ?stopName ;" +
                "   :stopAddress ?stopAddress ;" +
                "   geo:lat ?geoLat ;" +
                "   geo:long ?geoLong ;" +
                "   :stopZone \"B2\" ." +
                "" +
                "}";
        query = QueryFactory.create(queryString);
        qexec = QueryExecutionFactory.create(query, model);
        resultSet = qexec.execSelect();
        binding = resultSet.nextSolution();
        Literal zonaB2 = (Literal) binding.get("total");
        int b2 = zonaB2.getInt();
        lista.add(b2);

        // Get the total "B3" Bus Stops
        queryString = "PREFIX geo: " + " <http://www.w3.org/2003/01/geo/wgs84_pos#> " +
                "PREFIX : " + "<http://www.semanticweb.org/group12/ontology#> " +
                "PREFIX dbpedia: " + "<http://dbpedia.org/page/> "  +
                "SELECT (count(*) as ?total) WHERE {" +
                "" +
                "   ?busStop a dbpedia:Bus_stop ;" +
                "   :stopName ?stopName ;" +
                "   :stopAddress ?stopAddress ;" +
                "   geo:lat ?geoLat ;" +
                "   geo:long ?geoLong ;" +
                "   :stopZone \"B3\" ." +
                "" +
                "}";
        query = QueryFactory.create(queryString);
        qexec = QueryExecutionFactory.create(query, model);
        resultSet = qexec.execSelect();
        binding = resultSet.nextSolution();
        Literal zonaB3 = (Literal) binding.get("total");
        int b3 = zonaB3.getInt();
        lista.add(b3);

        return lista;
    }

    public GatewayStates infoParada(String idParada){
        String file = "src/main/resources/static/rdf/stopsautobus-updated.ttl";
        Model model = ModelFactory.createDefaultModel();
        model.read(file);

        String queryString = "PREFIX dbpedia: " + "<http://dbpedia.org/page/> "
                + "PREFIX : " + "<http://www.semanticweb.org/group12/ontology#>"
                + "SELECT ?stopName ?stopAddress ?stopZone WHERE { " +
                  "<http://www.semanticweb.org/group12/resources/Busstop/" + idParada + "> a dbpedia:Bus_stop ;"
                + ":stopName ?stopName ;"
                + ":stopAddress ?stopAddress ;"
                + ":stopZone ?stopZone ." +
                "}";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        ResultSet resultSet = qexec.execSelect();

        try{
            QuerySolution binding  = resultSet.nextSolution();
            Literal stopName = (Literal) binding.get("stopName");
            Literal stopAddress = (Literal) binding.get("stopAddress");
            Literal stopZone = (Literal) binding.get("stopZone");

            GatewayStates busStop = new GatewayStates();//stopName.toString(), stopAddress.toString(), stopZone.toString()
            return busStop;

        }catch (NoSuchElementException e){
            return null;
        }

    }


}
