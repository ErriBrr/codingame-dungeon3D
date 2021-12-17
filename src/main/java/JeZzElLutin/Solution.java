package JeZzElLutin;

import java.util.*;

class Solution {

    class Info {
        int dist = Integer.MAX_VALUE;
        String before = null;

        Info() { }

        Info(int dist) { this.dist = dist; }
    }

    void solve() {
        try (Scanner in = new Scanner(System.in)) {

            String start = in.nextLine();
            String end = in.nextLine();

            Map<String, List<String>> links = new HashMap<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                String station1 = in.next();
                String station2 = in.next();
                if (!links.containsKey(station1)) {
                    links.put(station1, new ArrayList<>());
                }
                if (!links.containsKey(station2)) {
                    links.put(station2, new ArrayList<>());
                }
                links.get(station1).add(station2);
                links.get(station2).add(station1);
            }

            Map<String, Info> infos = new HashMap<>();
            infos.put(start, new Info(0));

            Queue<String> q = new LinkedList<>();
            q.add(start);

            while (q.size() > 0) {
                String station = q.poll();
                if (station.equals(end)) {
                    break;
                }
                Info stationInfo = infos.get(station);
                List<String> sLinks = links.get(station);
                if (sLinks != null) {
                    for (String dest : sLinks) {
                        Info destInfo = infos.get(dest);
                        if (destInfo == null) {
                            infos.put(dest, (destInfo = new Info()));
                        }
                        if (stationInfo.dist + 1 < destInfo.dist) {
                            destInfo.dist = stationInfo.dist + 1;
                            destInfo.before = station;
                            q.add(dest);
                        }
                    }
                }
            }
            LinkedList<String> path = new LinkedList<>();
            String st = end;
            while (st != null) {
                path.addFirst(st);
                st = infos.get(st).before;
            }
            System.out.println(String.join(" > ", path));
        }
    }

    public static void main(String args[]) {
        new Solution().solve();
    }
}
