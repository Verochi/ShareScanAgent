package com.huawei.hms.ui;

/* loaded from: classes22.dex */
public abstract class AbstractPromptDialog extends com.huawei.hms.ui.AbstractDialog {
    @Override // com.huawei.hms.ui.AbstractDialog
    public java.lang.String onGetNegativeButtonString(android.content.Context context) {
        return null;
    }

    @Override // com.huawei.hms.ui.AbstractDialog
    public java.lang.String onGetTitleString(android.content.Context context) {
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context);
        }
        return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_bindfaildlg_title");
    }
}
