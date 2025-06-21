package com.sensorsdata.analytics.android.sdk.visual.model;

/* loaded from: classes19.dex */
public class CommonNode implements java.io.Serializable {
    private static final long serialVersionUID = -5865016149609340219L;
    private java.lang.String $element_content;
    private java.lang.String $element_path;
    private java.lang.String $element_position;
    private boolean enable_click;
    private float height;
    private java.lang.String id;
    private boolean isRootView;
    private boolean is_list_view;
    private float left;
    private int level;
    private java.lang.String lib_version;
    private float originLeft;
    private float originTop;
    private float scale;
    private float scrollX;
    private float scrollY;
    private java.util.List<java.lang.String> subelements;
    private float top;
    private boolean visibility;
    private float width;

    public java.lang.String get$element_content() {
        return this.$element_content;
    }

    public java.lang.String get$element_path() {
        return this.$element_path;
    }

    public java.lang.String get$element_position() {
        return this.$element_position;
    }

    public float getHeight() {
        return this.height;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public float getLeft() {
        return this.left;
    }

    public int getLevel() {
        return this.level;
    }

    public java.lang.String getLib_version() {
        return this.lib_version;
    }

    public float getOriginLeft() {
        return this.originLeft;
    }

    public float getOriginTop() {
        return this.originTop;
    }

    public float getScale() {
        return this.scale;
    }

    public float getScrollX() {
        return this.scrollX;
    }

    public float getScrollY() {
        return this.scrollY;
    }

    public java.util.List<java.lang.String> getSubelements() {
        return this.subelements;
    }

    public float getTop() {
        return this.top;
    }

    public float getWidth() {
        return this.width;
    }

    public boolean isEnable_click() {
        return this.enable_click;
    }

    public boolean isIs_list_view() {
        return this.is_list_view;
    }

    public boolean isRootView() {
        return this.isRootView;
    }

    public boolean isVisibility() {
        return this.visibility;
    }

    public void set$element_content(java.lang.String str) {
        this.$element_content = str;
    }

    public void set$element_path(java.lang.String str) {
        this.$element_path = str;
    }

    public void set$element_position(java.lang.String str) {
        this.$element_position = str;
    }

    public void setEnable_click(boolean z) {
        this.enable_click = z;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setId(java.lang.String str) {
        this.id = str;
    }

    public void setIs_list_view(boolean z) {
        this.is_list_view = z;
    }

    public void setLeft(float f) {
        this.left = f;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setLib_version(java.lang.String str) {
        this.lib_version = str;
    }

    public void setOriginLeft(float f) {
        this.originLeft = f;
    }

    public void setOriginTop(float f) {
        this.originTop = f;
    }

    public void setRootView(boolean z) {
        this.isRootView = z;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public void setScrollX(float f) {
        this.scrollX = f;
    }

    public void setScrollY(float f) {
        this.scrollY = f;
    }

    public void setSubelements(java.util.List<java.lang.String> list) {
        this.subelements = list;
    }

    public void setTop(float f) {
        this.top = f;
    }

    public void setVisibility(boolean z) {
        this.visibility = z;
    }

    public void setWidth(float f) {
        this.width = f;
    }
}
