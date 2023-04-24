// 외부와 공유할 함수 : 기본(default) 내보내기는 모듈 하나에 하나의 함수나 클래스 만 가능 (var, let, const 불가)
const fnPlusNubers = (pNum1, pNum2) => pNum1 + pNum2;

// 기본 모듈 내보내기
export default fnPlusNubers;