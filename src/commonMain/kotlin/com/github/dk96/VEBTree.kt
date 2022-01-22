package com.github.dk96

interface VEBTree<IntType : Comparable<IntType>> {

    /** The smallest value present in the Tree
     * This value is not stored anywhere else */
    val min: IntType?

    /** The greatest value present in the Tree */
    val max: IntType?

    /** Insert this value into the Tree if not present */
    fun insert(value: IntType)

    /** Delete this value from the Tree if present */
    fun delete(value: IntType)

    /** Determine whether this value is present */
    fun lookup(value: IntType)
        : Boolean

    /** Find the successor for this value
     * @return Successor or null if none */
    fun successor(value: IntType)
        : IntType?

    /** Find the predecessor for this value
     * @return Predecessor or null if none */
    fun predecessor(value: IntType)
        : IntType?

}