package module07.exercise02;


public class Main {


    public static String extractDigits(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9')
                sb.append(c);
        }
        return sb.toString();
    }

    public static NumberType detectType(String digits) {
        return switch (digits.length()) {
            case 8 -> NumberType.LANDLINE_NO_DDD;
            case 9 -> NumberType.MOBILE_NO_DDD;
            case 10 -> NumberType.LANDLINE_WITH_DDD;
            case 11 -> NumberType.MOBILE_WITH_DDD;
            case 12 -> digits.startsWith("55") ? NumberType.LANDLINE_WITH_DDD_INTL : null;
            case 13 -> digits.startsWith("55") ? NumberType.MOBILE_WITH_DDD_INTL: null;
            default -> null;
        };
    }

    public static String format(String digits, NumberType type) {
        return switch (type) {
            case LANDLINE_NO_DDD -> digits.substring(0,4) + "-" + digits.substring(4,8);
            case MOBILE_NO_DDD -> digits.substring(0,5) + "-" + digits.substring(5,9);
            case LANDLINE_WITH_DDD -> "(" + digits.substring(0,2) + ")" + digits.substring(2,6) + "-" + digits.substring(6,10);
            case LANDLINE_WITH_DDD_INTL -> "+" + digits.substring(0,2) + " (" + digits.substring(2,4) + ")" + digits.substring(4,8) + "-" + digits.substring(8,12);
            case MOBILE_WITH_DDD -> "(" + digits.substring(0,2) + ")" + digits.substring(2,7) + "-" + digits.substring(7,11);
            case MOBILE_WITH_DDD_INTL -> "+" + digits.substring(0,2) + " (" + digits.substring(2,4) + ")" + digits.substring(4,9) + "-" + digits.substring(9,13);
        };
    }

    public static String process(String input) {
        var digits = extractDigits(input);

        var hasPlus = input.trim().startsWith("+");
        if ((digits.length() == 12 || digits.length() == 13) && !hasPlus) {
            return "Invalid - International numbers must start with '+'";
        }

        var type = detectType(digits);
        if (type == null) {
            return "Invalid | Type was not detected";
        }

        var formatted = format(digits, type);
        if (input.equals(formatted)){
            return input + " | " + type.getLabel();
        } else {
            return formatted + " | " + type.getLabel();
        }
    }

    public static void main(String[] args){
        System.out.println(process("(75)99279-0034"));
        System.out.println(process("+557599279-0034"));
        System.out.println(process("557554728-2409"));
        System.out.println(process("45763549023"));
        System.out.println(process("987654321"));
        System.out.println(process("12345678"));
        System.out.println(process("abc123"));
    }

}
