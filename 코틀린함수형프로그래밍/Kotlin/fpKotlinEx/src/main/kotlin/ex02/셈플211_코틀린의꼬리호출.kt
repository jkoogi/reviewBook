package ex02

// 코틀린의 꼬리 호출 예제 : n 번째 펙토리얼 구하기
fun factorial(i: Int): Int {
    tailrec fun go(n: Int, acc: Int): Int = // tailrec 변경자는 꼬리 호출을 제거하라고 컴파일러에 명령
        if (n <= 0) {		//
//                println(" - n : "+n+" / acc : "+acc)
            acc		//     2	1
        }
        else {		//
//                println(" + n : "+n+" / acc : "+acc +" > ["+(n - 1)+", "+(n * acc)+"]")
            // 이 함수의 마지막 재귀 호출이 꼬리 위치에 있다.
            go(n - 1, n * acc)
        }
    return go(i, 1)
}

fun main() {
    var facNum = 4
     println("> factorial["+facNum+"] : "+factorial(facNum))// 4*3*2*1
}