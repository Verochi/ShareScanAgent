package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class i implements com.anythink.expressad.exoplayer.a.b {
    private static final java.lang.String a = "EventLogger";
    private static final int b = 3;
    private static final java.text.NumberFormat c;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.i.e d;
    private final com.anythink.expressad.exoplayer.ae.b e = new com.anythink.expressad.exoplayer.ae.b();
    private final com.anythink.expressad.exoplayer.ae.a f = new com.anythink.expressad.exoplayer.ae.a();
    private final long g = android.os.SystemClock.elapsedRealtime();

    static {
        java.text.NumberFormat numberFormat = java.text.NumberFormat.getInstance(java.util.Locale.US);
        c = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    private i(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.i.e eVar) {
        this.d = eVar;
    }

    private static java.lang.String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    private static java.lang.String a(int i, int i2) {
        return i < 2 ? "N/A" : i2 != 0 ? i2 != 8 ? i2 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    private static java.lang.String a(long j) {
        return j == -9223372036854775807L ? "?" : c.format(j / 1000.0f);
    }

    private static java.lang.String a(com.anythink.expressad.exoplayer.i.f fVar, com.anythink.expressad.exoplayer.h.ae aeVar, int i) {
        return a((fVar == null || fVar.f() != aeVar || fVar.c(i) == -1) ? false : true);
    }

    private static java.lang.String a(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    private void a(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.String str) {
        b(aVar, str);
    }

    private void a(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.String str, java.lang.Exception exc) {
        a(aVar, "internalError", str, exc);
    }

    private void a(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.String str, java.lang.String str2) {
        b(aVar, str, str2);
    }

    private void a(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a(b(aVar, str, str2), th);
    }

    private void a(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.String str, java.lang.Throwable th) {
        a(b(aVar, str), th);
    }

    private static void a(com.anythink.expressad.exoplayer.g.a aVar, java.lang.String str) {
        for (int i = 0; i < aVar.a(); i++) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(aVar.a(i));
        }
    }

    private static void a(java.lang.String str) {
    }

    private static void a(java.lang.String str, java.lang.Throwable th) {
    }

    private static java.lang.String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_DRM" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    private java.lang.String b(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.String str) {
        return str + " [" + i(aVar) + "]";
    }

    private java.lang.String b(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.String str, java.lang.String str2) {
        return str + " [" + i(aVar) + ", " + str2 + "]";
    }

    private static java.lang.String c(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "?" : org.apache.commons.codec.language.bm.Rule.ALL : "ONE" : "OFF";
    }

    private static java.lang.String d(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    private static java.lang.String e(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "?" : "DYNAMIC" : "RESET" : "PREPARED";
    }

    private static java.lang.String f(int i) {
        if (i == 0) {
            return "default";
        }
        if (i == 1) {
            return "audio";
        }
        if (i == 2) {
            return "video";
        }
        if (i == 3) {
            return "text";
        }
        if (i == 4) {
            return "metadata";
        }
        if (i == 5) {
            return "none";
        }
        if (i < 10000) {
            return "?";
        }
        return "custom (" + i + ")";
    }

    private java.lang.String i(com.anythink.expressad.exoplayer.a.b.a aVar) {
        java.lang.String str = "window=" + aVar.c;
        if (aVar.d != null) {
            str = str + ", period=" + aVar.d.a;
            if (aVar.d.a()) {
                str = (str + ", adGroup=" + aVar.d.b) + ", ad=" + aVar.d.c;
            }
        }
        return a(aVar.a - this.g) + ", " + a(aVar.f) + ", " + str;
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "seekStarted");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, int i) {
        int c2 = aVar.b.c();
        int b2 = aVar.b.b();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("timelineChanged [");
        sb.append(i(aVar));
        sb.append(", periodCount=");
        sb.append(c2);
        sb.append(", windowCount=");
        sb.append(b2);
        sb.append(", reason=");
        sb.append(i != 0 ? i != 1 ? i != 2 ? "?" : "DYNAMIC" : "RESET" : "PREPARED");
        for (int i2 = 0; i2 < java.lang.Math.min(c2, 3); i2++) {
            aVar.b.a(i2, this.f, false);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("  period [");
            sb2.append(a(com.anythink.expressad.exoplayer.b.a(this.f.d)));
            sb2.append("]");
        }
        for (int i3 = 0; i3 < java.lang.Math.min(b2, 3); i3++) {
            aVar.b.a(i3, this.e, false);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder("  window [");
            sb3.append(a(com.anythink.expressad.exoplayer.b.a(this.e.i)));
            sb3.append(", ");
            sb3.append(this.e.d);
            sb3.append(", ");
            sb3.append(this.e.e);
            sb3.append("]");
        }
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, int i, int i2) {
        a(aVar, "viewportSizeChanged", i + ", " + i2);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, int i, long j, long j2) {
        a(aVar, "audioTrackUnderrun", i + ", " + j + ", " + j2 + "]", (java.lang.Throwable) null);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, int i, com.anythink.expressad.exoplayer.m mVar) {
        a(aVar, "decoderInputFormatChanged", f(i) + ", " + com.anythink.expressad.exoplayer.m.c(mVar));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, int i, java.lang.String str) {
        a(aVar, "decoderInitialized", f(i) + ", " + str);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, @androidx.annotation.Nullable android.net.NetworkInfo networkInfo) {
        a(aVar, "networkTypeChanged", networkInfo == null ? "none" : networkInfo.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, android.view.Surface surface) {
        a(aVar, "renderedFirstFrame", surface.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, com.anythink.expressad.exoplayer.g.a aVar2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("metadata [");
        sb.append(i(aVar));
        sb.append(", ");
        a(aVar2, "  ");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, com.anythink.expressad.exoplayer.g gVar) {
        a(b(aVar, "playerFailed"), gVar);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
        a(aVar, "downstreamFormatChanged", com.anythink.expressad.exoplayer.m.c(cVar.c));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, com.anythink.expressad.exoplayer.i.g gVar) {
        int i;
        com.anythink.expressad.exoplayer.i.e eVar = this.d;
        com.anythink.expressad.exoplayer.i.e.a a2 = eVar != null ? eVar.a() : null;
        if (a2 == null) {
            a(aVar, "tracksChanged", "[]");
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("tracksChanged [");
        sb.append(i(aVar));
        sb.append(", ");
        int a3 = a2.a();
        int i2 = 0;
        while (i2 < a3) {
            com.anythink.expressad.exoplayer.h.af b2 = a2.b(i2);
            com.anythink.expressad.exoplayer.i.f a4 = gVar.a(i2);
            if (b2.b > 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("  Renderer:");
                sb2.append(i2);
                sb2.append(" [");
                int i3 = 0;
                while (i3 < b2.b) {
                    com.anythink.expressad.exoplayer.h.ae a5 = b2.a(i3);
                    int i4 = a5.a;
                    int a6 = a2.a(i2, i3);
                    int i5 = a3;
                    java.lang.String str = i4 < 2 ? "N/A" : a6 != 0 ? a6 != 8 ? a6 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder("    Group:");
                    sb3.append(i3);
                    sb3.append(", adaptive_supported=");
                    sb3.append(str);
                    sb3.append(" [");
                    int i6 = 0;
                    while (i6 < a5.a) {
                        java.lang.String a7 = a((a4 == null || a4.f() != a5 || a4.c(i6) == -1) ? false : true);
                        java.lang.String b3 = b(a2.a(i2, i3, i6));
                        com.anythink.expressad.exoplayer.h.af afVar = b2;
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder("      ");
                        sb4.append(a7);
                        sb4.append(" Track:");
                        sb4.append(i6);
                        sb4.append(", ");
                        sb4.append(com.anythink.expressad.exoplayer.m.c(a5.a(i6)));
                        sb4.append(", supported=");
                        sb4.append(b3);
                        i6++;
                        b2 = afVar;
                    }
                    i3++;
                    a3 = i5;
                }
                i = a3;
                if (a4 != null) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= a4.g()) {
                            break;
                        }
                        com.anythink.expressad.exoplayer.g.a aVar2 = a4.a(i7).f;
                        if (aVar2 != null) {
                            a(aVar2, "      ");
                            break;
                        }
                        i7++;
                    }
                }
            } else {
                i = a3;
            }
            i2++;
            a3 = i;
        }
        com.anythink.expressad.exoplayer.h.af b4 = a2.b();
        if (b4.b > 0) {
            for (int i8 = 0; i8 < b4.b; i8++) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder("    Group:");
                sb5.append(i8);
                sb5.append(" [");
                com.anythink.expressad.exoplayer.h.ae a8 = b4.a(i8);
                for (int i9 = 0; i9 < a8.a; i9++) {
                    java.lang.String a9 = a(false);
                    java.lang.String b5 = b(0);
                    java.lang.StringBuilder sb6 = new java.lang.StringBuilder("      ");
                    sb6.append(a9);
                    sb6.append(" Track:");
                    sb6.append(i9);
                    sb6.append(", ");
                    sb6.append(com.anythink.expressad.exoplayer.m.c(a8.a(i9)));
                    sb6.append(", supported=");
                    sb6.append(b5);
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, com.anythink.expressad.exoplayer.v vVar) {
        a(aVar, "playbackParameters", com.anythink.expressad.exoplayer.k.af.a("speed=%.2f, pitch=%.2f, skipSilence=%s", java.lang.Float.valueOf(vVar.b), java.lang.Float.valueOf(vVar.c), java.lang.Boolean.valueOf(vVar.d)));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, java.io.IOException iOException) {
        a(aVar, "loadError", (java.lang.Exception) iOException);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, java.lang.Exception exc) {
        a(aVar, "drmSessionManagerError", exc);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, boolean z) {
        a(aVar, "shuffleModeEnabled", java.lang.Boolean.toString(z));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(com.anythink.expressad.exoplayer.a.b.a aVar, boolean z, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(z);
        sb.append(", ");
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE");
        a(aVar, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, sb.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "seekProcessed");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(com.anythink.expressad.exoplayer.a.b.a aVar, int i) {
        a(aVar, "positionDiscontinuity", i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(com.anythink.expressad.exoplayer.a.b.a aVar, int i, int i2) {
        a(aVar, "videoSizeChanged", i + ", " + i2);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(com.anythink.expressad.exoplayer.a.b.a aVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
        a(aVar, "upstreamDiscarded", com.anythink.expressad.exoplayer.m.c(cVar.c));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(com.anythink.expressad.exoplayer.a.b.a aVar, boolean z) {
        a(aVar, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.e, java.lang.Boolean.toString(z));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "mediaPeriodCreated");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c(com.anythink.expressad.exoplayer.a.b.a aVar, int i) {
        a(aVar, "repeatMode", i != 0 ? i != 1 ? i != 2 ? "?" : org.apache.commons.codec.language.bm.Rule.ALL : "ONE" : "OFF");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "mediaPeriodReleased");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d(com.anythink.expressad.exoplayer.a.b.a aVar, int i) {
        a(aVar, "decoderEnabled", f(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void e(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "mediaPeriodReadingStarted");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void e(com.anythink.expressad.exoplayer.a.b.a aVar, int i) {
        a(aVar, "decoderDisabled", f(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void f(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "drmKeysLoaded");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void f(com.anythink.expressad.exoplayer.a.b.a aVar, int i) {
        a(aVar, "audioSessionId", java.lang.Integer.toString(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void g(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "drmKeysRestored");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void g(com.anythink.expressad.exoplayer.a.b.a aVar, int i) {
        a(aVar, "droppedFrames", java.lang.Integer.toString(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void h(com.anythink.expressad.exoplayer.a.b.a aVar) {
        a(aVar, "drmKeysRemoved");
    }
}
