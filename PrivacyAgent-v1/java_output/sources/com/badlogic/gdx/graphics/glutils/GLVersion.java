package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class GLVersion {
    public int a;
    public int b;
    public int c;
    public final java.lang.String d;
    public final java.lang.String e;
    public final com.badlogic.gdx.graphics.glutils.GLVersion.Type f;
    public final java.lang.String g = "GLVersion";

    public enum Type {
        OpenGL,
        GLES,
        WebGL,
        NONE
    }

    public GLVersion(com.badlogic.gdx.Application.ApplicationType applicationType, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (applicationType == com.badlogic.gdx.Application.ApplicationType.Android) {
            this.f = com.badlogic.gdx.graphics.glutils.GLVersion.Type.GLES;
        } else if (applicationType == com.badlogic.gdx.Application.ApplicationType.iOS) {
            this.f = com.badlogic.gdx.graphics.glutils.GLVersion.Type.GLES;
        } else if (applicationType == com.badlogic.gdx.Application.ApplicationType.Desktop) {
            this.f = com.badlogic.gdx.graphics.glutils.GLVersion.Type.OpenGL;
        } else if (applicationType == com.badlogic.gdx.Application.ApplicationType.Applet) {
            this.f = com.badlogic.gdx.graphics.glutils.GLVersion.Type.OpenGL;
        } else if (applicationType == com.badlogic.gdx.Application.ApplicationType.WebGL) {
            this.f = com.badlogic.gdx.graphics.glutils.GLVersion.Type.WebGL;
        } else {
            this.f = com.badlogic.gdx.graphics.glutils.GLVersion.Type.NONE;
        }
        com.badlogic.gdx.graphics.glutils.GLVersion.Type type = this.f;
        if (type == com.badlogic.gdx.graphics.glutils.GLVersion.Type.GLES) {
            a("OpenGL ES (\\d(\\.\\d){0,2})", str);
        } else if (type == com.badlogic.gdx.graphics.glutils.GLVersion.Type.WebGL) {
            a("WebGL (\\d(\\.\\d){0,2})", str);
        } else if (type == com.badlogic.gdx.graphics.glutils.GLVersion.Type.OpenGL) {
            a("(\\d(\\.\\d){0,2})", str);
        } else {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            str2 = "";
            str3 = "";
        }
        this.d = str2;
        this.e = str3;
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(str).matcher(str2);
        if (matcher.find()) {
            java.lang.String[] split = matcher.group(1).split("\\.");
            this.a = b(split[0], 2);
            this.b = split.length < 2 ? 0 : b(split[1], 0);
            this.c = split.length >= 3 ? b(split[2], 0) : 0;
            return;
        }
        com.badlogic.gdx.Gdx.app.log("GLVersion", "Invalid version string: " + str2);
        this.a = 2;
        this.b = 0;
        this.c = 0;
    }

    public final int b(java.lang.String str, int i) {
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException unused) {
            com.badlogic.gdx.Gdx.app.error("LibGDX GL", "Error parsing number: " + str + ", assuming: " + i);
            return i;
        }
    }

    public java.lang.String getDebugVersionString() {
        return "Type: " + this.f + "\nVersion: " + this.a + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.b + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.c + "\nVendor: " + this.d + "\nRenderer: " + this.e;
    }

    public int getMajorVersion() {
        return this.a;
    }

    public int getMinorVersion() {
        return this.b;
    }

    public int getReleaseVersion() {
        return this.c;
    }

    public java.lang.String getRendererString() {
        return this.e;
    }

    public com.badlogic.gdx.graphics.glutils.GLVersion.Type getType() {
        return this.f;
    }

    public java.lang.String getVendorString() {
        return this.d;
    }

    public boolean isVersionEqualToOrHigher(int i, int i2) {
        int i3 = this.a;
        return i3 > i || (i3 == i && this.b >= i2);
    }
}
