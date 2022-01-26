package com.github.dk96

import com.github.dk96.ushorts.IndexingFunctions.decomposeX
import kotlin.test.Test
import kotlin.test.assertEquals

class IndexingFunctionTest {

	@Test
	fun testDecomposeUShortX16() {
		for (x in 0 until 256) {
			val (c, i) = decomposeX(x.toUShort(), 16)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 256 until 512) {
			val (c, i) = decomposeX(x.toUShort(), 16)
			assertEquals(x - 256, i)
			assertEquals(1, c)
		}
		for (x in 512 until 768) {
			val (c, i) = decomposeX(x.toUShort(), 16)
			assertEquals(x - 512, i)
			assertEquals(2, c)
		}
	}

	@Test
	fun testDecomposeUShortX8() {
		for (x in 0 until 16) {
			val (c, i) = decomposeX(x.toUShort(), 8)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 16 until 32) {
			val (c, i) = decomposeX(x.toUShort(), 8)
			assertEquals(x - 16, i)
			assertEquals(1, c)
		}
		for (x in 32 until 48) {
			val (c, i) = decomposeX(x.toUShort(), 8)
			assertEquals(x - 32, i)
			assertEquals(2, c)
		}
	}

	@Test
	fun testDecomposeUShortX4() {
		for (x in 0 until 4) {
			val (c, i) = decomposeX(x.toUShort(), 4)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 4 until 8) {
			val (c, i) = decomposeX(x.toUShort(), 4)
			assertEquals(x - 4, i)
			assertEquals(1, c)
		}
		for (x in 8 until 12) {
			val (c, i) = decomposeX(x.toUShort(), 4)
			assertEquals(x - 8, i)
			assertEquals(2, c)
		}
	}

	@Test
	fun testDecomposeUShortX2() {
		for (x in 0 until 2) {
			val (c, i) = decomposeX(x.toUShort(), 2)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 2 until 4) {
			val (c, i) = decomposeX(x.toUShort(), 2)
			assertEquals(x - 2, i)
			assertEquals(1, c)
		}
	}

	@Test
	fun testDecomposeIntX16() {
		for (x in 0 until 256) {
			val (c, i) = decomposeX(x, 16)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 256 until 512) {
			val (c, i) = decomposeX(x, 16)
			assertEquals(x - 256, i)
			assertEquals(1, c)
		}
	}

	@Test
	fun testDecomposeIntX8() {
		for (x in 0 until 16) {
			val (c, i) = decomposeX(x, 8)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 16 until 32) {
			val (c, i) = decomposeX(x, 8)
			assertEquals(x - 16, i)
			assertEquals(1, c)
		}
	}

	@Test
	fun testDecomposeIntX4() {
		for (x in 0 until 4) {
			val (c, i) = decomposeX(x, 4)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 4 until 8) {
			val (c, i) = decomposeX(x, 4)
			assertEquals(x - 4, i)
			assertEquals(1, c)
		}
	}

	@Test
	fun testDecomposeIntX2() {
		for (x in 0 until 2) {
			val (c, i) = decomposeX(x, 2)
			assertEquals(x, i)
			assertEquals(0, c)
		}
		for (x in 2 until 4) {
			val (c, i) = decomposeX(x, 2)
			assertEquals(x - 2, i)
			assertEquals(1, c)
		}
	}

}