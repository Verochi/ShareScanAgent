package com.aliyun.svideo.base.http;

/* loaded from: classes.dex */
public class EffectService {
    public static final int ANIMATION_FILTER = 9;
    public static final java.lang.String BASE_URL = "https://alivc-demo.aliyuncs.com";
    public static final int EFFECT_CAPTION = 6;
    public static final int EFFECT_FACE_PASTER = 7;
    public static final int EFFECT_FILTER = 4;
    public static final int EFFECT_IMG = 8;
    public static final int EFFECT_MUSIC = 5;
    public static final int EFFECT_MV = 3;
    public static final int EFFECT_PASTER = 2;
    public static final int EFFECT_TEXT = 1;
    public static final int EFFECT_TRANSITION = 10;
    private static final java.lang.String KEY_PACKAGE_NAME = "PACKAGE_NAME";
    private static java.util.Map<java.lang.String, java.lang.String> sAppInfo;
    private com.google.gson.Gson mGson = new com.google.gson.GsonBuilder().disableHtmlEscaping().create();

    /* renamed from: com.aliyun.svideo.base.http.EffectService$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$1$1, reason: invalid class name and collision with other inner class name */
        public class C00541 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.Form.ResourceForm>> {
            public C00541() {
            }
        }

        public AnonymousClass1(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass1) str);
            try {
                java.util.List list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass1.C00541().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$10, reason: invalid class name */
    public class AnonymousClass10 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$10$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.http.MusicBean>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass10(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass10) str);
            try {
                java.util.List<com.aliyun.svideo.base.http.MusicBean> list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONObject("data").getJSONArray("musicList").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass10.AnonymousClass1().getType());
                if (this.val$callback != null) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (com.aliyun.svideo.base.http.MusicBean musicBean : list) {
                        arrayList.add(new com.aliyun.svideo.base.http.MusicFileBean(musicBean.getTitle(), musicBean.getArtistName(), musicBean.getMusicId(), musicBean.getImage()));
                    }
                    this.val$callback.onSuccess(arrayList);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$11, reason: invalid class name */
    public class AnonymousClass11 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        public AnonymousClass11(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass11) str);
            try {
                java.lang.String string = new org.json.JSONObject(str).getJSONObject("data").getString("playPath");
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(string);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$2, reason: invalid class name */
    public class AnonymousClass2 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass2(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass2) str);
            try {
                java.util.List list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass2.AnonymousClass1().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$3, reason: invalid class name */
    public class AnonymousClass3 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass3(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass3) str);
            try {
                java.util.List list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass3.AnonymousClass1().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$4, reason: invalid class name */
    public class AnonymousClass4 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        public AnonymousClass4(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass4) str);
            try {
                com.aliyun.svideo.base.Form.FontForm fontForm = (com.aliyun.svideo.base.Form.FontForm) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(new org.json.JSONObject(str).getJSONObject("data").toString(), com.aliyun.svideo.base.Form.FontForm.class);
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(fontForm);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$5, reason: invalid class name */
    public class AnonymousClass5 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$5$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideosdk.common.struct.form.PreviewPasterForm>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass5(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass5) str);
            try {
                java.util.List list = (java.util.List) new com.aliyun.common.jasonparse.JSONSupportImpl().readListValue(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass5.AnonymousClass1().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$6, reason: invalid class name */
    public class AnonymousClass6 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$6$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.Form.IMVForm>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass6(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass6) str);
            try {
                java.util.List list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass6.AnonymousClass1().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$7, reason: invalid class name */
    public class AnonymousClass7 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$7$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass7(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass7) str);
            try {
                java.util.List list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass7.AnonymousClass1().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$8, reason: invalid class name */
    public class AnonymousClass8 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$8$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass8(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass8) str);
            try {
                java.util.List list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass8.AnonymousClass1().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.base.http.EffectService$9, reason: invalid class name */
    public class AnonymousClass9 extends com.aliyun.common.qupaiokhttp.StringHttpRequestCallback {
        final /* synthetic */ com.aliyun.svideo.base.http.HttpCallback val$callback;

        /* renamed from: com.aliyun.svideo.base.http.EffectService$9$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideo.base.Form.ResourceForm>> {
            public AnonymousClass1() {
            }
        }

        public AnonymousClass9(com.aliyun.svideo.base.http.HttpCallback httpCallback) {
            this.val$callback = httpCallback;
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onFailure(int i, java.lang.String str) {
            super.onFailure(i, str);
            com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
            if (httpCallback != null) {
                httpCallback.onFailure(new java.lang.Throwable(str));
            }
        }

        @Override // com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback
        public void onSuccess(java.lang.String str) {
            super.onSuccess((com.aliyun.svideo.base.http.EffectService.AnonymousClass9) str);
            try {
                java.util.List list = (java.util.List) com.aliyun.svideo.base.http.EffectService.this.mGson.fromJson(new org.json.JSONObject(str).getJSONArray("data").toString(), new com.aliyun.svideo.base.http.EffectService.AnonymousClass9.AnonymousClass1().getType());
                com.aliyun.svideo.base.http.HttpCallback httpCallback = this.val$callback;
                if (httpCallback != null) {
                    httpCallback.onSuccess(list);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.aliyun.svideo.base.http.HttpCallback httpCallback2 = this.val$callback;
                if (httpCallback2 != null) {
                    httpCallback2.onFailure(e);
                }
            }
        }
    }

    private void get(java.lang.String str, com.aliyun.common.qupaiokhttp.RequestParams requestParams, com.aliyun.common.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        java.util.Map<java.lang.String, java.lang.String> map = sAppInfo;
        if (map != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                requestParams.addHeader(entry.getKey(), entry.getValue());
            }
        }
        com.aliyun.common.qupaiokhttp.HttpRequest.get(str, requestParams, baseHttpRequestCallback);
    }

    public static void setAppInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, long j) {
        if (sAppInfo == null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            sAppInfo = hashMap;
            try {
                hashMap.put("appName", java.net.URLEncoder.encode(str, "UTF-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sAppInfo.put("packageName", str2);
            sAppInfo.put("appVersionName", str3);
            sAppInfo.put(com.ss.android.socialbase.downloader.constants.DBDefinition.APP_VERSION_CODE, java.lang.String.valueOf(j));
        }
    }

    public void getCaptionListById(java.lang.String str, int i, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("textPasterId", i);
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(BASE_URL + "/resource/getTextPasterList", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass3(httpCallback));
    }

    public void getFontById(java.lang.String str, int i, com.aliyun.svideo.base.http.HttpCallback<com.aliyun.svideo.base.Form.FontForm> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("fontId", i);
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(BASE_URL + "/resource/getFont", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass4(httpCallback));
    }

    public void getMusicDownloadUrlById(java.lang.String str, java.lang.String str2, com.aliyun.svideo.base.http.HttpCallback<java.lang.String> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("musicId", str2);
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get("https://alivc-demo.aliyuncs.com/music/getPlayPath", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass11(httpCallback));
    }

    public void getPasterListById(java.lang.String str, int i, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.PasterForm>> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("type", 2);
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        requestParams.addFormDataPart("pasterId", i);
        get(BASE_URL + "/resource/getPasterList", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass2(httpCallback));
    }

    public void loadAnimationFilter(java.lang.String str, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm>> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(BASE_URL + "/resource/getMotionFilter", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass7(httpCallback));
    }

    public void loadEffectCaption(java.lang.String str, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.ResourceForm>> httpCallback) {
        java.lang.String str2 = BASE_URL + "/resource/getTextPaster";
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(str2, requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass9(httpCallback));
    }

    public void loadEffectMv(java.lang.String str, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.IMVForm>> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(BASE_URL + "/resource/getMv", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass6(httpCallback));
    }

    public void loadEffectPaster(java.lang.String str, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.ResourceForm>> httpCallback) {
        java.lang.String str2 = BASE_URL + "/resource/getPasterInfo";
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("type", 2);
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(str2, requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass1(httpCallback));
    }

    public void loadFrontEffectPaster(java.lang.String str, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideosdk.common.struct.form.PreviewPasterForm>> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(BASE_URL + "/resource/getFrontPasterList", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass5(httpCallback));
    }

    public void loadTransitonEffect(java.lang.String str, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.Form.AnimationEffectForm>> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        get(BASE_URL + "/resource/getTransitions", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass8(httpCallback));
    }

    public void loadingMusicData(java.lang.String str, int i, int i2, java.lang.String str2, com.aliyun.svideo.base.http.HttpCallback<java.util.List<com.aliyun.svideo.base.http.MusicFileBean>> httpCallback) {
        com.aliyun.common.qupaiokhttp.RequestParams requestParams = new com.aliyun.common.qupaiokhttp.RequestParams();
        requestParams.addFormDataPart("pageNo", i);
        requestParams.addFormDataPart("pageSize", i2);
        requestParams.addFormDataPart(KEY_PACKAGE_NAME, str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            requestParams.addFormDataPart("keyWords", str2);
        }
        get("https://alivc-demo.aliyuncs.com/music/getRecommendMusic", requestParams, new com.aliyun.svideo.base.http.EffectService.AnonymousClass10(httpCallback));
    }
}
