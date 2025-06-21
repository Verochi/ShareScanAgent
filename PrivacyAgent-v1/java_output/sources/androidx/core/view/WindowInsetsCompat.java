package androidx.core.view;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    @androidx.annotation.NonNull
    public static final androidx.core.view.WindowInsetsCompat CONSUMED;
    private static final java.lang.String TAG = "WindowInsetsCompat";
    private final androidx.core.view.WindowInsetsCompat.Impl mImpl;

    @androidx.annotation.RequiresApi(21)
    public static class Api21ReflectionHolder {
        private static java.lang.reflect.Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static java.lang.reflect.Field sStableInsets;
        private static java.lang.reflect.Field sViewAttachInfoField;

        static {
            try {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                java.lang.Class<?> cls = java.lang.Class.forName("android.view.View$AttachInfo");
                java.lang.reflect.Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                java.lang.reflect.Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
                sReflectionSucceeded = true;
            } catch (java.lang.ReflectiveOperationException e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Failed to get visible insets from AttachInfo ");
                sb.append(e.getMessage());
            }
        }

        private Api21ReflectionHolder() {
        }

        @androidx.annotation.Nullable
        public static androidx.core.view.WindowInsetsCompat getRootWindowInsets(@androidx.annotation.NonNull android.view.View view) {
            if (sReflectionSucceeded && view.isAttachedToWindow()) {
                try {
                    java.lang.Object obj = sViewAttachInfoField.get(view.getRootView());
                    if (obj != null) {
                        android.graphics.Rect rect = (android.graphics.Rect) sStableInsets.get(obj);
                        android.graphics.Rect rect2 = (android.graphics.Rect) sContentInsets.get(obj);
                        if (rect != null && rect2 != null) {
                            androidx.core.view.WindowInsetsCompat build = new androidx.core.view.WindowInsetsCompat.Builder().setStableInsets(androidx.core.graphics.Insets.of(rect)).setSystemWindowInsets(androidx.core.graphics.Insets.of(rect2)).build();
                            build.setRootWindowInsets(build);
                            build.copyRootViewBounds(view.getRootView());
                            return build;
                        }
                    }
                } catch (java.lang.IllegalAccessException e) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to get insets from AttachInfo. ");
                    sb.append(e.getMessage());
                }
            }
            return null;
        }
    }

    public static final class Builder {
        private final androidx.core.view.WindowInsetsCompat.BuilderImpl mImpl;

        public Builder() {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.mImpl = new androidx.core.view.WindowInsetsCompat.BuilderImpl30();
            } else if (i >= 29) {
                this.mImpl = new androidx.core.view.WindowInsetsCompat.BuilderImpl29();
            } else {
                this.mImpl = new androidx.core.view.WindowInsetsCompat.BuilderImpl20();
            }
        }

        public Builder(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.mImpl = new androidx.core.view.WindowInsetsCompat.BuilderImpl30(windowInsetsCompat);
            } else if (i >= 29) {
                this.mImpl = new androidx.core.view.WindowInsetsCompat.BuilderImpl29(windowInsetsCompat);
            } else {
                this.mImpl = new androidx.core.view.WindowInsetsCompat.BuilderImpl20(windowInsetsCompat);
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat.Builder setDisplayCutout(@androidx.annotation.Nullable androidx.core.view.DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.setDisplayCutout(displayCutoutCompat);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat.Builder setInsets(int i, @androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mImpl.setInsets(i, insets);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat.Builder setInsetsIgnoringVisibility(int i, @androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mImpl.setInsetsIgnoringVisibility(i, insets);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setMandatorySystemGestureInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setStableInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setSystemGestureInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setSystemWindowInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.view.WindowInsetsCompat.Builder setTappableElementInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat.Builder setVisible(int i, boolean z) {
            this.mImpl.setVisible(i, z);
            return this;
        }
    }

    public static class BuilderImpl {
        private final androidx.core.view.WindowInsetsCompat mInsets;
        androidx.core.graphics.Insets[] mInsetsTypeMask;

        public BuilderImpl() {
            this(new androidx.core.view.WindowInsetsCompat((androidx.core.view.WindowInsetsCompat) null));
        }

        public BuilderImpl(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }

        public final void applyInsetTypes() {
            androidx.core.graphics.Insets[] insetsArr = this.mInsetsTypeMask;
            if (insetsArr != null) {
                androidx.core.graphics.Insets insets = insetsArr[androidx.core.view.WindowInsetsCompat.Type.indexOf(1)];
                androidx.core.graphics.Insets insets2 = this.mInsetsTypeMask[androidx.core.view.WindowInsetsCompat.Type.indexOf(2)];
                if (insets != null && insets2 != null) {
                    setSystemWindowInsets(androidx.core.graphics.Insets.max(insets, insets2));
                } else if (insets != null) {
                    setSystemWindowInsets(insets);
                } else if (insets2 != null) {
                    setSystemWindowInsets(insets2);
                }
                androidx.core.graphics.Insets insets3 = this.mInsetsTypeMask[androidx.core.view.WindowInsetsCompat.Type.indexOf(16)];
                if (insets3 != null) {
                    setSystemGestureInsets(insets3);
                }
                androidx.core.graphics.Insets insets4 = this.mInsetsTypeMask[androidx.core.view.WindowInsetsCompat.Type.indexOf(32)];
                if (insets4 != null) {
                    setMandatorySystemGestureInsets(insets4);
                }
                androidx.core.graphics.Insets insets5 = this.mInsetsTypeMask[androidx.core.view.WindowInsetsCompat.Type.indexOf(64)];
                if (insets5 != null) {
                    setTappableElementInsets(insets5);
                }
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        public void setDisplayCutout(@androidx.annotation.Nullable androidx.core.view.DisplayCutoutCompat displayCutoutCompat) {
        }

        public void setInsets(int i, @androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new androidx.core.graphics.Insets[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.mInsetsTypeMask[androidx.core.view.WindowInsetsCompat.Type.indexOf(i2)] = insets;
                }
            }
        }

        public void setInsetsIgnoringVisibility(int i, @androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            if (i == 8) {
                throw new java.lang.IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        public void setMandatorySystemGestureInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        }

        public void setStableInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        }

        public void setSystemGestureInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        }

        public void setSystemWindowInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        }

        public void setTappableElementInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        }

        public void setVisible(int i, boolean z) {
        }
    }

    @androidx.annotation.RequiresApi(api = 20)
    public static class BuilderImpl20 extends androidx.core.view.WindowInsetsCompat.BuilderImpl {
        private static java.lang.reflect.Constructor<android.view.WindowInsets> sConstructor;
        private static boolean sConstructorFetched;
        private static java.lang.reflect.Field sConsumedField;
        private static boolean sConsumedFieldFetched;
        private android.view.WindowInsets mInsets;
        private androidx.core.graphics.Insets mStableInsets;

        public BuilderImpl20() {
            this.mInsets = createWindowInsetsInstance();
        }

        public BuilderImpl20(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat.toWindowInsets();
        }

        @androidx.annotation.Nullable
        private static android.view.WindowInsets createWindowInsetsInstance() {
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = android.view.WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (java.lang.ReflectiveOperationException unused) {
                }
                sConsumedFieldFetched = true;
            }
            java.lang.reflect.Field field = sConsumedField;
            if (field != null) {
                try {
                    android.view.WindowInsets windowInsets = (android.view.WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new android.view.WindowInsets(windowInsets);
                    }
                } catch (java.lang.ReflectiveOperationException unused2) {
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = android.view.WindowInsets.class.getConstructor(android.graphics.Rect.class);
                } catch (java.lang.ReflectiveOperationException unused3) {
                }
                sConstructorFetched = true;
            }
            java.lang.reflect.Constructor<android.view.WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new android.graphics.Rect());
                } catch (java.lang.ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat build() {
            applyInsetTypes();
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(this.mInsets);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            windowInsetsCompat.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@androidx.annotation.Nullable androidx.core.graphics.Insets insets) {
            this.mStableInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            android.view.WindowInsets windowInsets = this.mInsets;
            if (windowInsets != null) {
                this.mInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }
    }

    @androidx.annotation.RequiresApi(api = 29)
    public static class BuilderImpl29 extends androidx.core.view.WindowInsetsCompat.BuilderImpl {
        final android.view.WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = new android.view.WindowInsets.Builder();
        }

        public BuilderImpl29(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            android.view.WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            this.mPlatBuilder = windowInsets != null ? new android.view.WindowInsets.Builder(windowInsets) : new android.view.WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat build() {
            android.view.WindowInsets build;
            applyInsetTypes();
            build = this.mPlatBuilder.build();
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(build);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setDisplayCutout(@androidx.annotation.Nullable androidx.core.view.DisplayCutoutCompat displayCutoutCompat) {
            this.mPlatBuilder.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setMandatorySystemGestureInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemGestureInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setTappableElementInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class BuilderImpl30 extends androidx.core.view.WindowInsetsCompat.BuilderImpl29 {
        public BuilderImpl30() {
        }

        public BuilderImpl30(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsets(int i, @androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mPlatBuilder.setInsets(androidx.core.view.WindowInsetsCompat.TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsetsIgnoringVisibility(int i, @androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(androidx.core.view.WindowInsetsCompat.TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setVisible(int i, boolean z) {
            this.mPlatBuilder.setVisible(androidx.core.view.WindowInsetsCompat.TypeImpl30.toPlatformType(i), z);
        }
    }

    public static class Impl {

        @androidx.annotation.NonNull
        static final androidx.core.view.WindowInsetsCompat CONSUMED = new androidx.core.view.WindowInsetsCompat.Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        final androidx.core.view.WindowInsetsCompat mHost;

        public Impl(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public void copyRootViewBounds(@androidx.annotation.NonNull android.view.View view) {
        }

        public void copyWindowDataInto(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.core.view.WindowInsetsCompat.Impl)) {
                return false;
            }
            androidx.core.view.WindowInsetsCompat.Impl impl = (androidx.core.view.WindowInsetsCompat.Impl) obj;
            return isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && androidx.core.util.ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) && androidx.core.util.ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) && androidx.core.util.ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout());
        }

        @androidx.annotation.Nullable
        public androidx.core.view.DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getInsets(int i) {
            return androidx.core.graphics.Insets.NONE;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getInsetsIgnoringVisibility(int i) {
            if ((i & 8) == 0) {
                return androidx.core.graphics.Insets.NONE;
            }
            throw new java.lang.IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getStableInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getSystemWindowInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return androidx.core.util.ObjectsCompat.hash(java.lang.Boolean.valueOf(isRound()), java.lang.Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            return CONSUMED;
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public boolean isVisible(int i) {
            return true;
        }

        public void setOverriddenInsets(androidx.core.graphics.Insets[] insetsArr) {
        }

        public void setRootViewData(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        }

        public void setRootWindowInsets(@androidx.annotation.Nullable androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(androidx.core.graphics.Insets insets) {
        }
    }

    @androidx.annotation.RequiresApi(20)
    public static class Impl20 extends androidx.core.view.WindowInsetsCompat.Impl {
        private static java.lang.Class<?> sAttachInfoClass;
        private static java.lang.reflect.Field sAttachInfoField;
        private static java.lang.reflect.Method sGetViewRootImplMethod;
        private static java.lang.Class<?> sViewRootImplClass;
        private static java.lang.reflect.Field sVisibleInsetsField;
        private static boolean sVisibleRectReflectionFetched;
        private androidx.core.graphics.Insets[] mOverriddenInsets;

        @androidx.annotation.NonNull
        final android.view.WindowInsets mPlatformInsets;
        androidx.core.graphics.Insets mRootViewVisibleInsets;
        private androidx.core.view.WindowInsetsCompat mRootWindowInsets;
        private androidx.core.graphics.Insets mSystemWindowInsets;

        public Impl20(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        public Impl20(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat.Impl20 impl20) {
            this(windowInsetsCompat, new android.view.WindowInsets(impl20.mPlatformInsets));
        }

        @androidx.annotation.NonNull
        @android.annotation.SuppressLint({"WrongConstant"})
        private androidx.core.graphics.Insets getInsets(int i, boolean z) {
            androidx.core.graphics.Insets insets = androidx.core.graphics.Insets.NONE;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    insets = androidx.core.graphics.Insets.max(insets, getInsetsForType(i2, z));
                }
            }
            return insets;
        }

        private androidx.core.graphics.Insets getRootStableInsets() {
            androidx.core.view.WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            return windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : androidx.core.graphics.Insets.NONE;
        }

        @androidx.annotation.Nullable
        private androidx.core.graphics.Insets getVisibleInsets(@androidx.annotation.NonNull android.view.View view) {
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                throw new java.lang.UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!sVisibleRectReflectionFetched) {
                loadReflectionField();
            }
            java.lang.reflect.Method method = sGetViewRootImplMethod;
            if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
                try {
                    java.lang.Object invoke = method.invoke(view, new java.lang.Object[0]);
                    if (invoke == null) {
                        return null;
                    }
                    android.graphics.Rect rect = (android.graphics.Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                    if (rect != null) {
                        return androidx.core.graphics.Insets.of(rect);
                    }
                    return null;
                } catch (java.lang.ReflectiveOperationException e) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to get visible insets. (Reflection error). ");
                    sb.append(e.getMessage());
                }
            }
            return null;
        }

        @android.annotation.SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = android.view.View.class.getDeclaredMethod("getViewRootImpl", new java.lang.Class[0]);
                sViewRootImplClass = java.lang.Class.forName("android.view.ViewRootImpl");
                java.lang.Class<?> cls = java.lang.Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = sViewRootImplClass.getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (java.lang.ReflectiveOperationException e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Failed to get visible insets. (Reflection error). ");
                sb.append(e.getMessage());
            }
            sVisibleRectReflectionFetched = true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyRootViewBounds(@androidx.annotation.NonNull android.view.View view) {
            androidx.core.graphics.Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = androidx.core.graphics.Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyWindowDataInto(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
            windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(java.lang.Object obj) {
            if (super.equals(obj)) {
                return java.util.Objects.equals(this.mRootViewVisibleInsets, ((androidx.core.view.WindowInsetsCompat.Impl20) obj).mRootViewVisibleInsets);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getInsets(int i) {
            return getInsets(i, false);
        }

        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getInsetsForType(int i, boolean z) {
            androidx.core.graphics.Insets stableInsets;
            int i2;
            if (i == 1) {
                return z ? androidx.core.graphics.Insets.of(0, java.lang.Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0) : androidx.core.graphics.Insets.of(0, getSystemWindowInsets().top, 0, 0);
            }
            if (i == 2) {
                if (z) {
                    androidx.core.graphics.Insets rootStableInsets = getRootStableInsets();
                    androidx.core.graphics.Insets stableInsets2 = getStableInsets();
                    return androidx.core.graphics.Insets.of(java.lang.Math.max(rootStableInsets.left, stableInsets2.left), 0, java.lang.Math.max(rootStableInsets.right, stableInsets2.right), java.lang.Math.max(rootStableInsets.bottom, stableInsets2.bottom));
                }
                androidx.core.graphics.Insets systemWindowInsets = getSystemWindowInsets();
                androidx.core.view.WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                stableInsets = windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : null;
                int i3 = systemWindowInsets.bottom;
                if (stableInsets != null) {
                    i3 = java.lang.Math.min(i3, stableInsets.bottom);
                }
                return androidx.core.graphics.Insets.of(systemWindowInsets.left, 0, systemWindowInsets.right, i3);
            }
            if (i != 8) {
                if (i == 16) {
                    return getSystemGestureInsets();
                }
                if (i == 32) {
                    return getMandatorySystemGestureInsets();
                }
                if (i == 64) {
                    return getTappableElementInsets();
                }
                if (i != 128) {
                    return androidx.core.graphics.Insets.NONE;
                }
                androidx.core.view.WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                androidx.core.view.DisplayCutoutCompat displayCutout = windowInsetsCompat2 != null ? windowInsetsCompat2.getDisplayCutout() : getDisplayCutout();
                return displayCutout != null ? androidx.core.graphics.Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()) : androidx.core.graphics.Insets.NONE;
            }
            androidx.core.graphics.Insets[] insetsArr = this.mOverriddenInsets;
            stableInsets = insetsArr != null ? insetsArr[androidx.core.view.WindowInsetsCompat.Type.indexOf(8)] : null;
            if (stableInsets != null) {
                return stableInsets;
            }
            androidx.core.graphics.Insets systemWindowInsets2 = getSystemWindowInsets();
            androidx.core.graphics.Insets rootStableInsets2 = getRootStableInsets();
            int i4 = systemWindowInsets2.bottom;
            if (i4 > rootStableInsets2.bottom) {
                return androidx.core.graphics.Insets.of(0, 0, 0, i4);
            }
            androidx.core.graphics.Insets insets = this.mRootViewVisibleInsets;
            return (insets == null || insets.equals(androidx.core.graphics.Insets.NONE) || (i2 = this.mRootViewVisibleInsets.bottom) <= rootStableInsets2.bottom) ? androidx.core.graphics.Insets.NONE : androidx.core.graphics.Insets.of(0, 0, 0, i2);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getInsetsIgnoringVisibility(int i) {
            return getInsets(i, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public final androidx.core.graphics.Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = androidx.core.graphics.Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            androidx.core.view.WindowInsetsCompat.Builder builder = new androidx.core.view.WindowInsetsCompat.Builder(androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            builder.setSystemWindowInsets(androidx.core.view.WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i, i2, i3, i4));
            builder.setStableInsets(androidx.core.view.WindowInsetsCompat.insetInsets(getStableInsets(), i, i2, i3, i4));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public boolean isTypeVisible(int i) {
            if (i != 1 && i != 2) {
                if (i == 4) {
                    return false;
                }
                if (i != 8 && i != 128) {
                    return true;
                }
            }
            return !getInsetsForType(i, false).equals(androidx.core.graphics.Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @android.annotation.SuppressLint({"WrongConstant"})
        public boolean isVisible(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0 && !isTypeVisible(i2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(androidx.core.graphics.Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootViewData(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootWindowInsets(@androidx.annotation.Nullable androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static class Impl21 extends androidx.core.view.WindowInsetsCompat.Impl20 {
        private androidx.core.graphics.Insets mStableInsets;

        public Impl21(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mStableInsets = null;
        }

        public Impl21(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat.Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.mStableInsets = null;
            this.mStableInsets = impl21.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat consumeStableInsets() {
            return androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat consumeSystemWindowInsets() {
            return androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public final androidx.core.graphics.Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = androidx.core.graphics.Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@androidx.annotation.Nullable androidx.core.graphics.Insets insets) {
            this.mStableInsets = insets;
        }
    }

    @androidx.annotation.RequiresApi(28)
    public static class Impl28 extends androidx.core.view.WindowInsetsCompat.Impl21 {
        public Impl28(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public Impl28(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat.Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat consumeDisplayCutout() {
            android.view.WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.mPlatformInsets.consumeDisplayCutout();
            return androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(consumeDisplayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.core.view.WindowInsetsCompat.Impl28)) {
                return false;
            }
            androidx.core.view.WindowInsetsCompat.Impl28 impl28 = (androidx.core.view.WindowInsetsCompat.Impl28) obj;
            return java.util.Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) && java.util.Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.Nullable
        public androidx.core.view.DisplayCutoutCompat getDisplayCutout() {
            android.view.DisplayCutout displayCutout;
            displayCutout = this.mPlatformInsets.getDisplayCutout();
            return androidx.core.view.DisplayCutoutCompat.wrap(displayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    @androidx.annotation.RequiresApi(29)
    public static class Impl29 extends androidx.core.view.WindowInsetsCompat.Impl28 {
        private androidx.core.graphics.Insets mMandatorySystemGestureInsets;
        private androidx.core.graphics.Insets mSystemGestureInsets;
        private androidx.core.graphics.Insets mTappableElementInsets;

        public Impl29(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        public Impl29(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat.Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getMandatorySystemGestureInsets() {
            android.graphics.Insets mandatorySystemGestureInsets;
            if (this.mMandatorySystemGestureInsets == null) {
                mandatorySystemGestureInsets = this.mPlatformInsets.getMandatorySystemGestureInsets();
                this.mMandatorySystemGestureInsets = androidx.core.graphics.Insets.toCompatInsets(mandatorySystemGestureInsets);
            }
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getSystemGestureInsets() {
            android.graphics.Insets systemGestureInsets;
            if (this.mSystemGestureInsets == null) {
                systemGestureInsets = this.mPlatformInsets.getSystemGestureInsets();
                this.mSystemGestureInsets = androidx.core.graphics.Insets.toCompatInsets(systemGestureInsets);
            }
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getTappableElementInsets() {
            android.graphics.Insets tappableElementInsets;
            if (this.mTappableElementInsets == null) {
                tappableElementInsets = this.mPlatformInsets.getTappableElementInsets();
                this.mTappableElementInsets = androidx.core.graphics.Insets.toCompatInsets(tappableElementInsets);
            }
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
            android.view.WindowInsets inset;
            inset = this.mPlatformInsets.inset(i, i2, i3, i4);
            return androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(inset);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@androidx.annotation.Nullable androidx.core.graphics.Insets insets) {
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class Impl30 extends androidx.core.view.WindowInsetsCompat.Impl29 {

        @androidx.annotation.NonNull
        static final androidx.core.view.WindowInsetsCompat CONSUMED;

        static {
            android.view.WindowInsets windowInsets;
            windowInsets = android.view.WindowInsets.CONSUMED;
            CONSUMED = androidx.core.view.WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }

        public Impl30(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public Impl30(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat.Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void copyRootViewBounds(@androidx.annotation.NonNull android.view.View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getInsets(int i) {
            android.graphics.Insets insets;
            insets = this.mPlatformInsets.getInsets(androidx.core.view.WindowInsetsCompat.TypeImpl30.toPlatformType(i));
            return androidx.core.graphics.Insets.toCompatInsets(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @androidx.annotation.NonNull
        public androidx.core.graphics.Insets getInsetsIgnoringVisibility(int i) {
            android.graphics.Insets insetsIgnoringVisibility;
            insetsIgnoringVisibility = this.mPlatformInsets.getInsetsIgnoringVisibility(androidx.core.view.WindowInsetsCompat.TypeImpl30.toPlatformType(i));
            return androidx.core.graphics.Insets.toCompatInsets(insetsIgnoringVisibility);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int i) {
            boolean isVisible;
            isVisible = this.mPlatformInsets.isVisible(androidx.core.view.WindowInsetsCompat.TypeImpl30.toPlatformType(i));
            return isVisible;
        }
    }

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public @interface InsetsType {
        }

        private Type() {
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int indexOf(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new java.lang.IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static final class TypeImpl30 {
        private TypeImpl30() {
        }

        public static int toPlatformType(int i) {
            int statusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        statusBars = android.view.WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        statusBars = android.view.WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        statusBars = android.view.WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        statusBars = android.view.WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        statusBars = android.view.WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        statusBars = android.view.WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        statusBars = android.view.WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        statusBars = android.view.WindowInsets.Type.displayCutout();
                    }
                    i2 |= statusBars;
                }
            }
            return i2;
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            CONSUMED = androidx.core.view.WindowInsetsCompat.Impl30.CONSUMED;
        } else {
            CONSUMED = androidx.core.view.WindowInsetsCompat.Impl.CONSUMED;
        }
    }

    @androidx.annotation.RequiresApi(20)
    private WindowInsetsCompat(@androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl30(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl29(this, windowInsets);
        } else if (i >= 28) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl28(this, windowInsets);
        } else {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl21(this, windowInsets);
        }
    }

    public WindowInsetsCompat(@androidx.annotation.Nullable androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat == null) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl(this);
            return;
        }
        androidx.core.view.WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 30 && (impl instanceof androidx.core.view.WindowInsetsCompat.Impl30)) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl30(this, (androidx.core.view.WindowInsetsCompat.Impl30) impl);
        } else if (i >= 29 && (impl instanceof androidx.core.view.WindowInsetsCompat.Impl29)) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl29(this, (androidx.core.view.WindowInsetsCompat.Impl29) impl);
        } else if (i >= 28 && (impl instanceof androidx.core.view.WindowInsetsCompat.Impl28)) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl28(this, (androidx.core.view.WindowInsetsCompat.Impl28) impl);
        } else if (impl instanceof androidx.core.view.WindowInsetsCompat.Impl21) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl21(this, (androidx.core.view.WindowInsetsCompat.Impl21) impl);
        } else if (impl instanceof androidx.core.view.WindowInsetsCompat.Impl20) {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl20(this, (androidx.core.view.WindowInsetsCompat.Impl20) impl);
        } else {
            this.mImpl = new androidx.core.view.WindowInsetsCompat.Impl(this);
        }
        impl.copyWindowDataInto(this);
    }

    public static androidx.core.graphics.Insets insetInsets(@androidx.annotation.NonNull androidx.core.graphics.Insets insets, int i, int i2, int i3, int i4) {
        int max = java.lang.Math.max(0, insets.left - i);
        int max2 = java.lang.Math.max(0, insets.top - i2);
        int max3 = java.lang.Math.max(0, insets.right - i3);
        int max4 = java.lang.Math.max(0, insets.bottom - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? insets : androidx.core.graphics.Insets.of(max, max2, max3, max4);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(20)
    public static androidx.core.view.WindowInsetsCompat toWindowInsetsCompat(@androidx.annotation.NonNull android.view.WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(20)
    public static androidx.core.view.WindowInsetsCompat toWindowInsetsCompat(@androidx.annotation.NonNull android.view.WindowInsets windowInsets, @androidx.annotation.Nullable android.view.View view) {
        androidx.core.view.WindowInsetsCompat windowInsetsCompat = new androidx.core.view.WindowInsetsCompat((android.view.WindowInsets) androidx.core.util.Preconditions.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(androidx.core.view.ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.view.WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.view.WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.view.WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public void copyRootViewBounds(@androidx.annotation.NonNull android.view.View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof androidx.core.view.WindowInsetsCompat) {
            return androidx.core.util.ObjectsCompat.equals(this.mImpl, ((androidx.core.view.WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    @androidx.annotation.Nullable
    public androidx.core.view.DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @androidx.annotation.NonNull
    public androidx.core.graphics.Insets getInsets(int i) {
        return this.mImpl.getInsets(i);
    }

    @androidx.annotation.NonNull
    public androidx.core.graphics.Insets getInsetsIgnoringVisibility(int i) {
        return this.mImpl.getInsetsIgnoringVisibility(i);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.graphics.Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @java.lang.Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @java.lang.Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @java.lang.Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @java.lang.Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.graphics.Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.graphics.Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @java.lang.Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @java.lang.Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @java.lang.Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @java.lang.Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.graphics.Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.graphics.Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        androidx.core.graphics.Insets insets = getInsets(androidx.core.view.WindowInsetsCompat.Type.all());
        androidx.core.graphics.Insets insets2 = androidx.core.graphics.Insets.NONE;
        return (insets.equals(insets2) && getInsetsIgnoringVisibility(androidx.core.view.WindowInsetsCompat.Type.all() ^ androidx.core.view.WindowInsetsCompat.Type.ime()).equals(insets2) && getDisplayCutout() == null) ? false : true;
    }

    @java.lang.Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(androidx.core.graphics.Insets.NONE);
    }

    @java.lang.Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(androidx.core.graphics.Insets.NONE);
    }

    public int hashCode() {
        androidx.core.view.WindowInsetsCompat.Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @androidx.annotation.NonNull
    public androidx.core.view.WindowInsetsCompat inset(@androidx.annotation.IntRange(from = 0) int i, @androidx.annotation.IntRange(from = 0) int i2, @androidx.annotation.IntRange(from = 0) int i3, @androidx.annotation.IntRange(from = 0) int i4) {
        return this.mImpl.inset(i, i2, i3, i4);
    }

    @androidx.annotation.NonNull
    public androidx.core.view.WindowInsetsCompat inset(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int i) {
        return this.mImpl.isVisible(i);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.view.WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new androidx.core.view.WindowInsetsCompat.Builder(this).setSystemWindowInsets(androidx.core.graphics.Insets.of(i, i2, i3, i4)).build();
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public androidx.core.view.WindowInsetsCompat replaceSystemWindowInsets(@androidx.annotation.NonNull android.graphics.Rect rect) {
        return new androidx.core.view.WindowInsetsCompat.Builder(this).setSystemWindowInsets(androidx.core.graphics.Insets.of(rect)).build();
    }

    public void setOverriddenInsets(androidx.core.graphics.Insets[] insetsArr) {
        this.mImpl.setOverriddenInsets(insetsArr);
    }

    public void setRootViewData(@androidx.annotation.NonNull androidx.core.graphics.Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    public void setRootWindowInsets(@androidx.annotation.Nullable androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    public void setStableInsets(@androidx.annotation.Nullable androidx.core.graphics.Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(20)
    public android.view.WindowInsets toWindowInsets() {
        androidx.core.view.WindowInsetsCompat.Impl impl = this.mImpl;
        if (impl instanceof androidx.core.view.WindowInsetsCompat.Impl20) {
            return ((androidx.core.view.WindowInsetsCompat.Impl20) impl).mPlatformInsets;
        }
        return null;
    }
}
