package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_er {
    public static final java.util.concurrent.Executor jad_an = new com.jd.ad.sdk.jad_ir.jad_er.jad_an();
    public static final java.util.concurrent.Executor jad_bo = new com.jd.ad.sdk.jad_ir.jad_er.jad_bo();

    public class jad_an implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            com.jd.ad.sdk.jad_ir.jad_ly.jad_bo().post(runnable);
        }
    }

    public class jad_bo implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            runnable.run();
        }
    }
}
