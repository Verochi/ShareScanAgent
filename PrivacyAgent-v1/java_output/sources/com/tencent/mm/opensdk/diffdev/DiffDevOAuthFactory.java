package com.tencent.mm.opensdk.diffdev;

/* loaded from: classes19.dex */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final java.lang.String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static com.tencent.mm.opensdk.diffdev.IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static com.tencent.mm.opensdk.diffdev.IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static com.tencent.mm.opensdk.diffdev.IDiffDevOAuth getDiffDevOAuth(int i) {
        com.tencent.mm.opensdk.utils.Log.v(TAG, "getDiffDevOAuth, version = " + i);
        if (i > 1) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "getDiffDevOAuth fail, unsupported version = " + i);
            return null;
        }
        if (i != 1) {
            return null;
        }
        if (v1Instance == null) {
            v1Instance = new com.tencent.mm.opensdk.diffdev.a.a();
        }
        return v1Instance;
    }
}
