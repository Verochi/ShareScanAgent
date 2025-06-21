package com.bykv.vk.openvk.api.proto;

/* loaded from: classes.dex */
public interface Result {
    int code();

    boolean isSuccess();

    java.lang.String message();

    com.bykv.vk.openvk.api.proto.ValueSet values();
}
