@file:Suppress("unused")

package uk.co.ceilingcat.rrd.entities

import java.time.LocalDate

/**
 * Represents an upcoming service.
 */
interface ServiceDetails : Comparable<ServiceDetails> {

    /**
     * The date on which this service is expected.
     */
    val date: ServiceDate

    /**
     * The type of this service.
     */
    val type: ServiceType
}

typealias ServiceDate = LocalDate

/**
 * The types of service this application is concerned with.
 */
enum class ServiceType {
    /**
     * A refuse collection.
     */
    REFUSE,

    /**
     * A recycling collection.
     */
    RECYCLING
}

private data class ImmutableServiceDetails(
    override val date: LocalDate,
    override val type: ServiceType
) : ServiceDetails {
    override fun compareTo(other: ServiceDetails) = date.compareTo(other.date)
}

/**
 * Constructs an immutable instance.
 *
 * @param date the date to which the service applies
 * @param type the type of service
 *
 * @constructor
 */
fun createServiceDetails(
    date: ServiceDate,
    type: ServiceType
): ServiceDetails = ImmutableServiceDetails(date, type)
