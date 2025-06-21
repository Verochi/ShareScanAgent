package com.bytedance.pangle.res;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class PluginResources extends android.content.res.Resources {
    public java.lang.String pluginPkg;

    public PluginResources(android.content.res.Resources resources, java.lang.String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), com.bytedance.pangle.Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static android.content.res.AssetManager appendHostRes(android.content.res.Resources resources) {
        java.lang.String a = com.bytedance.pangle.util.g.a(com.bytedance.pangle.Zeus.getAppApplication());
        java.lang.String b = com.bytedance.pangle.util.g.b(com.bytedance.pangle.Zeus.getAppApplication());
        java.util.List<java.lang.String> b2 = com.bytedance.pangle.util.j.b();
        com.bytedance.pangle.res.a aVar = new com.bytedance.pangle.res.a();
        android.content.res.AssetManager assets = resources.getAssets();
        android.content.res.AssetManager assets2 = com.bytedance.pangle.Zeus.getAppApplication().getAssets();
        java.util.HashSet hashSet = new java.util.HashSet(com.bytedance.pangle.util.j.a(assets));
        java.util.List<java.lang.String> a2 = com.bytedance.pangle.util.j.a(assets2);
        for (java.lang.String str : b2) {
            if (!hashSet.contains(str)) {
                assets = aVar.a(assets, str, true);
            }
        }
        for (java.lang.String str2 : a2) {
            if (!isOtherPlugin(str2, a, b) && !hashSet.contains(str2) && !b2.contains(str2)) {
                assets = aVar.a(assets, str2, false);
            }
        }
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "pluginAssets = " + com.bytedance.pangle.util.j.b(assets));
        return assets;
    }

    private android.content.res.Resources.NotFoundException handleException(android.content.res.Resources.NotFoundException notFoundException) {
        return new android.content.res.Resources.NotFoundException(("Resources#Assets: " + com.bytedance.pangle.util.j.b(getAssets())) + "," + notFoundException.getMessage());
    }

    private static boolean isOtherPlugin(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String packageResourcePath = com.bytedance.pangle.Zeus.getAppApplication().getPackageResourcePath();
        if (!android.text.TextUtils.isEmpty(str3)) {
            packageResourcePath = packageResourcePath.replaceFirst(str2, str3);
            str = str.replaceFirst(str2, str3);
        }
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, str + " " + packageResourcePath + " " + str2 + " " + str3);
        if (android.text.TextUtils.equals(str, packageResourcePath) || str.contains("/tinker/patch-")) {
            return false;
        }
        if (android.text.TextUtils.isEmpty(str2) || !str.contains(str2)) {
            return !android.text.TextUtils.isEmpty(str3) && str.contains(str3);
        }
        return true;
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public android.content.res.XmlResourceParser getAnimation(int i) {
        try {
            return super.getAnimation(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) {
        try {
            return super.getBoolean(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i) {
        try {
            return super.getColor(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        try {
            return super.getColor(i, theme);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getColorStateList(int i) {
        try {
            return super.getColorStateList(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getColorStateList(int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        try {
            return super.getColorStateList(i, theme);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) {
        try {
            return super.getDimension(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) {
        try {
            return super.getDimensionPixelOffset(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) {
        try {
            return super.getDimensionPixelSize(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i) {
        try {
            return super.getDrawable(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        try {
            return super.getDrawable(i, theme);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getDrawableForDensity(int i, int i2) {
        try {
            return super.getDrawableForDensity(i, i2);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getDrawableForDensity(int i, int i2, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i, i2, theme);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public float getFloat(int i) {
        try {
            return super.getFloat(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public android.graphics.Typeface getFont(int i) {
        try {
            return super.getFont(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        try {
            return super.getFraction(i, i2, i3);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public int[] getIntArray(int i) {
        try {
            return super.getIntArray(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) {
        try {
            return super.getInteger(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public android.content.res.XmlResourceParser getLayout(int i) {
        try {
            return super.getLayout(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public android.graphics.Movie getMovie(int i) {
        try {
            return super.getMovie(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.String getQuantityString(int i, int i2) {
        try {
            return super.getQuantityString(i, i2);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.String getQuantityString(int i, int i2, java.lang.Object... objArr) {
        try {
            return super.getQuantityString(i, i2, objArr);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.CharSequence getQuantityText(int i, int i2) {
        try {
            return super.getQuantityText(i, i2);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourceEntryName(int i) {
        try {
            return super.getResourceEntryName(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourceName(int i) {
        try {
            return super.getResourceName(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourcePackageName(int i) {
        try {
            return super.getResourcePackageName(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourceTypeName(int i) {
        try {
            return super.getResourceTypeName(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.String getString(int i) {
        try {
            return super.getString(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.String getString(int i, java.lang.Object... objArr) {
        try {
            return super.getString(i, objArr);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.String[] getStringArray(int i) {
        try {
            return super.getStringArray(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.CharSequence getText(int i) {
        try {
            return super.getText(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence getText(int i, java.lang.CharSequence charSequence) {
        try {
            return super.getText(i, charSequence);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.lang.CharSequence[] getTextArray(int i) {
        try {
            return super.getTextArray(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i, android.util.TypedValue typedValue, boolean z) {
        try {
            super.getValue(i, typedValue, z);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(java.lang.String str, android.util.TypedValue typedValue, boolean z) {
        try {
            super.getValue(str, typedValue, z);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, android.util.TypedValue typedValue, boolean z) {
        try {
            super.getValueForDensity(i, i2, typedValue, z);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public android.content.res.XmlResourceParser getXml(int i) {
        try {
            return super.getXml(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public android.content.res.TypedArray obtainTypedArray(int i) {
        try {
            return super.obtainTypedArray(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.io.InputStream openRawResource(int i) {
        try {
            return super.openRawResource(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @androidx.annotation.NonNull
    public java.io.InputStream openRawResource(int i, android.util.TypedValue typedValue) {
        try {
            return super.openRawResource(i, typedValue);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public android.content.res.AssetFileDescriptor openRawResourceFd(int i) {
        try {
            return super.openRawResourceFd(i);
        } catch (android.content.res.Resources.NotFoundException e) {
            throw handleException(e);
        }
    }
}
