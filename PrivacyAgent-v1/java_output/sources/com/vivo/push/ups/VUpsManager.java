package com.vivo.push.ups;

/* loaded from: classes19.dex */
public class VUpsManager {

    public static class a {
        private static com.vivo.push.ups.VUpsManager a = new com.vivo.push.ups.VUpsManager();
    }

    public static com.vivo.push.ups.VUpsManager getInstance() {
        return com.vivo.push.ups.VUpsManager.a.a;
    }

    public void onCommandResult(android.content.Context context, android.os.Bundle bundle) {
    }

    public void registerToken(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.vivo.push.ups.UPSRegisterCallback uPSRegisterCallback) {
        com.vivo.push.PushClient.getInstance(context).turnOnPush(new com.vivo.push.ups.a(this, uPSRegisterCallback, context));
    }

    public void turnOffPush(android.content.Context context, com.vivo.push.ups.UPSTurnCallback uPSTurnCallback) {
        com.vivo.push.PushClient.getInstance(context).turnOffPush(new com.vivo.push.ups.d(this, uPSTurnCallback));
    }

    public void turnOnPush(android.content.Context context, com.vivo.push.ups.UPSTurnCallback uPSTurnCallback) {
        com.vivo.push.PushClient.getInstance(context).turnOnPush(new com.vivo.push.ups.c(this, uPSTurnCallback));
    }

    public void unRegisterToken(android.content.Context context, com.vivo.push.ups.UPSRegisterCallback uPSRegisterCallback) {
        com.vivo.push.PushClient.getInstance(context).turnOffPush(new com.vivo.push.ups.b(this, uPSRegisterCallback));
    }
}
