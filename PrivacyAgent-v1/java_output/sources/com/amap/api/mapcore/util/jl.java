package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jl {

    public static class a implements com.amap.api.mapcore.util.jj {
        private int a;
        private int b;
        private int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.amap.api.mapcore.util.jj
        public final long a() {
            return com.amap.api.mapcore.util.jl.a(this.a, this.b);
        }

        @Override // com.amap.api.mapcore.util.jj
        public final int b() {
            return this.c;
        }
    }

    public static long a(int i, int i2) {
        return (i2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) | ((i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) << 32);
    }

    public static synchronized void a(java.util.List<com.amap.api.mapcore.util.jn> list) {
        com.amap.api.mapcore.util.jl.a aVar;
        synchronized (com.amap.api.mapcore.util.jl.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
                    for (com.amap.api.mapcore.util.jn jnVar : list) {
                        if (jnVar instanceof com.amap.api.mapcore.util.jp) {
                            com.amap.api.mapcore.util.jp jpVar = (com.amap.api.mapcore.util.jp) jnVar;
                            aVar = new com.amap.api.mapcore.util.jl.a(jpVar.j, jpVar.k, jpVar.c);
                        } else if (jnVar instanceof com.amap.api.mapcore.util.jq) {
                            com.amap.api.mapcore.util.jq jqVar = (com.amap.api.mapcore.util.jq) jnVar;
                            aVar = new com.amap.api.mapcore.util.jl.a(jqVar.j, jqVar.k, jqVar.c);
                        } else if (jnVar instanceof com.amap.api.mapcore.util.jr) {
                            com.amap.api.mapcore.util.jr jrVar = (com.amap.api.mapcore.util.jr) jnVar;
                            aVar = new com.amap.api.mapcore.util.jl.a(jrVar.j, jrVar.k, jrVar.c);
                        } else if (jnVar instanceof com.amap.api.mapcore.util.jo) {
                            com.amap.api.mapcore.util.jo joVar = (com.amap.api.mapcore.util.jo) jnVar;
                            aVar = new com.amap.api.mapcore.util.jl.a(joVar.k, joVar.l, joVar.c);
                        }
                        arrayList.add(aVar);
                    }
                    com.amap.api.mapcore.util.jk.a().a(arrayList);
                }
            }
        }
    }
}
