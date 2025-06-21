package com.bytedance.pangle;

/* loaded from: classes12.dex */
public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r1 > 0) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        boolean z;
        com.bytedance.pangle.flipped.c bVar;
        int i;
        int i2;
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_FLIPPED, com.anythink.expressad.foundation.d.c.bT);
        int i3 = android.os.Build.VERSION.SDK_INT;
        boolean z2 = false;
        if (i3 < 30) {
            if (i3 == 29) {
                i2 = android.os.Build.VERSION.PREVIEW_SDK_INT;
            }
            z = false;
            if (z) {
                if (i3 < 28) {
                    if (i3 == 27) {
                        i = android.os.Build.VERSION.PREVIEW_SDK_INT;
                    }
                    bVar = !z2 ? new com.bytedance.pangle.flipped.b() : new com.bytedance.pangle.flipped.a();
                }
                z2 = true;
                if (!z2) {
                }
            } else {
                bVar = new com.bytedance.pangle.flipped.FlippedV2Impl();
            }
            bVar.invokeHiddenApiRestrictions();
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_FLIPPED, "finish");
        }
        z = true;
        if (z) {
        }
        bVar.invokeHiddenApiRestrictions();
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_FLIPPED, "finish");
    }
}
