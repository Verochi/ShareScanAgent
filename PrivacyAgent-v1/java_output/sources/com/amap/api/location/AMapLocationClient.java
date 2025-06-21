package com.amap.api.location;

/* loaded from: classes12.dex */
public class AMapLocationClient {
    android.content.Context a;
    com.loc.d b;

    public AMapLocationClient(android.content.Context context) throws java.lang.Exception {
        a(context);
        try {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("Context参数不能为null");
            }
            android.content.Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            com.loc.fx.a(applicationContext);
            this.b = new com.loc.d(context, null, null);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "ne1");
        }
    }

    public AMapLocationClient(android.content.Context context, android.content.Intent intent) throws java.lang.Exception {
        a(context);
        try {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            this.b = new com.loc.d(this.a, intent, null);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(android.os.Looper looper, android.content.Context context) throws java.lang.Exception {
        a(context);
        try {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            this.b = new com.loc.d(this.a, null, looper);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "ne3");
        }
    }

    private static void a(android.content.Context context) throws java.lang.Exception {
        com.loc.v a = com.loc.u.a(context, com.loc.fv.c());
        if (a.a != com.loc.u.c.SuccessCode) {
            throw new java.lang.Exception(a.b);
        }
    }

    public static java.lang.String getDeviceId(android.content.Context context) {
        return com.loc.p.q(context);
    }

    public static void setApiKey(java.lang.String str) {
        try {
            com.amap.api.location.AMapLocationClientOption.a = str;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "sKey");
        }
    }

    public static void setHost(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.loc.bp.a = -1;
            str = "";
        } else {
            com.loc.bp.a = 1;
        }
        com.loc.bp.b = str;
    }

    public static void updatePrivacyAgree(android.content.Context context, boolean z) {
        com.loc.u.a(context, z, com.loc.fv.c());
    }

    public static void updatePrivacyShow(android.content.Context context, boolean z, boolean z2) {
        com.loc.u.a(context, z, z2, com.loc.fv.c());
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.a(z);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i, android.app.Notification notification) {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.a(i, notification);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "eBackL");
        }
    }

    public com.amap.api.location.AMapLocation getLastKnownLocation() {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                return dVar.e();
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "gLastL");
            return null;
        }
    }

    public java.lang.String getVersion() {
        return "6.4.5";
    }

    public boolean isStarted() {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                return dVar.a();
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.d();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(com.amap.api.location.AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener == null) {
                throw new java.lang.IllegalArgumentException("listener参数不能为null");
            }
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.a(aMapLocationListener);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption == null) {
                throw new java.lang.IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption.b) {
                aMapLocationClientOption.b = false;
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (!android.text.TextUtils.isEmpty(aMapLocationClientOption.c)) {
                    jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.c);
                }
                com.loc.gb.a(this.a, "O019", jSONObject);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "sLocnO");
        }
    }

    public void startAssistantLocation(android.webkit.WebView webView) {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.a(webView);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.b();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.f();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.c();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(com.amap.api.location.AMapLocationListener aMapLocationListener) {
        try {
            com.loc.d dVar = this.b;
            if (dVar != null) {
                dVar.b(aMapLocationListener);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMClt", "unRL");
        }
    }
}
