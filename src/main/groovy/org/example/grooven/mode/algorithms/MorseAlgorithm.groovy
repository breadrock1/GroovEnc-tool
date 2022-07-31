package org.example.grooven.mode.algorithms


/**
 * Morse code is a method used in telecommunication to encode text characters as
 * standardized sequences of two different signal durations, called dots and dashes,
 * or dits and dahs. Morse code is named after Samuel Morse, one of the inventors of
 * the telegraph.
 */
class MorseAlgorithm implements Algorithm {

    final static def alphabetArray = [
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " ", "\n"
    ] as List<String>

    final static def morseArray = [
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--",
            "....-", ".....", "-....", "--...", "---..", "----.", "-----", "|", "\n"
    ] as List<String>

    /**
     * This method implements {@link Algorithm#encodeSpecifiedData(java.lang.String)} interface
     * method to encode specified {@link String} string data by morse algorithm.
     *
     * @param sourceData The {@link String} string data to encode by morse algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String encodeSpecifiedData(String sourceData) {
        return sourceData.collect() { letter ->

            int alphabetIndex = alphabetArray.findIndexOf {
                it.equalsIgnoreCase(letter)
            }

            return (alphabetIndex < 0) ? '' : morseArray.get(alphabetIndex) as String

        }.join(' ')
    }

    /**
     * This method implements {@link Algorithm#decodeSpecifiedData(java.lang.String)} interface
     * method to decode specified {@link String} string data by morse algorithm.
     *
     * @param sourceData The {@link String} string data to decode by morse algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String decodeSpecifiedData(String sourceData) {
        return sourceData.split(' ').collect() { letter ->

            int morseIndex = morseArray.findIndexOf {
                it.equalsIgnoreCase(letter)
            }

            return (morseIndex < 0) ? '' : alphabetArray.get(morseIndex) as String

        }.join('')
    }

}
