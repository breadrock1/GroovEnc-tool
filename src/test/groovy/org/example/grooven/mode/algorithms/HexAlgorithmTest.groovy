package org.example.grooven.mode.algorithms

import spock.lang.Specification


class HexAlgorithmTest extends Specification {

    def "testEncodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_encode.txt")
        HexAlgorithm hexAlgorithm = new HexAlgorithm()

        when:
        String encodedData = hexAlgorithm.encodeSpecifiedData(inputFileData)

        then:
        assert !encodedData.isEmpty()
        assert encodedData == '486572652069732073696d706c65207465787420746f2074657374206d6f64756c65732e'
    }

    def "testDecodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_decode.txt")
        HexAlgorithm hexAlgorithm = new HexAlgorithm()

        when:
        String decodedData = hexAlgorithm.decodeSpecifiedData(inputFileData)

        then:
        assert !decodedData.isEmpty()
        assert decodedData == 'Here is simple text to test modules.'
    }

    private String getTestFileInputData() {
        return this.getClass()
                .getClassLoader()
                .getResource('hex')
                .getPath()
    }

    private String readFileData(String inputFilePath) {
        File inputFile = new File(inputFilePath)
        return inputFile.readLines().join('\n')
    }

}
