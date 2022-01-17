# vEB-Tree

An Implementation of the van Emde Boas Tree data structure (DS).

### Purpose

A solution for storing many integers, where the operation of finding the nearest selected integer is important.
Ideally, more than half of all possible integers will be stored.

### Structure

The DS is a tree of fixed height, and fixed node relationships.
The size of the tree depends on the size of integers that will be stored.

### Integer Sizes

The tree is designed to work with powers of 2, and thus compatible with common binary integer representations.
- 8 bit (Todo)
- 16 bit
- 32 bit (Todo)
- 64 bit (Todo)

### Abstraction

This repository utilizes Generic types to reduce code duplication.
Common operations are delegated to a static object where possible.

The VEBTree interface defines the essential methods that must be implemented by each tree.
These methods require internal or private data management, or are specific to the Integer size.

### Implementation

Each tree size is implemented by a unique class, with a specific integer type.
