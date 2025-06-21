package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public enum ObjectPermission {
    Private(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default("default"),
    Unknown("");

    private java.lang.String permissionString;

    ObjectPermission(java.lang.String str) {
        this.permissionString = str;
    }

    public static com.alibaba.sdk.android.oss.model.ObjectPermission parsePermission(java.lang.String str) {
        com.alibaba.sdk.android.oss.model.ObjectPermission[] objectPermissionArr = {Private, PublicRead, PublicReadWrite, Default};
        for (int i = 0; i < 4; i++) {
            com.alibaba.sdk.android.oss.model.ObjectPermission objectPermission = objectPermissionArr[i];
            if (objectPermission.permissionString.equals(str)) {
                return objectPermission;
            }
        }
        return Unknown;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.permissionString;
    }
}
