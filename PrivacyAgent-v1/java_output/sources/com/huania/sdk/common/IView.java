package com.huania.sdk.common;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/huania/sdk/common/IView;", "", "onProcessFinish", "", "entity", "Lcom/huania/sdk/entity/EarthquakeEntity;", "showDeadZoneView", "showEarlyWarningView", "showStaticView", "showSurveyView", "updateCountdown", com.anythink.expressad.d.a.b.dk, "", "sdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes22.dex */
public interface IView {
    void onProcessFinish(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity entity);

    void showDeadZoneView(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity entity);

    void showEarlyWarningView(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity entity);

    void showStaticView(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity entity);

    void showSurveyView(@org.jetbrains.annotations.NotNull com.huania.sdk.entity.EarthquakeEntity entity);

    void updateCountdown(int countdown);
}
