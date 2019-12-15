import java.util.Scanner;

public class FoldingBike implements Bike {
    public static final String TYPE_NAME = "FOLDING BIKE";
    private String brandName;
    private int sizeWheels;
    private int numberGears;
    private int weight;
    private boolean lights;
    private String color;
    private int price;

    public FoldingBike(String brandName, int sizeWheels, int numberGears, int weight, boolean lights, String color, int price) {
        this.brandName = brandName;
        this.sizeWheels = sizeWheels;
        this.numberGears = numberGears;
        this.weight = weight;
        this.lights = lights;
        this.color = color;
        this.price = price;
    }

    public FoldingBike() {
    }

    public static FoldingBike addNewBikeFromLine(Scanner scanner) {
        System.out.println("Enter Brand name of " + FoldingBike.TYPE_NAME + ":");
        String brandName = scanner.next();
        System.out.println("Enter size of wheels:");
        int sizeWheels = scanner.nextInt();
        System.out.println("Enter number of gears:");
        int numberGears = scanner.nextInt();
        System.out.println("Enter weight:");
        int weight = scanner.nextInt();
        System.out.println("Enter availability of lights at front and back (true or false):");
        boolean lights = scanner.nextBoolean();
        System.out.println("Enter color:");
        String color = scanner.next();
        System.out.println("Enter price:");
        int price = scanner.nextInt();
        return new FoldingBike(brandName, sizeWheels, numberGears, weight, lights, color, price );
    }

    public static FoldingBike createFromFileLine(String line){
        FoldingBike foldingBike = new FoldingBike();
        String[] properties = line.split(";");
        for (int i = 0; i< properties.length; i++){
            switch (i){
                case 0: foldingBike.setBrandName(properties[i].substring(foldingBike.TYPE_NAME.length() + 1));
                    break;
                case 1: foldingBike.setSizeWheels(Integer.valueOf(properties[i].trim()));
                    break;
                case 2: foldingBike.setNumberGears(Integer.valueOf(properties[i].trim()));
                    break;
                case 3: foldingBike.setWeight(Integer.valueOf(properties[i].trim()));
                    break;
                case 4: foldingBike.setLights(Boolean.valueOf(properties[i].trim()));
                    break;
                case 5: foldingBike.setColor(properties[i].trim());
                    break;
                case 6: foldingBike.setPrice(Integer.valueOf(properties[i].trim()));
                    break;
            }
        }
        return foldingBike;
    }

    @Override
    public String getStringPropertiesToFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TYPE_NAME);
        stringBuilder.append(" ");
        stringBuilder.append(brandName);
        stringBuilder.append("; ");
        stringBuilder.append(sizeWheels);
        stringBuilder.append("; ");
        stringBuilder.append(numberGears);
        stringBuilder.append("; ");
        stringBuilder.append(weight);
        stringBuilder.append("; ");
        stringBuilder.append(lights);
        stringBuilder.append("; ");
        stringBuilder.append(color);
        stringBuilder.append("; ");
        stringBuilder.append(price);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return TYPE_NAME  + " " + brandName + " with " + sizeWheels + " gear(s) " + "and" + (lights == true ? " " : " no ") + "head/tail light." + "\n" +
                "Price: " + price + " euros.";
    }

    @Override
    public String getTypeName() {
        return TYPE_NAME;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getSizeWheels() {
        return sizeWheels;
    }

    public void setSizeWheels(int sizeWheels) {
        this.sizeWheels = sizeWheels;
    }

    public int getNumberGears() {
        return numberGears;
    }

    public void setNumberGears(int numberGears) {
        this.numberGears = numberGears;
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
