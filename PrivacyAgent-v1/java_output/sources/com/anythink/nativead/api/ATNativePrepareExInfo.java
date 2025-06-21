package com.anythink.nativead.api;

/* loaded from: classes12.dex */
public class ATNativePrepareExInfo extends com.anythink.nativead.api.ATNativePrepareInfo {
    java.util.List<android.view.View> creativeClickViewList;
    java.util.List<android.view.View> permissionClickViewList;
    java.util.List<android.view.View> privacyClickViewList;

    public java.util.List<android.view.View> getCreativeClickViewList() {
        android.view.View view;
        java.util.List<android.view.View> list = this.creativeClickViewList;
        if (list != null && (view = this.closeView) != null) {
            list.remove(view);
        }
        return this.creativeClickViewList;
    }

    public java.util.List<android.view.View> getPermissionClickViewList() {
        android.view.View view;
        java.util.List<android.view.View> list = this.permissionClickViewList;
        if (list != null && (view = this.closeView) != null) {
            list.remove(view);
        }
        return this.permissionClickViewList;
    }

    public java.util.List<android.view.View> getPrivacyClickViewList() {
        android.view.View view;
        java.util.List<android.view.View> list = this.privacyClickViewList;
        if (list != null && (view = this.closeView) != null) {
            list.remove(view);
        }
        return this.privacyClickViewList;
    }

    public void setCreativeClickViewList(java.util.List<android.view.View> list) {
        this.creativeClickViewList = list;
    }

    public void setPermissionClickViewList(java.util.List<android.view.View> list) {
        this.permissionClickViewList = list;
    }

    public void setPrivacyClickViewList(java.util.List<android.view.View> list) {
        this.privacyClickViewList = list;
    }
}
