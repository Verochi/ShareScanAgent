package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public class e implements java.lang.Runnable {
    static final /* synthetic */ boolean a = true;
    private final int b;
    private final java.lang.Object[] c;

    public e(int i) {
        this.b = i;
        this.c = null;
    }

    public e(int i, java.lang.Object[] objArr) {
        this.b = i;
        this.c = objArr;
    }

    public final boolean a() {
        int i = this.b;
        if (i == 451 || i == 452) {
            return com.uc.crashsdk.e.b(i, this.c);
        }
        switch (i) {
            case 351:
            case 352:
            case 353:
            case 354:
                return com.uc.crashsdk.a.h.b(i, this.c);
            default:
                switch (i) {
                    case 751:
                    case 752:
                    case 753:
                    case 754:
                    case 755:
                    case 756:
                        return com.uc.crashsdk.f.a(i, this.c);
                    default:
                        com.uc.crashsdk.a.a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (a) {
                            return false;
                        }
                        throw new java.lang.AssertionError();
                }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.b;
        if (i == 10) {
            com.uc.crashsdk.a.f.a(i, this.c);
            return;
        }
        if (i == 500) {
            com.uc.crashsdk.a.d.a(i);
            return;
        }
        if (i == 700) {
            com.uc.crashsdk.f.b(i);
            return;
        }
        if (i == 800) {
            com.uc.crashsdk.a.g.a(i);
            return;
        }
        if (i == 201 || i == 202) {
            com.uc.crashsdk.a.a(i);
            return;
        }
        switch (i) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                com.uc.crashsdk.b.a(i);
                return;
            default:
                switch (i) {
                    case 301:
                    case 302:
                    case 303:
                        com.uc.crashsdk.a.h.a(i, this.c);
                        return;
                    default:
                        switch (i) {
                            case 401:
                            case 402:
                            case 403:
                                break;
                            default:
                                switch (i) {
                                    case 405:
                                    case 406:
                                    case 407:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_CODE /* 411 */:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                    case com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                    case 416:
                                        break;
                                    default:
                                        com.uc.crashsdk.a.a.d("crashsdk", "Unknown async runnable: " + toString());
                                        if (!a) {
                                            throw new java.lang.AssertionError();
                                        }
                                        return;
                                }
                        }
                        com.uc.crashsdk.e.a(i, this.c);
                        return;
                }
        }
    }

    public java.lang.String toString() {
        return super.toString() + "@action_" + this.b;
    }
}
