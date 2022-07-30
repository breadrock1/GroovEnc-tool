package org.example.grooven.mode.algorithms


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

    @Override
    String encodeSpecifiedData(String sourceData) {
        return sourceData.collect() { letter ->

            int alphabetIndex = alphabetArray.findIndexOf {
                it.equalsIgnoreCase(letter)
            }

            return (alphabetIndex < 0) ? '' : morseArray.get(alphabetIndex) as String

        }.join(' ')
    }

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
