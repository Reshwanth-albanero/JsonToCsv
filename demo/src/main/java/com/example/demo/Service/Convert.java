package com.example.demo.Service;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class Convert {
    public void change( List<Object> objects) throws JSONException, IOException {
        HashSet<String> hashSet = new HashSet<>();
        for(Object object:objects){
            JSONObject jsonObject = new JSONObject(object.toString());
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()){
                hashSet.add(keys.next());
            }
        }
        String string = "";
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            string+=iterator.next()+",";
        }
        string=string.substring(0,string.length()-1);
        string+="\n";
        for(Object object:objects){
            JSONObject jsonObject = new JSONObject(object.toString());
            Iterator<String> keys = jsonObject.keys();
            Map<String,String> map = new HashMap<>();
            while (keys.hasNext()){
                String temp = keys.next();
                map.put(temp, jsonObject.get(temp).toString());
            }
            Iterator<String> headers = hashSet.iterator();
            while (headers.hasNext()){
                String head = headers.next();
                if(map.containsKey(head)){
                    string+= map.get(head)+",";
                }
                else{
                    string+="-,";
                }
            }
            string=string.substring(0,string.length()-1);
            string+="\n";
        }
        FileWriter file = new FileWriter("/home/albanero/Downloads/JsonToCsv/demo/src/main/resources/Type-1");
        file.write(string);
        file.close();
    }

    public void doChange(List<Map<String, String>> objects) throws IOException, JSONException {
        HashSet<String> hashSet = new HashSet<>();
        for(Map<String,String> map:objects){
            hashSet.addAll(map.keySet());
        }
        String string = "";
        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            string+=iterator.next()+",";
        }
        string = string.substring(0,string.length()-1);
        string += "\n";
        for(Map<String,String> map:objects){
            Iterator<String> itr = hashSet.iterator();
            while (itr.hasNext()){
                String key = itr.next();
                if(map.containsKey(key)){
                    string+= map.get(key)+",";
                }
                else{
                    string+="-,";
                }
            }
            string = string.substring(0,string.length()-1);
            string += "\n";
        }
        FileWriter file = new FileWriter("/home/albanero/Downloads/JsonToCsv/demo/src/main/resources/Type-1");
//        file.write(string);
//        file.close();
//        Iterable<CSVRecord> records = CSVFormat.DEFAULT(new JSONObject("{\"name\":\"Raju\"}"));
//        file.write(records.toString());
//        file.close();
    }
}
