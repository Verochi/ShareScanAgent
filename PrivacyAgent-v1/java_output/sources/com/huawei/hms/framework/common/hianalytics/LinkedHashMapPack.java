package com.huawei.hms.framework.common.hianalytics;

/* loaded from: classes22.dex */
public class LinkedHashMapPack {
    private java.util.LinkedHashMap<java.lang.String, java.lang.String> map = new java.util.LinkedHashMap<>();

    public java.util.LinkedHashMap<java.lang.String, java.lang.String> getAll() {
        return this.map;
    }

    public com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack put(java.lang.String str, long j) {
        if (str != null) {
            this.map.put(str, "" + j);
        }
        return this;
    }

    public com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack put(java.lang.String str, java.lang.String str2) {
        if (str != null && str2 != null) {
            this.map.put(str, str2);
        }
        return this;
    }

    public com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack put(java.lang.String str, boolean z) {
        if (str != null) {
            if (z) {
                this.map.put(str, "1");
            } else {
                this.map.put(str, "0");
            }
        }
        return this;
    }

    public com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack putIfNotDefault(java.lang.String str, long j, long j2) {
        return j == j2 ? this : put(str, j);
    }
}
