package org.example.grooven.mode.algorithms

import spock.lang.Specification


class VigenereAlgorithmTest extends Specification {

    def "testEncodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_encode.txt")

        VigenereAlgorithm vigenereAlgorithm =
                new VigenereAlgorithm(passPhrase: 'secretpassphrase', ignoreForeignChars: true)

        when:
        String encodedData = vigenereAlgorithm.encodeSpecifiedData(inputFileData)

        then:
        assert !encodedData.isEmpty()
        assert encodedData == 'zitvmlhiehalkepxlsvvwmbovmalj'
    }

    def "testDecodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_decode.txt")
        VigenereAlgorithm vigenereAlgorithm = new VigenereAlgorithm(passPhrase: 'secretpassphrase')

        when:
        String decodedData = vigenereAlgorithm.decodeSpecifiedData(inputFileData)

        then:
        assert !decodedData.isEmpty()
        assert decodedData == 'hereissimpletexttotestmodules'
    }

    private String getTestFileInputData() {
        return this.getClass()
                .getClassLoader()
                .getResource('vigenere')
                .getPath()
    }

    private String readFileData(String inputFilePath) {
        File inputFile = new File(inputFilePath)
        return inputFile.readLines().join('\n')
    }

}
