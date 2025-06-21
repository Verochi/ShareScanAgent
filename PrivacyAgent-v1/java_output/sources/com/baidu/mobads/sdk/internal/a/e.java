package com.baidu.mobads.sdk.internal.a;

/* loaded from: classes.dex */
public class e implements com.baidu.mobads.sdk.internal.a.a {
    private com.baidu.mobads.sdk.internal.a.c a;

    @androidx.annotation.Nullable
    public android.view.View a(android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        java.lang.Object a = this.a.a("onCreateView", layoutInflater, viewGroup, bundle);
        if (a instanceof android.view.View) {
            return (android.view.View) a;
        }
        return null;
    }

    public void a() {
        this.a.a("onStart");
    }

    public void a(android.content.Context context) {
        this.a.a("onAttach", context);
    }

    public void a(@androidx.annotation.Nullable android.os.Bundle bundle) {
        this.a.a("onCreate", bundle);
    }

    public void a(com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.a = com.baidu.mobads.sdk.internal.a.c.a(iAdInterListener, this);
        }
    }

    public void b() {
        this.a.a("onResume");
    }

    public void b(@androidx.annotation.Nullable android.os.Bundle bundle) {
        this.a.a("onActivityCreated", bundle);
    }

    public void c() {
        this.a.a("onPause");
    }

    public void d() {
        this.a.a("onStop");
    }

    public void e() {
        this.a.a("onDestroyView");
    }

    public void f() {
        this.a.a("onDestroy");
    }

    public void g() {
        this.a.a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.util.Map<java.lang.String, java.lang.Object> getData() {
        return this.a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @androidx.annotation.NonNull
    public com.baidu.mobads.sdk.api.IAdInterListener getDelegator() {
        return this.a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getMessage() {
        return this.a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.Object getTarget() {
        return this.a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getType() {
        return this.a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public java.lang.Object handleEvent(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(java.lang.Object obj) {
        this.a.setTarget(obj);
    }
}
