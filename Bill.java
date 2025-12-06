/*
    Create an abstract class implementing interface Payable. Bill has one attribute:
    the name of the vendor to be paid.

    Create the following types of concrete Bill implementations. All types should be
    initialized via their constructors so that method getPayment() of Payable interface
    can be called right after an instance is initialized. Payment amounts should be
    computed as described. Each bill type should implement toString() method listing
    the name of the vendor and the full payable amount of the bill.
 */
public abstract class Bill implements Payable{
    private final String vendorName;

    public Bill(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    // return String rep of Bill object
    @Override
    public String toString() {
        return String.format("Vendor: %s%nFull Payable Amount: $%,.2f%n", getVendorName(),
                getPaymentAmount());
    }

    // abstract method must be overridden by concrete subclasses
    public abstract double payment(); // no implementation here

    @Override
    public double getPaymentAmount() {
        return payment();
    }
}
