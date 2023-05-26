
public class DepositAccount extends Account {
    private double faizOrani;

    public DepositAccount(int accountId, double varliklar, double faizOrani) {
        super(accountId, varliklar);
        this.faizOrani = faizOrani;
    }

    public double getFaizOrani() {
        return faizOrani;
    }
}