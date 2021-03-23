package string.matching;

public class KMP {

  public int[] createLPSArray(String pattern) {
    int patternLen = pattern.length();

    int j = 0;
    int i = 1;
    int[] LPS = new int[patternLen];

    while (i < patternLen) {
      if (pattern.charAt(j) == pattern.charAt(i)) {
        j++;
        LPS[i] = j;
        i++;
      } else {
        // skip the jth character
        if (j == 0) {
          LPS[i] = j;
          i++;
        } else {
          j = LPS[j - 1];
        }
      }
    }

    return LPS;
  }

  public int search(String baseStr, String pattern) {
    int[] LPS = createLPSArray(pattern);
    int i = 0;
    int j = 0;
    int searchIndex = -1;

    while (i < baseStr.length() && j < pattern.length()) {
      if (baseStr.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else {
        // If already at first position skip the i
        if (j == 0) {
          i++;
        } else {
          j = LPS[j - 1];
        }
      }
    }

    if (j == pattern.length()) {
      searchIndex = i - j;
    }

    return searchIndex;
  }

  public static void main(String[] args) {
    String baseStr = "time";
    String pattern = "me";
    KMP kmp = new KMP();
    int searchIndex = kmp.search(baseStr, pattern);

    if (searchIndex != -1) System.out.println(
      searchIndex +
      " pattern: " +
      baseStr.substring(searchIndex, searchIndex + pattern.length())
    );
  }
}
