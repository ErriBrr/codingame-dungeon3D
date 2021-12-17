package java_coffe_cup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String start = in.nextLine();
        String end = in.nextLine();
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String n1 = in.next();
            String n2 = in.next();

            Node nod1 = Graph.map.get(n1);
            Node nod2 = Graph.map.get(n2);

            if (nod1 == null) {
                nod1 = new Node(n1);
            }
            if (nod2 == null) {
                nod2 = new Node(n2);
            }
            nod1.adj.add(nod2);
            nod2.adj.add(nod1);
            Graph.map.put(n1, nod1);
            Graph.map.put(n2, nod2);

        } // for

        Graph.getShortestPath(start, end);
    }
}

class Graph {
    static Map<String, Node> map = new HashMap<>();
    static int w = 1; // weight

    public static void getShortestPath(String start, String end) {
        Node startNode = map.get(start);

        calculateShortestPathFromSource(startNode);
        Stack<String> stack = backTrack(start, end);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" > ");
            }
        }
        System.out.println(sb.toString());
    }

    private static Stack<String> backTrack(String start, String end) {
        Node endNode = map.get(end);

        int min = Integer.MAX_VALUE;
        Node minNode = endNode;
        Set<Node> visited = new HashSet<>();

        Stack<String> stack = new Stack<>();
        stack.push(end);

        Node curNode = endNode;
        while (!curNode.name.equals(start)) {
            for (Map.Entry<String, Node> entry : map.entrySet()) {
                Node nod = entry.getValue();
                if (!visited.contains(nod) && nod.adjContainsName(curNode.name) && nod.getDistance() < min) {
                    min = nod.getDistance();
                    minNode = nod;
                    visited.add(minNode);
                }
            }
            stack.push(minNode.name);
            curNode = minNode;
        } // while
        return stack;
    }

    public static void calculateShortestPathFromSource(Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Node adjNode : currentNode.adj) {
                if (!settledNodes.contains(adjNode)) {
                    CalculateMinimumDistance(adjNode, w, currentNode);
                    unsettledNodes.add(adjNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

    private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}

class Node {
    String name;
    List<Node> adj = new ArrayList<>();
    private Integer distance = Integer.MAX_VALUE;
    private LinkedList<Node> shortestPath = new LinkedList<>();

    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }

    public boolean adjContainsName(String str) {
        for (Node nod : adj) {
            if (nod.name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Node(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}

