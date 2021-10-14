package by.com.vicitor.course.task.fifth.domain;

public class Save {

    private int volume;
    private int cost = 0;
    
    public Save(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Save volume can not be less than zero");
        }
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public int getCost() {
        return cost;
    }

    public boolean addProduct(Product product) {
        if(volume < product.getVolume()) {
            return false;
        }
        volume -= product.getVolume();
        cost += product.getCost();
        return true;
    }

    @Override
    public String toString() {
        return "Save\nRemaining volume: " + volume + "\nCost: " + cost + "\n";
    }
}
