package Domain;

public class Price {

    private final String amount;
    private final String currency;

    public Price(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}