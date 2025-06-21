package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public final class h extends com.anythink.expressad.video.module.a.a.k {
    public h(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, java.lang.String str, java.lang.String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i, z);
    }

    @Override // com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, java.lang.Object obj) {
        if (i == 100) {
            e();
            d();
            c();
            a(2);
        } else if (i == 109) {
            b(2);
        } else if (i == 122) {
            a();
        } else if (i != 129) {
            java.lang.String str = "";
            if (i == 118) {
                if (obj != null && (obj instanceof java.lang.String)) {
                    str = (java.lang.String) obj;
                }
                a(3, str);
            } else if (i == 119) {
                if (obj != null && (obj instanceof java.lang.String)) {
                    str = (java.lang.String) obj;
                }
                a(4, str);
            }
        } else {
            com.anythink.expressad.foundation.d.c cVar = this.X;
            if (cVar != null && cVar.J() == 2) {
                e();
                d();
                c();
                a(1);
            }
        }
        super.a(i, obj);
    }
}
