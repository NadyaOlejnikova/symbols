import java.util.*;

public class Main {
    static String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
            "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
            "mollit anim id est laborum.";


    public static void main(String[] args) {
        Map<Character, Integer> symbols = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.toLowerCase(Locale.ROOT).charAt(i);
            if (c != ' ' && c != ',' && c != '.') {
                if (symbols.containsKey(c)) {
                    symbols.put(c, symbols.get(c) + 1);
                } else {
                    symbols.put(c, 1);
                }
            }
        }
        Map.Entry<Character, Integer> maxSymbol = max(symbols);
        Map.Entry<Character, Integer> minSymbol = min(symbols);
        System.out.println(symbols);
        System.out.println("Наиболее повторяемый символ    " + maxSymbol);
        System.out.println("Наименее повторяемый символ    " + minSymbol);
    }

    public static Map.Entry<Character, Integer> max(Map<Character, Integer> symbols) {
        int max = -1;
        Map.Entry<Character, Integer> resultMax = null;
        for (Map.Entry<Character, Integer> maximum : symbols.entrySet()) {
            if (maximum.getValue() > max) {
                resultMax = maximum;
                max = maximum.getValue();
            }
        }

        return resultMax;
    }

    public static Map.Entry<Character, Integer> min(Map<Character, Integer> symbols) {
        int min = Integer.MAX_VALUE;
        Map.Entry<Character, Integer> resultMin = null;
        for (Map.Entry<Character, Integer> minimum : symbols.entrySet()) {
            if (minimum.getValue() < min) {
                resultMin = minimum;
                min = minimum.getValue();
            }
        }

        return resultMin;
    }
}

