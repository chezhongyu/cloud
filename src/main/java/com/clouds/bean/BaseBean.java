package com.clouds.bean;

import com.clouds.util.Page;

/**
 * create by foreknow on 2021/1/27
 */
public class BaseBean {
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public BaseBean(){
        this.page = new Page();
    }
}
