package com.github.dk96

import kotlin.math.log2
import kotlin.math.roundToInt
import kotlin.math.sqrt

abstract class VEBTree<IntType : Comparable<IntType>>(
    val size: Int
) {
    /** The Size of direct sub trees */
    val subSize: Int = when {
        size > 2 -> sqrt(size.toFloat()).roundToInt()
        size == 2 -> 1
        size == 1 -> 0
        else -> throw IllegalArgumentException()
    }

    /** The word size of this tree */
    val wordSize: Int = when {
        size > 2 -> log2(size.toFloat()).roundToInt()
        size == 2 -> 1
        else -> 0
    }

    /** The smallest value present in the Tree
     * This value is not stored anywhere else */
    abstract val min: IntType?

    /** The greatest value present in the Tree */
    abstract val max: IntType?

    protected var summary
        : ByteArray? = null

    /** Insert this value into the Tree if not present */
    abstract fun insert(value: IntType)

    /** Delete this value from the Tree if present */
    abstract fun delete(value: IntType)

    /** Determine whether this value is present */
    abstract fun lookup(value: IntType)
        : Boolean

    /** Find the successor for this value
     * @return Successor or null if none */
    abstract fun successor(value: IntType)
        : IntType?

    /** Find the predecessor for this value
     * @return Predecessor or null if none */
    abstract fun predecessor(value: IntType)
        : IntType?

}