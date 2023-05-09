// 캐시 제목과 캐시할 파일 선언
// const sCacheName = 'hello-pwa'; // 캐시 제목 선언
// const aFilesToCache = [         // 캐시할 파일 선언
//     './', './index.html', './manifest.json', './images/hello-pwa.png'
// ];
// 미션코딩 - 캐시변경하고 서비스워커 다시 등록하기
const sCacheName = 'hello-pwa-v1'; // 캐시 제목 변경 *
const aFilesToCache = [         // 캐시할 파일 선언
    './', './index.html', './manifest.json', './images/hello-pwa.png',
    './images/icons/favicon.ico',               //파비콘 이미지 캐시 추가 *
    './images/icons/android-chrome-192x192.png' //아이콘 이미지 캐시 추가 *
];

// 서비스 워커 설치하고 캐시파일 저장
self.addEventListener('install', pEvent => {
    console.log("서비스 워커 설치함!");
    pEvent.waitUntil(
        caches.open(sCacheName)
        .then(pCache => {
            console.log("파일을 캐시에 저장함!");
            return pCache.addAll(aFilesToCache);
        })
    );
});

//고유 번호를 할당받은 서비스 워커 작동
self.addEventListener('activate', pEvent => {
    console.log("서비스워커 동작 시작됨!");
});

// 데이터 요청을 받으면 네트워크 또는 캐시에서 찾아 반환
self.addEventListener('fetch', pEvent => {
    pEvent.respondWith(
        caches.match(pEvent.request)
        .then(response => {
            if(!response){
                console.log("네트워크에서 데이터 요청!", pEvent.request);
                return fetch(pEvent.request);
            }
            console.log("캐시에서 데이터 요청!", pEvent.request);
            return response;
        }).catch(err => console.log(err))
    );
});