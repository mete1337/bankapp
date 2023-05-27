
public class SavingAccount extends Account {
    private double faizOrani = 0.1;

    public SavingAccount(String accountId, double varliklar) {
        super(accountId, varliklar);
        this.faizOrani = 0.1;
    }

    public double getFaizOrani() {
        return faizOrani;
    }
}