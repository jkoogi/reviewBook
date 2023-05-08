//외부와 공유할 conHello 상수 와 fnPlusNumbers 함수 선언
const conHello = '안녕하세요';
const fnPlusNubers = (pNum1, pNum2) => pNum1 + pNum2;

//외부 사용을 위해 내보내기
export {conHello, fnPlusNubers};
