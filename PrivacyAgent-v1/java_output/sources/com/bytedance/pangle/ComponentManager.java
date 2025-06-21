package com.bytedance.pangle;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class ComponentManager {
    public static java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> stubActivity2TargetActivities = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.String, java.lang.String> targetString2StubActivity = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.String, java.lang.String> targetString2PluginPkgName = new java.util.HashMap<>();

    public static java.lang.String getTargetStubActivityString(java.lang.String str) {
        return targetString2StubActivity.get(str);
    }

    private static boolean isSupportLibIso(java.lang.String str) {
        try {
            return com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str).mIsSupportLibIso;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static void realStartActivity(java.lang.Object obj, android.content.Context context, android.content.Intent intent, android.os.Bundle bundle, java.lang.String str) {
        if (context instanceof com.bytedance.pangle.PluginContext) {
            context = ((com.bytedance.pangle.PluginContext) context).mOriginContext;
        }
        if (intent.getComponent() != null) {
            java.lang.String className = intent.getComponent().getClassName();
            com.bytedance.pangle.Zeus.loadPlugin(str);
            java.lang.String targetStubActivityString = getTargetStubActivityString(className);
            if (!android.text.TextUtils.isEmpty(targetStubActivityString)) {
                com.bytedance.pangle.activity.IntentUtils.a(intent, str);
                intent.setComponent(new android.content.ComponentName(context, targetStubActivityString));
                intent.putExtra("targetPlugin", className);
            }
        }
        try {
            if (!isSupportLibIso(str) && (obj instanceof androidx.fragment.app.Fragment)) {
                ((androidx.fragment.app.Fragment) obj).startActivity(intent, bundle);
            } else if (obj instanceof android.app.Fragment) {
                ((android.app.Fragment) obj).startActivity(intent, bundle);
            } else {
                context.startActivity(intent, bundle);
            }
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException("component = " + intent.getComponent(), th);
        }
    }

    private static void realStartActivityForResult(java.lang.Object obj, android.app.Activity activity, android.content.Intent intent, int i, android.os.Bundle bundle, java.lang.String str) {
        if (intent.getComponent() != null) {
            java.lang.String className = intent.getComponent().getClassName();
            com.bytedance.pangle.Zeus.loadPlugin(str);
            java.lang.String targetStubActivityString = getTargetStubActivityString(className);
            if (!android.text.TextUtils.isEmpty(targetStubActivityString)) {
                com.bytedance.pangle.activity.IntentUtils.a(intent, str);
                intent.setComponent(new android.content.ComponentName(activity, targetStubActivityString));
                intent.putExtra("targetPlugin", className);
            }
        }
        try {
            if (!isSupportLibIso(str) && (obj instanceof androidx.fragment.app.Fragment)) {
                ((androidx.fragment.app.Fragment) obj).startActivityForResult(intent, i, bundle);
            } else if (obj instanceof android.app.Fragment) {
                ((android.app.Fragment) obj).startActivityForResult(intent, i, bundle);
            } else {
                activity.startActivityForResult(intent, i, bundle);
            }
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException("component =  " + intent.getComponent(), th);
        }
    }

    public static void registerActivity(java.lang.String str, java.lang.String str2, java.lang.String... strArr) {
        if (strArr != null) {
            for (java.lang.String str3 : strArr) {
                java.util.List<java.lang.String> list = stubActivity2TargetActivities.get(str2);
                if (list == null) {
                    list = new java.util.ArrayList<>();
                    stubActivity2TargetActivities.put(str2, list);
                }
                list.add(str3);
                targetString2StubActivity.put(str3, str2);
                targetString2PluginPkgName.put(str3, str);
            }
        }
    }

    public static android.content.Intent registerReceiver(android.content.Context context, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, int i, java.lang.String str) {
        int i2;
        android.content.Intent registerReceiver;
        android.content.Intent registerReceiver2;
        com.bytedance.pangle.Zeus.loadPlugin(str);
        com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i2 = android.os.Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i2 < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                return context.registerReceiver(null, intentFilter);
            }
            registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
            return registerReceiver2;
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        registerReceiver = context.registerReceiver(aVar, intentFilter, i);
        a.b.put(pluginBroadcastReceiver, aVar);
        a.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public static android.content.Intent registerReceiver(android.content.Context context, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str) {
        android.content.Intent registerReceiver;
        com.bytedance.pangle.Zeus.loadPlugin(str);
        com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (android.os.Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                return context.registerReceiver(null, intentFilter);
            }
            registerReceiver = context.registerReceiver(null, intentFilter, 2);
            return registerReceiver;
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        android.content.Intent registerReceiver2 = (android.os.Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) ? context.registerReceiver(aVar, intentFilter) : context.registerReceiver(aVar, intentFilter, 2);
        a.b.put(pluginBroadcastReceiver, aVar);
        a.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver2;
    }

    public static android.content.Intent registerReceiver(android.content.Context context, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str, android.os.Handler handler, int i, java.lang.String str2) {
        int i2;
        android.content.Intent registerReceiver;
        android.content.Intent registerReceiver2;
        com.bytedance.pangle.Zeus.loadPlugin(str2);
        com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null || (i2 = android.os.Build.VERSION.SDK_INT) < 26) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (i2 < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                return context.registerReceiver(null, intentFilter);
            }
            registerReceiver2 = context.registerReceiver(null, intentFilter, 2);
            return registerReceiver2;
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        registerReceiver = context.registerReceiver(aVar, intentFilter, str, handler, i);
        a.b.put(pluginBroadcastReceiver, aVar);
        if (handler != null) {
            a.c.add(java.lang.Integer.valueOf(aVar.hashCode()));
        }
        a.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver;
    }

    public static android.content.Intent registerReceiver(android.content.Context context, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str, android.os.Handler handler, java.lang.String str2) {
        android.content.Intent registerReceiver;
        com.bytedance.pangle.Zeus.loadPlugin(str2);
        com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return null;
        }
        if (pluginBroadcastReceiver == null) {
            if (android.os.Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                return context.registerReceiver(null, intentFilter);
            }
            registerReceiver = context.registerReceiver(null, intentFilter, 2);
            return registerReceiver;
        }
        com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
        android.content.Intent registerReceiver2 = (android.os.Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) ? context.registerReceiver(aVar, intentFilter, str, handler) : context.registerReceiver(aVar, intentFilter, str, handler, 2);
        a.b.put(pluginBroadcastReceiver, aVar);
        if (handler != null) {
            a.c.add(java.lang.Integer.valueOf(aVar.hashCode()));
        }
        a.a(intentFilter, pluginBroadcastReceiver);
        return registerReceiver2;
    }

    public static void startActivity(android.content.Context context, android.content.Intent intent, android.os.Bundle bundle, java.lang.String str) {
        realStartActivity(null, context, intent, bundle, str);
    }

    public static void startActivity(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        realStartActivity(null, context, intent, null, str);
    }

    public static void startActivity(java.lang.Object obj, android.content.Intent intent, android.os.Bundle bundle, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            realStartActivity(null, (android.content.Context) obj, intent, bundle, str);
            return;
        }
        if (!isSupportLibIso(str) && (obj instanceof androidx.fragment.app.Fragment)) {
            realStartActivity(obj, ((androidx.fragment.app.Fragment) obj).getActivity(), intent, bundle, str);
        } else {
            if (obj instanceof android.app.Fragment) {
                realStartActivity(obj, ((android.app.Fragment) obj).getActivity(), intent, bundle, str);
                return;
            }
            try {
                com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "startActivity", new java.lang.Object[]{intent, bundle}, new java.lang.Class[]{android.content.Intent.class, android.os.Bundle.class});
            } catch (java.lang.Throwable th) {
                throw new java.lang.RuntimeException(th);
            }
        }
    }

    public static void startActivityForResult(android.app.Activity activity, android.content.Intent intent, int i, android.os.Bundle bundle, java.lang.String str) {
        realStartActivityForResult(null, activity, intent, i, bundle, str);
    }

    public static void startActivityForResult(java.lang.Object obj, android.content.Intent intent, int i, android.os.Bundle bundle, java.lang.String str) {
        if (obj instanceof android.app.Activity) {
            realStartActivityForResult(null, (android.app.Activity) obj, intent, i, null, str);
            return;
        }
        if (!isSupportLibIso(str) && (obj instanceof androidx.fragment.app.Fragment)) {
            realStartActivityForResult(obj, ((androidx.fragment.app.Fragment) obj).getActivity(), intent, i, null, str);
        } else {
            if (obj instanceof android.app.Fragment) {
                realStartActivityForResult(obj, ((android.app.Fragment) obj).getActivity(), intent, i, null, str);
                return;
            }
            try {
                com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "startActivityForResult", new java.lang.Object[]{intent, java.lang.Integer.valueOf(i), bundle}, new java.lang.Class[]{android.content.Intent.class, java.lang.Integer.TYPE, android.os.Bundle.class});
            } catch (java.lang.Throwable th) {
                throw new java.lang.RuntimeException(th);
            }
        }
    }

    public static void unregisterReceiver(android.content.Context context, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (pluginBroadcastReceiver != null) {
            com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.bytedance.pangle.receiver.c.a>> it = a.a.entrySet().iterator();
            while (it.hasNext()) {
                com.bytedance.pangle.receiver.c.a value = it.next().getValue();
                if (value != null) {
                    try {
                        if (value.b.size() > 0) {
                            value.b.remove(pluginBroadcastReceiver);
                        }
                    } catch (java.lang.Throwable th) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + value.a + "[exception]:", th);
                    }
                }
                android.content.BroadcastReceiver broadcastReceiver = a.b.get(pluginBroadcastReceiver);
                if (broadcastReceiver != null) {
                    try {
                        a.c.remove(java.lang.Integer.valueOf(broadcastReceiver.hashCode()));
                        a.b.remove(pluginBroadcastReceiver);
                        context.unregisterReceiver(broadcastReceiver);
                    } catch (java.lang.Throwable th2) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th2);
                    }
                }
            }
        }
    }
}
