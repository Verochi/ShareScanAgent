package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public final class o extends com.anythink.expressad.video.signal.a.e {
    private android.app.Activity n;
    private com.anythink.expressad.video.module.AnythinkContainerView o;

    private o(android.app.Activity activity, com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView) {
        this.n = activity;
        this.o = anythinkContainerView;
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i, java.lang.String str) {
        android.app.Activity activity;
        super.a(i, str);
        int i2 = 1;
        if (i != 1) {
            if (i == 2 && (activity = this.n) != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (this.o != null) {
            try {
                i2 = java.lang.Integer.valueOf(str).intValue();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            this.o.showVideoClickView(i2);
        }
    }
}
