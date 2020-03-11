import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marianam
 */
public class Carta {
    private String nombre;
    private String tipo;
    
    public Carta(String name, String type){
            nombre = name;
            tipo = type;
        }

    public Carta(){
    }
    //Devuelve el nobre
    public String getNombre(){
        return nombre;
    }
    //Devuelve el tipo
    public String getTipo(){
        return tipo;
    }
    //Devuelve el nombre con tipo en string
    public String toString(){
        return nombre + " -- " + tipo;
    }
    //Agraga una carta a la colección
    public ArrayList<Carta> agregarAColeccion(Map<Integer, Carta> map, String opcion, ArrayList<Carta> coleccion){
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Carta existe = carta.getValue();
            if(existe.getNombre().equals(opcion)){
                coleccion.add(new Carta(existe.getNombre(), existe.getTipo()));
                return coleccion;
            }
        }
        
        return null;
    }
    //Buscar carta enla coleccion
    public boolean buscar(Map<Integer, Carta> map, String opcion){
        for(Entry<Integer, Carta> carta : map.entrySet()){
            Carta existe = carta.getValue();
            if(existe.getNombre().equals(opcion)){
                return true;
            }
        }
        return false;
    }
    //Muestra las cartas en la coleccion
    public void mostrarCartas(Map<Integer, Carta> map){
        map.entrySet().forEach((carta) -> {
            Integer key = carta.getKey();
            Carta valor = carta.getValue();
            System.out.println(key + ". " + valor.toString());
        });
    }
    //Muestra el tipo de una carta
    public String mostrarTipo(String opcion, Map<Integer, Carta> map){
        String tipo = "";
        for (Entry<Integer, Carta> carta : map.entrySet()){
            Carta valor = carta.getValue();
            if(valor.getNombre().equals(opcion)){
                String nom = valor.getNombre();
                String tip = valor.getTipo();
                tipo = nom + " es de tipo " + tip;
            }
        }
        return tipo;
    }
    //Devuelve array de cartas
    public String MostrarArray(ArrayList<Carta> coleccion){
        String cartas = "";
        int contador = 0; 
        int monstruo = 0, hechizo = 0, trampa = 0; 
        for(Carta carta: coleccion){
            contador++;
            cartas += contador + ". " + carta.toString() + "\n";
            if(carta.getTipo().equals("Monstruo")) {
                monstruo++;
            }if(carta.getTipo().equals("Hechizo")) { 
                hechizo++;
            }if(carta.getTipo().equals("Trampa")) {
                trampa++;
            }
            else{
                
            }   
        }
        if(cartas.isEmpty()){
            return "No hay cartas";
        }else{
            cartas += "\nHay: \n" + "Monstruos: " + monstruo + "\n" + "Hechizos: " + hechizo + "\n" + "Trampas: " + trampa + "\n";
        }
        return cartas;
    }
    //Ordena las cartas
    public String ordenarMazo(ArrayList<Carta> mazo){
        Collections.sort(mazo, (Carta c1, Carta c2) -> c1.getTipo().compareTo(c2.getTipo()));
        String a = "";
        
        
        return MostrarArray(mazo);
    }
    //Ordena toda la coleccion de cartas
    public String ordenarColeccion(Map<Integer, Carta> map){
        Carta[] cartas = new Carta[map.size()];
        ArrayList<Carta> arreglo = new ArrayList<>();
        for (Entry<Integer, Carta> nueva : map.entrySet()){
            Carta valor = nueva.getValue();
            Carta nueva1 = new Carta(valor.getNombre(), valor.getTipo());
            arreglo.add(nueva1);
        }        
        Collections.sort(arreglo, (Carta c1, Carta c2) -> c1.getTipo().compareTo(c2.getTipo()));
        for(int i = 0; i < arreglo.size(); i++){
            cartas[i] = arreglo.get(i);
        }
        return ordenarMazo(arreglo);
    }
    //Cuenta las cartas por el tipo 
    public String contar(ArrayList<Carta> coleccion){
        String cartas = ""; 
        int contador = 0;
        int monstruo = 0, hechizo = 0, trampa = 0; 
        for(Carta carta: coleccion){
            contador++;
            cartas += contador + ". " + carta.toString() + "\n";
            
            if(carta.getTipo().equals("Monstruo")){
                monstruo++;
            }else if(carta.getTipo().equals("Hechizo")){
                hechizo++;
            }else if(carta.getTipo().equals("Trampa")){
                trampa++;
            }
        }
        
        if(cartas.isEmpty()){
            return "No hay cartas existentes";
        }else{
            cartas += "\nExisten: \n"+ "Monstruos: " + monstruo + "\n" + "Hechizos: " + hechizo + "\n"+ "Trampas: " + trampa + "\n";
        }                
        
        return cartas;
    }
}