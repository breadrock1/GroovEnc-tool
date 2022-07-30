package org.example.grooven.mode.algorithms

import spock.lang.Specification

class MorseAlgorithmTest extends Specification {

    def "testEncodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_encode.txt")
        MorseAlgorithm morseAlgorithm = new MorseAlgorithm()

        when:
        String encodedData = morseAlgorithm.encodeSpecifiedData(inputFileData)

        then:
        assert !encodedData.isEmpty()
        assert encodedData == '.... . .-. . | .. ... | ... .. -- .--. .-.. . | - . -..- - | - --- | - . ... - | -- --- -.. ..- .-.. . ... '
    }

    def "testDecodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_decode.txt")
        MorseAlgorithm morseAlgorithm = new MorseAlgorithm()

        when:
        String decodedData = morseAlgorithm.decodeSpecifiedData(inputFileData)

        then:
        assert !decodedData.isEmpty()
        assert decodedData == 'here is simple text to test modules'
    }

    private String getTestFileInputData() {
        return this.getClass()
                .getClassLoader()
                .getResource('morse')
                .getPath()
    }

    private String readFileData(String inputFilePath) {
        File inputFile = new File(inputFilePath)
        return inputFile.readLines().join('\n')
    }

}
