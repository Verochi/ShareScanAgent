package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class ProtocolNegotiate {
    private static final int MAX_VERSION = 2;
    private static com.huawei.hms.api.ProtocolNegotiate instance = new com.huawei.hms.api.ProtocolNegotiate();
    private int version = 1;

    public static com.huawei.hms.api.ProtocolNegotiate getInstance() {
        return instance;
    }

    public int getVersion() {
        return this.version;
    }

    public int negotiate(java.util.List<java.lang.Integer> list) {
        if (list == null || list.isEmpty()) {
            this.version = 1;
            return 1;
        }
        if (list.contains(2)) {
            this.version = 2;
        } else {
            this.version = list.get(list.size() - 1).intValue();
        }
        return this.version;
    }
}
