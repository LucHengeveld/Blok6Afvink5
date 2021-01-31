// Alles importeren
import java.util.*;

public class Afvink5Opdr2 {
    public static HashMap<String, String> eenLetter = new HashMap<>();
    public static HashMap<String, String> drieLetter = new HashMap<>();
    public static HashMap<String, String> alleLetters = new HashMap<>();

    public static void main(String[] args) {
        eenLetter.put("a", "Ala, Alanine");
        eenLetter.put("r", "Arg, Arginine");
        eenLetter.put("n", "Asn, Asparagine");
        eenLetter.put("d", "Asp, Asparaginezuur");
        eenLetter.put("c", "Cys, Cysteine");
        eenLetter.put("e", "Glu, Glutaminezuur");
        eenLetter.put("q", "Gln, Glutamine");
        eenLetter.put("g", "Gly, Glycine");
        eenLetter.put("h", "His, Histidine");
        eenLetter.put("i", "Ile, Isoleucine");
        eenLetter.put("l", "Leu, Leucine");
        eenLetter.put("k", "Lys, Lysine");
        eenLetter.put("m", "Met, Methionine");
        eenLetter.put("f", "Phe, Phenylaline");
        eenLetter.put("p", "Pro, Proline");
        eenLetter.put("s", "Ser, Serine");
        eenLetter.put("t", "Thr, Threonine");
        eenLetter.put("w", "Trp, Tryptofaan");
        eenLetter.put("y", "Tyr, Tyrosine");
        eenLetter.put("v", "Val, Valine");

        drieLetter.put("ala", "A, Alanine");
        drieLetter.put("arg", "R, Arginine");
        drieLetter.put("asn", "N, Asparagine");
        drieLetter.put("asp", "D, Asparaginezuur");
        drieLetter.put("cys", "C, Cysteine");
        drieLetter.put("glu", "E, Glutaminezuur");
        drieLetter.put("gln", "Q, Glutamine");
        drieLetter.put("gly", "G, Glycine");
        drieLetter.put("his", "H, Histidine");
        drieLetter.put("ile", "I, Isoleucine");
        drieLetter.put("leu", "L, Leucine");
        drieLetter.put("lys", "K, Lysine");
        drieLetter.put("met", "M, Metheonine");
        drieLetter.put("phe", "F, Phenylaline");
        drieLetter.put("pro", "P, Proline");
        drieLetter.put("ser", "S, Serine");
        drieLetter.put("thr", "T, Threonine");
        drieLetter.put("trp", "W, Tryptofaan");
        drieLetter.put("tyr", "Y, Tyrosine");
        drieLetter.put("val", "V, Valine");

        alleLetters.put("alanine", "A, Ala");
        alleLetters.put("arginine", "R, Arg");
        alleLetters.put("asparagine", "N, Asn");
        alleLetters.put("asparaginezuur", "D, Asp");
        alleLetters.put("cysteine", "C, Cys");
        alleLetters.put("glutaminezuur", "E, Glu");
        alleLetters.put("glutamine", "Q, Gln");
        alleLetters.put("glycine", "G, Gly");
        alleLetters.put("histidine", "H, His");
        alleLetters.put("isoleucine", "I, Ile");
        alleLetters.put("leucine", "L, Leu");
        alleLetters.put("lysine", "K, Lys");
        alleLetters.put("metheonine", "M, Met");
        alleLetters.put("phenylaline", "F, Phe");
        alleLetters.put("proline", "P, Pro");
        alleLetters.put("serine", "S, Ser");
        alleLetters.put("threonine", "T, Thr");
        alleLetters.put("tryptofaan", "W, Trp");
        alleLetters.put("tyrosine", "Y, Tyr");
        alleLetters.put("valine", "V, Val");

        int x = 0;
        while (x == 0) {
            Scanner aminozuurscanner = new Scanner(System.in);
            System.out.println("Voer een aminozuur in, dit mag zowel de 1 letterige code, 3 letterige code of " +
                    "volledige naam zijn. \nAls je wilt stoppen typ \"stop\".");
            String aminozuur = aminozuurscanner.nextLine().toLowerCase();
            int lengte = aminozuur.length();
            if (aminozuur.equals("stop")) {
                x++;
            } else if (lengte == 1) {
                System.out.println(eenLetter.get(aminozuur) + "\n");

            } else if (lengte == 3) {
                System.out.println(drieLetter.get(aminozuur) + "\n");

            } else if (lengte > 3) {
                System.out.println(alleLetters.get(aminozuur) + "\n");

            }
        }
    }
}