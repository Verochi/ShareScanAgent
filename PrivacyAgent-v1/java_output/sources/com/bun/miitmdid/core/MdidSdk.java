package com.bun.miitmdid.core;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class MdidSdk implements com.bun.supplier.SupplierListener {
    private java.lang.String _AddId;
    private com.bun.supplier.IIdentifierListener _InnerListener;
    private com.bun.miitmdid.a.b _setting;

    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.bun.miitmdid.c.a.values().length];
            a = iArr;
            try {
                iArr[com.bun.miitmdid.c.a.XIAOMI.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.bun.miitmdid.c.a.BLACKSHARK.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.bun.miitmdid.c.a.VIVO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.bun.miitmdid.c.a.HUA_WEI.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.bun.miitmdid.c.a.OPPO.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.bun.miitmdid.c.a.ONEPLUS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.bun.miitmdid.c.a.MOTO.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[com.bun.miitmdid.c.a.LENOVO.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[com.bun.miitmdid.c.a.ASUS.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                a[com.bun.miitmdid.c.a.SAMSUNG.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                a[com.bun.miitmdid.c.a.MEIZU.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                a[com.bun.miitmdid.c.a.NUBIA.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                a[com.bun.miitmdid.c.a.ZTE.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                a[com.bun.miitmdid.c.a.FREEMEOS.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                a[com.bun.miitmdid.c.a.SSUIOS.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
        }
    }

    @androidx.annotation.Keep
    public MdidSdk() {
        try {
            com.bun.lib.a.a(true);
        } catch (java.lang.Exception e) {
            com.bun.lib.a.b("mdidsdk", "extractor exception!", e);
        }
    }

    @androidx.annotation.Keep
    public MdidSdk(boolean z) {
        try {
            com.bun.lib.a.a(z);
        } catch (java.lang.Exception e) {
            com.bun.lib.a.b("mdidsdk", "extractor exception!", e);
        }
    }

    private void SaveAddid(java.lang.String str) {
    }

    private int _InnerFailed(int i, com.bun.supplier.IdSupplier idSupplier) {
        OnSupport(idSupplier != null ? idSupplier.isSupported() : false, idSupplier);
        return i;
    }

    public java.lang.String CreateAdditionalId(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (list != null && !list.isEmpty()) {
            for (java.lang.String str : list) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    stringBuffer.append(str);
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (java.lang.String str2 : list2) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    stringBuffer.append(str2);
                }
            }
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        if (android.text.TextUtils.isEmpty(stringBuffer2)) {
            return "";
        }
        java.lang.String a2 = com.bun.lib.c.a(stringBuffer2);
        this._AddId = a2;
        return a2;
    }

    @androidx.annotation.Keep
    public int InitSdk(android.content.Context context, com.bun.supplier.IIdentifierListener iIdentifierListener) {
        com.bun.supplier.InnerIdSupplier innerIdSupplier;
        this._InnerListener = iIdentifierListener;
        com.bun.lib.b.a(context);
        com.bun.miitmdid.c.a a2 = com.bun.miitmdid.c.a.a(android.os.Build.MANUFACTURER);
        com.bun.miitmdid.c.a aVar = com.bun.miitmdid.c.a.UNSUPPORT;
        if (a2 == aVar && (a2 = com.bun.miitmdid.c.c.a.a()) == aVar) {
            return _InnerFailed(com.bun.miitmdid.core.ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT, new com.bun.supplier.DefaultSupplier());
        }
        com.bun.miitmdid.a.a a3 = com.bun.miitmdid.a.a.a(context);
        if (a3 == null) {
            return _InnerFailed(com.bun.miitmdid.core.ErrorCode.INIT_ERROR_LOAD_CONFIGFILE, new com.bun.supplier.DefaultSupplier());
        }
        this._setting = a3;
        switch (com.bun.miitmdid.core.MdidSdk.a.a[a2.ordinal()]) {
            case 1:
            case 2:
                innerIdSupplier = new com.bun.miitmdid.c.k.b(context);
                break;
            case 3:
                com.bun.miitmdid.c.j.a aVar2 = new com.bun.miitmdid.c.j.a(context);
                aVar2.a(this._setting.a());
                innerIdSupplier = aVar2;
                break;
            case 4:
                innerIdSupplier = new com.bun.miitmdid.c.d.a(context);
                break;
            case 5:
            case 6:
                innerIdSupplier = new com.bun.miitmdid.c.i.a(context);
                break;
            case 7:
            case 8:
                innerIdSupplier = new com.bun.miitmdid.c.g.b(context, this);
                break;
            case 9:
                innerIdSupplier = new com.bun.miitmdid.c.b.a(context, this);
                break;
            case 10:
                innerIdSupplier = new com.bun.miitmdid.supplier.sumsung.a(context, this);
                break;
            case 11:
                innerIdSupplier = new com.bun.miitmdid.c.f.a(context);
                break;
            case 12:
                innerIdSupplier = new com.bun.miitmdid.c.h.b(context);
                break;
            case 13:
            case 14:
            case 15:
                innerIdSupplier = new com.bun.miitmdid.supplier.msa.b(context);
                break;
            default:
                innerIdSupplier = null;
                break;
        }
        if (innerIdSupplier == null) {
            return _InnerFailed(com.bun.miitmdid.core.ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, new com.bun.supplier.DefaultSupplier());
        }
        if (!innerIdSupplier.a()) {
            innerIdSupplier.a(this);
            return com.bun.miitmdid.core.ErrorCode.INIT_ERROR_RESULT_DELAY;
        }
        if (!innerIdSupplier.isSupported()) {
            return _InnerFailed(com.bun.miitmdid.core.ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, innerIdSupplier);
        }
        OnSupport(true, innerIdSupplier);
        return 0;
    }

    @Override // com.bun.supplier.SupplierListener
    public void OnSupport(boolean z, com.bun.supplier.IdSupplier idSupplier) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        com.bun.supplier.IIdentifierListener iIdentifierListener = this._InnerListener;
        if (iIdentifierListener != null) {
            iIdentifierListener.OnSupport(z, idSupplier);
        }
        com.bun.miitmdid.b.c cVar = new com.bun.miitmdid.b.c();
        if (idSupplier != null) {
            java.lang.String oaid = idSupplier.getOAID();
            java.lang.String vaid = idSupplier.getVAID();
            java.lang.String aaid = idSupplier.getAAID();
            if (idSupplier instanceof com.bun.supplier.InnerIdSupplier) {
                ((com.bun.supplier.InnerIdSupplier) idSupplier).shutDown();
            }
            str3 = aaid;
            str2 = vaid;
            str = oaid;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        java.lang.String str4 = this._AddId;
        cVar.a(z, "", str, str2, str3, str4 == null ? "" : str4);
    }

    public void UnInitSdk() {
    }
}
