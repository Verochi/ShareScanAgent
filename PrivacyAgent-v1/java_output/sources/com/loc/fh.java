package com.loc;

/* loaded from: classes23.dex */
public final class fh extends com.loc.ez<com.loc.ei> {
    public fh(android.content.Context context, java.lang.String str, android.os.Handler handler) {
        super(context, str, handler);
    }

    private static java.lang.String a(com.loc.ei eiVar) {
        return eiVar == null ? "" : eiVar.a();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.loc.ei eiVar, long j) {
        if (eiVar != null) {
            eiVar.f = j;
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(com.loc.ei eiVar) {
        if (eiVar == null) {
            return -113;
        }
        return eiVar.c;
    }

    /* renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(com.loc.ei eiVar) {
        if (eiVar == null) {
            return 0L;
        }
        return eiVar.f;
    }

    @Override // com.loc.ez
    public final /* bridge */ /* synthetic */ void a(com.loc.ei eiVar, long j) {
        a2(eiVar, j);
    }

    @Override // com.loc.ez
    public final long b() {
        return com.loc.ew.e;
    }

    @Override // com.loc.ez
    public final /* synthetic */ java.lang.String b(com.loc.ei eiVar) {
        return a(eiVar);
    }

    @Override // com.loc.ez
    public final /* synthetic */ int c(com.loc.ei eiVar) {
        return b2(eiVar);
    }

    @Override // com.loc.ez
    public final long c() {
        return com.loc.ew.f;
    }

    @Override // com.loc.ez
    public final /* synthetic */ long d(com.loc.ei eiVar) {
        return c2(eiVar);
    }
}
