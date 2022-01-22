package com.github.dk96

import com.github.dk96.ushorts.Tree16
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Tree16Test {

    private lateinit var mTree: Tree16

    @BeforeTest
    fun testSetup() {
        mTree = Tree16(UShort.MAX_VALUE.toInt() + 1)
    }

    @Test
    fun testInsertAndLookup() {
        mTree.insert(4u)
        mTree.insert(50u)
        assertEquals(true, mTree.lookup(4u))
        assertEquals(true, mTree.lookup(50u))
        assertEquals(false, mTree.lookup(51u))
        assertEquals(false, mTree.lookup(256u))
        assertEquals(false, mTree.lookup(259u))
    }

    @Test
    fun testSuccessor() {
        mTree.insert(5u)
        mTree.insert(10u)
        mTree.insert(20u)
        mTree.insert(256u)
        assertEquals(10, mTree.successor(5u)?.toInt())
        assertEquals(10, mTree.successor(6u)?.toInt())
        assertEquals(20, mTree.successor(10u)?.toInt())
        assertEquals(256, mTree.successor(20u)?.toInt())
        assertEquals(256, mTree.successor(255u)?.toInt())
        assertEquals(null, mTree.successor(256u))
    }

    @Test
    fun testPredecessor() {
        mTree.insert(5u)
        mTree.insert(10u)
        mTree.insert(20u)
        mTree.insert(256u)
        mTree.insert(290u)
        assertEquals(256u, mTree.predecessor(290u))
        assertEquals(256u, mTree.predecessor(280u))
        assertEquals(20u, mTree.predecessor(256u))
        assertEquals(20u, mTree.predecessor(255u))
        assertEquals(20u, mTree.predecessor(25u))
        assertEquals(10u, mTree.predecessor(20u))
        assertEquals(null, mTree.predecessor(5u))
    }

    @Test
    fun testDecomposeX() {
        for (x in 0 until 256) {
            val (c, i) = mTree.decomposeX(x.toUShort())
            assertEquals(x, i.toInt())
            assertEquals(0, c.toInt())
        }
        for (x in 256 until 512) {
            val (c, i) = mTree.decomposeX(x.toUShort())
            assertEquals(x - 256, i.toInt())
            assertEquals(1, c.toInt())
        }
        for (x in 512 until 768) {
            val (c, i) = mTree.decomposeX(x.toUShort())
            assertEquals(x - 512, i.toInt())
            assertEquals(2, c.toInt())
        }
    }

}