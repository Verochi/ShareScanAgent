package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class PathAttachment extends com.esotericsoftware.spine.attachments.VertexAttachment {
    public float[] g;
    public boolean h;
    public boolean i;
    public final com.badlogic.gdx.graphics.Color j;

    public PathAttachment(java.lang.String str) {
        super(str);
        this.j = new com.badlogic.gdx.graphics.Color(1.0f, 0.5f, 0.0f, 1.0f);
    }

    public boolean getClosed() {
        return this.h;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.j;
    }

    public boolean getConstantSpeed() {
        return this.i;
    }

    public float[] getLengths() {
        return this.g;
    }

    public void setClosed(boolean z) {
        this.h = z;
    }

    public void setConstantSpeed(boolean z) {
        this.i = z;
    }

    public void setLengths(float[] fArr) {
        this.g = fArr;
    }
}
