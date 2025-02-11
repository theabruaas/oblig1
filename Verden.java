public class Verden{
    Rutenett rutenett;
    int genNr = 0;
    int rad;
    int kolonne;
    public Verden(int rader, int kolonner){
        rutenett = new Rutenett(rader, kolonner);
        rad = rader;
        kolonne = kolonner;
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }
    
    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println(genNr);
        System.out.println(rutenett.antallLevende());
    }

    public void oppdatering(){
        for (int i = 0; i < rad; i++){
            for (int j = 0; j < kolonne; j++){
                rutenett.settNaboer(i, j);
                rutenett.antallLevende();
            }
        }
        for (int k = 0; k < rad; k++){
            for (int l = 0; l < kolonne; l++){
                rutenett.hentCelle(k, l).oppdaterStatus();
            }
        }
    genNr++;  
    }
}