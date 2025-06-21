package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public abstract class Attachment {
    public java.lang.String a;

    public Attachment(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a = str;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public java.lang.String toString() {
        return getName();
    }
}
