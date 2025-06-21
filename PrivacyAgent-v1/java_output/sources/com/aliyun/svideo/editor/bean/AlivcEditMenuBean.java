package com.aliyun.svideo.editor.bean;

/* loaded from: classes12.dex */
public class AlivcEditMenuBean {

    @androidx.annotation.Nullable
    public java.lang.String menuName;
    public com.aliyun.svideo.editor.bean.AlivcEditMenus menuType;
    public int resourceId;

    public AlivcEditMenuBean(java.lang.String str, int i, com.aliyun.svideo.editor.bean.AlivcEditMenus alivcEditMenus) {
        this.menuName = str;
        this.resourceId = i;
        this.menuType = alivcEditMenus;
    }
}
