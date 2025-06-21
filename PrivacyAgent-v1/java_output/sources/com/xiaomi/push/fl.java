package com.xiaomi.push;

/* loaded from: classes19.dex */
public class fl extends com.xiaomi.push.fn {
    private com.xiaomi.push.fl.a a;
    private final java.util.Map<java.lang.String, java.lang.String> b;

    public static class a {
        public static final com.xiaomi.push.fl.a a = new com.xiaomi.push.fl.a(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET);
        public static final com.xiaomi.push.fl.a b = new com.xiaomi.push.fl.a("set");
        public static final com.xiaomi.push.fl.a c = new com.xiaomi.push.fl.a("result");
        public static final com.xiaomi.push.fl.a d = new com.xiaomi.push.fl.a("error");
        public static final com.xiaomi.push.fl.a e = new com.xiaomi.push.fl.a(com.heytap.mcssdk.constant.b.y);
        private java.lang.String f;

        private a(java.lang.String str) {
            this.f = str;
        }

        public static com.xiaomi.push.fl.a a(java.lang.String str) {
            if (str == null) {
                return null;
            }
            java.lang.String lowerCase = str.toLowerCase();
            com.xiaomi.push.fl.a aVar = a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            com.xiaomi.push.fl.a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            com.xiaomi.push.fl.a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            com.xiaomi.push.fl.a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            com.xiaomi.push.fl.a aVar5 = e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public final java.lang.String toString() {
            return this.f;
        }
    }

    public fl() {
        this.a = com.xiaomi.push.fl.a.a;
        this.b = new java.util.HashMap();
    }

    public fl(android.os.Bundle bundle) {
        super(bundle);
        this.a = com.xiaomi.push.fl.a.a;
        this.b = new java.util.HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = com.xiaomi.push.fl.a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.fn
    public final android.os.Bundle a() {
        android.os.Bundle a2 = super.a();
        com.xiaomi.push.fl.a aVar = this.a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    public final void a(com.xiaomi.push.fl.a aVar) {
        if (aVar == null) {
            this.a = com.xiaomi.push.fl.a.a;
        } else {
            this.a = aVar;
        }
    }

    public final synchronized void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.b.putAll(map);
    }

    @Override // com.xiaomi.push.fn
    public final java.lang.String b() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<iq ");
        if (d() != null) {
            sb.append("id=\"" + d() + "\" ");
        }
        if (this.r != null) {
            sb.append("to=\"");
            sb.append(com.xiaomi.push.fy.a(this.r));
            sb.append("\" ");
        }
        if (this.f466s != null) {
            sb.append("from=\"");
            sb.append(com.xiaomi.push.fy.a(this.f466s));
            sb.append("\" ");
        }
        if (this.t != null) {
            sb.append("chid=\"");
            sb.append(com.xiaomi.push.fy.a(this.t));
            sb.append("\" ");
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.b.entrySet()) {
            sb.append(com.xiaomi.push.fy.a(entry.getKey()));
            sb.append("=\"");
            sb.append(com.xiaomi.push.fy.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(this.a);
            str = "\">";
        }
        sb.append(str);
        sb.append(e());
        com.xiaomi.push.fr frVar = this.v;
        if (frVar != null) {
            sb.append(frVar.b());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
