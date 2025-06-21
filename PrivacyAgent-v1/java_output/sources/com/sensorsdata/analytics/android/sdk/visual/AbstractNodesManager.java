package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public abstract class AbstractNodesManager {
    protected static final java.lang.String CALL_TYPE_PAGE_INFO = "page_info";
    protected static final java.lang.String CALL_TYPE_VISUALIZED_TRACK = "visualized_track";
    protected static final int LRU_CACHE_MAX_SIZE = 10;
    private static final java.lang.String TAG = "SA.Visual.AbstractNodesManager";
    protected static android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo> sNodesCache;
    protected static android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo> sPageInfoCache;
    protected boolean mHasAlertInfo;
    private boolean mHasWebView;
    protected java.lang.String mLastThirdNodeMsg = null;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(com.sensorsdata.analytics.android.sdk.visual.model.CommonNode commonNode, com.sensorsdata.analytics.android.sdk.visual.model.CommonNode commonNode2) {
            return commonNode.getLevel() - commonNode2.getLevel();
        }
    }

    public static class NodeRect {
        public float left;
        public float top;

        public NodeRect(float f, float f2) {
            this.top = f;
            this.left = f2;
        }
    }

    private void findWebNodes(org.json.JSONArray jSONArray, java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list, java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.NodeRect> map) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        com.sensorsdata.analytics.android.sdk.visual.model.CommonNode parseExtraNodesInfo = parseExtraNodesInfo(optJSONObject);
                        parseExtraNodesInfo.setId(optJSONObject.optString("id"));
                        parseExtraNodesInfo.set$element_content(optJSONObject.optString(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT));
                        parseExtraNodesInfo.setTop((float) optJSONObject.optDouble(com.sensorsdata.sf.ui.view.UIProperty.top));
                        parseExtraNodesInfo.setLeft((float) optJSONObject.optDouble(com.sensorsdata.sf.ui.view.UIProperty.left));
                        parseExtraNodesInfo.setScrollX((float) optJSONObject.optDouble("scrollX"));
                        parseExtraNodesInfo.setScrollY((float) optJSONObject.optDouble("scrollY"));
                        parseExtraNodesInfo.setWidth((float) optJSONObject.optDouble("width"));
                        parseExtraNodesInfo.setHeight((float) optJSONObject.optDouble("height"));
                        parseExtraNodesInfo.setLevel(optJSONObject.optInt(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL));
                        parseExtraNodesInfo.set$element_path(optJSONObject.optString(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_PATH));
                        parseExtraNodesInfo.set$element_position(optJSONObject.optString(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_POSITION));
                        parseExtraNodesInfo.setEnable_click(optJSONObject.optBoolean("enable_click", true));
                        parseExtraNodesInfo.setIs_list_view(optJSONObject.optBoolean("is_list_view"));
                        org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("subelements");
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                java.lang.String optString = optJSONArray.optString(i2);
                                if (!android.text.TextUtils.isEmpty(optString)) {
                                    arrayList.add(optString);
                                    if (!map.containsKey(optString)) {
                                        map.put(optString, new com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.NodeRect(parseExtraNodesInfo.getTop(), parseExtraNodesInfo.getLeft()));
                                    }
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            parseExtraNodesInfo.setSubelements(arrayList);
                        }
                        list.add(parseExtraNodesInfo);
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    private void modifyWebNodes(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list, java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.NodeRect> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (com.sensorsdata.analytics.android.sdk.visual.model.CommonNode commonNode : list) {
                commonNode.setOriginLeft(commonNode.getLeft());
                commonNode.setOriginTop(commonNode.getTop());
                if (map.containsKey(commonNode.getId())) {
                    com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.NodeRect nodeRect = map.get(commonNode.getId());
                    if (nodeRect != null) {
                        commonNode.setTop(commonNode.getTop() - nodeRect.top);
                        commonNode.setLeft(commonNode.getLeft() - nodeRect.left);
                    }
                } else {
                    commonNode.setRootView(true);
                    float scrollY = !java.lang.Float.isNaN(commonNode.getScrollY()) ? commonNode.getScrollY() : 0.0f;
                    float scrollX = java.lang.Float.isNaN(commonNode.getScrollX()) ? 0.0f : commonNode.getScrollX();
                    commonNode.setTop(commonNode.getTop() + scrollY);
                    commonNode.setLeft(commonNode.getLeft() + scrollX);
                }
            }
        }
    }

    private java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> parseAlertResult(java.lang.String str) {
        java.util.ArrayList arrayList = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONArray optJSONArray = new org.json.JSONObject(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    org.json.JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        arrayList2.add(new com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo(jSONObject.optString("title"), jSONObject.optString("message"), jSONObject.optString("link_text"), jSONObject.optString("link_url")));
                    }
                } catch (org.json.JSONException e) {
                    e = e;
                    arrayList = arrayList2;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    return arrayList;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    arrayList = arrayList2;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (org.json.JSONException e3) {
            e = e3;
        } catch (java.lang.Exception e4) {
            e = e4;
        }
    }

    private java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> parseResult(java.lang.String str) {
        org.json.JSONArray jSONArray = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> arrayList = new java.util.ArrayList<>();
        java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.NodeRect> hashMap = new java.util.HashMap<>();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("data");
            try {
                jSONArray = jSONObject.optJSONArray("extra_elements");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            if (optJSONArray != null) {
                findWebNodes(optJSONArray, arrayList, hashMap);
            }
            if (jSONArray != null) {
                findWebNodes(jSONArray, arrayList, hashMap);
            }
            modifyWebNodes(arrayList, hashMap);
            try {
                java.util.Collections.sort(arrayList, new com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.AnonymousClass1());
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
        } catch (org.json.JSONException e3) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
        } catch (java.lang.Exception e4) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
        }
        return arrayList;
    }

    public void clear() {
        this.mLastThirdNodeMsg = null;
        this.mHasAlertInfo = false;
    }

    public java.lang.String getLastThirdMsg() {
        return this.mLastThirdNodeMsg;
    }

    public com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo getNodes(java.lang.String str) {
        if (!com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().isServiceRunning() && !com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().isServiceRunning()) {
            return null;
        }
        if (sNodesCache == null) {
            sNodesCache = new android.util.LruCache<>(10);
        }
        return sNodesCache.get(str);
    }

    public com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo getPageInfo(java.lang.String str) {
        if (!com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().isServiceRunning() && !com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().isServiceRunning()) {
            return null;
        }
        if (sPageInfoCache == null) {
            sPageInfoCache = new android.util.LruCache<>(10);
        }
        return sPageInfoCache.get(str);
    }

    public void handlerFailure(java.lang.String str, java.lang.String str2) {
        try {
            com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().removeCallbacksAndMessages();
            if ((com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().isServiceRunning() || com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().isServiceRunning()) && !android.text.TextUtils.isEmpty(str2)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "handlerFailure url " + str + ",msg: " + str2);
                this.mHasAlertInfo = true;
                this.mLastThirdNodeMsg = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> parseAlertResult = parseAlertResult(str2);
                if (parseAlertResult == null || parseAlertResult.size() <= 0) {
                    return;
                }
                if (sNodesCache == null) {
                    sNodesCache = new android.util.LruCache<>(10);
                }
                handlerVisualizedFailure(str, parseAlertResult);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068 A[Catch: Exception -> 0x0085, JSONException -> 0x008a, TryCatch #2 {JSONException -> 0x008a, Exception -> 0x0085, blocks: (B:12:0x0030, B:22:0x0064, B:24:0x0068, B:26:0x006e, B:28:0x0074, B:30:0x0078, B:31:0x0081, B:35:0x004b, B:38:0x0055), top: B:11:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlerMessage(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().removeCallbacksAndMessages();
        if ((!com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().isServiceRunning() && !com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().isServiceRunning()) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mLastThirdNodeMsg = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        char c = 0;
        this.mHasAlertInfo = false;
        try {
            java.lang.String optString = new org.json.JSONObject(str).optString("callType");
            int hashCode = optString.hashCode();
            if (hashCode != 817885468) {
                if (hashCode == 883555422 && optString.equals(CALL_TYPE_PAGE_INFO)) {
                    c = 1;
                    if (c == 0) {
                        if (c != 1) {
                            return;
                        }
                        handlerVisualizedPageInfo(str);
                        return;
                    }
                    java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> parseResult = parseResult(str);
                    if (parseResult == null || parseResult.size() <= 0) {
                        return;
                    }
                    if (sNodesCache == null) {
                        sNodesCache = new android.util.LruCache<>(10);
                    }
                    handlerVisualizedTrack(parseResult);
                    return;
                }
                c = 65535;
                if (c == 0) {
                }
            } else {
                if (optString.equals(CALL_TYPE_VISUALIZED_TRACK)) {
                    if (c == 0) {
                    }
                }
                c = 65535;
                if (c == 0) {
                }
            }
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public abstract void handlerVisualizedFailure(java.lang.String str, java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo.AlertInfo> list);

    public abstract void handlerVisualizedPageInfo(java.lang.String str);

    public abstract void handlerVisualizedTrack(java.util.List<? extends com.sensorsdata.analytics.android.sdk.visual.model.CommonNode> list);

    public boolean hasAlertInfo() {
        return this.mHasAlertInfo;
    }

    public boolean hasThirdView() {
        return this.mHasWebView;
    }

    public abstract com.sensorsdata.analytics.android.sdk.visual.model.CommonNode parseExtraNodesInfo(org.json.JSONObject jSONObject);

    public void setHasThirdView(boolean z) {
        this.mHasWebView = z;
    }
}
