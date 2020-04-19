/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.diffrserver.controller

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
class RootControllerTest : ControllerTest("/") {
  @Test
  fun `test get on root endpoint`() {
    testEndpoint(
      method = HttpMethod.GET,
      expectedStatus = status().isOk
    )
  }
}