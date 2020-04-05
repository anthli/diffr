/**
 * diffr - just another diff tool.
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

package com.anthli.diffr.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

/**
 * A base class containing generalized testing functionality for controllers.
 */
@AutoConfigureMockMvc
abstract class ControllerTest {
  @Autowired
  private lateinit var mvc: MockMvc

  fun testEndpoint(
    endpoint: String,
    mediaType: MediaType,
    method: HttpMethod,
    expectedStatus: ResultMatcher,
    expectedContent: String? = null
  ) {
    val builder = MockMvcRequestBuilders.request(method, endpoint).accept(mediaType)
    val result = mvc.perform(builder).andExpect(expectedStatus)
    if (expectedContent != null) {
      result.andExpect(content().string(expectedContent))
    }
  }
}