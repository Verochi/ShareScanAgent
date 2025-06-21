package androidx.appcompat.app;

/* loaded from: classes.dex */
class LayoutIncludeDetector {

    @androidx.annotation.NonNull
    private final java.util.Deque<java.lang.ref.WeakReference<org.xmlpull.v1.XmlPullParser>> mXmlParserStack = new java.util.ArrayDeque();

    private static boolean isParserOutdated(@androidx.annotation.Nullable org.xmlpull.v1.XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            return true;
        }
        try {
            if (xmlPullParser.getEventType() != 3) {
                return xmlPullParser.getEventType() == 1;
            }
            return true;
        } catch (org.xmlpull.v1.XmlPullParserException unused) {
            return true;
        }
    }

    @androidx.annotation.Nullable
    private static org.xmlpull.v1.XmlPullParser popOutdatedAttrHolders(@androidx.annotation.NonNull java.util.Deque<java.lang.ref.WeakReference<org.xmlpull.v1.XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            org.xmlpull.v1.XmlPullParser xmlPullParser = deque.peek().get();
            if (!isParserOutdated(xmlPullParser)) {
                return xmlPullParser;
            }
            deque.pop();
        }
        return null;
    }

    private static boolean shouldInheritContext(@androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable org.xmlpull.v1.XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 == null || xmlPullParser == xmlPullParser2) {
            return false;
        }
        try {
            if (xmlPullParser2.getEventType() == 2) {
                return "include".equals(xmlPullParser2.getName());
            }
            return false;
        } catch (org.xmlpull.v1.XmlPullParserException unused) {
            return false;
        }
    }

    public boolean detect(@androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        if (!(attributeSet instanceof org.xmlpull.v1.XmlPullParser)) {
            return false;
        }
        org.xmlpull.v1.XmlPullParser xmlPullParser = (org.xmlpull.v1.XmlPullParser) attributeSet;
        if (xmlPullParser.getDepth() != 1) {
            return false;
        }
        org.xmlpull.v1.XmlPullParser popOutdatedAttrHolders = popOutdatedAttrHolders(this.mXmlParserStack);
        this.mXmlParserStack.push(new java.lang.ref.WeakReference<>(xmlPullParser));
        return shouldInheritContext(xmlPullParser, popOutdatedAttrHolders);
    }
}
