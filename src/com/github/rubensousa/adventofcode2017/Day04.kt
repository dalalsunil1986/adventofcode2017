package com.github.rubensousa.adventofcode2017


import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.*
import kotlin.collections.HashSet

object Day04 {

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val bufferedReader = BufferedReader(FileReader("inputday04.txt"))
        var line: String? = bufferedReader.readLine()
        val passphrases = HashSet<String>()
        while (line != null) {
            passphrases.add(line)
            line = bufferedReader.readLine()
        }
        println(countValid(passphrases))
        println(countValidAnagrams(passphrases))
    }

    private fun countValid(passphrases: HashSet<String>): Int {
        var validPassphrases = 0
        val wordsSet = HashSet<String>()
        for (passphrase in passphrases) {
            val words = passphrase.split(" ".toRegex())
            var valid = true
            for (word in words) {
                if (wordsSet.contains(word)) {
                    valid = false
                    break
                } else {
                    wordsSet.add(word)
                }
            }
            if (valid) {
                validPassphrases++
            }
            wordsSet.clear()
        }
        return validPassphrases
    }

    private fun countValidAnagrams(passphrases: HashSet<String>): Int {
        var validPassphrases = 0
        val wordsSet = HashSet<String>()
        for (passphrase in passphrases) {
            val words = passphrase.split(" ".toRegex())
            var valid = true
            for (word in words) {
                val chars = word.toCharArray()
                Arrays.sort(chars)
                if (!wordsSet.add(String(chars))) {
                    valid = false
                    break
                }
            }
            if (valid) {
                validPassphrases++
            }
            wordsSet.clear()
        }
        return validPassphrases
    }
}