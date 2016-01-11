package com.wdxxl.tangpoetry.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "add")
public class TangPoetry {
    private List<Poetry> poetries;

    public List<Poetry> getPoetries() {
        return poetries;
    }

    public void setPoetries(List<Poetry> poetries) {
        this.poetries = poetries;
    }
}
