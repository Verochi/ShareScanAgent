package com.igexin.sdk.router;

/* loaded from: classes23.dex */
public class TransferGtcProcess implements com.getui.gtc.base.publish.Subscriber {
    public static final java.lang.String POPUACTION_METHODNAME = "checkTopActivityInfo";
    public static final java.lang.String TYPE145TASK_METHODNAME = "runInGtMainProcess";
    private static java.lang.String methodName;

    public static class a {
        private static final com.igexin.sdk.router.TransferGtcProcess a = new com.igexin.sdk.router.TransferGtcProcess();

        private a() {
        }
    }

    private android.os.Bundle createBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    public static com.igexin.sdk.router.TransferGtcProcess getInstance() {
        methodName = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
        return com.igexin.sdk.router.TransferGtcProcess.a.a;
    }

    @Override // com.getui.gtc.base.publish.Subscriber
    public void receive(android.os.Bundle bundle, android.os.Bundle bundle2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.Throwable th = (java.lang.Throwable) bundle2.getSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION);
            if (th != null) {
                arrayList.add(th);
            }
            java.lang.String string = bundle.getString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME);
            if (android.text.TextUtils.isEmpty(string)) {
                throw new java.lang.RuntimeException("methodName missed");
            }
            if (TYPE145TASK_METHODNAME.equals(string)) {
                android.content.Intent intent = (android.content.Intent) bundle.getParcelable(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                com.igexin.push.g.g.a();
                com.igexin.push.g.g.a(com.getui.gtc.base.GtcProvider.context(), intent);
            }
            if (POPUACTION_METHODNAME.equals(string)) {
                new com.igexin.push.core.a.c.h();
                bundle2.putSerializable("map", com.igexin.push.core.a.c.h.a(com.getui.gtc.base.GtcProvider.context()));
            }
        } catch (java.lang.Throwable th2) {
            try {
                arrayList.add(th2);
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.igexin.c.a.c.a.a((java.lang.Throwable) it.next());
                }
            } finally {
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.igexin.c.a.c.a.a((java.lang.Throwable) it2.next());
                }
            }
        }
    }

    public android.os.Bundle transferGtcProcess(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        com.getui.gtc.base.GtcProvider.setContext(context);
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, str);
        createBundle.putParcelable(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        return com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
    }
}
