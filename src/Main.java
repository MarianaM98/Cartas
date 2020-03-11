/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 * @author Daniela Batz 19214
 * @author Mariana Morales 17235
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        Carta c=new Carta();
        String opcion;
        int seleccionado=0;
        
        ArrayList<Carta> cartas=new ArrayList();
        
        FactoryCartas fm = new FactoryCartas();
        Scanner s=new Scanner(System.in);
        
        System.out.println("Ingrese la abreviacion de la opcion que desea elegir: ");
        System.out.println("1. HashMap ");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        opcion = s.nextLine();
        if (opcion.equals("1") || opcion.equals("2") || opcion.equals("3")){
            seleccionado=1;
        }
        while ((seleccionado == 0)){
            System.out.println("ERROR Ingreso no valido. Por favor ingrese la abreviacion de la opcion que desea elegir: ");
            System.out.println("1. HashMap ");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            opcion = s.nextLine();
            if (opcion.equals("1") || opcion.equals("2") || opcion.equals("3")){
                seleccionado=1;
            };
        }
        Map<Integer, Carta> map = fm.FactoryCards(opcion);
        File file = new File ("cards_desc.txt");
        
        FileReader fr = new FileReader (file);
        BufferedReader br = new BufferedReader(fr);
        
        Scanner loader=new Scanner(br);
        int posicion=0;
        
        while (loader.hasNextLine()){
            posicion++;
            String linea=loader.nextLine();
            int a=linea.indexOf("|");
            String nom = linea.substring(0,a);
            String tipo = linea.substring(a+1, linea.length());
            map.put(posicion, new Carta(nom, tipo));
        }
        int respuesta=1;
        while (respuesta!=0){
            System.out.println("Ingrese el numero de la instruccion que deseas realizar");
            System.out.println("0. Salir.");
            System.out.println("1. Ver todas las cartas.");
            System.out.println("2. Mostrar la coleccion por tipo.");
            System.out.println("3. Agregar carta a la coleccion.");
            System.out.println("4. Mostrar las cartas de mi coleccion y sus cantidades.");
            System.out.println("5. Mostrar por tipo mi coleccion.");
            System.out.println("6. Mostrar tipo de carta ingresada.");
            System.out.println("");
            respuesta=s.nextInt();
            s.nextLine();
            
            if (respuesta==0){
                System.out.println("Gracias!");
            }else if(respuesta==1){
                c.mostrarCartas(map);
            }else if(respuesta==2){
                System.out.println(c.ordenarColeccion(map));
            }else if(respuesta==3){
                System.out.println("Igrese el nombre de la carta que desea agregar");
                String cartaAgregar=s.nextLine();
                if (c.buscar(map, cartaAgregar)){
                    cartas=c.agregarAColeccion(map, cartaAgregar, cartas);
                    System.out.println("Se agrego la carta a la coleccion");
                }else{
                    System.out.println("La carta ingresada no existe");
                }
            }else if(respuesta==4){
                System.out.println(c.MostrarArray(cartas));
            }else if(respuesta==5){
                System.out.println(c.ordenarMazo(cartas));
            }else if(respuesta==6){
                System.out.println("Ingrese el nombre de la carta");
                String obtenerTipo=s.nextLine();
                if (c.buscar(map, obtenerTipo)==true){
                    System.out.println(c.mostrarTipo(obtenerTipo, map));
                }else{
                    System.out.println("No se reconoce el nombre de la carta");
                }
            }else{
                System.out.println("Opcion no valida intente de nuevo");
            }
            
            
        }
        
        
    }
    
}
