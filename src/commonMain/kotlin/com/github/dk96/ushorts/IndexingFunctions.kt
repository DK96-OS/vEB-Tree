package com.github.dk96.ushorts

internal object IndexingFunctions {

	/** Split the lowest bits of x in half */
	fun decomposeX(x: UShort, wordSize: Int)
		: Pair<Int, Int> {
		if (wordSize <= 0) throw IllegalArgumentException()
		val xInt = x.toInt()   // Bit shift not supported by UShort
		val half = wordSize / 2
		val c = xInt.ushr(half)
		val upperBits = 32 - half
		val i = xInt.shl(upperBits).ushr(upperBits)
		return c to i
	}

	/** Split the lowest bits of x in half */
	fun decomposeX(x: Int, wordSize: Int)
		: Pair<Int, Int> {
		if (wordSize <= 0) throw IllegalArgumentException()
		val half = wordSize / 2
		val c = x.ushr(half)
		val upperBits = 32 - half
		val i = x.shl(upperBits).ushr(upperBits)
		return c to i
	}

}