package org.example.grooven.mode.algorithms

import java.util.function.Function


/**
 * The Vigenere cipher is a method of encrypting alphabetic text by using a series
 * of interwoven Caesar ciphers, based on the letters of a keyword. It employs a
 * form of polyalphabetic substitution.
 */
class VigenereAlgorithm implements Algorithm {

    String passPhrase

    Boolean ignoreForeignChars = true

    /**
     * This method implements {@link Algorithm#encodeSpecifiedData(java.lang.String)} interface
     * method to encode specified {@link String} string data by vigenere algorithm.
     *
     * @param sourceData The {@link String} string data to encode by vigenere algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String encodeSpecifiedData(String sourceData) {
        List<Integer> passPhraseBytes = getBytesListFromString(passPhrase, true)
        List<Integer> sourceDataBytes = getBytesListFromString(sourceData, true)

        return sourceDataBytes.withIndex().collect { letter, index ->
            Integer roundedOffset = index % passPhraseBytes.size()
            Integer phraseLetter = passPhraseBytes[roundedOffset]
            Integer xoredLetter = (phraseLetter + letter) % 26
            int asciiOffset = xoredLetter + 97

            return (ignoreForeignChars && (letter as int) < 48)
                    ? (char) letter : (char) asciiOffset

        }.join('')
    }

    /**
     * This method implements {@link Algorithm#decodeSpecifiedData(java.lang.String)} interface
     * method to decode specified {@link String} string data by vigenere algorithm.
     *
     * @param sourceData The {@link String} string data to decode by vigenere algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String decodeSpecifiedData(String sourceData) {
        List<Integer> passPhraseBytes = getBytesListFromString(passPhrase, false)
        List<Integer> sourceDataBytes = getBytesListFromString(sourceData, false)

        return sourceDataBytes.withIndex().collect { letter, index ->
            Integer roundedOffset = index % passPhraseBytes.size()
            Integer phraseLetter = passPhraseBytes[roundedOffset]
            int xoredLetter = (letter - phraseLetter + 26) % 26
            int asciiOffset = xoredLetter + 97

            return (char) asciiOffset

        }.join('')
    }

    /**
     * This method returns {@link List} list container with ascii int values of passed
     * {@link String} string value to crypt/decrypt data by vigenere algorithm.

     * @param inputString   The {@link String} input string to get {@link List} of ascii values.
     * @param isUpperCase   The boolean value to validate input string value.
     * @return
     */
    private List<Integer> getBytesListFromString(String inputString, Boolean isUpperCase) {
        String validatedPhrase = validateStringData(
                inputString, (isUpperCase) ? String::toUpperCase : String::toLowerCase)

        return validatedPhrase.bytes.collect() as List<Integer>
    }

    /**
     * This method returns validated {@link String} string value -> applies passed
     * {@link Function} function to input string and replace all non words characters.
     *
     * @param inputString   The {@link String} input string to validate.
     * @param function      The {@link Function} function to apply to input string.
     * @return The validated {@link String} string value.
     */
    private String validateStringData(String inputString, Function<String, String> function) {
        def upperString = function.apply(inputString)
        return upperString.replaceAll(/\W/, '')
    }

}
