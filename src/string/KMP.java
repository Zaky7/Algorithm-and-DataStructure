package string;

import java.util.Arrays;

public class KMP {

  public int[] createLPSArray(String pattern) {
    int patternLen = pattern.length();

    int len = 0;
    int i = 1;
    int[] LPS = new int[patternLen];

    while (i < patternLen) {
      if (pattern.charAt(len) == pattern.charAt(i)) {
        len++;
        LPS[i] = len;
        i++;
      } else {
        // skip the jth character
        if (len == 0) {
          LPS[i] = len;
          i++;
        } else {
          len = LPS[len - 1];
        }
      }
    }

    return LPS;
  }

  public int search(String baseStr, String pattern) {
    int[] LPS = createLPSArray(pattern);
    int i = 0;
    int j = 0;
    int matchedChars = 0;
    int searchIndex = -1;

    while (i < baseStr.length()) {
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

      if (j == pattern.length()) {
        if (searchIndex == -1) {
          searchIndex = i - j;
        }
        break;
      }
    }

    return searchIndex;
  }

  public static void main(String[] args) {
    String baseStr = "abxabcabxabcabcaby";
    String pattern = "bd";
    KMP kmp = new KMP();
    int searchIndex = kmp.search(baseStr, pattern);

    if (searchIndex != -1) System.out.println(
      searchIndex +
      " pattern: " +
      baseStr.substring(searchIndex, searchIndex + pattern.length())
    );
  }
}
