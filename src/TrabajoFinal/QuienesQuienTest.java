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
	
}