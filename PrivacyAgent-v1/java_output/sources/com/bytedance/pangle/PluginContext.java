package com.bytedance.pangle;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class PluginContext extends com.bytedance.pangle.f {
    private android.view.LayoutInflater mInflater;
    public boolean mIsHostApplicationContext;
    public android.content.Context mOriginContext;
    private android.content.res.Configuration mOverrideConfiguration;
    public com.bytedance.pangle.plugin.Plugin mPlugin;

    public PluginContext() {
    }

    public PluginContext(android.content.Context context, com.bytedance.pangle.plugin.Plugin plugin, boolean z) {
        super(getContextWithoutTheme(context), getThemeResourceId(context));
        this.mPlugin = plugin;
        this.mOriginContext = context;
        this.mIsHostApplicationContext = z;
    }

    public static android.content.Context getContextWithoutTheme(android.content.Context context) {
        while (true) {
            if (context instanceof android.view.ContextThemeWrapper) {
                context = ((android.view.ContextThemeWrapper) context).getBaseContext();
            } else {
                if (!(context instanceof androidx.appcompat.view.ContextThemeWrapper)) {
                    return context;
                }
                context = ((androidx.appcompat.view.ContextThemeWrapper) context).getBaseContext();
            }
        }
    }

    @androidx.annotation.RequiresApi(api = 17)
    private android.content.res.Resources getResourcesInternal() {
        return this.mPlugin.mResources;
    }

    public static int getThemeResourceId(android.content.Context context) {
        if (context instanceof android.view.ContextThemeWrapper) {
            try {
                return ((java.lang.Integer) com.bytedance.pangle.util.FieldUtils.readField(context, "mThemeResource")).intValue();
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(android.content.res.Configuration configuration) {
        if (this.mPlugin.mResources != null) {
            throw new java.lang.IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.mOverrideConfiguration != null) {
            throw new java.lang.IllegalStateException("Override configuration has already been set");
        }
        this.mOverrideConfiguration = new android.content.res.Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.Context createConfigurationContext(android.content.res.Configuration configuration) {
        android.content.Context createConfigurationContext = super.createConfigurationContext(configuration);
        try {
            try {
                com.bytedance.pangle.util.FieldUtils.writeField(createConfigurationContext, "mResources", this.mPlugin.mResources);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } catch (java.lang.Throwable unused) {
            com.bytedance.pangle.b.b.a.a(createConfigurationContext.getClass(), "mResources").set(createConfigurationContext, this.mPlugin.mResources);
        }
        return createConfigurationContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.Context getApplicationContext() {
        android.content.Context context = this.mOriginContext;
        return context instanceof com.bytedance.pangle.wrapper.PluginApplicationWrapper ? context : com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext(context.getApplicationContext(), this.mPlugin.mPkgName);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.pm.ApplicationInfo getApplicationInfo() {
        return this.mPlugin.mHostApplicationInfoHookSomeField;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return this.mPlugin.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper
    public android.content.Context getBaseContext() {
        android.content.Context baseContext = super.getBaseContext();
        return baseContext instanceof android.content.ContextWrapper ? ((android.content.ContextWrapper) baseContext).getBaseContext() : baseContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.ClassLoader getClassLoader() {
        return this.mPlugin.mClassLoader;
    }

    public android.content.res.Configuration getOverrideConfiguration() {
        return this.mOverrideConfiguration;
    }

    public java.lang.String getPluginPackageName() {
        return this.mPlugin.mPkgName;
    }

    @Override // com.bytedance.pangle.f
    public java.lang.String getPluginPkg() {
        return this.mPlugin.mPkgName;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        return this.mPlugin.mResources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        if (!"layout_inflater".equals(str)) {
            android.content.Context context = this.mOriginContext;
            return context != null ? context.getSystemService(str) : getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            android.view.LayoutInflater cloneInContext = android.view.LayoutInflater.from(getBaseContext()).cloneInContext(this);
            this.mInflater = cloneInContext;
            com.bytedance.pangle.res.b.a(cloneInContext);
        }
        return this.mInflater;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(android.content.ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.registerComponentCallbacks(componentCallbacks);
        } else {
            super.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(android.content.ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.unregisterComponentCallbacks(componentCallbacks);
        } else {
            super.unregisterComponentCallbacks(componentCallbacks);
        }
    }
}
