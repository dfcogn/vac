import java.util.Scanner;

public class EBike implements Bike {
    public static final String TYPE_NAME = "E-BIKE";
    private String brandName;
    private int maximumSpeed;
    private int weight;
    private boolean lights;
    private int batteryCapacity;
    private String color;
    private int price;

    public EBike(String brandName, int maximumSpeed, int weight, boolean lights, int batteryCapacity, String color, int price) {
        this.brandName = brandName;
        this.maximumSpeed = maximumSpeed;
        this.weight = weight;
        this.lights = lights;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
        this.price = price;
    }

    public EBike() {
    }

    public static EBike addNewBikeFromLine(Scanner scanner) {
        System.out.println("Enter Brand name of " + EBike.TYPE_NAME + ":");
        String brandName = scanner.next();
        System.out.println("Enter maximum speed:");
        int maximumSpeed = scanner.nextInt();
        System.out.println("Enter number of weight:");
        int weight = scanner.nextInt();
        System.out.println("Enter availability of lights at front and back (true or false):");
        boolean lights = scanner.nextBoolean();
        System.out.println("Enter battery capacity");
        int batteryCapacity = scanner.nextInt();
        System.out.println("Enter color:");
        String color = scanner.next();
        System.out.println("Enter price:");
        int price = scanner.nextInt();
        return new EBike(brandName, maximumSpeed, weight, lights, batteryCapacity, color, price );
    }

    public static EBike createFromFileLine(String line){
        EBike eBike = new EBike();
        String[] properties = line.split(";");
        for (int i = 0; i< properties.length; i++){
            switch (i){
                case 0: eBike.setBrandName(properties[i].substring(eBike.TYPE_NAME.length() + 1));
                    break;
                case 1: eBike.setMaximumSpeed(Integer.valueOf(properties[i].trim()));
                    break;
                case 2: eBike.setWeight(Integer.valueOf(properties[i].trim()));
                    break;
                case 3: eBike.setLights(Boolean.valueOf(properties[i].trim()));
                    break;
                case 4: eBike.setBatteryCapacity(Integer.valueOf(properties[i].trim()));
                    break;
                case 5: eBike.setColor(properties[i].trim());
                    break;
                case 6: eBike.setPrice(Integer.valueOf(properties[i].trim()));
                    break;
            }
        }
        return eBike;
    }

    @Override
    public String getStringPropertiesToFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TYPE_NAME);
        stringBuilder.append(" ");
        stringBuilder.append(brandName);
        stringBuilder.append("; ");
        stringBuilder.append(maximumSpeed);
        stringBuilder.append("; ");
        stringBuilder.append(weight);
        stringBuilder.append("; ");
        stringBuilder.append(lights);
        stringBuilder.append("; ");
        stringBuilder.append(batteryCapacity);
        stringBuilder.append("; ");
        stringBuilder.append(color);
        stringBuilder.append("; ");
        stringBuilder.append(price);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public String toString() {
        return TYPE_NAME  + " " + brandName + " with " + batteryCapacity + " mAh battery " + "and" + (lights == true ? " " : " no ") + "head/tail light." + "\n" +
                "Price: " + price + " euros.";
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isLights() {
        return lights;
    }

    public void setLights(boolean lights) {
        this.lights = lights;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
