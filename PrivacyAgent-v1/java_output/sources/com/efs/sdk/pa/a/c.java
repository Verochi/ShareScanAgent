package com.efs.sdk.pa.a;

import com.efs.sdk.pa.a.b.a.AnonymousClass1;

/* loaded from: classes22.dex */
public final class c implements com.efs.sdk.pa.PA {
    private boolean a;
    private com.efs.sdk.pa.a.e c;
    private com.efs.sdk.pa.a.f d;
    private com.efs.sdk.pa.a.a e;
    private boolean h;
    private boolean i;
    private android.os.Looper b = android.os.Looper.myLooper();
    private com.efs.sdk.pa.a.b f = new com.efs.sdk.pa.a.b();
    private com.efs.sdk.pa.a.g g = new com.efs.sdk.pa.a.g();

    public c(boolean z) {
        this.i = z;
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableDumpToFile(java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        com.efs.sdk.pa.a.f fVar = this.d;
        if (fVar == null || str == null || str.trim().length() == 0) {
            return;
        }
        fVar.c = str;
        if (fVar.d == null) {
            try {
                fileOutputStream = new java.io.FileOutputStream(str);
            } catch (java.lang.Exception unused) {
                fileOutputStream = null;
            }
            try {
                fVar.d = new java.io.BufferedOutputStream(fileOutputStream);
            } catch (java.lang.Exception unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.lang.Exception unused3) {
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableLog(boolean z) {
        this.a = z;
        this.f.b = z;
        this.g.b = z;
        com.efs.sdk.pa.a.f fVar = this.d;
        if (fVar != null) {
            fVar.b = z;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final int endCalFPS(java.lang.String str) {
        if (!this.h) {
            return -1;
        }
        com.efs.sdk.pa.a.b bVar = this.f;
        if (str != null && str.trim().length() != 0) {
            com.efs.sdk.pa.a.b.a aVar = bVar.a.get(str);
            if (aVar == null) {
                return 0;
            }
            android.view.View view = aVar.d;
            if (view != null && aVar.c != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(aVar.c);
            }
            bVar.a.remove(str);
            int currentTimeMillis = (int) (aVar.b / ((java.lang.System.currentTimeMillis() - aVar.a) / 1000.0f));
            r1 = currentTimeMillis > 0 ? currentTimeMillis : 0;
            if (bVar.b) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("key=");
                sb.append(str);
                sb.append(",fps=");
                sb.append(r1);
            }
        }
        return r1;
    }

    @Override // com.efs.sdk.pa.PA
    public final long endCalTime(java.lang.String str) {
        if (!this.h) {
            return -1L;
        }
        com.efs.sdk.pa.a.g gVar = this.g;
        long j = 0;
        if (str != null && str.trim().length() != 0) {
            com.efs.sdk.pa.a.g.a aVar = gVar.a.get(str);
            if (aVar == null) {
                return 0L;
            }
            gVar.a.remove(str);
            j = java.lang.System.currentTimeMillis() - aVar.a;
            if (gVar.b) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("key=");
                sb.append(str);
                sb.append(",consumeTime=");
                sb.append(j);
            }
        }
        return j;
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(android.content.Context context, com.efs.sdk.pa.PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, 2000L);
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(android.content.Context context, com.efs.sdk.pa.PAANRListener pAANRListener, long j) {
        registerPAANRListener(context, pAANRListener, j, android.os.Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(android.content.Context context, com.efs.sdk.pa.PAANRListener pAANRListener, long j, java.lang.Thread thread) {
        if (this.e == null) {
            if (thread != null) {
                this.e = new com.efs.sdk.pa.a.a((android.app.Application) context.getApplicationContext(), j);
            } else {
                this.e = new com.efs.sdk.pa.a.a((android.app.Application) context.getApplicationContext(), j, false);
            }
        }
        this.e.h = pAANRListener;
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAMsgListener(com.efs.sdk.pa.PAMsgListener pAMsgListener) {
        if (this.c == null) {
            this.c = new com.efs.sdk.pa.a.e();
        }
        this.b.setMessageLogging(this.c);
        if (this.d == null) {
            this.d = new com.efs.sdk.pa.a.f();
        }
        com.efs.sdk.pa.a.f fVar = this.d;
        fVar.b = this.a;
        fVar.a = pAMsgListener;
        this.c.a.add(fVar);
    }

    @Override // com.efs.sdk.pa.PA
    public final void start() {
        if (this.i || com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.h = true;
            com.efs.sdk.pa.a.e eVar = this.c;
            if (eVar != null) {
                this.b.setMessageLogging(eVar);
            }
            com.efs.sdk.pa.a.a aVar = this.e;
            if (aVar == null || !aVar.f) {
                return;
            }
            aVar.f = false;
            aVar.g.post(aVar.m);
            aVar.j = android.os.SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalFPS(java.lang.String str, android.view.View view) {
        if (this.h) {
            com.efs.sdk.pa.a.b bVar = this.f;
            if (str == null || str.trim().length() == 0 || view == null || bVar.a.get(str) != null) {
                return;
            }
            com.efs.sdk.pa.a.b.a aVar = new com.efs.sdk.pa.a.b.a((byte) 0);
            aVar.d = view;
            com.efs.sdk.pa.a.b.a.AnonymousClass1 anonymousClass1 = aVar.new AnonymousClass1();
            aVar.c = anonymousClass1;
            aVar.d.getViewTreeObserver().addOnPreDrawListener(anonymousClass1);
            aVar.a = java.lang.System.currentTimeMillis();
            bVar.a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalTime(java.lang.String str) {
        if (this.h) {
            com.efs.sdk.pa.a.g gVar = this.g;
            if (str == null || str.trim().length() == 0 || gVar.a.get(str) != null) {
                return;
            }
            com.efs.sdk.pa.a.g.a aVar = new com.efs.sdk.pa.a.g.a((byte) 0);
            aVar.a = java.lang.System.currentTimeMillis();
            gVar.a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void stop() {
        this.h = false;
        this.b.setMessageLogging(null);
        com.efs.sdk.pa.a.a aVar = this.e;
        if (aVar != null) {
            aVar.f = true;
            aVar.g.removeCallbacksAndMessages(null);
            aVar.a = true;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unRegisterPAMsgListener() {
        com.efs.sdk.pa.a.f fVar = this.d;
        if (fVar != null) {
            fVar.a = null;
        }
        com.efs.sdk.pa.a.e eVar = this.c;
        if (eVar != null) {
            eVar.a.remove(fVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unregisterPAANRListener() {
    }
}
