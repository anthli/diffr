/**
 * Copyright (c) 2020 Anthony Li
 *
 * This source code is licensed under the MIT license (see LICENSE for details)
 */

package com.anthli.diffrserver.controller

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.LinkedMultiValueMap

@SpringBootTest
class DiffControllerTest : ControllerTest("/diff") {
  @Test
  fun `test get diff endpoint with parameters`() {
    val params = LinkedMultiValueMap<String, String>()
    params["oldString"] = "ABC"
    params["newString"] = "BCD"

    testEndpoint(
      method = HttpMethod.GET,
      mediaType = MediaType.APPLICATION_JSON,
      params = params,
      expectedStatus = status().isOk,
      expectedContent = """[{"op":"DELETE","text":"A"},{"op":"EQUAL","text":"B"},{"op":"EQUAL","text":"C"},{"op":"INSERT","text":"D"}]"""
    )
  }

  @Test
  fun `test get diff endpoint with no parameters`() {
    testEndpoint(
      method = HttpMethod.GET,
      mediaType = MediaType.APPLICATION_JSON,
      expectedStatus = status().isUnprocessableEntity
    )
  }
}