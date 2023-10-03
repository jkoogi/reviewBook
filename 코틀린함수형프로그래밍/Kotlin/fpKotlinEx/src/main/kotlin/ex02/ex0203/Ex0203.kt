package ex02.ex0203

//연습문제 2.3
fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = {
        a: A -> { b: B -> f(a, b) }
}
//연습문제 2.4
fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = {
        a: A, b: B -> f(a)(b)
}
//연습문제 2.5
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = {
        a: A -> f(g(a))
}

fun main(){
    println("curry.String[1,2] -> " + curry{ a: Long, b: Int -> "$a$b" }(1)(2))
    println("curry.int[1,2] -> " + curry(fun(a: Long, b: Int) = a+b)(1)(2))

    println("uncurry.String[1,2] -> " + uncurry{ a: Int -> { b: Long -> "$a$b" } }(1, 2))
    println("uncurry.int[1,2] -> " + uncurry(fun(a: Int) = fun (b: Long) = a+b) (1, 2))

    println("compose.String[3] -> " + compose( {b: Int -> "$b"+2 }, { a: Long -> a.toInt() * 100})(3))
    println("compose.int[3] -> " + compose(fun(b: Int)= b+2, fun(a: Long)=a.toInt() * 100)(3))
}
