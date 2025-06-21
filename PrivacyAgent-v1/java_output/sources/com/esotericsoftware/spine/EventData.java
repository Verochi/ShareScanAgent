package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class EventData {
    public final java.lang.String a;
    public int b;
    public float c;
    public java.lang.String d;
    public java.lang.String e;

    public EventData(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a = str;
    }

    public java.lang.String getAudioPath() {
        return this.e;
    }

    public float getFloat() {
        return this.c;
    }

    public int getInt() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public java.lang.String getString() {
        return this.d;
    }

    public void setAudioPath(java.lang.String str) {
        this.e = str;
    }

    public void setFloat(float f) {
        this.c = f;
    }

    public void setInt(int i) {
        this.b = i;
    }

    public void setString(java.lang.String str) {
        this.d = str;
    }

    public java.lang.String toString() {
        return this.a;
    }
}
