import java.util.Scanner;

public class Kamatos {

    public Kamatos() {
       
    }
    public void startKamatos(){
        double tenyleges = this.bekerDatas();
        nyomtat(tenyleges);
    }
    private void nyomtat( double tenyleges){
        System.out.println(tenyleges);

    }
    private double bekerDatas() {
        String betetStr = beker("Betét:");
      
        if(!this.checkInput(betetStr)){
            System.err.println("Hiba! Csak számot lehet beírni.");
            throw new NumberFormatException("Csak szám");
        }
        String nevlegesStr = beker("Névleges kamat (%):");
        if(!this.checkInput(nevlegesStr)){
            System.err.println("Hiba! Csak számot lehet beírni.");
            throw new NumberFormatException("Csak szám");
        }
        String tokesites_szamStr = beker("Évenkénti tőkésítések száma:");
        if(!this.checkInput(tokesites_szamStr)){
            System.err.println("Hiba! Csak számot lehet beírni.");
            throw new NumberFormatException("Csak szám");
        }

        double betet = Double.parseDouble(betetStr);
        double nevleges = Double.parseDouble(nevlegesStr);
        double tokesites_szam = Double.parseDouble(tokesites_szamStr);
       double tenyleges = this.szamitTenylegesKamat(betet, nevleges, tokesites_szam);
       return tenyleges;
    }

    private String beker(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }
    public double szamitTenylegesKamat(double betet, double nevleges,double tokesites_szam){
        double tenyleges = (Math.pow((
            1 + (nevleges/(100.*tokesites_szam))
        ),tokesites_szam)-1)*betet;
        return tenyleges;
    }
    public boolean checkInput(String input){
       if( input.matches("[0-9.,]+")) {
        return true;
       }else{
        return false;
       }
    }
}
