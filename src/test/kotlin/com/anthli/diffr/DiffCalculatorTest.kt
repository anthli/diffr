package com.anthli.diffr

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DiffCalculatorTest {
  @Test
  fun `diffs generated for "ABCABBA" and "CBABAC"`() {
    val a = "ABCABBA"
    val b = "CBABAC"
    val expectedDiffs = sequenceOf(
      Diff(Operation.DELETE, "A"),
      Diff(Operation.DELETE, "B"),
      Diff(Operation.EQUAL, "C"),
      Diff(Operation.DELETE, "A"),
      Diff(Operation.EQUAL, "B"),
      Diff(Operation.INSERT, "A"),
      Diff(Operation.EQUAL, "B"),
      Diff(Operation.EQUAL, "A"),
      Diff(Operation.INSERT, "C")
    )

    testDiff(a, b, expectedDiffs)
  }

  @Test
  fun `diffs generated for "!@#T$%^" and "&*T()-"`() {
    val a = "!@#T$%^"
    val b = "&*T()-"
    val expectedDiffs = sequenceOf(
      Diff(Operation.DELETE, "!"),
      Diff(Operation.DELETE, "@"),
      Diff(Operation.DELETE, "#"),
      Diff(Operation.INSERT, "&"),
      Diff(Operation.INSERT, "*"),
      Diff(Operation.EQUAL, "T"),
      Diff(Operation.DELETE, "$"),
      Diff(Operation.DELETE, "%"),
      Diff(Operation.DELETE, "^"),
      Diff(Operation.INSERT, "("),
      Diff(Operation.INSERT, ")"),
      Diff(Operation.INSERT, "-")
    )

    testDiff(a, b, expectedDiffs)
  }

  @Test
  fun `diff generated for "A" and "B"`() {
    val a = "A"
    val b = "B"
    val expectedDiffs = sequenceOf(
      Diff(Operation.DELETE, "A"),
      Diff(Operation.INSERT, "B")
    )

    testDiff(a, b, expectedDiffs)
  }

  @Test
  fun `equal diff generated for "A" and "A"`() {
    val a = "A"
    val b = "A"
    val expectedDiffs = sequenceOf(Diff(Operation.EQUAL, "A"))

    testDiff(a, b, expectedDiffs)
  }

  @Test
  fun `all insert diffs generated for "" and "ABC"`() {
    val a = ""
    val b = "ABC"
    val expectedDiffs = sequenceOf(
      Diff(Operation.INSERT, "A"),
      Diff(Operation.INSERT, "B"),
      Diff(Operation.INSERT, "C")
    )

    testDiff(a, b, expectedDiffs)
  }

  @Test
  fun `all delete diffs generated for "ABC" and ""`() {
    val a = "ABC"
    val b = ""
    val expectedDiffs = sequenceOf(
      Diff(Operation.DELETE, "A"),
      Diff(Operation.DELETE, "B"),
      Diff(Operation.DELETE, "C")
    )

    testDiff(a, b, expectedDiffs)
  }

  private fun testDiff(a: String, b: String, expectedDiffs: Sequence<Diff>) {
    val diffCalculator = DiffCalculator(a, b)
    val actualDiffs = diffCalculator.compute().toList()
    Assertions.assertTrue(actualDiffs.count() > 0)

    expectedDiffs.forEachIndexed { i, expectedDiff ->
      val actualDiff = actualDiffs[i]
      Assertions.assertEquals(expectedDiff.op, actualDiff.op)
      Assertions.assertEquals(expectedDiff.text, actualDiff.text)
    }
  }
}