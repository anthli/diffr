package com.anthli.diffr

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DiffTest {
  @Test
  fun `test Operation INSERT toString`() {
    val diff = Diff(Operation.INSERT, "A")
    Assertions.assertEquals("+A", diff.toString())
  }

  @Test
  fun `test Operation DELETE toString`() {
    val diff = Diff(Operation.DELETE, "b")
    Assertions.assertEquals("-b", diff.toString())
  }

  @Test
  fun `test Operation EQUAL toString`() {
    val diff = Diff(Operation.EQUAL, "1")
    Assertions.assertEquals("1", diff.toString())
  }
}