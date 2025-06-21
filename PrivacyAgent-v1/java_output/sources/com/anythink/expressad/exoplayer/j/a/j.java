package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
final class j {
    private static final java.lang.String a = "exo_";
    private static final java.lang.String b = "exo_redir";
    private static final java.lang.String c = "exo_len";

    private j() {
    }

    public static long a(com.anythink.expressad.exoplayer.j.a.i iVar) {
        return iVar.a("exo_len");
    }

    private static void a(com.anythink.expressad.exoplayer.j.a.k kVar) {
        kVar.a("exo_len");
    }

    public static void a(com.anythink.expressad.exoplayer.j.a.k kVar, long j) {
        kVar.a("exo_len", j);
    }

    public static void a(com.anythink.expressad.exoplayer.j.a.k kVar, android.net.Uri uri) {
        kVar.a("exo_redir", uri.toString());
    }

    @androidx.annotation.Nullable
    private static android.net.Uri b(com.anythink.expressad.exoplayer.j.a.i iVar) {
        java.lang.String a2 = iVar.a("exo_redir", (java.lang.String) null);
        if (a2 == null) {
            return null;
        }
        return android.net.Uri.parse(a2);
    }

    private static void b(com.anythink.expressad.exoplayer.j.a.k kVar) {
        kVar.a("exo_redir");
    }
}
