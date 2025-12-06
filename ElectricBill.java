public class ElectricBill extends Bill {
    private final double baseCharge;
    private final double costPerKiloHour; // cost per kilowatt-hour (kWh)
    private final double numKilo;         // number of kWh consumed
    public ElectricBill(String vendorName, double baseCharge, double costPerKiloHour, double numKilo) {
        super(vendorName);
        this.baseCharge = baseCharge;
        this.costPerKiloHour = costPerKiloHour;
        this.numKilo = numKilo;
    }
    public double getBaseCharge() {return baseCharge;}
    public double getCostPerKiloHour() {return costPerKiloHour;}
    public double getNumKilo() {return numKilo;}

    @Override
    public double payment() {
        return getBaseCharge() + getCostPerKiloHour() * getNumKilo();
    }

    @Override
    public String toString() {
        return String.format("%nVendor: %s%nFull Payable Amount: $%,.2f%nBase Charge: $%,.2f%nCost per Kilowatt-Hour: " +
                        "$%,.2f%nNumber of kWh consumed: %f", getVendorName(), getPaymentAmount(), getBaseCharge(),
                getCostPerKiloHour(), getNumKilo());
    }
}
