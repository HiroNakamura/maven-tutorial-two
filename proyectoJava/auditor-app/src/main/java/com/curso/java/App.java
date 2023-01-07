package com.curso.java;

import static java.lang.System.out;
import static java.lang.System.err;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import com.google.gson.Gson;

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.stream.Stream;
import com.curso.java.models.Punto;
import com.curso.java.models.PuntoLista;
import com.curso.java.models.Dominios;
import com.curso.java.exceptions.PuntoException;
import com.curso.java.models.DataVerified;
import com.curso.java.models.VerifyData;
import com.curso.java.models.ReturnCodes;
import com.curso.java.models.Objeto;

public class App {
    public static void main(String[] args) throws Exception{
        out.println("\t [Curso Java Maven Actualizado]");
        /*if(args.length > 0){
            for(String arg: args){
                System.out.println("Hola, "+arg);
            }
        }*/

        //testA();
        out.println("\t===========================");
        //testB();
        out.println("\t===========================");
        //testC();
        out.println("\t===========================");
        //testD();
        testE();
    }

    public static void print(Object obj){
        out.println(obj);
    }

    public static void testE(){
        print("\t");
        Punto punto1 = null;
        Punto punto2 = null;
        try{
            punto2 = punto1.gePunto(-1, 0);
            print(punto2);
        }catch(PuntoException pex){
            err.println("Ha ocurrido una excepcion tipo Punto: "+pex.getMessage());
        }catch(NullPointerException npe){
            err.println("Ha ocurrido una excepcion tipo null: "+npe.getMessage());
        }

        punto1 = new Punto(1,1);
        punto2 = null;
        try{
            punto2 = punto1.gePunto(-1, 0);
            print(punto2);
        }catch(PuntoException pex){
            err.println("Ha ocurrido una excepcion tipo Punto: "+pex.getMessage());
        }catch(NullPointerException npe){
            err.println("Ha ocurrido una excepcion tipo null: "+npe.getMessage());
        }

        punto2 = null;
        try{
            punto2 = punto1.gePunto(1, 1);
            print(punto2);
        }catch(PuntoException pex){
            err.println("Ha ocurrido una excepcion tipo Punto: "+pex.getMessage());
        }catch(NullPointerException npe){
            err.println("Ha ocurrido una excepcion tipo null: "+npe.getMessage());
        }

    }

    static void testD(){ 
        //final String strJson = "{'verifyData':{'name':'Verificador','status':'Disponible','timestamp':'20221023 14:34'},'returnCodes':[{'returnCode':'FPC2300','name':'Verificador ocular','status':'Correcto'}],'lists':[{'nss':'2','td':'33'},{'nss':'NULL','td':'NULL'},{'nss':'4','td':'NULL'}]}";      
        //JSONObject jsonObj = null;
        //JSONArray jsonArray = new JSONArray();
        DataVerified dataVerified = null;
        VerifyData verifyData = null;
        ReturnCodes returnCodes = null;
        Objeto objeto1 = null;
        Objeto objeto2 = null;
        Objeto objeto3 = null;
        List<Objeto> lists = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("/home/fernando/Documentos/pruebasMaven/proyectoJava/auditor-app/src/main/java/com/curso/java/verificacion.json");
        try{
            
            dataVerified = objectMapper.readValue(file, DataVerified.class);

            if(dataVerified!=null){
                out.println("dataVerified no es NULL...");
                verifyData = dataVerified.getVerifyData();
                returnCodes = dataVerified.getReturnCodes();
                lists = dataVerified.getLists();
                objeto1 = lists.get(0);
                objeto2 = lists.get(1);
                objeto3 = lists.get(2);
                out.println("\t [Resultados]");
                out.println("DataVerified: "+dataVerified);
                out.println("VerifyData: "+verifyData);
                out.println("ReturnCodes: "+returnCodes);
                out.println("Objeto [0]: "+objeto1);
                out.println("Objeto [1]: "+objeto2);
                out.println("Objeto [2]: "+objeto3);
            }


        }
        catch(JSONException jse){
            err.println("JSONException: "+jse.getMessage());
        }catch(Exception ex){
            err.println("Exception: "+ex.getMessage());
        }
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
