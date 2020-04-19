/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.diffrserver.routing

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import org.junit.jupiter.api.Test

class RootRouteTest : RouteTest() {
  @Test
  fun `test get on root endpoint`() {
    testEndpoint("/", HttpMethod.Get, HttpStatusCode.OK, "Root")
  }

  @Test
  fun `test get on invalid endpoint`() {
    testEndpoint("/invalid", HttpMethod.Get)
  }
}