package org.example.grooven.mode.algorithms


/**
 * ROT13 ("rotate by 13 places", sometimes hyphenated ROT-13) is a simple letter
 * substitution cipher that replaces a letter with the 13th letter after it in
 * the alphabet. ROT13 is a special case of the Caesar cipher which was developed
 * in ancient Rome.
 */
class Rot13Algorithm implements Algorithm {

    /**
     * This method implements {@link Algorithm#encodeSpecifiedData(java.lang.String)} interface
     * method to encode specified {@link String} string data by rot13 algorithm.
     *
     * @param sourceData The {@link String} string data to encode by rot13 algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String encodeSpecifiedData(String sourceData) {
        return rot13(sourceData)
    }

    /**
     * This method implements {@link Algorithm#decodeSpecifiedData(java.lang.String)} interface
     * method to decode specified {@link String} string data by rot13 algorithm.
     *
     * @param sourceData The {@link String} string data to decode by rot13 algorithm.
     * @return The transformed {@link String} string value.
     */
    @Override
    String decodeSpecifiedData(String sourceData) {
        return rot13(sourceData)
    }

    /**
     * This method returns transformed specified {@link String} string value by rot13 algorithm.
     *
     * @param sourceData The {@link String} string data to transform.
     * @return The transformed {@link String} string value.
     */
    private static String rot13(String sourceData) {
        return sourceData.collect(){ String letter ->
            Character character = letter.toCharacter()

            if (character >= ('a' as Character) && character <= ('m' as Character))
                character += 13

            else
            if  (character >= ('n' as Character) && character <= ('z' as Character))
                character -= 13;

            else
            if  (character >= ('A' as Character) && character <= ('M' as Character))
                character += 13;

            else
            if  (character >= ('N' as Character) && character <= ('Z' as Character))
                character -= 13;

            return character.toString()
        }.join('')
    }

}
