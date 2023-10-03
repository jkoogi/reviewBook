package ex02.ex0205

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
    println("--curry")
    println(curry { a: Double, b: Int -> "String - $a$b" }(11.23)(2))

    println("--uncurry")
    println(uncurry{ a: Int -> { b: Double -> "String - $a$b" } }(1, 22.34))

    println("--compose")
    println( compose( {b: Int -> "String - $b" }, { a: Double -> a.toInt() + 1})(12.23))
//    ex2n3()
//    ex2n4()
//    ex2n5()
//    println("2.3: "+ curry(fun (a: Int, b: Int)= a+b)(1)(3))
//    println("2.3: "+ curry { a: Int, b: Int -> a + b }(1)(3))
//
//    println("2.4: "+ uncurry(fun (a: Int)= fun (b: Int)= a+b)(1, 4))
//    println("2.4: "+ uncurry { a: Int-> { b: Int-> a+b } }(1, 4))
//
//    println("2.5: "+ compose(fun (b: Int)= b+1, fun (a: Int)= a+1)(2))
//    println("2.5: "+ compose({ b: Int-> b+1 }) { a: Int-> a + 1 }(2))
//    println("curry({a, b -> a + b})(1)(2) = ${curry({ a: Int, b: Int -> a + b })(1)(2)}")
//    println("uncurry { a: Int-> { b: Int-> a+b } }(1, 2) = ${uncurry { a: Int -> { b: Int -> a + b } }(1, 2)}")
//    println("compose(fun (b: Int)= b+1, fun (a: Int)= a+1)(1) = ${compose(fun(b: Int) = b + 1, fun(a: Int) = a + 1)(1)}")
}

/*  연습문제 2.3
    다른 예제로 커링을 살펴보자.
    커링은 인자를 두 개 받는 함수 f를 받아서 첫 번째 인자를 f에 부분 적용한 새 함수를 돌려주는 함수다.

    fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = SOLUTION_HERE()
*/
fun ex2n3(){
    fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = { a -> { b -> f(a,b) } }

    val plusOne = curry { a:Int , b:Int -> a + b } (3)
    println("# 연습문제 2.3")
    println("  plusOne = curry { a:Int , b:Int -> a + b } (1)")
    println("  plusOne(3) = ${plusOne(3)}")
    println("# END")
}

/*  연습문제 2.4
    curry 변환의 역변환인 uncurry를 구현하라.
    ->가 오른쪽 결합이므로 (A) -> ((B) -> c)를 (A) -> (B) -> C라고 적을 수 있다.

    fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = SOLUTION_HERE()
*/
fun ex2n4(){
    fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = { a, b -> f(a)(b) }

    val plus = uncurry { a:Int -> { b:Int -> a+b } }
    println("# 연습문제 2.4")
    println("  plus = uncurry { a:Int -> { b:Int -> a+b } }")
    println("  plus(1, 3) = ${plus(2, 3)}")
    println("# END")
}

/*  연습문제 2.5
    두 함수를 합성하는 고차 함수를 작성하라.

    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = SOLUTION_HERE()
*/
fun ex2n5(){
    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = { a -> f(g(a)) }

    val squareBold = compose({b:String->"<b>$b</b>"}, {a:Int->(a * a).toString()})
    println("# 연습문제 2.5")
    println("  squareBold = ${squareBold(5)}")
    println("# END")
}