package com.taotao.common.pojo;

import java.util.List;

/**
 * Created by 2P on 2018/3/24.
 */
public class EUGridResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
