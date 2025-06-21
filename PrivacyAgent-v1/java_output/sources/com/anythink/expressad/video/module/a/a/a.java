package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public final class a extends com.anythink.expressad.video.module.a.a.f {
    private com.anythink.expressad.foundation.d.c V;
    private android.app.Activity a;

    private a(android.app.Activity activity, com.anythink.expressad.foundation.d.c cVar) {
        this.a = activity;
        this.V = cVar;
    }

    @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, java.lang.Object obj) {
        android.app.Activity activity;
        super.a(i, obj);
        if (i != 106 || (activity = this.a) == null || this.V == null) {
            return;
        }
        activity.finish();
    }
}
