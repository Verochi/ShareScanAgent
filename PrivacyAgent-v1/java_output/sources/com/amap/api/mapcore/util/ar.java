package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ar extends com.amap.api.mapcore.util.ij implements com.amap.api.mapcore.util.bg.a {
    private com.amap.api.mapcore.util.bg a;
    private com.amap.api.mapcore.util.bi b;
    private com.amap.api.mapcore.util.bl c;
    private android.content.Context d;
    private android.os.Bundle e;
    private boolean g;

    private ar(com.amap.api.mapcore.util.bl blVar, android.content.Context context) {
        this.e = new android.os.Bundle();
        this.g = false;
        this.c = blVar;
        this.d = context;
    }

    public ar(com.amap.api.mapcore.util.bl blVar, android.content.Context context, byte b) {
        this(blVar, context);
    }

    private java.lang.String d() {
        return com.amap.api.mapcore.util.dl.c(this.d);
    }

    private void e() throws java.io.IOException {
        com.amap.api.mapcore.util.bg bgVar = new com.amap.api.mapcore.util.bg(new com.amap.api.mapcore.util.bh(this.c.getUrl(), d(), this.c.v(), this.c.w()), this.c.getUrl(), this.d, this.c);
        this.a = bgVar;
        bgVar.a(this);
        com.amap.api.mapcore.util.bl blVar = this.c;
        this.b = new com.amap.api.mapcore.util.bi(blVar, blVar);
        if (this.g) {
            return;
        }
        this.a.a();
    }

    public final void a() {
        this.g = true;
        com.amap.api.mapcore.util.bg bgVar = this.a;
        if (bgVar != null) {
            bgVar.b();
        } else {
            cancelTask();
        }
        com.amap.api.mapcore.util.bi biVar = this.b;
        if (biVar != null) {
            biVar.a();
        }
    }

    public final void b() {
        android.os.Bundle bundle = this.e;
        if (bundle != null) {
            bundle.clear();
            this.e = null;
        }
    }

    @Override // com.amap.api.mapcore.util.bg.a
    public final void c() {
        com.amap.api.mapcore.util.bi biVar = this.b;
        if (biVar != null) {
            biVar.b();
        }
    }

    @Override // com.amap.api.mapcore.util.ij
    public final void runTask() {
        if (this.c.u()) {
            this.c.a(com.amap.api.mapcore.util.bm.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
