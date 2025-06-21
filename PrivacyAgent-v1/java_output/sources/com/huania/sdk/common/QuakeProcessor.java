package com.huania.sdk.common;

@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\bH\u0002R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001dR\u0016\u0010-\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010$¨\u00064"}, d2 = {"Lcom/huania/sdk/common/QuakeProcessor;", "", "Lcom/huania/sdk/entity/EarthquakeEntity;", "entity", "Landroid/content/Context;", "context", "Lcom/huania/sdk/common/IView;", "iView", "", "update", "showSurvey", "closeVoice", "closeEarlyWarning", "a", "Landroid/content/Context;", "Lio/reactivex/disposables/Disposable;", "b", "Lio/reactivex/disposables/Disposable;", "observerStaticView", "Lio/reactivex/observers/DisposableObserver;", "", "c", "Lio/reactivex/observers/DisposableObserver;", "observer", "Lcom/huania/sdk/utils/PlaySound;", "d", "Lcom/huania/sdk/utils/PlaySound;", "playSound", "e", "Lcom/huania/sdk/entity/EarthquakeEntity;", "getEntity", "()Lcom/huania/sdk/entity/EarthquakeEntity;", "setEntity", "(Lcom/huania/sdk/entity/EarthquakeEntity;)V", "", "f", "Z", "isSameQuake", "", "g", "I", "timeSync", "h", "firstQuake", "i", "isVoiceClose", "j", "Lcom/huania/sdk/common/IView;", "k", "isTrigger", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class QuakeProcessor {

    /* renamed from: a, reason: from kotlin metadata */
    public android.content.Context context;

    /* renamed from: b, reason: from kotlin metadata */
    public io.reactivex.disposables.Disposable observerStaticView;

    /* renamed from: c, reason: from kotlin metadata */
    public io.reactivex.observers.DisposableObserver<java.lang.Long> observer;

    /* renamed from: d, reason: from kotlin metadata */
    public com.huania.sdk.utils.PlaySound playSound;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public com.huania.sdk.entity.EarthquakeEntity entity = new com.huania.sdk.entity.EarthquakeEntity();

    /* renamed from: f, reason: from kotlin metadata */
    public boolean isSameQuake;

    /* renamed from: g, reason: from kotlin metadata */
    public int timeSync;

    /* renamed from: h, reason: from kotlin metadata */
    public com.huania.sdk.entity.EarthquakeEntity firstQuake;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean isVoiceClose;

    /* renamed from: j, reason: from kotlin metadata */
    public com.huania.sdk.common.IView iView;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean isTrigger;

    public final void a() {
        io.reactivex.disposables.Disposable disposable = this.observerStaticView;
        if (disposable != null) {
            disposable.dispose();
        }
        com.huania.sdk.entity.EarthquakeEntity earthquakeEntity = this.firstQuake;
        if (earthquakeEntity != null) {
            com.huania.sdk.utils.Logger.INSTANCE.d("showStaticView：" + earthquakeEntity);
            com.huania.sdk.common.IView iView = this.iView;
            if (iView != null) {
                iView.showStaticView(earthquakeEntity);
            }
        }
    }

    public final void closeEarlyWarning() {
        com.huania.sdk.utils.Logger.INSTANCE.d("closeEarlyWarning");
        com.huania.sdk.utils.PlaySound playSound = this.playSound;
        if (playSound != null) {
            playSound.stop();
        }
        io.reactivex.observers.DisposableObserver<java.lang.Long> disposableObserver = this.observer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        io.reactivex.disposables.Disposable disposable = this.observerStaticView;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void closeVoice() {
        com.huania.sdk.utils.Logger.INSTANCE.d("closeVoice");
        this.isVoiceClose = true;
        com.huania.sdk.utils.PlaySound playSound = this.playSound;
        if (playSound != null) {
            playSound.stop();
        }
    }

    @org.jetbrains.annotations.NotNull
    public final com.huania.sdk.entity.EarthquakeEntity getEntity() {
        return this.entity;
    }

    public final void setEntity(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity earthquakeEntity) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(earthquakeEntity, "<set-?>");
        this.entity = earthquakeEntity;
    }

    public final void showSurvey(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity entity) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(entity, "entity");
        com.huania.sdk.common.IView iView = this.iView;
        if (iView != null) {
            iView.showSurveyView(entity);
        }
    }

    public final void update(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity entity, @org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable com.huania.sdk.common.IView iView) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(entity, "entity");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.iView = iView;
        com.huania.sdk.entity.EarthquakeEntity earthquakeEntity = this.entity;
        this.isSameQuake = earthquakeEntity != null && kotlin.jvm.internal.Intrinsics.areEqual(earthquakeEntity.getEventId(), entity.getEventId());
        com.huania.sdk.utils.Logger logger = com.huania.sdk.utils.Logger.INSTANCE;
        logger.d("onProcessFinish:" + entity);
        if (iView != null) {
            iView.onProcessFinish(entity);
        }
        java.lang.Integer curCountdown = entity.getCurCountdown();
        if (curCountdown == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        if (curCountdown.intValue() < -300) {
            return;
        }
        boolean z = this.isTrigger;
        if (!this.isSameQuake) {
            z = false;
        }
        java.lang.Float curIntensity = entity.getCurIntensity();
        if (curIntensity == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        float f = 2;
        boolean z2 = curIntensity.floatValue() < f ? z : true;
        java.lang.Float curIntensity2 = entity.getCurIntensity();
        if (curIntensity2 == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        if (curIntensity2.floatValue() >= f || z2) {
            this.entity = entity;
            this.isTrigger = z2;
            this.playSound = com.huania.sdk.utils.PlaySound.getInstance(context);
            io.reactivex.observers.DisposableObserver<java.lang.Long> disposableObserver = this.observer;
            if (disposableObserver != null) {
                disposableObserver.dispose();
            }
            if (!this.isSameQuake) {
                com.huania.sdk.utils.PlaySound playSound = this.playSound;
                if (playSound != null) {
                    playSound.clear();
                }
                this.firstQuake = entity;
                this.timeSync = 0;
                io.reactivex.disposables.Disposable disposable = this.observerStaticView;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.isVoiceClose = false;
            }
            java.lang.Integer curCountdown2 = entity.getCurCountdown();
            if (curCountdown2 == null) {
                kotlin.jvm.internal.Intrinsics.throwNpe();
            }
            if (curCountdown2.intValue() >= 0) {
                logger.d("showEarlyWarningView:" + entity);
                if (iView != null) {
                    iView.showEarlyWarningView(entity);
                }
            } else {
                java.lang.Integer curCountdown3 = entity.getCurCountdown();
                if (curCountdown3 == null) {
                    kotlin.jvm.internal.Intrinsics.throwNpe();
                }
                if (curCountdown3.intValue() < -10) {
                    logger.d("showStaticView");
                    com.huania.sdk.utils.PlaySound playSound2 = this.playSound;
                    if (playSound2 != null) {
                        playSound2.clear();
                    }
                    a();
                    return;
                }
                entity.setCurCountdown(0);
                logger.d("showDeadZoneView:" + entity);
                if (iView != null) {
                    iView.showDeadZoneView(entity);
                }
            }
            io.reactivex.Observable<R> map = io.reactivex.Observable.interval(0L, 1L, java.util.concurrent.TimeUnit.SECONDS).map(new com.huania.sdk.common.QuakeProcessor$update$1(entity));
            if (entity.getCurCountdown() == null) {
                kotlin.jvm.internal.Intrinsics.throwNpe();
            }
            this.observer = (io.reactivex.observers.DisposableObserver) map.take(r0.intValue() + 10).observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).subscribeWith(new com.huania.sdk.common.QuakeProcessor$update$2(this, iView, entity));
        }
    }
}
