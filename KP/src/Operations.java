import java.util.ArrayList;

public class Operations {
    private ArrayList<Node> solutions = new ArrayList<Node>();

    public void fillTree(Node node) {
        if (node.values.size() == 0 ) {
            solutions.add(node);
            return;
        }
        node.left = new Node(null, null, new ArrayList<Item>(), new ArrayList<Item>());
        node.right = new Node(null, null, new ArrayList<Item>(), new ArrayList<Item>());
        // Filling arrays of left node
        for (int i = 1; i < node.values.size(); i++) {// Copying rest of first element
            node.left.values.add(node.values.get(i));
        }
        for(Item i : node.selected){
            node.left.selected.add(i);
        }
        node.left.selected.add(node.values.get(0));

        //Filling arrays of right node
        for (int i = 0; i < node.selected.size(); i++) {
            node.right.selected.add(node.selected.get(i));
        }
        for (int i = 1; i < node.values.size(); i++) {// Copying rest of first element
            node.right.values.add(node.values.get(i));
        }
        fillTree(node.left);
        fillTree(node.right);
    }

    public ArrayList<Node> getSolutions() {
        return solutions;
    }

    public void setSolutions(ArrayList<Node> solutions) {
        this.solutions = solutions;
    }

    public void printSolutions() {
        for (Node s : solutions) {
            System.out.println();
            System.out.print("Selected: ");
            for (Item i : s.selected) {
                System.out.print(" " + i.name);
            }
            System.out.println("\nprofit: " + s.getTotalProfit());
            System.out.println("weight: " + s.getTotalWeight());
            System.out.println("----------------------");
        }
    }
    public void findBestSolution(int capacity){
        int max=0;
        Node bestNode=new Node();
        for(Node s: solutions){
            if(s.getTotalProfit()>=max && s.getTotalWeight()<=capacity){
                bestNode=s;
                max=s.getTotalProfit();
            }
        }
        System.out.println("Best solution: ");
        System.out.print("Selected: ");
        for (Item i : bestNode.selected) {
            System.out.print(" " + i.name);
        }
        System.out.println("\nprofit: " + bestNode.getTotalProfit());
        System.out.println("weight: " + bestNode.getTotalWeight());
        System.out.println("----------------------");
    }
}
