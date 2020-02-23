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

package com.anthli.diffr.routing

import com.anthli.diffr.main
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.TestApplicationResponse
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.jupiter.api.Assertions

/**
 * A base class containing generalized testing functionality for routes.
 */
abstract class RouteTest {
  /**
   * Tests the given endpoint and method with the expected response, status,
   * content.
   *
   * @param endpoint
   *        The endpoint to be tested.
   * @param method
   *        The method to test the endpoint with.
   * @param expectedStatus
   *        The expected status from the endpoint request. Default is `null`.
   * @param expectedContent
   *        The expected content from the endpoint request. Default is `null`.
   */
  fun testEndpoint(
    endpoint: String,
    method: HttpMethod,
    expectedStatus: HttpStatusCode? = null,
    expectedContent: String? = null
  ) {
    withTestApplication(Application::main) {
      handleRequest(method, endpoint).apply {
        compare(response, expectedStatus, expectedContent)
      }
    }
  }

  /**
   * Applies a standard set of assertions on the given response.
   *
   * @param response
   *        The response to apply assertions on.
   * @param expectedStatus
   *        The expected status of the response, e.g. 200 OK
   * @param expectedContent
   *        The expected content of the response.
   */
  private fun compare(
    response: TestApplicationResponse,
    expectedStatus: HttpStatusCode?,
    expectedContent: String? = null
  ) {
    Assertions.assertNotNull(response)
    expectedStatus
      ?.let {
        Assertions.assertTrue(response.status() == expectedStatus)
      }
      ?: Assertions.assertNull(response.status())

    expectedContent
      ?.let {
        Assertions.assertNotNull(response.content)
        Assertions.assertEquals(expectedContent, response.content)
      }
      ?: Assertions.assertNull(response.content)
  }
}