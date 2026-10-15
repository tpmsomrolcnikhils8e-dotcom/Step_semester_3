abstract class Transport {
    protected double distance;
    public Transport(double distance) {
        this.distance = distance;
    }
    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) { super(distance); }
    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);[cite: 1]
        return Math.min(fare, 10.0); // Max fare $10[cite: 1]
    }
}

class Train extends Transport {
    public Train(double distance) { super(distance); }
    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);[cite: 1]
    }
}

class Metro extends Transport {
    private double peakHourFactor;
    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;[cite: 1]
    }
}