public class Celle{
    int antNaboer = 0;
    int antLevendeNaboer = 0;
    Boolean levende;
    Celle[] naboer = new Celle[8];
    
    public Celle(){
            levende = false;
        }
        

    public void settDød(){
        levende = false;
    }

    public void settLevende(){
        levende = true;
    }

    public boolean erLevende(){
        if (levende == true){
            return true;
        }
        else{
            return false;
        }
    }

    public char hentStatusTegn(){
        if (levende == true){
            return 'O';
        }
        else{
            return '.';
        }
    }

    public void leggTilNabo(Celle nabo){
        for(int i = 0; i < naboer.length; i++){
            if (naboer[i] == null){
                naboer[i] = nabo;
                antNaboer ++;
                return ;
                }
            }
        }
    
        public void tellLevendeNaboer(){
            antLevendeNaboer = 0;
            for (int j = 0; j < naboer.length; j++){
                if (naboer[j] != null && naboer[j].erLevende()){
                    antLevendeNaboer++;
                }
            }
        }

        public void oppdaterStatus(){
            if(levende == true && antLevendeNaboer < 2){
                levende = false;
            }
            else if(levende == true && antLevendeNaboer > 3){
                levende = false;
            }
            else if(levende == false && antLevendeNaboer == 3){
                levende = true;
            }
        }
    }
