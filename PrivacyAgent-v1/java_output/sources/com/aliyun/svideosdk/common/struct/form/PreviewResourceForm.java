package com.aliyun.svideosdk.common.struct.form;

@com.aliyun.Visible
@java.lang.Deprecated
/* loaded from: classes12.dex */
public class PreviewResourceForm implements java.io.Serializable {
    private java.lang.String description;
    private java.lang.String icon;
    private int id;
    private transient boolean isMore;
    private int isNew;
    private int level;
    private java.lang.String name;
    private java.util.List<com.aliyun.svideosdk.common.struct.form.PreviewPasterForm> pasterList;
    private java.lang.String preview;
    private int sort;

    public java.lang.String getDescription() {
        return this.description;
    }

    public java.lang.String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public int getIsNew() {
        return this.isNew;
    }

    public int getLevel() {
        return this.level;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.form.PreviewPasterForm> getPasterList() {
        return this.pasterList;
    }

    public java.lang.String getPreview() {
        return this.preview;
    }

    public int getSort() {
        return this.sort;
    }

    public boolean isMore() {
        return this.isMore;
    }

    public void setDescription(java.lang.String str) {
        this.description = str;
    }

    public void setIcon(java.lang.String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsNew(int i) {
        this.isNew = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setMore(boolean z) {
        this.isMore = z;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setPasterList(java.util.List<com.aliyun.svideosdk.common.struct.form.PreviewPasterForm> list) {
        this.pasterList = list;
    }

    public void setPreview(java.lang.String str) {
        this.preview = str;
    }

    public void setSort(int i) {
        this.sort = i;
    }
}
