package com.github.dk96

import com.github.dk96.ushorts.IndexingFunctions.decomposeX
import kotlin.test.Test
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

class IndexingFunctionPerformanceTest {

	/**
	 * Tests have shown that the two functions are equivalent
	 * when the return type is Pair<Int, Int>.
	 * However, if the return type is changed to
	 * Pair<UShort, UShort> the running time is multiplied
	 * by an approximate factor of 5
	 */

	@Test
	@ExperimentalTime
	fun testDecomposeIntX() {
		var n = 100_000
		var time = runInt(n)
		println("Int$n Time: $time")
		for (i in 0 until 5) {
			n += 100_000
			time = runInt(n)
			println("Int$n Time: $time")
		}
	}

	@Test
	@ExperimentalTime
	fun testDecomposeUShortX() {
		var n = 100_000
		var time = runUShort(n)
		println("USh$n Time: $time")
		for (i in 0 until 5) {
			n += 100_000
			time = runUShort(n)
			println("USh$n Time: $time")
		}
	}

	@ExperimentalTime
	private fun runUShort(n: Int)
		: Duration = measureTime {
			for (i in 0 until n)
				for (x in 256 until 512)
					decomposeX(x.toUShort(), 16)
		}

	@ExperimentalTime
	private fun runInt(n: Int)
		: Duration = measureTime {
			for (i in 0 until n)
				for (x in 256 until 512)
					decomposeX(x, 16)
		}

}