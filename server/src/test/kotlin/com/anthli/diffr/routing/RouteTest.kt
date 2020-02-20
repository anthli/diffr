package com.anthli.diffr.routing

import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.TestApplicationResponse
import org.junit.jupiter.api.Assertions

abstract class RouteTest {
  /**
   * Applies a standard set of assertions on the given response.
   *
   * @param response
   *        The response to apply assertions on.
   * @param status
   *        The expected status of the response, e.g. 200 OK
   * @param content
   *        The expected content of the response.
   */
  fun compare(response: TestApplicationResponse, status: HttpStatusCode, content: String) {
    Assertions.assertNotNull(response)
    Assertions.assertTrue(response.status() == status)

    Assertions.assertNotNull(response.content)
    Assertions.assertEquals(content, response.content)
  }
}