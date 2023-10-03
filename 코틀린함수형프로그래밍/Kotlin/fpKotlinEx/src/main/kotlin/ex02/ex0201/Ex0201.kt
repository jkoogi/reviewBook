package ex02.ex0201


/**
 * 참고 : https://gift123.tistory.com/22
 */
class Ex0201 {

    /*
     * 연습문제 2.1 : n 번째 피보나치 수열 구하기
     * - 처음 두 피보나치 수는 0과 1.
     * - n번째 피보나치 수는 자신 바로 앞의 두 피보나치 수의 합 : f(n)->
     * - 피보나치 수열은 0, 1, 1, 2, 3, 5, 8, 13, 21 등.
     * - 함수 정의 : 지역적인 꼬리 재귀 함수를 사용
     * f(n)    0   1   2   3   4   5   6
     * 1 : 0 + 1 = 1
     * 2 :     1 + 1 = 2
     * 3 :         1 + 2 = 3
     * 4 :             2 + 3 = 5
     * 5 :                 3 + 5 = 8
     * 6 :                     5 + 8 = 13
     * */
    fun fib(i: Int): Int {
        tailrec fun go(n: Int, f: Int, s: Int): Int =
            if (n > 0) {
                var step = n-1
                var first = s
                var second = f+s
//                println(" + n : "+n+" / f : "+f +" / s : "+s +" > ["+first+", "+second+"]")
                go(step, first, second)
            } else {
//                println(" - n : "+n+" / f : "+f +" / s : "+s)
                s
            }
        return go(i, 0, 1)
    }
    fun fi2b(i: Int): Int = S0LUTI0N_HERE()
}

fun main() {
//    var fibNum = 6
//     println("> fib["+fibNum+"] : "+fib(fibNum)) // 1+2+3+5+8

    for (i in 0 until 10) {
        println("> fib["+i+"] : "+Ex0201().fib(i))
    }
}

