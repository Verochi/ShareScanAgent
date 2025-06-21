package cn.fly.verify;

/* loaded from: classes31.dex */
public enum bb {
    JP("jp", "Japan"),
    US("us", "United States of America"),
    DEFAULT(null, null);

    private java.lang.String d;
    private java.lang.String e;

    bb(java.lang.String str, java.lang.String str2) {
        this.d = str;
        this.e = str2;
    }

    public static cn.fly.verify.bb a(java.lang.String str) {
        if (str == null) {
            return DEFAULT;
        }
        for (cn.fly.verify.bb bbVar : values()) {
            if (str.equalsIgnoreCase(bbVar.d)) {
                return bbVar;
            }
        }
        return DEFAULT;
    }

    public java.lang.String a() {
        return this.d;
    }
}
