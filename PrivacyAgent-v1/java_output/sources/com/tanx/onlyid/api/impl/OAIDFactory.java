package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
public final class OAIDFactory {
    public static com.tanx.onlyid.api.IOAID a;

    public static com.tanx.onlyid.api.IOAID a(android.content.Context context) {
        if (com.tanx.onlyid.api.OAIDRom.isLenovo() || com.tanx.onlyid.api.OAIDRom.isMotolora()) {
            return new com.tanx.onlyid.api.impl.LenovoImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isMeizu()) {
            return new com.tanx.onlyid.api.impl.MeizuImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isNubia()) {
            return new com.tanx.onlyid.api.impl.NubiaImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isXiaomi() || com.tanx.onlyid.api.OAIDRom.isMiui() || com.tanx.onlyid.api.OAIDRom.isBlackShark()) {
            return new com.tanx.onlyid.api.impl.XiaomiImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isSamsung()) {
            return new com.tanx.onlyid.api.impl.SamsungImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isVivo()) {
            return new com.tanx.onlyid.api.impl.VivoImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isASUS()) {
            return new com.tanx.onlyid.api.impl.AsusImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isHonor()) {
            com.tanx.onlyid.api.impl.HonorImpl honorImpl = new com.tanx.onlyid.api.impl.HonorImpl(context);
            if (honorImpl.supported()) {
                return honorImpl;
            }
        }
        if (com.tanx.onlyid.api.OAIDRom.isHuawei() || com.tanx.onlyid.api.OAIDRom.isEmui()) {
            return new com.tanx.onlyid.api.impl.HuaweiImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isOppo() || com.tanx.onlyid.api.OAIDRom.isOnePlus()) {
            return new com.tanx.onlyid.api.impl.OppoImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isCoolpad(context)) {
            return new com.tanx.onlyid.api.impl.CoolpadImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isCoosea()) {
            return new com.tanx.onlyid.api.impl.CooseaImpl(context);
        }
        if (com.tanx.onlyid.api.OAIDRom.isFreeme()) {
            return new com.tanx.onlyid.api.impl.FreemeImpl(context);
        }
        return null;
    }

    public static com.tanx.onlyid.api.IOAID b(android.content.Context context) {
        com.tanx.onlyid.api.impl.MsaImpl msaImpl = new com.tanx.onlyid.api.impl.MsaImpl(context);
        if (msaImpl.supported()) {
            com.tanx.onlyid.api.OAIDLog.print("Mobile Security Alliance has been found: " + com.tanx.onlyid.api.impl.MsaImpl.class.getName());
            return msaImpl;
        }
        com.tanx.onlyid.api.impl.GmsImpl gmsImpl = new com.tanx.onlyid.api.impl.GmsImpl(context);
        if (gmsImpl.supported()) {
            com.tanx.onlyid.api.OAIDLog.print("Google Play Service has been found: " + com.tanx.onlyid.api.impl.GmsImpl.class.getName());
            return gmsImpl;
        }
        com.tanx.onlyid.api.impl.DefaultImpl defaultImpl = new com.tanx.onlyid.api.impl.DefaultImpl();
        com.tanx.onlyid.api.OAIDLog.print("OAID/AAID was not supported: " + com.tanx.onlyid.api.impl.DefaultImpl.class.getName());
        return defaultImpl;
    }

    public static com.tanx.onlyid.api.IOAID create(android.content.Context context) {
        if (context != null && !(context instanceof android.app.Application)) {
            context = context.getApplicationContext();
        }
        com.tanx.onlyid.api.IOAID ioaid = a;
        if (ioaid != null) {
            return ioaid;
        }
        com.tanx.onlyid.api.IOAID a2 = a(context);
        a = a2;
        if (a2 == null || !a2.supported()) {
            com.tanx.onlyid.api.IOAID b = b(context);
            a = b;
            return b;
        }
        com.tanx.onlyid.api.OAIDLog.print("Manufacturer interface has been found: " + a.getClass().getName());
        return a;
    }
}
