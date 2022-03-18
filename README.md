# Math - Pi calculator - Chudnovsky Algorithm

My code / solution to calculate Pi using the Chudnovsky Algorithm in Java using the BigNumber and BigDecimal classes.

The Chudnovsky Algorithm is the algorithm programmers and computers use to calculate Pi to trillions of decimal places.

## Chudnovsky Algorithm

<pre>
        (6q!) x (q * 545140134 + 13591409)
F(q) = -------------------------------------------
        (3q!)  x (q!^3) x (-262537412640768000^q)

Pi = 426880 x SQRT (10005) / SUM (F(q))

i.e. Calculate F(0), F(1), F(2), etc and sum them up, and divide into 426880 x SQRT (10005).

Calculation using only F(0):
0. 3.141592653589734020		Pi is correct to 13 digits
                  ^^^^^

Calculation using SUM F(0), F(1), F(2), F(3) and F(4):
4.	3.141592653589793051		Pi is correct to 15 digits
                    ^^^
</pre>


## William Shanks method:

<pre>
Pi = 16 arctan (1/5) - 4 arctan (1/239)

arctan (1/x) = 1/x - 1/3x^3 + 1/5x^5 - 1/7x^7 + 1/9x^9 - .....
</pre>


## Useful Links:

* **Chudnovsky algorithm**, https://en.wikipedia.org/wiki/Chudnovsky_algorithm

* **Calculating p by hand: the Chudnovsky algorithm**, Stand-up Maths / Matt Parker, Mar 14, 2018, https://www.youtube.com/watch?v=LhlqCJjbEa0
https://www.youtube.com/watch?v=I7YvD7dqsy8
* Can we calculate 100 digits of p by hand? The William Shanks method, Stand-up Maths / Matt Parker, Mar 15, 2022, https://www.youtube.com/watch?v=dtiLxLrzjOQ

* Matt Parker calculates Pi playlist: https://www.youtube.com/watch?v=dtiLxLrzjOQ&list=PLhtC92GarkjyYbxI3-4qzIWIRbZaw4wuP


**Moose**
<br>Moose's Software Valley - Established July, 1996.
<br>https://moosevalley.github.io/
