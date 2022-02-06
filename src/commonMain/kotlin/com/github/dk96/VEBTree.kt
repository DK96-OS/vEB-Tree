package com.github.dk96

import kotlin.math.log2
import kotlin.math.roundToInt
import kotlin.math.sqrt

/** A van Emde Boas Tree Data Structure
 * Developed by DK96-OS : 2022 */
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
    val wordSize: Short = when {
        size > 2 -> log2(size.toFloat()).roundToInt().toShort()
        size == 2 -> 1
        else -> 0
    }

    /** The smallest value present in the Tree
     * This value is not stored anywhere else */
    var min: IntType? = null
        protected set

    /** The greatest value present in the Tree */
    var max: IntType? = null
        protected set

    /** A summary array, enables searching for children */
    protected var mSummary
        : BooleanArray? = null

    /** Child Nodes / Sub trees */
    protected var mChildren
        : HashMap<Int, VEBTree<IntType>>? = null

    /** Insert this value into a subtree */
    protected abstract fun insertSubtree(
        value: IntType
    )

    /** Delete this value from the Tree if present */
    protected abstract fun deleteFromSubtree(
        value: IntType
    ) : Boolean

    /** Determine whether this value is present */
    protected abstract fun lookInSubtree(
        value: IntType
    ) : Boolean

    /** Search for the successor in a sub tree
     * @return Successor or null if none */
    protected abstract fun successorInSubtree(
        value: IntType
    ) : IntType?

    /** Search for the predecessor in a sub tree
     * @return Predecessor or null if none */
    protected abstract fun predecessorInSubtree(
        value: IntType
    ) : IntType?

    /** Insert this value into the Tree if not present */
    fun insert(value: IntType) {
        val min = min
        when {
            min == null -> {
                this.min = value
                this.max = value
            }
            min > value -> {
                this.min = value
                insert(min)
            }
            min == value -> {}
            else -> insertSubtree(value)
        }
    }

    /** Delete a value from this tree
     * @return True if this tree is now empty, can be deleted */
    fun delete(
        value: IntType
    ) : Boolean {
        val min = min
        when {
            min == null -> return true
            value == min -> {
                val successor = successor(value)
                if (successor != null) {
                    delete(successor)
                    this.min = successor
                } else {
                    this.min = null
                    return true
                }
            }
            else -> deleteFromSubtree(value)
        }
        return false
    }

    /** Determine whether this value is present */
    fun lookup(
        value: IntType
    ) : Boolean = when (min) {
        null -> false
        value -> true
        else -> lookInSubtree(value)
    }

}