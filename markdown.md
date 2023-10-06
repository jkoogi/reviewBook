# 마크다운 정리

- [줄바꿈](#줄바꿈)
- [주석](#주석)
- [글머리 : 1~6 레벨](#글머리--16-레벨)
- [인용](#인용)
- [순서목록](#순서목록)
- [항목목록](#항목목록)
- [인라인(Inline) 코드 블록](#인라인inline-코드-블록)
- [코드 블록](#코드-블록)
- [수평선](#수평선)
- [체크리스트 (Check List)](#체크리스트-check-list)
- [글자 서식](#글자-서식)
- [링크 생성](#링크-생성)
- [목차 생성](#목차-생성)
- [다른 파일 열기](#다른-파일-열기)
- [이미지 파일 불러오기](#이미지-파일-불러오기)
- [이미지에 링크 걸기](#이미지에-링크-걸기)
- [상대참조 방식으로 링크 처리](#상대참조-방식으로-링크-처리)
- [자동링크](#자동링크)
- [수식](#수식)
- [표 (Table)](#표-table)
- [토글 (Toggle)](#토글-toggle)
- [글자색 및 하이라이트 처리](#글자색-및-하이라이트-처리)
- [버튼(상단이동)](#버튼상단이동)

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 줄바꿈

```text
* 줄바꿈 : X

사과
포도

* 공백 하나 : X

사과 포도

* 공백 둘 : X

사과  포도

* 공백 둘, 줄바꿈 : O

사과  
포도

* 줄바꿈테그 : O

사과 <br> 포도

* 줄바꿈X2 : O

사과


포도

```

* 줄바꿈 : X <br>

사과
포도

* 공백 하나 : X <br>

사과 포도

* 공백 둘 : X <br>

사과  포도

* 공백 둘, 줄바꿈 : O <br>

사과  
포도

* 줄바꿈테그 : O <br>

사과 <br> 포도

* 줄바꿈X2 : O <br>

사과


포도


---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 주석

```text
<!-- 주석을 표시해봐 -->
안보이지?
```

<!-- 주석을 표시해봐 -->
안보이지?

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 글머리 : 1~6 레벨

```text
# 1. 큰제목 : 구분실선표시
## 1.1 소제목 : 구분실선표시
### 1.1.1 타이틀
#### * 항목
##### - 속성
###### > 참조
```

# 1. 큰제목 : 구분실선표시
## 1.1 소제목 : 구분실선표시
### 1.1.1 타이틀
#### * 항목
##### - 속성
###### > 참조

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 인용

```text
> first blockqute
>> second blockqute
>>> third blockqute
```
> first blockqute
>> second blockqute
>>> third blockqute

* 인용문 출처 : 안되나?
```text
<cite>Steve Jobs</cite> --- Apple Worldwide Developers' Conference, 1997 {: .small}
<small><cite>Steve Jobs</cite> --- Apple Worldwide Developers' Conference, 1997</small>
<small><i><cite>Steve Jobs</cite> --- Apple Worldwide Developers' Conference, 1997</i></small>  
```
<cite>Steve Jobs</cite> --- Apple Worldwide Developers' Conference, 1997 {: .small}  
<small><cite>Steve Jobs</cite> --- Apple Worldwide Developers' Conference, 1997</small>  
<small><i><cite>Steve Jobs</cite> --- Apple Worldwide Developers' Conference, 1997</i></small>  

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 순서목록

```text
1. first.
2. second..
3. third...

```
1. first.
2. second..
3. third...

* 혼용
```text
1. 순서가
2. 있는  
   1. 목록
      - 하나
      - 둘
   2. 목록
       - 하나
       - 둘
3. 목록   
```
1. 순서가
2. 있는  
   1. 목록
      - 하나
      - 둘
   2. 목록
       - 하나
       - 둘
3. 목록
   
---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 항목목록
 - 글머리 기호: *, +, - 지원
 - 공백 2칸으로 들여쓰기 한다.

```text
+ 빨강  
  * 주황
  - 노랑  
    + 초록
```
+ 빨강  
  * 주황
  - 노랑  
    + 초록
      
---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 인라인(Inline) 코드 블록

```text
su 명령어  
`$ sudo su`
```
su 명령어  
`$ sudo su`

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 코드 블록
 - 문법강조시 해당 키워드 설정 : java...
 - 기본값(생략) : text
```
  ```java
  public void main(){
      system.out.println("hello java");
  }
  \```
```
```java
public void main(){
    system.out.println("hello java");
}
```

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 수평선
 * [***,  - - -, ---] 동일한 수평선 표시됨
```text
* 별수평
***
* 선수평
---
* 동등수평
===
* 별공백수평
* * *
* 선공백수평
- - -
* 동등공백수평
```

* 별수평
***
* 선수평
---
* 별공백수평
* * *
* 선공백수평

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 체크리스트 (Check List)
 * 표기상태만 표시
```text
- [x] complete item
- [ ] incomplete item
```
- [x] complete item
- [ ] incomplete item

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 글자 서식

```text
* 이텔릭 : [*,_]  
*single asterisks 이텔릭체*  
_single underscores 이텔릭체_  

* 볼드 : [**,__]  
**double asterisks 볼드체**  
__double underscores 볼드체__  

* 이텔릭+볼드 : [***,___]  
***tripple underscores 볼드+이텔릭체***  
___tripple underscores 볼드+이텔릭체___  

* 취소 : [~~], 볼드취소 : [**~~], 밑줄 : <U>테그
~~cancelline 취소선~~  
**~~bold cancelline 볼드+취소선~~**  
<u>underline - 밑줄</u>
```
* 이텔릭 : [*,_]  
*single asterisks 이텔릭체*  
_single underscores 이텔릭체_  

* 볼드 : [**,__]  
**double asterisks 볼드체**  
__double underscores 볼드체__  

* 이텔릭+볼드 : [***,___]  
***tripple underscores 볼드+이텔릭체***  
___tripple underscores 볼드+이텔릭체___  

* 취소 : [~~], 볼드취소 : [**~~], 밑줄 : <U>테그  - 편집모드는 되는데, 프리뷰는 안되네?
~~cancelline 취소선~~  
**~~bold cancelline 볼드+취소선~~**  
<u>underline - 밑줄</u>

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 링크 생성
* [보여지는 글](링크 "설명")
```text
[표시텍스트](https://naver.com/ "네이버홈")  
[네이버](https://naver.com/)
```

[표시텍스트](https://naver.com/ "네이버홈")  
[네이버](https://naver.com/)

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 목차 생성
* [표시할 텍스트](#정리된글머리)
 - 정리 : 공백 > -, 대문자 > 소문자, 특수문자 삭제
* 페이지 소스로 목차 추출(한글안됨) : https://ecotrust-canada.github.io/markdown-toc/
```text
[1. 큰제목 : 구분실선표시](#1-큰제목--구분실선표시)  
[1.1 소제목 : 구분실선표시](#11-소제목-구분실선표시)  
[1.1.1 타이틀](#111-타이틀)  
[* 항목](#-항목)  
[ - 속성](#---속성)  
[ > 참조](#--참조)  
```

[1. 큰제목 : 구분실선표시](#1-큰제목--구분실선표시)  
[1.1 소제목 : 구분실선표시](#11-소제목--구분실선표시)  
[1.1.1 타이틀](#111-타이틀)  
[* 항목](#-항목)  
[ - 속성](#--속성)  
[ > 참조](#-참조)  

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 다른 파일 열기

```text
[리드미 파일](./README.md "리드미파일")
```
[리드미 파일](./README.md "리드미파일")

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 이미지 파일 불러오기
* ![대체 텍스트](경로, "설명")
```text
![하늘 사진](./image/sky.jpg "DSR")  
![이미지가 없어서 보이는 대체택스트](./image/img.png)  
```
![하늘 사진](./image/sky.jpg "DSR")  
![이미지가 없어서 보이는 대체택스트](./image/img.png)  

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 이미지에 링크 걸기
* [![대체 텍스트](이미지 경로, "설명")](URL 링크 "설명")
```text
[![하늘 사진](./image/sky.jpg "DSR")](https://zoosso.tistory.com/)
```
[![하늘 사진](./image/sky.jpg "DSR")](https://zoosso.tistory.com/)

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 상대참조 방식으로 링크 처리
* [보여지는 글자] [id]
* [id]: URL Link "optional comment"
```text
[검색][google]  
[포털][네이버]

[google]: https://google.com/ "구글"
[네이버]: https://naver.com/
```

[검색][google]  
[포털][네이버]

[google]: https://google.com/ "구글"
[네이버]: https://naver.com/

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 자동링크
* URL, e-Mail 주소는 자동링크 생성
* 링크취소 : 백틱(`)을 이용한 코드블록 처
```text
https://naver.com/
`https://naver.com/`
```
https://naver.com/  
`https://naver.com/`

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 수식
* 처음과 뒤에 $ (달러 기호)로 감싼다.
* $$ 두 개씩 사용하면 가운데 정렬된다.
* 특수기호 문자하고 싶은 경우 \ (백슬러시)
```text
$a^2 + b^2 = c^2$  
$x^2_1 + 2x_2 = 3$

$$(\alpha + \beta)^2 = \alpha^2 + 2\alpha\beta+\beta^2 $$
```
$a^2 + b^2 = c^2$  
$x^2_1 + 2x_2 = 3$

$$(\alpha + \beta)^2 = \alpha^2 + 2\alpha\beta+\beta^2 $$

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 표 (Table)
* 제목 행 구분을 위해 -(hyphen/dash) 3개 필요
    :(Colons) 기호로 셀(열/칸) 안에 내용을 정렬할 수 있다.
* 같은 행에서 셀(열/칸) 구분은 |(vertical bar) 사용
    가장 좌/우측은 |(vertical bar) 기호 생략 가능
```text
값 | 의미 | 기본값
---|:---:|---:
`static` | 유형(기준) 없음 / 배치 불가 | `static`
`relative` | 요소 **자신** 기준으로 배치 |
`absolute` | 위치 상 **_부모_(조상)요소** 기준으로 배치 |
`fixed` | **브라우저 창** 기준으로 배치 |


A (기본 왼쪽 정렬) | B (가운데 정렬) | C (오른쪽 정렬)
---|:---:|---:
`1` | 가나다라 | abc
`2` | 가나다라마 | abcd
`3` | 가나다라마바 | abcde
`4` | 가나다라마바사 | abcdef
```
값 | 의미 | 기본값
---|:---:|---:
`static` | 유형(기준) 없음 / 배치 불가 | `static`
`relative` | 요소 **자신** 기준으로 배치 |
`absolute` | 위치 상 **_부모_(조상)요소** 기준으로 배치 |
`fixed` | **브라우저 창** 기준으로 배치 |


A (기본 왼쪽 정렬) | B (가운데 정렬) | C (오른쪽 정렬)
---|:---:|---:
`1` | 가나다라 | abc
`2` | 가나다라마 | abcd
`3` | 가나다라마바 | abcde
`4` | 가나다라마바사 | abcdef

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 토글 (Toggle)

```text
<details open>
  <summary>열린 상태에서 시작</summary>
<pre>
내용 1
내용 2
내용 3
</pre>
</details>

<details>
  <summary>더보기</summary>
<pre>
내용 1
내용 2
내용 3
</pre>
</details>
```
<details open>
  <summary>열린 상태에서 시작</summary>
<pre>
내용 1
내용 2
내용 3
</pre>
</details>

<details>
  <summary>더보기</summary>
<pre>
내용 1
내용 2
내용 3
</pre>
</details>

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 글자색 및 하이라이트 처리

```text
<mark>형광펜</mark>  
<span style="color:red">빨간</span>  
<span style="color:blue">파란</span>  
<span style="color:green">초록</span>  
<span style="color:yellow">노란</span>  
<span style="color:purple">보라</span>
```
<mark>형광펜</mark>  
<span style="color:red">빨간</span>  
<span style="color:blue">파란</span>  
<span style="color:green">초록</span>  
<span style="color:yellow">노란</span>  
<span style="color:purple">보라</span>  

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 버튼(상단이동)
* 테그
```text
<p align="right">
<a href="#" class="btn--success">위로</a>
</p>
```
<p align="right"><a href="#" class="btn--success">위로</a></p>

* 목차 링크
```text
<p align="right">
[kotlin] <a href="https://kotlinlang.org/docs/reflection.html#jvm-dependency"> [:: - reflection] </a>
</p>
```
<p align="right">
[kotlin] <a href="https://kotlinlang.org/docs/reflection.html#jvm-dependency"> [:: - reflection] </a>
</p>

---
<p align="right"><a href="#" class="btn--success">위로</a></p>

# 마크다운 확장? 동작안함
https://kramdown.gettalong.org/syntax.html#inline-attribute-lists

```
Left aligned text.
{: .text-left}

Center aligned text.
{: .text-center}

Right aligned text.
{: .text-right}

Justified text.
{: .text-justify}

No wrap text.
{: .text-nowrap}

Lowercased text
{: .text-lowercase}

Uppercased text
{: .text-uppercase}

Capitalized text
{: .text-capitalize}

This *is*{:.underline} some `code`{:#id}{:.class}.
A [link](test.html){:rel='something'} and some **tools**{:.tools}.

{::comment}
This text is completely ignored by kramdown - a comment in the text.
{:/comment}

Do you see {::comment}this text{:/comment}?
{::comment}some other comment{:/}

{::options key="val" /}

```

This *is*{:.underline} some `code`{:#id}{:.class}.
A [link](test.html){:rel='something'} and some **tools**{:.tools}.

{::comment}
This text is completely ignored by kramdown - a comment in the text.
{:/comment}

Do you see {::comment}this text{:/comment}?
{::comment}some other comment{:/}

{::options key="val" /}

Left aligned text.
{: .text-left}

Center aligned text.
{: .text-center}

Right aligned text.
{: .text-right}

Justified text.
{: .text-justify}

No wrap text.
{: .text-nowrap}

Lowercased text
{: .text-lowercase}

Uppercased text
{: .text-uppercase}

Capitalized text
{: .text-capitalize}
