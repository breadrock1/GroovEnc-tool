package org.example.grooven.mode.algorithms


class Base64Algorithm implements Algorithm {

    @Override
    String encodeSpecifiedData(String sourceData) {
        return sourceData.bytes.encodeBase64().toString()
    }

    @Override
    String decodeSpecifiedData(String sourceData) {
        return new String(sourceData.decodeBase64())
    }

}
