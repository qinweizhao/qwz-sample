package com.qinweizhao.util.problem.copy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author qinweizhao
 * @since 2022-02-21
 */
@SpringBootTest
class CopyMainTest {

    @Test
    void beanUtils(){
        CopyMain copyMain = new CopyMain();
        copyMain.beanUtils();
    }



    @Test
    void beanCopier(){
        CopyMain copyMain = new CopyMain();
        copyMain.beanCopier();
    }


    @Test
    void mapstruct(){
        CopyMain copyMain = new CopyMain();
        copyMain.mapstruct();
    }
}