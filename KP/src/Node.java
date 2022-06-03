import java.util.ArrayList;

public class Node {
    public Node left;
    public Node right;

    public ArrayList<Item> selected;
    public ArrayList<Item> values;

    public Node() {
    }

    public Node(Node left, Node right, ArrayList<Item> selected, ArrayList<Item> values) {
        this.left = left;
        this.right = right;
        this.selected = selected;
        this.values = values;
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (Item i : this.selected) {
            totalWeight += i.weight;
        }
        return totalWeight;
    }
    public int getTotalProfit() {
        int totalProfit = 0;
        for (Item i : this.selected) {
            totalProfit += i.profit;
        }
        return totalProfit;
    }
    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }


}
