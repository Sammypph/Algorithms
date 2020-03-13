import java.util.*;

class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews) {
        // WRITE YOUR CODE HERE

        HashSet<String> competitorsSet = new HashSet<>(competitors);
        HashMap<String, Integer> reviewAndCount = new HashMap<>();

        for (String review : reviews) {
            String[] reviewWords = review.split(" ");

            HashSet<String> temp = new HashSet<>();

            for (String word : reviewWords) {
                if (competitorsSet.contains(word)) temp.add(word);
            }

            for (String w : temp) {
                reviewAndCount.putIfAbsent(w, 0);
                reviewAndCount.put(w, reviewAndCount.get(w) + 1);
            }
        }

        ArrayList<Node> tempRes = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : reviewAndCount.entrySet()) {
            tempRes.add(new Node(entry.getKey(), entry.getValue()));
        }

        Collections.sort(tempRes);

        int k = 0;
        ArrayList<String> res = new ArrayList<>();
        for (Node node : tempRes) {
            if (k == topNCompetitors) break;
            res.add(node.comp);
            k++;
        }

        return res;
    }
    // METHOD SIGNATURE ENDS
}

class Node implements Comparable<Node> {
    String comp;
    int freq;

    Node(String comp, int freq) {
        this.comp = comp;
        this.freq = freq;
    }

    public int compareTo(Node o) {
        int compare = o.freq - this.freq;
        return compare == 0 ? this.comp.compareTo(o.comp) : compare;
    }

}