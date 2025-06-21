package com.xiaomi.push;

/* loaded from: classes19.dex */
final class jg extends com.xiaomi.push.jf {
    final /* synthetic */ java.lang.Runnable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jg(android.content.Context context, java.io.File file, java.lang.Runnable runnable) {
        super(context, file, (byte) 0);
        this.a = runnable;
    }

    @Override // com.xiaomi.push.jf
    public final void a() {
        java.lang.Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
