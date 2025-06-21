package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class hd {
    private com.amap.api.mapcore.util.hf a;
    private com.amap.api.mapcore.util.hi b;
    private long c;
    private long d;

    public interface a {
        void onDownload(byte[] bArr, long j);

        void onException(java.lang.Throwable th);

        void onFinish();

        void onStop();
    }

    public hd(com.amap.api.mapcore.util.hi hiVar) {
        this(hiVar, (byte) 0);
    }

    private hd(com.amap.api.mapcore.util.hi hiVar, byte b) {
        this(hiVar, 0L, -1L, false);
    }

    public hd(com.amap.api.mapcore.util.hi hiVar, long j, long j2, boolean z) {
        this.b = hiVar;
        this.c = j;
        this.d = j2;
        hiVar.setHttpProtocol(z ? com.amap.api.mapcore.util.hi.c.HTTPS : com.amap.api.mapcore.util.hi.c.HTTP);
        this.b.setDegradeAbility(com.amap.api.mapcore.util.hi.a.SINGLE);
    }

    public final void a() {
        com.amap.api.mapcore.util.hf hfVar = this.a;
        if (hfVar != null) {
            hfVar.a();
        }
    }

    public final void a(com.amap.api.mapcore.util.hd.a aVar) {
        try {
            com.amap.api.mapcore.util.hf hfVar = new com.amap.api.mapcore.util.hf();
            this.a = hfVar;
            hfVar.b(this.d);
            this.a.a(this.c);
            com.amap.api.mapcore.util.hb.a();
            if (com.amap.api.mapcore.util.hb.c(this.b)) {
                this.b.setDegradeType(com.amap.api.mapcore.util.hi.b.NEVER_GRADE);
                this.a.a(this.b, aVar);
            } else {
                this.b.setDegradeType(com.amap.api.mapcore.util.hi.b.DEGRADE_ONLY);
                this.a.a(this.b, aVar);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
