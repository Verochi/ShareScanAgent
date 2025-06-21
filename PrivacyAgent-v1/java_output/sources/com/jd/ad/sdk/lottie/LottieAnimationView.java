package com.jd.ad.sdk.lottie;

/* loaded from: classes23.dex */
public class LottieAnimationView extends androidx.appcompat.widget.AppCompatImageView {
    public static final com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> jad_tg = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_an();
    public final com.jd.ad.sdk.jad_lu.jad_ob<com.jd.ad.sdk.jad_lu.jad_jt> jad_an;
    public final com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> jad_bo;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> jad_cp;

    @androidx.annotation.DrawableRes
    public int jad_dq;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_er;
    public boolean jad_fs;

    @androidx.annotation.RawRes
    public int jad_hu;
    public boolean jad_iv;
    public java.lang.String jad_jt;
    public boolean jad_jw;
    public boolean jad_kx;
    public boolean jad_ly;
    public boolean jad_mz;
    public boolean jad_na;
    public com.jd.ad.sdk.jad_lu.jad_wj jad_ob;
    public final java.util.Set<com.jd.ad.sdk.jad_lu.jad_qd> jad_pc;
    public int jad_qd;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_re;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_jt jad_sf;

    public class jad_an implements com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> {
        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(java.lang.Throwable th) {
            java.lang.Throwable th2 = th;
            java.lang.ThreadLocal<android.graphics.PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
            if (!((th2 instanceof java.net.SocketException) || (th2 instanceof java.nio.channels.ClosedChannelException) || (th2 instanceof java.io.InterruptedIOException) || (th2 instanceof java.net.ProtocolException) || (th2 instanceof javax.net.ssl.SSLException) || (th2 instanceof java.net.UnknownHostException) || (th2 instanceof java.net.UnknownServiceException))) {
                throw new java.lang.IllegalStateException("Unable to parse composition", th2);
            }
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Unable to load composition.", th2);
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_lu.jad_ob<com.jd.ad.sdk.jad_lu.jad_jt> {
        public jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            com.jd.ad.sdk.lottie.LottieAnimationView.this.setComposition(jad_jtVar);
        }
    }

    public class jad_cp implements com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> {
        public jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(java.lang.Throwable th) {
            java.lang.Throwable th2 = th;
            com.jd.ad.sdk.lottie.LottieAnimationView lottieAnimationView = com.jd.ad.sdk.lottie.LottieAnimationView.this;
            int i = lottieAnimationView.jad_dq;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> jad_obVar = com.jd.ad.sdk.lottie.LottieAnimationView.this.jad_cp;
            if (jad_obVar == null) {
                jad_obVar = com.jd.ad.sdk.lottie.LottieAnimationView.jad_tg;
            }
            jad_obVar.jad_an(th2);
        }
    }

    public static /* synthetic */ class jad_dq {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_lu.jad_wj.values().length];
            jad_an = iArr;
            try {
                iArr[1] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_an[2] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                jad_an[0] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static class jad_er extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.jd.ad.sdk.lottie.LottieAnimationView.jad_er> CREATOR = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_er.jad_an();
        public java.lang.String jad_an;
        public int jad_bo;
        public float jad_cp;
        public boolean jad_dq;
        public java.lang.String jad_er;
        public int jad_fs;
        public int jad_jt;

        public class jad_an implements android.os.Parcelable.Creator<com.jd.ad.sdk.lottie.LottieAnimationView.jad_er> {
            @Override // android.os.Parcelable.Creator
            public com.jd.ad.sdk.lottie.LottieAnimationView.jad_er createFromParcel(android.os.Parcel parcel) {
                return new com.jd.ad.sdk.lottie.LottieAnimationView.jad_er(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public com.jd.ad.sdk.lottie.LottieAnimationView.jad_er[] newArray(int i) {
                return new com.jd.ad.sdk.lottie.LottieAnimationView.jad_er[i];
            }
        }

        public jad_er(android.os.Parcel parcel) {
            super(parcel);
            this.jad_an = parcel.readString();
            this.jad_cp = parcel.readFloat();
            this.jad_dq = parcel.readInt() == 1;
            this.jad_er = parcel.readString();
            this.jad_fs = parcel.readInt();
            this.jad_jt = parcel.readInt();
        }

        public jad_er(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.jad_an);
            parcel.writeFloat(this.jad_cp);
            parcel.writeInt(this.jad_dq ? 1 : 0);
            parcel.writeString(this.jad_er);
            parcel.writeInt(this.jad_fs);
            parcel.writeInt(this.jad_jt);
        }
    }

    public LottieAnimationView(android.content.Context context) {
        super(context);
        this.jad_an = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_bo();
        this.jad_bo = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_cp();
        this.jad_dq = 0;
        this.jad_er = new com.jd.ad.sdk.jad_lu.jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = com.jd.ad.sdk.jad_lu.jad_wj.AUTOMATIC;
        this.jad_pc = new java.util.HashSet();
        this.jad_qd = 0;
        jad_an(null, com.jd.ad.sdk.R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_an = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_bo();
        this.jad_bo = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_cp();
        this.jad_dq = 0;
        this.jad_er = new com.jd.ad.sdk.jad_lu.jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = com.jd.ad.sdk.jad_lu.jad_wj.AUTOMATIC;
        this.jad_pc = new java.util.HashSet();
        this.jad_qd = 0;
        jad_an(attributeSet, com.jd.ad.sdk.R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jad_an = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_bo();
        this.jad_bo = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_cp();
        this.jad_dq = 0;
        this.jad_er = new com.jd.ad.sdk.jad_lu.jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = com.jd.ad.sdk.jad_lu.jad_wj.AUTOMATIC;
        this.jad_pc = new java.util.HashSet();
        this.jad_qd = 0;
        jad_an(attributeSet, i);
    }

    private void setCompositionTask(com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_uhVar) {
        this.jad_sf = null;
        this.jad_er.jad_cp();
        jad_an();
        this.jad_re = jad_uhVar.jad_bo(this.jad_an).jad_an(this.jad_bo);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        this.jad_qd++;
        super.buildDrawingCache(z);
        if (this.jad_qd == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(com.jd.ad.sdk.jad_lu.jad_wj.HARDWARE);
        }
        this.jad_qd--;
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("buildDrawingCache");
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_jt getComposition() {
        return this.jad_sf;
    }

    public long getDuration() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_sf;
        if (jad_jtVar != null) {
            return (long) jad_jtVar.jad_an();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.jad_er.jad_cp.jad_fs;
    }

    @androidx.annotation.Nullable
    public java.lang.String getImageAssetsFolder() {
        return this.jad_er.jad_jw;
    }

    public float getMaxFrame() {
        return this.jad_er.jad_cp.jad_dq();
    }

    public float getMinFrame() {
        return this.jad_er.jad_cp.jad_er();
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_vi getPerformanceTracker() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_er.jad_bo;
        if (jad_jtVar != null) {
            return jad_jtVar.jad_an;
        }
        return null;
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.jad_er.jad_cp.jad_cp();
    }

    public int getRepeatCount() {
        return this.jad_er.jad_cp.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.jad_er.jad_cp.getRepeatMode();
    }

    public float getScale() {
        return this.jad_er.jad_dq;
    }

    public float getSpeed() {
        return this.jad_er.jad_cp.jad_cp;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = getDrawable();
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        if (drawable2 == jad_mzVar) {
            super.invalidateDrawable(jad_mzVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public final void jad_an() {
        com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_uhVar = this.jad_re;
        if (jad_uhVar != null) {
            com.jd.ad.sdk.jad_lu.jad_ob<com.jd.ad.sdk.jad_lu.jad_jt> jad_obVar = this.jad_an;
            synchronized (jad_uhVar) {
                jad_uhVar.jad_an.remove(jad_obVar);
            }
            com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_uhVar2 = this.jad_re;
            com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> jad_obVar2 = this.jad_bo;
            synchronized (jad_uhVar2) {
                jad_uhVar2.jad_bo.remove(jad_obVar2);
            }
        }
    }

    public final void jad_an(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i) {
        java.lang.String string;
        android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.jd.ad.sdk.R.styleable.LottieAnimationView, i, 0);
        this.jad_na = obtainStyledAttributes.getBoolean(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        int i3 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
        int i4 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_url;
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
        setFallbackResource(obtainStyledAttributes.getResourceId(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.jad_kx = true;
            this.jad_mz = true;
        }
        if (obtainStyledAttributes.getBoolean(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.jad_er.jad_cp.setRepeatCount(-1);
        }
        int i5 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        boolean z = obtainStyledAttributes.getBoolean(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_na != z) {
            jad_mzVar.jad_na = z;
            if (jad_mzVar.jad_bo != null) {
                jad_mzVar.jad_bo();
            }
        }
        int i8 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i8)) {
            com.jd.ad.sdk.jad_lu.jad_xk jad_xkVar = new com.jd.ad.sdk.jad_lu.jad_xk(androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i8, -1)).getDefaultColor());
            this.jad_er.jad_an(new com.jd.ad.sdk.jad_qz.jad_er(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH), com.jd.ad.sdk.jad_lu.jad_re.jad_mx, new com.jd.ad.sdk.jad_yh.jad_cp(jad_xkVar));
        }
        int i9 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_scale;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.jad_er.jad_dq = obtainStyledAttributes.getFloat(i9, 1.0f);
        }
        int i10 = com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i10)) {
            int i11 = obtainStyledAttributes.getInt(i10, 0);
            if (i11 >= com.jd.ad.sdk.jad_lu.jad_wj.values().length) {
                i11 = 0;
            }
            setRenderMode(com.jd.ad.sdk.jad_lu.jad_wj.values()[i11]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(com.jd.ad.sdk.R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        obtainStyledAttributes.recycle();
        jad_bo();
        this.jad_fs = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (((r0 == null || !r0.jad_na || android.os.Build.VERSION.SDK_INT >= 28) && !((r0 != null && r0.jad_ob > 4) || (r0 = android.os.Build.VERSION.SDK_INT) == 24 || r0 == 25)) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_bo() {
        int i = com.jd.ad.sdk.lottie.LottieAnimationView.jad_dq.jad_an[this.jad_ob.ordinal()];
        int i2 = 2;
        if (i != 1) {
            if (i != 2 && i == 3) {
                com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_sf;
            }
            i2 = 1;
        }
        if (i2 != getLayerType()) {
            setLayerType(i2, null);
        }
    }

    @androidx.annotation.MainThread
    public void jad_cp() {
        this.jad_mz = false;
        this.jad_kx = false;
        this.jad_jw = false;
        this.jad_iv = false;
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_hu.clear();
        jad_mzVar.jad_cp.jad_hu();
        jad_bo();
    }

    @androidx.annotation.MainThread
    public void jad_dq() {
        if (!isShown()) {
            this.jad_iv = true;
        } else {
            this.jad_er.jad_fs();
            jad_bo();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.jad_mz || this.jad_kx)) {
            jad_dq();
            this.jad_mz = false;
            this.jad_kx = false;
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.jad_er.jad_er()) {
            this.jad_kx = false;
            this.jad_jw = false;
            this.jad_iv = false;
            com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
            jad_mzVar.jad_hu.clear();
            jad_mzVar.jad_cp.cancel();
            jad_bo();
            this.jad_kx = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.jd.ad.sdk.lottie.LottieAnimationView.jad_er)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.jd.ad.sdk.lottie.LottieAnimationView.jad_er jad_erVar = (com.jd.ad.sdk.lottie.LottieAnimationView.jad_er) parcelable;
        super.onRestoreInstanceState(jad_erVar.getSuperState());
        java.lang.String str = jad_erVar.jad_an;
        this.jad_jt = str;
        if (!android.text.TextUtils.isEmpty(str)) {
            setAnimation(this.jad_jt);
        }
        int i = jad_erVar.jad_bo;
        this.jad_hu = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(jad_erVar.jad_cp);
        if (jad_erVar.jad_dq) {
            jad_dq();
        }
        this.jad_er.jad_jw = jad_erVar.jad_er;
        setRepeatMode(jad_erVar.jad_fs);
        setRepeatCount(jad_erVar.jad_jt);
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.jd.ad.sdk.lottie.LottieAnimationView.jad_er jad_erVar = new com.jd.ad.sdk.lottie.LottieAnimationView.jad_er(super.onSaveInstanceState());
        jad_erVar.jad_an = this.jad_jt;
        jad_erVar.jad_bo = this.jad_hu;
        jad_erVar.jad_cp = this.jad_er.jad_cp.jad_cp();
        jad_erVar.jad_dq = this.jad_er.jad_er() || (!androidx.core.view.ViewCompat.isAttachedToWindow(this) && this.jad_kx);
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        jad_erVar.jad_er = jad_mzVar.jad_jw;
        jad_erVar.jad_fs = jad_mzVar.jad_cp.getRepeatMode();
        jad_erVar.jad_jt = this.jad_er.jad_cp.getRepeatCount();
        return jad_erVar;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        if (this.jad_fs) {
            if (!isShown()) {
                if (this.jad_er.jad_er()) {
                    jad_cp();
                    this.jad_jw = true;
                    return;
                }
                return;
            }
            if (this.jad_jw) {
                if (isShown()) {
                    this.jad_er.jad_jt();
                    jad_bo();
                } else {
                    this.jad_iv = false;
                    this.jad_jw = true;
                }
            } else if (this.jad_iv) {
                jad_dq();
            }
            this.jad_jw = false;
            this.jad_iv = false;
        }
    }

    public void setAnimation(@androidx.annotation.RawRes int i) {
        com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_an2;
        this.jad_hu = i;
        this.jad_jt = null;
        if (isInEditMode()) {
            jad_an2 = new com.jd.ad.sdk.jad_lu.jad_uh<>(new com.jd.ad.sdk.jad_lu.jad_er(this, i), true);
        } else if (this.jad_na) {
            android.content.Context context = getContext();
            java.lang.String jad_an3 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(context, i);
            jad_an2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(jad_an3, new com.jd.ad.sdk.jad_lu.jad_kx(new java.lang.ref.WeakReference(context), context.getApplicationContext(), i, jad_an3));
        } else {
            android.content.Context context2 = getContext();
            java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            jad_an2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an((java.lang.String) null, new com.jd.ad.sdk.jad_lu.jad_kx(new java.lang.ref.WeakReference(context2), context2.getApplicationContext(), i, null));
        }
        setCompositionTask(jad_an2);
    }

    public void setAnimation(java.lang.String str) {
        com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_an2;
        this.jad_jt = str;
        this.jad_hu = 0;
        if (isInEditMode()) {
            jad_an2 = new com.jd.ad.sdk.jad_lu.jad_uh<>(new com.jd.ad.sdk.jad_lu.jad_fs(this, str), true);
        } else if (this.jad_na) {
            android.content.Context context = getContext();
            java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            java.lang.String str2 = "asset_" + str;
            jad_an2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(str2, new com.jd.ad.sdk.jad_lu.jad_jw(context.getApplicationContext(), str, str2));
        } else {
            android.content.Context context2 = getContext();
            java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> map2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            jad_an2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an((java.lang.String) null, new com.jd.ad.sdk.jad_lu.jad_jw(context2.getApplicationContext(), str, null));
        }
        setCompositionTask(jad_an2);
    }

    @java.lang.Deprecated
    public void setAnimationFromJson(java.lang.String str) {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(str.getBytes());
        java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
        setCompositionTask(com.jd.ad.sdk.jad_lu.jad_hu.jad_an((java.lang.String) null, new com.jd.ad.sdk.jad_lu.jad_ly(byteArrayInputStream, null)));
    }

    public void setAnimationFromUrl(java.lang.String str) {
        com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_an2;
        if (this.jad_na) {
            android.content.Context context = getContext();
            java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            java.lang.String str2 = "url_" + str;
            jad_an2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(str2, new com.jd.ad.sdk.jad_lu.jad_iv(context, str, str2));
        } else {
            android.content.Context context2 = getContext();
            java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> map2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            jad_an2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an((java.lang.String) null, new com.jd.ad.sdk.jad_lu.jad_iv(context2, str, null));
        }
        setCompositionTask(jad_an2);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.jad_er.jad_sf = z;
    }

    public void setCacheComposition(boolean z) {
        this.jad_na = z;
    }

    public void setComposition(@androidx.annotation.NonNull com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        this.jad_er.setCallback(this);
        this.jad_sf = jad_jtVar;
        boolean z = true;
        this.jad_ly = true;
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_bo == jad_jtVar) {
            z = false;
        } else {
            jad_mzVar.jad_uh = false;
            jad_mzVar.jad_cp();
            jad_mzVar.jad_bo = jad_jtVar;
            jad_mzVar.jad_bo();
            com.jd.ad.sdk.jad_xg.jad_er jad_erVar = jad_mzVar.jad_cp;
            boolean z2 = jad_erVar.jad_jw == null;
            jad_erVar.jad_jw = jad_jtVar;
            if (z2) {
                jad_erVar.jad_an((int) java.lang.Math.max(jad_erVar.jad_hu, jad_jtVar.jad_kx), (int) java.lang.Math.min(jad_erVar.jad_iv, jad_jtVar.jad_ly));
            } else {
                jad_erVar.jad_an((int) jad_jtVar.jad_kx, (int) jad_jtVar.jad_ly);
            }
            float f = jad_erVar.jad_fs;
            jad_erVar.jad_fs = 0.0f;
            jad_erVar.jad_an((int) f);
            jad_erVar.jad_an();
            jad_mzVar.jad_cp(jad_mzVar.jad_cp.getAnimatedFraction());
            jad_mzVar.jad_dq = jad_mzVar.jad_dq;
            java.util.Iterator it = new java.util.ArrayList(jad_mzVar.jad_hu).iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.jad_lu.jad_mz.jad_ob jad_obVar = (com.jd.ad.sdk.jad_lu.jad_mz.jad_ob) it.next();
                if (jad_obVar != null) {
                    jad_obVar.jad_an(jad_jtVar);
                }
                it.remove();
            }
            jad_mzVar.jad_hu.clear();
            jad_jtVar.jad_an.jad_an = jad_mzVar.jad_qd;
            android.graphics.drawable.Drawable.Callback callback = jad_mzVar.getCallback();
            if (callback instanceof android.widget.ImageView) {
                android.widget.ImageView imageView = (android.widget.ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(jad_mzVar);
            }
        }
        this.jad_ly = false;
        jad_bo();
        android.graphics.drawable.Drawable drawable = getDrawable();
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar2 = this.jad_er;
        if (drawable != jad_mzVar2 || z) {
            if (!z) {
                boolean jad_er2 = jad_mzVar2.jad_er();
                setImageDrawable(null);
                setImageDrawable(this.jad_er);
                if (jad_er2) {
                    this.jad_er.jad_jt();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            java.util.Iterator<com.jd.ad.sdk.jad_lu.jad_qd> it2 = this.jad_pc.iterator();
            while (it2.hasNext()) {
                it2.next().jad_an(jad_jtVar);
            }
        }
    }

    public void setFailureListener(@androidx.annotation.Nullable com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> jad_obVar) {
        this.jad_cp = jad_obVar;
    }

    public void setFallbackResource(@androidx.annotation.DrawableRes int i) {
        this.jad_dq = i;
    }

    public void setFontAssetDelegate(com.jd.ad.sdk.jad_lu.jad_an jad_anVar) {
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_mz = jad_anVar;
        com.jd.ad.sdk.jad_py.jad_an jad_anVar2 = jad_mzVar.jad_ly;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_er = jad_anVar;
        }
    }

    public void setFrame(int i) {
        this.jad_er.jad_an(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.jad_er.jad_fs = z;
    }

    public void setImageAssetDelegate(com.jd.ad.sdk.jad_lu.jad_bo jad_boVar) {
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_kx = jad_boVar;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar2 = jad_mzVar.jad_iv;
        if (jad_boVar2 != null) {
            jad_boVar2.jad_cp = jad_boVar;
        }
    }

    public void setImageAssetsFolder(java.lang.String str) {
        this.jad_er.jad_jw = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        jad_an();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        jad_an();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        jad_an();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.jad_er.jad_bo(i);
    }

    public void setMaxFrame(java.lang.String str) {
        this.jad_er.jad_an(str);
    }

    public void setMaxProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jad_er.jad_an(f);
    }

    public void setMinAndMaxFrame(java.lang.String str) {
        this.jad_er.jad_bo(str);
    }

    public void setMinFrame(int i) {
        this.jad_er.jad_cp(i);
    }

    public void setMinFrame(java.lang.String str) {
        this.jad_er.jad_cp(str);
    }

    public void setMinProgress(float f) {
        this.jad_er.jad_bo(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_re == z) {
            return;
        }
        jad_mzVar.jad_re = z;
        com.jd.ad.sdk.jad_tc.jad_bo jad_boVar = jad_mzVar.jad_ob;
        if (jad_boVar != null) {
            jad_boVar.jad_an(z);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_qd = z;
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = jad_mzVar.jad_bo;
        if (jad_jtVar != null) {
            jad_jtVar.jad_an.jad_an = z;
        }
    }

    public void setProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jad_er.jad_cp(f);
    }

    public void setRenderMode(com.jd.ad.sdk.jad_lu.jad_wj jad_wjVar) {
        this.jad_ob = jad_wjVar;
        jad_bo();
    }

    public void setRepeatCount(int i) {
        this.jad_er.jad_cp.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.jad_er.jad_cp.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.jad_er.jad_jt = z;
    }

    public void setScale(float f) {
        this.jad_er.jad_dq = f;
        android.graphics.drawable.Drawable drawable = getDrawable();
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_er;
        if (drawable == jad_mzVar) {
            boolean jad_er2 = jad_mzVar.jad_er();
            setImageDrawable(null);
            setImageDrawable(this.jad_er);
            if (jad_er2) {
                this.jad_er.jad_jt();
            }
        }
    }

    public void setSpeed(float f) {
        this.jad_er.jad_cp.jad_cp = f;
    }

    public void setTextDelegate(com.jd.ad.sdk.jad_lu.jad_yl jad_ylVar) {
        this.jad_er.getClass();
    }

    @Override // android.view.View
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable) {
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar;
        if (!this.jad_ly && drawable == (jad_mzVar = this.jad_er) && jad_mzVar.jad_er()) {
            jad_cp();
        } else if (!this.jad_ly && (drawable instanceof com.jd.ad.sdk.jad_lu.jad_mz)) {
            com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar2 = (com.jd.ad.sdk.jad_lu.jad_mz) drawable;
            if (jad_mzVar2.jad_er()) {
                jad_mzVar2.jad_hu.clear();
                jad_mzVar2.jad_cp.jad_hu();
            }
        }
        super.unscheduleDrawable(drawable);
    }
}
