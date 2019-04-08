package com.xupt.highconcurrency.publist;

import com.xupt.highconcurrency.annoations.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NoThreadSafe
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        String[] states = unsafePublish.getStates();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "c";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
