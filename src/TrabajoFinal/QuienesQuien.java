package TrabajoFinal;
import java.util.*;
public class QuienesQuien {
	
	public static void respuesta(int res, String atr, ArrayList db) {
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
		
		if (db.size()==1) {
			HashMap persona= (HashMap)db.get(0);
			String nombre = (String)persona.get("name");
			System.out.println("El nombre de tu personaje es:"+nombre);
		}	
	}
	
	public static void creacion_usuario(String nombre) {
		
	}
	
	public static void main(String[] args) {
		
		/*Base de datos*/
		boolean si= true;
		boolean no= false;
		ArrayList db = new ArrayList();
		HashMap p1 = new HashMap();p1.put("name","Raquel");p1.put("oscurx",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p2 = new HashMap();p2.put("name","Linda");p2.put("oscurx",si);p2.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p3 = new HashMap();p3.put("name","Maria");p3.put("oscurx",si);p3.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p4 = new HashMap();p4.put("name","Jeremy");p4.put("oscurx",si);p4.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p5 = new HashMap();p5.put("name","Adrian T");p5.put("oscurx",no);p5.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p6 = new HashMap();p1.put("name","Alberto");p1.put("oscurx",no);p1.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p7 = new HashMap();p2.put("name","Alvaro");p2.put("oscurx",si);p2.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p8 = new HashMap();p3.put("name","Daniel");p3.put("oscurx",si);p3.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p9 = new HashMap();p4.put("name","Marcos");p4.put("oscurx",si);p4.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p10 = new HashMap();p5.put("name","Nuria");p5.put("oscurx",no);p5.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p11 = new HashMap();p1.put("name","Pablo lliso");p1.put("oscurx",no);p1.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p12 = new HashMap();p2.put("name","Firas");p2.put("oscurx",si);p2.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p13 = new HashMap();p3.put("name","Nicolas");p3.put("oscurx",si);p3.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p14 = new HashMap();p4.put("name","Pablo");p4.put("oscurx",si);p4.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p15 = new HashMap();p5.put("name","Alvaro");p5.put("oscurx",no);p5.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p16 = new HashMap();p1.put("name","Adrian F");p1.put("oscurx",no);p1.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p17 = new HashMap();p2.put("name","Daniel");p2.put("oscurx",si);p2.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p18 = new HashMap();p3.put("name","Luis");p3.put("oscurx",si);p3.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p19 = new HashMap();p4.put("name","Julian");p4.put("oscurx",si);p4.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p20 = new HashMap();p5.put("name","Luca");p5.put("oscurx",no);p5.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p21 = new HashMap();p1.put("name","Jaime");p1.put("oscurx",no);p1.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p22 = new HashMap();p2.put("name","Ricardo");p2.put("oscurx",si);p2.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p23 = new HashMap();p3.put("name","Maria");p3.put("oscurx",si);p3.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p24 = new HashMap();p4.put("name","Jeremy");p4.put("oscurx",si);p4.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p25 = new HashMap();p5.put("name","Adrian");p5.put("oscurx",no);p5.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p26 = new HashMap();p1.put("name","Raquel");p1.put("oscurx",no);p1.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p27 = new HashMap();p2.put("name","Linda");p2.put("oscurx",si);p2.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p28 = new HashMap();p3.put("name","Maria");p3.put("oscurx",si);p3.put("hombre",no);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p29 = new HashMap();p4.put("name","Jeremy");p4.put("oscurx",si);p4.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		HashMap p30 = new HashMap();p5.put("name","Adrian");p5.put("oscurx",no);p5.put("hombre",si);p1.put("hombre",no);p1.put("oMarron",si);p1.put("oAzul",si);p1.put("oVerde",si);p1.put("alto",si);p1.put("gafas",si);p1.put("fuera",si );
		db.add(p1);db.add(p2);db.add(p3);db.add(p4);db.add(p5);
		
		/*Juego*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Tu personaje es hombre?");
		respuesta(sc.nextInt(),"hombre",db);
		System.out.println("Tu personaje tiene el pelo de color oscuro?");
		respuesta(sc.nextInt(),"oscurx",db);
		System.out.println("Tu personaje es hombre?");
		respuesta(sc.nextInt(),"hombre",db);
		System.out.println("Tu personaje tiene el pelo de color oscuro?");
		respuesta(sc.nextInt(),"oscurx",db);
		System.out.println("Tu personaje es hombre?");
		respuesta(sc.nextInt(),"hombre",db);
		System.out.println("Tu personaje tiene el pelo de color oscuro?");
		respuesta(sc.nextInt(),"oscurx",db);
		System.out.println("Tu personaje es hombre?");
		respuesta(sc.nextInt(),"hombre",db);
		System.out.println("Tu personaje tiene el pelo de color oscuro?");
		respuesta(sc.nextInt(),"oscurx",db);
		System.out.println("Tu personaje es hombre?");
		respuesta(sc.nextInt(),"hombre",db);
		System.out.println("Tu personaje tiene el pelo de color oscuro?");
		respuesta(sc.nextInt(),"oscurx",db);
		System.out.println("Tu personaje es hombre?");
		respuesta(sc.nextInt(),"hombre",db);
		System.out.println("Tu personaje tiene el pelo de color oscuro?");
		respuesta(sc.nextInt(),"oscurx",db);
		
	}

}

