package uk.co.ceilingcat.rrd.entities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import java.time.LocalDate

@TestInstance(PER_CLASS)
internal class ServiceDetailsTests {

    @Test
    fun `That createServiceDetails() returns instances with the correct property values`() {
        createServiceDetails(serviceDate, serviceType).run {
            assertEquals(serviceDate, date)
            assertEquals(serviceType, type)
        }
    }

    companion object {
        private val serviceDate = LocalDate.now()!!
        private val serviceType = ServiceType.RECYCLING
    }
}
