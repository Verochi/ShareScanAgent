package com.getui.gs.a;

/* loaded from: classes22.dex */
public final class d {
    public static int a = 0;
    private static android.content.Context b = null;
    private static java.lang.String c = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9PkwyShdEmTYQE+KFGBlkzQLIzZlsHsltb6ROW96w18U+YTBcoQ6cDxKMHc1c1fbqHM2b2LRrC9q78ZaC4MeYXzFRl2MYU3d+0Qz++xiv31Y+idvmHUN2MXrmo5cfvuwI65t6F883fehNstbdCW2QFDS3jXkrY4DinRf4VGokdwIDAQAB";
    private static java.lang.String d = "6f4f57c3777e3f4364f440e72b26ff2e";
    private static java.lang.String e = "";
    private static volatile java.lang.String f = "";
    private static java.lang.String g = "";
    private static java.lang.String h = "";
    private static java.lang.String i = "";
    private static int j = -1;
    private static java.lang.String k = "";

    public static android.content.Context a() {
        return b;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v14 java.lang.String, still in use, count: 2, list:
          (r3v14 java.lang.String) from 0x007a: INVOKE (r3v14 java.lang.String) STATIC call: android.text.TextUtils.isEmpty(java.lang.CharSequence):boolean A[MD:(java.lang.CharSequence):boolean (c), WRAPPED]
          (r3v14 java.lang.String) from 0x0071: PHI (r3v21 java.lang.String) = (r3v14 java.lang.String) binds: [B:47:0x007e] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:125)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public static void a(android.content.Context r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gs.a.d.a(android.content.Context):void");
    }

    public static void a(java.lang.String str) {
        f = str;
    }

    public static java.lang.String b() {
        return c;
    }

    public static java.lang.String c() {
        return d;
    }

    public static java.lang.String d() {
        java.lang.String str = e;
        return str == null ? "" : str;
    }

    public static java.lang.String e() {
        java.lang.String str = f;
        return str == null ? "" : str;
    }

    public static java.lang.String f() {
        java.lang.String str = i;
        return str == null ? "" : str;
    }

    public static java.lang.String g() {
        java.lang.String str = h;
        return str == null ? "" : str;
    }

    public static java.lang.String h() {
        java.lang.String str = g;
        return str == null ? "" : str;
    }

    public static java.lang.String i() {
        java.lang.String str = "GSIDO-1.4.6.2";
        if (!android.text.TextUtils.isEmpty(k)) {
            str = "GSIDO-1.4.6.2," + k;
        }
        return str == null ? "" : str;
    }

    public static int j() {
        return j;
    }
}
