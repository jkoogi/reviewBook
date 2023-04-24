// js 파일에서 내보낸 식별자를 가져와 conHello, fnPlusNumbers 객체에 저장
import {conHello, fnPlusNumbers} from './library_named.js';
console.log(conHello, "이름으로 내보내기입니다.");
console.log("[fnPlusNubers] 1 + 2 = : ", fnPlusNumbers(1,2));

// js 파일에서 내보닌 모든 식별자를 가져와 myLibrary 객체에 저장 : * 
import * as myLibrary from './library_named.js';
console.log(myLibrary.conHello, "*을 사용한 이름으로 내보내기 입니다.");
console.log("[myLibrary.fnPlusNubers] 3 + 3 = : ", myLibrary.fnPlusNumbers(3,4));

// default export를 이용한 기본 내보내기
import fnMyfunction from './library_default.js';
console.log("안녕하세요! 기본으로 내보내기입니다.");
console.log("[fnMyFunction] 5 + 6 = ", fnMyfunction(5,6));
