
public class Main {
    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyTreeMap<>();
        map.add("5", 25);
        map.add("4", 16);
        map.add("6", 36);
        map.add("2", 4);
        map.add("3", 9);

        System.out.println(map.get("2"));
        System.out.println(map.get("3"));
        System.out.println(map.get("-1"));
        System.out.println("=========");

        System.out.println(map.get("6"));
        map.add("6", -6);
        System.out.println(map.get("6"));
    }
}

