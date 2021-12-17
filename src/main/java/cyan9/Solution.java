package cyan9;

import java.util.*;
import java.io.*;
import java.math.*;

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

        ArrayList<ArrayList<String>> adjList = new ArrayList<>();
        HashMap<String, Integer> numCode = new HashMap<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            String station1 = in.next();
            String station2 = in.next();

            if (!numCode.containsKey(station1)) {
                adjList.add(new ArrayList<>());
                numCode.put(station1, num);
                num++;
            }
            adjList.get(numCode.get(station1)).add(station2);

            if (!numCode.containsKey(station2)) {
                adjList.add(new ArrayList<>());
                numCode.put(station2, num);
                num++;
            }
            adjList.get(numCode.get(station2)).add(station1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[num];
        String[] prev = new String[num];

        pq.offer(start);
        while (!pq.isEmpty()) {
            String cur = pq.poll();
            visited[numCode.get(cur)] = true;
            for (String next : adjList.get(numCode.get(cur))) {
                if (!visited[numCode.get(next)]) {
                    visited[numCode.get(next)] = true;
                    prev[numCode.get(next)] = cur;
                    pq.offer(next);
                }
            }
        }

        Stack<String> reversePath = new Stack<>();
        while (end != null) {
            reversePath.push(end);
            end = prev[numCode.get(end)];
        }

        ArrayList<String> path = new ArrayList<>();
        while (!reversePath.isEmpty()) {
            path.add(reversePath.pop());
        }

        String res = String.join(" > ", path);
        System.out.println(res);
    }
}