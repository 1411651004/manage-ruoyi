package com.gzf.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gzf.manage.entry.SysBtnCol;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManageApplicationTests {


    @Test
    void contextLoads() {
        SysBtnCol sysBtnCol = new SysBtnCol();
        sysBtnCol.setBtnName("ceshiJSON");
        sysBtnCol.setId(1);
        String btnJson = JSON.toJSONString(sysBtnCol, SerializerFeature.WriteClassName);
        System.out.println("简单java类转json字符串:" + btnJson);
    }

}
