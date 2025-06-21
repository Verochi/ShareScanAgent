package com.tencent.open;

/* loaded from: classes19.dex */
public class a {
    protected java.util.HashMap<java.lang.String, com.tencent.open.a.b> a = new java.util.HashMap<>();

    /* renamed from: com.tencent.open.a$a, reason: collision with other inner class name */
    public static class C0500a {
        protected java.lang.ref.WeakReference<android.webkit.WebView> a;
        protected long b;
        protected java.lang.String c;

        public C0500a(android.webkit.WebView webView, long j, java.lang.String str) {
            this.a = new java.lang.ref.WeakReference<>(webView);
            this.b = j;
            this.c = str;
        }

        public void a() {
            android.webkit.WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            java.lang.String str = "javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})";
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
            webView.loadUrl(str);
        }

        public void a(java.lang.Object obj) {
            java.lang.String obj2;
            android.webkit.WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof java.lang.String) {
                obj2 = "'" + ((java.lang.Object) ((java.lang.String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                obj2 = ((obj instanceof java.lang.Number) || (obj instanceof java.lang.Long) || (obj instanceof java.lang.Integer) || (obj instanceof java.lang.Double) || (obj instanceof java.lang.Float)) ? obj.toString() : obj instanceof java.lang.Boolean ? obj.toString() : "'undefined'";
            }
            java.lang.String str = "javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + obj2 + "});";
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
            webView.loadUrl(str);
        }

        public void a(java.lang.String str) {
            android.webkit.WebView webView = this.a.get();
            if (webView != null) {
                java.lang.String str2 = "javascript:" + str;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str2);
                webView.loadUrl(str2);
            }
        }
    }

    public static class b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(java.lang.String str, java.util.List<java.lang.String> list, com.tencent.open.a.C0500a c0500a) {
            java.lang.reflect.Method method;
            java.lang.reflect.Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                } else {
                    i++;
                }
            }
            if (method == null) {
                if (c0500a != null) {
                    c0500a.a();
                    return;
                }
                return;
            }
            try {
                int size = list.size();
                java.lang.Object invoke = size != 0 ? size != 1 ? size != 2 ? size != 3 ? size != 4 ? size != 5 ? method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3)) : method.invoke(this, list.get(0), list.get(1), list.get(2)) : method.invoke(this, list.get(0), list.get(1)) : method.invoke(this, list.get(0)) : method.invoke(this, new java.lang.Object[0]);
                java.lang.Class<?> returnType = method.getReturnType();
                com.tencent.open.log.SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
                if (!"void".equals(returnType.getName()) && returnType != java.lang.Void.class) {
                    if (c0500a == null || !customCallback()) {
                        return;
                    }
                    c0500a.a(invoke != null ? invoke.toString() : null);
                }
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                if (c0500a != null) {
                    c0500a.a();
                }
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(com.tencent.open.a.b bVar, java.lang.String str) {
        this.a.put(str, bVar);
    }

    public void a(java.lang.String str, java.lang.String str2, java.util.List<java.lang.String> list, com.tencent.open.a.C0500a c0500a) {
        com.tencent.open.log.SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, java.net.URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        com.tencent.open.a.b bVar = this.a.get(str);
        if (bVar != null) {
            com.tencent.open.log.SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0500a);
        } else {
            com.tencent.open.log.SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0500a != null) {
                c0500a.a();
            }
        }
    }

    public boolean a(android.webkit.WebView webView, java.lang.String str) {
        com.tencent.open.log.SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !android.net.Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList((str + "/#").split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)));
        if (arrayList.size() < 6) {
            return false;
        }
        java.lang.String str2 = (java.lang.String) arrayList.get(2);
        java.lang.String str3 = (java.lang.String) arrayList.get(3);
        java.util.List<java.lang.String> subList = arrayList.subList(4, arrayList.size() - 1);
        com.tencent.open.a.C0500a c0500a = new com.tencent.open.a.C0500a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, subList, c0500a);
        return true;
    }
}
