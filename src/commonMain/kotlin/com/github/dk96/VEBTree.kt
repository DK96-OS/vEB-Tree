package com.github.dk96

interface VEBTree<IntType : Comparable<IntType>> {

    /** The smallest value present in the Tree */
    val min: IntType?

    /** The greatest value present in the Tree */
    val max: IntType?

    /** Insert this value into the Tree if not present */
    fun insert(value: IntType)

    /** Delete this value from the Tree if present */
    fun delete(value: IntType)

    /** Obtain the child tree at the given index */
    fun getChildAt(index: Int): VEBTree<IntType>?

    fun lookup(value: IntType)
        : Boolean = VEBOperations.lookup(this, value)

    fun findNext(value: IntType)
        : IntType? = VEBOperations.findNext(this, value)

    fun findPrev(value: IntType)
        : IntType? = VEBOperations.findPrev(this, value)

}