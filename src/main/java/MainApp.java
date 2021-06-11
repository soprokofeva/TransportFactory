import transport.Transport;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        List<String> inputTransport = input();
        List<Transport> transports = filling(inputTransport);
        System.out.println("Sorting...");
        transports.sort(new TransportUtils.TransportComparator());
        output(transports);
    }

    public static List<String> input() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        List<String> resultList = new ArrayList<String>();

        do {
            System.out.print("Введите кол-во транспортных средств: ");
            try {
                count = scanner.nextInt();
            } catch (InputMismatchException exception) {
                count = -1;
                scanner.nextLine();
            }
        } while (count <= 0);

        scanner.nextLine();
        System.out.println("Введите атрибуты транспортного средства в формате: \n"
                + "число колёс   имя   ёмкость   расход на 100 км");
        String data;

        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 +".");
            do {
                data = scanner.nextLine();
            } while (!TransportUtils.isValidString(data));
            resultList.add(data);
        }

        System.out.println(resultList.toString());
        return resultList;
    }

    public static List<Transport> filling(List<String> inputTransports) {
        List<Transport> transportlist = new ArrayList<Transport>();
        TransportFactory factory = new TransportFactory();

        for (String inputTransport : inputTransports) {
            String[] params = inputTransport.split(" +");
            int countWheels = Integer.parseInt(params[0]);
            String name = params[1];
            double capasity = Double.parseDouble(params[2]);
            double consumption100Km = Double.parseDouble(params[3]);

            Transport transport = factory.getTransportInstance(countWheels, name, capasity, consumption100Km);
            transportlist.add(transport);

        }

        return transportlist;
    }

    public static void output(List<Transport> transports) {
        for (Transport transport : transports) {
            System.out.println(transport);
        }
    }

}
