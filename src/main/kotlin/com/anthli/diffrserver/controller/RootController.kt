/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.diffrserver.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Routing for the root endpoint.
 */
@RestController
class RootController {
  @GetMapping("/")
  fun getIndex(): ResponseEntity<Unit> = ResponseEntity.ok().build()
}