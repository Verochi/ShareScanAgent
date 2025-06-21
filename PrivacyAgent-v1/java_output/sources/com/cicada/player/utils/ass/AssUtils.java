package com.cicada.player.utils.ass;

/* loaded from: classes22.dex */
public class AssUtils {
    static {
        com.aliyun.utils.f.f();
    }

    public static void loadClass() {
    }

    private static native java.lang.Object nParseAssDialogue(java.lang.Object obj, java.lang.String str);

    private static native java.lang.Object nParseAssHeader(java.lang.String str);

    public static com.cicada.player.utils.ass.AssDialogue parseAssDialogue(com.cicada.player.utils.ass.AssHeader assHeader, java.lang.String str) {
        return !com.aliyun.utils.f.b() ? new com.cicada.player.utils.ass.AssDialogue() : (com.cicada.player.utils.ass.AssDialogue) nParseAssDialogue(assHeader, str);
    }

    public static com.cicada.player.utils.ass.AssHeader parseAssHeader(java.lang.String str) {
        return !com.aliyun.utils.f.b() ? new com.cicada.player.utils.ass.AssHeader() : (com.cicada.player.utils.ass.AssHeader) nParseAssHeader(str);
    }
}
