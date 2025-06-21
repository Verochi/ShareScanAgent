package com.huawei.hms.ui;

/* loaded from: classes22.dex */
public class SafeBundle {
    public final android.os.Bundle a;

    public SafeBundle() {
        this(new android.os.Bundle());
    }

    public SafeBundle(android.os.Bundle bundle) {
        this.a = bundle == null ? new android.os.Bundle() : bundle;
    }

    public boolean containsKey(java.lang.String str) {
        try {
            return this.a.containsKey(str);
        } catch (java.lang.Exception unused) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public java.lang.Object get(java.lang.String str) {
        try {
            return this.a.get(str);
        } catch (java.lang.Exception e) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "get exception: " + e.getMessage(), true);
            return null;
        }
    }

    public android.os.Bundle getBundle() {
        return this.a;
    }

    public int getInt(java.lang.String str) {
        return getInt(str, 0);
    }

    public int getInt(java.lang.String str, int i) {
        try {
            return this.a.getInt(str, i);
        } catch (java.lang.Exception e) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "getInt exception: " + e.getMessage(), true);
            return i;
        }
    }

    public java.lang.String getString(java.lang.String str) {
        try {
            return this.a.getString(str);
        } catch (java.lang.Exception e) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return "";
        }
    }

    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (java.lang.Exception e) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return str2;
        }
    }

    public boolean isEmpty() {
        try {
            return this.a.isEmpty();
        } catch (java.lang.Exception unused) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.a.size();
        } catch (java.lang.Exception unused) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "size exception");
            return 0;
        }
    }

    public java.lang.String toString() {
        return this.a.toString();
    }
}
