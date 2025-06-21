package com.getui.gtc.b;

/* loaded from: classes22.dex */
public final class b {

    /* renamed from: com.getui.gtc.b.b$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.api.GtcIdCallback.Stub {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass1(android.content.Context context, java.lang.String str, int i, java.lang.String str2) {
            this.a = context;
            this.b = str;
            this.c = i;
            this.d = str2;
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public final void onFailure(java.lang.String str) {
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public final void onSuccess(java.lang.String str) {
            android.content.Context context = this.a;
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    com.getui.gtc.h.c.a.a("send cid broadcast fail,cid is null");
                } else {
                    android.content.Intent intent = new android.content.Intent();
                    intent.setAction(context.getPackageName());
                    intent.putExtra("gicid", str);
                    context.sendBroadcast(intent);
                }
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.d(e);
            }
            android.content.Context context2 = this.a;
            java.lang.String str2 = this.b;
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    com.getui.gtc.h.c.a.a("send gicid broadcast fail,cid is null");
                } else {
                    android.content.Intent intent2 = new android.content.Intent();
                    intent2.setPackage(context2.getPackageName());
                    intent2.setAction(str2);
                    intent2.putExtra("gicid", str);
                    context2.sendBroadcast(intent2);
                }
            } catch (java.lang.Exception e2) {
                com.getui.gtc.h.c.a.d(e2);
            }
            com.getui.gtc.api.GtcManager.getInstance().loadSdk(new com.getui.gtc.api.SdkInfo.Builder().moduleName("SDKID:" + this.c).appid(this.d).version(this.b).cid(str).build());
        }
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            java.lang.reflect.Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            java.lang.reflect.AccessibleObject.setAccessible(declaredConstructors, true);
            java.lang.reflect.Constructor<?> constructor = declaredConstructors[0];
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("getSdkVersion", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(constructor.newInstance(new java.lang.Object[0]), new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.d(" getSdkVersion error : " + th.toString());
            return null;
        }
    }

    public static int b(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            java.lang.reflect.Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            java.lang.reflect.AccessibleObject.setAccessible(declaredConstructors, true);
            java.lang.reflect.Constructor<?> constructor = declaredConstructors[0];
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("getSdkId", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return ((java.lang.Integer) declaredMethod.invoke(constructor.newInstance(new java.lang.Object[0]), new java.lang.Object[0])).intValue();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.d(" getSDKId error : " + th.toString());
            return 0;
        }
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            java.lang.reflect.Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            java.lang.reflect.AccessibleObject.setAccessible(declaredConstructors, true);
            java.lang.reflect.Constructor<?> constructor = declaredConstructors[0];
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("getSdkAppId", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(constructor.newInstance(new java.lang.Object[0]), new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.d(" getAppId error : " + th.toString());
            return null;
        }
    }
}
