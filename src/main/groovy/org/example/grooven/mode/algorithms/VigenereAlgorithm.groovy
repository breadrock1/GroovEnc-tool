package org.example.grooven.mode.algorithms

import java.util.function.Function


class VigenereAlgorithm implements Algorithm {

    String passPhrase

    Boolean ignoreForeignChars = true

    @Override
    String encodeSpecifiedData(String sourceData) {
        String validatedPhrase = validateStringData(passPhrase, String::toUpperCase)
        String validatedSource = validateStringData(sourceData, String::toUpperCase)

        List<Integer> passPhraseBytes = validatedPhrase.bytes.collect() as List<Integer>
        List<Integer> sourceDataBytes = validatedSource.bytes.collect() as List<Integer>

        return sourceDataBytes.withIndex().collect { letter, index ->
            Integer roundedOffset = index % passPhraseBytes.size()
            Integer phraseLetter = passPhraseBytes[roundedOffset]
            Integer xoredLetter = (phraseLetter + letter) % 26
            int asciiOffset = (xoredLetter + 97)

            return (ignoreForeignChars && (letter as int) < 48)
                    ? (char) letter : (char) asciiOffset

        }.join('')
    }

    @Override
    String decodeSpecifiedData(String sourceData) {
        String validatedPhrase = validateStringData(passPhrase, String::toLowerCase)
        String validatedSource = validateStringData(sourceData, String::toLowerCase)

        List<Integer> passPhraseBytes = validatedPhrase.bytes.collect() as List<Integer>
        List<Integer> sourceDataBytes = validatedSource.bytes.collect() as List<Integer>

        return sourceDataBytes.withIndex().collect { letter, index ->
            Integer roundedOffset = index % passPhraseBytes.size()
            Integer phraseLetter = passPhraseBytes[roundedOffset]
            int xoredLetter = (letter - phraseLetter + 26) % 26
            int asciiOffset = xoredLetter + 97

            return (char) asciiOffset

        }.join('')
    }

    private String validateStringData(String inputString, Function<String, String> function) {
        def upperString = function.apply(inputString)
        return upperString.replaceAll(/\W/, '')
    }

}
