package com.bytedance.pangle.transform;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class ZeusTransformUtils {
    private static final java.lang.String TAG = "PluginContextUtils";
    public static java.lang.Class fragmentClazz;
    private static boolean sCanThrowException;
    private static boolean sSupportFragmentWrapper;
    static java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.content.Context>> contextCache = new java.util.HashMap<>();
    static boolean hasEnsure = false;
    static java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<android.view.View>> sConstructorMap = null;

    public static android.app.Activity _getActivity(java.lang.Object obj, java.lang.String str) {
        try {
            android.app.Activity activity = (android.app.Activity) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getActivity", new java.lang.Object[0]);
            android.app.Activity activity2 = (android.app.Activity) wrapperContext(activity, str);
            return activity2 instanceof com.bytedance.pangle.activity.GenerateProxyActivity ? ((com.bytedance.pangle.activity.GenerateProxyActivity) activity2).mTargetActivity : (isSupportLibIso(str) || !(activity2 instanceof com.bytedance.pangle.activity.GenerateProxyAppCompatActivity)) ? (android.app.Activity) wrapperContext(activity, str) : ((com.bytedance.pangle.activity.GenerateProxyAppCompatActivity) activity2).mTargetActivity;
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static boolean bindService(java.lang.Object obj, android.content.Intent intent, android.content.ServiceConnection serviceConnection, int i, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            return com.bytedance.pangle.service.client.ServiceManagerNative.getInstance().bindServiceNative((android.content.Context) obj, intent, serviceConnection, i, str);
        }
        try {
            return ((java.lang.Boolean) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "bindService", new java.lang.Object[]{intent, serviceConnection, java.lang.Integer.valueOf(i)}, new java.lang.Class[]{android.content.Intent.class, android.content.ServiceConnection.class, java.lang.Integer.TYPE})).booleanValue();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void canThrowException(boolean z) {
        sCanThrowException = z;
    }

    public static void clearConstructorCache() {
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            try {
                if (sConstructorMap == null) {
                    sConstructorMap = (java.util.HashMap) com.bytedance.pangle.util.FieldUtils.readStaticField(android.view.LayoutInflater.class, "sConstructorMap");
                }
                for (java.lang.String str : new java.util.HashSet(sConstructorMap.keySet())) {
                    if (!str.startsWith("android.view.") && !str.startsWith("android.widget.") && !str.startsWith("android.webkit.") && str.contains(".")) {
                        sConstructorMap.remove(str);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static android.content.Context convertProxy2PluginActivity(android.content.Context context) {
        try {
            if ((context instanceof com.bytedance.pangle.activity.GenerateProxyActivity) || (context instanceof com.bytedance.pangle.activity.GenerateProxyAppCompatActivity)) {
                return (android.app.Activity) com.bytedance.pangle.util.FieldUtils.readField(context, "mTargetActivity");
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "convertProxy2PluginActivity failed.", th);
        }
        return context;
    }

    private static void ensureFragmentActivity() {
        if (hasEnsure) {
            return;
        }
        try {
            try {
                fragmentClazz = com.bytedance.pangle.Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            } catch (java.lang.Throwable unused) {
                fragmentClazz = com.bytedance.pangle.Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            }
        } catch (java.lang.Throwable unused2) {
        }
        hasEnsure = true;
    }

    private static boolean equalsFragmentActivity(java.lang.Class cls) {
        ensureFragmentActivity();
        java.lang.Class cls2 = fragmentClazz;
        return cls2 != null && cls == cls2;
    }

    public static java.lang.Class forName(java.lang.String str, java.lang.String str2) {
        return com.bytedance.pangle.Zeus.getPlugin(str2).mClassLoader.loadClass(str);
    }

    public static android.app.Activity getActivity(java.lang.Object obj, java.lang.String str) {
        return _getActivity(obj, str);
    }

    public static java.lang.String getAssetPaths(android.content.res.AssetManager assetManager) {
        int i;
        int i2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (assetManager == null) {
            return "";
        }
        try {
            i = android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "TransformUtils GetAssetsPaths error. ", th);
        }
        if (i < 28) {
            if (i == 27) {
                i2 = android.os.Build.VERSION.PREVIEW_SDK_INT;
                if (i2 > 0) {
                }
            }
            int intValue = ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new java.lang.Object[0])).intValue();
            for (int i3 = 0; i3 < intValue; i3++) {
                try {
                    java.lang.String str = (java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getCookieName", java.lang.Integer.valueOf(i3 + 1));
                    if (!android.text.TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                } catch (java.lang.IndexOutOfBoundsException unused) {
                }
            }
            return sb.toString();
        }
        java.lang.Object[] objArr = (java.lang.Object[]) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getApkAssets", new java.lang.Object[0]);
        if (objArr != null && objArr.length > 0) {
            for (java.lang.Object obj : objArr) {
                sb.append((java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getAssetPath", new java.lang.Object[0]));
            }
        }
        return sb.toString();
    }

    public static android.content.Context getContext(java.lang.Object obj, java.lang.String str) {
        try {
            android.content.Context context = (android.content.Context) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getContext", new java.lang.Object[0]);
            return ((isSupportLibIso(str) || !instanceOfFragmentActivity(context)) && !(context instanceof android.app.Activity) && !(context instanceof android.app.Application) && (context instanceof com.bytedance.pangle.PluginContext)) ? context : wrapperContext(context, str);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    private static android.content.Context getContextIfNeedWrap(android.content.Context context, android.content.Context context2, java.lang.String str) {
        java.lang.Object readField;
        while (context2 != 0) {
            if (context2 instanceof com.bytedance.pangle.activity.IPluginActivity) {
                if (android.text.TextUtils.equals(((com.bytedance.pangle.activity.IPluginActivity) context2).getPluginPkgName(), str)) {
                    return null;
                }
                return context;
            }
            if (context2 instanceof com.bytedance.pangle.PluginContext) {
                com.bytedance.pangle.PluginContext pluginContext = (com.bytedance.pangle.PluginContext) context2;
                if (android.text.TextUtils.equals(pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginContext.mOriginContext;
            }
            if (context2 instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper) {
                com.bytedance.pangle.wrapper.PluginActivityWrapper pluginActivityWrapper = (com.bytedance.pangle.wrapper.PluginActivityWrapper) context2;
                if (android.text.TextUtils.equals(pluginActivityWrapper.pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginActivityWrapper.mOriginActivity;
            }
            if (!isSupportLibIso(str) && (context2 instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper)) {
                if (android.text.TextUtils.equals(context2.pluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                try {
                    try {
                        readField = context2.getOriginActivity();
                    } catch (java.lang.Throwable unused) {
                        readField = com.bytedance.pangle.util.FieldUtils.readField(context2, "mOriginActivity");
                    }
                    return (android.content.Context) readField;
                } catch (java.lang.Throwable th) {
                    throw new java.lang.RuntimeException(th);
                }
            }
            if (context2 instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper) {
                com.bytedance.pangle.wrapper.PluginApplicationWrapper pluginApplicationWrapper = (com.bytedance.pangle.wrapper.PluginApplicationWrapper) context2;
                if (android.text.TextUtils.equals(pluginApplicationWrapper.mPluginContext.mPlugin.mPkgName, str)) {
                    return null;
                }
                return pluginApplicationWrapper.mOriginApplication;
            }
            if (context2.getResources() instanceof com.bytedance.pangle.res.PluginResources) {
                com.bytedance.pangle.res.PluginResources pluginResources = (com.bytedance.pangle.res.PluginResources) context2.getResources();
                try {
                    java.lang.String str2 = (java.lang.String) com.bytedance.pangle.util.FieldUtils.readField(pluginResources, "pluginPkg");
                    if (android.text.TextUtils.isEmpty(str2)) {
                        if (!getAssetPaths(pluginResources.getAssets()).contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str + "/version")) {
                            return context;
                        }
                    } else if (!android.text.TextUtils.equals(str2, str)) {
                        return context;
                    }
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
                return null;
            }
            if (!(context2 instanceof android.content.ContextWrapper)) {
                return context;
            }
            try {
                context2 = (android.content.Context) com.bytedance.pangle.util.FieldUtils.readField(context2, "mBase");
            } catch (java.lang.Throwable unused2) {
                context2 = context2.getBaseContext();
            }
        }
        return null;
    }

    public static int getIdentifier(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (!(obj instanceof android.content.res.Resources)) {
            try {
                return ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        android.content.res.Resources resources = (android.content.res.Resources) obj;
        if (!android.text.TextUtils.equals(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM, str3)) {
            str3 = str4;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public static android.content.res.Resources getResources(java.lang.Object obj, java.lang.String str) {
        try {
            android.content.res.Resources resources = (android.content.res.Resources) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getResources", new java.lang.Object[0]);
            if (resources == null) {
                return null;
            }
            if (resources instanceof com.bytedance.pangle.res.PluginResources) {
                java.lang.String str2 = (java.lang.String) com.bytedance.pangle.util.FieldUtils.readField(resources, "pluginPkg");
                if (android.text.TextUtils.isEmpty(str2)) {
                    if (getAssetPaths(resources.getAssets()).contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str + "/version")) {
                        return resources;
                    }
                } else if (android.text.TextUtils.equals(str2, str)) {
                    return resources;
                }
            }
            return com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str).mResources;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.net.Uri getUriForFile(android.content.Context context, java.lang.String str, java.io.File file, java.lang.String str2) {
        try {
            return com.bytedance.pangle.FileProvider.getUriForFile(file);
        } catch (java.lang.NoClassDefFoundError unused) {
            return android.net.Uri.parse("");
        }
    }

    public static android.view.Window getWindow(android.app.Activity activity, java.lang.String str) {
        android.view.Window window = activity.getWindow();
        if (window != null) {
            return window;
        }
        try {
            return (android.view.Window) com.bytedance.pangle.util.MethodUtils.invokeMethod(activity, "getWindow", new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException(th);
        }
    }

    private static android.content.Context getWrapperFromCache(java.lang.Object obj, java.lang.String str) {
        java.lang.ref.WeakReference<android.content.Context> weakReference = contextCache.get(str + java.lang.System.identityHashCode(obj));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void handleAttrAfter(android.content.res.TypedArray typedArray, int[] iArr, int[] iArr2) {
        if (java.util.Arrays.equals(iArr, iArr2)) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < iArr.length; i++) {
            hashMap.put(java.lang.Integer.valueOf(iArr[i]), java.lang.Integer.valueOf(i));
        }
        java.util.HashMap hashMap2 = new java.util.HashMap();
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            hashMap2.put((java.lang.Integer) hashMap.get(java.lang.Integer.valueOf(iArr2[i2])), java.lang.Integer.valueOf(i2));
        }
        try {
            int[] iArr3 = (int[]) com.bytedance.pangle.util.FieldUtils.readField(typedArray, "mData");
            int[] copyOf = java.util.Arrays.copyOf(iArr3, iArr3.length);
            for (java.lang.Integer num : hashMap2.keySet()) {
                java.lang.Integer num2 = (java.lang.Integer) hashMap2.get(num);
                if (!num.equals(num2)) {
                    java.lang.System.arraycopy(iArr3, num.intValue() * 7, copyOf, num2.intValue() * 7, 7);
                }
            }
            java.lang.System.arraycopy(copyOf, 0, iArr3, 0, iArr3.length);
        } catch (java.lang.IllegalAccessException unused) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "read mData failed.");
        }
    }

    private static int[] handleAttrBefore(int[] iArr) {
        int[] copyOf = java.util.Arrays.copyOf(iArr, iArr.length);
        java.util.Arrays.sort(copyOf);
        return copyOf;
    }

    public static android.view.View inflate(android.content.Context context, int i, android.view.ViewGroup viewGroup, java.lang.String str) {
        if (!(context instanceof com.bytedance.pangle.PluginContext) && !(context instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper)) && !(context instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper))) {
            context = wrapperContext(context, str);
        }
        android.view.LayoutInflater layoutInflater = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
        clearConstructorCache();
        android.view.View inflate = layoutInflater.inflate(i, viewGroup);
        clearConstructorCache();
        return inflate;
    }

    public static android.view.View inflate(android.view.LayoutInflater layoutInflater, int i, android.view.ViewGroup viewGroup, java.lang.String str) {
        return inflate(layoutInflater, i, viewGroup, viewGroup != null, str);
    }

    public static android.view.View inflate(android.view.LayoutInflater layoutInflater, int i, android.view.ViewGroup viewGroup, boolean z, java.lang.String str) {
        android.content.Context context = layoutInflater.getContext();
        if (!(context instanceof com.bytedance.pangle.PluginContext) && !(context instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper)) && !(context instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper))) {
            android.content.Context wrapperContext = wrapperContext(context, str);
            android.view.LayoutInflater.Factory factory = layoutInflater.getFactory();
            android.view.LayoutInflater.Factory2 factory2 = layoutInflater.getFactory2();
            android.view.LayoutInflater layoutInflater2 = (android.view.LayoutInflater) wrapperContext.getSystemService("layout_inflater");
            if (isSupportLibIso(str)) {
                if (factory != null) {
                    try {
                        com.bytedance.pangle.util.FieldUtils.writeField(layoutInflater2, "mFactory", factory);
                    } catch (java.lang.Throwable unused) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "set Factory failed.");
                    }
                }
                if (factory2 != null) {
                    try {
                        com.bytedance.pangle.util.FieldUtils.writeField(layoutInflater2, "mFactory2", factory2);
                    } catch (java.lang.Throwable unused2) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "set Factory2 failed.");
                    }
                }
            }
            layoutInflater = layoutInflater2;
        }
        clearConstructorCache();
        android.view.View inflate = layoutInflater.inflate(i, viewGroup, z);
        clearConstructorCache();
        return inflate;
    }

    public static android.view.View inflate(android.view.LayoutInflater layoutInflater, org.xmlpull.v1.XmlPullParser xmlPullParser, android.view.ViewGroup viewGroup, java.lang.String str) {
        return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
    }

    public static android.view.View inflate(android.view.LayoutInflater layoutInflater, org.xmlpull.v1.XmlPullParser xmlPullParser, android.view.ViewGroup viewGroup, boolean z, java.lang.String str) {
        android.content.Context context = layoutInflater.getContext();
        if (!(context instanceof com.bytedance.pangle.PluginContext) && !(context instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper) && ((isSupportLibIso(str) || !(context instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper)) && !(context instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper))) {
            context = wrapperContext(context, str);
        }
        android.view.LayoutInflater layoutInflater2 = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
        clearConstructorCache();
        android.view.View inflate = layoutInflater2.inflate(xmlPullParser, viewGroup, z);
        clearConstructorCache();
        return inflate;
    }

    public static boolean instanceOf(java.lang.Class cls, java.lang.Object obj) {
        return instanceOf(obj, cls);
    }

    public static boolean instanceOf(java.lang.Object obj, java.lang.Class cls) {
        java.lang.Object readField;
        if (obj instanceof com.bytedance.pangle.PluginContext) {
            return cls.isInstance(((com.bytedance.pangle.PluginContext) obj).mOriginContext);
        }
        if (obj instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper) {
            return cls.isInstance(((com.bytedance.pangle.wrapper.PluginActivityWrapper) obj).mOriginActivity);
        }
        if (!(obj instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper)) {
            return obj instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper ? cls.isInstance(((com.bytedance.pangle.wrapper.PluginApplicationWrapper) obj).mOriginApplication) : obj instanceof com.bytedance.pangle.activity.GenerateProxyActivity ? cls.isInstance(((com.bytedance.pangle.activity.GenerateProxyActivity) obj).mTargetActivity) : cls.isInstance(obj);
        }
        try {
            try {
                readField = ((com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper) obj).getOriginActivity();
            } catch (java.lang.Throwable th) {
                throw new java.lang.RuntimeException(th);
            }
        } catch (java.lang.Throwable unused) {
            readField = com.bytedance.pangle.util.FieldUtils.readField(obj, "mOriginActivity");
        }
        return cls.isInstance(readField);
    }

    private static boolean instanceOfFragmentActivity(java.lang.Object obj) {
        ensureFragmentActivity();
        java.lang.Class cls = fragmentClazz;
        if (cls == null) {
            return false;
        }
        return cls.isInstance(obj);
    }

    private static boolean isSupportLibIso(java.lang.String str) {
        try {
            return com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str).mIsSupportLibIso;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static int mapRes(int i, java.lang.String str, java.lang.String str2) {
        if (i < 2130706432) {
            return i;
        }
        int identifier = com.bytedance.pangle.Zeus.getAppApplication().getResources().getIdentifier(str2, str, com.bytedance.pangle.Zeus.getAppApplication().getPackageName());
        if (identifier == 0) {
            identifier = com.bytedance.pangle.Zeus.getAppApplication().getResources().getIdentifier(str2.replace("_", "."), str, com.bytedance.pangle.Zeus.getAppApplication().getPackageName());
        }
        if (identifier == 0) {
            com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "Cant find res, resName = " + str2 + ", pluginResId = " + i);
        }
        return identifier;
    }

    public static android.content.res.TypedArray obtainAttributes(java.lang.Object obj, android.util.AttributeSet attributeSet, int[] iArr, java.lang.String str) {
        if (!(obj instanceof android.content.res.Resources)) {
            try {
                return (android.content.res.TypedArray) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "obtainAttributes", attributeSet, iArr);
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        int[] handleAttrBefore = handleAttrBefore(iArr);
        android.content.res.TypedArray obtainAttributes = ((android.content.res.Resources) obj).obtainAttributes(attributeSet, handleAttrBefore);
        handleAttrAfter(obtainAttributes, handleAttrBefore, iArr);
        return obtainAttributes;
    }

    public static android.content.res.TypedArray obtainStyledAttributes(java.lang.Object obj, int i, int[] iArr, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            android.content.res.TypedArray obtainStyledAttributes = ((android.content.Context) obj).obtainStyledAttributes(i, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        if (!(obj instanceof android.content.res.Resources.Theme)) {
            try {
                return (android.content.res.TypedArray) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "obtainStyledAttributes", java.lang.Integer.valueOf(i), iArr);
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        int[] handleAttrBefore2 = handleAttrBefore(iArr);
        android.content.res.TypedArray obtainStyledAttributes2 = ((android.content.res.Resources.Theme) obj).obtainStyledAttributes(i, handleAttrBefore2);
        handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
        return obtainStyledAttributes2;
    }

    public static android.content.res.TypedArray obtainStyledAttributes(java.lang.Object obj, android.util.AttributeSet attributeSet, int[] iArr, int i, int i2, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            android.content.res.TypedArray obtainStyledAttributes = ((android.content.Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        if (!(obj instanceof android.content.res.Resources.Theme)) {
            try {
                return (android.content.res.TypedArray) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        int[] handleAttrBefore2 = handleAttrBefore(iArr);
        android.content.res.TypedArray obtainStyledAttributes2 = ((android.content.res.Resources.Theme) obj).obtainStyledAttributes(attributeSet, handleAttrBefore2, i, i2);
        handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
        return obtainStyledAttributes2;
    }

    public static android.content.res.TypedArray obtainStyledAttributes(java.lang.Object obj, android.util.AttributeSet attributeSet, int[] iArr, java.lang.String str) {
        if (!(obj instanceof android.content.Context)) {
            try {
                return (android.content.res.TypedArray) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "obtainStyledAttributes", attributeSet, iArr);
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        int[] handleAttrBefore = handleAttrBefore(iArr);
        android.content.res.TypedArray obtainStyledAttributes = ((android.content.Context) obj).obtainStyledAttributes(attributeSet, handleAttrBefore);
        handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
        return obtainStyledAttributes;
    }

    public static android.content.res.TypedArray obtainStyledAttributes(java.lang.Object obj, int[] iArr, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            int[] handleAttrBefore = handleAttrBefore(iArr);
            android.content.res.TypedArray obtainStyledAttributes = ((android.content.Context) obj).obtainStyledAttributes(handleAttrBefore);
            handleAttrAfter(obtainStyledAttributes, handleAttrBefore, iArr);
            return obtainStyledAttributes;
        }
        if (!(obj instanceof android.content.res.Resources.Theme)) {
            try {
                return (android.content.res.TypedArray) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "obtainStyledAttributes", iArr, new java.lang.Class[]{int[].class});
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        int[] handleAttrBefore2 = handleAttrBefore(iArr);
        android.content.res.TypedArray obtainStyledAttributes2 = ((android.content.res.Resources.Theme) obj).obtainStyledAttributes(handleAttrBefore2);
        handleAttrAfter(obtainStyledAttributes2, handleAttrBefore2, iArr);
        return obtainStyledAttributes2;
    }

    public static java.lang.Object preCheckCast(java.lang.Object obj, java.lang.Class cls, java.lang.String str) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof android.content.Context)) {
            return obj;
        }
        boolean z = !cls.isInstance(obj);
        if (equalsFragmentActivity(cls)) {
            return wrapperContext2FragmentActivity(obj, str);
        }
        if (cls == android.app.Activity.class) {
            return wrapperContext2Activity(obj, str);
        }
        if (cls == android.app.Application.class) {
            return wrapperContext2Application(obj, str);
        }
        if ((obj instanceof com.bytedance.pangle.PluginContext) && z) {
            return ((com.bytedance.pangle.PluginContext) obj).mOriginContext;
        }
        if (!(obj instanceof com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper) || !z) {
            return ((obj instanceof com.bytedance.pangle.wrapper.PluginActivityWrapper) && z) ? ((com.bytedance.pangle.wrapper.PluginActivityWrapper) obj).mOriginActivity : ((obj instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper) && z) ? ((com.bytedance.pangle.wrapper.PluginApplicationWrapper) obj).mOriginApplication : ((obj instanceof com.bytedance.pangle.activity.GenerateProxyActivity) && z) ? ((com.bytedance.pangle.activity.GenerateProxyActivity) obj).mTargetActivity : obj;
        }
        try {
            try {
                return ((com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper) obj).getOriginActivity();
            } catch (java.lang.Throwable unused) {
                return com.bytedance.pangle.util.FieldUtils.readField(obj, "mOriginActivity");
            }
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException(th);
        }
    }

    public static android.content.Intent registerReceiver(java.lang.Object obj, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, int i, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            return com.bytedance.pangle.ComponentManager.registerReceiver((android.content.Context) obj, pluginBroadcastReceiver, intentFilter, i, str);
        }
        try {
            return (android.content.Intent) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.content.Intent registerReceiver(java.lang.Object obj, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            return com.bytedance.pangle.ComponentManager.registerReceiver((android.content.Context) obj, pluginBroadcastReceiver, intentFilter, str);
        }
        try {
            return (android.content.Intent) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.content.Intent registerReceiver(java.lang.Object obj, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str, android.os.Handler handler, int i, java.lang.String str2) {
        if (obj instanceof android.content.Context) {
            return com.bytedance.pangle.ComponentManager.registerReceiver((android.content.Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i, str2);
        }
        try {
            return (android.content.Intent) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.content.Intent registerReceiver(java.lang.Object obj, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str, android.os.Handler handler, java.lang.String str2) {
        if (obj instanceof android.content.Context) {
            com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
            return com.bytedance.pangle.ComponentManager.registerReceiver((android.content.Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
        }
        try {
            return (android.content.Intent) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void registerZeusActivityStub(java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        com.bytedance.pangle.ComponentManager.registerActivity(str2, str, strArr);
    }

    public static void requestPermissions(java.lang.Object obj, java.lang.String[] strArr, int i, java.lang.String str) {
        java.lang.Object obj2;
        if (obj instanceof com.bytedance.pangle.activity.IPluginActivity) {
            ((com.bytedance.pangle.activity.IPluginActivity) obj)._requestPermissions(strArr, i);
            return;
        }
        if (obj instanceof android.app.Activity) {
            try {
                obj2 = com.bytedance.pangle.util.FieldUtils.readField(obj, "mOriginActivity");
            } catch (java.lang.IllegalAccessException unused) {
                obj2 = null;
            }
            if (obj2 != null) {
                obj = obj2;
            }
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "requestPermissions", strArr, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void setComponentEnabledSetting(android.content.pm.PackageManager packageManager, android.content.ComponentName componentName, int i, int i2) {
        try {
            packageManager.setComponentEnabledSetting(componentName, i, i2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void setResult(java.lang.Object obj, int i, android.content.Intent intent, java.lang.String str) {
        if (obj instanceof android.app.Activity) {
            try {
                java.lang.Object readField = com.bytedance.pangle.util.FieldUtils.readField(obj, "mProxyActivity");
                if (readField == null) {
                    readField = com.bytedance.pangle.util.FieldUtils.readField(obj, "mOriginActivity");
                }
                if (readField != null) {
                    com.bytedance.pangle.util.MethodUtils.invokeMethod(readField, "setResult", java.lang.Integer.valueOf(i), intent);
                    return;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "setResult", java.lang.Integer.valueOf(i), intent);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void setResult(java.lang.Object obj, int i, java.lang.String str) {
        if (obj instanceof android.app.Activity) {
            try {
                java.lang.Object readField = com.bytedance.pangle.util.FieldUtils.readField(obj, "mProxyActivity");
                if (readField != null) {
                    com.bytedance.pangle.util.MethodUtils.invokeMethod(readField, "setResult", java.lang.Integer.valueOf(i));
                    return;
                }
            } catch (java.lang.Exception unused) {
                com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(java.lang.String.valueOf(obj)));
            }
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "setResult", java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void startActivity(java.lang.Object obj, android.content.Intent intent, android.os.Bundle bundle, java.lang.String str) {
        try {
            com.bytedance.pangle.ComponentManager.startActivity(obj, intent, bundle, str);
        } catch (java.lang.Throwable th) {
            if (obj instanceof android.content.Context) {
                com.bytedance.pangle.ComponentManager.startActivity((android.content.Context) obj, intent, bundle, str);
                return;
            }
            try {
                com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "startActivity", new java.lang.Object[]{intent, bundle}, new java.lang.Class[]{android.content.Intent.class, android.os.Bundle.class});
            } catch (java.lang.Throwable th2) {
                th2.addSuppressed(th);
                throw new java.lang.RuntimeException(th2);
            }
        }
    }

    public static void startActivity(java.lang.Object obj, android.content.Intent intent, java.lang.String str) {
        startActivity(obj, intent, null, str);
    }

    public static void startActivityForResult(java.lang.Object obj, android.content.Intent intent, int i, android.os.Bundle bundle, java.lang.String str) {
        try {
            com.bytedance.pangle.ComponentManager.startActivityForResult(obj, intent, i, bundle, str);
        } catch (java.lang.Throwable th) {
            if (obj instanceof android.app.Activity) {
                com.bytedance.pangle.ComponentManager.startActivityForResult((android.app.Activity) obj, intent, i, bundle, str);
                return;
            }
            try {
                com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "startActivityForResult", new java.lang.Object[]{intent, java.lang.Integer.valueOf(i), bundle}, new java.lang.Class[]{android.content.Intent.class, java.lang.Integer.TYPE, android.os.Bundle.class});
            } catch (java.lang.Throwable th2) {
                th2.addSuppressed(th);
                throw new java.lang.RuntimeException(th2);
            }
        }
    }

    public static void startActivityForResult(java.lang.Object obj, android.content.Intent intent, int i, java.lang.String str) {
        startActivityForResult(obj, intent, i, null, str);
    }

    public static android.content.ComponentName startService(java.lang.Object obj, android.content.Intent intent, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            return com.bytedance.pangle.service.client.ServiceManagerNative.getInstance().startServiceNative((android.content.Context) obj, intent, str);
        }
        try {
            return (android.content.ComponentName) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "startService", intent);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static boolean stopService(java.lang.Object obj, android.content.Intent intent, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            return com.bytedance.pangle.service.client.ServiceManagerNative.getInstance().stopServiceNative((android.content.Context) obj, intent, str);
        }
        try {
            return ((java.lang.Boolean) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void supportFragmentWrapper(boolean z) {
        sSupportFragmentWrapper = z;
    }

    public static void unbindService(java.lang.Object obj, android.content.ServiceConnection serviceConnection, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            com.bytedance.pangle.service.client.ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
            return;
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void unregisterReceiver(java.lang.Object obj, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, java.lang.String str) {
        if (obj instanceof android.content.Context) {
            com.bytedance.pangle.ComponentManager.unregisterReceiver((android.content.Context) obj, pluginBroadcastReceiver);
            return;
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.content.Context wrapperContext(java.lang.Object obj, java.lang.String str) {
        return wrapperContext(obj, str, null);
    }

    public static android.content.Context wrapperContext(java.lang.Object obj, java.lang.String str, java.lang.StringBuilder sb) {
        android.content.Context pluginContext;
        android.app.Application application;
        if (com.bytedance.pangle.Zeus.getAppApplication() == null && (application = (android.app.Application) ((android.content.Context) obj).getApplicationContext()) != null) {
            com.bytedance.pangle.Zeus.setAppContext(application);
        }
        if (obj == null) {
            if (sb == null) {
                return null;
            }
            sb.append("context1 == null");
            return null;
        }
        android.content.Context wrapperFromCache = getWrapperFromCache(obj, str);
        if (wrapperFromCache != null) {
            if (sb != null) {
                sb.append("cache1:");
                sb.append(wrapperFromCache);
            }
            return wrapperFromCache;
        }
        android.content.Context context = (android.content.Context) obj;
        android.content.Context contextIfNeedWrap = getContextIfNeedWrap(context, context, str);
        if (contextIfNeedWrap == null) {
            if (sb != null) {
                sb.append("context2 == null");
                sb.append(obj);
            }
            return context;
        }
        if (!isSupportLibIso(str) && instanceOfFragmentActivity(contextIfNeedWrap) && sSupportFragmentWrapper) {
            if (android.os.Looper.myLooper() == null) {
                android.os.Looper.prepare();
            }
            try {
                try {
                    pluginContext = new com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper((android.app.Activity) contextIfNeedWrap, new com.bytedance.pangle.PluginContext(contextIfNeedWrap, com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str), false));
                    if (sb != null) {
                        sb.append("new PluginFragmentActivityWrapper:");
                        sb.append(pluginContext);
                    }
                } catch (java.lang.Throwable unused) {
                    pluginContext = (android.content.Context) com.bytedance.pangle.util.MethodUtils.invokeConstructor(com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper.class, new java.lang.Object[]{contextIfNeedWrap, new com.bytedance.pangle.PluginContext(contextIfNeedWrap, com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str), false)}, new java.lang.Class[]{fragmentClazz, com.bytedance.pangle.PluginContext.class});
                    if (sb != null) {
                        sb.append("new invokeConstructor:");
                        sb.append(pluginContext);
                    }
                }
            } catch (java.lang.Throwable unused2) {
                if (sb != null) {
                    sb.append("context3 == null");
                    sb.append(contextIfNeedWrap);
                }
                return contextIfNeedWrap;
            }
        } else if (contextIfNeedWrap instanceof android.app.Activity) {
            if (android.os.Looper.myLooper() == null) {
                android.os.Looper.prepare();
            }
            pluginContext = new com.bytedance.pangle.wrapper.PluginActivityWrapper((android.app.Activity) contextIfNeedWrap, new com.bytedance.pangle.PluginContext(contextIfNeedWrap, com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str), false));
            if (sb != null) {
                sb.append("new PluginActivityWrapper:");
                sb.append(pluginContext);
            }
        } else if (contextIfNeedWrap instanceof android.app.Application) {
            pluginContext = new com.bytedance.pangle.wrapper.PluginApplicationWrapper((android.app.Application) contextIfNeedWrap, new com.bytedance.pangle.PluginContext(contextIfNeedWrap, com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str), true));
            if (sb != null) {
                sb.append("new PluginApplicationWrapper:");
                sb.append(pluginContext);
            }
        } else {
            pluginContext = new com.bytedance.pangle.PluginContext(contextIfNeedWrap, com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str), false);
            if (sb != null) {
                sb.append("new PluginContext:");
                sb.append(pluginContext);
            }
        }
        if (pluginContext != null) {
            contextCache.put(str + java.lang.System.identityHashCode(contextIfNeedWrap), new java.lang.ref.WeakReference<>(pluginContext));
        }
        if (sb != null) {
            sb.append("cache2:");
            sb.append(pluginContext);
        }
        return pluginContext;
    }

    public static android.app.Activity wrapperContext2Activity(java.lang.Object obj, java.lang.String str) {
        while (obj != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.content.Context wrapperContext = wrapperContext(obj, str, sb);
            if (wrapperContext instanceof android.app.Activity) {
                return (android.app.Activity) wrapperContext;
            }
            if (!(wrapperContext instanceof com.bytedance.pangle.PluginContext)) {
                sb.append("SupportFragment=");
                sb.append(sSupportFragmentWrapper);
                if (!sCanThrowException) {
                    return (android.app.Activity) obj;
                }
                throw new java.lang.RuntimeException("强转失败 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((java.lang.Object) sb));
            }
            obj = ((com.bytedance.pangle.PluginContext) wrapperContext).mOriginContext;
        }
        return null;
    }

    public static android.app.Application wrapperContext2Application(java.lang.Object obj, java.lang.String str) {
        while (obj != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.content.Context wrapperContext = wrapperContext(obj, str, sb);
            if (wrapperContext instanceof android.app.Application) {
                return (android.app.Application) wrapperContext;
            }
            if (!(wrapperContext instanceof com.bytedance.pangle.PluginContext)) {
                sb.append("SupportFragment=");
                sb.append(sSupportFragmentWrapper);
                if (!sCanThrowException) {
                    return (android.app.Application) obj;
                }
                throw new java.lang.RuntimeException("强转失败 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((java.lang.Object) sb));
            }
            obj = ((com.bytedance.pangle.PluginContext) wrapperContext).mOriginContext;
        }
        return null;
    }

    private static java.lang.Object wrapperContext2FragmentActivity(java.lang.Object obj, java.lang.String str) {
        while (obj != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.content.Context wrapperContext = wrapperContext(obj, str, sb);
            if (!isSupportLibIso(str) && instanceOfFragmentActivity(wrapperContext)) {
                return wrapperContext;
            }
            if (!(wrapperContext instanceof com.bytedance.pangle.PluginContext)) {
                sb.append("SupportFragment=");
                sb.append(sSupportFragmentWrapper);
                if (!sCanThrowException) {
                    return obj;
                }
                throw new java.lang.RuntimeException("强转失败 context:" + obj + " wrapperContext:" + wrapperContext + " log:" + ((java.lang.Object) sb));
            }
            obj = ((com.bytedance.pangle.PluginContext) wrapperContext).mOriginContext;
        }
        return null;
    }

    public static java.lang.Object wrapperContextForParams(java.lang.Object obj, java.lang.Class cls, java.lang.String str) {
        if (!(obj instanceof com.bytedance.pangle.service.PluginService) && !(obj instanceof com.bytedance.pangle.service.PluginIntentService) && (obj instanceof android.content.Context)) {
            android.content.Context convertProxy2PluginActivity = convertProxy2PluginActivity(wrapperContext(obj, str));
            if (cls.isInstance(convertProxy2PluginActivity)) {
                return convertProxy2PluginActivity;
            }
        }
        return obj;
    }
}
