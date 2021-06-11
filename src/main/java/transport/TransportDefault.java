package transport;

public class TransportDefault implements Transport {
    private String name;
    private int countWheels;
    private double capacity;
    private double consumption100Km;

    public TransportDefault(int countWheels, String name, double capacity, double consumption100Km) {
        this.countWheels = countWheels;
        this.setParameters(name, capacity, consumption100Km);
    }

    public void setParameters(String name, double capacity, double consumption100Km) {
        this.name = name;
        this.capacity = capacity;
        this.consumption100Km = consumption100Km;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountWheels() {
        return countWheels;
    }

    public void setCountWheels(int countWheels) {
        this.countWheels = countWheels;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getConsumption100Km() {
        return consumption100Km;
    }

    public void setConsumption100Km(double consumption100Km) {
        this.consumption100Km = consumption100Km;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "countWheels=" + countWheels +
                ", name='" + name + '\'' +
                ", max path=" + this.getPath() +
                ", capacity=" + capacity +
                ", consumption100Km=" + consumption100Km +
                '}';
    }

    @Override
    public double getPath() {
        return this.getConsumption100Km() != 0 ? this.getCapacity() / this.getConsumption100Km() * 100 : 0;
    }
}
