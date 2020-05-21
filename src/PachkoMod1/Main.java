package PachkoMod1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    class Node implements Comparable<Node>{

        final int sum;
        String code;

        void buildCode(String code) {
            this.code = code;
        }

        public Node(int sum){
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node {//внутренний узел
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode (Node left, Node right) {
            super(left.sum+ right.sum);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {//лист
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        private LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("1.txt"));
        String s = input.next();
        Map<Character, Integer> count = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)){
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(); //добавили в приоритетную очередь каждый листовой узел
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode node = (new LeafNode(entry.getKey(), entry.getValue()));
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }

        int sum = 0;
        while(priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        System.out.println(count.size() + "  " + sum);
        Node root = priorityQueue.poll();
        root.buildCode("");
        String result = "";
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            result += charNodes.get(c).code;
        }
        System.out.println(result);
    }



    public static void main(String[] args) throws FileNotFoundException {
        long startTIME = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTIME + "ms");
    }
}
