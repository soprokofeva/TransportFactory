import transport.Transport;

import java.util.Comparator;


public class TransportUtils {

    public static final int COUNT_PARAMETERS = 4;

    /**
     * @param dataString is a string
     * @return true if dataString is a correct
     */
    public static boolean isValidString(String dataString) {
        String[] params = dataString.split(" +");
        int sizeParameters = params.length;
        return sizeParameters == COUNT_PARAMETERS && isCanBeParsed(params);
    }

    /**
     * @param params presents array of 4 values: int, String, double, double
     * @return true if all values are correct
     */
    public static boolean isCanBeParsed(String[] params) {
        try {
            int intValue = Integer.parseInt(params[0]);
            double doubleValue = Double.parseDouble(params[2]);
            doubleValue = Double.parseDouble(params[3]);
        } catch (NumberFormatException exc) {
            System.out.println("Ошибка формата значений! Требуется повторный ввод...");
            return false;
        }
        return true;
    }

    public static class TransportComparator implements Comparator<Transport> {

        @Override
        public int compare(Transport t1, Transport t2) {
            int result = 0;
            result = isZeroCompareAgain(result, Integer.compare(t2.getCountWheels(), t1.getCountWheels()));
            result = isZeroCompareAgain(result, Double.compare(t2.getPath(), t1.getPath()));
            result = isZeroCompareAgain(result, String.CASE_INSENSITIVE_ORDER.compare(t1.getName(), t2.getName()));
            return result;
        }

    }

    public static int isZeroCompareAgain(int old, int newValue) {
        return old == 0 ? newValue : old;
    }

}
