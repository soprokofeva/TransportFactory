package transport;

public interface Transport {

    int getCountWheels();
    String getName();
    double getCapacity();
    double getConsumption100Km();
    double getPath();
    String toStringWithoutFieldName();
}
