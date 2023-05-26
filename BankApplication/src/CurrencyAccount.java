
public class CurrencyAccount extends Account {
    private String dovizCinsi;

    public CurrencyAccount(int accountId, double varliklar, String dovizCinsi) {
        super(accountId, varliklar);
        this.dovizCinsi = dovizCinsi;
    }

    public String getDovizCinsi() {
        return dovizCinsi;
    }
}