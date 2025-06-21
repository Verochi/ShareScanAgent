package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public enum CannedAccessControlList {
    Private(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default("default");

    private java.lang.String ACLString;

    CannedAccessControlList(java.lang.String str) {
        this.ACLString = str;
    }

    public static com.alibaba.sdk.android.oss.model.CannedAccessControlList parseACL(java.lang.String str) {
        for (com.alibaba.sdk.android.oss.model.CannedAccessControlList cannedAccessControlList : values()) {
            if (cannedAccessControlList.toString().equals(str)) {
                return cannedAccessControlList;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.ACLString;
    }
}
