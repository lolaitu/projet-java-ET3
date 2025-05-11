package struct.entity;

public class Personne {
    String Nom;
    int rangChallenges2024;
    int milliardaireForbes2024;
    int rangChallenges2023;
    int milliardaireForbes2023;
    int rangChallenges2022;
    int milliardaireForbes2022;
    int rangChallenges2021;
    int milliardaireForbes2021;

    public Personne(String nom, int r24, int f24, int r23, int f23, int r22, int f22, int r21, int f21){
        Nom = nom;
        rangChallenges2024 = r24;
        milliardaireForbes2024 = f24;
        rangChallenges2023 = r23;
        milliardaireForbes2023 = f23;
        rangChallenges2022 = r22;
        milliardaireForbes2022 = f22;
        rangChallenges2021 = r21;
        milliardaireForbes2021 = f21;
    }

    public String getNom() {
        return Nom;
    }

    public int getRangChallenges2024() {
        return rangChallenges2024;
    }

    public int getMilliardaireForbes2024() {
        return milliardaireForbes2024;
    }

    public int getRangChallenges2023() {
        return rangChallenges2024;
    }

    public int getMilliardaireForbes2023() {
        return milliardaireForbes2024;
    }

    public int getRangChallenges2022() {
        return rangChallenges2024;
    }

    public int getMilliardaireForbes2022() {
        return milliardaireForbes2024;
    }

    public int getRangChallenges2021() {
        return rangChallenges2024;
    }

    public int getMilliardaireForbes2021() {
        return milliardaireForbes2024;
    }

    @Override
    public String toString() {
        return Nom + buildRankString(" C", rangChallenges2024, rangChallenges2023, rangChallenges2022, rangChallenges2021)
                + buildRankString(" F", milliardaireForbes2024, milliardaireForbes2023, milliardaireForbes2022, milliardaireForbes2021);
    }

    private String buildRankString(String prefix, int... values) {
        StringBuilder sb = new StringBuilder();
        String[] years = {"24:", "23:", "22:", "21:"};
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) sb.append(prefix).append(years[i]).append(values[i]);
        }
        return sb.toString();
    }
}
