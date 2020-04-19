/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.diffrserver.routing

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import org.junit.jupiter.api.Test

class DiffRouteTest : RouteTest() {
  @Test
  fun `test get on diff endpoint`() {
    testEndpoint("/diff", HttpMethod.Get, HttpStatusCode.OK, "Diff")
  }
}