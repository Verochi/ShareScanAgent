package com.vivo.push.model;

/* loaded from: classes19.dex */
public final class a {
    private java.lang.String a;
    private java.lang.String b;

    public a(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public final java.lang.String a() {
        return this.a;
    }

    public final java.lang.String b() {
        return this.b;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.vivo.push.model.a.class != obj.getClass()) {
            return false;
        }
        java.lang.String str = this.a;
        java.lang.String str2 = ((com.vivo.push.model.a) obj).a;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        java.lang.String str = this.a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final java.lang.String toString() {
        return "ConfigItem{mKey='" + this.a + "', mValue='" + this.b + "'}";
    }
}
