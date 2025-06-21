package com.baidu.mobads.sdk.internal.concrete;

/* loaded from: classes.dex */
public class RVViewHolderDelegate extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements com.baidu.mobads.sdk.internal.a.a {
    private final com.baidu.mobads.sdk.internal.a.c a;

    public RVViewHolderDelegate(@androidx.annotation.NonNull com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener, android.view.View view) {
        super(view);
        this.a = com.baidu.mobads.sdk.internal.a.c.a(iAdInterListener, this);
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
