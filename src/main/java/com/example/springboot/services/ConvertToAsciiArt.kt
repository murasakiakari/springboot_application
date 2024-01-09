package com.example.springboot.services

import java.awt.Image
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

const val WIDTH = 120
const val CHARS = " _.,-=+:;cba!?0123456789\$W#@Ñ"

fun convertToAsciiArt(image: ByteArray): String {
    val byteArrayInputStream = image.inputStream()
    val originalImage = ImageIO.read(byteArrayInputStream)

    val height = (WIDTH.toDouble() / originalImage.width.toDouble() * originalImage.height.toDouble()).toInt()
    val scaledImage = originalImage.getScaledInstance(WIDTH, height, Image.SCALE_SMOOTH)
    val bufferedImage = BufferedImage(WIDTH, height, BufferedImage.TYPE_INT_RGB)

    val graphics = bufferedImage.createGraphics()
    graphics.drawImage(scaledImage, 0, 0, null)
    graphics.dispose()

    val stringBuilder = StringBuilder()
    for (y in 0 until height step 2) {
        for (x in 0 until WIDTH) {
            val pixel = bufferedImage.getRGB(x, y)
            val r = (pixel shr 16) and 0xff
            val g = (pixel shr 8) and 0xff
            val b = pixel and 0xff

            val average = 0.2126 * r + 0.7152 * g + 0.0722 * b
            val index = (average * (CHARS.length - 1) / 255).toInt()
            stringBuilder.append(CHARS[index])
        }

        stringBuilder.append("\n")
    }

    return stringBuilder.toString()
}