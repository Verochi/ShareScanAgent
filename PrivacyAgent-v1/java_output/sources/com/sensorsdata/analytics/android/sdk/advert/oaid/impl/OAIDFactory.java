package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
public final class OAIDFactory {
    private static final java.lang.String TAG = "SA.OAIDFactory";
    private static com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID ioaid;

    public static com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID create(android.content.Context context) {
        if (context != null && !(context instanceof android.app.Application)) {
            context = context.getApplicationContext();
        }
        com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID iRomOAID = ioaid;
        if (iRomOAID != null) {
            return iRomOAID;
        }
        com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID createManufacturerImpl = createManufacturerImpl(context);
        ioaid = createManufacturerImpl;
        if (createManufacturerImpl == null || !createManufacturerImpl.isSupported()) {
            com.sensorsdata.analytics.android.sdk.advert.oaid.impl.DefaultImpl defaultImpl = new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.DefaultImpl();
            ioaid = defaultImpl;
            return defaultImpl;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Manufacturer interface has been found: " + ioaid.getClass().getName());
        return ioaid;
    }

    private static com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID createManufacturerImpl(android.content.Context context) {
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isHuawei() || com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isEmui()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.HuaweiImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isXiaomi() || com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isMiui() || com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isBlackShark()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.XiaomiImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isVivo()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.VivoImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isOppo() || com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isOnePlus()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OppoImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isMeizu()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.MeizuImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isSamsung()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.SamsungImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isNubia()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.NubiaImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isASUS()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.AsusImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isLenovo() || com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isMotolora()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.LenovoImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isZTE()) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.ZTEImpl(context);
        }
        if (com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.isCoolpad(context)) {
            return new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.CoolpadImpl(context);
        }
        return null;
    }
}
