package com.anthli.diffr

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DiffTest {
  @Test
  fun testWithCommonSubsequence() {
    val a = "ABCABBA"
    val b = "CBABAC"
    testDiff(a, b, "BABA")
  }

  @Test
  fun testWithSingleLetterCommonSubsequence() {
    val a = "anxTcjv"
    val b = "byTpqmerf"
    testDiff(a, b, "T")
  }

  @Test
  fun testWithLongCommonSubsequence() {
    val a = "utioweQwertyrWeyuEtyutyuRweryTiopioyYrtyryUutywererutIyuiOiiuyqweP"
    val b = "QzcxvWxcvbEcvbnvRvbnmvbTbnmbnmbnmYcvcvxbUxcvxcvIxcvcvcvOxcvvvzxcvP"
    testDiff(a, b, "QWERTYUIOP")
  }

  @Test
  fun testWithNonAlphanumericCharacters() {
    val a = "[!@#$!@#$]!@#@;$#@!$@#'@#@!$@#@#!,@!#!@#$@3$!@#$.#$#$@#$@!@#$@!#$/"
    val b = "[*&%*%*]%^&*%^&*;%^&*%^&*%^&*%^&*'%^&*%&*%^&*,^&*%^&*^%&*.^&*%^*^/"
    testDiff(a, b, "[];',./")
  }

  @Test
  fun testWithNoCommonSubsequence() {
    val a = "ABC"
    val b = "XYZ"
    testDiff(a, b, "")
  }

  private fun testDiff(a: String, b: String, expectedLcs: String) {
    val diff = Diff(a, b)
    Assertions.assertEquals(expectedLcs, diff.compute())
  }
}