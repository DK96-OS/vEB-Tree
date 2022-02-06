package com.github.dk96.ushorts

/** Tree Index Conversion Functions
 * Developed by DK96-OS : 2022 */
internal object IndexingFunctions {

	/** Split the lowest bits of x in half */
	fun decomposeX(
		x: UShort,
		wordSize: Short
	) : Pair<Int, Int> {
		if (wordSize <= 0) throw IllegalArgumentException()
		val xInt = x.toInt()   // Bit shift not supported by UShort
		val half = wordSize / 2
		val c = xInt.ushr(half)
		val upperBits = 32 - half
		val i = xInt.shl(upperBits).ushr(upperBits)
		return c to i
	}

	/** Split the lowest bits of x in half */
	fun decomposeX(
		x: Int,
		wordSize: Short
	) : Pair<Int, Int> {
		if (wordSize <= 0) throw IllegalArgumentException()
		val half = wordSize / 2
		val c = x.ushr(half)
		val upperBits = 32 - half
		val i = x.shl(upperBits).ushr(upperBits)
		return c to i
	}

	/** Recombine the index of a tree, and a position
	 * @param wordSize The word size of the sub tree
	 */
	fun recomposeX(
		c: Int,
		i: Int,
		wordSize: Short
	) : Int {
		if (c < 0) throw IllegalArgumentException()
		if (i < 0) throw IllegalArgumentException()
		if (wordSize <= 0) throw IllegalArgumentException()
		var x = c.shl(wordSize.toInt())
		x += i
		return x
	}

}