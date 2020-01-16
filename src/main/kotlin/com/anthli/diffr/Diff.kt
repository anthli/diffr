package com.anthli.diffr

import kotlin.math.max

/**
 * Diff implementation that takes in two sequences and generates a diff output.
 */
class Diff(private val a: String, private val b: String) {
  fun compute(): Int {
    return naiveLCS(a.length, b.length)
  }

  /**
   * A naive implementation of the Longest Common Subsequence algorithm.
   *
   * The issue with this implementation is that is suffers from overlapping
   * subproblems, i.e., the same problem is solved multiple times in the
   * recursive tree. This ends up with a runtime of O(2^N) where N is the sum of
   * the lengths of strings a and b.
   *
   * @param m
   *        The length of string a.
   * @param n
   *        The length of string b.
   */
  fun naiveLCS(m: Int, n: Int): Int {
    if (m == 0 || n == 0) {
      return 0
    }

    if (a[m - 1] == b[n - 1]) {
      return 1 + naiveLCS(m - 1, n - 1)
    }

    return max(naiveLCS(m - 1, n), naiveLCS(m, n -1))
  }

  /**
   * An implementation of the Longest Common Subsequence algorithm using dynamic
   * programming via tabulation.
   *
   * This approach has a much better runtime of only O(mn) where m and n are the
   * lengths of strings a and b, respectively.
   *
   * @param m
   *        The length of string a.
   * @param n
   *        The length of string b.
   */
  fun tabulatedLCS(m: Int, n: Int): Int {
    val editGraph = arrayOf<Array<Int>>()

    for (i in 0..m + 1) {
      for (j in 0..n + 1) {
        if (i == 0 || j == 0) {
          editGraph[i][j] = 0
        }
        else if (a[i - 1] == b[j - 1]) {
          editGraph[i][j] = editGraph[i - 1][j - 1] + 1
        }
        else {
          editGraph[i][j] = max(editGraph[i - 1][j], editGraph[i][j - 1])
        }
      }
    }

    return editGraph[m][n]
  }
}