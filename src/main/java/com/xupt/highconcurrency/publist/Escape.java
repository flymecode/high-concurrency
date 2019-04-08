package com.xupt.highconcurrency.publist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }
    
    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }
}
