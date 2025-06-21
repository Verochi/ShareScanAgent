package com.sensorsdata.analytics.android.sdk.util.visual;

/* loaded from: classes19.dex */
public class ViewTreeStatusObservable {
    private static final java.lang.String TAG = "SA.ViewTreeStatusObservable";
    public static volatile com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable viewTreeStatusObservable;
    private android.util.SparseArray<com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> mViewNodesWithHashCode = new android.util.SparseArray<>();
    private java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> mViewNodesHashMap = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> mWebViewHashMap = new java.util.HashMap<>();

    private java.lang.String generateKey(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return sb.toString();
    }

    private com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getCacheViewPathAndPosition(android.view.View view, boolean z) {
        java.lang.String str;
        com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode;
        int lastIndexOf;
        com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode2 = this.mViewNodesWithHashCode.get(view.hashCode());
        if (viewNode2 != null) {
            return viewNode2;
        }
        java.lang.Object parent = view.getParent();
        android.view.View view2 = parent instanceof android.view.ViewGroup ? (android.view.View) parent : null;
        if (view2 == null) {
            viewNode = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewPathAndPosition(view, z);
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode3 = this.mViewNodesWithHashCode.get(view2.hashCode());
            if (viewNode3 == null) {
                viewNode3 = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewPathAndPosition(view2, z);
                this.mViewNodesWithHashCode.put(view2.hashCode(), viewNode3);
            }
            if (viewNode3 != null) {
                sb.append(viewNode3.getViewOriginalPath());
                sb2.append(viewNode3.getViewPath());
                str = viewNode3.getViewPosition();
            } else {
                str = "";
            }
            viewNode = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewNode(view, ((android.view.ViewGroup) view2).indexOfChild(view), z);
            if (viewNode != null && !android.text.TextUtils.isEmpty(viewNode.getViewPath()) && viewNode.getViewPath().contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) && !android.text.TextUtils.isEmpty(str) && (lastIndexOf = sb2.lastIndexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != -1) {
                sb2.replace(lastIndexOf, lastIndexOf + 1, java.lang.String.valueOf(str));
            }
            if (viewNode != null) {
                sb.append(viewNode.getViewOriginalPath());
                sb2.append(viewNode.getViewPath());
                viewNode = new com.sensorsdata.analytics.android.sdk.util.visual.ViewNode(view, viewNode.getViewPosition(), sb.toString(), sb2.toString(), viewNode.getViewContent());
            }
        }
        this.mViewNodesWithHashCode.put(view.hashCode(), viewNode);
        return viewNode;
    }

    public static com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable getInstance() {
        if (viewTreeStatusObservable == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.class) {
                if (viewTreeStatusObservable == null) {
                    viewTreeStatusObservable = new com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable();
                }
            }
        }
        return viewTreeStatusObservable;
    }

    private com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getSingleViewPathAndPosition(android.view.View view, boolean z) {
        java.lang.String str;
        int lastIndexOf;
        java.lang.Object parent = view.getParent();
        android.view.View view2 = parent instanceof android.view.ViewGroup ? (android.view.View) parent : null;
        if (view2 == null) {
            return com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewPathAndPosition(view, z);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewPathAndPosition = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewPathAndPosition(view2, z);
        if (viewPathAndPosition != null) {
            sb.append(viewPathAndPosition.getViewOriginalPath());
            sb2.append(viewPathAndPosition.getViewPath());
            str = viewPathAndPosition.getViewPosition();
        } else {
            str = "";
        }
        com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.getViewNode(view, ((android.view.ViewGroup) view2).indexOfChild(view), z);
        if (viewNode == null) {
            return viewNode;
        }
        if (!android.text.TextUtils.isEmpty(viewNode.getViewPath()) && viewNode.getViewPath().contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) && !android.text.TextUtils.isEmpty(str) && (lastIndexOf = sb2.lastIndexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != -1) {
            sb2.replace(lastIndexOf, lastIndexOf + 1, java.lang.String.valueOf(str));
        }
        sb.append(viewNode.getViewOriginalPath());
        sb2.append(viewNode.getViewPath());
        return new com.sensorsdata.analytics.android.sdk.util.visual.ViewNode(view, viewNode.getViewPosition(), sb.toString(), sb2.toString(), viewNode.getViewContent());
    }

    private void traverseNode() {
        traverseNode(null);
    }

    private void traverseNode(android.view.View view) {
        try {
            this.mViewNodesHashMap.clear();
            this.mViewNodesWithHashCode.clear();
            this.mWebViewHashMap.clear();
            android.util.SparseArray<com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> sparseArray = new android.util.SparseArray<>();
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> hashMap = new java.util.HashMap<>();
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> hashMap2 = new java.util.HashMap<>();
            if (view != null) {
                traverseNode(view, sparseArray, hashMap, hashMap2);
            } else {
                for (android.view.View view2 : com.sensorsdata.analytics.android.sdk.util.WindowHelper.getSortedWindowViews()) {
                    traverseNode(view2, sparseArray, hashMap, hashMap2);
                }
            }
            this.mViewNodesHashMap = hashMap;
            this.mViewNodesWithHashCode = sparseArray;
            this.mWebViewHashMap = hashMap2;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void traverseNode(android.view.View view, android.util.SparseArray<com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> sparseArray, java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> hashMap, java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> hashMap2) {
        org.json.JSONObject screenNameAndTitle;
        if (view == null) {
            return;
        }
        try {
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode cacheViewPathAndPosition = getCacheViewPathAndPosition(view, true);
            if (cacheViewPathAndPosition != null) {
                sparseArray.put(view.hashCode(), cacheViewPathAndPosition);
                if (!android.text.TextUtils.isEmpty(cacheViewPathAndPosition.getViewPath()) && (screenNameAndTitle = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getScreenNameAndTitle(view)) != null) {
                    java.lang.String optString = screenNameAndTitle.optString("$screen_name");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        if (!android.text.TextUtils.isEmpty(cacheViewPathAndPosition.getViewContent())) {
                            hashMap.put(generateKey(cacheViewPathAndPosition.getViewPath(), cacheViewPathAndPosition.getViewPosition(), optString), cacheViewPathAndPosition);
                        }
                        if (com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfWebView(view)) {
                            hashMap2.put(cacheViewPathAndPosition.getViewPath() + optString, cacheViewPathAndPosition);
                        }
                    }
                }
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    android.view.View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        traverseNode(childAt, sparseArray, hashMap, hashMap2);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void clearViewNodeCache() {
        this.mViewNodesWithHashCode.clear();
        this.mViewNodesHashMap.clear();
    }

    public void clearWebViewCache() {
        try {
            java.util.HashMap<java.lang.String, com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> hashMap = this.mWebViewHashMap;
            if (hashMap != null) {
                hashMap.clear();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public java.util.List<android.view.View> getCurrentWebView() {
        try {
            if (this.mWebViewHashMap.size() == 0) {
                traverseNode();
            }
            if (this.mWebViewHashMap.size() <= 0) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.util.visual.ViewNode> it = this.mWebViewHashMap.values().iterator();
            while (it.hasNext()) {
                java.lang.ref.WeakReference<android.view.View> view = it.next().getView();
                if (view != null && view.get() != null) {
                    arrayList.add(view.get());
                }
            }
            return arrayList;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewNode(android.view.View view) {
        try {
            return getViewPathAndPosition(view);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewNode(java.lang.String str) {
        android.view.View view = null;
        try {
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = this.mWebViewHashMap.get(str);
            if (viewNode != 0) {
                try {
                    if (viewNode.getView() != null && viewNode.getView().get() != null) {
                        return viewNode;
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    view = viewNode;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    return view;
                }
            }
            android.app.Activity foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
            if (foregroundActivity != null && foregroundActivity.getWindow() != null && foregroundActivity.getWindow().isActive()) {
                view = foregroundActivity.getWindow().getDecorView();
            }
            if (view != null) {
                traverseNode(view);
            }
            return this.mWebViewHashMap.get(str);
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewNode(java.lang.ref.WeakReference<android.view.View> weakReference, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.app.Activity foregroundActivity;
        android.view.View view = null;
        try {
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = this.mViewNodesHashMap.get(generateKey(str, str2, str3));
            if (viewNode != 0) {
                return viewNode;
            }
            if (weakReference != null) {
                try {
                    if (weakReference.get() != null) {
                        view = weakReference.get().getRootView();
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    view = viewNode;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    return view;
                }
            }
            if (view == null && (foregroundActivity = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity()) != null && foregroundActivity.getWindow() != null && foregroundActivity.getWindow().isActive()) {
                view = foregroundActivity.getWindow().getDecorView();
            }
            if (view != null) {
                traverseNode(view);
            }
            return this.mViewNodesHashMap.get(generateKey(str, str2, str3));
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    public com.sensorsdata.analytics.android.sdk.util.visual.ViewNode getViewPathAndPosition(android.view.View view) {
        return getSingleViewPathAndPosition(view, false);
    }
}
