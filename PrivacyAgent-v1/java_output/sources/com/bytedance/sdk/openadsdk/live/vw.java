package com.bytedance.sdk.openadsdk.live;

/* loaded from: classes22.dex */
public class vw {

    /* renamed from: com.bytedance.sdk.openadsdk.live.vw$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bytedance.android.openliveplugin.LivePluginHelper.initLiveCommerce();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean vw() {
        try {
            com.bytedance.sdk.openadsdk.yl.vw.vw().wg(new com.bytedance.sdk.openadsdk.live.vw.AnonymousClass1());
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vw(android.content.Context context, android.net.Uri uri) {
        if (context != null && uri != null) {
            try {
                com.bytedance.android.live.base.api.IOuterLiveService liveRoomService = com.bytedance.android.openliveplugin.LivePluginHelper.getLiveRoomService();
                if (liveRoomService != null) {
                    return liveRoomService.handleSchema(context, uri);
                }
                return false;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean vw(android.content.Context context, android.os.Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey(com.bytedance.sdk.openadsdk.live.TTLiveConstants.ROOMID_KEY)) {
            long j = bundle.getLong(com.bytedance.sdk.openadsdk.live.TTLiveConstants.ROOMID_KEY);
            try {
                com.bytedance.android.live.base.api.IOuterLiveService liveRoomService = com.bytedance.android.openliveplugin.LivePluginHelper.getLiveRoomService();
                if (liveRoomService == null) {
                    return false;
                }
                liveRoomService.enterLiveRoom(context, j, bundle);
                return true;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean vw(android.content.Context context, java.lang.String str, com.bytedance.android.live.base.api.ILiveHostContextParam.Builder builder, com.bytedance.android.live.base.api.ILiveInitCallback iLiveInitCallback, boolean z) {
        try {
            com.bytedance.android.openliveplugin.LivePluginHelper.initLive((android.app.Application) context, str, builder, iLiveInitCallback, z);
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
