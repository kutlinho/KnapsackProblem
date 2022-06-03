import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Operations op = new Operations();
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Item> sel = new ArrayList<Item>();
        Scanner s = new Scanner(System.in);
        System.out.println("Eşya sayısını giriniz: ");
        int itemNo = s.nextInt();
        System.out.println("Kapasiteyi giriniz: ");
        int capacity = s.nextInt();
        for (int i = 0; i < itemNo; i++) {
            System.out.println((i+1) +". eşyanın adı: ");
            String name = s.next();
            System.out.println((i+1) +". eşyanın karı: ");
            int profit = s.nextInt();
            System.out.println((i+1) +". eşyanın ağırlığı: ");
            int weight = s.nextInt();
            Item item = new Item(name, profit, weight);
            items.add(item);
        }
        Item item1 = new Item("A", 1, 1);
        items.add(item1);
        Item item2 = new Item("B", 6, 2);
        items.add(item2);
        Item item3 = new Item("C", 10, 3);
        items.add(item3);
        Item item4 = new Item("D", 16, 5);
        items.add(item4);
        Node node = new Node(null, null, sel, items);
        op.fillTree(node);
        op.printSolutions();
        op.findBestSolution(capacity);

    }
}
