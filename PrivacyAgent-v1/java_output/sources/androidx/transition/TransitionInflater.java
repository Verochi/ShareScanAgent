package androidx.transition;

/* loaded from: classes.dex */
public class TransitionInflater {
    private final android.content.Context mContext;
    private static final java.lang.Class<?>[] CONSTRUCTOR_SIGNATURE = {android.content.Context.class, android.util.AttributeSet.class};
    private static final androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Constructor<?>> CONSTRUCTORS = new androidx.collection.ArrayMap<>();

    private TransitionInflater(@androidx.annotation.NonNull android.content.Context context) {
        this.mContext = context;
    }

    private java.lang.Object createCustom(android.util.AttributeSet attributeSet, java.lang.Class<?> cls, java.lang.String str) {
        java.lang.Object newInstance;
        java.lang.Class<? extends U> asSubclass;
        java.lang.String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new android.view.InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Constructor<?>> arrayMap = CONSTRUCTORS;
            synchronized (arrayMap) {
                java.lang.reflect.Constructor<?> constructor = arrayMap.get(attributeValue);
                if (constructor == null && (asSubclass = java.lang.Class.forName(attributeValue, false, this.mContext.getClassLoader()).asSubclass(cls)) != 0) {
                    constructor = asSubclass.getConstructor(CONSTRUCTOR_SIGNATURE);
                    constructor.setAccessible(true);
                    arrayMap.put(attributeValue, constructor);
                }
                newInstance = constructor.newInstance(this.mContext, attributeSet);
            }
            return newInstance;
        } catch (java.lang.Exception e) {
            throw new android.view.InflateException("Could not instantiate " + cls + " class " + attributeValue, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x017f, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private androidx.transition.Transition createTransitionFromXml(org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, androidx.transition.Transition transition) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth = xmlPullParser.getDepth();
        androidx.transition.TransitionSet transitionSet = transition instanceof androidx.transition.TransitionSet ? (androidx.transition.TransitionSet) transition : null;
        loop0: while (true) {
            androidx.transition.Transition transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        java.lang.String name = xmlPullParser.getName();
                        if ("fade".equals(name)) {
                            transition2 = new androidx.transition.Fade(this.mContext, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new androidx.transition.ChangeBounds(this.mContext, attributeSet);
                        } else if ("slide".equals(name)) {
                            transition2 = new androidx.transition.Slide(this.mContext, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new androidx.transition.Explode(this.mContext, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new androidx.transition.ChangeImageTransform(this.mContext, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new androidx.transition.ChangeTransform(this.mContext, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new androidx.transition.ChangeClipBounds(this.mContext, attributeSet);
                        } else if ("autoTransition".equals(name)) {
                            transition2 = new androidx.transition.AutoTransition(this.mContext, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new androidx.transition.ChangeScroll(this.mContext, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new androidx.transition.TransitionSet(this.mContext, attributeSet);
                        } else if (com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION.equals(name)) {
                            transition2 = (androidx.transition.Transition) createCustom(attributeSet, androidx.transition.Transition.class, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION);
                        } else if ("targets".equals(name)) {
                            getTargetIds(xmlPullParser, attributeSet, transition);
                        } else if ("arcMotion".equals(name)) {
                            if (transition == null) {
                                throw new java.lang.RuntimeException("Invalid use of arcMotion element");
                            }
                            transition.setPathMotion(new androidx.transition.ArcMotion(this.mContext, attributeSet));
                        } else if ("pathMotion".equals(name)) {
                            if (transition == null) {
                                throw new java.lang.RuntimeException("Invalid use of pathMotion element");
                            }
                            transition.setPathMotion((androidx.transition.PathMotion) createCustom(attributeSet, androidx.transition.PathMotion.class, "pathMotion"));
                        } else {
                            if (!"patternPathMotion".equals(name)) {
                                throw new java.lang.RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                            }
                            if (transition == null) {
                                throw new java.lang.RuntimeException("Invalid use of patternPathMotion element");
                            }
                            transition.setPathMotion(new androidx.transition.PatternPathMotion(this.mContext, attributeSet));
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                createTransitionFromXml(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            }
                            if (transition != null) {
                                throw new android.view.InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.addTransition(transition2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0056, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private androidx.transition.TransitionManager createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.view.ViewGroup viewGroup) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth = xmlPullParser.getDepth();
        androidx.transition.TransitionManager transitionManager = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    java.lang.String name = xmlPullParser.getName();
                    if (name.equals("transitionManager")) {
                        transitionManager = new androidx.transition.TransitionManager();
                    } else {
                        if (!name.equals(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION) || transitionManager == null) {
                            break;
                        }
                        loadTransition(attributeSet, xmlPullParser, viewGroup, transitionManager);
                    }
                }
            }
        }
        throw new java.lang.RuntimeException("Unknown scene name: " + xmlPullParser.getName());
    }

    public static androidx.transition.TransitionInflater from(android.content.Context context) {
        return new androidx.transition.TransitionInflater(context);
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    private void getTargetIds(org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, androidx.transition.Transition transition) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (!xmlPullParser.getName().equals(com.umeng.ccg.a.A)) {
                    throw new java.lang.RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
                android.content.res.TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, androidx.transition.Styleable.TRANSITION_TARGET);
                int namedResourceId = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                if (namedResourceId != 0) {
                    transition.addTarget(namedResourceId);
                } else {
                    int namedResourceId2 = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                    if (namedResourceId2 != 0) {
                        transition.excludeTarget(namedResourceId2, true);
                    } else {
                        java.lang.String namedString = androidx.core.content.res.TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                        if (namedString != null) {
                            transition.addTarget(namedString);
                        } else {
                            java.lang.String namedString2 = androidx.core.content.res.TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                            if (namedString2 != null) {
                                transition.excludeTarget(namedString2, true);
                            } else {
                                java.lang.String namedString3 = androidx.core.content.res.TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                if (namedString3 != null) {
                                    try {
                                        transition.excludeTarget(java.lang.Class.forName(namedString3), true);
                                    } catch (java.lang.ClassNotFoundException e) {
                                        obtainStyledAttributes.recycle();
                                        throw new java.lang.RuntimeException("Could not create " + namedString3, e);
                                    }
                                } else {
                                    java.lang.String namedString4 = androidx.core.content.res.TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                    if (namedString4 != null) {
                                        transition.addTarget(java.lang.Class.forName(namedString4));
                                    }
                                }
                            }
                        }
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    private void loadTransition(android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser, android.view.ViewGroup viewGroup, androidx.transition.TransitionManager transitionManager) throws android.content.res.Resources.NotFoundException {
        androidx.transition.Transition inflateTransition;
        android.content.res.TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, androidx.transition.Styleable.TRANSITION_MANAGER);
        int namedResourceId = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION, 2, -1);
        int namedResourceId2 = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        androidx.transition.Scene sceneForLayout = namedResourceId2 < 0 ? null : androidx.transition.Scene.getSceneForLayout(viewGroup, namedResourceId2, this.mContext);
        int namedResourceId3 = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        androidx.transition.Scene sceneForLayout2 = namedResourceId3 >= 0 ? androidx.transition.Scene.getSceneForLayout(viewGroup, namedResourceId3, this.mContext) : null;
        if (namedResourceId >= 0 && (inflateTransition = inflateTransition(namedResourceId)) != null) {
            if (sceneForLayout2 == null) {
                throw new java.lang.RuntimeException("No toScene for transition ID " + namedResourceId);
            }
            if (sceneForLayout == null) {
                transitionManager.setTransition(sceneForLayout2, inflateTransition);
            } else {
                transitionManager.setTransition(sceneForLayout, sceneForLayout2, inflateTransition);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public androidx.transition.Transition inflateTransition(int i) {
        android.content.res.XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                return createTransitionFromXml(xml, android.util.Xml.asAttributeSet(xml), null);
            } catch (java.io.IOException e) {
                throw new android.view.InflateException(xml.getPositionDescription() + ": " + e.getMessage(), e);
            } catch (org.xmlpull.v1.XmlPullParserException e2) {
                throw new android.view.InflateException(e2.getMessage(), e2);
            }
        } finally {
            xml.close();
        }
    }

    public androidx.transition.TransitionManager inflateTransitionManager(int i, android.view.ViewGroup viewGroup) {
        android.content.res.XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                return createTransitionManagerFromXml(xml, android.util.Xml.asAttributeSet(xml), viewGroup);
            } catch (java.io.IOException e) {
                android.view.InflateException inflateException = new android.view.InflateException(xml.getPositionDescription() + ": " + e.getMessage());
                inflateException.initCause(e);
                throw inflateException;
            } catch (org.xmlpull.v1.XmlPullParserException e2) {
                android.view.InflateException inflateException2 = new android.view.InflateException(e2.getMessage());
                inflateException2.initCause(e2);
                throw inflateException2;
            }
        } finally {
            xml.close();
        }
    }
}
