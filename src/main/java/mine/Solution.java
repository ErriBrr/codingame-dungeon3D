package mine;

import java.util.*;
import java.io.*;
import java.math.*;

class Node{
    String name;
    HashSet<Node> next = new HashSet<>();
    Node prev = null;
    boolean isReachable = true;
    public Node(String name){
        this.name = name.replace("[^a-zA-Z]", "");
    }
}

class Router {
    String startPoint;
    String endPoint;
    public Router(String start, String end){
        this.startPoint = start.replace("[^a-zA-Z]", "");
        this.endPoint = end.replace("[^a-zA-Z]", "");
    }
    public void prepare(String station1, String station2, HashMap<String,Node> nodes){
        Node node1 = nodes.get(station1);
        Node node2 = nodes.get(station2);
        if (node1 == null){
            node1 = new Node(station1);
            nodes.put(node1.name, node1);
        }
        if (node2 == null){
            node2 = new Node(station2);
            nodes.put(node2.name, node2);
        }
        node1.next.add(node2);
        node2.next.add(node1);
        System.err.println(nodes.get(node1.name).name + " <-> " + nodes.get(node2.name).name);
    }
    public String result(Node destNode){
        ArrayList<Node> nodesPath = new ArrayList<>();
        nodesPath.add(destNode);
        Node prev = destNode.prev;
        while(prev != null){
            nodesPath.add(prev);
            prev = prev.prev;
        }
        String ret = "";
        for (int i = nodesPath.size() - 1; 0 <= i; i--){
            if (ret != ""){
                ret += " > ";
            }
            ret += nodesPath.get(i).name;
        }
        return ret;
    }
    public String proceed(HashMap<String,Node> nodes){
        Node startNode = nodes.get(this.startPoint);
        if (startNode == null){
            return "test1";
        } else {
            startNode.isReachable = false;
            ArrayList<Node> currentNodes = new ArrayList<>();
            for (Node n1:startNode.next){
                currentNodes.add(n1);
                n1.prev = startNode;
                n1.isReachable = false;
            }
            System.err.println("current" + currentNodes.size());
            while(!currentNodes.isEmpty()){
                ArrayList<Node> nextNodes = new ArrayList<>();
                for (Node n1:currentNodes){
                    if(n1.name.equals(this.endPoint)){
                        return this.result(n1);
                    } else {
                        for (Node n2: n1.next){
                            if(n2.isReachable){
                                n2.prev = n1;
                                nextNodes.add(n2);
                                n2.isReachable = false;
                            }
                        }
                    }
                }
                currentNodes = nextNodes;
            }
            return "test2";
        }
    }
}

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String start = in.nextLine();
        String end = in.nextLine();
        int n = in.nextInt();
        HashMap<String,Node> nodes = new HashMap<>();
        Router router = new Router(start, end);
        for (int i = 0; i < n; i++) {
            String station1 = in.next();
            String station2 = in.next();
            router.prepare(station1, station2, nodes);
        }

        System.out.println(router.proceed(nodes));
    }
}