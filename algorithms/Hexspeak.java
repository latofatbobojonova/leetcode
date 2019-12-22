public class Hexspeak {
    public String toHexspeak(String num) {
        String result = "";
        char hexLetter;
        long decNum = Long.parseLong(num);

        while ((hexLetter = getHexLetter(decNum)) != 'x' && decNum != 0) {
            result = hexLetter + result;
            decNum /= 16;
        }

        if (decNum == 0 && hexLetter != 'x') {
            return result;
        }

        return "ERROR";
    }

    public char getHexLetter(long decimalNum) {
        int reminder = (int) (decimalNum % 16);
        switch (reminder) {
            case 0:
                return 'O';
            case 1:
                return 'I';
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            default:
                return 'x';
        }
    }
}
