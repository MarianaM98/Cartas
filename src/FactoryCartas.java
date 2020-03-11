/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.*;
/**
 *
 * @author marianam
 */
public class FactoryCartas {
    //Devuelve el tipo de mapa
    public Map FactoryCards(String tipoSet) {

        if(tipoSet.equals("1")) {
            return new HashMap();

        } if(tipoSet.equals("2")) {
            return new TreeMap();

        } if(tipoSet.equals("3")) {
            return new LinkedHashMap();
        }
        return null;
    }
      
}
