package com.anythink.pd;

/* loaded from: classes12.dex */
public class ExHandler implements com.anythink.core.api.IExHandler {
    public static final java.lang.String JSON_REQUEST_BOOT_MARK = "boot_mark";
    public static final java.lang.String JSON_REQUEST_CPU = "cpu";
    public static final java.lang.String JSON_REQUEST_IMEI = "imei";
    public static final java.lang.String JSON_REQUEST_INSTALL_TS = "install_ts";
    public static final java.lang.String JSON_REQUEST_ISAGENT = "isagent";
    public static final java.lang.String JSON_REQUEST_ISROOT = "isroot";
    public static final java.lang.String JSON_REQUEST_MAC = "mac";
    public static final java.lang.String JSON_REQUEST_OAID = "oaid";
    public static final java.lang.String JSON_REQUEST_SSID = "wifi_name";
    public static final java.lang.String JSON_REQUEST_UPDATE_MARK = "update_mark";
    public static final java.lang.String JSON_REQUEST_UPDATE_TS = "update_ts";
    int macOpen = 1;
    int imeiOpen = 1;

    @Override // com.anythink.core.api.IExHandler
    public boolean checkDebuggerDevice(android.content.Context context, java.lang.String str) {
        java.lang.String b = com.anythink.china.b.a.b();
        if (android.text.TextUtils.isEmpty(b)) {
            b = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, "oaid", "");
        }
        return android.text.TextUtils.equals(str, b);
    }

    @Override // com.anythink.core.api.IExHandler
    public int checkDownloadType(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar) {
        return com.anythink.china.common.a.a(com.anythink.core.common.b.o.a().f()).b(lVar);
    }

    @Override // com.anythink.core.api.IExHandler
    public com.anythink.core.api.ATEventInterface createDownloadListener(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.api.BaseAd baseAd, com.anythink.core.api.ATEventInterface aTEventInterface) {
        return new com.anythink.china.common.c(aTBaseAdAdapter, baseAd, aTEventInterface);
    }

    @Override // com.anythink.core.api.IExHandler
    public java.lang.String fillCDataParam(java.lang.String str) {
        if (str == null) {
            return "";
        }
        java.lang.String d = this.imeiOpen == 1 ? com.anythink.china.b.a.d(com.anythink.core.common.b.o.a().f()) : "";
        java.lang.String a = this.macOpen == 1 ? com.anythink.china.b.a.a() : "";
        java.lang.String b = com.anythink.china.b.a.b();
        if (d == null) {
            d = "";
        }
        java.lang.String replaceAll = str.replaceAll("at_device1", d);
        if (a == null) {
            a = "";
        }
        return replaceAll.replaceAll("at_device2", a).replaceAll("at_device3", b != null ? b : "");
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillRequestData(org.json.JSONObject jSONObject, com.anythink.core.d.a aVar) {
        java.lang.String N = aVar != null ? aVar.N() : "";
        if (android.text.TextUtils.isEmpty(N)) {
            try {
                jSONObject.put("mac", com.anythink.china.b.a.a());
                jSONObject.put("imei", com.anythink.china.b.a.d(com.anythink.core.common.b.o.a().f()));
                jSONObject.put("oaid", com.anythink.china.b.a.b());
                return;
            } catch (java.lang.Exception unused) {
                return;
            }
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(N);
            this.macOpen = jSONObject2.optInt(com.anythink.expressad.d.a.b.dH);
            this.imeiOpen = jSONObject2.optInt("i");
        } catch (java.lang.Exception unused2) {
        }
        try {
            jSONObject.put("mac", this.macOpen == 1 ? com.anythink.china.b.a.a() : "");
            jSONObject.put("imei", this.imeiOpen == 1 ? com.anythink.china.b.a.d(com.anythink.core.common.b.o.a().f()) : "");
            jSONObject.put("oaid", com.anythink.china.b.a.b());
        } catch (java.lang.Exception unused3) {
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillRequestDeviceData(org.json.JSONObject jSONObject, int i) {
        if ((i & 1) == 1) {
            try {
                if (!android.text.TextUtils.isEmpty(com.anythink.china.b.a.d())) {
                    jSONObject.put(JSON_REQUEST_ISROOT, java.lang.Integer.parseInt(com.anythink.china.b.a.d()));
                }
            } catch (java.lang.Throwable unused) {
            }
            try {
                if (!android.text.TextUtils.isEmpty(com.anythink.china.b.a.e())) {
                    jSONObject.put(JSON_REQUEST_ISAGENT, java.lang.Integer.parseInt(com.anythink.china.b.a.e()));
                }
            } catch (java.lang.Throwable unused2) {
            }
            try {
                jSONObject.put("wifi_name", com.anythink.china.b.a.c());
            } catch (java.lang.Throwable unused3) {
            }
            try {
                if (!android.text.TextUtils.isEmpty(com.anythink.china.b.a.f())) {
                    jSONObject.put(JSON_REQUEST_INSTALL_TS, java.lang.Long.parseLong(com.anythink.china.b.a.f()));
                }
            } catch (java.lang.Throwable unused4) {
            }
            try {
                if (!android.text.TextUtils.isEmpty(com.anythink.china.b.a.g())) {
                    jSONObject.put(JSON_REQUEST_UPDATE_TS, java.lang.Long.parseLong(com.anythink.china.b.a.g()));
                }
            } catch (java.lang.Throwable unused5) {
            }
            try {
                jSONObject.put("cpu", com.anythink.china.b.a.h());
            } catch (java.lang.Throwable unused6) {
            }
        }
        if ((i & 2) == 2) {
            try {
                jSONObject.put(JSON_REQUEST_BOOT_MARK, com.anythink.china.b.a.i());
                jSONObject.put(JSON_REQUEST_UPDATE_MARK, com.anythink.china.b.a.j());
            } catch (java.lang.Throwable unused7) {
            }
        }
        if ((i & 16) == 16) {
            try {
                java.util.List<com.anythink.core.common.f.s> k = com.anythink.china.b.a.k();
                if (k == null || k.size() <= 0) {
                    return;
                }
                for (int i2 = 0; i2 < k.size(); i2++) {
                    com.anythink.core.common.f.s sVar = k.get(i2);
                    if (sVar != null && !android.text.TextUtils.isEmpty(sVar.b())) {
                        jSONObject.put(sVar.a(), sVar.b());
                    }
                }
            } catch (java.lang.Throwable unused8) {
            }
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillTestDeviceData(org.json.JSONObject jSONObject, com.anythink.core.d.a aVar) {
        java.lang.String str = "";
        java.lang.String N = aVar != null ? aVar.N() : "";
        if (android.text.TextUtils.isEmpty(N)) {
            try {
                java.lang.String d = com.anythink.china.b.a.d(com.anythink.core.common.b.o.a().f());
                if (!android.text.TextUtils.isEmpty(d)) {
                    str = d;
                }
                jSONObject.put("IMEI", str);
                jSONObject.put("OAID", com.anythink.china.b.a.c(com.anythink.core.common.b.o.a().f()));
                return;
            } catch (java.lang.Exception unused) {
                return;
            }
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(N);
            this.macOpen = jSONObject2.optInt(com.anythink.expressad.d.a.b.dH);
            this.imeiOpen = jSONObject2.optInt("i");
        } catch (java.lang.Exception unused2) {
        }
        try {
            java.lang.String d2 = com.anythink.china.b.a.d(com.anythink.core.common.b.o.a().f());
            if (this.imeiOpen == 1 && !android.text.TextUtils.isEmpty(d2)) {
                str = d2;
            }
            jSONObject.put("IMEI", str);
            jSONObject.put("OAID", com.anythink.china.b.a.c(com.anythink.core.common.b.o.a().f()));
        } catch (java.lang.Exception unused3) {
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public java.lang.String getAid(android.content.Context context) {
        return com.anythink.china.b.a.e(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public java.lang.String getUniqueId(android.content.Context context) {
        return com.anythink.china.b.a.b(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public void handleOfferClick(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2, java.lang.Runnable runnable, com.anythink.core.common.g.b bVar) {
        com.anythink.china.common.a.a(context).a(context, mVar, lVar, str, str2, runnable, bVar);
    }

    @Override // com.anythink.core.api.IExHandler
    public void initDeviceInfo(android.content.Context context) {
        com.anythink.china.b.a.a(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public boolean onGeolocationPermissionsShowPrompt(java.lang.String str, android.webkit.GeolocationPermissions.Callback callback) {
        try {
            callback.invoke(str, true, false);
        } catch (java.lang.Throwable unused) {
        }
        return true;
    }

    @Override // com.anythink.core.api.IExHandler
    public void openApkConfirmDialog(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, com.anythink.core.common.g.a aVar) {
        com.anythink.china.activity.ApkConfirmDialogActivity.a(context, lVar, aVar);
    }
}
