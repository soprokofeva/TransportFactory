import transport.*;

public class TransportFactory {

    public Transport getTransportInstance(int countWheels, String name, double capacity, double consumption100Km) {
        switch (countWheels) {
            case 1:
                return new Monocycle(name, capacity, consumption100Km);
            case 2:
                return new Motorcycle(name, capacity, consumption100Km);
            case 3:
                return new Tricycle(name, capacity, consumption100Km);
            case 4:
                return new Quadricycle(name, capacity, consumption100Km);
            default:
                return new TransportDefault(countWheels, name, capacity, consumption100Km);
        }
    }
}
