package com.example.composecalculator.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _inputState = mutableStateOf("")
    val inputState: State<String>
        get() = _inputState

    private val _resultState = mutableStateOf("0")
    val resultState: State<String>
        get() = _resultState


    private var inputCalculateKey = ""

    private var num1 = 0f
    private var num2 = 0f

    private var calculateDone = false

    fun input(key: String) {
        if (calculateDone && key in calculateKeys) {//上次计算刚完成 此时点击
            _inputState.value = _resultState.value + key
            num1 = _resultState.value.toFloat()
            calculateDone = false
            inputCalculateKey = key
        } else {
            when (key) {
                "=" -> {
                    calculate()
                    calculateDone = true
                }
                "DEL" -> {
                    _inputState.value = _inputState.value.dropLast(1)
                }
                else -> {
                    val cache = _inputState.value

                    //如果尚未输入任何数字时 输入了运算符号
                    if (cache.isEmpty() && key in calculateKeys) {
                        return
                    }

                    if (key in calculateKeys) {
                        //已经输入过运算法 ，先计算结果
                        if (inputCalculateKey.isNotEmpty()) {
                            calculate()
                            _inputState.value = _resultState.value + key
                            num1 = _resultState.value.toFloat()
                        } else {
                            num1 = inputState.value.toFloat()
                            _inputState.value = cache + key
                        }
                        inputCalculateKey = key
                    } else {
                        _inputState.value = cache + key
                    }
                }
            }
        }
    }

    private fun calculate() {
        if(inputState.value.last() in inputCalculateKey){
            _resultState.value = num1.toString()
        }else {
            if (inputCalculateKey.isNotEmpty() && inputState.value.isNotEmpty()) {
                val cache = inputState.value
                num2 = cache.subSequence(
                    cache.indexOfLast { it.toString() == inputCalculateKey } + 1,
                    cache.length
                ).toString().toFloat()
                _resultState.value = when (inputCalculateKey) {
                    "+" -> {
                        num1 + num2
                    }
                    "-" -> {
                        num1 - num2
                    }
                    "*" -> {
                        num1 * num2
                    }
                    else -> {
                        num1 / num2
                    }
                }.toString()
                inputCalculateKey = ""
            }
        }
    }


    private val calculateKeys = listOf("+", "-", "*", "÷")
}