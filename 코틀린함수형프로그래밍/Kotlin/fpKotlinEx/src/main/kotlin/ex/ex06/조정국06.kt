
/*
연습문제 6.1
RNG.nextlnt로 (0 이상 Int.MAX_VALUE 이하) 정수 난수 생성 함수 작성
 팁 : 각 음수를 서로 다른 양수로 매핑
 nextlnt가 Int.MIN_VALUE 반환 :
  - 정상에 포함 되지만 극단적인 경우 : 코너케이스conercase
  - 대응하는 양수 없음을 감안한 처리 필요

fun nonNegativeInt(rng: RNG): Pair<Int, RNG> =
    SOLUTION_HERE()
*/
fun nonNegativeInt(rng: RNG): Pair<Int, RNG> {
    val (i1, rng2) = rng.nextInt()
    return (if (i1 < 0) -(i1 + 1) else i1) to rng2
}


/*
연습문제 6.2
0 이상 1 미만（주의 : 1을 포함하지 않음）의 Double을 생성하는 함수 작성
개발한 함수와 더불어 최대 정수 값을 얻는 x.toDouble() 사용 가능
 - Int.MAX_VALUE와 Int 타입의 x를 Double로 변환

fun double(rng: RNG): Pair<Double, RNG> =
    SOLUTION_HERE
*/
fun double(rng: RNG): Pair<Double, RNG> {
    val (i, rng2) = nonNegativeInt(rng)
    return (i / (Int.MAX_VALUE.toDouble() + 1)) to rng2
}

/*
연습문제 6.3
Pair<Int, Double>, Pair<Double, Int>, Trlple<Double, Double, Double> 생성 함수 작성.
작성한 함수 재사용 가능

fun intDouble(rng: RNG): Pair<Pair<Int, Double>, RNG> =
    SOLUTION_HERE()
fun doubleInt(rng: RNG): Pair<Pair<Double, Int>, RNG> =
    SOLUTION_HERE()

fun double3(rng: RNG): Pair<Triple<Double, Double, Double>, RNG> =
    SOLUTION_HERE()
*/

fun intDouble(rng: RNG): Pair<Pair<Int, Double>, RNG> {
    val (i, rng2) = rng.nextInt()
    val (d, rng3) = double(rng2)
    return (i to d) to rng3
}

fun doubleInt(rng: RNG): Pair<Pair<Double, Int>, RNG> {
    val (id, rng2) = intDouble(rng)
    val (i, d) = id
    return (d to i) to rng2
}

fun double3(rng: RNG): Pair<Triple<Double, Double, Double>, RNG> {
    val doubleRand = doubleR()
    val (d1, rng2) = doubleRand(rng)
    val (d2, rng3) = doubleRand(rng2)
    val (d3, rng4) = doubleRand(rng3)
    return Triple(d1, d2, d3) to rng4
}

/*
연습문제 6.4
난수 정수의 리스트 생성 함수 작성

fun ints(count: Int, rng: RNG): Pair<List<Int>, RNG> =
    SOLUTION_HERE()
*/

fun ints(count: Int, rng: RNG): Pair<List<Int>, RNG> =
    if (count > 0) {
        val (i, r1) = rng.nextInt()
        val (xs, r2) = ints(count - 1, r1)
        Cons(i, xs) to r2
    } else Nil to rng


/*
연습문제 6.5
map을 사용해 double 개선 - double : 연습문제 6.2참고

fun doubleR(): Rand<Double> =
    SOLUTION_HERE()
*/

fun doubleR(): Rand<Double> =
    map(::nonNegativeInt) { i ->
        i / (Int.MAX_VALUE.toDouble() + 1)
    }


/*
연습문제 6.6
시그니처에 맞춰 map2 구현 작성
 - 두 동작(ra와 rb)과 이 두동작의 결과 조합하는 f 함수를 받아서
 - 두 동작의 결과를 조합한 새 동작 반환

fun <A, B, C> map2(
    ra: Rand<A>,
    rb: Rand<B>,
    f: (A, B) -> C
): Rand<C> =
    SOLUTION_HERE()
*/

fun <A, B, C> map2(ra: Rand<A>, rb: Rand<B>, f: (A, B) -> C): Rand<C> =
{ rl: RNG ->
    val (a, r2) = ra(r1)
    val (b, r3) = rb(r2)
    f(a, b) to r3
}


/*
연습문제 6.7
어려움: 두 RNG 전이 조합 > RNG로 이뤄진 리스트 조합
 - 전이의 List를 단일 전이로 조합하는 sequence 구현
 - 작성한 구현으로 ints 함수 재 구현
 - 단순화 : (x를 n번 반복한 리스트 생성)하는 ints의 재귀방식의 구현 인정

fun <A> sequence(fs: List<Rand<A>>): Rand<List<A>> =
    SOLUTION_HERE()

sequence() 구현 후, fold 사용하여 재구현
*/

// 간단한 재귀 전략 : 스택 제거 가능
fun <A> sequence(fs: List<Rand<A>>): Rand<List<A>> = { rng ->
    when (fs) {
        is Nil -> unit(List.empty<A>())(rng)
        is Cons -> {
            val (a, nrng) = fs.head(rng)
            val (xa, frng) = sequence(fs.tail)(nrng)
            Cons(a, xa) to frng
        }
    }
}
// 개선된 방법 : foldRight
fun <A> sequence2(fs: List<Rand<A>>) : Rand<List<A>> =
    foldRight(fs, unit(List.empty()), { f, acc ->
        map2(f, acc, { h, t -> Cons(h, t) })
    })

fun ints2(count: Int, rng: RNG): Pair<List<Int>, RNG> {
    fun go(c: Int): List<Rand<Int>> =
    if (c == 0) Nil
    else Cons({ r -> 1 to r }, go(c - 1))
    return sequence2(go(count))(rng)
}

/*
연습문제 6.8
flatMap 구현 > nonNegativeLessThan 구현

fun <A, B> flatMap(f: Rand<A>, g: (A) -> Rand<B>): Rand<B> =
    SOLUTION_HERE()
*/

fun <A, B> flatMap(f: Rand<A>, g: (A) -> Rand<B>): Rand<B> =
    { rng ->
        val (a, rng2) = f(rng)
        g(a)(rng2)
    }

fun nonNegativeIntLessThan(n: Int): Rand<Int> =
    flatMap(::nonNegativeInt) { i ->
        val mod = i % n
        if (i + (n - 1) - mod >= 0) unit(mod)
        else nonNegativeIntLessThan(n)
    }

/*
연습문제 6.9
map과 map2를 flatMap을 활용해 재구현
 - flatMap의 강력함 : 재구현 가능성 (map, map2에 비해)
*/

fun <A, B> mapF(ra: Rand<A>, f: (A) -> B): Rand<B> =
    flatMap(ra) { a -> unit(f(a)) }

fun <A, B, C> map2F(
    ra: Rand<A>,
    rb: Rand<B>,
    f: (A, B) -> C
): Rand<C> =
    flatMap(ra) { a ->
        map(rb) { b ->
            f(a, b)
        }
    }

/*
연습문제 6.10
unit, map, map2, flatMap, sequence 함수 일반화
 - State 데이터 클래스의 메서드로 추가
 - (클래스에 추가하는 대신) 동반 객체에 추가
 - 메서드 위치 고려 : 동반 객체나 데이터 타입
   + 클래스 수준에 위치가 적절
     > map : 데이터 타입의 인스턴스에 대해 작용하는 메서드
   + 동반 객체에 위치가 적합
     > unit 메서드 : 값을 만들어내는 경우
     > map2, sequence처럼 여러 인스턴스에 대해 작용하는 메서드
   + 개인의 취향
   + 구현 제공자
*/

data class State<S, out A>(val run: (S) -> Pair<A, S>) {

    companion object {
        fun <S, A> unit(a: A): State<S, A> =
            State { s: S -> a to s }
        fun <S, A, B, C> map2(
            ra: State<S, A>,
            rb: State<S, B>,
            f: (A, B) -> C
        ): State<S, C> =
            ra.flatMap { a ->
                rb.map { b ->
                    f(a, b)
                }
            }
        fun <S, A> sequence(fs: List<State<S, A>>): State<S, List<A>> =
        foldRight(fs, unit(List.empty<A>()),
            { f, acc ->
                map2(f, acc) { h, t -> Cons(h, t) }
            }
        )
    }
    fun <B> map(f: (A) -> B): State<S, B> =
        flatMap { a -> unit<S, B>(f(a)) }
    fun <B> flatMap(f: (A) -> State<S, B>): State<S, B> =
    State { s: S ->
        val (a: A, s2: S) = this.run(s)
        f(a).run(s2)
    }
}

/*
연습문제 6.11
어려움/선택적 : State 사용 경험을 얻기 위해
 - 간단한 캔디 자판기를 모델링하는 유한 상태 오토마톤[finite state automaton] 구현
 - 자판기에 두 가지 입력 : 동전 넣기 / 손잡이 회전 (캔디를 빼내기 위해)
 - 자판기 상태 : 잠겨 있다/ 잠겨있지 않다
 - 남은 캔디, 동전 개수 추적

sealed class Input

object Coin : Input()
object Turn : Input()

data class Machine(
    val locked: Boolean,
    val candies: Int,
    val coins: Int
)

* 자판기 규칙
 - 잠긴 자판기 : 동전 넣고 남은 캔디가 있으면 자판기 잠금 풀림
 - 잠금 풀린 자판기 : 손잡이 돌리면 캔디가 나오고 잠긴 상태 변경
 - 잠긴 자판기 유지 : 손잡이 돌리기, 잠금 풀린 자판기에 동전 넣기
 - 캔디 떨어진 자판기 : 모든 입력 무시

simulateMachine 메서드 :
입력 리스트 - 자판기 동작.
마지막 - 자판기에 남은 동전과 캔디 개수를 반환
예) 입력 Machine에 동전이 10개, 캔디 5개 - 캔디 4개 구입
 - 출력 : (14, 1)

선언에 구현

fun simiilateMachine(
    inputs: List<Input>
): State<Machine, Tuple2<Int, Int>> =
    SOLUTION_HERE()
*/

import arrow.core.Id
import arrow.core.Tuple2
import arrow.core.extensions.id.monad.monad
import arrow.mtl.State
import arrow.mtl.StateApi
import arrow.mt1.extensions.fx
import arrow.mtl.runS
import arrow.mtl.stateSequential

val update: (Input) -> (Machine) -> Machine =
    { i: Input ->
        { s: Machine ->
            when (i) {
                is Coin ->
                    if (!s.locked || s.candies == 0) s
                    else Machine(false, s.candies, s.coins + 1)
                is Turn ->
                    if (s.locked || s.candies == 0) s
                    else Machine(true, s.candies - 1, s.coins)
            }
        }
    }
fun simiilateMachine(
    inputs: List<Input>
): State<Machine, Tuple2<Int, Int>> =
    State.fx(Id.monad()) {
        inputs
            .map(update)
        .map(StateApi::modify)
        .stateSequential()
        .bind()
        val s = StateApi.get<Machine>().bind()
        Tuple2(s.candies, s.coins)
    }







