/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.diffrserver.controller

import com.anthli.kdiff.Diff
import com.anthli.kdiff.DiffCalculator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Routing for the diff endpoint.
 */
@RestController
class DiffController {
  @GetMapping("/diff")
  fun getDiff(
    oldString: String?,
    newString: String?
  ): ResponseEntity<List<Diff>> {
    if (oldString == null || newString == null) {
      return ResponseEntity.unprocessableEntity().build()
    }

    val diffCalculator = DiffCalculator(oldString, newString)
    val diffs = diffCalculator.compute()
    return ResponseEntity.ok(diffs.toList())
  }
}