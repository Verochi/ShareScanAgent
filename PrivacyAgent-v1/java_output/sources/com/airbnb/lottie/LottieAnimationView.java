package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieAnimationView extends androidx.appcompat.widget.AppCompatImageView {
    public static final com.airbnb.lottie.LottieListener<java.lang.Throwable> L = new com.airbnb.lottie.LottieAnimationView.AnonymousClass1();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public com.airbnb.lottie.RenderMode G;
    public final java.util.Set<com.airbnb.lottie.LottieOnCompositionLoadedListener> H;
    public int I;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> J;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.LottieComposition K;
    public final com.airbnb.lottie.LottieListener<com.airbnb.lottie.LottieComposition> n;
    public final com.airbnb.lottie.LottieListener<java.lang.Throwable> t;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.LottieListener<java.lang.Throwable> u;

    @androidx.annotation.DrawableRes
    public int v;
    public final com.airbnb.lottie.LottieDrawable w;
    public boolean x;
    public java.lang.String y;

    @androidx.annotation.RawRes
    public int z;

    /* renamed from: com.airbnb.lottie.LottieAnimationView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.airbnb.lottie.LottieListener<java.lang.Throwable> {
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(java.lang.Throwable th) {
            if (!com.airbnb.lottie.utils.Utils.isNetworkException(th)) {
                throw new java.lang.IllegalStateException("Unable to parse composition", th);
            }
            com.airbnb.lottie.utils.Logger.warning("Unable to load composition.", th);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.airbnb.lottie.LottieListener<com.airbnb.lottie.LottieComposition> {
        public AnonymousClass2() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieAnimationView.this.setComposition(lottieComposition);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.airbnb.lottie.LottieListener<java.lang.Throwable> {
        public AnonymousClass3() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(java.lang.Throwable th) {
            if (com.airbnb.lottie.LottieAnimationView.this.v != 0) {
                com.airbnb.lottie.LottieAnimationView lottieAnimationView = com.airbnb.lottie.LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.v);
            }
            (com.airbnb.lottie.LottieAnimationView.this.u == null ? com.airbnb.lottie.LottieAnimationView.L : com.airbnb.lottie.LottieAnimationView.this.u).onResult(th);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ int n;

        public AnonymousClass4(int i) {
            this.n = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieAnimationView.this.F ? com.airbnb.lottie.LottieCompositionFactory.fromRawResSync(com.airbnb.lottie.LottieAnimationView.this.getContext(), this.n) : com.airbnb.lottie.LottieCompositionFactory.fromRawResSync(com.airbnb.lottie.LottieAnimationView.this.getContext(), this.n, null);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> {
        public final /* synthetic */ java.lang.String n;

        public AnonymousClass5(java.lang.String str) {
            this.n = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> call() {
            return com.airbnb.lottie.LottieAnimationView.this.F ? com.airbnb.lottie.LottieCompositionFactory.fromAssetSync(com.airbnb.lottie.LottieAnimationView.this.getContext(), this.n) : com.airbnb.lottie.LottieCompositionFactory.fromAssetSync(com.airbnb.lottie.LottieAnimationView.this.getContext(), this.n, null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.airbnb.lottie.LottieAnimationView$6, reason: invalid class name */
    public class AnonymousClass6<T> extends com.airbnb.lottie.value.LottieValueCallback<T> {
        public final /* synthetic */ com.airbnb.lottie.value.SimpleLottieValueCallback c;

        public AnonymousClass6(com.airbnb.lottie.value.SimpleLottieValueCallback simpleLottieValueCallback) {
            this.c = simpleLottieValueCallback;
        }

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public T getValue(com.airbnb.lottie.value.LottieFrameInfo<T> lottieFrameInfo) {
            return (T) this.c.getValue(lottieFrameInfo);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.RenderMode.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.RenderMode.HARDWARE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.airbnb.lottie.RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.airbnb.lottie.LottieAnimationView.SavedState> CREATOR = new com.airbnb.lottie.LottieAnimationView.SavedState.AnonymousClass1();
        java.lang.String animationName;
        int animationResId;
        java.lang.String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        /* renamed from: com.airbnb.lottie.LottieAnimationView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.airbnb.lottie.LottieAnimationView.SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.LottieAnimationView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.airbnb.lottie.LottieAnimationView.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.LottieAnimationView.SavedState[] newArray(int i) {
                return new com.airbnb.lottie.LottieAnimationView.SavedState[i];
            }
        }

        private SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        public /* synthetic */ SavedState(android.os.Parcel parcel, com.airbnb.lottie.LottieAnimationView.AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }

    public LottieAnimationView(android.content.Context context) {
        super(context);
        this.n = new com.airbnb.lottie.LottieAnimationView.AnonymousClass2();
        this.t = new com.airbnb.lottie.LottieAnimationView.AnonymousClass3();
        this.v = 0;
        this.w = new com.airbnb.lottie.LottieDrawable();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = com.airbnb.lottie.RenderMode.AUTOMATIC;
        this.H = new java.util.HashSet();
        this.I = 0;
        j(null, com.airbnb.lottie.R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new com.airbnb.lottie.LottieAnimationView.AnonymousClass2();
        this.t = new com.airbnb.lottie.LottieAnimationView.AnonymousClass3();
        this.v = 0;
        this.w = new com.airbnb.lottie.LottieDrawable();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = com.airbnb.lottie.RenderMode.AUTOMATIC;
        this.H = new java.util.HashSet();
        this.I = 0;
        j(attributeSet, com.airbnb.lottie.R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new com.airbnb.lottie.LottieAnimationView.AnonymousClass2();
        this.t = new com.airbnb.lottie.LottieAnimationView.AnonymousClass3();
        this.v = 0;
        this.w = new com.airbnb.lottie.LottieDrawable();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = com.airbnb.lottie.RenderMode.AUTOMATIC;
        this.H = new java.util.HashSet();
        this.I = 0;
        j(attributeSet, i);
    }

    private void f() {
        this.K = null;
        this.w.clearComposition();
    }

    private void setCompositionTask(com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> lottieTask) {
        f();
        e();
        this.J = lottieTask.addListener(this.n).addFailureListener(this.t);
    }

    public void addAnimatorListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.w.addAnimatorListener(animatorListener);
    }

    @androidx.annotation.RequiresApi(api = 19)
    public void addAnimatorPauseListener(android.animation.Animator.AnimatorPauseListener animatorPauseListener) {
        this.w.addAnimatorPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.w.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@androidx.annotation.NonNull com.airbnb.lottie.LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.K;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.H.add(lottieOnCompositionLoadedListener);
    }

    public <T> void addValueCallback(com.airbnb.lottie.model.KeyPath keyPath, T t, com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        this.w.addValueCallback(keyPath, (com.airbnb.lottie.model.KeyPath) t, (com.airbnb.lottie.value.LottieValueCallback<com.airbnb.lottie.model.KeyPath>) lottieValueCallback);
    }

    public <T> void addValueCallback(com.airbnb.lottie.model.KeyPath keyPath, T t, com.airbnb.lottie.value.SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.w.addValueCallback(keyPath, (com.airbnb.lottie.model.KeyPath) t, (com.airbnb.lottie.value.LottieValueCallback<com.airbnb.lottie.model.KeyPath>) new com.airbnb.lottie.LottieAnimationView.AnonymousClass6(simpleLottieValueCallback));
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        com.airbnb.lottie.L.beginSection("buildDrawingCache");
        this.I++;
        super.buildDrawingCache(z);
        if (this.I == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(com.airbnb.lottie.RenderMode.HARDWARE);
        }
        this.I--;
        com.airbnb.lottie.L.endSection("buildDrawingCache");
    }

    @androidx.annotation.MainThread
    public void cancelAnimation() {
        this.C = false;
        this.B = false;
        this.A = false;
        this.w.cancelAnimation();
        g();
    }

    public void disableExtraScaleModeInFitXY() {
        this.w.disableExtraScaleModeInFitXY();
    }

    public final void e() {
        com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> lottieTask = this.J;
        if (lottieTask != null) {
            lottieTask.removeListener(this.n);
            this.J.removeFailureListener(this.t);
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.w.enableMergePathsForKitKatAndAbove(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r3 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        com.airbnb.lottie.LottieComposition lottieComposition;
        int i;
        int i2 = com.airbnb.lottie.LottieAnimationView.AnonymousClass7.a[this.G.ordinal()];
        int i3 = 2;
        if (i2 != 1) {
            if (i2 != 2 && i2 == 3) {
                com.airbnb.lottie.LottieComposition lottieComposition2 = this.K;
                boolean z = false;
                if ((lottieComposition2 == null || !lottieComposition2.hasDashPattern() || android.os.Build.VERSION.SDK_INT >= 28) && (((lottieComposition = this.K) == null || lottieComposition.getMaskAndMatteCount() <= 4) && (i = android.os.Build.VERSION.SDK_INT) != 24 && i != 25)) {
                    z = true;
                }
            }
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.LottieComposition getComposition() {
        return this.K;
    }

    public long getDuration() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.K;
        if (lottieComposition != null) {
            return (long) lottieComposition.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return this.w.getFrame();
    }

    @androidx.annotation.Nullable
    public java.lang.String getImageAssetsFolder() {
        return this.w.getImageAssetsFolder();
    }

    public float getMaxFrame() {
        return this.w.getMaxFrame();
    }

    public float getMinFrame() {
        return this.w.getMinFrame();
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.PerformanceTracker getPerformanceTracker() {
        return this.w.getPerformanceTracker();
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.w.getProgress();
    }

    public int getRepeatCount() {
        return this.w.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.w.getRepeatMode();
    }

    public float getScale() {
        return this.w.getScale();
    }

    public float getSpeed() {
        return this.w.getSpeed();
    }

    public final com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> h(java.lang.String str) {
        return isInEditMode() ? new com.airbnb.lottie.LottieTask<>(new com.airbnb.lottie.LottieAnimationView.AnonymousClass5(str), true) : this.F ? com.airbnb.lottie.LottieCompositionFactory.fromAsset(getContext(), str) : com.airbnb.lottie.LottieCompositionFactory.fromAsset(getContext(), str, null);
    }

    public boolean hasMasks() {
        return this.w.hasMasks();
    }

    public boolean hasMatte() {
        return this.w.hasMatte();
    }

    public final com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> i(@androidx.annotation.RawRes int i) {
        return isInEditMode() ? new com.airbnb.lottie.LottieTask<>(new com.airbnb.lottie.LottieAnimationView.AnonymousClass4(i), true) : this.F ? com.airbnb.lottie.LottieCompositionFactory.fromRawRes(getContext(), i) : com.airbnb.lottie.LottieCompositionFactory.fromRawRes(getContext(), i, null);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = getDrawable();
        com.airbnb.lottie.LottieDrawable lottieDrawable = this.w;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.w.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.w.isMergePathsEnabledForKitKatAndAbove();
    }

    public final void j(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i) {
        java.lang.String string;
        android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.airbnb.lottie.R.styleable.LottieAnimationView, i, 0);
        this.F = obtainStyledAttributes.getBoolean(com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        int i3 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
        int i4 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i4);
        if (hasValue && hasValue2) {
            throw new java.lang.IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            java.lang.String string2 = obtainStyledAttributes.getString(i3);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i4)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.C = true;
            this.E = true;
        }
        if (obtainStyledAttributes.getBoolean(com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.w.setRepeatCount(-1);
        }
        int i5 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i8 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i8)) {
            addValueCallback(new com.airbnb.lottie.model.KeyPath(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH), (com.airbnb.lottie.model.KeyPath) com.airbnb.lottie.LottieProperty.COLOR_FILTER, (com.airbnb.lottie.value.LottieValueCallback<com.airbnb.lottie.model.KeyPath>) new com.airbnb.lottie.value.LottieValueCallback(new com.airbnb.lottie.SimpleColorFilter(androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i8, -1)).getDefaultColor())));
        }
        int i9 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_scale;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.w.setScale(obtainStyledAttributes.getFloat(i9, 1.0f));
        }
        int i10 = com.airbnb.lottie.R.styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i10)) {
            com.airbnb.lottie.RenderMode renderMode = com.airbnb.lottie.RenderMode.AUTOMATIC;
            int i11 = obtainStyledAttributes.getInt(i10, renderMode.ordinal());
            if (i11 >= com.airbnb.lottie.RenderMode.values().length) {
                i11 = renderMode.ordinal();
            }
            setRenderMode(com.airbnb.lottie.RenderMode.values()[i11]);
        }
        obtainStyledAttributes.recycle();
        this.w.l(java.lang.Boolean.valueOf(com.airbnb.lottie.utils.Utils.getAnimationScale(getContext()) != 0.0f));
        g();
        this.x = true;
    }

    public final void k() {
        boolean isAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.w);
        if (isAnimating) {
            this.w.resumeAnimation();
        }
    }

    @java.lang.Deprecated
    public void loop(boolean z) {
        this.w.setRepeatCount(z ? -1 : 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.E || this.C)) {
            playAnimation();
            this.E = false;
            this.C = false;
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.C = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.airbnb.lottie.LottieAnimationView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.airbnb.lottie.LottieAnimationView.SavedState savedState = (com.airbnb.lottie.LottieAnimationView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        java.lang.String str = savedState.animationName;
        this.y = str;
        if (!android.text.TextUtils.isEmpty(str)) {
            setAnimation(this.y);
        }
        int i = savedState.animationResId;
        this.z = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.w.setImagesAssetsFolder(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.airbnb.lottie.LottieAnimationView.SavedState savedState = new com.airbnb.lottie.LottieAnimationView.SavedState(super.onSaveInstanceState());
        savedState.animationName = this.y;
        savedState.animationResId = this.z;
        savedState.progress = this.w.getProgress();
        savedState.isAnimating = this.w.isAnimating() || (!androidx.core.view.ViewCompat.isAttachedToWindow(this) && this.C);
        savedState.imageAssetsFolder = this.w.getImageAssetsFolder();
        savedState.repeatMode = this.w.getRepeatMode();
        savedState.repeatCount = this.w.getRepeatCount();
        return savedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        if (this.x) {
            if (!isShown()) {
                if (isAnimating()) {
                    pauseAnimation();
                    this.B = true;
                    return;
                }
                return;
            }
            if (this.B) {
                resumeAnimation();
            } else if (this.A) {
                playAnimation();
            }
            this.B = false;
            this.A = false;
        }
    }

    @androidx.annotation.MainThread
    public void pauseAnimation() {
        this.E = false;
        this.C = false;
        this.B = false;
        this.A = false;
        this.w.pauseAnimation();
        g();
    }

    @androidx.annotation.MainThread
    public void playAnimation() {
        if (!isShown()) {
            this.A = true;
        } else {
            this.w.playAnimation();
            g();
        }
    }

    public void removeAllAnimatorListeners() {
        this.w.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.H.clear();
    }

    public void removeAllUpdateListeners() {
        this.w.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.w.removeAnimatorListener(animatorListener);
    }

    @androidx.annotation.RequiresApi(api = 19)
    public void removeAnimatorPauseListener(android.animation.Animator.AnimatorPauseListener animatorPauseListener) {
        this.w.removeAnimatorPauseListener(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@androidx.annotation.NonNull com.airbnb.lottie.LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.H.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.w.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public java.util.List<com.airbnb.lottie.model.KeyPath> resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath) {
        return this.w.resolveKeyPath(keyPath);
    }

    @androidx.annotation.MainThread
    public void resumeAnimation() {
        if (isShown()) {
            this.w.resumeAnimation();
            g();
        } else {
            this.A = false;
            this.B = true;
        }
    }

    public void reverseAnimationSpeed() {
        this.w.reverseAnimationSpeed();
    }

    public void setAnimation(@androidx.annotation.RawRes int i) {
        this.z = i;
        this.y = null;
        setCompositionTask(i(i));
    }

    public void setAnimation(java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str) {
        setCompositionTask(com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStream(inputStream, str));
    }

    public void setAnimation(java.lang.String str) {
        this.y = str;
        this.z = 0;
        setCompositionTask(h(str));
    }

    @java.lang.Deprecated
    public void setAnimationFromJson(java.lang.String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        setAnimation(new java.io.ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimationFromUrl(java.lang.String str) {
        setCompositionTask(this.F ? com.airbnb.lottie.LottieCompositionFactory.fromUrl(getContext(), str) : com.airbnb.lottie.LottieCompositionFactory.fromUrl(getContext(), str, null));
    }

    public void setAnimationFromUrl(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        setCompositionTask(com.airbnb.lottie.LottieCompositionFactory.fromUrl(getContext(), str, str2));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.w.setApplyingOpacityToLayersEnabled(z);
    }

    public void setCacheComposition(boolean z) {
        this.F = z;
    }

    public void setComposition(@androidx.annotation.NonNull com.airbnb.lottie.LottieComposition lottieComposition) {
        if (com.airbnb.lottie.L.DBG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Set Composition \n");
            sb.append(lottieComposition);
        }
        this.w.setCallback(this);
        this.K = lottieComposition;
        this.D = true;
        boolean composition = this.w.setComposition(lottieComposition);
        this.D = false;
        g();
        if (getDrawable() != this.w || composition) {
            if (!composition) {
                k();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            java.util.Iterator<com.airbnb.lottie.LottieOnCompositionLoadedListener> it = this.H.iterator();
            while (it.hasNext()) {
                it.next().onCompositionLoaded(lottieComposition);
            }
        }
    }

    public void setFailureListener(@androidx.annotation.Nullable com.airbnb.lottie.LottieListener<java.lang.Throwable> lottieListener) {
        this.u = lottieListener;
    }

    public void setFallbackResource(@androidx.annotation.DrawableRes int i) {
        this.v = i;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.FontAssetDelegate fontAssetDelegate) {
        this.w.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setFrame(int i) {
        this.w.setFrame(i);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.ImageAssetDelegate imageAssetDelegate) {
        this.w.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(java.lang.String str) {
        this.w.setImagesAssetsFolder(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        e();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        e();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        e();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.w.setMaxFrame(i);
    }

    public void setMaxFrame(java.lang.String str) {
        this.w.setMaxFrame(str);
    }

    public void setMaxProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.w.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.w.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxFrame(java.lang.String str) {
        this.w.setMinAndMaxFrame(str);
    }

    public void setMinAndMaxFrame(java.lang.String str, java.lang.String str2, boolean z) {
        this.w.setMinAndMaxFrame(str, str2, z);
    }

    public void setMinAndMaxProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.w.setMinAndMaxProgress(f, f2);
    }

    public void setMinFrame(int i) {
        this.w.setMinFrame(i);
    }

    public void setMinFrame(java.lang.String str) {
        this.w.setMinFrame(str);
    }

    public void setMinProgress(float f) {
        this.w.setMinProgress(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.w.setOutlineMasksAndMattes(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.w.setPerformanceTrackingEnabled(z);
    }

    public void setProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.w.setProgress(f);
    }

    public void setRenderMode(com.airbnb.lottie.RenderMode renderMode) {
        this.G = renderMode;
        g();
    }

    public void setRepeatCount(int i) {
        this.w.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.w.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.w.setSafeMode(z);
    }

    public void setScale(float f) {
        this.w.setScale(f);
        if (getDrawable() == this.w) {
            k();
        }
    }

    public void setSpeed(float f) {
        this.w.setSpeed(f);
    }

    public void setTextDelegate(com.airbnb.lottie.TextDelegate textDelegate) {
        this.w.setTextDelegate(textDelegate);
    }

    @Override // android.view.View
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable) {
        com.airbnb.lottie.LottieDrawable lottieDrawable;
        if (!this.D && drawable == (lottieDrawable = this.w) && lottieDrawable.isAnimating()) {
            pauseAnimation();
        } else if (!this.D && (drawable instanceof com.airbnb.lottie.LottieDrawable)) {
            com.airbnb.lottie.LottieDrawable lottieDrawable2 = (com.airbnb.lottie.LottieDrawable) drawable;
            if (lottieDrawable2.isAnimating()) {
                lottieDrawable2.pauseAnimation();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @androidx.annotation.Nullable
    public android.graphics.Bitmap updateBitmap(java.lang.String str, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        return this.w.updateBitmap(str, bitmap);
    }
}
