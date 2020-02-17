/**
 * diffr - just another diff tool.
 * Copyright (C) <year>  <name of author>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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