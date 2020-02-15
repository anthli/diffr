package com.anthli.diffr

/**
 * The different types of operations that can happen in a diff.
 */
enum class Operation {
  /**
   * A change caused by insertion.
   */
  INSERT,

  /**
   * A change caused by deletion.
   */
  DELETE,

  /**
   * No change.
   */
  EQUAL
}