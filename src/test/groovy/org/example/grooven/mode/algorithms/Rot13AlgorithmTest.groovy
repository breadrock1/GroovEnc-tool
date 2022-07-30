package org.example.grooven.mode.algorithms

import spock.lang.Specification

class Rot13AlgorithmTest extends Specification {

    def "testEncodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_encode.txt")
        Rot13Algorithm rot13Algorithm = new Rot13Algorithm()

        when:
        String encodedData = rot13Algorithm.encodeSpecifiedData(inputFileData)

        then:
        assert !encodedData.isEmpty()
        assert encodedData == 'Urer vf fvzcyr grkg gb grfg zbqhyrf.'
    }

    def "testDecodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_decode.txt")
        Rot13Algorithm rot13Algorithm = new Rot13Algorithm()

        when:
        String decodedData = rot13Algorithm.decodeSpecifiedData(inputFileData)

        then:
        assert !decodedData.isEmpty()
        assert decodedData == 'Here is simple text to test modules.'
    }

    private String getTestFileInputData() {
        return this.getClass()
                .getClassLoader()
                .getResource('rot13')
                .getPath()
    }

    private String readFileData(String inputFilePath) {
        File inputFile = new File(inputFilePath)
        return inputFile.readLines().join('\n')
    }

}
