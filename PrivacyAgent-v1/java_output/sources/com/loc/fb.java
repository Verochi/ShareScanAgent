package com.loc;

/* loaded from: classes23.dex */
public final class fb extends com.loc.ez<com.loc.fc> {
    public fb(android.content.Context context, java.lang.String str, android.os.Handler handler) {
        super(context, str, handler);
    }

    private static java.lang.String a(com.loc.fc fcVar) {
        return fcVar == null ? "" : fcVar.b();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.loc.fc fcVar, long j) {
        if (fcVar != null) {
            fcVar.t = j;
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(com.loc.fc fcVar) {
        if (fcVar == null) {
            return 99;
        }
        return fcVar.f406s;
    }

    /* renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(com.loc.fc fcVar) {
        if (fcVar == null) {
            return 0L;
        }
        return fcVar.t;
    }

    @Override // com.loc.ez
    public final /* bridge */ /* synthetic */ void a(com.loc.fc fcVar, long j) {
        a2(fcVar, j);
    }

    @Override // com.loc.ez
    public final long b() {
        return com.loc.ew.g;
    }

    @Override // com.loc.ez
    public final /* synthetic */ java.lang.String b(com.loc.fc fcVar) {
        return a(fcVar);
    }

    @Override // com.loc.ez
    public final /* synthetic */ int c(com.loc.fc fcVar) {
        return b2(fcVar);
    }

    @Override // com.loc.ez
    public final long c() {
        return com.loc.ew.h;
    }

    @Override // com.loc.ez
    public final /* synthetic */ long d(com.loc.fc fcVar) {
        return c2(fcVar);
    }
}
