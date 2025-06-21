package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class fr {
    private int a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.util.List<com.xiaomi.push.fk> f;

    public static class a {
        public static final com.xiaomi.push.fr.a a = new com.xiaomi.push.fr.a("internal-server-error");
        public static final com.xiaomi.push.fr.a b = new com.xiaomi.push.fr.a(com.getui.gtc.extension.distribution.gbd.d.g.h);
        public static final com.xiaomi.push.fr.a c = new com.xiaomi.push.fr.a("bad-request");
        public static final com.xiaomi.push.fr.a d = new com.xiaomi.push.fr.a("conflict");
        public static final com.xiaomi.push.fr.a e = new com.xiaomi.push.fr.a("feature-not-implemented");
        public static final com.xiaomi.push.fr.a f = new com.xiaomi.push.fr.a("gone");
        public static final com.xiaomi.push.fr.a g = new com.xiaomi.push.fr.a("item-not-found");
        public static final com.xiaomi.push.fr.a h = new com.xiaomi.push.fr.a("jid-malformed");
        public static final com.xiaomi.push.fr.a i = new com.xiaomi.push.fr.a("not-acceptable");
        public static final com.xiaomi.push.fr.a j = new com.xiaomi.push.fr.a("not-allowed");
        public static final com.xiaomi.push.fr.a k = new com.xiaomi.push.fr.a("not-authorized");
        public static final com.xiaomi.push.fr.a l = new com.xiaomi.push.fr.a("payment-required");
        public static final com.xiaomi.push.fr.a m = new com.xiaomi.push.fr.a("recipient-unavailable");
        public static final com.xiaomi.push.fr.a n = new com.xiaomi.push.fr.a("redirect");
        public static final com.xiaomi.push.fr.a o = new com.xiaomi.push.fr.a("registration-required");
        public static final com.xiaomi.push.fr.a p = new com.xiaomi.push.fr.a("remote-server-error");
        public static final com.xiaomi.push.fr.a q = new com.xiaomi.push.fr.a("remote-server-not-found");
        public static final com.xiaomi.push.fr.a r = new com.xiaomi.push.fr.a("remote-server-timeout");

        /* renamed from: s, reason: collision with root package name */
        public static final com.xiaomi.push.fr.a f467s = new com.xiaomi.push.fr.a("resource-constraint");
        public static final com.xiaomi.push.fr.a t = new com.xiaomi.push.fr.a("service-unavailable");
        public static final com.xiaomi.push.fr.a u = new com.xiaomi.push.fr.a("subscription-required");
        public static final com.xiaomi.push.fr.a v = new com.xiaomi.push.fr.a("undefined-condition");
        public static final com.xiaomi.push.fr.a w = new com.xiaomi.push.fr.a("unexpected-request");
        public static final com.xiaomi.push.fr.a x = new com.xiaomi.push.fr.a("request-timeout");
        private java.lang.String y;

        private a(java.lang.String str) {
            this.y = str;
        }

        public final java.lang.String toString() {
            return this.y;
        }
    }

    public fr(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.List<com.xiaomi.push.fk> list) {
        this.a = i;
        this.b = str;
        this.d = str2;
        this.c = str3;
        this.e = str4;
        this.f = list;
    }

    public fr(android.os.Bundle bundle) {
        this.f = null;
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.b = bundle.getString("ext_err_type");
        }
        this.c = bundle.getString("ext_err_cond");
        this.d = bundle.getString("ext_err_reason");
        this.e = bundle.getString("ext_err_msg");
        android.os.Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f = new java.util.ArrayList(parcelableArray.length);
            for (android.os.Parcelable parcelable : parcelableArray) {
                this.f.add(com.xiaomi.push.fk.a((android.os.Bundle) parcelable));
            }
        }
    }

    public fr(com.xiaomi.push.fr.a aVar) {
        this.f = null;
        this.c = aVar.y;
        this.e = null;
    }

    private synchronized java.util.List<com.xiaomi.push.fk> c() {
        java.util.List<com.xiaomi.push.fk> list = this.f;
        if (list == null) {
            return java.util.Collections.emptyList();
        }
        return java.util.Collections.unmodifiableList(list);
    }

    public final android.os.Bundle a() {
        android.os.Bundle bundle = new android.os.Bundle();
        java.lang.String str = this.b;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.a);
        java.lang.String str2 = this.d;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        java.lang.String str3 = this.c;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        java.lang.String str4 = this.e;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        java.util.List<com.xiaomi.push.fk> list = this.f;
        if (list != null) {
            android.os.Bundle[] bundleArr = new android.os.Bundle[list.size()];
            java.util.Iterator<com.xiaomi.push.fk> it = this.f.iterator();
            int i = 0;
            while (it.hasNext()) {
                bundleArr[i] = it.next().c();
                i++;
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public final java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.a);
        sb.append("\"");
        if (this.b != null) {
            sb.append(" type=\"");
            sb.append(this.b);
            sb.append("\"");
        }
        if (this.d != null) {
            sb.append(" reason=\"");
            sb.append(this.d);
            sb.append("\"");
        }
        sb.append(">");
        if (this.c != null) {
            sb.append("<");
            sb.append(this.c);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.e != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.e);
            sb.append("</text>");
        }
        java.util.Iterator<com.xiaomi.push.fk> it = c().iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
        }
        sb.append("</error>");
        return sb.toString();
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = this.c;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.a);
        sb.append(")");
        if (this.e != null) {
            sb.append(" ");
            sb.append(this.e);
        }
        return sb.toString();
    }
}
