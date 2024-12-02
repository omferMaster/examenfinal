@RestController
@RequestMapping("/api")
public class endpoint {

    // Endpoint para obtener un mensaje
    @GetMapping("/saludo")
    public String saludo() {
        return "¡Hola desde Spring Boot!";
    }

    // Endpoint para enviar datos (POST)
    @PostMapping("/datos")
    public String recibirDatos(@RequestBody String datos) {
        return "Datos recibidos: " + datos;
    }
}
