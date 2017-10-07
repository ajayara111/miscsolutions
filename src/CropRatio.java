
import java.util.HashMap;

public class CropRatio {
    private double cropWeight;
    private HashMap<String, Double> crops = new HashMap<String, Double>();

    public void add(String name, double cropWeight) {
        Double currentCropWeight = crops.get(name);

        if (currentCropWeight == null) {
            crops.put(name, cropWeight);
        }

        this.cropWeight = this.cropWeight + cropWeight;
       
    }

    public double proportion(String name) {
        return (double) ((crops.get(name) )/(cropWeight));
    }

    public static void main(String[] args) {
        CropRatio cropRatio = new CropRatio();

        cropRatio.add("Wheat", 4);
        cropRatio.add("Wheat", 5);
        cropRatio.add("Rice", 1);

        System.out.println("Fraction of wheat: " + cropRatio.proportion("Wheat"));
    }
}
