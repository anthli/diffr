package com.anthli.diffr

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DiffTest {
  @Test
  fun testDiffWithCommonSubsequence() {
    val a = "ABCABBA"
    val b = "CBABAC"

    val diff = Diff(a, b)
    Assertions.assertEquals(4, diff.compute())
  }

  @Test
  fun testDiffWithNoCommonSubsequence() {
    val a = "ABC"
    val b = "XYZ"

    val diff = Diff(a, b)
    Assertions.assertEquals(0, diff.compute())
  }
}