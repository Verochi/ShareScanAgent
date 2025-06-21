package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static com.huawei.hms.core.aidl.MessageCodec find(int i) {
        return i == 2 ? new com.huawei.hms.core.aidl.a() : new com.huawei.hms.core.aidl.MessageCodec();
    }
}
