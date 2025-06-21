package com.bytedance.pangle.flipped;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class FlippedV2Impl implements com.bytedance.pangle.flipped.c {
    private static final java.lang.String TAG = "FlippedV2Impl";

    static {
        java.lang.System.loadLibrary("pangleflipped");
    }

    private native java.lang.reflect.Method getDeclaredMethod(java.lang.Object obj, java.lang.String str, java.lang.Class<?>[] clsArr);

    @Override // com.bytedance.pangle.flipped.c
    public void invokeHiddenApiRestrictions() {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_FLIPPED, com.alipay.sdk.m.x.c.d);
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("dalvik.system.VMRuntime");
            java.lang.reflect.Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new java.lang.Class[]{java.lang.String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(invoke, new java.lang.String[]{"L"});
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_FLIPPED, "V2 invokeHiddenApiRestrictions fail: " + android.util.Log.getStackTraceString(e));
            new java.lang.StringBuilder("V2 invokeHiddenApiRestrictions fail: ").append(android.util.Log.getStackTraceString(e));
        }
    }
}
