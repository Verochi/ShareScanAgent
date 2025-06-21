package androidx.appcompat.view;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends android.content.ContextWrapper {
    private android.view.LayoutInflater mInflater;
    private android.content.res.Configuration mOverrideConfiguration;
    private android.content.res.Resources mResources;
    private android.content.res.Resources.Theme mTheme;
    private int mThemeResource;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(android.content.Context context, @androidx.annotation.StyleRes int i) {
        super(context);
        this.mThemeResource = i;
    }

    public ContextThemeWrapper(android.content.Context context, android.content.res.Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    private android.content.res.Resources getResourcesInternal() {
        if (this.mResources == null) {
            android.content.res.Configuration configuration = this.mOverrideConfiguration;
            if (configuration == null) {
                this.mResources = super.getResources();
            } else {
                this.mResources = createConfigurationContext(configuration).getResources();
            }
        }
        return this.mResources;
    }

    private void initializeTheme() {
        boolean z = this.mTheme == null;
        if (z) {
            this.mTheme = getResources().newTheme();
            android.content.res.Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        onApplyThemeResource(this.mTheme, this.mThemeResource, z);
    }

    public void applyOverrideConfiguration(android.content.res.Configuration configuration) {
        if (this.mResources != null) {
            throw new java.lang.IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.mOverrideConfiguration != null) {
            throw new java.lang.IllegalStateException("Override configuration has already been set");
        }
        this.mOverrideConfiguration = new android.content.res.Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        return getResourcesInternal();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = android.view.LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.mInflater;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources.Theme getTheme() {
        android.content.res.Resources.Theme theme = this.mTheme;
        if (theme != null) {
            return theme;
        }
        if (this.mThemeResource == 0) {
            this.mThemeResource = androidx.appcompat.R.style.Theme_AppCompat_Light;
        }
        initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    public void onApplyThemeResource(android.content.res.Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.mThemeResource != i) {
            this.mThemeResource = i;
            initializeTheme();
        }
    }
}
