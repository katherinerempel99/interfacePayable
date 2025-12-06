public class Mortgage extends Bill {
    private final double principal;
    private final double interest;
    private final double taxes;
    private final double insurance;

    // constructor
    public Mortgage(String vendorName ,double principal, double interest, double taxes, double insurance) {
        super(vendorName);
        this.principal = principal;
        this.interest = interest;
        this.taxes = taxes;
        this.insurance = insurance;
    }

    public double getPrincipal() {return principal;}
    public double getInterest() {return interest;}
    public double getTaxes() {return taxes;}
    public double getInsurance() {return insurance;}

    // calculate payment
    @Override
    public double payment() {
        return getPrincipal() * getInterest() * getInsurance() * getTaxes();
    }
    // return String rep of Mortgage object
    @Override
    public String toString() {
        return String.format("%nVendor: %s%nFull Payable Amount: $%,.2f%nPrincipal: $%,.2f%nInterest: $%,.2f%n" +
                        "Insurance: $%,.2f%nTaxes: $%,.2f", getVendorName(),
                getPaymentAmount(), getPrincipal(), getInterest(), getInsurance(), getTaxes());
    }
}
