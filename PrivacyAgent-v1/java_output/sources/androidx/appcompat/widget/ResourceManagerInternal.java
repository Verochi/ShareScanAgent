package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ResourceManagerInternal {
    private static final boolean DEBUG = false;
    private static androidx.appcompat.widget.ResourceManagerInternal INSTANCE = null;
    private static final java.lang.String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final java.lang.String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final java.lang.String TAG = "ResourceManagerInternal";
    private androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate> mDelegates;
    private final java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>>> mDrawableCaches = new java.util.WeakHashMap<>(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks mHooks;
    private androidx.collection.SparseArrayCompat<java.lang.String> mKnownDrawableIdTags;
    private java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> mTintLists;
    private android.util.TypedValue mTypedValue;
    private static final android.graphics.PorterDuff.Mode DEFAULT_MODE = android.graphics.PorterDuff.Mode.SRC_IN;
    private static final androidx.appcompat.widget.ResourceManagerInternal.ColorFilterLruCache COLOR_FILTER_CACHE = new androidx.appcompat.widget.ResourceManagerInternal.ColorFilterLruCache(6);

    public static class AsldcInflateDelegate implements androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public android.graphics.drawable.Drawable createFromXmlInner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
            try {
                return androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
    }

    public static class AvdcInflateDelegate implements androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public android.graphics.drawable.Drawable createFromXmlInner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
    }

    public static class ColorFilterLruCache extends androidx.collection.LruCache<java.lang.Integer, android.graphics.PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        private static int generateCacheKey(int i, android.graphics.PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        public android.graphics.PorterDuffColorFilter get(int i, android.graphics.PorterDuff.Mode mode) {
            return get(java.lang.Integer.valueOf(generateCacheKey(i, mode)));
        }

        public android.graphics.PorterDuffColorFilter put(int i, android.graphics.PorterDuff.Mode mode, android.graphics.PorterDuffColorFilter porterDuffColorFilter) {
            return put(java.lang.Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }
    }

    public static class DrawableDelegate implements androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public android.graphics.drawable.Drawable createFromXmlInner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
            java.lang.String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    android.graphics.drawable.Drawable drawable = (android.graphics.drawable.Drawable) androidx.appcompat.widget.ResourceManagerInternal.DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(android.graphics.drawable.Drawable.class).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (java.lang.Exception unused) {
                }
            }
            return null;
        }
    }

    public interface InflateDelegate {
        android.graphics.drawable.Drawable createFromXmlInner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        @androidx.annotation.Nullable
        android.graphics.drawable.Drawable createDrawableFor(@androidx.annotation.NonNull androidx.appcompat.widget.ResourceManagerInternal resourceManagerInternal, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i);

        @androidx.annotation.Nullable
        android.content.res.ColorStateList getTintListForDrawableRes(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i);

        @androidx.annotation.Nullable
        android.graphics.PorterDuff.Mode getTintModeForDrawableRes(int i);

        boolean tintDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable);

        boolean tintDrawableUsingColorFilter(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable);
    }

    public static class VdcInflateDelegate implements androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate {
        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public android.graphics.drawable.Drawable createFromXmlInner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
    }

    private void addDelegate(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new androidx.collection.SimpleArrayMap<>();
        }
        this.mDelegates.put(str, inflateDelegate);
    }

    private synchronized boolean addDrawableToCache(@androidx.annotation.NonNull android.content.Context context, long j, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            longSparseArray = new androidx.collection.LongSparseArray<>();
            this.mDrawableCaches.put(context, longSparseArray);
        }
        longSparseArray.put(j, new java.lang.ref.WeakReference<>(constantState));
        return true;
    }

    private void addTintListToCache(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new java.util.WeakHashMap<>();
        }
        androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new androidx.collection.SparseArrayCompat<>();
            this.mTintLists.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i, colorStateList);
    }

    private void checkVectorDrawableSetup(@androidx.annotation.NonNull android.content.Context context) {
        if (this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        android.graphics.drawable.Drawable drawable = getDrawable(context, androidx.appcompat.resources.R.drawable.abc_vector_test);
        if (drawable == null || !isVectorDrawable(drawable)) {
            this.mHasCheckedVectorDrawableSetup = false;
            throw new java.lang.IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long createCacheKey(android.util.TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private android.graphics.drawable.Drawable createDrawableIfNeeded(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new android.util.TypedValue();
        }
        android.util.TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        android.graphics.drawable.Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks = this.mHooks;
        android.graphics.drawable.Drawable createDrawableFor = resourceManagerHooks == null ? null : resourceManagerHooks.createDrawableFor(this, context, i);
        if (createDrawableFor != null) {
            createDrawableFor.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, createCacheKey, createDrawableFor);
        }
        return createDrawableFor;
    }

    private static android.graphics.PorterDuffColorFilter createTintFilter(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized androidx.appcompat.widget.ResourceManagerInternal get() {
        androidx.appcompat.widget.ResourceManagerInternal resourceManagerInternal;
        synchronized (androidx.appcompat.widget.ResourceManagerInternal.class) {
            if (INSTANCE == null) {
                androidx.appcompat.widget.ResourceManagerInternal resourceManagerInternal2 = new androidx.appcompat.widget.ResourceManagerInternal();
                INSTANCE = resourceManagerInternal2;
                installDefaultInflateDelegates(resourceManagerInternal2);
            }
            resourceManagerInternal = INSTANCE;
        }
        return resourceManagerInternal;
    }

    private synchronized android.graphics.drawable.Drawable getCachedDrawable(@androidx.annotation.NonNull android.content.Context context, long j) {
        androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            return null;
        }
        java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState> weakReference = longSparseArray.get(j);
        if (weakReference != null) {
            android.graphics.drawable.Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.remove(j);
        }
        return null;
    }

    public static synchronized android.graphics.PorterDuffColorFilter getPorterDuffColorFilter(int i, android.graphics.PorterDuff.Mode mode) {
        android.graphics.PorterDuffColorFilter porterDuffColorFilter;
        synchronized (androidx.appcompat.widget.ResourceManagerInternal.class) {
            androidx.appcompat.widget.ResourceManagerInternal.ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
            porterDuffColorFilter = colorFilterLruCache.get(i, mode);
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new android.graphics.PorterDuffColorFilter(i, mode);
                colorFilterLruCache.put(i, mode, porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    private android.content.res.ColorStateList getTintListFromCache(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> sparseArrayCompat;
        java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> weakHashMap = this.mTintLists;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.get(i);
    }

    private static void installDefaultInflateDelegates(@androidx.annotation.NonNull androidx.appcompat.widget.ResourceManagerInternal resourceManagerInternal) {
        if (android.os.Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.addDelegate("vector", new androidx.appcompat.widget.ResourceManagerInternal.VdcInflateDelegate());
            resourceManagerInternal.addDelegate("animated-vector", new androidx.appcompat.widget.ResourceManagerInternal.AvdcInflateDelegate());
            resourceManagerInternal.addDelegate("animated-selector", new androidx.appcompat.widget.ResourceManagerInternal.AsldcInflateDelegate());
            resourceManagerInternal.addDelegate(com.anythink.expressad.foundation.h.i.c, new androidx.appcompat.widget.ResourceManagerInternal.DrawableDelegate());
        }
    }

    private static boolean isVectorDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat) || PLATFORM_VD_CLAZZ.equals(drawable.getClass().getName());
    }

    private android.graphics.drawable.Drawable loadDrawableFromDelegates(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        int next;
        androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate> simpleArrayMap = this.mDelegates;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        androidx.collection.SparseArrayCompat<java.lang.String> sparseArrayCompat = this.mKnownDrawableIdTags;
        if (sparseArrayCompat != null) {
            java.lang.String str = sparseArrayCompat.get(i);
            if (SKIP_DRAWABLE_TAG.equals(str) || (str != null && this.mDelegates.get(str) == null)) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new androidx.collection.SparseArrayCompat<>();
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new android.util.TypedValue();
        }
        android.util.TypedValue typedValue = this.mTypedValue;
        android.content.res.Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        android.graphics.drawable.Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        java.lang.CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                android.content.res.XmlResourceParser xml = resources.getXml(i);
                android.util.AttributeSet asAttributeSet = android.util.Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
                }
                java.lang.String name = xml.getName();
                this.mKnownDrawableIdTags.append(i, name);
                androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate inflateDelegate = this.mDelegates.get(name);
                if (inflateDelegate != null) {
                    cachedDrawable = inflateDelegate.createFromXmlInner(context, xml, asAttributeSet, context.getTheme());
                }
                if (cachedDrawable != null) {
                    cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                    addDrawableToCache(context, createCacheKey, cachedDrawable);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        if (cachedDrawable == null) {
            this.mKnownDrawableIdTags.append(i, SKIP_DRAWABLE_TAG);
        }
        return cachedDrawable;
    }

    private android.graphics.drawable.Drawable tintDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, boolean z, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.content.res.ColorStateList tintList = getTintList(context, i);
        if (tintList == null) {
            androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if ((resourceManagerHooks == null || !resourceManagerHooks.tintDrawable(context, i, drawable)) && !tintDrawableUsingColorFilter(context, i, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        android.graphics.drawable.Drawable wrap = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable);
        androidx.core.graphics.drawable.DrawableCompat.setTintList(wrap, tintList);
        android.graphics.PorterDuff.Mode tintMode = getTintMode(i);
        if (tintMode == null) {
            return wrap;
        }
        androidx.core.graphics.drawable.DrawableCompat.setTintMode(wrap, tintMode);
        return wrap;
    }

    public static void tintDrawable(android.graphics.drawable.Drawable drawable, androidx.appcompat.widget.TintInfo tintInfo, int[] iArr) {
        if (!androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            boolean z = tintInfo.mHasTintList;
            if (z || tintInfo.mHasTintMode) {
                drawable.setColorFilter(createTintFilter(z ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (android.os.Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public synchronized android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        return getDrawable(context, i, false);
    }

    public synchronized android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, boolean z) {
        android.graphics.drawable.Drawable loadDrawableFromDelegates;
        checkVectorDrawableSetup(context);
        loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = createDrawableIfNeeded(context, i);
        }
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = androidx.core.content.ContextCompat.getDrawable(context, i);
        }
        if (loadDrawableFromDelegates != null) {
            loadDrawableFromDelegates = tintDrawable(context, i, z, loadDrawableFromDelegates);
        }
        if (loadDrawableFromDelegates != null) {
            androidx.appcompat.widget.DrawableUtils.fixDrawable(loadDrawableFromDelegates);
        }
        return loadDrawableFromDelegates;
    }

    public synchronized android.content.res.ColorStateList getTintList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        android.content.res.ColorStateList tintListFromCache;
        tintListFromCache = getTintListFromCache(context, i);
        if (tintListFromCache == null) {
            androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks = this.mHooks;
            tintListFromCache = resourceManagerHooks == null ? null : resourceManagerHooks.getTintListForDrawableRes(context, i);
            if (tintListFromCache != null) {
                addTintListToCache(context, i, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    public android.graphics.PorterDuff.Mode getTintMode(int i) {
        androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.getTintModeForDrawableRes(i);
    }

    public synchronized void onConfigurationChanged(@androidx.annotation.NonNull android.content.Context context) {
        androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public synchronized android.graphics.drawable.Drawable onDrawableLoadedFromResources(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.widget.VectorEnabledTintResources vectorEnabledTintResources, @androidx.annotation.DrawableRes int i) {
        android.graphics.drawable.Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = vectorEnabledTintResources.superGetDrawable(i);
        }
        if (loadDrawableFromDelegates == null) {
            return null;
        }
        return tintDrawable(context, i, false, loadDrawableFromDelegates);
    }

    public synchronized void setHooks(androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks) {
        this.mHooks = resourceManagerHooks;
    }

    public boolean tintDrawableUsingColorFilter(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks = this.mHooks;
        return resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, i, drawable);
    }
}
