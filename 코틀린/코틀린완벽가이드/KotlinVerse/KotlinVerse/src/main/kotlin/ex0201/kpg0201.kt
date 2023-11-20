package ex0201

fun main() {
//    typeInference56()
//    valInit58()
//    valGraveAccent59()
//    valMutable60()
//    operatorAugmenledAssignment60()
//    operatorPrefixPostfix()
    operatorPrecedence()
}
fun typeInference56(){
    val a = readLine()!! .toInt()
    val b: Int = readLine()!! .toInt()
    println(a + b)
}

fun typeExpression57(){
    val n: Int = 100
    val text: String = "Hello!"

    /* Error： assigning String value to Int variable */
//    val n： Int = “Hello!"
}

fun valInit58(){
    val text: String
    text = "Hello!"
    println(text)

    val n:Int
    /* Error： variable n is not initialized */
//    println(n+1)
}

fun valIdentifier59(){
    /*
      Unexpected tokens (use ';' to separate expressions on the same line)
      예기치 않은 토큰(';'을 사용하여 동일한 행에 있는 식을 구분)
     */
//    val a$:String = "$는 식별자로 안돼"
}

fun valGraveAccent59(){
    val `fun` = 1
    val `name with spaces` = 2
    println(`fun`+`name with spaces`)
}

fun valMutable60(){
    var sum = 1
    println(sum)
    sum = sum + 2
    println(sum)
    sum = sum + 3
    println(sum)
}

fun operatorAugmenledAssignment60(){
    var result = 3
    result *= 10 // result = result * 10
    println(result)
    result += 6 // result = result + 6
    println(result)
}

fun operatorPrefixPostfix(){
    var a = 1
    println(a++) // a는 2, 1이 출력됨
    println(++a) // a는 3, 3이 출력됨
    println(--a) // a는 2, 2가 출력됨
    println(a--) // a는 1, 2가 출력됨
}

fun operatorPrecedence(){
//    a.foo().bar()                  // (a.foo()).bar()
//    a * b % c                      // (a * b) % c
//    (a = 1) or (b < 1) and (c > 1) // ((a == 1) or (b < 1)) and (c > 1)
}
