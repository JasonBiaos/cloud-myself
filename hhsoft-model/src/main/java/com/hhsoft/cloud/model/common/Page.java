package com.hhsoft.cloud.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Page
 * @Description 封装分页对象
 * @Author Jason Biao
 * @Date 2019/4/25 14:31
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -275582248840137389L;

    /**
     * 总条数
     */
    private int total;

    /**
     * 数据集合
     */
    private List<T> data;
}
