package com.getui.gtc.base.publish;

/* loaded from: classes22.dex */
public class Broker {

    public static class InstanceHolder {
        private static final com.getui.gtc.base.publish.Broker broker = new com.getui.gtc.base.publish.Broker(null);

        private InstanceHolder() {
        }
    }

    private Broker() {
    }

    public /* synthetic */ Broker(com.getui.gtc.base.publish.Broker.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gtc.base.publish.Broker getInstance() {
        return com.getui.gtc.base.publish.Broker.InstanceHolder.broker;
    }

    public android.os.Bundle publish(android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        com.getui.gtc.base.publish.Subscriber subscriber = null;
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(bundle.getString(com.getui.gtc.base.ProcessSwitchContract.CLASS_NAME)).getDeclaredMethod(bundle.getString(com.getui.gtc.base.ProcessSwitchContract.GET_INSTANCE), new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            subscriber = (com.getui.gtc.base.publish.Subscriber) declaredMethod.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            bundle2.putSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION, th);
        }
        if (subscriber != null) {
            subscriber.receive(bundle, bundle2);
        }
        return bundle2;
    }

    public android.os.Bundle subscribe(android.os.Bundle bundle) {
        if (com.getui.gtc.base.GtcProvider.context() == null) {
            throw new java.lang.RuntimeException("if you are running at not gtc Process, you should call \"GtcProvider.setContext(context)\" firstly!");
        }
        android.os.Bundle call = com.getui.gtc.base.GtcProvider.context().getContentResolver().call(android.net.Uri.parse("content://" + com.getui.gtc.base.GtcProvider.context().getPackageName() + ".getui.gtc.provider"), "", "", bundle);
        if (call != null) {
            call.setClassLoader(getClass().getClassLoader());
        }
        return call;
    }
}
