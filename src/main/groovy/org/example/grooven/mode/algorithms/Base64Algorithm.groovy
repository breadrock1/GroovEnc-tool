package org.example.grooven.mode.algorithms


/**
 * The Base64 algorithm is one of the algorithms for Encoding and Decoding an object into ASCII
 * format, which is meant for the base number 64 or one of the methods used to encode the binary
 * data. Base64 Commonly used in various applications such as e-mail via MME, XML data, or for
 * URL encoding purposes.
 */
class Base64Algorithm implements Algorithm {

    /**
     * This method implements {@link Algorithm#encodeSpecifiedData(java.lang.String)} interface
     * method to encode specified {@link String} string data by base64 algorithm.
     *
     * @param sourceData The {@link String} string data to encode by base64 algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String encodeSpecifiedData(String sourceData) {
        return sourceData.bytes.encodeBase64().toString()
    }

    /**
     * This method implements {@link Algorithm#decodeSpecifiedData(java.lang.String)} interface
     * method to decode specified {@link String} string data by base64 algorithm.
     *
     * @param sourceData The {@link String} string data to decode by base64 algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String decodeSpecifiedData(String sourceData) {
        return new String(sourceData.decodeBase64())
    }

}
