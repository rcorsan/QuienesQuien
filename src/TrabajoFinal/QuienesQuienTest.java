package TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuienesQuienTest {

	ArrayList<HashMap<String, Object>> db;

	@BeforeEach
	void setUp() {
		this.db = new ArrayList<>();
		HashMap<String, Object> p1 = new HashMap<>();
		p1.put("name", "Luisa");
		p1.put("ojomarron", true);
		p1.put("alto", false);
		p1.put("gafas", false);
		p1.put("español", true);
		p1.put("negro", false);
		p1.put("castaño", false);
		p1.put("hombre", false);
		this.db.add(p1);
		HashMap<String, Object> p2 = new HashMap<>();
		p2.put("name", "Luis");
		p2.put("ojomarron", true);
		p2.put("alto", false);
		p2.put("gafas", false);
		p2.put("español", true);
		p2.put("negro", false);
		p2.put("castaño", false);
		p2.put("hombre", true);
		this.db.add(p2);
		QuienesQuien.creacion_usuario("UsuarioPrueba");
	}

	@Test
	void testPuntuacion() {
		setUp();
		QuienesQuien.puntuacion();

		try {
			FileReader reader = new FileReader("users.json");
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
			reader.close();

			for (Object obj : jsonArray) {
				JSONObject jsonObj = (JSONObject) obj;
				JSONObject userObj = (JSONObject) jsonObj.get("user");
				String nombre = (String) userObj.get("nombre");

				if (nombre.equals(QuienesQuien.usuario)) {
					long puntuacion = (long) userObj.get("puntuacion");
					assertEquals(1, puntuacion);
				}
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	void respuestainvalida() {
		assertDoesNotThrow(() -> QuienesQuien.respuesta(4, "hombre", db));
	}

	@Test
	void testComprobar_usuarioExistente() {
		Boolean resultado = QuienesQuien.comprobar_usuario("UsuarioPrueba");
		// Comprueba que se devuelva true cuando el usuario existe
		assertEquals(true, resultado);
	}

	@Test
	void testComprobar_usuarioInexistente() {
		String nom = "UsuarionoExistente";
		// Comprueba que se devuelva false cuando el usuario no existe
		assertFalse(QuienesQuien.comprobar_usuario(nom));

	}

	@Test
	void testSet_usuario() {
		String nom = "nuevo_usuario";
		QuienesQuien.set_usuario(nom);

		// Comprueba que el usuario se asigna correctamente
		assertEquals(nom, QuienesQuien.usuario);
	}

	@Test
	void testCreacion_usuario() {
		setUp();
		// Comprueba que el nuevo usuario se haya creado correctamente mediante el
		// metodo comprobar_usuario()
		assertTrue(QuienesQuien.comprobar_usuario("UsuarioPrueba"));
	}

	@Test
	void creacion_usuario_nombreVacio() {
		String nombre = "";
		// Comprueba que se lance la excepción IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> QuienesQuien.creacion_usuario(nombre));
	}

	@Test
	void creacionfichero_comprobacion() {
		File archivo = new File("users.json");
		assertTrue(archivo.exists());
	}
	
	@AfterAll
	static void eliminarFichero() {
		// Eliminar el archivo JSON después de que se completen todas las pruebas
		File file = new File("users.json");
		if (file.exists()) {
			boolean deleted = file.delete();
			if (deleted) {
				System.out.println("Archivo JSON eliminado correctamente");
			} else {
				System.out.println("No se pudo eliminar el archivo JSON");
			}
		}
	}
}