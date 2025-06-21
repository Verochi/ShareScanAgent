package org.apache.tools.ant.input;

/* loaded from: classes25.dex */
public class InputRequest {
    public final java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;

    public InputRequest(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("prompt must not be null");
        }
        this.a = str;
    }

    public java.lang.String getDefaultValue() {
        return this.c;
    }

    public java.lang.String getInput() {
        return this.b;
    }

    public java.lang.String getPrompt() {
        return this.a;
    }

    public boolean isInputValid() {
        return true;
    }

    public void setDefaultValue(java.lang.String str) {
        this.c = str;
    }

    public void setInput(java.lang.String str) {
        this.b = str;
    }
}
