import java.util.HashSet;
import java.util.Set;

public class DatabaseService {
    
    private Set<String> numerosNFeRegistrados = new HashSet<>();

    public boolean existNumber(String numero) {
        return numerosNFeRegistrados.contains(numero);
    }

    public void insertLog(String numero) {
        System.out.println("DB_LOG: Inserindo " + numero);
        numerosNFeRegistrados.add(numero);
    }

    public void removeLog(String numero) {
        System.out.println("DB_LOG: Removendo " + numero);
        numerosNFeRegistrados.remove(numero);
    }
}