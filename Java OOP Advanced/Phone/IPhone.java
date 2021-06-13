public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String s = "Iphone " + getVersionnumber()+" says "+ getRingTone();
        return s;
    }
    @Override
    public String unlock() {
        String s ="unlocking via face recognition";
        return s;
    }
    @Override
    public void displayInfo() {
        System.out.println("Iphone "+ getVersionnumber() + " from " + getCarrier());
            
    }
}