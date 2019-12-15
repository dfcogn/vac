import java.util.Scanner;

public class SpeedDelec implements Bike {
    public static final String TYPE_NAME = "SPEEDELEC";
    private String brandName;
    private int maximumSpeed;
    private int weight;
    private boolean lights;
    private int batteryCapacity;
    private String color;
    private int price;



    public SpeedDelec(String brandName, int maximumSpeed, int weight, boolean lights, int batteryCapacity, String color, int price) {
        this.brandName = brandName;
        this.maximumSpeed = maximumSpeed;
        this.weight = weight;
        this.lights = lights;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
        this.price = price;
    }

    public SpeedDelec() {
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

    public static SpeedDelec addNewBikeFromLine(Scanner scanner) {
        System.out.println("Enter Brand name of " + SpeedDelec.TYPE_NAME + ":");
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
        return new SpeedDelec(brandName, maximumSpeed, weight, lights, batteryCapacity, color, price );
    }


    public static SpeedDelec createFromFileLine(String line){
        SpeedDelec speedDelec = new SpeedDelec();
        String[] properties = line.split(";");
        for (int i = 0; i< properties.length; i++){
            switch (i){
                case 0: speedDelec.setBrandName(properties[i].substring(speedDelec.TYPE_NAME.length() + 1));
                    break;
                case 1: speedDelec.setMaximumSpeed(Integer.valueOf(properties[i].trim()));
                    break;
                case 2: speedDelec.setWeight(Integer.valueOf(properties[i].trim()));
                    break;
                case 3: speedDelec.setLights(Boolean.valueOf(properties[i].trim()));
                    break;
                case 4: speedDelec.setBatteryCapacity(Integer.valueOf(properties[i].trim()));
                    break;
                case 5: speedDelec.setColor(properties[i].trim());
                    break;
                case 6: speedDelec.setPrice(Integer.valueOf(properties[i].trim()));
                    break;
            }
        }
        return speedDelec;
    }

    @Override
    public String toString() {
        return TYPE_NAME  + " " + brandName + " with " + batteryCapacity + " mAh battery " + "and" + (lights == true ? " " : " no ") + "head/tail light." + "\n" +
                "Price: " + price + " euros.";
    }


    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

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

