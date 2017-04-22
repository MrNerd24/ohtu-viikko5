package ohtu.intjoukkosovellus;

import java.util.TreeSet;

public class IntJoukko {

    TreeSet<Integer> joukko = new TreeSet<>();

    public IntJoukko() {
    }

    public IntJoukko(int kapasiteetti) {
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
    }

    public boolean lisaa(int luku) {
        return joukko.add(luku);
    }

    public boolean kuuluu(int luku) {
        return joukko.contains(luku);
    }

    public boolean poista(int luku) {
        return joukko.remove(luku);
    }

    public int mahtavuus() {
        return joukko.size();
    }

    @Override
    public String toString() {
        String ans = "{";
        for (Integer luku : joukko) {
            if (luku != joukko.first()) {
                ans += ", ";
            }
            ans += luku;
        }
        return ans + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[joukko.size()];
        int i = 0;
        for (int luku : joukko) {
            taulu[i] = luku;
            i++;
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko vastaus = new IntJoukko();
        for (int luku : a.toIntArray()) {
            vastaus.lisaa(luku);
        }
        for (int luku : b.toIntArray()) {
            vastaus.lisaa(luku);
        }
        return vastaus;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko vastaus = new IntJoukko();
        for (int luku : a.toIntArray()) {
            if (b.kuuluu(luku)) {
                vastaus.lisaa(luku);
            }
        }
        return vastaus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko vastaus = new IntJoukko();
        for (int luku : a.toIntArray()) {
            if (!b.kuuluu(luku)) {
                vastaus.lisaa(luku);
            }
        }
        return vastaus;
    }

}
