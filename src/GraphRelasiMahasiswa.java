import java.util.*;

public class GraphRelasiMahasiswa {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void tambahMahasiswa(String nim) {
        adjList.putIfAbsent(nim, new ArrayList<>());
    }

    public void tambahRelasi(String nim1, String nim2) {
        adjList.putIfAbsent(nim1, new ArrayList<>());
        adjList.putIfAbsent(nim2, new ArrayList<>());
        adjList.get(nim1).add(nim2);
        adjList.get(nim2).add(nim1);
    }

    public void tampilkanRelasi() {
        for (String nim : adjList.keySet()) {
            System.out.println("🔗 " + nim + " terhubung dengan: " + adjList.get(nim));
        }
    }

    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            String nim = queue.poll();
            System.out.print(nim + " ");
            for (String tetangga : adjList.getOrDefault(nim, new ArrayList<>())) {
                if (!visited.contains(tetangga)) {
                    visited.add(tetangga);
                    queue.add(tetangga);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsRec(start, visited);
        System.out.println();
    }

    private void dfsRec(String nim, Set<String> visited) {
        visited.add(nim);
        System.out.print(nim + " ");
        for (String tetangga : adjList.getOrDefault(nim, new ArrayList<>())) {
            if (!visited.contains(tetangga)) {
                dfsRec(tetangga, visited);
            }
        }
    }
}
