package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public abstract class AliyunBasePasterController implements com.aliyun.svideosdk.editor.AliyunPasterBaseView {
    public boolean canDrag() {
        return true;
    }

    public abstract boolean contentContains(float f, float f2);

    public abstract void editTimeCompleted();

    public abstract void editTimeStart();

    public abstract com.aliyun.svideo.editor.effects.control.UIEditorPage getEditorPage();

    public abstract void hideOverlayView();

    public abstract boolean isAddedAnimation();

    public abstract boolean isEditCompleted();

    public abstract boolean isPasterExists();

    public abstract boolean isPasterRemoved();

    public abstract boolean isVisibleInTime(long j);

    public abstract void moveContent(float f, float f2);

    public abstract void moveToCenter();

    public abstract void removePaster();

    public abstract void setOnlyApplyUI(boolean z);

    public abstract void setPasterViewVisibility(int i);

    public abstract void showTextEdit(boolean z);

    public abstract void showTimeEdit();
}
