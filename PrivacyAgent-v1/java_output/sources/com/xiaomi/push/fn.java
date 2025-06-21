package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class fn {
    private static java.lang.String b;
    private static long c;
    public static final java.text.DateFormat o;
    private java.util.List<com.xiaomi.push.fk> d;
    private final java.util.Map<java.lang.String, java.lang.Object> e;
    java.lang.String p;
    java.lang.String q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public java.lang.String f466s;
    public java.lang.String t;
    public java.lang.String u;
    com.xiaomi.push.fr v;
    protected static final java.lang.String n = java.util.Locale.getDefault().getLanguage().toLowerCase();
    private static java.lang.String a = null;

    static {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        o = simpleDateFormat;
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        b = com.xiaomi.push.fy.a() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        c = 0L;
    }

    public fn() {
        this.p = a;
        this.q = null;
        this.r = null;
        this.f466s = null;
        this.t = null;
        this.u = null;
        this.d = new java.util.concurrent.CopyOnWriteArrayList();
        this.e = new java.util.HashMap();
        this.v = null;
    }

    public fn(android.os.Bundle bundle) {
        this.p = a;
        this.q = null;
        this.r = null;
        this.f466s = null;
        this.t = null;
        this.u = null;
        this.d = new java.util.concurrent.CopyOnWriteArrayList();
        this.e = new java.util.HashMap();
        this.v = null;
        this.r = bundle.getString("ext_to");
        this.f466s = bundle.getString("ext_from");
        this.t = bundle.getString("ext_chid");
        this.q = bundle.getString("ext_pkt_id");
        android.os.Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.d = new java.util.ArrayList(parcelableArray.length);
            for (android.os.Parcelable parcelable : parcelableArray) {
                this.d.add(com.xiaomi.push.fk.a((android.os.Bundle) parcelable));
            }
        }
        android.os.Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.v = new com.xiaomi.push.fr(bundle2);
        }
    }

    private synchronized java.lang.Object b(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Object> map = this.e;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static synchronized java.lang.String c() {
        java.lang.String sb;
        synchronized (com.xiaomi.push.fn.class) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(b);
            long j = c;
            c = 1 + j;
            sb2.append(java.lang.Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public static java.lang.String f() {
        return n;
    }

    private synchronized java.util.Collection<com.xiaomi.push.fk> g() {
        if (this.d == null) {
            return java.util.Collections.emptyList();
        }
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(this.d));
    }

    private synchronized java.util.Collection<java.lang.String> h() {
        if (this.e == null) {
            return java.util.Collections.emptySet();
        }
        return java.util.Collections.unmodifiableSet(new java.util.HashSet(this.e.keySet()));
    }

    public android.os.Bundle a() {
        android.os.Bundle bundle = new android.os.Bundle();
        if (!android.text.TextUtils.isEmpty(this.p)) {
            bundle.putString("ext_ns", this.p);
        }
        if (!android.text.TextUtils.isEmpty(this.f466s)) {
            bundle.putString("ext_from", this.f466s);
        }
        if (!android.text.TextUtils.isEmpty(this.r)) {
            bundle.putString("ext_to", this.r);
        }
        if (!android.text.TextUtils.isEmpty(this.q)) {
            bundle.putString("ext_pkt_id", this.q);
        }
        if (!android.text.TextUtils.isEmpty(this.t)) {
            bundle.putString("ext_chid", this.t);
        }
        com.xiaomi.push.fr frVar = this.v;
        if (frVar != null) {
            bundle.putBundle("ext_ERROR", frVar.a());
        }
        java.util.List<com.xiaomi.push.fk> list = this.d;
        if (list != null) {
            android.os.Bundle[] bundleArr = new android.os.Bundle[list.size()];
            java.util.Iterator<com.xiaomi.push.fk> it = this.d.iterator();
            int i = 0;
            while (it.hasNext()) {
                bundleArr[i] = it.next().c();
                i++;
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public final com.xiaomi.push.fk a(java.lang.String str) {
        for (com.xiaomi.push.fk fkVar : this.d) {
            if (str.equals(fkVar.a)) {
                return fkVar;
            }
        }
        return null;
    }

    public final void a(com.xiaomi.push.fk fkVar) {
        this.d.add(fkVar);
    }

    public abstract java.lang.String b();

    public final java.lang.String d() {
        if ("ID_NOT_AVAILABLE".equals(this.q)) {
            return null;
        }
        if (this.q == null) {
            this.q = c();
        }
        return this.q;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x010d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.lang.String e() {
        java.lang.StringBuilder sb;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ObjectOutputStream objectOutputStream;
        java.lang.Exception e;
        java.lang.String str;
        sb = new java.lang.StringBuilder();
        java.util.Iterator<com.xiaomi.push.fk> it = g().iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
        }
        java.util.Map<java.lang.String, java.lang.Object> map = this.e;
        if (map != null && !map.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (java.lang.String str2 : h()) {
                java.lang.Object b2 = b(str2);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(com.xiaomi.push.fy.a(str2));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (b2 instanceof java.lang.Integer) {
                    sb.append("integer\">");
                    sb.append(b2);
                    str = "</value>";
                } else if (b2 instanceof java.lang.Long) {
                    sb.append("long\">");
                    sb.append(b2);
                    str = "</value>";
                } else if (b2 instanceof java.lang.Float) {
                    sb.append("float\">");
                    sb.append(b2);
                    str = "</value>";
                } else if (b2 instanceof java.lang.Double) {
                    sb.append("double\">");
                    sb.append(b2);
                    str = "</value>";
                } else if (b2 instanceof java.lang.Boolean) {
                    sb.append("boolean\">");
                    sb.append(b2);
                    str = "</value>";
                } else if (b2 instanceof java.lang.String) {
                    sb.append("string\">");
                    sb.append(com.xiaomi.push.fy.a((java.lang.String) b2));
                    str = "</value>";
                } else {
                    java.io.ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        try {
                            objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
                            try {
                                try {
                                    objectOutputStream.writeObject(b2);
                                    sb.append("java-object\">");
                                    sb.append(com.xiaomi.push.fy.a(byteArrayOutputStream.toByteArray()));
                                    sb.append("</value>");
                                    try {
                                        objectOutputStream.close();
                                    } catch (java.lang.Exception unused) {
                                    }
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    objectOutputStream2 = objectOutputStream;
                                    if (objectOutputStream2 != null) {
                                        try {
                                            objectOutputStream2.close();
                                        } catch (java.lang.Exception unused2) {
                                        }
                                    }
                                    if (byteArrayOutputStream == null) {
                                        throw th;
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (java.lang.Exception unused3) {
                                        throw th;
                                    }
                                }
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (java.lang.Exception unused4) {
                                    }
                                }
                                if (byteArrayOutputStream == null) {
                                    sb.append("</property>");
                                }
                                byteArrayOutputStream.close();
                                sb.append("</property>");
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            objectOutputStream = null;
                            e = e;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                            }
                            if (byteArrayOutputStream == null) {
                            }
                            byteArrayOutputStream.close();
                            sb.append("</property>");
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.lang.Exception unused5) {
                    }
                    sb.append("</property>");
                }
                sb.append(str);
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.xiaomi.push.fn fnVar = (com.xiaomi.push.fn) obj;
            com.xiaomi.push.fr frVar = this.v;
            if (frVar == null ? fnVar.v != null : !frVar.equals(fnVar.v)) {
                return false;
            }
            java.lang.String str = this.f466s;
            if (str == null ? fnVar.f466s != null : !str.equals(fnVar.f466s)) {
                return false;
            }
            if (!this.d.equals(fnVar.d)) {
                return false;
            }
            java.lang.String str2 = this.q;
            if (str2 == null ? fnVar.q != null : !str2.equals(fnVar.q)) {
                return false;
            }
            java.lang.String str3 = this.t;
            if (str3 == null ? fnVar.t != null : !str3.equals(fnVar.t)) {
                return false;
            }
            java.util.Map<java.lang.String, java.lang.Object> map = this.e;
            if (map == null ? fnVar.e != null : !map.equals(fnVar.e)) {
                return false;
            }
            java.lang.String str4 = this.r;
            if (str4 == null ? fnVar.r != null : !str4.equals(fnVar.r)) {
                return false;
            }
            java.lang.String str5 = this.p;
            java.lang.String str6 = fnVar.p;
            if (str5 == null ? str6 == null : str5.equals(str6)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        java.lang.String str = this.p;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.q;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.r;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        java.lang.String str4 = this.f466s;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        java.lang.String str5 = this.t;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        com.xiaomi.push.fr frVar = this.v;
        return hashCode5 + (frVar != null ? frVar.hashCode() : 0);
    }
}
