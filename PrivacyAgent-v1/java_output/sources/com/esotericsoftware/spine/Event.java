package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class Event {
    public final com.esotericsoftware.spine.EventData a;
    public int b;
    public float c;
    public java.lang.String d;
    public final float e;

    public Event(float f, com.esotericsoftware.spine.EventData eventData) {
        if (eventData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        this.e = f;
        this.a = eventData;
    }

    public com.esotericsoftware.spine.EventData getData() {
        return this.a;
    }

    public float getFloat() {
        return this.c;
    }

    public int getInt() {
        return this.b;
    }

    public java.lang.String getString() {
        return this.d;
    }

    public float getTime() {
        return this.e;
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
        return this.a.a;
    }
}
