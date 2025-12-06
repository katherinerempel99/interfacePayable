public class CreditCard extends Bill {
    private final double charges;
    private final double credit;

    // constructor
    public CreditCard(String vendorName, double charges, double credit) {
        super(vendorName);
        if (charges < 0.0) {
            throw new IllegalArgumentException("Charges must be >= 0.0");
        }
        this.charges = charges;
        this.credit = credit;
    }

    public double getCharges() {return charges;}
    public double getCredit() {return credit;}

    // calculate payment

    @Override
    public double payment() {
        return getCharges() - getCredit();
    }
    @Override
    public String toString() {
        return String.format("%nVendor: %s%nFull Payable Amount: $%,.2f%nCharges: $%,.2f%n" +
                        "Credit: $%,.2f", getVendorName(),
                getPaymentAmount(), getCharges(), getCredit());
    }
}
