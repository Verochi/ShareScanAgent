package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dl {
    private static com.autonavi.base.amap.mapcore.FPoint[] a = {com.autonavi.base.amap.mapcore.FPoint.obtain(), com.autonavi.base.amap.mapcore.FPoint.obtain(), com.autonavi.base.amap.mapcore.FPoint.obtain(), com.autonavi.base.amap.mapcore.FPoint.obtain()};
    private static java.util.List<java.lang.Float> b = new java.util.ArrayList(4);
    private static java.util.List<java.lang.Float> c = new java.util.ArrayList(4);
    private static int d = 0;

    private static double a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return ((d4 - d2) * (d7 - d3)) - ((d6 - d2) * (d5 - d3));
    }

    private static double a(float f, double d2, double d3) {
        return 20.0d - (java.lang.Math.log(d3 / (d2 * f)) / java.lang.Math.log(2.0d));
    }

    private static float a(float f, float f2, double d2) {
        return (float) (d2 / (java.lang.Math.pow(2.0d, 20.0f - f2) * f));
    }

    private static float a(float f, float f2, float f3) {
        return (float) (f3 * java.lang.Math.pow(2.0d, 20.0f - f2) * f);
    }

    public static float a(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState, int i, int i2, double d2, double d3, int i3) {
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(d2, d3, 20, obtain);
        float a2 = a(iGLMapState, i, i2, ((android.graphics.Point) obtain).x, ((android.graphics.Point) obtain).y, i3);
        obtain.recycle();
        return a2;
    }

    private static float a(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState, int i, int i2, int i3, int i4, int i5) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i, i2, i3, i4, i5);
        }
        return 3.0f;
    }

    public static float a(com.autonavi.amap.mapcore.DPoint dPoint, com.autonavi.amap.mapcore.DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d2 = dPoint.x;
        double d3 = dPoint2.x;
        return (float) ((java.lang.Math.atan2(dPoint2.y - dPoint.y, d3 - d2) / 3.141592653589793d) * 180.0d);
    }

    public static float a(com.autonavi.amap.mapcore.interfaces.IMapConfig iMapConfig, float f) {
        if (iMapConfig != null) {
            return f > iMapConfig.getMaxZoomLevel() ? iMapConfig.getMaxZoomLevel() : f < iMapConfig.getMinZoomLevel() ? iMapConfig.getMinZoomLevel() : f;
        }
        if (f > 20.0f) {
            return 20.0f;
        }
        if (f < 3.0f) {
            return 3.0f;
        }
        return f;
    }

    public static float a(com.autonavi.amap.mapcore.interfaces.IMapConfig iMapConfig, float f, float f2) {
        boolean z;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            z = iMapConfig.getAbroadState() != 1;
            r0 = isAbroadEnable;
        } else {
            z = false;
        }
        float f3 = f >= 0.0f ? f : 0.0f;
        if (r0 && z) {
            if (f3 > 40.0f) {
                return 40.0f;
            }
            return f3;
        }
        if (iMapConfig != null && iMapConfig.isTerrainEnable()) {
            if (f3 > 80.0f) {
                return 80.0f;
            }
            return f3;
        }
        if (f <= 40.0f) {
            return f3;
        }
        float f4 = f2 <= 15.0f ? 40 : f2 <= 16.0f ? 56 : f2 <= 17.0f ? 66 : f2 <= 18.0f ? 74 : f2 <= 18.0f ? 78 : 80;
        return f3 > f4 ? f4 : f3;
    }

    public static float a(com.autonavi.amap.mapcore.interfaces.IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float sz = iMapConfig.getSZ();
        if (i == i3 || i2 == i4) {
            return sz;
        }
        return java.lang.Math.max((float) a(iMapConfig.getMapZoomScale(), i5, java.lang.Math.abs(i3 - i)), (float) a(iMapConfig.getMapZoomScale(), i6, java.lang.Math.abs(i4 - i2)));
    }

    public static int a(java.lang.Object[] objArr) {
        return java.util.Arrays.hashCode(objArr);
    }

    public static android.graphics.Bitmap a(android.content.Context context, java.lang.String str) {
        try {
            java.io.InputStream open = com.amap.api.mapcore.util.df.a(context).open(str);
            android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "Util", "fromAsset");
            a(th);
            return null;
        }
    }

    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return android.graphics.Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), true);
    }

    public static android.graphics.Bitmap a(android.view.View view) {
        try {
            c(view);
            view.destroyDrawingCache();
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            android.graphics.Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap a(int[] iArr, int i, int i2) {
        return a(iArr, i, i2, false);
    }

    public static android.graphics.Bitmap a(int[] iArr, int i, int i2, boolean z) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = (i3 * i) + i4;
                    int i6 = iArr[i5];
                    int i7 = (i6 & (-16711936)) | ((i6 << 16) & 16711680) | ((i6 >> 16) & 255);
                    if (z) {
                        iArr2[(((i2 - i3) - 1) * i) + i4] = i7;
                    } else {
                        iArr2[i5] = i7;
                    }
                }
            }
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
            return createBitmap;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "Util", "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }

    public static android.util.Pair<java.lang.Float, com.autonavi.amap.mapcore.IPoint> a(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage, com.autonavi.amap.mapcore.interfaces.IMapConfig iMapConfig) {
        return a(iMapConfig, java.lang.Math.max(abstractCameraUpdateMessage.paddingLeft, 1), java.lang.Math.max(abstractCameraUpdateMessage.paddingRight, 1), java.lang.Math.max(abstractCameraUpdateMessage.paddingTop, 1), java.lang.Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static android.util.Pair<java.lang.Float, com.autonavi.amap.mapcore.IPoint> a(com.autonavi.amap.mapcore.interfaces.IMapConfig iMapConfig, int i, int i2, int i3, int i4, com.amap.api.maps.model.LatLngBounds latLngBounds, int i5, int i6) {
        com.amap.api.maps.model.LatLng latLng;
        int i7;
        float f;
        float f2;
        int i8;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        android.graphics.Point latLongToPixels = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        com.amap.api.maps.model.LatLng latLng2 = latLngBounds.southwest;
        android.graphics.Point latLongToPixels2 = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int i9 = latLongToPixels.x;
        int i10 = latLongToPixels2.x;
        int i11 = i9 - i10;
        int i12 = latLongToPixels2.y;
        int i13 = latLongToPixels.y;
        int i14 = i12 - i13;
        int i15 = i5 - (i + i2);
        int i16 = i6 - (i3 + i4);
        if (i11 < 0 && i14 < 0) {
            return null;
        }
        if (i11 <= 0) {
            i11 = 1;
        }
        int i17 = i14 <= 0 ? 1 : i14;
        if (i15 <= 0) {
            i15 = 1;
        }
        if (i16 <= 0) {
            i16 = 1;
        }
        android.util.Pair<java.lang.Float, java.lang.Boolean> b2 = b(iMapConfig, i9, i13, i10, i12, i15, i16);
        float floatValue = ((java.lang.Float) b2.first).floatValue();
        boolean booleanValue = ((java.lang.Boolean) b2.second).booleanValue();
        float a2 = a(iMapConfig.getMapZoomScale(), floatValue, i11);
        float a3 = a(iMapConfig.getMapZoomScale(), floatValue, i17);
        if (floatValue >= iMapConfig.getMaxZoomLevel()) {
            i7 = (int) (latLongToPixels2.x + ((((i2 - i) + a2) * i11) / (a2 * 2.0f)));
            i8 = latLongToPixels.y;
        } else {
            if (!booleanValue) {
                i7 = (int) (latLongToPixels2.x + ((((i2 - i) + a2) * i11) / (a2 * 2.0f)));
                f = latLongToPixels.y;
                f2 = (((i6 / 2) - i3) / a3) * i17;
                return new android.util.Pair<>(java.lang.Float.valueOf(floatValue), com.autonavi.amap.mapcore.IPoint.obtain((int) (i7 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f + f2)) + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
            }
            i7 = (int) (latLongToPixels2.x + ((((i5 / 2) - i) / a2) * i11));
            i8 = latLongToPixels.y;
        }
        f = i8;
        f2 = (((i4 - i3) + a3) * i17) / (a3 * 2.0f);
        return new android.util.Pair<>(java.lang.Float.valueOf(floatValue), com.autonavi.amap.mapcore.IPoint.obtain((int) (i7 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f + f2)) + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
    }

    public static com.amap.api.mapcore.util.fh a() {
        try {
            if (com.amap.api.mapcore.util.l.e == null) {
                com.amap.api.mapcore.util.l.e = new com.amap.api.mapcore.util.fh.a("3dmap", "9.1.0", com.amap.api.mapcore.util.l.c).a(new java.lang.String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("9.1.0").a();
            }
            return com.amap.api.mapcore.util.l.e;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static com.autonavi.amap.mapcore.DPoint a(com.amap.api.maps.model.LatLng latLng) {
        double d2 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = java.lang.Math.sin(java.lang.Math.toRadians(latLng.latitude));
        return com.autonavi.amap.mapcore.DPoint.obtain(d2 * 1.0d, (((java.lang.Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static java.lang.String a(int i) {
        if (i < 1000) {
            return i + com.anythink.expressad.d.a.b.dH;
        }
        return (i / 1000) + "km";
    }

    public static java.lang.String a(android.content.Context context) {
        java.io.File file = new java.io.File(com.autonavi.base.amap.mapcore.FileUtil.getMapBaseStorage(context), com.autonavi.base.amap.mapcore.AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(file.toString());
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        java.io.File file2 = new java.io.File(sb.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e4 A[Catch: IOException -> 0x00d2, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x00d2, blocks: (B:83:0x00e4, B:93:0x00ce), top: B:80:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.io.File file) {
        ?? r7;
        java.io.FileInputStream fileInputStream;
        java.io.IOException e;
        java.io.BufferedReader bufferedReader;
        java.io.FileNotFoundException e2;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.io.FileInputStream fileInputStream2 = null;
        try {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            try {
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream, "utf-8"));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuffer.append(readLine);
                            } else {
                                try {
                                    try {
                                        break;
                                    } catch (java.io.IOException e3) {
                                        e3.printStackTrace();
                                        bufferedReader.close();
                                    }
                                } finally {
                                    try {
                                        bufferedReader.close();
                                    } catch (java.io.IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                        } catch (java.io.FileNotFoundException e5) {
                            e2 = e5;
                            com.amap.api.mapcore.util.gd.c(e2, "Util", "readFile fileNotFound");
                            e2.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException e6) {
                                        e6.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    }
                                } finally {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        } catch (java.io.IOException e7) {
                            e = e7;
                            com.amap.api.mapcore.util.gd.c(e, "Util", "readFile io");
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException e8) {
                                        e8.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    }
                                } finally {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return stringBuffer.toString();
                        }
                    }
                    fileInputStream.close();
                    bufferedReader.close();
                } catch (java.io.FileNotFoundException e9) {
                    e2 = e9;
                    bufferedReader = null;
                } catch (java.io.IOException e10) {
                    e = e10;
                    bufferedReader = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    file = null;
                    fileInputStream2 = fileInputStream;
                    r7 = file;
                    try {
                        try {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (java.io.IOException e11) {
                                    e11.printStackTrace();
                                    if (r7 != 0) {
                                        r7.close();
                                    }
                                    throw th;
                                }
                            }
                            if (r7 != 0) {
                                r7.close();
                            }
                        } catch (java.lang.Throwable th3) {
                            if (r7 != 0) {
                                try {
                                    r7.close();
                                } catch (java.io.IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    } catch (java.io.IOException e13) {
                        e13.printStackTrace();
                    }
                    throw th;
                }
            } catch (java.io.IOException e14) {
                e14.printStackTrace();
            }
        } catch (java.io.FileNotFoundException e15) {
            fileInputStream = null;
            e2 = e15;
            bufferedReader = null;
        } catch (java.io.IOException e16) {
            fileInputStream = null;
            e = e16;
            bufferedReader = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            r7 = 0;
            if (fileInputStream2 != null) {
            }
            if (r7 != 0) {
            }
            throw th;
        }
        return stringBuffer.toString();
    }

    public static java.lang.String a(java.io.InputStream inputStream) {
        try {
            return new java.lang.String(b(inputStream), "utf-8");
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            if (parse.getAuthority() != null && parse.getAuthority().startsWith("dualstack-")) {
                return str;
            }
            if (parse.getAuthority() != null && parse.getAuthority().startsWith("restsdk.amap.com")) {
                return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
            }
            return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
        } catch (java.lang.Throwable unused) {
            return str;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.Object obj) {
        return str + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + java.lang.String.valueOf(obj);
    }

    public static java.lang.String a(java.lang.String... strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        for (java.lang.String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public static void a(android.graphics.Bitmap bitmap) {
    }

    public static void a(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static void a(java.lang.Throwable th) {
        try {
            if (com.amap.api.maps.MapsInitializer.getExceptionLogger() != null) {
                com.amap.api.maps.MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean a(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d4 - d2;
        double d10 = d8 - d7;
        double d11 = d5 - d3;
        double d12 = 180.0d - d6;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d3 - d7;
            double d15 = d2 - d6;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            if (d16 >= 0.0d && d16 <= 1.0d && d17 >= 0.0d && d17 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(double d2, com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) com.amap.api.maps.AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d2 - circleHoleOptions.getRadius();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private static boolean a(double d2, com.amap.api.maps.model.LatLng latLng, java.util.List<com.amap.api.maps.model.BaseHoleOptions> list, com.amap.api.maps.model.LatLng latLng2) throws android.os.RemoteException {
        if (list != null && list.size() > 0) {
            java.util.Iterator<com.amap.api.maps.model.BaseHoleOptions> it = list.iterator();
            while (it.hasNext()) {
                if (a(it.next(), latLng2)) {
                    return false;
                }
            }
        }
        return d2 >= ((double) com.amap.api.maps.AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    public static boolean a(double d2, com.amap.api.maps.model.LatLng latLng, java.util.List<com.amap.api.maps.model.BaseHoleOptions> list, com.amap.api.maps.model.PolygonHoleOptions polygonHoleOptions) {
        boolean z = true;
        try {
            java.util.List<com.amap.api.maps.model.LatLng> points = polygonHoleOptions.getPoints();
            for (int i = 0; i < points.size() && (z = a(d2, latLng, list, points.get(i))); i++) {
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z;
    }

    public static boolean a(int i, int i2) {
        return i > 0 && i2 > 0;
    }

    public static boolean a(android.graphics.Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public static boolean a(com.amap.api.maps.model.BaseHoleOptions baseHoleOptions, com.amap.api.maps.model.LatLng latLng) {
        if (baseHoleOptions instanceof com.amap.api.maps.model.CircleHoleOptions) {
            com.amap.api.maps.model.CircleHoleOptions circleHoleOptions = (com.amap.api.maps.model.CircleHoleOptions) baseHoleOptions;
            com.amap.api.maps.model.LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) com.amap.api.maps.AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        java.util.List<com.amap.api.maps.model.LatLng> points = ((com.amap.api.maps.model.PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return a(latLng, points);
    }

    private static boolean a(com.amap.api.maps.model.CircleHoleOptions circleHoleOptions, com.amap.api.maps.model.CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) com.amap.api.maps.AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(com.amap.api.maps.model.LatLng latLng, java.util.List<com.amap.api.maps.model.LatLng> list) {
        boolean z;
        if (latLng == null || list == null) {
            return false;
        }
        double d2 = latLng.longitude;
        double d3 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z = false;
        } else {
            list.add(list.get(0));
            z = true;
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            try {
                double d4 = list.get(i).longitude;
                double d5 = list.get(i).latitude;
                i++;
                double d6 = list.get(i).longitude;
                double d7 = list.get(i).latitude;
                double d8 = d3;
                double d9 = d2;
                if (b(d2, d3, d4, d5, d6, d7)) {
                    return true;
                }
                if (java.lang.Math.abs(d7 - d5) >= 1.0E-9d) {
                    if (b(d4, d5, d9, d8, 180.0d, d8)) {
                        if (d5 <= d7) {
                        }
                        i2++;
                    } else if (b(d6, d7, d9, d8, 180.0d, d8)) {
                        if (d7 > d5) {
                            i2++;
                        }
                    } else if (a(d4, d5, d6, d7, d9, d8, d8)) {
                        i2++;
                    }
                }
                d3 = d8;
                d2 = d9;
            } finally {
                if (z) {
                    list.remove(list.size() - 1);
                }
            }
        }
        boolean z2 = i2 % 2 != 0;
        if (z) {
            list.remove(list.size() - 1);
        }
        return z2;
    }

    public static boolean a(java.util.List<com.amap.api.maps.model.BaseHoleOptions> list, com.amap.api.maps.model.CircleHoleOptions circleHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            com.amap.api.maps.model.BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof com.amap.api.maps.model.PolygonHoleOptions) {
                z = b(((com.amap.api.maps.model.PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof com.amap.api.maps.model.CircleHoleOptions) && (z = a(circleHoleOptions, (com.amap.api.maps.model.CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z;
    }

    public static boolean a(java.util.List<com.amap.api.maps.model.BaseHoleOptions> list, com.amap.api.maps.model.PolygonHoleOptions polygonHoleOptions) {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            com.amap.api.maps.model.BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof com.amap.api.maps.model.PolygonHoleOptions) {
                z = a(((com.amap.api.maps.model.PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z) {
                    return true;
                }
            } else if (baseHoleOptions instanceof com.amap.api.maps.model.CircleHoleOptions) {
                z = b(polygonHoleOptions.getPoints(), (com.amap.api.maps.model.CircleHoleOptions) baseHoleOptions);
                if (z) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z;
    }

    private static boolean a(java.util.List<com.amap.api.maps.model.LatLng> list, java.util.List<com.amap.api.maps.model.LatLng> list2) {
        for (int i = 0; i < list2.size(); i++) {
            try {
                if (a(list2.get(i), list)) {
                    return true;
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (a(list.get(i2), list2)) {
                return true;
            }
        }
        return b(list, list2);
    }

    public static boolean a(java.util.List<com.amap.api.maps.model.LatLng> list, java.util.List<com.amap.api.maps.model.BaseHoleOptions> list2, com.amap.api.maps.model.CircleHoleOptions circleHoleOptions) {
        try {
            if (b(list, circleHoleOptions)) {
                return false;
            }
            return a(list, list2, circleHoleOptions.getCenter());
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private static boolean a(java.util.List<com.amap.api.maps.model.LatLng> list, java.util.List<com.amap.api.maps.model.BaseHoleOptions> list2, com.amap.api.maps.model.LatLng latLng) throws android.os.RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    java.util.Iterator<com.amap.api.maps.model.BaseHoleOptions> it = list2.iterator();
                    while (it.hasNext()) {
                        if (a(it.next(), latLng)) {
                            return false;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return a(latLng, list);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, i, i, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        r2.setPixel(r5, r6, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, int i, int i2, boolean z) {
        try {
            android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            android.graphics.Bitmap copy = decodeByteArray.copy(decodeByteArray.getConfig(), true);
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int i3 = 0;
            while (i3 < width) {
                int i4 = 0;
                while (i4 < height) {
                    if (i3 != 0 && i4 != 0) {
                        copy.setPixel(i3, i4, i);
                        i4++;
                    }
                    i4++;
                }
                i3++;
            }
            byte[] b2 = b(copy);
            if (b2 == null) {
                b2 = bArr;
            }
            a(copy);
            a(decodeByteArray);
            return b2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static synchronized int[] a(int i, int i2, int i3, int i4, com.autonavi.amap.mapcore.interfaces.IMapConfig iMapConfig, com.autonavi.amap.api.mapcore.IGLMapState iGLMapState, int i5, int i6) {
        int[] iArr;
        synchronized (com.amap.api.mapcore.util.dl.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            iArr = new int[]{(int) java.lang.Math.max(i3 + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), iMapConfig.getAnchorX()), java.lang.Math.min(i5, i - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - r3))), (int) java.lang.Math.max(i2 + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), iMapConfig.getAnchorY()), java.lang.Math.min(i6, i4 - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - r4)))};
        }
        return iArr;
    }

    public static synchronized int b() {
        int i;
        synchronized (com.amap.api.mapcore.util.dl.class) {
            int i2 = d + 1;
            d = i2;
            if (i2 == Integer.MAX_VALUE) {
                d = 0;
            }
            i = d;
        }
        return i;
    }

    private static android.util.Pair<java.lang.Float, java.lang.Boolean> b(com.autonavi.amap.mapcore.interfaces.IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float min;
        iMapConfig.getSZ();
        if (i == i3 && i2 == i4) {
            min = iMapConfig.getMaxZoomLevel();
        } else {
            float a2 = (float) a(iMapConfig.getMapZoomScale(), i6, java.lang.Math.abs(i4 - i2));
            float a3 = (float) a(iMapConfig.getMapZoomScale(), i5, java.lang.Math.abs(i3 - i));
            float min2 = java.lang.Math.min(a3, a2);
            r0 = min2 == a3;
            min = java.lang.Math.min(iMapConfig.getMaxZoomLevel(), java.lang.Math.max(iMapConfig.getMinZoomLevel(), min2));
        }
        return new android.util.Pair<>(java.lang.Float.valueOf(min), java.lang.Boolean.valueOf(r0));
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.autonavi.base.amap.mapcore.FileUtil.getMapBaseStorage(context));
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append("data");
        sb.append(str);
        return sb.toString();
    }

    public static java.lang.String b(android.view.View view) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (view != null) {
            try {
                if (view instanceof android.widget.TextView) {
                    sb = new java.lang.StringBuilder(((android.widget.TextView) view).getText().toString());
                }
                if (view instanceof android.view.ViewGroup) {
                    int childCount = ((android.view.ViewGroup) view).getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        java.lang.String b2 = b(((android.view.ViewGroup) view).getChildAt(i));
                        if (!android.text.TextUtils.isEmpty(b2)) {
                            sb.append("--");
                            sb.append(b2);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static boolean b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return java.lang.Math.abs(a(d2, d3, d4, d5, d6, d7)) < 1.0E-9d && (d2 - d4) * (d2 - d6) <= 0.0d && (d3 - d5) * (d3 - d7) <= 0.0d;
    }

    private static boolean b(java.util.List<com.amap.api.maps.model.LatLng> list, com.amap.api.maps.model.CircleHoleOptions circleHoleOptions) {
        int i;
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(list.get(i2));
            }
            arrayList.add(list.get(0));
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int i3 = 0;
            while (i3 < arrayList.size() && (i = i3 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < com.amap.api.maps.AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (com.amap.api.maps.model.LatLng) arrayList.get(i3)) && circleHoleOptions.getRadius() < com.amap.api.maps.AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (com.amap.api.maps.model.LatLng) arrayList.get(i))) {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i3));
                    arrayList2.add(arrayList.get(i));
                    if (circleHoleOptions.getRadius() >= ((double) com.amap.api.maps.AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (com.amap.api.maps.model.LatLng) com.amap.api.maps.utils.SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                        return true;
                    }
                    i3 = i;
                }
                return true;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(java.util.List<com.amap.api.maps.model.LatLng> list, com.amap.api.maps.model.PolygonHoleOptions polygonHoleOptions) {
        int i = 0;
        if (list == null || polygonHoleOptions == null) {
            return false;
        }
        try {
            java.util.List<com.amap.api.maps.model.LatLng> points = polygonHoleOptions.getPoints();
            boolean z = 0;
            while (i < points.size()) {
                try {
                    boolean a2 = a(points.get(i), list);
                    if (!a2) {
                        return a2;
                    }
                    i++;
                    z = a2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    i = z;
                    com.amap.api.mapcore.util.gd.c(th, "PolygonDelegateImp", "isPolygonInPolygon");
                    th.printStackTrace();
                    return i;
                }
            }
            return z;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static boolean b(java.util.List<com.amap.api.maps.model.LatLng> list, java.util.List<com.amap.api.maps.model.LatLng> list2) {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < list.size() && (i = i3 + 1) < list.size()) {
            try {
                int i4 = 0;
                while (i4 < list2.size() && (i2 = i4 + 1) < list2.size()) {
                    boolean a2 = com.amap.api.mapcore.util.dg.a(list.get(i3), list.get(i), list2.get(i4), list2.get(i2));
                    if (a2) {
                        return a2;
                    }
                    i4 = i2;
                }
                i3 = i;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    private static byte[] b(android.graphics.Bitmap bitmap) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        } catch (java.lang.Throwable unused) {
            byteArrayOutputStream = null;
        }
        try {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            return byteArray;
        } catch (java.lang.Throwable unused2) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            }
            return null;
        }
    }

    private static byte[] b(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String a2 = a(context);
        if (a2 == null) {
            return null;
        }
        java.io.File file = new java.io.File(a2, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + java.io.File.separator;
    }

    private static void c(android.view.View view) {
        int i = 0;
        if (!(view instanceof android.view.ViewGroup)) {
            if (view instanceof android.widget.TextView) {
                ((android.widget.TextView) view).setHorizontallyScrolling(false);
            }
        } else {
            while (true) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return;
                }
                c(viewGroup.getChildAt(i));
                i++;
            }
        }
    }

    public static boolean d(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        android.net.NetworkInfo.State state;
        return (context == null || (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == android.net.NetworkInfo.State.DISCONNECTED || state == android.net.NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    public static boolean e(android.content.Context context) {
        java.io.File file = new java.io.File(b(context));
        if (file.exists()) {
            return com.autonavi.base.amap.mapcore.FileUtil.deleteFile(file);
        }
        return true;
    }
}
