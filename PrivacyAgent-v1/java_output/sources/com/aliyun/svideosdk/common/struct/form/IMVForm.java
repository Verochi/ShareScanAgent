package com.aliyun.svideosdk.common.struct.form;

@com.aliyun.Visible
@java.lang.Deprecated
/* loaded from: classes12.dex */
public class IMVForm implements java.io.Serializable {
    private java.util.List<com.aliyun.svideosdk.common.struct.form.AspectForm> aspectList;
    private int cat;
    private long duration;
    private java.lang.String icon;
    private int id;
    private java.lang.String key;
    private int level;
    private java.lang.String name;
    private java.lang.String previewMp4;
    private java.lang.String previewPic;
    private int sort;
    private java.lang.String tag;
    private int type;

    public java.util.List<com.aliyun.svideosdk.common.struct.form.AspectForm> getAspectList() {
        return this.aspectList;
    }

    public int getCat() {
        return this.cat;
    }

    public long getDuration() {
        return this.duration;
    }

    public java.lang.String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public int getLevel() {
        return this.level;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getPreviewMp4() {
        return this.previewMp4;
    }

    public java.lang.String getPreviewPic() {
        return this.previewPic;
    }

    public int getSort() {
        return this.sort;
    }

    public java.lang.String getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public void setAspectList(java.util.List<com.aliyun.svideosdk.common.struct.form.AspectForm> list) {
        this.aspectList = list;
    }

    public void setCat(int i) {
        this.cat = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setIcon(java.lang.String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setPreviewMp4(java.lang.String str) {
        this.previewMp4 = str;
    }

    public void setPreviewPic(java.lang.String str) {
        this.previewPic = str;
    }

    public void setSort(int i) {
        this.sort = i;
    }

    public void setTag(java.lang.String str) {
        this.tag = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
