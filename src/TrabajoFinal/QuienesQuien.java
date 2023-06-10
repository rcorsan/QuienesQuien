package TrabajoFinal;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.random.*;
import java.util.InputMismatchException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class QuienesQuien {
	
	public static String usuario;
	
	public static void respuesta(int res, String atr, ArrayList db) {
		
		try {
			
			int ress = res;
			if(ress!=1 && ress!=2) {
				throw new InputMismatchException();
			}
			
			boolean resp;
			ArrayList eliminado = new ArrayList();
			
			if(res==1) {
				resp= true;
			}else{
				resp=false;
			}
			
			for(Object d: db){
				HashMap persona = (HashMap) d;
				boolean atri=(boolean)persona.get(atr);
				if(atri!=resp) {
					eliminado.add(persona);
				}
			}
			
			for(Object per: eliminado) {
				db.remove(per);
			}
			if(db.size()==0) {
				System.out.print("No hay ningun personaje con esas caracteristicas :(");
				System.exit(0);
			}
			if (db.size()==1) {
				HashMap persona= (HashMap)db.get(0);
				String nombre = (String)persona.get("name");
				System.out.println("El nombre de tu personaje es:"+nombre+"!!!!!");
				puntuacion();
				System.exit(0);
			}
			if (db.size()<3) {
				int num=(int) (Math.random() * (2 - 0 ) + 0);
				HashMap persona= (HashMap)db.get(num);
				String nombre = (String)persona.get("name");
				System.out.println("El nombre de tu personaje es:"+nombre+"?");
				Scanner sc = new Scanner(System.in);
				int respuesta= sc.nextInt();
				if(respuesta==1) {
					System.exit(0);
				}else {
					eliminado.add(persona);
				}
			}
			for(Object per: eliminado) {
				db.remove(per);
			}
		}catch(InputMismatchException e){
			System.out.println("Error: ingresa una respuesta valida");
			System.exit(0);
		}
		
	}
	
	public static boolean comprobar_usuario(String nom){
		File af = new File("users.json");
        if(af.exists()){
			try {
				
	            FileReader reader = new FileReader("users.json");
	            JSONParser jsonParser = new JSONParser();
	            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
	            reader.close();
	
	            for (Object obj : jsonArray) {
	                JSONObject jsonObj = (JSONObject) obj;
	                JSONObject userObj = (JSONObject) jsonObj.get("user");
	                String nombre = (String) userObj.get("nombre");
	
	                if (nombre.equals(nom)) {
	                	return true;
	                }
	                
	            }
	        } catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }
			return false;
        }else {
        	return false;
        }
		
	}
	
	public static void puntuacion() {
		try {
            FileReader reader = new FileReader("users.json");
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
            reader.close();

            for (Object obj : jsonArray) {
                JSONObject jsonObj = (JSONObject) obj;
                JSONObject userObj = (JSONObject) jsonObj.get("user");
                String nombre = (String) userObj.get("nombre");

                if (nombre.equals(usuario)) {
                	long puntuacion = (long) userObj.get("puntuacion");
                    puntuacion += 1;
                    userObj.put("puntuacion", puntuacion);
                }
            }
            FileWriter writer = new FileWriter("users.json");
            writer.write(jsonArray.toJSONString());
            writer.close();

            System.out.println("Puntuacion actualizada correctamente!");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
	}
	
	public static void set_usuario(String nom) {
		usuario=nom;
	}
	
	public static void creacion_usuario(String nombre) {
		usuario=nombre;
		JSONObject userdetails = new JSONObject();
		userdetails.put("nombre",nombre);
		userdetails.put("puntuacion", 0);
		JSONArray userlist = new JSONArray();
		JSONObject user = new JSONObject(); 
        user.put("user", userdetails);
        userlist.add(user);
        
        File af = new File("users.json");
        if(af.exists()){
        JSONParser jsonP = new JSONParser();
    	try(FileReader reader = new FileReader("users.json")){
    		 Object obj = jsonP.parse(reader);
			 JSONArray lista = (JSONArray)obj;
			 lista.add(user);
			 try(FileWriter file = new FileWriter("users.json")){
				 file.write(lista.toJSONString());
				 file.flush();
				 System.out.println("Usuario creado correctamente!");	
				}catch (IOException e){
					e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	}else {
    		try(FileWriter file = new FileWriter("users.json")){
    			file.write(userlist.toJSONString());
    			file.flush();
    			System.out.println("Usuario creado correctamente!");
    		}catch (IOException e){
    			e.printStackTrace();
    		}
    	}		
	}
	
	public static void mostrar_ranking() {
		File af = new File("users.json");
        if(af.exists()){
        	
        	JSONParser parser = new JSONParser();
            try {
                // Lee el archivo JSON
                Object obj = parser.parse(new FileReader("users.json"));

                JSONArray jsonArray = (JSONArray) obj;

                // Crea una lista para almacenar los objetos JSON
               ArrayList<JSONObject> usuarios = new ArrayList<>();

                // Recorre el arreglo JSON y obtiene los objetos JSON de los usuarios
                for (Object o : jsonArray) {
                    JSONObject jsonObject = (JSONObject) o;
                    usuarios.add(jsonObject);
                }

                // Ordena la lista de usuarios por puntuación de mayor a menor
                usuarios.sort((o1, o2) -> {
                    long puntuacion1 = (Long) ((JSONObject) o1.get("user")).get("puntuacion");
                    long puntuacion2 = (Long) ((JSONObject) o2.get("user")).get("puntuacion");
                    return Long.compare(puntuacion2, puntuacion1);
                });

                // Muestra el ranking de usuarios
                
                System.out.println("Ranking de usuarios:");
                for (JSONObject usuario : usuarios) {
                    JSONObject userObject = (JSONObject) usuario.get("user");
                    String nombre = (String) userObject.get("nombre");
                    long puntuacion = (Long) userObject.get("puntuacion");
                    System.out.println(nombre + ": " + puntuacion);
                }
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
                
            }
					
        }else {
        	System.out.println("No hay usuarios creados!");
        	System.exit(0);
        } 
    }
    
	public static void main(String[] args) {
		
		/*Base de datos*/
		boolean si= true;
		boolean no= false;
		ArrayList db = new ArrayList();
		HashMap p1 = new HashMap();p1.put("name","Raquel");p1.put("ojomarron", si);p1.put("alto",no);p1.put("gafas",no);p1.put("español",si );p1.put("negro", no);p1.put("castaño",no );p1.put("hombre", no);
		HashMap p2 = new HashMap();p2.put("name","Jeremy");p2.put("ojomarron", si);p2.put("alto",no);p2.put("gafas",si);p2.put("español",no );p2.put("negro", si);p2.put("castaño",no );p2.put("hombre", si);
		HashMap p3 = new HashMap();p3.put("name","Ricardo");p3.put("ojomarron", no);p3.put("alto",no);p3.put("gafas",no);p3.put("español",no );p3.put("negro", no);p3.put("castaño",si );p3.put("hombre", si);
		HashMap p4 = new HashMap();p4.put("name","Adrian");p4.put("ojomarron", no);p4.put("alto",si);p4.put("gafas",no);p4.put("español",si );p4.put("negro", no);p4.put("castaño",no );p4.put("hombre", si);
		HashMap p5 = new HashMap();p5.put("name","Sergio");p5.put("ojomarron", si);p5.put("alto",no);p5.put("gafas",no);p5.put("español",si );p5.put("negro", no);p5.put("castaño",si);p5.put("hombre", si);
		HashMap p6 = new HashMap();p6.put("name","Alberto");p6.put("ojomarron", si);p6.put("alto",no);p6.put("gafas",no);p6.put("español",si );p6.put("negro", si);p6.put("castaño",no);p6.put("hombre", si);
		HashMap p7 = new HashMap();p7.put("name","Alvaro Morazo");p7.put("ojomarron", no);p7.put("alto",no);p7.put("gafas",no);p7.put("español",si );p7.put("negro", no);p7.put("castaño",si );p7.put("hombre", si);
		HashMap p8 = new HashMap();p8.put("name","Alvaro Hernandez");p8.put("ojomarron", si);p8.put("alto",si);p8.put("gafas",no);p8.put("español",si );p8.put("negro", no);p8.put("castaño",si );p8.put("hombre", si);
		HashMap p9 = new HashMap();p9.put("name","Ramon");p9.put("ojomarron", no);p9.put("alto",si);p9.put("gafas",no);p9.put("español",si );p9.put("negro", no);p9.put("castaño",si );p9.put("hombre", si);
		HashMap p10 = new HashMap();p10.put("name","Linda");p10.put("ojomarron", si);p10.put("alto",no);p10.put("gafas",si);p10.put("español",si );p10.put("negro", si);p10.put("castaño",no );p10.put("hombre", no);
		HashMap p11 = new HashMap();p11.put("name","Marcos");p11.put("ojomarron", no);p11.put("alto",si);p11.put("gafas",no);p11.put("español",si );p11.put("negro", no);p11.put("castaño",si );p11.put("hombre", si);
		HashMap p12 = new HashMap();p12.put("name","Pablo");p12.put("ojomarron", si);p12.put("alto",si);p12.put("gafas",no);p12.put("español",si );p12.put("negro", no);p12.put("castaño",si);p12.put("hombre", si);
		HashMap p13 = new HashMap();p13.put("name","Maria");p13.put("ojomarron", si);p13.put("alto",no);p13.put("gafas",si);p13.put("español",si );p13.put("negro", no);p13.put("castaño",si );p13.put("hombre", no);
		db.add(p1);db.add(p2);db.add(p3);db.add(p4);db.add(p5);db.add(p6);db.add(p7);db.add(p8);db.add(p9);db.add(p10);db.add(p11);db.add(p12);db.add(p13);
		
		/*Juego*/
		
		Scanner us = new Scanner(System.in);
		System.out.println("Bienvenido al juego, dime un nombre de ususario!");
		String nombre= us.nextLine();
		if(comprobar_usuario(nombre)==true) {
			System.out.println("El usuario ya existe.");
			System.out.println("(1)¿Quieres seguir jugando con el? , (2)¿Quieres crear un nuevo usuario con otro nombre? (3)¿Quieres ver el ranking?");
			Scanner el = new Scanner(System.in);
			int eleccion=el.nextInt();
			if(eleccion==2) {
				System.out.print("Escribe el nuevo usuario");
				Scanner nu = new Scanner(System.in);
				creacion_usuario(nu.nextLine());
			}else if(eleccion==1){
				set_usuario(nombre);
			}else if(eleccion==3) {
				mostrar_ranking();
			}
		}else {
			creacion_usuario(nombre);
		}
		
		System.out.println("Reglas del juego:");
		System.out.println("Solo puedes responder con 1(si) o 2(no)");
		System.out.println("Tienes que pensar en una persona que este incluida en clase de las siguientes: ");
		for(Object d: db){
			HashMap persona = (HashMap) d;
			String nom=(String)persona.get("name");
			System.out.println(" "+nom+" ");
		}
		System.out.println("Y yo lo adivinare!");
		System.out.println("Ya estas listo para jugar!! Empezemos <3");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Tu personaje es hombre?");
		respuesta(sc.nextInt(),"hombre",db);
		System.out.println("Tu personaje tiene el pelo de color negro?");
		respuesta(sc.nextInt(),"negro",db);
		System.out.println("Tu personaje tiene el pelo de color castaño?");
		respuesta(sc.nextInt(),"castaño",db);
		System.out.println("Tu personaje tiene los ojos de color marron?");
		respuesta(sc.nextInt(),"ojomarron",db);
		System.out.println("Tu personaje se puede considerar alto (mide mas de 1.75)?");
		respuesta(sc.nextInt(),"alto",db);
		System.out.println("Tu personaje suele llevar gafas siempre?");
		respuesta(sc.nextInt(),"gafas",db);
		System.out.println("Tu personaje es español?");
		respuesta(sc.nextInt(),"español",db);		
		}
}

