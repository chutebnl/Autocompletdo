package algoritms;

import java.util.Scanner;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * @author Braian Ledantes
 *
 * Dado un gran conjunto de palabras (más de 1 millón, por ejemplo) y un prefijo, se debe encontrar el conjunto de
 * palabras que pueden ser propuestas de autocompletado
 *
 * Dicho de otro modo, encontrar todas las palabras que comparten el prefijo dado.
 */
public class Autocompletado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un texto:");
        String texto = scanner.nextLine();
        System.out.println("Ingrese el prefijo:");
        String prefijo = scanner.nextLine().trim();

        texto = texto.toLowerCase()
                .replaceAll("[^qwertyuiopasdfghjklñzxcvbnmáíóú ]", "")
                .trim();
        String[] palabras = texto.split(" ");

        String[] coinciden = buscarConPrefijo(palabras, prefijo);

        System.out.println(texto);
        System.out.print("Palabras que coinciden con el prefijo \"" + prefijo + "\":\n[ ");
        for (String a : coinciden) {
            System.out.print(a + " ");
        }
        System.out.println("]");

    }

    static String[] buscarConPrefijo(String[] palabras, String prefijo) {
        HashSet<String> set = new HashSet<>();
        Pattern p = Pattern.compile("^" + prefijo);

        for (String palabra : palabras) {
            if (p.matcher(palabra).find()) {
                set.add(palabra);
            }
        }
        return set.toArray(new String[set.size()]);
    }

}
