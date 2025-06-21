package com.bykv.vk.openvk.api.proto;

/* loaded from: classes.dex */
public interface Initializer {
    com.bykv.vk.openvk.api.proto.Manager getManager();

    void init(android.content.Context context, com.bykv.vk.openvk.api.proto.ValueSet valueSet);

    boolean isInitSuccess();
}
