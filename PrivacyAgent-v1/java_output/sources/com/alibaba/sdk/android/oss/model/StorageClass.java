package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public enum StorageClass {
    Standard("Standard"),
    IA("IA"),
    Archive("Archive"),
    Unknown("Unknown");

    private java.lang.String storageClassString;

    StorageClass(java.lang.String str) {
        this.storageClassString = str;
    }

    public static com.alibaba.sdk.android.oss.model.StorageClass parse(java.lang.String str) {
        for (com.alibaba.sdk.android.oss.model.StorageClass storageClass : values()) {
            if (storageClass.toString().equals(str)) {
                return storageClass;
            }
        }
        throw new java.lang.IllegalArgumentException("Unable to parse " + str);
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.storageClassString;
    }
}
