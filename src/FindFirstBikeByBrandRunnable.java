import java.util.List;

public class FindFirstBikeByBrandRunnable implements Runnable {
    private String brandName;
    private List<Bike> bikesList;


    public FindFirstBikeByBrandRunnable(List<Bike> bikesList, String brandName) {
        this.bikesList = bikesList;
        this.brandName = brandName;
    }

    @Override
    public void run() {
        synchronized (bikesList){
            for (Bike bike: bikesList) {
                try {
                    Thread.sleep(10);
                    if(bike.getBrandName().equalsIgnoreCase(brandName)){
                        System.out.println("First particular bike:");
                        System.out.println(bike.toString());
                        return;
                    }
                } catch (InterruptedException e) {
                    System.out.println("Error in searching thread");
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Not found bike " + brandName);
    }
}
