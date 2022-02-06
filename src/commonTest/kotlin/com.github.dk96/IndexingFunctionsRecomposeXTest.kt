package com.github.dk96

import com.github.dk96.ushorts.IndexingFunctions.recomposeX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class IndexingFunctionsRecomposeXTest {

	@Test
	fun testRecomposeIntX16() {
		for (i in 0 until 256)
			for (c in 0 until 256)
				assertEquals(
					i + c * 256,
					recomposeX(c, i, 8)
				)
	}

	@Test
	fun testRecomposeIntX8() {
		for (i in 0 until 16)
			for (c in 0 until 16)
				assertEquals(
					i + c * 16,
					recomposeX(c, i, 4)
				)
	}

	@Test
	fun testRecomposeIntIllegalArgs() {
		assertFailsWith<IllegalArgumentException> {
			recomposeX(-1, 10, 8)
		}
		assertFailsWith<IllegalArgumentException> {
			recomposeX(0, -10, 8)
		}
		assertFailsWith<IllegalArgumentException> {
			recomposeX(0, 10, -1)
		}
	}

}