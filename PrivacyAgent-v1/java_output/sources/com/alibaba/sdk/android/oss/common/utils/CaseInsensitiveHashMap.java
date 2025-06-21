package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class CaseInsensitiveHashMap<k, v> extends java.util.HashMap<k, v> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public v get(java.lang.Object obj) {
        if (obj == null || containsKey(obj) || !(obj instanceof java.lang.String)) {
            return (v) super.get(obj);
        }
        java.lang.String lowerCase = ((java.lang.String) obj).toLowerCase();
        if (containsKey(lowerCase)) {
            return get(lowerCase);
        }
        return null;
    }
}
