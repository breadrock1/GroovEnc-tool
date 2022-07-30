package org.example.grooven.mode.algorithms

import spock.lang.Specification

import java.awt.image.BufferedImage
import javax.imageio.ImageIO


class QrCodeManagerTest extends Specification {

    def "testEncodeSpecifiedData"() {
        setup:
        String inputFileData = readFileData("${getTestFileInputData()}/to_encode.txt")
        QrCodeManager qrCodeAlgorithm = new QrCodeManager()

        when:
        BufferedImage qrCodeImage = qrCodeAlgorithm.generateQrCodeImage(inputFileData)

        then:
        assert qrCodeImage != null
    }

    def "testDecodeSpecifiedData"() {
        setup:
        String inputFileData = new File("${getTestFileInputData()}/to_decode.png")
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(inputFileData))
        QrCodeManager qrCodeAlgorithm = new QrCodeManager()

        when:
        String qrCodeImage = qrCodeAlgorithm.readQrCodeImage(bufferedImage)

        then:
        assert qrCodeImage == "http://127.0.0.1/"
    }

    private String getTestFileInputData() {
        return this.getClass()
                .getClassLoader()
                .getResource('qrcode')
                .getPath()
    }

    private String readFileData(String inputFilePath) {
        File inputFile = new File(inputFilePath)
        return inputFile.readLines().join('\n')
    }

}
