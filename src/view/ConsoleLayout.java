package view;

public class ConsoleLayout {

    //상단
    public static void header() {
        System.out.println(
            "+============================================================+"
        );
        System.out.printf(
            "%-60s%n", "                FoodManager Console"
        );
        System.out.println(
            "+============================================================+"
        );
    }

    public static void line(String text) {
        System.out.printf("|%s|", text);
    }

    public static void blank() {
        System.out.printf("%-60s%n", "");
    }

    public static void footer() {
        System.out.println(
            "+============================================================+"
        );
    }

}
