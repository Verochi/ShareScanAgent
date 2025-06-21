package com.alipay.sdk.m.x;

/* loaded from: classes.dex */
public class d extends com.alipay.sdk.m.x.c implements com.alipay.sdk.m.x.e.f, com.alipay.sdk.m.x.e.g, com.alipay.sdk.m.x.e.h {
    public static final java.lang.String A = "action";
    public static final java.lang.String B = "pushWindow";
    public static final java.lang.String C = "h5JsFuncCallback";
    public static final java.lang.String D = "sdkInfo";
    public static final java.lang.String E = "canUseTaoLogin";
    public static final java.lang.String F = "taoLogin";
    public static final java.lang.String l = "sdk_result_code:";
    public static final java.lang.String m = "alipayjsbridge://";
    public static final java.lang.String n = "onBack";
    public static final java.lang.String o = "setTitle";
    public static final java.lang.String p = "onRefresh";
    public static final java.lang.String q = "showBackButton";
    public static final java.lang.String r = "onExit";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f88s = "onLoadJs";
    public static final java.lang.String t = "callNativeFunc";
    public static final java.lang.String u = "back";
    public static final java.lang.String v = "title";
    public static final java.lang.String w = "refresh";
    public static final java.lang.String x = "backButton";
    public static final java.lang.String y = "refreshButton";
    public static final java.lang.String z = "exit";
    public boolean e;
    public java.lang.String f;
    public boolean g;
    public final com.alipay.sdk.m.s.a h;
    public boolean i;
    public com.alipay.sdk.m.x.e j;
    public com.alipay.sdk.m.x.f k;

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.sdk.m.x.d.this.a.finish();
        }
    }

    public class b extends com.alipay.sdk.m.x.d.e {
        public final /* synthetic */ com.alipay.sdk.m.x.e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.alipay.sdk.m.x.e eVar) {
            super(null);
            this.a = eVar;
        }

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            this.a.a();
            com.alipay.sdk.m.x.d.this.g = false;
        }
    }

    public class c extends com.alipay.sdk.m.x.d.e {
        public final /* synthetic */ com.alipay.sdk.m.x.e a;
        public final /* synthetic */ java.lang.String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.alipay.sdk.m.x.e eVar, java.lang.String str) {
            super(null);
            this.a = eVar;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            com.alipay.sdk.m.x.d.this.removeView(this.a);
            com.alipay.sdk.m.x.d.this.j.a(this.b);
            com.alipay.sdk.m.x.d.this.g = false;
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$d, reason: collision with other inner class name */
    public class RunnableC0048d implements java.lang.Runnable {
        public final /* synthetic */ android.app.Activity a;
        public final /* synthetic */ android.webkit.SslErrorHandler b;

        /* renamed from: com.alipay.sdk.m.x.d$d$a */
        public class a implements android.content.DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                com.alipay.sdk.m.x.d.RunnableC0048d.this.b.cancel();
                com.alipay.sdk.m.k.a.b(com.alipay.sdk.m.x.d.this.h, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.A, "2");
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
                com.alipay.sdk.m.x.d.RunnableC0048d.this.a.finish();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
            }
        }

        public RunnableC0048d(android.app.Activity activity, android.webkit.SslErrorHandler sslErrorHandler) {
            this.a = activity;
            this.b = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.sdk.m.x.b.a(this.a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new com.alipay.sdk.m.x.d.RunnableC0048d.a(), null, null);
        }
    }

    public static abstract class e implements android.view.animation.Animation.AnimationListener {
        public e() {
        }

        public /* synthetic */ e(com.alipay.sdk.m.x.d.a aVar) {
            this();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    public static class f {
        public final java.lang.ref.WeakReference<com.alipay.sdk.m.x.e> a;
        public final java.lang.String b;
        public final java.lang.String c;
        public final org.json.JSONObject d;
        public boolean e = false;

        public f(com.alipay.sdk.m.x.e eVar, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
            this.a = new java.lang.ref.WeakReference<>(eVar);
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
        }

        public static java.lang.String a(java.lang.String str) {
            return android.text.TextUtils.isEmpty(str) ? "" : str.replace("'", "");
        }

        public void a(org.json.JSONObject jSONObject) {
            com.alipay.sdk.m.x.e eVar;
            if (this.e || (eVar = (com.alipay.sdk.m.x.e) com.alipay.sdk.m.u.n.a(this.a)) == null) {
                return;
            }
            this.e = true;
            eVar.a(java.lang.String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.c), a(jSONObject.toString())));
        }
    }

    public static class g implements com.alipay.sdk.m.j.d.a {
        public final com.alipay.sdk.m.x.d.f a;
        public final java.lang.String b;

        public g(com.alipay.sdk.m.x.d.f fVar, java.lang.String str) {
            this.a = fVar;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.j.d.a
        public void a(boolean z, org.json.JSONObject jSONObject, java.lang.String str) {
            try {
                this.a.a(new org.json.JSONObject().put("success", z).put("random", this.b).put("code", jSONObject).put("status", str));
            } catch (org.json.JSONException unused) {
            }
        }
    }

    public d(android.app.Activity activity, com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        super(activity, str);
        this.e = true;
        this.f = "GET";
        this.g = false;
        this.j = null;
        this.k = new com.alipay.sdk.m.x.f();
        this.h = aVar;
        g();
    }

    private synchronized void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        char c2;
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar == null) {
            return;
        }
        org.json.JSONObject h = com.alipay.sdk.m.u.n.h(str3);
        com.alipay.sdk.m.x.d.f fVar = new com.alipay.sdk.m.x.d.f(eVar, str, str2, h);
        android.content.Context context = eVar.getContext();
        try {
            java.lang.String str4 = fVar.b;
            switch (str4.hashCode()) {
                case -1785164386:
                    if (str4.equals(E)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552487705:
                    if (str4.equals(F)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3015911:
                    if (str4.equals(u)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3127582:
                    if (str4.equals(z)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 110371416:
                    if (str4.equals("title")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1085444827:
                    if (str4.equals(w)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1703426986:
                    if (str4.equals(B)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1906413305:
                    if (str4.equals(x)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1947723784:
                    if (str4.equals(D)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2033767917:
                    if (str4.equals(y)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (h.has("title")) {
                        eVar.getTitle().setText(h.optString("title", ""));
                        break;
                    }
                    break;
                case 1:
                    eVar.getWebView().reload();
                    break;
                case 2:
                    i();
                    break;
                case 3:
                    com.alipay.sdk.m.j.b.a(h.optString("result", null));
                    a(h.optBoolean("success", false));
                    break;
                case 4:
                    eVar.getBackButton().setVisibility(h.optBoolean("show", true) ? 0 : 4);
                    break;
                case 5:
                    eVar.getRefreshButton().setVisibility(h.optBoolean("show", true) ? 0 : 4);
                    break;
                case 6:
                    b(h.optString("url"), h.optString("title", ""));
                    break;
                case 7:
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("sdk_version", "15.8.11");
                    jSONObject.put("app_name", this.h.b());
                    jSONObject.put("app_version", this.h.c());
                    fVar.a(jSONObject);
                    break;
                case '\b':
                    java.lang.String url = eVar.getUrl();
                    if (!com.alipay.sdk.m.u.n.a(this.h, url)) {
                        com.alipay.sdk.m.k.a.b(this.h, com.alipay.sdk.m.k.b.l, "jsUrlErr", url);
                        break;
                    } else {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        boolean a2 = com.alipay.sdk.m.j.d.a(this.h, context);
                        jSONObject2.put("enabled", a2);
                        com.alipay.sdk.m.k.a.a(this.h, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.t0, java.lang.String.valueOf(a2));
                        fVar.a(jSONObject2);
                        break;
                    }
                case '\t':
                    java.lang.String url2 = eVar.getUrl();
                    if (!com.alipay.sdk.m.u.n.a(this.h, url2)) {
                        com.alipay.sdk.m.k.a.b(this.h, com.alipay.sdk.m.k.b.l, "jsUrlErr", url2);
                        break;
                    } else {
                        java.lang.String optString = h.optString("random");
                        org.json.JSONObject optJSONObject = h.optJSONObject("options");
                        if (!android.text.TextUtils.isEmpty("random") && optJSONObject != null) {
                            java.lang.String optString2 = optJSONObject.optString("url");
                            java.lang.String optString3 = optJSONObject.optString("action");
                            if (!android.text.TextUtils.isEmpty(optString2) && !android.text.TextUtils.isEmpty(optString3) && (context instanceof android.app.Activity)) {
                                com.alipay.sdk.m.j.d.a(this.h, (android.app.Activity) context, 1010, optString2, optString3, new com.alipay.sdk.m.x.d.g(fVar, optString));
                                break;
                            }
                        }
                    }
                    break;
            }
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(this.h, com.alipay.sdk.m.k.b.l, "jInfoErr", th, str);
        }
    }

    private synchronized void a(boolean z2) {
        com.alipay.sdk.m.j.b.a(z2);
        this.a.finish();
    }

    private synchronized void b(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> b2 = com.alipay.sdk.m.u.n.b(this.h, str);
        if (str.startsWith(t)) {
            a(b2.get("func"), b2.get("cbId"), b2.get("data"));
        } else if (str.startsWith(n)) {
            i();
        } else if (str.startsWith(o) && b2.containsKey("title")) {
            this.j.getTitle().setText(b2.get("title"));
        } else if (str.startsWith(p)) {
            this.j.getWebView().reload();
        } else if (str.startsWith(q) && b2.containsKey("bshow")) {
            this.j.getBackButton().setVisibility(android.text.TextUtils.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE, b2.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(r)) {
            com.alipay.sdk.m.j.b.a(b2.get("result"));
            a(android.text.TextUtils.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE, b2.get("bsucc")));
        } else if (str.startsWith(f88s)) {
            this.j.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    private synchronized boolean b(java.lang.String str, java.lang.String str2) {
        com.alipay.sdk.m.x.e eVar = this.j;
        try {
            com.alipay.sdk.m.x.e eVar2 = new com.alipay.sdk.m.x.e(this.a, this.h, new com.alipay.sdk.m.x.e.C0050e(!a(), !a()));
            this.j = eVar2;
            eVar2.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            if (!android.text.TextUtils.isEmpty(str2)) {
                this.j.getTitle().setText(str2);
            }
            this.g = true;
            this.k.a(eVar);
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new com.alipay.sdk.m.x.d.c(eVar, str));
            this.j.setAnimation(translateAnimation);
            addView(this.j);
        } catch (java.lang.Throwable unused) {
            return false;
        }
        return true;
    }

    private synchronized boolean e() {
        if (this.k.b()) {
            this.a.finish();
        } else {
            this.g = true;
            com.alipay.sdk.m.x.e eVar = this.j;
            this.j = this.k.c();
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new com.alipay.sdk.m.x.d.b(eVar));
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.j);
        }
        return true;
    }

    private synchronized void f() {
        android.app.Activity activity = this.a;
        com.alipay.sdk.m.x.e eVar = this.j;
        if (activity != null && eVar != null) {
            if (this.e) {
                activity.finish();
            } else {
                eVar.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    private synchronized boolean g() {
        try {
            com.alipay.sdk.m.x.e eVar = new com.alipay.sdk.m.x.e(this.a, this.h, new com.alipay.sdk.m.x.e.C0050e(!a(), !a()));
            this.j = eVar;
            eVar.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            addView(this.j);
        } catch (java.lang.Exception unused) {
            return false;
        }
        return true;
    }

    private void h() {
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar != null) {
            android.webkit.WebView webView = eVar.getWebView();
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, "javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
            webView.loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    private synchronized void i() {
        android.webkit.WebView webView = this.j.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            com.alipay.sdk.m.x.f fVar = this.k;
            if (fVar == null || fVar.b()) {
                a(false);
            } else {
                e();
            }
        }
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void a(com.alipay.sdk.m.x.e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void a(java.lang.String str) {
        if ("POST".equals(this.f)) {
            this.j.a(str, (byte[]) null);
        } else {
            this.j.a(str);
        }
        com.alipay.sdk.m.x.c.a(this.j.getWebView());
    }

    public synchronized void a(java.lang.String str, java.lang.String str2, boolean z2) {
        this.f = str2;
        this.j.getTitle().setText(str);
        this.e = z2;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, int i, java.lang.String str, java.lang.String str2) {
        this.i = true;
        com.alipay.sdk.m.k.a.b(this.h, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.y, "onReceivedError:" + i + "|" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        android.app.Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        com.alipay.sdk.m.k.a.b(this.h, com.alipay.sdk.m.k.b.k, com.alipay.sdk.m.k.b.z, "2-" + sslError);
        activity.runOnUiThread(new com.alipay.sdk.m.x.d.RunnableC0048d(activity, sslErrorHandler));
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        android.app.Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        if (com.alipay.sdk.m.u.n.a(this.h, str, activity)) {
            return true;
        }
        if (str.startsWith(m)) {
            b(str.substring(17));
        } else if (android.text.TextUtils.equals(str, com.alipay.sdk.m.l.a.p)) {
            a(false);
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            this.j.a(str);
        } else {
            try {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(str));
                activity.startActivity(intent);
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.k.a.a(this.h, com.alipay.sdk.m.k.b.l, th);
            }
        }
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(l)) {
            this.a.runOnUiThread(new com.alipay.sdk.m.x.d.a());
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void b(com.alipay.sdk.m.x.e eVar) {
        f();
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized boolean b() {
        android.app.Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        if (!a()) {
            if (!this.g) {
                f();
            }
            return true;
        }
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar != null && eVar.getWebView() != null) {
            if (!eVar.getWebView().canGoBack()) {
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
                activity.finish();
            } else if (d()) {
                com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b2.b(), b2.a(), ""));
                activity.finish();
            }
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean b(com.alipay.sdk.m.x.e eVar, java.lang.String str) {
        com.alipay.sdk.m.k.a.a(this.h, com.alipay.sdk.m.k.b.l, "h5ldd", android.os.SystemClock.elapsedRealtime() + "|" + com.alipay.sdk.m.u.n.i(str));
        h();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void c() {
        this.j.a();
        this.k.a();
    }

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized void c(com.alipay.sdk.m.x.e eVar, java.lang.String str) {
        if (!str.startsWith(com.alipay.sdk.m.l.a.q) && !eVar.getUrl().endsWith(str)) {
            this.j.getTitle().setText(str);
        }
    }

    public boolean d() {
        return this.i;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean d(com.alipay.sdk.m.x.e eVar, java.lang.String str) {
        com.alipay.sdk.m.k.a.a(this.h, com.alipay.sdk.m.k.b.l, "h5ld", android.os.SystemClock.elapsedRealtime() + "|" + com.alipay.sdk.m.u.n.i(str));
        if (!android.text.TextUtils.isEmpty(str) && !str.endsWith(com.anythink.china.common.a.a.g)) {
            h();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return this.g ? true : super.onInterceptTouchEvent(motionEvent);
    }
}
