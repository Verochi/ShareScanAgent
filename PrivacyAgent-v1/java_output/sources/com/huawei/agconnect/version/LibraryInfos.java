package com.huawei.agconnect.version;

/* loaded from: classes22.dex */
public class LibraryInfos {
    public static final com.huawei.agconnect.version.LibraryInfos b = new com.huawei.agconnect.version.LibraryInfos();
    public java.lang.String a = "Java";

    public static com.huawei.agconnect.version.LibraryInfos getInstance() {
        return b;
    }

    public java.lang.String getLibraryType() {
        return this.a;
    }

    public void registerLibraryType(java.lang.String str) {
        this.a = str;
    }
}
