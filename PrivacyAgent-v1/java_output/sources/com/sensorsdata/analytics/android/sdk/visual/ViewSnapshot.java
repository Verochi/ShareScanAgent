package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class ViewSnapshot {
    private static final int JS_NOT_INTEGRATED_ALERT_TIME_OUT = 5000;
    private static final int MAX_CLASS_NAME_CACHE_SIZE = 255;
    private static final java.lang.String TAG = "SA.ViewSnapshot";
    private final android.os.Handler mMainThreadHandler;
    private final java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription> mProperties;
    private final com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds mResourceIds;
    private com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo mSnapInfo = new com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo();
    private final com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewFinder mRootViewFinder = new com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewFinder();
    private final com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.ClassNameCache mClassnameCache = new com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.ClassNameCache(255);

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.CountDownLatch val$latch;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view, java.util.concurrent.CountDownLatch countDownLatch) {
            this.val$view = view;
            this.val$latch = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(this.val$view, "getUrl", new java.lang.Object[0]);
            if (android.text.TextUtils.isEmpty(str)) {
                this.val$latch.countDown();
                return;
            }
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.this.mSnapInfo.webViewUrl = str;
            java.lang.Float f = (java.lang.Float) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(this.val$view, "getScale", new java.lang.Object[0]);
            if (f != null) {
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.this.mSnapInfo.webViewScale = f.floatValue();
            }
            this.val$latch.countDown();
            com.sensorsdata.analytics.android.sdk.util.WebUtils.loadUrl(this.val$view, "javascript:window.sensorsdata_app_call_js('visualized')");
        }
    }

    public static class CachedBitmap {
        private java.lang.String mImageHash = "";
        private final android.graphics.Paint mPaint = new android.graphics.Paint(2);
        private android.graphics.Bitmap mCached = null;

        private static byte[] concat(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            java.lang.System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String getImageHash() {
            return this.mImageHash;
        }

        private java.lang.String toHex(byte[] bArr) {
            java.lang.String str = "";
            for (int i = 0; i < bArr.length; i++) {
                str = (str + "0123456789ABCDEF".charAt((bArr[i] >> 4) & 15)) + "0123456789ABCDEF".charAt(bArr[i] & 15);
            }
            return str;
        }

        public synchronized void recreate(int i, int i2, int i3, android.graphics.Bitmap bitmap) {
            byte[] bytes;
            byte[] bytes2;
            byte[] bytes3;
            android.graphics.Bitmap bitmap2 = this.mCached;
            if (bitmap2 == null || bitmap2.getWidth() != i || this.mCached.getHeight() != i2) {
                try {
                    this.mCached = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.RGB_565);
                } catch (java.lang.Throwable unused) {
                    this.mCached = null;
                }
                android.graphics.Bitmap bitmap3 = this.mCached;
                if (bitmap3 != null) {
                    bitmap3.setDensity(i3);
                }
            }
            if (this.mCached != null) {
                new android.graphics.Canvas(this.mCached).drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
                try {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    this.mCached.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    java.lang.String lastThirdMsg = com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().getLastThirdMsg();
                    if (!android.text.TextUtils.isEmpty(lastThirdMsg) && (bytes3 = lastThirdMsg.getBytes()) != null && bytes3.length > 0) {
                        byteArray = concat(byteArray, bytes3);
                    }
                    java.lang.String lastThirdMsg2 = com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().getLastThirdMsg();
                    if (!android.text.TextUtils.isEmpty(lastThirdMsg2) && (bytes2 = lastThirdMsg2.getBytes()) != null && bytes2.length > 0) {
                        byteArray = concat(byteArray, bytes2);
                    }
                    java.lang.String lastDebugInfo = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().getLastDebugInfo();
                    if (!android.text.TextUtils.isEmpty(lastDebugInfo) && (bytes = lastDebugInfo.getBytes()) != null && bytes.length > 0) {
                        byteArray = concat(byteArray, bytes);
                    }
                    this.mImageHash = toHex(java.security.MessageDigest.getInstance("MD5").digest(byteArray));
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.TAG, "CachedBitmap.recreate;Create image_hash error=" + e);
                }
            }
        }

        public synchronized void writeBitmapJSON(android.graphics.Bitmap.CompressFormat compressFormat, int i, java.io.OutputStream outputStream) throws java.io.IOException {
            android.graphics.Bitmap bitmap = this.mCached;
            if (bitmap != null && bitmap.getWidth() != 0 && this.mCached.getHeight() != 0) {
                outputStream.write(34);
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                this.mCached.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                outputStream.write(new java.lang.String(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(byteArrayOutputStream.toByteArray())).getBytes());
                outputStream.write(34);
            }
            outputStream.write(com.igexin.push.core.b.m.getBytes());
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static class ClassNameCache extends android.util.LruCache<java.lang.Class<?>, java.lang.String> {
        public ClassNameCache(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        public java.lang.String create(java.lang.Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    public static class RootViewFinder implements java.util.concurrent.Callable<java.util.List<com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo>> {
        private final int mClientDensity = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
        private final java.util.List<com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo> mRootViews = new java.util.ArrayList();
        private final com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.CachedBitmap mCachedBitmap = new com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.CachedBitmap();

        private static android.graphics.Bitmap getFlutterBitmap(android.app.Activity activity) {
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("io.flutter.embedding.android.FlutterActivity").getDeclaredMethod("getFlutterEngine", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                java.lang.Object invoke = declaredMethod.invoke(activity, new java.lang.Object[0]);
                java.lang.reflect.Method method = java.lang.Class.forName("io.flutter.embedding.engine.FlutterEngine").getMethod("getRenderer", new java.lang.Class[0]);
                method.setAccessible(true);
                java.lang.Object invoke2 = method.invoke(invoke, new java.lang.Object[0]);
                java.lang.reflect.Method method2 = java.lang.Class.forName("io.flutter.embedding.engine.renderer.FlutterRenderer").getMethod("getBitmap", new java.lang.Class[0]);
                method2.setAccessible(true);
                return (android.graphics.Bitmap) method2.invoke(invoke2, new java.lang.Object[0]);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }

        private void scaleBitmap(com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo rootViewInfo, android.graphics.Bitmap bitmap) {
            if (bitmap != null) {
                int density = bitmap.getDensity();
                r0 = density != 0 ? 160.0f / density : 1.0f;
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = (int) ((bitmap.getWidth() * r0) + 0.5d);
                int height2 = (int) ((bitmap.getHeight() * r0) + 0.5d);
                if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                    this.mCachedBitmap.recreate(width2, height2, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, bitmap);
                }
            }
            rootViewInfo.scale = r0;
            rootViewInfo.screenshot = this.mCachedBitmap;
        }

        @Override // java.util.concurrent.Callable
        public java.util.List<com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo> call() throws java.lang.Exception {
            com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo flutterNodeInfo;
            this.mRootViews.clear();
            try {
                android.app.Activity foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
                if (foregroundActivity != null) {
                    org.json.JSONObject activityPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getActivityPageInfo(foregroundActivity);
                    org.json.JSONObject rNPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getRNPageInfo();
                    if (activityPageInfo == null) {
                        activityPageInfo = new org.json.JSONObject();
                    }
                    com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeDuplicateProperty(rNPageInfo, activityPageInfo);
                    java.lang.String optString = activityPageInfo.optString("$screen_name");
                    java.lang.String optString2 = activityPageInfo.optString("$title");
                    boolean instanceOfFlutterActivity = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfFlutterActivity(foregroundActivity);
                    if (instanceOfFlutterActivity && (flutterNodeInfo = (com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo) com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().getPageInfo(com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(foregroundActivity.getClass()))) != null) {
                        java.lang.String screen_name = flutterNodeInfo.getScreen_name();
                        java.lang.String title = flutterNodeInfo.getTitle();
                        if (!android.text.TextUtils.isEmpty(optString)) {
                            optString = screen_name;
                        }
                        if (!android.text.TextUtils.isEmpty(title)) {
                            optString2 = title;
                        }
                    }
                    android.view.Window window = foregroundActivity.getWindow();
                    android.view.View rootView = (window == null || !window.isActive()) ? null : window.getDecorView().getRootView();
                    if (rootView == null) {
                        return this.mRootViews;
                    }
                    com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo rootViewInfo = new com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo(optString, optString2, rootView);
                    android.view.View[] sortedWindowViews = com.sensorsdata.analytics.android.sdk.util.WindowHelper.getSortedWindowViews();
                    if (instanceOfFlutterActivity) {
                        scaleBitmap(rootViewInfo, getFlutterBitmap(foregroundActivity));
                        this.mRootViews.add(rootViewInfo);
                    } else if (sortedWindowViews != null && sortedWindowViews.length > 0) {
                        android.graphics.Bitmap mergeViewLayers = mergeViewLayers(sortedWindowViews, rootViewInfo);
                        for (android.view.View view : sortedWindowViews) {
                            if (view.getWindowVisibility() == 0 && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && !android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.util.WindowHelper.getWindowPrefix(view), com.sensorsdata.analytics.android.sdk.util.WindowHelper.getMainWindowPrefix()) && !com.sensorsdata.analytics.android.sdk.util.WindowHelper.isCustomWindow(view)) {
                                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo rootViewInfo2 = new com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo(optString, optString2, view.getRootView());
                                scaleBitmap(rootViewInfo2, mergeViewLayers);
                                this.mRootViews.add(rootViewInfo2);
                            }
                        }
                        if (this.mRootViews.size() == 0) {
                            scaleBitmap(rootViewInfo, mergeViewLayers);
                            this.mRootViews.add(rootViewInfo);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.d(com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.TAG, "" + th);
            }
            return this.mRootViews;
        }

        public android.graphics.Bitmap mergeViewLayers(android.view.View[] viewArr, com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo rootViewInfo) {
            int width = rootViewInfo.rootView.getWidth();
            int height = rootViewInfo.rootView.getHeight();
            if (width == 0 || height == 0) {
                int[] deviceSize = com.sensorsdata.analytics.android.sdk.util.DeviceUtils.getDeviceSize(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext());
                width = deviceSize[0];
                height = deviceSize[1];
                if (width == 0 || height == 0) {
                    return null;
                }
            }
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
            com.sensorsdata.analytics.android.sdk.visual.snap.SoftWareCanvas softWareCanvas = new com.sensorsdata.analytics.android.sdk.visual.snap.SoftWareCanvas(createBitmap);
            int[] iArr = new int[2];
            boolean z = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getMainWindowCount(viewArr) > 1;
            com.sensorsdata.analytics.android.sdk.util.WindowHelper.init();
            com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.invalidateLayerTypeView(viewArr);
            boolean z2 = false;
            for (android.view.View view : viewArr) {
                if (view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.isWindowNeedTraverse(view, com.sensorsdata.analytics.android.sdk.util.WindowHelper.getWindowPrefix(view), z)) {
                    softWareCanvas.save();
                    if (!com.sensorsdata.analytics.android.sdk.util.WindowHelper.isMainWindow(view)) {
                        view.getLocationOnScreen(iArr);
                        softWareCanvas.translate(iArr[0], iArr[1]);
                        if (com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDialogOrPopupWindow(view) && !z2) {
                            android.graphics.Paint paint = new android.graphics.Paint();
                            paint.setColor(-1610612736);
                            softWareCanvas.drawRect(-iArr[0], -iArr[1], softWareCanvas.getWidth(), softWareCanvas.getHeight(), paint);
                            z2 = true;
                        }
                    }
                    view.draw(softWareCanvas);
                    softWareCanvas.restoreToCount(1);
                }
            }
            softWareCanvas.destroy();
            return createBitmap;
        }
    }

    public static class RootViewInfo {
        final java.lang.String activityTitle;
        final android.view.View rootView;
        final java.lang.String screenName;
        com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.CachedBitmap screenshot = null;
        float scale = 1.0f;

        public RootViewInfo(java.lang.String str, java.lang.String str2, android.view.View view) {
            this.screenName = str;
            this.activityTitle = str2;
            this.rootView = view;
        }
    }

    public ViewSnapshot(java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription> list, com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds resourceIds, android.os.Handler handler) {
        this.mProperties = list;
        this.mResourceIds = resourceIds;
        this.mMainThreadHandler = handler;
    }

    private void addProperties(org.json.JSONObject jSONObject, android.view.View view) throws java.lang.Exception {
        com.sensorsdata.analytics.android.sdk.visual.snap.Caller caller;
        java.lang.Object applyMethod;
        jSONObject.put("importantForAccessibility", true);
        java.lang.Class<?> cls = view.getClass();
        for (com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription propertyDescription : this.mProperties) {
            if (propertyDescription.targetClass.isAssignableFrom(cls) && (caller = propertyDescription.accessor) != null && (applyMethod = caller.applyMethod(view)) != null) {
                if (applyMethod instanceof java.lang.Number) {
                    jSONObject.put(propertyDescription.name, applyMethod);
                } else if (applyMethod instanceof java.lang.Boolean) {
                    boolean booleanValue = ((java.lang.Boolean) applyMethod).booleanValue();
                    if ("clickable".equals(propertyDescription.name)) {
                        if (com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil.isSupportClick(view)) {
                            booleanValue = true;
                        } else if (com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil.isForbiddenClick(view)) {
                            booleanValue = false;
                        }
                    }
                    jSONObject.put(propertyDescription.name, booleanValue);
                } else if (applyMethod instanceof android.content.res.ColorStateList) {
                    jSONObject.put(propertyDescription.name, java.lang.Integer.valueOf(((android.content.res.ColorStateList) applyMethod).getDefaultColor()));
                } else if (applyMethod instanceof android.graphics.drawable.Drawable) {
                    android.graphics.drawable.Drawable drawable = (android.graphics.drawable.Drawable) applyMethod;
                    android.graphics.Rect bounds = drawable.getBounds();
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    for (java.lang.Class<?> cls2 = drawable.getClass(); cls2 != java.lang.Object.class && cls2 != null; cls2 = cls2.getSuperclass()) {
                        jSONArray.put(com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(cls2));
                    }
                    jSONObject2.put("classes", jSONArray);
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.left, bounds.left);
                    jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.right, bounds.right);
                    jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.top, bounds.top);
                    jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.bottom, bounds.bottom);
                    jSONObject2.put("dimensions", jSONObject3);
                    if (drawable instanceof android.graphics.drawable.ColorDrawable) {
                        jSONObject2.put("color", ((android.graphics.drawable.ColorDrawable) drawable).getColor());
                    }
                    jSONObject.put(propertyDescription.name, jSONObject2);
                } else {
                    jSONObject.put(propertyDescription.name, applyMethod.toString());
                }
            }
        }
    }

    private java.lang.String getResName(android.view.View view) {
        int id = view.getId();
        if (-1 == id) {
            return null;
        }
        return this.mResourceIds.nameForId(id);
    }

    private void getVisibleRect(android.view.View view, android.graphics.Rect rect, boolean z) {
        if (z) {
            view.getGlobalVisibleRect(rect);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocalVisibleRect(rect);
        rect.offset(iArr[0], iArr[1]);
    }

    private boolean isSnapShotUpdated(java.lang.String str, java.lang.StringBuilder sb) {
        boolean z = !((str == null || sb == null) ? false : str.equals(sb.toString())) || com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().hasAlertInfo() || com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().hasAlertInfo();
        if (sb != null) {
            sb.delete(0, sb.length()).append(str);
        }
        return z;
    }

    private void mergeThirdViewNodes(org.json.JSONArray jSONArray, com.sensorsdata.analytics.android.sdk.visual.model.CommonNode commonNode, android.view.View view, float f) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, commonNode.getId() + view.hashCode());
            jSONObject.put("index", 0);
            if (!android.text.TextUtils.isEmpty(commonNode.get$element_content())) {
                jSONObject.put("element_content", commonNode.get$element_content());
            }
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo = this.mSnapInfo;
            int i = snapInfo.elementLevel + 1;
            snapInfo.elementLevel = i;
            jSONObject.put("element_level", i);
            if (f == 0.0f) {
                f = commonNode.getScale();
            }
            float top = commonNode.getTop() * f;
            jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.left, commonNode.getLeft() * f);
            jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.top, top);
            jSONObject.put("width", (int) (commonNode.getWidth() * f));
            jSONObject.put("height", (int) (commonNode.getHeight() * f));
            jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, (commonNode.isVisibility() && (((commonNode.getOriginTop() * f) > ((float) view.getHeight()) ? 1 : ((commonNode.getOriginTop() * f) == ((float) view.getHeight()) ? 0 : -1)) <= 0 && ((commonNode.getOriginLeft() * f) > ((float) view.getWidth()) ? 1 : ((commonNode.getOriginLeft() * f) == ((float) view.getWidth()) ? 0 : -1)) <= 0)) ? 0 : 8);
            jSONObject.put("clickable", commonNode.isEnable_click());
            jSONObject.put("importantForAccessibility", true);
            jSONObject.put("is_list_view", commonNode.isIs_list_view());
            jSONObject.put("element_path", commonNode.get$element_path());
            if (!android.text.TextUtils.isEmpty(commonNode.get$element_position())) {
                jSONObject.put("element_position", commonNode.get$element_position());
            }
            this.mSnapInfo.webLibVersion = commonNode.getLib_version();
            jSONObject.put("scrollX", 0);
            jSONObject.put("scrollY", 0);
            if (commonNode instanceof com.sensorsdata.analytics.android.sdk.visual.model.WebNode) {
                com.sensorsdata.analytics.android.sdk.visual.model.WebNode webNode = (com.sensorsdata.analytics.android.sdk.visual.model.WebNode) commonNode;
                jSONObject.put("h5_title", webNode.get$title());
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_NAME, webNode.getTagName());
                jSONObject.put("url", webNode.get$url());
                if (!android.text.TextUtils.isEmpty(webNode.get$element_selector())) {
                    jSONObject.put("element_selector", webNode.get$element_selector());
                }
                jSONObject.put("list_selector", webNode.getList_selector());
                jSONObject.put("is_h5", true);
                jSONObject.put("element_platform", "h5");
            }
            if (commonNode instanceof com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode) {
                com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode flutterNode = (com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode) commonNode;
                jSONObject.put("title", flutterNode.getTitle());
                jSONObject.put("screen_name", flutterNode.getScreen_name());
                jSONObject.put("element_platform", "flutter");
            }
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            if (commonNode instanceof com.sensorsdata.analytics.android.sdk.visual.model.WebNode) {
                jSONArray2.put(((com.sensorsdata.analytics.android.sdk.visual.model.WebNode) commonNode).getTagName());
            }
            java.lang.Class<?> cls = view.getClass();
            do {
                jSONArray2.put(com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(cls));
                cls = cls.getSuperclass();
                if (cls == java.lang.Object.class) {
                    break;
                }
            } while (cls != null);
            jSONObject.put("classes", jSONArray2);
            java.util.List<java.lang.String> subelements = commonNode.getSubelements();
            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
            if (subelements != null && subelements.size() > 0) {
                java.util.Iterator<java.lang.String> it = subelements.iterator();
                while (it.hasNext()) {
                    jSONArray3.put(it.next() + view.hashCode());
                }
            }
            jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.subviews, jSONArray3);
            jSONArray.put(jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void reset() {
        this.mSnapInfo = new com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo();
    }

    private void snapshotFlutterView(org.json.JSONArray jSONArray, android.view.View view, java.util.List<java.lang.String> list, com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo) {
        java.lang.String str = snapInfo.activityName;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo flutterNodeInfo = (com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo) com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().getNodes(str);
        if (flutterNodeInfo == null) {
            com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().postDelayed(new com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable(com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.FLUTTER, str), 5000L);
            return;
        }
        if (flutterNodeInfo.getStatus() != com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.SUCCESS) {
            if (flutterNodeInfo.getStatus() == com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.FAILURE) {
                this.mSnapInfo.flutter_alertInfos = flutterNodeInfo.getAlertInfos();
                return;
            }
            return;
        }
        java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> nodes = flutterNodeInfo.getNodes();
        if (nodes == null || nodes.size() <= 0) {
            return;
        }
        java.util.Iterator<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> it = nodes.iterator();
        while (it.hasNext()) {
            com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode flutterNode = (com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode) it.next();
            mergeThirdViewNodes(jSONArray, flutterNode, view, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext().getResources().getDisplayMetrics().scaledDensity);
            if (flutterNode.isRootView()) {
                list.add(flutterNode.getId() + view.hashCode());
            }
        }
    }

    private void snapshotView(org.json.JSONArray jSONArray, android.view.View view, int i) throws java.lang.Exception {
        android.app.Activity foregroundActivity;
        if (com.sensorsdata.analytics.android.sdk.util.SAViewUtils.isViewSelfVisible(view)) {
            java.util.List<java.lang.String> arrayList = new java.util.ArrayList<>();
            int i2 = this.mSnapInfo.elementLevel;
            if (com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfFlutterSurfaceView(view)) {
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo = this.mSnapInfo;
                snapInfo.isFlutter = true;
                if (android.text.TextUtils.isEmpty(snapInfo.activityName) && (foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity()) != null) {
                    this.mSnapInfo.activityName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(foregroundActivity.getClass());
                }
                com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo flutterNodeInfo = (com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo) com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().getPageInfo(this.mSnapInfo.activityName);
                if (flutterNodeInfo != null) {
                    this.mSnapInfo.flutterLibVersion = flutterNodeInfo.getFlutter_lib_version();
                }
                snapshotFlutterView(jSONArray, view, arrayList, this.mSnapInfo);
            }
            if (com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfWebView(view)) {
                this.mSnapInfo.isWebView = true;
                java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                try {
                    view.post(new com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.AnonymousClass1(view, countDownLatch));
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
                try {
                    countDownLatch.await(500L, java.util.concurrent.TimeUnit.MILLISECONDS);
                } catch (java.lang.InterruptedException e2) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "WebView url: " + this.mSnapInfo.webViewUrl);
                if (!android.text.TextUtils.isEmpty(this.mSnapInfo.webViewUrl)) {
                    com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo webNodeInfo = (com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo) com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().getNodes(this.mSnapInfo.webViewUrl);
                    if (webNodeInfo == null) {
                        com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().postDelayed(new com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable(com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.AlertRunnable.AlertType.H5, this.mSnapInfo.webViewUrl), 5000L);
                    } else if (webNodeInfo.getStatus() == com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.SUCCESS) {
                        java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> nodes = webNodeInfo.getNodes();
                        if (nodes != null && nodes.size() > 0) {
                            arrayList = new java.util.ArrayList<>();
                            for (com.sensorsdata.analytics.android.sdk.visual.model.CommonNode commonNode : nodes) {
                                mergeThirdViewNodes(jSONArray, commonNode, view, this.mSnapInfo.webViewScale);
                                if (commonNode.isRootView()) {
                                    arrayList.add(commonNode.getId() + view.hashCode());
                                }
                            }
                        }
                    } else if (webNodeInfo.getStatus() == com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.Status.FAILURE) {
                        this.mSnapInfo.alertInfos = webNodeInfo.getAlertInfos();
                    }
                }
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, view.hashCode());
            jSONObject.put("id", view.getId());
            jSONObject.put("index", com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getChildIndex(view.getParent(), view));
            if (com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfWebView(view) || com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfFlutterSurfaceView(view)) {
                jSONObject.put("element_level", i2);
            } else {
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo2 = this.mSnapInfo;
                int i3 = snapInfo2.elementLevel + 1;
                snapInfo2.elementLevel = i3;
                jSONObject.put("element_level", i3);
            }
            jSONObject.put("element_selector", com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getElementSelector(view));
            org.json.JSONObject screenNameAndTitle = com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil.getScreenNameAndTitle(view, this.mSnapInfo);
            if (screenNameAndTitle != null) {
                java.lang.String optString = screenNameAndTitle.optString("$screen_name");
                java.lang.String optString2 = screenNameAndTitle.optString("$title");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    jSONObject.put("screen_name", optString);
                }
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    jSONObject.put("title", optString2);
                }
            }
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewNode(view, i, true);
            if (viewNode != null) {
                if (!android.text.TextUtils.isEmpty(viewNode.getViewPath())) {
                    jSONObject.put("element_path", viewNode.getViewPath());
                }
                if (!android.text.TextUtils.isEmpty(viewNode.getViewPosition())) {
                    jSONObject.put("element_position", viewNode.getViewPosition());
                }
                if (!android.text.TextUtils.isEmpty(viewNode.getViewContent()) && com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil.isSupportElementContent(view)) {
                    jSONObject.put("element_content", viewNode.getViewContent());
                }
                jSONObject.put("is_list_view", viewNode.isListView());
            }
            jSONObject.put("element_platform", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            jSONObject.put("sa_id_name", getResName(view));
            try {
                java.lang.String str = (java.lang.String) view.getTag(com.sensorsdata.analytics.android.sdk.visual.R.id.sensors_analytics_tag_view_id);
                if (!android.text.TextUtils.isEmpty(str)) {
                    jSONObject.put("sa_id_name", str);
                }
            } catch (java.lang.Exception e3) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
            }
            if (com.sensorsdata.analytics.android.sdk.util.WindowHelper.isMainWindow(view.getRootView())) {
                jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.top, view.getTop());
                jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.left, view.getLeft());
                jSONObject.put("width", view.getWidth());
                jSONObject.put("height", view.getHeight());
            } else if (com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(view.getClass())) {
                android.util.DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.top, view.getTop());
                jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.left, view.getLeft());
                jSONObject.put("width", i4);
                jSONObject.put("height", i5);
            } else {
                android.view.ViewParent parent = view.getParent();
                if (parent == null || !com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(parent.getClass())) {
                    jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.top, view.getTop());
                    jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.left, view.getLeft());
                    jSONObject.put("width", view.getWidth());
                    jSONObject.put("height", view.getHeight());
                } else {
                    android.graphics.Rect rect = new android.graphics.Rect();
                    getVisibleRect(view, rect, false);
                    jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.top, rect.top);
                    jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.left, rect.left);
                    jSONObject.put("width", rect.width());
                    jSONObject.put("height", rect.height());
                }
            }
            int scrollX = view.getScrollX();
            if ((view instanceof android.widget.TextView) && ((android.widget.TextView) view).getMaxLines() == 1) {
                scrollX = 0;
            }
            if (com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfX5WebView(view)) {
                try {
                    jSONObject.put("scrollX", com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(view, "getWebScrollX", new java.lang.Object[0]));
                    jSONObject.put("scrollY", com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(view, "getWebScrollY", new java.lang.Object[0]));
                } catch (java.lang.Exception e4) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                }
            } else {
                jSONObject.put("scrollX", scrollX);
                jSONObject.put("scrollY", view.getScrollY());
            }
            jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil.getVisibility(view));
            float translationX = view.getTranslationX();
            float translationY = view.getTranslationY();
            jSONObject.put("translationX", translationX);
            jSONObject.put("translationY", translationY);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            java.lang.Class<?> cls = view.getClass();
            do {
                jSONArray2.put(this.mClassnameCache.get(cls));
                cls = cls.getSuperclass();
                if (cls == java.lang.Object.class) {
                    break;
                }
            } while (cls != null);
            jSONObject.put("classes", jSONArray2);
            addProperties(jSONObject, view);
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
                int[] rules = ((android.widget.RelativeLayout.LayoutParams) layoutParams).getRules();
                org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                for (int i6 : rules) {
                    jSONArray3.put(i6);
                }
                jSONObject.put("layoutRules", jSONArray3);
            }
            org.json.JSONArray jSONArray4 = new org.json.JSONArray();
            if (arrayList.size() > 0) {
                java.util.Iterator<java.lang.String> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray4.put(it.next());
                }
            } else if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    android.view.View childAt = viewGroup.getChildAt(i7);
                    if (childAt != null) {
                        jSONArray4.put(childAt.hashCode());
                    }
                }
            }
            jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.subviews, jSONArray4);
            jSONArray.put(jSONObject);
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                android.view.View childAt2 = viewGroup2.getChildAt(i8);
                if (childAt2 != null) {
                    snapshotView(jSONArray, childAt2, i8);
                }
            }
        }
    }

    private void snapshotViewHierarchy(org.json.JSONArray jSONArray, android.view.View view) throws java.lang.Exception {
        reset();
        snapshotView(jSONArray, view, 0);
        com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().setHasThirdView(this.mSnapInfo.isWebView);
        com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().setHasThirdView(this.mSnapInfo.isFlutter);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapshots(java.io.OutputStream outputStream, java.lang.StringBuilder sb) throws java.io.IOException {
        int size;
        int i;
        android.app.Activity foregroundActivity;
        int i2;
        java.util.List list;
        com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.CachedBitmap cachedBitmap;
        org.json.JSONObject jSONObject;
        java.lang.StringBuilder sb2;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.concurrent.FutureTask futureTask = new java.util.concurrent.FutureTask(this.mRootViewFinder);
        this.mMainThreadHandler.post(futureTask);
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(outputStream);
        java.util.List emptyList = java.util.Collections.emptyList();
        bufferedOutputStream.write("[".getBytes());
        int i3 = 1;
        try {
            try {
                try {
                    try {
                        java.util.List list2 = (java.util.List) futureTask.get(2L, java.util.concurrent.TimeUnit.SECONDS);
                        futureTask.cancel(true);
                        this.mMainThreadHandler.removeCallbacks(futureTask);
                        emptyList = list2;
                    } catch (java.lang.Throwable th) {
                        futureTask.cancel(true);
                        this.mMainThreadHandler.removeCallbacks(futureTask);
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Throwable thrown during screenshot attempt", th2);
                    futureTask.cancel(true);
                    this.mMainThreadHandler.removeCallbacks(futureTask);
                    size = emptyList.size();
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "infoCount:" + size + ",time:" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
                    java.lang.String str = null;
                    java.lang.String str2 = null;
                    i = 0;
                    while (i < size) {
                    }
                    bufferedOutputStream.write("]".getBytes());
                    bufferedOutputStream.flush();
                    com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo = this.mSnapInfo;
                    snapInfo.screenName = str;
                    snapInfo.activityTitle = str2;
                    foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
                    if (foregroundActivity != null) {
                    }
                    return this.mSnapInfo;
                }
            } catch (java.util.concurrent.TimeoutException e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent.", e);
                futureTask.cancel(true);
                this.mMainThreadHandler.removeCallbacks(futureTask);
                size = emptyList.size();
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "infoCount:" + size + ",time:" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
                java.lang.String str3 = null;
                java.lang.String str22 = null;
                i = 0;
                while (i < size) {
                }
                bufferedOutputStream.write("]".getBytes());
                bufferedOutputStream.flush();
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo2 = this.mSnapInfo;
                snapInfo2.screenName = str3;
                snapInfo2.activityTitle = str22;
                foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
                if (foregroundActivity != null) {
                }
                return this.mSnapInfo;
            }
        } catch (java.lang.InterruptedException e2) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Screenshot interrupted, no screenshot will be sent.", e2);
            futureTask.cancel(true);
            this.mMainThreadHandler.removeCallbacks(futureTask);
            size = emptyList.size();
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "infoCount:" + size + ",time:" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
            java.lang.String str32 = null;
            java.lang.String str222 = null;
            i = 0;
            while (i < size) {
            }
            bufferedOutputStream.write("]".getBytes());
            bufferedOutputStream.flush();
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo22 = this.mSnapInfo;
            snapInfo22.screenName = str32;
            snapInfo22.activityTitle = str222;
            foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
            if (foregroundActivity != null) {
            }
            return this.mSnapInfo;
        } catch (java.util.concurrent.ExecutionException e3) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Exception thrown during screenshot attempt", e3);
            futureTask.cancel(true);
            this.mMainThreadHandler.removeCallbacks(futureTask);
            size = emptyList.size();
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "infoCount:" + size + ",time:" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
            java.lang.String str322 = null;
            java.lang.String str2222 = null;
            i = 0;
            while (i < size) {
            }
            bufferedOutputStream.write("]".getBytes());
            bufferedOutputStream.flush();
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo222 = this.mSnapInfo;
            snapInfo222.screenName = str322;
            snapInfo222.activityTitle = str2222;
            foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
            if (foregroundActivity != null) {
            }
            return this.mSnapInfo;
        }
        size = emptyList.size();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "infoCount:" + size + ",time:" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
        java.lang.String str3222 = null;
        java.lang.String str22222 = null;
        i = 0;
        while (i < size) {
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo rootViewInfo = (com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo) emptyList.get(i);
            if (i > 0) {
                bufferedOutputStream.write(",".getBytes());
            }
            if (rootViewInfo != null && (cachedBitmap = rootViewInfo.screenshot) != null) {
                if (isSnapShotUpdated(cachedBitmap.getImageHash(), sb) || i > 0) {
                    bufferedOutputStream.write("{".getBytes());
                    bufferedOutputStream.write("\"activity\":".getBytes());
                    java.lang.String str4 = rootViewInfo.screenName;
                    java.lang.String str5 = rootViewInfo.activityTitle;
                    bufferedOutputStream.write(org.json.JSONObject.quote(str4).getBytes());
                    bufferedOutputStream.write(",".getBytes());
                    bufferedOutputStream.write("\"scale\":".getBytes());
                    java.lang.Object[] objArr = new java.lang.Object[i3];
                    objArr[0] = java.lang.Float.valueOf(rootViewInfo.scale);
                    bufferedOutputStream.write(java.lang.String.format("%s", objArr).getBytes());
                    bufferedOutputStream.write(",".getBytes());
                    bufferedOutputStream.write("\"serialized_objects\":".getBytes());
                    try {
                        jSONObject = new org.json.JSONObject();
                        i2 = size;
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        i2 = size;
                    }
                    try {
                        jSONObject.put("rootObject", rootViewInfo.rootView.hashCode());
                        org.json.JSONArray jSONArray = new org.json.JSONArray();
                        snapshotViewHierarchy(jSONArray, rootViewInfo.rootView);
                        jSONObject.put("objects", jSONArray);
                        bufferedOutputStream.write(jSONObject.toString().getBytes());
                        sb2 = new java.lang.StringBuilder();
                        sb2.append("snapshotViewHierarchy:");
                        list = emptyList;
                    } catch (java.lang.Exception e5) {
                        e = e5;
                        list = emptyList;
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        bufferedOutputStream.write(",".getBytes());
                        bufferedOutputStream.write("\"image_hash\":".getBytes());
                        bufferedOutputStream.write(org.json.JSONObject.quote(rootViewInfo.screenshot.getImageHash()).getBytes());
                        bufferedOutputStream.write(",".getBytes());
                        bufferedOutputStream.write("\"screenshot\":".getBytes());
                        bufferedOutputStream.flush();
                        rootViewInfo.screenshot.writeBitmapJSON(android.graphics.Bitmap.CompressFormat.PNG, 70, outputStream);
                        bufferedOutputStream.write(com.alipay.sdk.m.u.i.d.getBytes());
                        str3222 = str4;
                        str22222 = str5;
                        i++;
                        emptyList = list;
                        size = i2;
                        i3 = 1;
                    }
                    try {
                        sb2.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, sb2.toString());
                    } catch (java.lang.Exception e6) {
                        e = e6;
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        bufferedOutputStream.write(",".getBytes());
                        bufferedOutputStream.write("\"image_hash\":".getBytes());
                        bufferedOutputStream.write(org.json.JSONObject.quote(rootViewInfo.screenshot.getImageHash()).getBytes());
                        bufferedOutputStream.write(",".getBytes());
                        bufferedOutputStream.write("\"screenshot\":".getBytes());
                        bufferedOutputStream.flush();
                        rootViewInfo.screenshot.writeBitmapJSON(android.graphics.Bitmap.CompressFormat.PNG, 70, outputStream);
                        bufferedOutputStream.write(com.alipay.sdk.m.u.i.d.getBytes());
                        str3222 = str4;
                        str22222 = str5;
                        i++;
                        emptyList = list;
                        size = i2;
                        i3 = 1;
                    }
                    bufferedOutputStream.write(",".getBytes());
                    bufferedOutputStream.write("\"image_hash\":".getBytes());
                    bufferedOutputStream.write(org.json.JSONObject.quote(rootViewInfo.screenshot.getImageHash()).getBytes());
                    bufferedOutputStream.write(",".getBytes());
                    bufferedOutputStream.write("\"screenshot\":".getBytes());
                    bufferedOutputStream.flush();
                    rootViewInfo.screenshot.writeBitmapJSON(android.graphics.Bitmap.CompressFormat.PNG, 70, outputStream);
                    bufferedOutputStream.write(com.alipay.sdk.m.u.i.d.getBytes());
                    str3222 = str4;
                    str22222 = str5;
                    i++;
                    emptyList = list;
                    size = i2;
                    i3 = 1;
                }
            }
            i2 = size;
            list = emptyList;
            bufferedOutputStream.write("{}".getBytes());
            i++;
            emptyList = list;
            size = i2;
            i3 = 1;
        }
        bufferedOutputStream.write("]".getBytes());
        bufferedOutputStream.flush();
        com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo2222 = this.mSnapInfo;
        snapInfo2222.screenName = str3222;
        snapInfo2222.activityTitle = str22222;
        foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
        if (foregroundActivity != null) {
            this.mSnapInfo.isFlutter = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfFlutterActivity(foregroundActivity);
            this.mSnapInfo.activityName = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(foregroundActivity.getClass());
        }
        return this.mSnapInfo;
    }
}
