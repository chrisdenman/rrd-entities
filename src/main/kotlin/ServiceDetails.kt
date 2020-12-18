@file:Suppress("unused")

package uk.co.ceilingcat.rrd.entities

import java.time.LocalDate

/**
 * Represents a pending service date and type.
 */
interface ServiceDetails : Comparable<ServiceDetails> {
    val date: ServiceDate
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
 * Create a `ServiceDetails`.
 *
 * @param date the day on which the service applies
 * @param type the type of service
 *
 * @constructor
 */
fun createServiceDetails(
    date: ServiceDate,
    type: ServiceType
): ServiceDetails = ImmutableServiceDetails(date, type)
