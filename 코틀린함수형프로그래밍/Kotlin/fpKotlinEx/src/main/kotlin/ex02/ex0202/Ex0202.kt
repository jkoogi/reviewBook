package ex02.ex0202

/*
 * 연습문제 2.2 : isSorted 구현
 *  - List 타입의 단일 연결 리스트를 받아
 *  - 이 리스트가 주어진 비교 함수에 맞춰 적절히 정렬돼 있는지 검사
 *  - 이 함수의 앞에 두 가지 확장프로퍼티[extension property] 정의
 *     > head 프로퍼티 : 리스트의 첫 번째 원소 반환
 *     > tail 프로퍼티 : List에서 첫 번째 원소를 제외한 나머지 리스트 반환
 * */
val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean  {
    if(aa.size <= 1) return true

    fun loop(h:A, t:List<A>): Boolean =
        when{
            t.isEmpty() -> true
            !order(h,t.head) -> false
            else -> loop(t.head, t.tail)
        }

    return aa.isEmpty() || loop(aa.head, aa.tail)
}

// boo
fun <A> isSorted2(aa: List<A>, order: (A, A) -> Boolean): Boolean  {
    if(aa.size <= 1) return true

    fun loop(aa:List<A>): Boolean  {
        val head = aa.head
        val tail = aa.tail
        return if(aa.size == 2) {
            order(head, tail.head)
        } else {
            order(head, tail.head) && loop(tail)
        }
    }

    return loop(aa)
}

fun main() {
    val lamInt = { a: Int, b: Int -> a <= b }
    val lamTxt = { a: String, b: String -> a <= b }

    val testEmpty = listOf("")
    println("test : "+testEmpty+" sorted is "+isSorted(testEmpty , lamTxt))

    val testIntTrue = listOf(1,2,3)
    println("test : "+testIntTrue+" sorted is "+isSorted(testIntTrue , lamInt))

    val testIntFalse = listOf(1,2,3,1)
    println("test : "+testIntFalse+" sorted is "+isSorted(testIntFalse , lamInt))

    val testTxtTrue = listOf("a", "b", "n")
    println("test : "+testTxtTrue+" sorted is "+isSorted(testTxtTrue , lamTxt))

    val testTxtFalse = listOf("a", "z", "n")
    println("test : "+testTxtFalse+" sorted is "+isSorted(testTxtFalse , lamTxt))
}

