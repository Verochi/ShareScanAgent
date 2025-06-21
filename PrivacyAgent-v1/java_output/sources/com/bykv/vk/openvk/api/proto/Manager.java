package com.bykv.vk.openvk.api.proto;

/* loaded from: classes.dex */
public interface Manager {
    com.bykv.vk.openvk.api.proto.Loader createLoader(android.content.Context context);

    com.bykv.vk.openvk.api.proto.Bridge getBridge(int i);

    com.bykv.vk.openvk.api.proto.ValueSet values();
}
