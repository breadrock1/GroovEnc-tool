package org.example.grooven.mode.algorithms


/**
 * The hexadecimal (also base 16 or simply hex) numeral system is a positional numeral
 * system that represents numbers using a radix (base) of 16. Unlike the decimal system
 * representing numbers using 10 symbols, hexadecimal uses 16 distinct symbols, most
 * often the symbols "0"–"9" to represent values 0 to 9, and "A"–"F" (or alternatively
 * "a"–"f") to represent values from 10 to 15.
 */
class HexAlgorithm implements Algorithm {

    /**
     * This method implements {@link Algorithm#encodeSpecifiedData(java.lang.String)} interface
     * method to encode specified {@link String} string data to hexadecimal string.
     *
     * @param sourceData The {@link String} string data to encode to hexadecimal string.
     * @return The transformed {@link String} string value.
     */
    @Override
    String encodeSpecifiedData(String sourceData) {
        return sourceData.bytes.encodeHex().toString()
    }

    /**
     * This method implements {@link Algorithm#decodeSpecifiedData(java.lang.String)} interface
     * method to decode specified {@link String} string data from hexadecimal string.
     *
     * @param sourceData The {@link String} string data to decode to hexadecimal string.
     * @return The transformed {@link String} string value.
     */
    @Override
    String decodeSpecifiedData(String sourceData) {
        return new String(sourceData.decodeHex())
    }

}
