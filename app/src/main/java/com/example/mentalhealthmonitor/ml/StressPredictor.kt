package com.example.mentalhealthmonitor.ml

import android.content.Context
import org.tensorflow.lite.Interpreter
import java.nio.ByteBuffer
import java.nio.ByteOrder

class StressPredictor(context: Context) {

    private val interpreter: Interpreter

    init {
        val model = context.assets.open("stress_model.tflite").readBytes()
        val buffer = ByteBuffer.allocateDirect(model.size)
        buffer.order(ByteOrder.nativeOrder())
        buffer.put(model)
        interpreter = Interpreter(buffer)
    }

    fun predict(sleep: Float, heartRate: Float, activity: Float): String {
        val input = arrayOf(floatArrayOf(sleep, heartRate, activity))
        val output = Array(1) { FloatArray(3) }
        interpreter.run(input, output)
        val resultIndex = output[0].indices.maxBy { output[0][it] }
        return when (resultIndex) {
            0 -> "Low Stress"
            1 -> "Medium Stress"
            else -> "High Stress"
        }
    }
}
