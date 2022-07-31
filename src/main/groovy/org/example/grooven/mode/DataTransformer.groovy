package org.example.grooven.mode

import org.example.grooven.exception.UnknownAlgorithmException
import org.example.grooven.mode.algorithms.Algorithm
import org.example.grooven.mode.algorithms.Base64Algorithm
import org.example.grooven.mode.algorithms.HexAlgorithm
import org.example.grooven.mode.algorithms.MorseAlgorithm
import org.example.grooven.mode.algorithms.Rot13Algorithm
import org.example.grooven.mode.algorithms.VigenereAlgorithm


/**
 * This class provides ability to parsed selected {@link Algorithm} algorithm by user
 * from command line interface to encode/decode specified data.
 */
class DataTransformer {

    /**
     * The {@link String} string value with algorithm name passed to cli.
     */
    String algorithm

    /**
     * The {@link String} string data stored into specified file or passed as cli argument.
     */
    String inputFileData

    /**
     * The {@link String} string data of secret phrase passed as cli argument.
     */
    String secretPhrase


    /**
     * This method returns implemented {@link Algorithm} algorithm class object from
     * passed argument from command line interface to encode/decode passed data.
     *
     * @return The implemented {@link Algorithm} algorithm class object.
     * @throws UnknownAlgorithmException throws while passes algorithm has not been founded.
     */
    def <T extends Algorithm> T switchSelectedAlgorithm()
            throws UnknownAlgorithmException {

        switch (algorithm) {
            case "base64":
                return new Base64Algorithm() as T

            case "hex":
                return new HexAlgorithm() as T

            case "morse":
                return new MorseAlgorithm() as T

            case "rot13":
                return new Rot13Algorithm() as T

            case "vigenere":
                return new VigenereAlgorithm(passPhrase: secretPhrase) as T

            default:
                throw new UnknownAlgorithmException(
                        "Has been specified unknown algorithm: '${algorithm}'")
        }
    }

    /**
     * This method returns {@link String} string value from specified file path.
     *
     * @param filePath The path to file.
     * @return The stored {@link String} string data into file.
     */
    static String getInputFileData(String filePath) {
        return new File(filePath).readLines().join('\n')
    }

}
