package org.example.grooven.mode

import org.example.grooven.exception.UnknownAlgorithmException
import org.example.grooven.mode.algorithms.Algorithm
import org.example.grooven.mode.algorithms.Base64Algorithm
import org.example.grooven.mode.algorithms.HexAlgorithm
import org.example.grooven.mode.algorithms.MorseAlgorithm
import org.example.grooven.mode.algorithms.Rot13Algorithm
import org.example.grooven.mode.algorithms.VigenereAlgorithm


class DataTransformer {

    String algorithm

    String inputFileData

    String secretPhrase


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

    static String getInputFileData(String filePath) {
        return new File(filePath).readLines().join('\n')
    }

}
