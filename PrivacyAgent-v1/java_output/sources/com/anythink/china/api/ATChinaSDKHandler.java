package com.anythink.china.api;

/* loaded from: classes12.dex */
public class ATChinaSDKHandler {
    private static boolean allowUserOaidSDK = true;

    /* renamed from: com.anythink.china.api.ATChinaSDKHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bun.miitmdid.interfaces.IIdentifierListener {
        final /* synthetic */ com.anythink.china.api.OaidSDKCallbackListener val$oaidSDKListener;

        public AnonymousClass1(com.anythink.china.api.OaidSDKCallbackListener oaidSDKCallbackListener) {
            this.val$oaidSDKListener = oaidSDKCallbackListener;
        }

        public void OnSupport(boolean z, com.bun.miitmdid.interfaces.IdSupplier idSupplier) {
            com.anythink.china.api.OaidSDKCallbackListener oaidSDKCallbackListener = this.val$oaidSDKListener;
            if (oaidSDKCallbackListener != null) {
                oaidSDKCallbackListener.OnSupport(z, idSupplier);
            }
        }

        public void onSupport(com.bun.miitmdid.interfaces.IdSupplier idSupplier) {
            com.anythink.china.api.OaidSDKCallbackListener oaidSDKCallbackListener = this.val$oaidSDKListener;
            if (oaidSDKCallbackListener != null) {
                oaidSDKCallbackListener.onSupport(idSupplier);
            }
        }
    }

    public static void handleInitOaidSDK(android.content.Context context, com.anythink.china.api.OaidSDKCallbackListener oaidSDKCallbackListener) {
        try {
            if (allowUserOaidSDK) {
                com.bun.miitmdid.core.MdidSdkHelper.InitSdk(context.getApplicationContext(), true, (com.bun.miitmdid.interfaces.IIdentifierListener) new com.anythink.china.api.ATChinaSDKHandler.AnonymousClass1(oaidSDKCallbackListener));
            } else if (oaidSDKCallbackListener != null) {
                oaidSDKCallbackListener.OnSupport(false, null);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void requestPermissionIfNecessary(android.content.Context context) {
        java.lang.String[] strArr = {com.anythink.china.common.d.a, com.anythink.china.common.d.b};
        if (context == null || android.os.Build.VERSION.SDK_INT < 23) {
            return;
        }
        int nextInt = new java.util.Random().nextInt(com.airbnb.lottie.utils.Utils.SECOND_IN_NANOS);
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.anythink.china.activity.TransparentActivity.class);
        intent.putExtra("type", 1000);
        intent.putExtra(com.anythink.china.activity.TransparentActivity.b, nextInt);
        intent.putExtra(com.anythink.china.activity.TransparentActivity.d, strArr);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void setAllowUseMdidSDK(boolean z) {
        allowUserOaidSDK = z;
    }
}
