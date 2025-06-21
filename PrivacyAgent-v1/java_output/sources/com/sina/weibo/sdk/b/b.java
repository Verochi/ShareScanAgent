package com.sina.weibo.sdk.b;

/* loaded from: classes19.dex */
public final class b {
    private com.sina.weibo.sdk.b.a O;

    public static class a {
        private static com.sina.weibo.sdk.b.b P = new com.sina.weibo.sdk.b.b((byte) 0);
    }

    private b() {
        this.O = null;
        this.O = new com.sina.weibo.sdk.b.a();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public final void a(com.sina.weibo.sdk.b.c cVar) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.O.M;
        if (cVar.Q != com.sina.weibo.sdk.b.c.b.Z) {
            int i = com.sina.weibo.sdk.b.c.AnonymousClass4.W[cVar.Q - 1];
            if (i == 1) {
                throw new java.lang.IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new java.lang.IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        cVar.Q = com.sina.weibo.sdk.b.c.b.aa;
        com.sina.weibo.sdk.b.c.d<Params, Result> dVar = cVar.R;
        dVar.ad = cVar.U;
        dVar.priority = cVar.T;
        threadPoolExecutor.execute(cVar.S);
    }
}
