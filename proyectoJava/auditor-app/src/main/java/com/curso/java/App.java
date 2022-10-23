package com.curso.java;

import static java.lang.System.out;
import static java.lang.System.err;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import com.google.gson.Gson;
import com.curso.java.models.Punto;
import com.curso.java.models.PuntoLista;
import com.curso.java.models.Dominios;

public class App {
    public static void main(String[] args) throws Exception{
        out.println("\t [Curso Java Maven]");
        /*if(args.length > 0){
            for(String arg: args){
                System.out.println("Hola, "+arg);
            }
        }*/

        //testA();
        out.println("\t===========================");
        //testB();
        out.println("\t===========================");
        testC();
    }

    static void testC(){
        final String strJson = "{'domains':['upes.ac.in'],'country':'India','state-province':'Dehradun','web_pages':['https://www.upes.ac.in/'],'name':'University of Petroleum and Energy Studies','alpha_two_code':'IN'}";
        Dominios dominios = new Dominios();
        List<String> domains = new ArrayList<>();
        List<String> webPages = new ArrayList<>();
        JSONObject jsonObj = null;
        JSONArray jsonArray = new JSONArray();
        try{
            out.println("Entrada: "+strJson);
            jsonObj = new JSONObject(strJson);
            if(jsonObj!=null){
                jsonArray = jsonObj.getJSONArray("domains");
                for(int i=0; i < jsonArray.length(); i++){
                    domains.add(""+jsonArray.get(i));
                }
                out.println(domains);
                jsonArray = jsonObj.getJSONArray("web_pages");
                for(int i=0; i < jsonArray.length(); i++){
                    webPages.add(""+jsonArray.get(i));
                }
                out.println(webPages);
                dominios.setAlphaTwoCode(jsonObj.getString("alpha_two_code"));
                dominios.setCountry(jsonObj.getString("country"));
                dominios.setName(jsonObj.getString("name"));
                dominios.setStateProvidence(jsonObj.getString("state-province"));
                dominios.setDomains(domains);
                dominios.setWebPages(webPages);
                out.println("Salida: "+dominios);
                out.println("URL: "+dominios.getWebPages().get(0));
            }
        }catch(JSONException jse){
            err.println("JSONException: "+jse.getMessage());
        }catch(Exception ex){
            err.println("Exception al obtener objeto: "+ex.getMessage());
        }
        
    }

    static void testB(){
        final String strJson = "{'Punto':{'x':2,'y':3},'Lista':['1','AB','NULL','765A']}";
        PuntoLista puntoLista = null; 
        List<String> lista = new ArrayList<>();
        Punto punto = new Punto(0,0);
        JSONObject jSONObject = null;
        JSONArray jSONArray = new JSONArray();
        Gson gson = new Gson();
        out.println("\t [Obtener objeto de un String JSON]");
        out.printf("Entrada: %s\n",strJson);
        try{
            jSONObject = new JSONObject(strJson);
            if(jSONObject !=null){
                out.println("El objeto jSONObject no es NULL");
                out.println("Nombre clase: "+jSONObject.get("Punto").getClass().getName());
                out.println("jSONObject: "+jSONObject.toString());

                punto = gson.fromJson(jSONObject.getJSONObject("Punto").toString(), Punto.class);
                out.println(punto);

                jSONArray = jSONObject.getJSONArray("Lista");
                out.println(jSONArray);
                
                for(int i=0; i < jSONArray.length(); i++ ){
                    lista.add(""+jSONArray.get(i));
                }

                out.println("Lista: "+lista);
                puntoLista = new PuntoLista(punto, lista);
                out.println("Salida: "+puntoLista);

            }
        }catch(JSONException jse){
            err.println("JSONException: "+jse.getMessage());
        }catch(Exception ex){
            err.println("Exception al obtener objeto: "+ex.getMessage());
        }
    }

    static void testA(){
        final String strJson = "{'x':3,'y':4}";
        JSONObject jSONObject = null;
        Punto punto = new Punto(0,0);
        out.println("\t [Obtener objeto de un String JSON]");
        out.printf("Entrada: %s\n",strJson);
        try{
            jSONObject = new JSONObject(strJson);
            punto.setX(jSONObject.getInt("x"));
            punto.setY(jSONObject.getInt("y"));
            out.printf("Salida: %s\n",punto);
        }catch(JSONException jse){
            err.println("JSONException: "+jse.getMessage());
        }catch(Exception ex){
            err.println("Exception al obtener objeto: "+ex.getMessage());
        }
    }


}
