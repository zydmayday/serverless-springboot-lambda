package com.zydmayday.demo.common;

import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@SuperBuilder
public abstract class CommonUtils {
    public static final String getName() {
        return "zydmayday";
    }
}
