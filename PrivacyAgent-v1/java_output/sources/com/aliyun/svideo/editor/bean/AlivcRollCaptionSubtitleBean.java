package com.aliyun.svideo.editor.bean;

/* loaded from: classes12.dex */
public class AlivcRollCaptionSubtitleBean implements java.io.Serializable {
    private int color = -1;
    private java.lang.String content;
    private boolean inEdit;
    private boolean isChecked;
    private java.lang.String showTime;

    public int getColor() {
        return this.color;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public java.lang.String getShowTime() {
        return this.showTime;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isInEdit() {
        return this.inEdit;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setInEdit(boolean z) {
        this.inEdit = z;
    }

    public void setShowTime(java.lang.String str) {
        this.showTime = str;
    }
}
