package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public enum BlendMode {
    normal(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, 1, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA),
    additive(com.badlogic.gdx.graphics.GL20.GL_SRC_ALPHA, 1, 1),
    multiply(com.badlogic.gdx.graphics.GL20.GL_DST_COLOR, com.badlogic.gdx.graphics.GL20.GL_DST_COLOR, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_ALPHA),
    screen(1, 1, com.badlogic.gdx.graphics.GL20.GL_ONE_MINUS_SRC_COLOR);

    public static com.esotericsoftware.spine.BlendMode[] values = values();
    int dest;
    int source;
    int sourcePMA;

    BlendMode(int i, int i2, int i3) {
        this.source = i;
        this.sourcePMA = i2;
        this.dest = i3;
    }

    public int getDest() {
        return this.dest;
    }

    public int getSource(boolean z) {
        return z ? this.sourcePMA : this.source;
    }
}
