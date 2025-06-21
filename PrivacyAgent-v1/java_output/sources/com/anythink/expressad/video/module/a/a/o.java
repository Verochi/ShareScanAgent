package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public class o extends com.anythink.expressad.video.module.a.a.k {
    private boolean ag;
    protected int ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private boolean al;
    private java.util.Map<java.lang.Integer, java.lang.String> am;
    private int an;

    public o(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, java.lang.String str, java.lang.String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar3, cVar2, str, str2, aVar, i, z);
        this.al = false;
        this.ah = 0;
        this.an = -1;
        if (this.W) {
            this.am = cVar.R();
        }
        this.ah = cVar.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:
    
        if (r8 != 16) goto L60;
     */
    @Override // com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, java.lang.Object obj) {
        int i2;
        com.anythink.expressad.foundation.d.c cVar;
        try {
            if (i != 2 && i != 6) {
                if (i != 7) {
                    int i3 = 0;
                    if (i == 11) {
                        com.anythink.expressad.videocommon.b.e.a().a(false);
                        b();
                    } else if (i == 12) {
                        b();
                        com.anythink.expressad.videocommon.b.e.a().a(false);
                    } else if (i == 15) {
                        e();
                        d();
                        c();
                        if (obj == null || !(obj instanceof com.anythink.expressad.video.module.AnythinkVideoView.a)) {
                            i2 = 0;
                        } else {
                            int i4 = ((com.anythink.expressad.video.module.AnythinkVideoView.a) obj).a;
                            i3 = ((com.anythink.expressad.video.module.AnythinkVideoView.a) obj).b;
                            i2 = i4;
                        }
                        if (i3 == 0 && (cVar = this.X) != null) {
                            i3 = cVar.bi();
                        }
                        com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.o.a().f(), this.X, i2, i3, this.af);
                        com.anythink.expressad.video.module.b.a.a(this.X, this.am, this.ac, i2);
                        if (!this.ak) {
                            this.ak = true;
                            com.anythink.expressad.video.module.b.a.a(this.X, this.ac);
                        }
                        if (!this.al) {
                            int i5 = this.ah;
                            if (i5 != 0) {
                                i3 = i5;
                            }
                            if (i2 >= i3) {
                                this.al = true;
                                i = 17;
                            }
                        }
                        this.an = i2;
                    }
                } else if (this.W && obj != null && (obj instanceof java.lang.Integer)) {
                    int intValue = ((java.lang.Integer) obj).intValue();
                    if (intValue == 2) {
                        if (!this.ai) {
                            this.ai = true;
                            com.anythink.expressad.video.module.b.a.b(com.anythink.core.common.b.o.a().f(), this.X);
                        }
                    } else if (intValue == 1 && !this.ag) {
                        this.ag = true;
                        com.anythink.expressad.video.module.b.a.c(com.anythink.core.common.b.o.a().f(), this.X);
                    }
                }
                this.ae.a(i, obj);
            }
            if (this.W && !this.aj) {
                this.aj = true;
                b();
                com.anythink.expressad.video.module.b.a.d(com.anythink.core.common.b.o.a().f(), this.X);
            }
            this.ae.a(i, obj);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
