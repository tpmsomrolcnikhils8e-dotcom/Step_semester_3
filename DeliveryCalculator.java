abstract class Delivery {
    protected double weight;
    protected double distance;
    
    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }
    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }
    @Override
    public double calculateFee() {
        return 15.0 + (1.0 * weight) + (0.20 * distance);[cite: 1]
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    @Override
    public double calculateFee() {
        return 25.0 + (2.0 * weight) + (0.50 * distance) + customsFee;[cite: 1]
    }
}
