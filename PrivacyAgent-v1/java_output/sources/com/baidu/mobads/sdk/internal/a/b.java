package com.baidu.mobads.sdk.internal.a;

/* loaded from: classes.dex */
public class b {
    public int a(java.lang.Object[] objArr, int i, int i2) {
        if (objArr != null && objArr.length > i) {
            java.lang.Object obj = objArr[i];
            if (obj instanceof java.lang.Integer) {
                return ((java.lang.Integer) obj).intValue();
            }
        }
        return i2;
    }

    public java.lang.Object a(java.lang.Object[] objArr, int i, java.lang.Object obj) {
        java.lang.Object obj2;
        return (objArr == null || objArr.length <= i || (obj2 = objArr[i]) == null) ? obj : obj2;
    }
}
