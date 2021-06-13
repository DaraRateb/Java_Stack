public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String s = "Galaxy " + getVersionnumber()+" says "+ getRingTone();
        return s;
    }
    @Override
    public String unlock() {
        String s ="unlocking via finger print";
        return s;
    }
    @Override
    public void displayInfo() {
        System.out.println("Galaxy "+ getVersionnumber() + " from " + getCarrier());        
    }
}