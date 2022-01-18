## 16-bit Integer Set

The 16-bit Unsigned Short stores numbers from 0 to 65535.

	2^16 = 65536

Using the following symbols to represent the numbers:

- Let ___m___ be bit size, ___m___ = 16
- Let ___M___ be Set Space size, ___M___ = 65536

To search through the Set Space, vEB divides the space 
into equally sized clusters.

- Let ___s___ be the size of each cluster
- Let ___r___ be the number of clusters

These variables follow the relation:

	M = s * r

The search requires at most s + r - 1 attempts.

	T(s,r) = s + r - 1
	
	T(s) = s + (M * s^-1) - 1

Optimizing ___s___ and ___r___:

	dT/ds = 1 - (M * s^-2)

There is a minimum at:

	s^2 = M
	
	s = M^(1/2)

Therefore, the size of each cluster:

	s = 256

And, the number of clusters:

	r = M * s^-1
	
	r = 256
