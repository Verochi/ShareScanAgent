package com.bytedance.pangle.flipped;

/* loaded from: classes12.dex */
public final class b implements com.bytedance.pangle.flipped.c {
    @Override // com.bytedance.pangle.flipped.c
    @android.annotation.SuppressLint({"DiscouragedPrivateApi"})
    public final void invokeHiddenApiRestrictions() {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_FLIPPED, com.alipay.sdk.m.x.c.c);
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.class.getDeclaredMethod("getDeclaredMethod", java.lang.String.class, java.lang.Class[].class);
            java.lang.Class<?> cls = java.lang.Class.forName("dalvik.system.VMRuntime");
            java.lang.reflect.Method method = (java.lang.reflect.Method) declaredMethod.invoke(cls, "getRuntime", new java.lang.Class[0]);
            method.setAccessible(true);
            java.lang.Object invoke = method.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method method2 = (java.lang.reflect.Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new java.lang.Class[]{java.lang.String[].class});
            method2.setAccessible(true);
            method2.invoke(invoke, new java.lang.String[]{"L"});
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_FLIPPED, "V1 invokeHiddenApiRestrictions fail: " + android.util.Log.getStackTraceString(e));
            new java.lang.StringBuilder("V1 invokeHiddenApiRestrictions fail: ").append(android.util.Log.getStackTraceString(e));
        }
    }
}
