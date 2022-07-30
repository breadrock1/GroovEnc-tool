package org.example.grooven.output

import java.text.SimpleDateFormat

import spock.lang.Specification


class ResultWriterTest extends Specification {

    def "testDumpParsedDataToStream"() {
        setup:
        String inputFileData = loadTestFileInputData()
        ResultWriter resultWriter = new ResultWriter(outputPath: OutputStream.getClass())

        when:
        resultWriter.dumpResultsDataToOutput(inputFileData)

        then:
        assert true
    }

    def "testDumpParsedDataToFile"() {
        setup:
        String inputFileData = loadTestFileInputData()
        File outputFile = generateTestOutputFile()

        ResultWriter resultWriter = new ResultWriter(outputPath: outputFile)

        when:
        resultWriter.dumpResultsDataToOutput(inputFileData)

        then:
        assert !outputFile.readLines().isEmpty()
        assert outputFile.readLines().join('\n') == inputFileData
    }

    private String loadTestFileInputData() {
        String testBytesArrayFilePath = this.getClass()
                .getClassLoader()
                .getResource('text_bytes.txt')
                .getPath()

        File inputFile = new File(testBytesArrayFilePath)
        return inputFile.readLines().join('\n')
    }

    private File generateTestOutputFile() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat('MM-dd-yyyy-HH-mm-ss')
        String outputFileName = "${simpleDateFormat.format(new Date())}"
        return new File("/tmp/${outputFileName}")
    }

}
