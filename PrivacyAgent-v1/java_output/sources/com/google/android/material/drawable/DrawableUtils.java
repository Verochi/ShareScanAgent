package com.google.android.material.drawable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public final class DrawableUtils {
    private DrawableUtils() {
    }

    @androidx.annotation.NonNull
    public static android.util.AttributeSet parseDrawableXml(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.XmlRes int i, @androidx.annotation.NonNull java.lang.CharSequence charSequence) {
        int next;
        try {
            android.content.res.XmlResourceParser xml = context.getResources().getXml(i);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
            }
            if (android.text.TextUtils.equals(xml.getName(), charSequence)) {
                return android.util.Xml.asAttributeSet(xml);
            }
            throw new org.xmlpull.v1.XmlPullParserException("Must have a <" + ((java.lang.Object) charSequence) + "> start tag");
        } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException e) {
            android.content.res.Resources.NotFoundException notFoundException = new android.content.res.Resources.NotFoundException("Can't load badge resource ID #0x" + java.lang.Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }

    @android.annotation.TargetApi(21)
    public static void setRippleDrawableRadius(@androidx.annotation.Nullable android.graphics.drawable.RippleDrawable rippleDrawable, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i);
            return;
        }
        try {
            android.graphics.drawable.RippleDrawable.class.getDeclaredMethod("setMaxRadius", java.lang.Integer.TYPE).invoke(rippleDrawable, java.lang.Integer.valueOf(i));
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.IllegalStateException("Couldn't set RippleDrawable radius", e);
        }
    }

    @androidx.annotation.Nullable
    public static android.graphics.PorterDuffColorFilter updateTintFilter(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList, @androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
