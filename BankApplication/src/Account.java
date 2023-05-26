import java.util.ArrayList;

public class Account {
    protected String accountId;
    protected double balance;
    protected ArrayList<String> loglar;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.loglar = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getLoglar() {
        return loglar;
    }

//    public void superclassMetodu(double toplamVarlik, ArrayList<String> logListesi) {
//        System.out.println("Superclass Metodu Çağırıldı");
//        System.out.println("Toplam Varlık: " + toplamVarlik);
//        System.out.println("Loglar:");
//        for (String log : logListesi) {
//            System.out.println(log);
//        }
//    }
}
