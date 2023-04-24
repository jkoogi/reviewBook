
    // js 파일에서 내보낸 식별자를 가져와 conHello, fnPlusNumbers 객체에 저장
    import {conHello, fnPlusNubers} from './04-1_library_named.js';
    console.log("conHello : ", conHello);
    console.log("fnPlusNubers : ", fnPlusNubers(1,2));

    // js 파일에서 내보닌 모든 식별자를 가져와 myLibrary 객체에 저장
    import * as myLibrary from './04-1_library_named.js';
    console.log("myLibrary.conHello : ", myLibrary.conHello);
    console.log("myLibrary.fnPlusNubers : ", myLibrary.fnPlusNubers(1,2));