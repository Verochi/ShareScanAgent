package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class i extends com.sijla.mla.a.b.s {
    private static final java.util.HashMap<java.lang.String, java.lang.String> b = new java.util.HashMap<>();
    private static android.content.SharedPreferences g;
    private static final java.util.ArrayList<java.lang.String> h;
    private com.sijla.mla.a.b a;
    private android.content.Context f;

    public static class a extends com.sijla.mla.a.b.t {
        private final android.content.Context a;

        public a(android.content.Context context, java.lang.String str) {
            this.a = context;
            this.e = str;
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            char c;
            try {
                java.lang.String str = this.e;
                switch (str.hashCode()) {
                    case -1289358244:
                        if (str.equals("exists")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -934610812:
                        if (str.equals("remove")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 102230:
                        if (str.equals(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 113762:
                        if (str.equals("set")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3322014:
                        if (str.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 94746189:
                        if (str.equals("clear")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    java.lang.String v = yVar.v(1);
                    java.lang.String str2 = (java.lang.String) com.sijla.mla.a.b.i.b.get(v);
                    if (str2 == null) {
                        if (!yVar.p(2)) {
                            return com.sijla.mla.a.r.k;
                        }
                        str2 = com.sijla.mla.a.b.i.g.getString("mla_".concat(java.lang.String.valueOf(v)), "_null_");
                        if ("_null_".equalsIgnoreCase(str2)) {
                            return com.sijla.mla.a.r.k;
                        }
                        com.sijla.mla.a.b.i.b.put(v, str2);
                    }
                    return com.sijla.mla.a.n.c(str2);
                }
                if (c == 1) {
                    java.lang.String v2 = yVar.v(1);
                    java.lang.String v3 = yVar.v(2);
                    com.sijla.mla.a.b.i.b.put(v2, v3);
                    if (yVar.p(3) && com.sijla.mla.a.b.i.g != null) {
                        com.sijla.mla.a.b.i.g.edit().putString("mla_".concat(java.lang.String.valueOf(v2)), v3).apply();
                    }
                    return com.sijla.mla.a.r.l;
                }
                if (c != 2) {
                    if (c == 3) {
                        com.sijla.mla.a.b.i.b.clear();
                        return com.sijla.mla.a.r.l;
                    }
                    if (c != 4) {
                        return c != 5 ? com.sijla.mla.a.r.n : com.sijla.mla.a.r.a(com.sijla.mla.a.b.i.b.containsKey(yVar.v(1)));
                    }
                    com.sijla.mla.a.b.i.b.remove(yVar.v(1));
                    return com.sijla.mla.a.r.l;
                }
                java.util.Set<java.lang.String> keySet = com.sijla.mla.a.b.i.b.keySet();
                com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
                for (java.lang.String str3 : keySet) {
                    oVar.b(str3, (java.lang.String) com.sijla.mla.a.b.i.b.get(str3));
                }
                return oVar;
            } catch (java.lang.Exception e) {
                return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.y) com.sijla.mla.a.n.c(e.getMessage()));
            }
        }
    }

    static {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        h = arrayList;
        arrayList.add(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET);
        arrayList.add("set");
        arrayList.add(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
        arrayList.add("clear");
        arrayList.add("remove");
        arrayList.add("exists");
    }

    public i(android.content.Context context) {
        this.f = context.getApplicationContext();
        if (g == null) {
            g = context.getSharedPreferences("__ML__" + context.getPackageName(), 0);
        }
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        this.a = rVar2.a();
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        int i = 0;
        while (true) {
            java.util.ArrayList<java.lang.String> arrayList = h;
            if (i >= arrayList.size()) {
                rVar2.a("kv", oVar);
                rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a("kv", oVar);
                return oVar;
            }
            java.lang.String str = arrayList.get(i);
            oVar.a(str, new com.sijla.mla.a.b.i.a(this.f, str));
            i++;
        }
    }
}
