package heap;

import java.util.*;

public class TopKSortWord {

  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> wordFreqHashMap = createFrequencyMap(words);
    List<String> mostFrequentKWords = new ArrayList<>();
    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
      wordFreqHashMap.entrySet()
    );

    PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
      words.length,
      new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(
          Map.Entry<String, Integer> m1,
          Map.Entry<String, Integer> m2
        ) {
          int valueCompareDesc = m2.getValue().compareTo(m1.getValue());
          int nameCompareAsc = m1.getKey().compareTo(m2.getKey());

          // If value is same
          if (valueCompareDesc == 0) {
            // Check if nameCompare is also 0 then both enteries are identical
            return (nameCompareAsc == 0) ? valueCompareDesc : nameCompareAsc;
          } else {
            return valueCompareDesc;
          }
        }
      }
    );

    for (Map.Entry<String, Integer> map : list) {
      maxHeap.add(map);
    }

    Iterator<Map.Entry<String, Integer>> itr2 = maxHeap.iterator();
    while (itr2.hasNext()) {
      Map.Entry<String, Integer> map = itr2.next();
      mostFrequentKWords.add(map.getKey());
      System.out.println(map.getKey() + " " + map.getValue());
    }

    return mostFrequentKWords;
  }

  public HashMap<String, Integer> createFrequencyMap(String[] list) {
    HashMap<String, Integer> hm = new HashMap<>();

    for (String strKey : list) {
      if (!hm.containsKey(strKey)) {
        hm.put(strKey, 1);
      } else {
        int oldFrequency = hm.get(strKey);
        hm.replace(strKey, oldFrequency, oldFrequency + 1);
      }
    }

    return hm;
  }

  public static void main(String[] args) {
    String[] list = {
      "day",
      "is",
      "sunny",
      "the",
      "the",
      "the",
      "sunny",
      "is",
      "is",
    };
    int k = 4;
    List<String> words = new TopKSortWord().topKFrequent(list, k);
    System.out.println(words);
  }
}
