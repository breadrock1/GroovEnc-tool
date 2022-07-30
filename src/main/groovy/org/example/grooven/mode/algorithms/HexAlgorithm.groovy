package org.example.grooven.mode.algorithms


class HexAlgorithm implements Algorithm {

    @Override
    String encodeSpecifiedData(String sourceData) {
        return sourceData.bytes.encodeHex().toString()
    }

    @Override
    String decodeSpecifiedData(String sourceData) {
        return new String(sourceData.decodeHex())
    }

}
