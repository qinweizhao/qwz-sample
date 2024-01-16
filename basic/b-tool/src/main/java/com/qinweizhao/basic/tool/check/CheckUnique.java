package com.qinweizhao.basic.tool.check;

import org.apache.commons.lang3.ObjectUtils;

public class CheckUnique {


    private void checkUnique(String id, String dbId, String msg) {
        if (ObjectUtils.isEmpty(id)) {
            // 新增
            if (ObjectUtils.isNotEmpty(dbId)) {
                throw new RuntimeException(msg);
            }
        } else {
            // 修改
            if (ObjectUtils.isNotEmpty(dbId) && !dbId.equals(id)) {
                throw new RuntimeException(msg);
            }
        }
    }

}
