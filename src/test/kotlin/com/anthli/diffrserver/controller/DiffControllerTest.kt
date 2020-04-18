/**
 * diffr - just another diff tool
 * Copyright (C) 2020 Anthony Li
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