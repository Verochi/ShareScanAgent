package com.huania.sdk.common;

@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J6\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J^\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"J\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u0006J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0002R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010)¨\u0006-"}, d2 = {"Lcom/huania/sdk/common/QuakeManager;", "", "Landroid/content/Context;", "context", "", "platform", "", "init", "", "longitude", "latitude", com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, "county", "setLocation", com.alipay.sdk.m.l.c.f, "setHost", "", "are", com.umeng.ccg.a.j, "movement", "setCurrentStatus", "", com.heytap.mcssdk.constant.b.k, "updates", "epicenter", "depth", "magnitude", "startAt", "updateAt", "Lcom/huania/sdk/common/IView;", "iView", "createWarningView", "Lcom/huania/sdk/entity/EarthquakeEntity;", "entity", "showSurvey", "closeVoice", "closeEarlyWarning", "a", "Lcom/huania/sdk/common/QuakeProcessor;", "Lcom/huania/sdk/common/QuakeProcessor;", "quakeProcessor", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class QuakeManager {
    public static final com.huania.sdk.common.QuakeManager INSTANCE = new com.huania.sdk.common.QuakeManager();

    /* renamed from: a, reason: from kotlin metadata */
    public static final com.huania.sdk.common.QuakeProcessor quakeProcessor = new com.huania.sdk.common.QuakeProcessor();

    public final void a(com.huania.sdk.entity.EarthquakeEntity entity) {
        com.huania.sdk.utils.PreferencesHelper preferencesHelper = com.huania.sdk.utils.PreferencesHelper.INSTANCE;
        float f = preferencesHelper.getFloat("latitude");
        float f2 = preferencesHelper.getFloat("longitude");
        java.lang.String string = preferencesHelper.getString(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
        java.lang.Float latitude = entity.getLatitude();
        if (latitude == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        float floatValue = latitude.floatValue();
        java.lang.Float longitude = entity.getLongitude();
        if (longitude == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        float distance = com.huania.sdk.utils.CalcCountdown.distance(f, f2, floatValue, longitude.floatValue());
        java.lang.Float magnitude = entity.getMagnitude();
        if (magnitude == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        float intensity = com.huania.sdk.utils.CalcCountdown.getIntensity(magnitude.floatValue(), distance);
        com.huania.sdk.utils.Logger.INSTANCE.d("震级烈度：" + entity.getMagnitude() + "     " + intensity);
        com.huania.sdk.utils.Utils utils = com.huania.sdk.utils.Utils.INSTANCE;
        java.lang.Float depth = entity.getDepth();
        if (depth == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        entity.setCurCountdown(java.lang.Integer.valueOf(utils.getTheoryCountdown(com.huania.sdk.utils.CalcCountdown.getCountDownSeconds(depth.floatValue(), distance), entity.getStartAt(), entity.getUpdateAt())));
        entity.setCurDistance(java.lang.Float.valueOf(distance));
        entity.setCurIntensity(java.lang.Float.valueOf(intensity));
        entity.setCurLongitude(java.lang.Float.valueOf(f2));
        entity.setCurLatitude(java.lang.Float.valueOf(f));
        entity.setCurLocation(string);
    }

    public final void closeEarlyWarning() {
        quakeProcessor.closeEarlyWarning();
    }

    public final void closeVoice() {
        quakeProcessor.closeVoice();
    }

    public final void createWarningView(@org.jetbrains.annotations.NotNull android.content.Context context, long eventId, int updates, float longitude, float latitude, @org.jetbrains.annotations.NotNull java.lang.String epicenter, float depth, float magnitude, long startAt, long updateAt, @org.jetbrains.annotations.NotNull com.huania.sdk.common.IView iView) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(epicenter, "epicenter");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(iView, "iView");
        com.huania.sdk.entity.EarthquakeEntity earthquakeEntity = new com.huania.sdk.entity.EarthquakeEntity();
        earthquakeEntity.setEventId(java.lang.Long.valueOf(eventId));
        earthquakeEntity.setUpdates(java.lang.Integer.valueOf(updates));
        earthquakeEntity.setLongitude(java.lang.Float.valueOf(longitude));
        earthquakeEntity.setLatitude(java.lang.Float.valueOf(latitude));
        earthquakeEntity.setEpicenter(epicenter);
        earthquakeEntity.setDepth(java.lang.Float.valueOf(depth));
        earthquakeEntity.setMagnitude(java.lang.Float.valueOf(magnitude));
        earthquakeEntity.setStartAt(java.lang.Long.valueOf(startAt));
        earthquakeEntity.setUpdateAt(java.lang.Long.valueOf(updateAt));
        a(earthquakeEntity);
        if (kotlin.jvm.internal.Intrinsics.areEqual(earthquakeEntity.getCurLatitude(), 0.0f) || kotlin.jvm.internal.Intrinsics.areEqual(earthquakeEntity.getCurLongitude(), 0.0f)) {
            return;
        }
        com.huania.sdk.utils.Utils utils = com.huania.sdk.utils.Utils.INSTANCE;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (earthquakeEntity.getUpdateAt() == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        int formateMeihuanInt = utils.formateMeihuanInt(java.lang.Float.valueOf((currentTimeMillis - r6.longValue()) / 1000), 0);
        if (formateMeihuanInt < 0) {
            formateMeihuanInt = 0;
        }
        if (earthquakeEntity.getCurCountdown() == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        earthquakeEntity.setCurCountdown(java.lang.Integer.valueOf(utils.formateMeihuanInt(java.lang.Float.valueOf(r6.intValue() - formateMeihuanInt), 0)));
        quakeProcessor.update(earthquakeEntity, context, iView);
    }

    public final void init(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.NotNull java.lang.String platform) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(platform, "platform");
        com.huania.sdk.utils.PlaySound.getInstance(context);
        com.huania.sdk.utils.PreferencesHelper preferencesHelper = com.huania.sdk.utils.PreferencesHelper.INSTANCE;
        com.huania.sdk.utils.PreferencesHelper.init$default(preferencesHelper, context, null, 2, null);
        preferencesHelper.putString("platform", platform);
    }

    public final void setCurrentStatus(int are, int scene, int movement) {
        com.huania.sdk.utils.PreferencesHelper preferencesHelper = com.huania.sdk.utils.PreferencesHelper.INSTANCE;
        preferencesHelper.putInt("area", java.lang.Integer.valueOf(are));
        preferencesHelper.putInt(com.umeng.ccg.a.j, java.lang.Integer.valueOf(scene));
        preferencesHelper.putInt("movement", java.lang.Integer.valueOf(movement));
    }

    public final void setHost(@org.jetbrains.annotations.NotNull java.lang.String host) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(host, "host");
        com.huania.sdk.utils.PreferencesHelper.INSTANCE.putString(com.alipay.sdk.m.l.c.f, host);
    }

    public final void setLocation(float longitude, float latitude, @org.jetbrains.annotations.NotNull java.lang.String location, @org.jetbrains.annotations.NotNull java.lang.String province, @org.jetbrains.annotations.NotNull java.lang.String city, @org.jetbrains.annotations.NotNull java.lang.String county) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(location, "location");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(province, "province");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(city, "city");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(county, "county");
        com.huania.sdk.utils.PreferencesHelper preferencesHelper = com.huania.sdk.utils.PreferencesHelper.INSTANCE;
        preferencesHelper.putFloat("latitude", java.lang.Float.valueOf(latitude));
        preferencesHelper.putFloat("longitude", java.lang.Float.valueOf(longitude));
        preferencesHelper.putString(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, location);
        preferencesHelper.putString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, province);
        preferencesHelper.putString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, city);
        preferencesHelper.putString("county", county);
    }

    public final void showSurvey(@org.jetbrains.annotations.Nullable com.huania.sdk.entity.EarthquakeEntity entity) {
        if (entity == null) {
            return;
        }
        quakeProcessor.showSurvey(entity);
    }
}
