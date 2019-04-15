package com.kostikum.cleancode.data.repository

import com.kostikum.cleancode.data.repository.vehicle.VehicleRepositoryRemote
import com.kostikum.cleancode.domain.entity.vehicle.CoordinateParam
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class VehicleRepositoryRemoteTest {

    private lateinit var mockServer: MockWebServer
    private lateinit var url: String

    @Before
    fun setUp() {
        mockServer = MockWebServer()
        mockServer.start()

        url = mockServer.url("/").toString()
    }

    @After
    fun release() {
        mockServer.shutdown()
    }



    @Test
    fun TestNormalRepository() {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)
        mockResponse.setBody(JsonUtil.getJson(JsonUtil.NORMAL_RESPONSE))

        val repository = VehicleRepositoryRemote(url)
        val coordinateParam = CoordinateParam(
            lat1 = 2.25,
            lon1 = 5.145,
            lat2 = 5.544,
            lon2 = 2.345
        )

        repository
            .fetch(coordinateParam)
            .test()
            .assertValue{
                it.size == 11
            }
    }

    @Test
    fun TestErrorRepository() {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)
        mockResponse.setBody(JsonUtil.getJson(JsonUtil.NORMAL_RESPONSE))

        val repository = VehicleRepositoryRemote(url)
        val coordinateParam = CoordinateParam(
            lat1 = 2.25,
            lon1 = 5.145,
            lat2 = 5.544,
            lon2 = 2.345
        )

        repository
            .fetch(coordinateParam)
            .test()
            .assertError{
                true
            }
    }



    @Test
    fun testRealRequestComplete() {

        val url = "http://kiparo.ru/t/fake-api/car-service.php"
        val repository = VehicleRepositoryRemote(url)

        val coordinateParam = CoordinateParam(
            lat1 = 2.25,
            lon1 = 5.145,
            lat2 = 5.544,
            lon2 = 2.345
        )

        repository
            .fetch(coordinateParam)
            .test()
            .assertComplete()
    }


}