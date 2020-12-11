package io.swagger.api.impl;

import io.swagger.api.impl.*;
import io.swagger.model.TomaTemperatura;

import java.util.ArrayList;
import java.util.List;

import java.net.Socket;
import java.io.DataOutputStream;

public class server{
    
    private List<pairUserTemp> userTempList;
    private static server instance;
    
    private server(){
        //Adding some entries to the server
        userTempList = new ArrayList<>(); ;
    }
    
    public static server getInstance(){
        if(instance == null){
            instance = new server();
        }
        return instance;
    }

    public void setUserTemp(String user, TomaTemperatura temp){
        Socket conn = null;
        DataOutputStream dos = null;
        
            try {
                if(temp.getTemperatura() > 37 && temp.getPulso() > 100){
                    conn = new Socket("da2ae0dd.carbon.hostedgraphite.com", 2003);
                    dos = new DataOutputStream(conn.getOutputStream());
                    dos.writeBytes("a17d2a80-1dc6-4372-8edb-29a65eeec5ba.sla.errorAlerta 1\n");
                    if(conn != null && !conn.isClosed()){
                        conn.close();
                    }
                }else{
                    conn = new Socket("da2ae0dd.carbon.hostedgraphite.com", 2003);
                    dos = new DataOutputStream(conn.getOutputStream());
                    dos.writeBytes("a17d2a80-1dc6-4372-8edb-29a65eeec5ba.sla.noErrorAlerta 0\n");
                    if(conn != null && !conn.isClosed()){
                        conn.close();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        
        System.out.println("SendTemp.java - User de para: " + user + " User de temp : " + temp.getIdUser() + " temp: " + temp.getTemperatura() + " pulso: " + temp.getPulso() + " timestamp " + temp.getTimestamp());
        boolean found = false;
        for (int i = 0; i <userTempList.size() && !found; i++) {
            if(userTempList.get(i).getUser() == user){
                userTempList.get(i).addTemp(temp);
                found = true;
            }
        }
    }

    public pairUserTemp getUserAllTemps(String user){
        pairUserTemp result = null;
        boolean breakLoop = false;

        for (int i = 0; i < userTempList.size() && !breakLoop; i++) {
            result = userTempList.get(i);
            if(result.getUser() == user){
                breakLoop = true;
            }
        }

        return result;
    }

        public TomaTemperatura getUserTemp(String user, String timestamp){
        TomaTemperatura result = null;
        boolean breakLoop = false;

        for (int i = 0; i < userTempList.size() && !breakLoop; i++) {
            if(userTempList.get(i).getUser() == user){
                breakLoop = true;
                result = userTempList.get(i).getTemp(timestamp);
            }
        }

        return result;
    }

    public int deleteUser(String user){
        int result;
        boolean found = false;
        for (int i = 0; i < userTempList.size() && !found; i++) {
            if(userTempList.get(i).getUser() == user){
                userTempList.remove(i);
                found = true;
            }
        }
        if(found){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }
}