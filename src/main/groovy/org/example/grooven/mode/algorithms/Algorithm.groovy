package org.example.grooven.mode.algorithms


/**
 * This is main interface to implements encoding/decoding algorithms.
 */
interface Algorithm {

    /**
     * This interface method encodes specified string data.
     *
     * @param sourceData The {@link String} string data to encode.
     * @return The transformed {@link String} string value.
     */
    String encodeSpecifiedData(String sourceData)

    /**
     * This interface method decodes specified string data.
     *
     * @param sourceData The {@link String} string data to decode.
     * @return The transformed {@link String} string value.
     */
    String decodeSpecifiedData(String sourceData)

}
