package io.swagger.api.impl;

import io.swagger.model.TomaTemperatura;
import java.util.List;

public class pairUserTemp{
    String user;
    List<TomaTemperatura> temps;

    public pairUserTemp(String user, List<TomaTemperatura> temps){
        this.user = user;
        this.temps = temps;
    }

    public void setUser(String user){
        this.user= user;
    }

    public void addTemp(TomaTemperatura temp){
        temps.add(temp);
    }

    public String getUser(){
        return this.user;
    }

    public List<TomaTemperatura> getAllTemps(){
        return this.temps;
    }

    public TomaTemperatura getTemp(String timestamp){
        TomaTemperatura result = null;
        boolean found = false;

        for (int i = 0; i < temps.size() && !found; i++) {
            if(temps.get(i).getTimestamp() == timestamp){
                result = temps.get(i);
                found = true;
            }
        }

        return result;
    }
    
}