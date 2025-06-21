package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class g {
    private com.baidu.mobads.sdk.internal.de a;
    private java.lang.String b;

    public interface a {
        void a();

        void a(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse);

        void a(com.baidu.mobads.sdk.api.NativeResponse nativeResponse);

        void a(com.baidu.mobads.sdk.api.NativeResponse nativeResponse, int i);

        void a(java.util.List<com.baidu.mobads.sdk.api.NativeResponse> list);

        void b();

        void b(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse);

        void b(com.baidu.mobads.sdk.api.NativeResponse nativeResponse);

        void c();
    }

    public interface b {
        void a(com.baidu.mobads.sdk.api.NativeResponse nativeResponse);
    }

    public g(android.content.Context context, com.baidu.mobads.sdk.internal.g.a aVar, com.baidu.mobads.sdk.internal.de deVar) {
        this.a = deVar;
        deVar.a(aVar);
    }

    public g(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i) {
        com.baidu.mobads.sdk.internal.de deVar = new com.baidu.mobads.sdk.internal.de(context, str, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_SONES, z, i);
        this.a = deVar;
        deVar.a(entryAdListener);
    }

    public g(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i) {
        com.baidu.mobads.sdk.internal.de deVar = new com.baidu.mobads.sdk.internal.de(context, str, "feed", z, i);
        this.a = deVar;
        deVar.a(expressAdListener);
        this.a.a(1);
    }

    public g(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.internal.g.a aVar, boolean z, int i) {
        this(context, aVar, new com.baidu.mobads.sdk.internal.de(context, str, "feed", z, i));
    }

    public g(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.internal.g.a aVar, boolean z, int i, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str2)) {
            if (str2.equals(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.a = new com.baidu.mobads.sdk.internal.de(context, str, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INSITE, z, i);
            } else if (str2.equals(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.a = new com.baidu.mobads.sdk.internal.de(context, str, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_SUG, z, i);
            } else if (str2.equals(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.a = new com.baidu.mobads.sdk.internal.de(context, str, "video", z, i);
            } else {
                this.a = new com.baidu.mobads.sdk.internal.de(context, str, "feed", z, i);
            }
        }
        this.a.a(aVar);
    }

    public java.lang.String a(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        if (this.a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new com.baidu.mobads.sdk.api.RequestParameters.Builder().build();
        }
        this.a.h(this.b);
        this.a.a(requestParameters);
        return this.a.l();
    }

    public void a() {
        com.baidu.mobads.sdk.internal.de deVar = this.a;
        if (deVar != null) {
            deVar.p();
        }
    }

    public void a(int i) {
        com.baidu.mobads.sdk.internal.de deVar = this.a;
        if (deVar != null) {
            deVar.r = i;
        }
    }

    public void a(com.baidu.mobads.sdk.internal.g.b bVar) {
        com.baidu.mobads.sdk.internal.de deVar = this.a;
        if (deVar != null) {
            deVar.a(bVar);
        }
    }

    public void a(java.lang.String str) {
        com.baidu.mobads.sdk.internal.de deVar = this.a;
        if (deVar != null) {
            deVar.b(str);
        }
    }

    public void a(boolean z) {
        com.baidu.mobads.sdk.internal.de deVar = this.a;
        if (deVar != null) {
            deVar.c(z);
        }
    }

    public void b() {
        b((com.baidu.mobads.sdk.api.RequestParameters) null);
    }

    public void b(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new com.baidu.mobads.sdk.api.RequestParameters.Builder().build();
        }
        com.baidu.mobads.sdk.internal.de deVar = this.a;
        if (deVar != null) {
            deVar.h(this.b);
        }
        this.a.a(requestParameters);
        this.a.a();
    }

    public void b(java.lang.String str) {
        this.b = str;
    }
}
