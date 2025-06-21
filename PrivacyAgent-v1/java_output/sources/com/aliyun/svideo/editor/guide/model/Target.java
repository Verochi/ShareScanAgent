package com.aliyun.svideo.editor.guide.model;

/* loaded from: classes12.dex */
public class Target {
    private char direction;
    private java.lang.String message;
    private com.aliyun.svideo.editor.guide.shapes.Shape shape;
    private android.view.View view;

    public Target() {
    }

    public Target(android.view.View view, java.lang.String str, char c, com.aliyun.svideo.editor.guide.shapes.Shape shape) {
        this.view = view;
        this.message = str;
        this.shape = shape;
        this.direction = c;
    }

    public char getDirection() {
        return this.direction;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public com.aliyun.svideo.editor.guide.shapes.Shape getShape() {
        return this.shape;
    }

    public android.view.View getView() {
        return this.view;
    }

    public void setDirection(char c) {
        this.direction = c;
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }

    public void setShape(com.aliyun.svideo.editor.guide.shapes.Shape shape) {
        this.shape = shape;
    }

    public void setView(android.view.View view) {
        this.view = view;
    }
}
