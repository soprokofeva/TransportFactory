import transport.Transport;

import java.io.*;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> inputTransport = null;

        int action = -1;
        do {
            System.out.println("Выберите действие:" + "\n"
                    + "0 - выход" + "\n"
                    + "1 - ввести с клавиатуры" + "\n"
                    + "2 - считать из файла" + "\n");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    inputTransport = input(scanner);
                    break;
                case 2:
                    inputTransport = inputFromFile();
                    break;
                case 0:
                    System.exit(-1);
            }
        } while (action < 0);

        if (inputTransport == null) {
            System.exit(-1);
        }
        List<Transport> transports = filling(inputTransport);
        output(transports);
        System.out.println("Sorting...");
        transports.sort(new TransportUtils.TransportComparator());
        output(transports);
    }

    private static List<String> inputFromFile() {
        List<String> resultList = new ArrayList<String>();

        String filePath = "C:\\Users\\svetlana.snezhkova\\IdeaProjects\\transportFactory\\src\\main\\resources\\transports.txt";

        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;

            do {
                line = reader.readLine();
                if (line != null && TransportUtils.isValidString(line)) {
                    resultList.add(line);
                }
            } while (line != null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public static List<String> input(Scanner scanner) {
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
