package androidx.vectordrawable.graphics.drawable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x00ca, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.view.animation.Interpolator createInterpolatorFromXml(android.content.Context context, android.content.res.Resources resources, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.view.animation.Interpolator accelerateInterpolator;
        int depth = xmlPullParser.getDepth();
        android.view.animation.Interpolator interpolator = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    android.util.AttributeSet asAttributeSet = android.util.Xml.asAttributeSet(xmlPullParser);
                    java.lang.String name = xmlPullParser.getName();
                    if (name.equals("linearInterpolator")) {
                        interpolator = new android.view.animation.LinearInterpolator();
                    } else {
                        if (name.equals("accelerateInterpolator")) {
                            accelerateInterpolator = new android.view.animation.AccelerateInterpolator(context, asAttributeSet);
                        } else if (name.equals("decelerateInterpolator")) {
                            accelerateInterpolator = new android.view.animation.DecelerateInterpolator(context, asAttributeSet);
                        } else if (name.equals("accelerateDecelerateInterpolator")) {
                            interpolator = new android.view.animation.AccelerateDecelerateInterpolator();
                        } else if (name.equals("cycleInterpolator")) {
                            accelerateInterpolator = new android.view.animation.CycleInterpolator(context, asAttributeSet);
                        } else if (name.equals("anticipateInterpolator")) {
                            accelerateInterpolator = new android.view.animation.AnticipateInterpolator(context, asAttributeSet);
                        } else if (name.equals("overshootInterpolator")) {
                            accelerateInterpolator = new android.view.animation.OvershootInterpolator(context, asAttributeSet);
                        } else if (name.equals("anticipateOvershootInterpolator")) {
                            accelerateInterpolator = new android.view.animation.AnticipateOvershootInterpolator(context, asAttributeSet);
                        } else if (name.equals("bounceInterpolator")) {
                            interpolator = new android.view.animation.BounceInterpolator();
                        } else {
                            if (!name.equals("pathInterpolator")) {
                                throw new java.lang.RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                            }
                            accelerateInterpolator = new androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat(context, asAttributeSet, xmlPullParser);
                        }
                        interpolator = accelerateInterpolator;
                    }
                }
            }
        }
    }

    public static android.view.animation.Interpolator loadInterpolator(android.content.Context context, int i) throws android.content.res.Resources.NotFoundException {
        return android.view.animation.AnimationUtils.loadInterpolator(context, i);
    }
}
