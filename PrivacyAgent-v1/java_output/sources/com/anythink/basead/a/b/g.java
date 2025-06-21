package com.anythink.basead.a.b;

/* loaded from: classes12.dex */
public final class g {

    /* renamed from: com.anythink.basead.a.b.g$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.l a;

        /* renamed from: com.anythink.basead.a.b.g$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01301 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.ExecutorService a;

            public RunnableC01301(java.util.concurrent.ExecutorService executorService) {
                this.a = executorService;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.anythink.basead.a.b.g.a a = com.anythink.basead.a.b.g.a(com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).c(4, com.anythink.core.common.o.g.a(com.anythink.basead.a.b.g.AnonymousClass1.this.a.A())));
                    if (a != null) {
                        com.anythink.basead.a.b.g.AnonymousClass1.this.a.i(a.a);
                        com.anythink.basead.a.b.g.AnonymousClass1.this.a.j(a.b);
                    }
                } catch (java.lang.Throwable unused) {
                }
                try {
                    synchronized (this.a) {
                        this.a.notifyAll();
                    }
                } catch (java.lang.Throwable unused2) {
                }
            }
        }

        public AnonymousClass1(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.util.concurrent.ExecutorService newFixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(2);
            newFixedThreadPool.submit(new com.anythink.basead.a.b.g.AnonymousClass1.RunnableC01301(newFixedThreadPool));
            try {
                synchronized (newFixedThreadPool) {
                    newFixedThreadPool.wait(5000L);
                }
                newFixedThreadPool.shutdownNow();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        public int a;
        public int b;
    }

    private static com.anythink.basead.a.b.g.a a(int i, int i2, int i3, int i4) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        com.anythink.basead.a.b.g.a aVar = new com.anythink.basead.a.b.g.a();
        float f = (i * 1.0f) / i2;
        if (f < (i3 * 1.0f) / i4) {
            aVar.b = i4;
            aVar.a = (int) (i4 * f);
        } else {
            aVar.a = i3;
            aVar.b = (int) (i3 / f);
        }
        return aVar;
    }

    private static com.anythink.basead.a.b.g.a a(java.io.FileDescriptor fileDescriptor) {
        com.anythink.basead.a.b.g.a aVar;
        com.anythink.basead.a.b.g.a aVar2 = null;
        if (fileDescriptor == null) {
            return null;
        }
        try {
            aVar = new com.anythink.basead.a.b.g.a();
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(fileDescriptor);
            java.lang.String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            java.lang.String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            mediaMetadataRetriever.release();
            aVar.a = java.lang.Integer.parseInt(extractMetadata);
            aVar.b = java.lang.Integer.parseInt(extractMetadata2);
            return aVar;
        } catch (java.lang.Exception e2) {
            e = e2;
            aVar2 = aVar;
            e.printStackTrace();
            return aVar2;
        }
    }

    private static com.anythink.basead.a.b.g.a a(java.io.FileDescriptor fileDescriptor, int i, int i2) {
        com.anythink.basead.a.b.g.a a2 = a(fileDescriptor);
        if (a2 == null) {
            return null;
        }
        if ((a2.a * 1.0f) / a2.b < (i * 1.0f) / i2) {
            a2.b = i2;
            a2.a = (int) java.lang.Math.ceil(i2 * r0);
        } else {
            a2.a = i;
            a2.b = (int) java.lang.Math.ceil(i / r0);
        }
        return a2;
    }

    public static com.anythink.basead.a.b.g.a a(java.lang.String str) {
        com.anythink.basead.a.b.g.a aVar = null;
        try {
            if (android.text.TextUtils.isEmpty(str) || !new java.io.File(str).exists()) {
                return null;
            }
            com.anythink.basead.a.b.g.a aVar2 = new com.anythink.basead.a.b.g.a();
            try {
                android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                java.lang.String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                java.lang.String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaMetadataRetriever.release();
                aVar2.a = java.lang.Integer.parseInt(extractMetadata);
                aVar2.b = java.lang.Integer.parseInt(extractMetadata2);
                return aVar2;
            } catch (java.lang.Exception e) {
                e = e;
                aVar = aVar2;
                e.printStackTrace();
                return aVar;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    public static void a(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.n nVar) {
        if (lVar == null) {
            return;
        }
        synchronized (lVar) {
            if (!lVar.S() && !android.text.TextUtils.isEmpty(lVar.A())) {
                lVar.T();
                if (java.lang.String.valueOf(nVar.z()).equals("3") && lVar.F() == 1 && nVar.K().equals("2")) {
                    com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.a.b.g.AnonymousClass1(lVar), 2, true);
                }
            }
        }
    }
}
