package com.huania.sdk.common;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/huania/sdk/common/QuakeProcessor$update$2", "Lio/reactivex/observers/DisposableObserver;", "", "onComplete", "", "onError", "e", "", "onNext", "t", "sdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes22.dex */
public final class QuakeProcessor$update$2 extends io.reactivex.observers.DisposableObserver<java.lang.Long> {
    public final /* synthetic */ com.huania.sdk.common.QuakeProcessor t;
    public final /* synthetic */ com.huania.sdk.common.IView u;
    public final /* synthetic */ com.huania.sdk.entity.EarthquakeEntity v;

    public QuakeProcessor$update$2(com.huania.sdk.common.QuakeProcessor quakeProcessor, com.huania.sdk.common.IView iView, com.huania.sdk.entity.EarthquakeEntity earthquakeEntity) {
        this.t = quakeProcessor;
        this.u = iView;
        this.v = earthquakeEntity;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        com.huania.sdk.utils.PlaySound playSound;
        io.reactivex.observers.DisposableObserver disposableObserver;
        com.huania.sdk.utils.Logger.INSTANCE.d("onComplete");
        playSound = this.t.playSound;
        if (playSound != null) {
            playSound.stop();
        }
        disposableObserver = this.t.observer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        this.t.a();
    }

    @Override // io.reactivex.Observer
    public void onError(@org.jetbrains.annotations.NotNull java.lang.Throwable e) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(e, "e");
        e.printStackTrace();
        com.huania.sdk.utils.Logger.INSTANCE.e("ee:" + e.getCause());
    }

    public void onNext(long t) {
        int i;
        boolean z;
        com.huania.sdk.utils.PlaySound playSound;
        boolean z2;
        int i2;
        int i3;
        com.huania.sdk.utils.PlaySound playSound2;
        com.huania.sdk.common.QuakeProcessor quakeProcessor = this.t;
        i = quakeProcessor.timeSync;
        quakeProcessor.timeSync = i + 1;
        com.huania.sdk.utils.Logger logger = com.huania.sdk.utils.Logger.INSTANCE;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("updateCountdown:");
        int i4 = (int) t;
        sb.append(i4);
        logger.d(sb.toString());
        com.huania.sdk.common.IView iView = this.u;
        if (iView != null) {
            iView.updateCountdown(i4);
        }
        z = this.t.isVoiceClose;
        if (z) {
            logger.d("关闭声音");
            playSound2 = this.t.playSound;
            if (playSound2 != null) {
                playSound2.clear();
                return;
            }
            return;
        }
        playSound = this.t.playSound;
        if (playSound != null) {
            z2 = this.t.isSameQuake;
            if (z2) {
                java.lang.Integer curCountdown = this.v.getCurCountdown();
                if (curCountdown == null || curCountdown.intValue() != i4) {
                    i3 = this.t.timeSync;
                    if (i3 != 20 || i4 <= 0) {
                        return;
                    }
                    logger.d("校准播放");
                    this.t.timeSync = 0;
                    java.lang.Float curIntensity = this.v.getCurIntensity();
                    if (curIntensity == null) {
                        kotlin.jvm.internal.Intrinsics.throwNpe();
                    }
                    playSound.playWithoutDingdong(i4, curIntensity.floatValue());
                    return;
                }
                logger.d("多报");
                java.lang.Integer curCountdown2 = this.v.getCurCountdown();
                if (curCountdown2 != null && curCountdown2.intValue() == 0) {
                    playSound.playWuwuWithoutDingdong();
                    return;
                }
                this.t.timeSync = 0;
                java.lang.Float curIntensity2 = this.v.getCurIntensity();
                if (curIntensity2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwNpe();
                }
                playSound.playWithoutDingdong(i4, curIntensity2.floatValue());
                return;
            }
            java.lang.Integer curCountdown3 = this.v.getCurCountdown();
            if (curCountdown3 == null || curCountdown3.intValue() != i4) {
                i2 = this.t.timeSync;
                if (i2 != 20 || i4 <= 0) {
                    return;
                }
                logger.d("校准播放");
                this.t.timeSync = 0;
                java.lang.Float curIntensity3 = this.v.getCurIntensity();
                if (curIntensity3 == null) {
                    kotlin.jvm.internal.Intrinsics.throwNpe();
                }
                playSound.playWithoutDingdong(i4, curIntensity3.floatValue());
                return;
            }
            logger.d("首报");
            java.lang.Integer curCountdown4 = this.v.getCurCountdown();
            if (curCountdown4 != null && curCountdown4.intValue() == 0) {
                playSound.playWuwu();
                return;
            }
            this.t.timeSync = 0;
            java.lang.Float curIntensity4 = this.v.getCurIntensity();
            if (curIntensity4 == null) {
                kotlin.jvm.internal.Intrinsics.throwNpe();
            }
            playSound.play(i4, curIntensity4.floatValue());
        }
    }

    @Override // io.reactivex.Observer
    public /* bridge */ /* synthetic */ void onNext(java.lang.Object obj) {
        onNext(((java.lang.Number) obj).longValue());
    }
}
