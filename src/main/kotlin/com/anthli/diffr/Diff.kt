package com.anthli.diffr

import kotlin.math.max

/**
 * Diff implementation that takes in two sequences and generates a diff output.
 */
class Diff(private val a: String, private val b: String) {
  fun compute(): String {
    val editGraph = getLcsEditGraph(a.length, b.length)
    return getLcs(editGraph, a.length, b.length)
  }

  /**
   * A naive implementation of the Longest Common Subsequence algorithm.
   *
   * The issue with this implementation is that is suffers from overlapping
   * subproblems, i.e., the same problem is solved multiple times in the
   * recursive tree. This ends up with a runtime of O(2^N) where N is the sum of
   * the lengths of strings a and b.
   *
   * This will be kept here for educational purposes.
   *
   * @param m
   *        The length of string a.
   * @param n
   *        The length of string b.
   */
  private fun naiveLcs(m: Int, n: Int): Int {
    if (m == 0 || n == 0) {
      return 0
    }

    if (a[m - 1] == b[n - 1]) {
      return 1 + naiveLcs(m - 1, n - 1)
    }

    return max(naiveLcs(m - 1, n), naiveLcs(m, n -1))
  }

  /**
   * An implementation of the Longest Common Subsequence algorithm using dynamic
   * programming via tabulation.
   *
   * This approach has a much better runtime of only O(MN) where M and N are the
   * lengths of strings a and b, respectively.
   *
   * @param m
   *        The length of string a.
   * @param n
   *        The length of string b.
   * @return The [EditGraph] containing the path of the longest common
   *         subsequence.
   */
  private fun getLcsEditGraph(m: Int, n: Int): EditGraph {
    val editGraph = EditGraph(m, n)

    for (i in 1..m) {
      for (j in 1..n) {
        if (a[i - 1] == b[j - 1]) {
          editGraph[i, j] = 1 + editGraph[i - 1, j - 1]
        }
        else {
          editGraph[i, j] = max(editGraph[i - 1, j], editGraph[i, j - 1])
        }
      }
    }

    return editGraph
  }

  private fun getLcs(editGraph: EditGraph, m: Int, n: Int): String {
    if (m == 0 || n == 0) {
      return ""
    }

    if (a[m - 1] == b[n - 1]) {
      return getLcs(editGraph, m - 1, n - 1) + a[m - 1]
    }

    if (editGraph[m - 1, n] < editGraph[m, n - 1]) {
      return getLcs(editGraph, m, n - 1)
    }

    return getLcs(editGraph, m - 1, n)
  }
}