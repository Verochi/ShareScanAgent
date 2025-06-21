package com.bytedance.pangle.activity;

/* loaded from: classes12.dex */
final class c {
    private static java.lang.Class a() {
        java.lang.Class<?> cls = null;
        for (java.lang.Class<?> cls2 : android.app.Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void a(android.app.Activity activity) {
        try {
            com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(android.app.Activity.class, "convertToTranslucent", a(), android.app.ActivityOptions.class).invoke(activity, null, com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(android.app.Activity.class, "getActivityOptions", new java.lang.Class[0]).invoke(activity, new java.lang.Object[0]));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.app.Activity activity, android.view.View view) {
        java.lang.Object readField;
        if (view == null) {
            return;
        }
        try {
            java.lang.Object readField2 = com.bytedance.pangle.util.FieldUtils.readField(view, "mListenerInfo");
            if (readField2 != null && (readField = com.bytedance.pangle.util.FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                java.lang.String name = readField.getClass().getName();
                if (name.startsWith(androidx.appcompat.app.AppCompatViewInflater.class.getName()) || name.startsWith(android.view.View.class.getName())) {
                    view.setOnClickListener(new com.bytedance.pangle.activity.a(activity, view.getId(), (java.lang.String) com.bytedance.pangle.util.FieldUtils.readField(readField, "mMethodName")));
                }
            }
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(java.lang.String.valueOf(view)));
            e.printStackTrace();
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    public static void a(com.bytedance.pangle.activity.b bVar, android.content.Context context) {
        if (!com.bytedance.pangle.Zeus.hasInit()) {
            bVar.zeusSuperAttachBaseContext(context);
            return;
        }
        java.lang.String pluginPkgName = bVar.getPluginPkgName();
        boolean loadPlugin = com.bytedance.pangle.plugin.PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            bVar.setPlugin(com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(pluginPkgName));
            if (!loadPlugin) {
                bVar.zeusSuperAttachBaseContext(context);
            } else {
                bVar.zeusSuperAttachBaseContext(com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                com.bytedance.pangle.util.FieldUtils.writeField(bVar, "mResources", (java.lang.Object) null);
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(com.bytedance.pangle.activity.b bVar, android.os.Bundle bundle) {
        java.util.List<java.lang.String> list;
        if (!com.bytedance.pangle.Zeus.hasInit()) {
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        android.content.Intent intent = bVar.getIntent();
        java.lang.String pluginPkgName = bVar.getPluginPkgName();
        com.bytedance.pangle.plugin.Plugin plugin = bVar.getPlugin();
        if (plugin == null) {
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        com.bytedance.pangle.activity.IntentUtils.a(intent);
        java.lang.String stringExtra = intent.getStringExtra("targetPlugin");
        if (android.text.TextUtils.isEmpty(stringExtra) && (list = com.bytedance.pangle.ComponentManager.stubActivity2TargetActivities.get(bVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (!plugin.isLoaded() || android.text.TextUtils.isEmpty(stringExtra)) {
            try {
                bVar.zeusSuperOnCreate(null);
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                bVar.finish();
                return;
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        android.content.pm.ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
        }
        int i = -1;
        try {
            com.bytedance.pangle.activity.IPluginActivity iPluginActivity = (com.bytedance.pangle.activity.IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            com.bytedance.pangle.util.FieldUtils.writeField(iPluginActivity, "mApplication", bVar.getApplication());
            bVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(bVar, plugin);
            i = activityInfo.theme;
            bVar.zeusSuperSetTheme(i);
            android.content.res.TypedArray obtainStyledAttributes = ((android.app.Activity) bVar).getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
            if (obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(0), false)) {
                a((android.app.Activity) bVar);
            }
            obtainStyledAttributes.recycle();
            iPluginActivity.attachBaseContext(bVar.getBaseContext());
            try {
                int requestedOrientation = ((android.app.Activity) bVar).getRequestedOrientation();
                int i2 = activityInfo.screenOrientation;
                if (requestedOrientation != i2) {
                    ((android.app.Activity) bVar).setRequestedOrientation(i2);
                }
            } catch (java.lang.IllegalStateException unused) {
            }
            iPluginActivity.onCreate(bundle);
        } catch (java.lang.Exception e2) {
            throw new java.lang.RuntimeException(e2 instanceof java.lang.IllegalStateException ? "activityTheme:".concat(java.lang.String.valueOf(i)) : "", e2);
        }
    }
}
