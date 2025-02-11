import java.util.Random;

public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;
 
     public Rutenett(int rad, int kolonne){
         antRader = rad;
         antKolonner = kolonne;
         rutene = new Celle[rad][kolonne];
     }

     public Celle lagCelle(){
        Celle celle = new Celle();
        if (Math.random() <= 0.3333){
            celle.settLevende();
        }
        else{
            celle.settDød();
        }
        return celle;
     }

     public void fyllMedTilfeldigeCeller(){
        for (int i = 0; i < antRader; i++){
            for (int j = 0; j < antKolonner; j++){
                rutene[i][j] = lagCelle();
            }
        }
     }

     public Celle hentCelle(int rad, int kolonne){
        System.out.println(rad);
        System.out.println(kolonne);
        return rutene[rad][kolonne];
     }

     public void tegnRutenett(){
        for (int i = 0; i < antRader; i++){
            System.out.println();
            for (int j = 0; j < antKolonner; j++){
                System.out.print(rutene[i][j].hentStatusTegn() + " ");
            }
        }
     }

     public void settNaboer(int rad, int kolonne){
        Celle nabo = new Celle();
        Celle hoved = new Celle();
        hoved = rutene[rad][kolonne];
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                nabo = rutene[rad+i][kolonne+j];
                if (nabo != null || nabo != hoved){
                    hoved.leggTilNabo(nabo);
                }
            }
        }
     }

     public void kobleAlleCeller(){
        for(int i = 0; i < antRader; i++){
            for (int j = 0; j < antKolonner; j++){
                settNaboer(i,j);
                //rutenett(i, j);
            }
        }
     }

     public int antallLevende(){
        int teller = 0;
        for(int i = 0; i < antRader; i++){
            for (int j = 0; j < antKolonner; j++){
                if (rutene[i][j].erLevende()){
                    teller++;
                }
            }
        }
        return teller;
     }
 }



