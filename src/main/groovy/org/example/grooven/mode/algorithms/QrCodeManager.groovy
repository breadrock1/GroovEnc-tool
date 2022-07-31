package org.example.grooven.mode.algorithms

import com.google.zxing.BarcodeFormat
import com.google.zxing.BinaryBitmap
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatReader
import com.google.zxing.Result
import com.google.zxing.client.j2se.BufferedImageLuminanceSource
import com.google.zxing.common.BitMatrix
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel

import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage


/**
 * A QR code (an initialism for quick response code) is a type of matrix barcode (or
 * two-dimensional barcode) invented in 1994 by the Japanese automotive company Denso
 * Wave. A barcode is a machine-readable optical label that can contain information
 * about the item to which it is attached. In practice, QR codes often contain data for
 * a locator, identifier, or tracker that points to a website or application. A QR code
 * is case sensitive. It uses four standardized encoding modes (numeric, alphanumeric,
 * byte/binary, and kanji) to store data efficiently; extensions may also be used.
 */
class QrCodeManager {

    Integer bitMatrixSize = 125

    Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap =
            new Hashtable<EncodeHintType, ErrorCorrectionLevel>() {{
                put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L)
            }}

    /**
     * This method returns generated QrCode {@link BufferedImage} buffered image
     * from specified {@link String} string value.
     *
     * @param sourceData The {@link String} string data to generate QrCode image.
     * @return The {@link BufferedImage} buffered image with generated QrCode.
     */
    BufferedImage generateQrCodeImage(String sourceData) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter()

        BitMatrix bitMatrix = qrCodeWriter.encode(sourceData, BarcodeFormat.QR_CODE, bitMatrixSize, bitMatrixSize, hintMap)

        Integer crunchWidth = bitMatrix.getWidth()
        BufferedImage bufferedImage =
                new BufferedImage(crunchWidth, crunchWidth, BufferedImage.TYPE_INT_RGB)

        bufferedImage.createGraphics()
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics()

        //Color the entire image white
        graphics.setColor(Color.WHITE)
        graphics.fillRect(0, 0, crunchWidth, crunchWidth)

        //Change color to black
        graphics.setColor(Color.BLACK)

        //Read black points and set to image
        for (int i = 0; i < crunchWidth; i++) {
            for (int j = 0; j < crunchWidth; j++) {
                if (bitMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1)
                }
            }
        }

        return bufferedImage
    }

    /**
     * This method returns {@link String} string value from specified {@link BufferedImage}
     * buffered image (QrCode).
     *
     * @param bufferedImage The {@link BufferedImage} buffered image with QrCode to decode.
     * @return The {@link String} string data stored into QrCode image.
     */
    String readQrCodeImage(BufferedImage bufferedImage) {
        BufferedImageLuminanceSource bufferedImageLuminanceSource =
                new BufferedImageLuminanceSource(bufferedImage)

        HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource)
        BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer)
        Result result = new MultiFormatReader().decode(binaryBitmap)
        return result.getText();
    }

}
