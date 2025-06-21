package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class a implements com.amap.api.mapcore.util.cg.a {
    private boolean A;
    private com.amap.api.mapcore.util.a.InterfaceC0118a D;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate b;
    private com.amap.api.maps.model.CustomMapStyleOptions c;
    private int i;
    private android.content.Context j;
    private boolean p;
    private boolean q;
    private com.amap.api.mapcore.util.cg u;
    private com.amap.api.mapcore.util.cg v;
    private final java.lang.String a = "__MACOSX";
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private byte[] k = null;
    private byte[] l = null;
    private byte[] m = null;
    private byte[] n = null;
    private byte[] o = null;
    private boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f116s = false;
    private boolean t = false;
    private byte[] w = null;
    private byte[] x = null;
    private byte[] y = null;
    private boolean z = false;
    private java.util.HashMap<java.lang.String, byte[]> B = new java.util.HashMap<>();
    private com.amap.api.maps.model.MyTrafficStyle C = new com.amap.api.maps.model.MyTrafficStyle();

    /* renamed from: com.amap.api.mapcore.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC0118a {
        void a();
    }

    public a(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate, android.content.Context context, boolean z) {
        this.i = -1;
        this.p = false;
        this.q = false;
        this.A = false;
        this.b = iAMapDelegate;
        this.j = context;
        this.p = false;
        this.q = false;
        this.A = z;
        this.i = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
    }

    private void a(com.autonavi.base.amap.mapcore.MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.B.clear();
            return;
        }
        java.lang.String styleResDataPath = this.c.getStyleResDataPath();
        if (this.c.getStyleResData() == null && !android.text.TextUtils.isEmpty(styleResDataPath)) {
            this.c.setStyleResData(com.autonavi.base.amap.mapcore.FileUtil.readFileContents(styleResDataPath));
        }
        if (this.c.getStyleResData() == null && this.y == null) {
            return;
        }
        byte[] bArr2 = this.y;
        if (bArr2 == null) {
            bArr2 = this.c.getStyleResData();
        }
        if (bArr2 != null) {
            mapConfig.setUseProFunction(true);
            this.B.clear();
            java.util.Map<java.lang.String, byte[]> uncompressToByteWithKeys = com.autonavi.base.amap.mapcore.FileUtil.uncompressToByteWithKeys(bArr2, null);
            if (uncompressToByteWithKeys != null) {
                for (java.lang.String str : uncompressToByteWithKeys.keySet()) {
                    if (str != null && !str.contains("__MACOSX") && (bArr = uncompressToByteWithKeys.get(str)) != null) {
                        if (com.autonavi.base.amap.mapcore.FileUtil.isGzip(bArr)) {
                            this.B.put(str, bArr);
                        } else {
                            this.B.put(str, com.autonavi.base.amap.mapcore.FileUtil.compress(bArr));
                        }
                    }
                }
            }
        }
    }

    private void a(java.lang.String str, boolean z) {
        boolean z2;
        int a = !android.text.TextUtils.isEmpty(str) ? com.amap.api.mapcore.util.cn.a(str) : Integer.MIN_VALUE;
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.b;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.m == null) {
            this.m = com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.j, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME + java.io.File.separator + com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
        }
        byte[] bArr = this.m;
        if (bArr != null) {
            if (!z) {
                a = 0;
            } else if (a == Integer.MIN_VALUE) {
                z2 = true;
                this.b.getGLMapEngine().setBackgroundTexture(this.i, com.amap.api.mapcore.util.dl.a((byte[]) bArr.clone(), 0, a, z2));
            }
            z2 = false;
            this.b.getGLMapEngine().setBackgroundTexture(this.i, com.amap.api.mapcore.util.dl.a((byte[]) bArr.clone(), 0, a, z2));
        }
    }

    private void a(byte[] bArr) {
        com.amap.api.mapcore.util.ck a;
        org.json.JSONObject optJSONObject;
        if (bArr == null || (a = com.amap.api.mapcore.util.cn.a(bArr)) == null || a.a() == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(a.a());
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("bg");
            java.lang.String str = null;
            boolean z = true;
            if (optJSONObject2 != null) {
                z = optJSONObject2.optBoolean("visible", true);
                str = optJSONObject2.optString("lineColor", null);
            }
            a(str, z);
            org.json.JSONObject optJSONObject3 = jSONObject.optJSONObject(com.umeng.analytics.pro.f.F);
            if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("multiFillColors")) == null) {
                return;
            }
            int a2 = com.amap.api.mapcore.util.cn.a(optJSONObject.optString("smooth"));
            int a3 = com.amap.api.mapcore.util.cn.a(optJSONObject.optString("slow"));
            int a4 = com.amap.api.mapcore.util.cn.a(optJSONObject.optString("congested"));
            int a5 = com.amap.api.mapcore.util.cn.a(optJSONObject.optString("seriousCongested"));
            this.C.setSmoothColor(a2);
            this.C.setSlowColor(a3);
            this.C.setCongestedColor(a4);
            this.C.setSeriousCongestedColor(a5);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapCustomStyleManager", "setExtraStyle");
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    private static java.lang.String b(java.lang.String str) {
        int indexOf;
        return (str == null || (indexOf = str.indexOf("99999_")) == -1) ? str : str.substring(0, indexOf).replace("99999_", "");
    }

    private static boolean b(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapCustomStyleManager", "checkData");
            com.amap.api.mapcore.util.dl.a(th);
        }
        if (bArr.length < 8) {
            return false;
        }
        return ((bArr[4] & 255) | ((((bArr[7] << com.google.common.base.Ascii.CAN) & androidx.core.view.ViewCompat.MEASURED_STATE_MASK) | ((bArr[6] << 16) & 16711680)) | ((bArr[5] << 8) & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK))) == 2001;
    }

    private static byte[] c(byte[] bArr) {
        java.util.zip.GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read < 0) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.amap.api.mapcore.util.dl.a(th);
                    th.printStackTrace();
                    return null;
                } finally {
                    com.autonavi.base.amap.mapcore.tools.GLFileUtil.closeQuietly(byteArrayOutputStream);
                    com.autonavi.base.amap.mapcore.tools.GLFileUtil.closeQuietly(byteArrayInputStream);
                    com.autonavi.base.amap.mapcore.tools.GLFileUtil.closeQuietly(gZIPInputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPInputStream = null;
        }
    }

    private void f() {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.m != null) {
            this.b.getGLMapEngine().setBackgroundTexture(this.i, this.m);
        }
        this.t = false;
    }

    private void g() {
        if (this.A) {
            if (this.l == null) {
                this.l = c(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.j, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME + java.io.File.separator + com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.l == null) {
            this.l = c(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.j, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME + java.io.File.separator + com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.b.getGLMapEngine().setCustomStyleData(this.i, this.l, this.k);
        this.f116s = false;
        this.B.clear();
    }

    private void h() {
        if (this.r) {
            if (this.n == null) {
                this.n = com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.j, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME + java.io.File.separator + com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.r = false;
            this.b.getGLMapEngine().setCustomStyleTexture(this.i, this.n);
        }
    }

    private void i() {
        com.amap.api.maps.model.CustomMapStyleOptions customMapStyleOptions = this.c;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.c.setStyleDataPath(null);
            this.c.setStyleData(null);
            this.c.setStyleTexturePath(null);
            this.c.setStyleTextureData(null);
            this.c.setStyleExtraData(null);
            this.c.setStyleExtraPath(null);
        }
    }

    public final void a() {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate;
        if (this.c == null || this.q) {
            return;
        }
        try {
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                if (mapConfig.isHideLogoEnable() && (iAMapDelegate = this.b) != null && iAMapDelegate.getUiSettings() != null) {
                    if (this.b.getUiSettings().isLogoEnable()) {
                        if (!this.c.isEnable()) {
                            this.b.getUiSettings().setLogoEnable(true);
                        } else if (this.f116s) {
                            this.b.getUiSettings().setLogoEnable(false);
                        }
                    } else if (!this.f116s) {
                        this.b.getUiSettings().setLogoEnable(true);
                    }
                }
                if (this.d) {
                    if (!this.c.isEnable()) {
                        this.b.getGLMapEngine().setNativeMapModeAndStyle(this.i, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime(), mapConfig.getMapStyleState(), false, false, null);
                        this.f116s = false;
                        if (mapConfig.isCustomStyleEnable()) {
                            if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0 && mapConfig.getMapStyleState() == 0) {
                                g();
                            }
                            h();
                            if (this.t) {
                                f();
                            }
                            mapConfig.setCustomStyleEnable(false);
                        }
                        this.d = false;
                        return;
                    }
                    this.b.getGLMapEngine().setNativeMapModeAndStyle(this.i, 0, 0, 0, false, false, null);
                    mapConfig.setCustomStyleEnable(true);
                    this.d = false;
                }
                if (this.f) {
                    java.lang.String styleTexturePath = this.c.getStyleTexturePath();
                    if (this.c.getStyleTextureData() == null && !android.text.TextUtils.isEmpty(styleTexturePath)) {
                        this.c.setStyleTextureData(com.autonavi.base.amap.mapcore.FileUtil.readFileContents(styleTexturePath));
                    }
                    if (this.c.getStyleTextureData() != null) {
                        this.z = true;
                        if (mapConfig.isProFunctionAuthEnable()) {
                            this.r = true;
                            this.b.getGLMapEngine().setCustomStyleTexture(this.i, this.c.getStyleTextureData());
                            mapConfig.setUseProFunction(true);
                        } else {
                            h();
                        }
                    } else {
                        h();
                        this.z = false;
                    }
                    this.f = false;
                }
                if (this.e) {
                    java.lang.String styleDataPath = this.c.getStyleDataPath();
                    if (this.c.getStyleData() == null && !android.text.TextUtils.isEmpty(styleDataPath)) {
                        this.c.setStyleData(com.autonavi.base.amap.mapcore.FileUtil.readFileContents(styleDataPath));
                    }
                    if (this.c.getStyleData() == null && this.w == null) {
                        if (this.f116s) {
                            this.d = true;
                            this.c.setEnable(false);
                        }
                        this.e = false;
                    }
                    if (this.o == null) {
                        this.o = c(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.j, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME + java.io.File.separator + com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE));
                    }
                    byte[] bArr = this.w;
                    if (bArr == null) {
                        bArr = this.c.getStyleData();
                    }
                    if (b(bArr)) {
                        this.b.getGLMapEngine().setCustomStyleData(this.i, bArr, this.o);
                        this.f116s = true;
                        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate2 = this.b;
                        if (iAMapDelegate2 != null) {
                            iAMapDelegate2.resetRenderTime();
                        }
                    } else {
                        com.amap.api.mapcore.util.cr.a();
                    }
                    this.e = false;
                }
                if (this.g) {
                    java.lang.String styleExtraPath = this.c.getStyleExtraPath();
                    if (this.c.getStyleExtraData() == null && !android.text.TextUtils.isEmpty(styleExtraPath)) {
                        this.c.setStyleExtraData(com.autonavi.base.amap.mapcore.FileUtil.readFileContents(styleExtraPath));
                    }
                    if (this.c.getStyleExtraData() != null || this.x != null) {
                        byte[] bArr2 = this.x;
                        if (bArr2 == null) {
                            bArr2 = this.c.getStyleExtraData();
                        }
                        if (bArr2 != null) {
                            a(bArr2);
                            this.t = true;
                        }
                    }
                    this.g = false;
                }
                if (this.h) {
                    a(mapConfig);
                    this.h = false;
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapCustomStyleManager", "updateStyle");
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    public final void a(com.amap.api.mapcore.util.a.InterfaceC0118a interfaceC0118a) {
        this.D = interfaceC0118a;
    }

    public final void a(com.amap.api.maps.model.CustomMapStyleOptions customMapStyleOptions) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate;
        if (this.c == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            if (!this.p) {
                this.p = true;
                if (this.c.isEnable()) {
                    this.d = true;
                }
            }
            if (this.c.isEnable() != customMapStyleOptions.isEnable()) {
                this.c.setEnable(customMapStyleOptions.isEnable());
                this.d = true;
                com.amap.api.mapcore.util.di.b(this.j, customMapStyleOptions.isEnable());
            }
            if (this.c.isEnable()) {
                if (!android.text.TextUtils.equals(this.c.getStyleId(), customMapStyleOptions.getStyleId())) {
                    this.c.setStyleId(customMapStyleOptions.getStyleId());
                    java.lang.String styleId = this.c.getStyleId();
                    if (!android.text.TextUtils.isEmpty(styleId) && (iAMapDelegate = this.b) != null && iAMapDelegate.getMapConfig() != null && this.b.getMapConfig().isProFunctionAuthEnable()) {
                        if (this.u == null) {
                            if (this.A) {
                                this.u = new com.amap.api.mapcore.util.cg(this.j, this, 2, "abroad_sdk_json_sdk_780_zip");
                            } else {
                                this.u = new com.amap.api.mapcore.util.cg(this.j, this, 1, "sdk_780");
                            }
                        }
                        this.u.a(styleId);
                        this.u.b();
                        if (this.v == null) {
                            this.v = new com.amap.api.mapcore.util.cg(this.j, this, 0, null);
                        }
                        this.v.a(styleId);
                        this.v.b();
                    }
                }
                if (!android.text.TextUtils.equals(this.c.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                    this.c.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                    this.e = true;
                }
                if (this.c.getStyleData() != customMapStyleOptions.getStyleData()) {
                    this.c.setStyleData(customMapStyleOptions.getStyleData());
                    this.e = true;
                }
                if (!android.text.TextUtils.equals(this.c.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                    this.c.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                    this.f = true;
                }
                if (this.c.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                    this.c.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                    this.f = true;
                }
                if (!android.text.TextUtils.equals(this.c.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                    this.c.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                    this.g = true;
                }
                if (this.c.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                    this.c.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                    this.g = true;
                }
                if (!android.text.TextUtils.equals(this.c.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                    this.c.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                    this.h = true;
                }
                if (this.c.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                    this.c.setStyleResData(customMapStyleOptions.getStyleResData());
                    this.h = true;
                }
                com.amap.api.mapcore.util.di.a(this.j, true);
            } else {
                i();
                com.amap.api.mapcore.util.di.a(this.j, false);
            }
        }
    }

    @Override // com.amap.api.mapcore.util.cg.a
    public final void a(byte[] bArr, int i) {
        b(bArr, i);
    }

    public final byte[] a(java.lang.String str) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig;
        if (str == null || (mapConfig = this.b.getMapConfig()) == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            return com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssetsByPreName(this.j, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME, b(str));
        }
        for (java.lang.String str2 : this.B.keySet()) {
            if (str.contains(str2)) {
                return this.B.get(str2);
            }
        }
        return null;
    }

    public final void b() {
        if (this.c == null) {
            return;
        }
        synchronized (this) {
            com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.b;
            if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.b.getMapConfig().isProFunctionAuthEnable()) {
                this.c.setStyleId(null);
                this.w = null;
                this.x = null;
                this.y = null;
            }
            this.f = true;
            this.e = true;
            if (this.t) {
                this.g = true;
            }
            this.d = true;
            this.h = true;
        }
    }

    @Override // com.amap.api.mapcore.util.cg.a
    public final void b(byte[] bArr, int i) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig;
        com.amap.api.mapcore.util.a.InterfaceC0118a interfaceC0118a;
        if (this.c != null) {
            synchronized (this) {
                com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.b;
                if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                    mapConfig.setUseProFunction(true);
                    if (i == 1) {
                        this.w = bArr;
                        this.e = true;
                    } else if (i == 0) {
                        this.x = bArr;
                        this.g = true;
                    } else if (i == 2) {
                        java.lang.String str = this.c.getStyleId() + "_sdk_780.data";
                        java.lang.String str2 = this.c.getStyleId() + "_abroad_sdk.json";
                        java.util.Map<java.lang.String, byte[]> uncompressToByteWithKeys = com.autonavi.base.amap.mapcore.FileUtil.uncompressToByteWithKeys(bArr, new java.lang.String[]{str, str2});
                        if (uncompressToByteWithKeys != null) {
                            byte[] bArr2 = uncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.w = bArr2;
                                this.e = true;
                            }
                            if (uncompressToByteWithKeys.get(str2) != null && (interfaceC0118a = this.D) != null) {
                                interfaceC0118a.a();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        if (this.c == null) {
            this.c = new com.amap.api.maps.model.CustomMapStyleOptions();
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    public final void e() {
        synchronized (this) {
            com.amap.api.maps.model.CustomMapStyleOptions customMapStyleOptions = this.c;
            if (customMapStyleOptions != null) {
                customMapStyleOptions.setEnable(false);
                i();
                this.d = true;
            }
        }
    }
}
