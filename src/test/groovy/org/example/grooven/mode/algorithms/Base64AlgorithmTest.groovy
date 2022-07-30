package org.example.grooven.mode.algorithms

import spock.lang.Specification


class Base64AlgorithmTest extends Specification {

    def "testEncodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_encode.txt")
        Base64Algorithm base64Algorithm = new Base64Algorithm()

        when:
        String encodedData = base64Algorithm.encodeSpecifiedData(inputFileData)

        then:
        assert !encodedData.isEmpty()
        assert encodedData == 'SGVyZSBpcyBzaW1wbGUgdGV4dCB0byB0ZXN0IG1vZHVsZXMu'
    }

    def "testDecodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_decode.txt")
        Base64Algorithm base64Algorithm = new Base64Algorithm()

        when:
        String decodedData = base64Algorithm.decodeSpecifiedData(inputFileData)

        then:
        assert !decodedData.isEmpty()
        assert decodedData == 'Here is simple text to test modules.\n'
    }

    private String getTestFileInputData() {
        return this.getClass()
                .getClassLoader()
                .getResource('base64')
                .getPath()
    }

    private String readFileData(String inputFilePath) {
        File inputFile = new File(inputFilePath)
        return inputFile.readLines().join('\n')
    }

}
