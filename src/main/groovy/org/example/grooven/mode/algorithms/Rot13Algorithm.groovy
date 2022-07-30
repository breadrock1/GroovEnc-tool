package org.example.grooven.mode.algorithms


class Rot13Algorithm implements Algorithm {

    @Override
    String encodeSpecifiedData(String sourceData) {
        return rot13(sourceData)
    }

    @Override
    String decodeSpecifiedData(String sourceData) {
        return rot13(sourceData)
    }

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
