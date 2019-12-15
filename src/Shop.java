import java.io.*;
import java.util.*;

public class Shop {
    public static List<Bike> bikesList = new ArrayList<>();
    public static String fileListBike = "src/ecobike.txt";

    public static void start(){
        File file = new File(fileListBike);

        if(!file.exists() || file.isDirectory()){
            System.out.println("Fail shop start. Bike file is not found");
            return;
        }

        scanBikesFromFile();
        showChoices();

        int readNumber = 0;
        circle:
        while (true){
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");

            try {
                readNumber = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Error! Please enter only number");
                continue;
            }

            switch (readNumber){
                case (1):
                    showAllBikes();
                    break;
                case (2):
                    try{
                        bikesList.add(FoldingBike.addNewBikeFromLine(scanner));
                        System.out.println("New bike added");
                        break;
                    }catch (InputMismatchException ex){
                        System.out.println("Not correct entry properties. Bike not added\nPress 2 if you want add bike again\n");
                        showChoices();
                        break;
                    }
                case (3):
                    try{
                        bikesList.add(SpeedDelec.addNewBikeFromLine(scanner));
                        System.out.println("New bike added");
                        break;
                    }catch (InputMismatchException ex){
                        System.out.println("Not correct entry properties. Bike not added\nPress 3 if you want add bike again\n");
                        showChoices();
                        break;
                    }
                case (4):
                    try{
                        bikesList.add(EBike.addNewBikeFromLine(scanner));
                        System.out.println("New bike added");
                        break;
                    }catch (InputMismatchException ex){
                        System.out.println("Not correct entry properties. Bike not added\nPress 3 if you want add bike again\n");
                        showChoices();
                        break;
                    }
                case (5):
                    findFirstParticularBrand();
                    break;
                case (6):
                    writeBikesToFile();
                    System.out.println("Bike file updated");
                    break;
                case (7):
                    System.out.println("exit " + readNumber);
                    scanner.close();
                    break circle;
                default:
                    System.out.println("empty or not correct number " + readNumber);
                    break;
            }
        }
        System.out.println("End");
    }

    public static void scanBikesFromFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileListBike)));
            String line;

            while((line = br.readLine()) != null){
                if(line.contains(FoldingBike.TYPE_NAME)){
                    bikesList.add(FoldingBike.createFromFileLine(line));
                    continue;
                }

                if(line.contains(SpeedDelec.TYPE_NAME)){
                    bikesList.add(SpeedDelec.createFromFileLine(line));
                    continue;
                }

                if(line.contains(EBike.TYPE_NAME)){
                    bikesList.add(EBike.createFromFileLine(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Path properties in file is not correct");
        }
    }

    public static void findFirstParticularBrand(){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter brand for find first bike");
        String brandName = scanner.nextLine();

        synchronized(bikesList){

        }


        for (Bike bike: bikesList) {

        };
    }

    public static void writeBikesToFile(){
        try(FileWriter writer = new FileWriter(fileListBike, false)){
            for(Bike bike : bikesList){
                if(bike.getTypeName().equals(FoldingBike.TYPE_NAME)){
                    writer.write(bike.getStringPropertiesToFile());
                }

                if(bike.getTypeName().equals(SpeedDelec.TYPE_NAME)){
                    writer.write(bike.getStringPropertiesToFile());
                }

                if(bike.getTypeName().equals(EBike.TYPE_NAME)){
                    writer.write(bike.getStringPropertiesToFile());
                }
            }

            writer.flush();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void showAllBikes(){
        for (Bike bike : bikesList){
            System.out.println(bike);
        }
    }

    public static void showChoices(){
        System.out.println("Please make your choice:");
        System.out.println("1 - Show the entire EcoBike catalog");
        System.out.println("2 – Add a new folding bike");
        System.out.println("3 – Add a new speedelec");
        System.out.println("4 – Add a new e-bike");
        System.out.println("5 – Find the first item of a particular brand");
        System.out.println("6 – Write to file");
        System.out.println("7 – Stop the program");
    }
}
