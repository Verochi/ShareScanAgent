package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback, android.graphics.drawable.Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.manager.ImageAssetManager A;

    @androidx.annotation.Nullable
    public java.lang.String B;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.ImageAssetDelegate C;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.manager.FontAssetManager D;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.FontAssetDelegate E;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.TextDelegate F;
    public boolean G;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.layer.CompositionLayer H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public final android.graphics.Matrix n = new android.graphics.Matrix();
    public com.airbnb.lottie.LottieComposition t;
    public final com.airbnb.lottie.utils.LottieValueAnimator u;
    public float v;
    public boolean w;
    public boolean x;
    public final java.util.ArrayList<com.airbnb.lottie.LottieDrawable.LazyCompositionTask> y;
    public final android.animation.ValueAnimator.AnimatorUpdateListener z;

    /* renamed from: com.airbnb.lottie.LottieDrawable$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            if (com.airbnb.lottie.LottieDrawable.this.H != null) {
                com.airbnb.lottie.LottieDrawable.this.H.setProgress(com.airbnb.lottie.LottieDrawable.this.u.getAnimatedValueAbsolute());
            }
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$10, reason: invalid class name */
    public class AnonymousClass10 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass10(java.lang.String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMinAndMaxFrame(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$11, reason: invalid class name */
    public class AnonymousClass11 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ java.lang.String b;
        public final /* synthetic */ boolean c;

        public AnonymousClass11(java.lang.String str, java.lang.String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMinAndMaxFrame(this.a, this.b, this.c);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$12, reason: invalid class name */
    public class AnonymousClass12 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public AnonymousClass12(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMinAndMaxFrame(this.a, this.b);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$13, reason: invalid class name */
    public class AnonymousClass13 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;

        public AnonymousClass13(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMinAndMaxProgress(this.a, this.b);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$14, reason: invalid class name */
    public class AnonymousClass14 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ int a;

        public AnonymousClass14(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setFrame(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$15, reason: invalid class name */
    public class AnonymousClass15 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ float a;

        public AnonymousClass15(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setProgress(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$16, reason: invalid class name */
    public class AnonymousClass16 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ com.airbnb.lottie.model.KeyPath a;
        public final /* synthetic */ java.lang.Object b;
        public final /* synthetic */ com.airbnb.lottie.value.LottieValueCallback c;

        public AnonymousClass16(com.airbnb.lottie.model.KeyPath keyPath, java.lang.Object obj, com.airbnb.lottie.value.LottieValueCallback lottieValueCallback) {
            this.a = keyPath;
            this.b = obj;
            this.c = lottieValueCallback;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.addValueCallback(this.a, (com.airbnb.lottie.model.KeyPath) this.b, (com.airbnb.lottie.value.LottieValueCallback<com.airbnb.lottie.model.KeyPath>) this.c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.airbnb.lottie.LottieDrawable$17, reason: invalid class name */
    public class AnonymousClass17<T> extends com.airbnb.lottie.value.LottieValueCallback<T> {
        public final /* synthetic */ com.airbnb.lottie.value.SimpleLottieValueCallback c;

        public AnonymousClass17(com.airbnb.lottie.value.SimpleLottieValueCallback simpleLottieValueCallback) {
            this.c = simpleLottieValueCallback;
        }

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public T getValue(com.airbnb.lottie.value.LottieFrameInfo<T> lottieFrameInfo) {
            return (T) this.c.getValue(lottieFrameInfo);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$2, reason: invalid class name */
    public class AnonymousClass2 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public AnonymousClass2() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.playAnimation();
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$3, reason: invalid class name */
    public class AnonymousClass3 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public AnonymousClass3() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.resumeAnimation();
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$4, reason: invalid class name */
    public class AnonymousClass4 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ int a;

        public AnonymousClass4(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMinFrame(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$5, reason: invalid class name */
    public class AnonymousClass5 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ float a;

        public AnonymousClass5(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMinProgress(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$6, reason: invalid class name */
    public class AnonymousClass6 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ int a;

        public AnonymousClass6(int i) {
            this.a = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMaxFrame(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$7, reason: invalid class name */
    public class AnonymousClass7 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ float a;

        public AnonymousClass7(float f) {
            this.a = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMaxProgress(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$8, reason: invalid class name */
    public class AnonymousClass8 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass8(java.lang.String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMinFrame(this.a);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$9, reason: invalid class name */
    public class AnonymousClass9 implements com.airbnb.lottie.LottieDrawable.LazyCompositionTask {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass9(java.lang.String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void a(com.airbnb.lottie.LottieComposition lottieComposition) {
            com.airbnb.lottie.LottieDrawable.this.setMaxFrame(this.a);
        }
    }

    public interface LazyCompositionTask {
        void a(com.airbnb.lottie.LottieComposition lottieComposition);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public LottieDrawable() {
        com.airbnb.lottie.utils.LottieValueAnimator lottieValueAnimator = new com.airbnb.lottie.utils.LottieValueAnimator();
        this.u = lottieValueAnimator;
        this.v = 1.0f;
        this.w = true;
        this.x = false;
        this.y = new java.util.ArrayList<>();
        com.airbnb.lottie.LottieDrawable.AnonymousClass1 anonymousClass1 = new com.airbnb.lottie.LottieDrawable.AnonymousClass1();
        this.z = anonymousClass1;
        this.I = 255;
        this.M = true;
        this.N = false;
        lottieValueAnimator.addUpdateListener(anonymousClass1);
    }

    @androidx.annotation.Nullable
    private android.content.Context getContext() {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof android.view.View)) {
            return ((android.view.View) callback).getContext();
        }
        return null;
    }

    public void addAnimatorListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.u.addListener(animatorListener);
    }

    @androidx.annotation.RequiresApi(api = 19)
    public void addAnimatorPauseListener(android.animation.Animator.AnimatorPauseListener animatorPauseListener) {
        this.u.addPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.u.addUpdateListener(animatorUpdateListener);
    }

    public <T> void addValueCallback(com.airbnb.lottie.model.KeyPath keyPath, T t, com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        com.airbnb.lottie.model.layer.CompositionLayer compositionLayer = this.H;
        if (compositionLayer == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass16(keyPath, t, lottieValueCallback));
            return;
        }
        boolean z = true;
        if (keyPath == com.airbnb.lottie.model.KeyPath.COMPOSITION) {
            compositionLayer.addValueCallback(t, lottieValueCallback);
        } else if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t, lottieValueCallback);
        } else {
            java.util.List<com.airbnb.lottie.model.KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).getResolvedElement().addValueCallback(t, lottieValueCallback);
            }
            z = true ^ resolveKeyPath.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == com.airbnb.lottie.LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public <T> void addValueCallback(com.airbnb.lottie.model.KeyPath keyPath, T t, com.airbnb.lottie.value.SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(keyPath, (com.airbnb.lottie.model.KeyPath) t, (com.airbnb.lottie.value.LottieValueCallback<com.airbnb.lottie.model.KeyPath>) new com.airbnb.lottie.LottieDrawable.AnonymousClass17(simpleLottieValueCallback));
    }

    public final float c(android.graphics.Rect rect) {
        return rect.width() / rect.height();
    }

    public void cancelAnimation() {
        this.y.clear();
        this.u.cancel();
    }

    public void clearComposition() {
        if (this.u.isRunning()) {
            this.u.cancel();
        }
        this.t = null;
        this.H = null;
        this.A = null;
        this.u.clearComposition();
        invalidateSelf();
    }

    public final boolean d() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        return lottieComposition == null || getBounds().isEmpty() || c(getBounds()) == c(lottieComposition.getBounds());
    }

    public void disableExtraScaleModeInFitXY() {
        this.M = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        this.N = false;
        com.airbnb.lottie.L.beginSection("Drawable#draw");
        if (this.x) {
            try {
                f(canvas);
            } catch (java.lang.Throwable th) {
                com.airbnb.lottie.utils.Logger.error("Lottie crashed in draw!", th);
            }
        } else {
            f(canvas);
        }
        com.airbnb.lottie.L.endSection("Drawable#draw");
    }

    public final void e() {
        com.airbnb.lottie.model.layer.CompositionLayer compositionLayer = new com.airbnb.lottie.model.layer.CompositionLayer(this, com.airbnb.lottie.parser.LayerParser.parse(this.t), this.t.getLayers(), this.t);
        this.H = compositionLayer;
        if (this.K) {
            compositionLayer.setOutlineMasksAndMattes(true);
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.G == z) {
            return;
        }
        this.G = z;
        if (this.t != null) {
            e();
        }
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.G;
    }

    @androidx.annotation.MainThread
    public void endAnimation() {
        this.y.clear();
        this.u.endAnimation();
    }

    public final void f(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (d()) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    public final void g(android.graphics.Canvas canvas) {
        float f;
        if (this.H == null) {
            return;
        }
        android.graphics.Rect bounds = getBounds();
        float width = bounds.width() / this.t.getBounds().width();
        float height = bounds.height() / this.t.getBounds().height();
        int i = -1;
        if (this.M) {
            float min = java.lang.Math.min(width, height);
            if (min < 1.0f) {
                f = 1.0f / min;
                width /= f;
                height /= f;
            } else {
                f = 1.0f;
            }
            if (f > 1.0f) {
                i = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f2 = width2 * min;
                float f3 = min * height2;
                canvas.translate(width2 - f2, height2 - f3);
                canvas.scale(f, f, f2, f3);
            }
        }
        this.n.reset();
        this.n.preScale(width, height);
        this.H.draw(canvas, this.n, this.I);
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.I;
    }

    public com.airbnb.lottie.LottieComposition getComposition() {
        return this.t;
    }

    public int getFrame() {
        return (int) this.u.getFrame();
    }

    @androidx.annotation.Nullable
    public android.graphics.Bitmap getImageAsset(java.lang.String str) {
        com.airbnb.lottie.manager.ImageAssetManager j = j();
        if (j != null) {
            return j.bitmapForId(str);
        }
        return null;
    }

    @androidx.annotation.Nullable
    public java.lang.String getImageAssetsFolder() {
        return this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.t == null) {
            return -1;
        }
        return (int) (r0.getBounds().height() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.t == null) {
            return -1;
        }
        return (int) (r0.getBounds().width() * getScale());
    }

    public float getMaxFrame() {
        return this.u.getMaxFrame();
    }

    public float getMinFrame() {
        return this.u.getMinFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.PerformanceTracker getPerformanceTracker() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.u.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.u.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.u.getRepeatMode();
    }

    public float getScale() {
        return this.v;
    }

    public float getSpeed() {
        return this.u.getSpeed();
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.TextDelegate getTextDelegate() {
        return this.F;
    }

    @androidx.annotation.Nullable
    public android.graphics.Typeface getTypeface(java.lang.String str, java.lang.String str2) {
        com.airbnb.lottie.manager.FontAssetManager i = i();
        if (i != null) {
            return i.getTypeface(str, str2);
        }
        return null;
    }

    public final void h(android.graphics.Canvas canvas) {
        float f;
        int i;
        if (this.H == null) {
            return;
        }
        float f2 = this.v;
        float k = k(canvas);
        if (f2 > k) {
            f = this.v / k;
        } else {
            k = f2;
            f = 1.0f;
        }
        if (f > 1.0f) {
            i = canvas.save();
            float width = this.t.getBounds().width() / 2.0f;
            float height = this.t.getBounds().height() / 2.0f;
            float f3 = width * k;
            float f4 = height * k;
            canvas.translate((getScale() * width) - f3, (getScale() * height) - f4);
            canvas.scale(f, f, f3, f4);
        } else {
            i = -1;
        }
        this.n.reset();
        this.n.preScale(k, k);
        this.H.draw(canvas, this.n, this.I);
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    public boolean hasMasks() {
        com.airbnb.lottie.model.layer.CompositionLayer compositionLayer = this.H;
        return compositionLayer != null && compositionLayer.hasMasks();
    }

    public boolean hasMatte() {
        com.airbnb.lottie.model.layer.CompositionLayer compositionLayer = this.H;
        return compositionLayer != null && compositionLayer.hasMatte();
    }

    public final com.airbnb.lottie.manager.FontAssetManager i() {
        if (getCallback() == null) {
            return null;
        }
        if (this.D == null) {
            this.D = new com.airbnb.lottie.manager.FontAssetManager(getCallback(), this.E);
        }
        return this.D;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.N) {
            return;
        }
        this.N = true;
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAnimating() {
        com.airbnb.lottie.utils.LottieValueAnimator lottieValueAnimator = this.u;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.L;
    }

    public boolean isLooping() {
        return this.u.getRepeatCount() == -1;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.G;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public final com.airbnb.lottie.manager.ImageAssetManager j() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.manager.ImageAssetManager imageAssetManager = this.A;
        if (imageAssetManager != null && !imageAssetManager.hasSameContext(getContext())) {
            this.A = null;
        }
        if (this.A == null) {
            this.A = new com.airbnb.lottie.manager.ImageAssetManager(getCallback(), this.B, this.C, this.t.getImages());
        }
        return this.A;
    }

    public final float k(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        return java.lang.Math.min(canvas.getWidth() / this.t.getBounds().width(), canvas.getHeight() / this.t.getBounds().height());
    }

    public void l(java.lang.Boolean bool) {
        this.w = bool.booleanValue();
    }

    @java.lang.Deprecated
    public void loop(boolean z) {
        this.u.setRepeatCount(z ? -1 : 0);
    }

    public void pauseAnimation() {
        this.y.clear();
        this.u.pauseAnimation();
    }

    @androidx.annotation.MainThread
    public void playAnimation() {
        if (this.H == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass2());
            return;
        }
        if (this.w || getRepeatCount() == 0) {
            this.u.playAnimation();
        }
        if (this.w) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        this.u.endAnimation();
    }

    public void removeAllAnimatorListeners() {
        this.u.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.u.removeAllUpdateListeners();
        this.u.addUpdateListener(this.z);
    }

    public void removeAnimatorListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.u.removeListener(animatorListener);
    }

    @androidx.annotation.RequiresApi(api = 19)
    public void removeAnimatorPauseListener(android.animation.Animator.AnimatorPauseListener animatorPauseListener) {
        this.u.removePauseListener(animatorPauseListener);
    }

    public void removeAnimatorUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.u.removeUpdateListener(animatorUpdateListener);
    }

    public java.util.List<com.airbnb.lottie.model.KeyPath> resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath) {
        if (this.H == null) {
            com.airbnb.lottie.utils.Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.H.resolveKeyPath(keyPath, 0, arrayList, new com.airbnb.lottie.model.KeyPath(new java.lang.String[0]));
        return arrayList;
    }

    @androidx.annotation.MainThread
    public void resumeAnimation() {
        if (this.H == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass3());
            return;
        }
        if (this.w || getRepeatCount() == 0) {
            this.u.resumeAnimation();
        }
        if (this.w) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        this.u.endAnimation();
    }

    public void reverseAnimationSpeed() {
        this.u.reverseAnimationSpeed();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable, long j) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@androidx.annotation.IntRange(from = 0, to = 255) int i) {
        this.I = i;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.L = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        com.airbnb.lottie.utils.Logger.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(com.airbnb.lottie.LottieComposition lottieComposition) {
        if (this.t == lottieComposition) {
            return false;
        }
        this.N = false;
        clearComposition();
        this.t = lottieComposition;
        e();
        this.u.setComposition(lottieComposition);
        setProgress(this.u.getAnimatedFraction());
        setScale(this.v);
        java.util.Iterator it = new java.util.ArrayList(this.y).iterator();
        while (it.hasNext()) {
            com.airbnb.lottie.LottieDrawable.LazyCompositionTask lazyCompositionTask = (com.airbnb.lottie.LottieDrawable.LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.a(lottieComposition);
            }
            it.remove();
        }
        this.y.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.J);
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (!(callback instanceof android.widget.ImageView)) {
            return true;
        }
        android.widget.ImageView imageView = (android.widget.ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.FontAssetDelegate fontAssetDelegate) {
        this.E = fontAssetDelegate;
        com.airbnb.lottie.manager.FontAssetManager fontAssetManager = this.D;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setFrame(int i) {
        if (this.t == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass14(i));
        } else {
            this.u.setFrame(i);
        }
    }

    public void setImageAssetDelegate(com.airbnb.lottie.ImageAssetDelegate imageAssetDelegate) {
        this.C = imageAssetDelegate;
        com.airbnb.lottie.manager.ImageAssetManager imageAssetManager = this.A;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setImagesAssetsFolder(@androidx.annotation.Nullable java.lang.String str) {
        this.B = str;
    }

    public void setMaxFrame(int i) {
        if (this.t == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass6(i));
        } else {
            this.u.setMaxFrame(i + 0.99f);
        }
    }

    public void setMaxFrame(java.lang.String str) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass9(str));
            return;
        }
        com.airbnb.lottie.model.Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.startFrame + marker.durationFrames));
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMaxProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass7(f));
        } else {
            setMaxFrame((int) com.airbnb.lottie.utils.MiscUtils.lerp(lottieComposition.getStartFrame(), this.t.getEndFrame(), f));
        }
    }

    public void setMinAndMaxFrame(int i, int i2) {
        if (this.t == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass12(i, i2));
        } else {
            this.u.setMinAndMaxFrames(i, i2 + 0.99f);
        }
    }

    public void setMinAndMaxFrame(java.lang.String str) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass10(str));
            return;
        }
        com.airbnb.lottie.model.Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i = (int) marker.startFrame;
            setMinAndMaxFrame(i, ((int) marker.durationFrames) + i);
        } else {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void setMinAndMaxFrame(java.lang.String str, java.lang.String str2, boolean z) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass11(str, str2, z));
            return;
        }
        com.airbnb.lottie.model.Marker marker = lottieComposition.getMarker(str);
        if (marker == null) {
            throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) marker.startFrame;
        com.airbnb.lottie.model.Marker marker2 = this.t.getMarker(str2);
        if (marker2 != null) {
            setMinAndMaxFrame(i, (int) (marker2.startFrame + (z ? 1.0f : 0.0f)));
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    public void setMinAndMaxProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass13(f, f2));
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.utils.MiscUtils.lerp(lottieComposition.getStartFrame(), this.t.getEndFrame(), f), (int) com.airbnb.lottie.utils.MiscUtils.lerp(this.t.getStartFrame(), this.t.getEndFrame(), f2));
        }
    }

    public void setMinFrame(int i) {
        if (this.t == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass4(i));
        } else {
            this.u.setMinFrame(i);
        }
    }

    public void setMinFrame(java.lang.String str) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass8(str));
            return;
        }
        com.airbnb.lottie.model.Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.startFrame);
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinProgress(float f) {
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass5(f));
        } else {
            setMinFrame((int) com.airbnb.lottie.utils.MiscUtils.lerp(lottieComposition.getStartFrame(), this.t.getEndFrame(), f));
        }
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if (this.K == z) {
            return;
        }
        this.K = z;
        com.airbnb.lottie.model.layer.CompositionLayer compositionLayer = this.H;
        if (compositionLayer != null) {
            compositionLayer.setOutlineMasksAndMattes(z);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.J = z;
        com.airbnb.lottie.LottieComposition lottieComposition = this.t;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z);
        }
    }

    public void setProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.t == null) {
            this.y.add(new com.airbnb.lottie.LottieDrawable.AnonymousClass15(f));
            return;
        }
        com.airbnb.lottie.L.beginSection("Drawable#setProgress");
        this.u.setFrame(com.airbnb.lottie.utils.MiscUtils.lerp(this.t.getStartFrame(), this.t.getEndFrame(), f));
        com.airbnb.lottie.L.endSection("Drawable#setProgress");
    }

    public void setRepeatCount(int i) {
        this.u.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.u.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.x = z;
    }

    public void setScale(float f) {
        this.v = f;
    }

    public void setSpeed(float f) {
        this.u.setSpeed(f);
    }

    public void setTextDelegate(com.airbnb.lottie.TextDelegate textDelegate) {
        this.F = textDelegate;
    }

    @Override // android.graphics.drawable.Animatable
    @androidx.annotation.MainThread
    public void start() {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (!(callback instanceof android.view.View) || ((android.view.View) callback).isInEditMode()) {
            return;
        }
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    @androidx.annotation.MainThread
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    @androidx.annotation.Nullable
    public android.graphics.Bitmap updateBitmap(java.lang.String str, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        com.airbnb.lottie.manager.ImageAssetManager j = j();
        if (j == null) {
            com.airbnb.lottie.utils.Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        android.graphics.Bitmap updateBitmap = j.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    public boolean useTextGlyphs() {
        return this.F == null && this.t.getCharacters().size() > 0;
    }
}
