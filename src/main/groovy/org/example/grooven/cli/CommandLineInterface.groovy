package org.example.grooven.cli

import groovy.cli.picocli.CliBuilder
import groovy.cli.picocli.OptionAccessor

import org.example.grooven.log.Logger
import org.example.grooven.mode.DataTransformer
import org.example.grooven.mode.algorithms.Algorithm
import org.example.grooven.mode.algorithms.QrCodeManager
import org.example.grooven.output.ResultWriter

import javax.imageio.ImageIO
import java.awt.image.BufferedImage


/**
 * This class class implements command line interface to parse entered options by user
 * and select encoding/decoding application running mode. There are available two launching modes:
 *
 * <ol>
 *  <li value = "1">
 *      Encrypt or Encode entered data by specified encryption algorithm name;
 *  </li>
 *  <li value = "2">
 *      Decrypt or Decode entered data by specified encryption algorithm name;
 *  </li>
 * </ol>
 */
enum CommandLineInterface {

    INSTANCE

    /**
     * This is {@link CliBuilder} cli builder class which provides a builder functionality to
     * assist the processing of command line arguments.
     */
    CliBuilder cliBuilder

    /**
     *
     */
    CommandLineInterface() {
        cliBuilder = new CliBuilder(
                usage: '-[f|d] <path to report(s)> -o <output file>',
                header: 'This application provides ability to encode/decode data, ' +
                        'generate/read QrCode images and other algorithms.\nOptions:',
                footer: 'breadrock1 - 2022.'
        )

        cliBuilder.width = 100
        cliBuilder.with {
            h longOpt: 'help', 'Print help message with usage.'

            e longOpt: 'encode', args: 1, argName: 'encode', 'Encode data by specified algorithm.'
            d longOpt: 'decode', args: 1, argName: 'decode', 'Decode data by specified algorithm.'
            q longOpt: 'qrcode', args: 1, argName: 'qrcode', 'Generate/Read QrCode image.'

            s longOpt: 'secret', args: 1, argName: 'secret', 'Secret phrase to encrypt/decrypt data.'

            f longOpt: 'file', args: 1, argName: 'file', 'Input file path to transform data.'
            o longOpt: 'output', args: 1, argName: 'output', 'Output path to save transformed data.'
        }
    }

    /**
     * This method parses command line arguments entered by user to select running mode.
     *
     * @param args The entered arguments.
     */
    void parse(args) {
        OptionAccessor options = cliBuilder.parse(args)

        if (!options) {
            printOutUsageInformation('Has not been specified any options.\n')
        }

        if (options.h) {
            cliBuilder.usage()
            System.exit 0
        }

        if (!options.e && !options.d && !options.q) {
            printOutUsageInformation('Has not been specified any mode option.\n')
        }

        Serializable secretPhrase = (options.s) ? options.s as String : null
        Serializable outputStream = (options.o) ? options.o as String : null
        Serializable inputStream = (options.f)
                ? DataTransformer.getInputFileData(options.f as String)
                : options.arguments().first() as String

        ResultWriter resultWriter = new ResultWriter(outputPath: outputStream)
        DataTransformer dataTransformer = new DataTransformer(
                inputFileData: inputStream, secretPhrase: secretPhrase)

        if (options.e) {
            dataTransformer.setProperty('algorithm', options.e as String)
            Algorithm algorithm = dataTransformer.switchSelectedAlgorithm()
            String encodedData = algorithm.encodeSpecifiedData(inputStream)
            resultWriter.dumpResultsDataToOutput(encodedData)
        }

        if (options.d) {
            dataTransformer.setProperty('algorithm', options.d as String)
            Algorithm algorithm = dataTransformer.switchSelectedAlgorithm()
            String decodedData = algorithm.decodeSpecifiedData(inputStream)
            resultWriter.dumpResultsDataToOutput(decodedData)
        }

        if (options.q) {
            QrCodeManager qrCodeManager = new QrCodeManager()

            if (options.q == 'generate') {
                BufferedImage bufferedImage = qrCodeManager.generateQrCodeImage(inputStream)
                resultWriter.dumpImageDataToFile(bufferedImage, new File(outputStream))
            }

            if (options.q == 'read') {
                BufferedImage bufferedImage = ImageIO.read(new File(inputStream))
                String loadedData = qrCodeManager.readQrCodeImage(bufferedImage)
                resultWriter.dumpResultsDataToOutput(loadedData)
            }
        }
    }

    /**
     * This procedure prints out usage information to terminal output stream while parsing
     * current arguments has been failed.
     *
     * @param errorMessage The error message string value.
     */
    private void printOutUsageInformation(String errorMessage) {
        Logger.errorMessage('Error while parsing command-line options: ')
        Logger.errorMessage(errorMessage)

        cliBuilder.usage()
        System.exit 1
    }

}
