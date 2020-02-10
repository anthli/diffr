package com.anthli.diffr

/**
 * Encapsulation of the type of operation and the involved text of a diff.
 */
data class Diff(val op: Operation, val text: String) {
  override fun toString(): String {
    return buildString {
      append(when (op) {
        Operation.EQUAL -> ""
        Operation.INSERT -> "+"
        Operation.DELETE -> "-"
      })
      append(text)
    }
  }
}