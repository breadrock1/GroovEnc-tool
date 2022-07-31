package org.example.grooven.output

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import org.example.grooven.log.Logger


/**
 * This class provides ability to transform collection of {@link String} transformed data to
 * output stream or to specified file.
 */
class ResultWriter {

    /**
     * The specified output file or output stream to print out transformed data.
     */
    String outputPath

    /**
     * This procedure creates output image file and dump generated QrCode.
     *
     * @param bufferedImage The generated {@link BufferedImage} QrCode image.
     * @param outputFile    The {@link File} output file object.
     */
    void dumpImageDataToFile(BufferedImage bufferedImage, File outputFile) {
        ImageIO.write(bufferedImage, 'png', outputFile)
    }

    /**
     * This procedure creates output file and dump transformed string data.
     *
     * @param transformedData The {@link String} transformed string data.
     */
    void dumpResultsDataToOutput(String transformedData) {
        (outputPath)
                ? writeDataToOutputFile(transformedData)
                : writeDataToOutputStream(transformedData)
    }

    /**
     * This procedure writes specified data to {@link ResultWriter#outputPath} output file.
     *
     * @param transformedData The {@link String} transformed string data.
     */
    private writeDataToOutputFile(String transformedData) {
        new File(outputPath)?.withWriter { bufWriter ->
            bufWriter.write(transformedData.toString())
        }
    }

    /**
     * This procedure writes specified data to output stream.
     *
     * @param transformedData The {@link String} transformed string data.
     */
    private writeDataToOutputStream(String transformedData) {
        Logger.infoMessage(transformedData.toString())
    }

}
