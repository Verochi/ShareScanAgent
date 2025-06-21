package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class KeyFrames {
    private static final java.lang.String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<? extends androidx.constraintlayout.motion.widget.Key>> sKeyMakers;
    private java.util.HashMap<java.lang.Integer, java.util.ArrayList<androidx.constraintlayout.motion.widget.Key>> mFramesMap = new java.util.HashMap<>();

    static {
        java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<? extends androidx.constraintlayout.motion.widget.Key>> hashMap = new java.util.HashMap<>();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", androidx.constraintlayout.motion.widget.KeyAttributes.class.getConstructor(new java.lang.Class[0]));
            sKeyMakers.put("KeyPosition", androidx.constraintlayout.motion.widget.KeyPosition.class.getConstructor(new java.lang.Class[0]));
            sKeyMakers.put("KeyCycle", androidx.constraintlayout.motion.widget.KeyCycle.class.getConstructor(new java.lang.Class[0]));
            sKeyMakers.put("KeyTimeCycle", androidx.constraintlayout.motion.widget.KeyTimeCycle.class.getConstructor(new java.lang.Class[0]));
            sKeyMakers.put("KeyTrigger", androidx.constraintlayout.motion.widget.KeyTrigger.class.getConstructor(new java.lang.Class[0]));
        } catch (java.lang.NoSuchMethodException unused) {
        }
    }

    public KeyFrames(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> hashMap;
        try {
            int eventType = xmlPullParser.getEventType();
            androidx.constraintlayout.motion.widget.Key key = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    java.lang.String name = xmlPullParser.getName();
                    if (sKeyMakers.containsKey(name)) {
                        try {
                            androidx.constraintlayout.motion.widget.Key newInstance = sKeyMakers.get(name).newInstance(new java.lang.Object[0]);
                            try {
                                newInstance.load(context, android.util.Xml.asAttributeSet(xmlPullParser));
                                addKey(newInstance);
                            } catch (java.lang.Exception unused) {
                            }
                            key = newInstance;
                        } catch (java.lang.Exception unused2) {
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute") && key != null && (hashMap = key.mCustomConstraints) != null) {
                        androidx.constraintlayout.widget.ConstraintAttribute.parse(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void addKey(androidx.constraintlayout.motion.widget.Key key) {
        if (!this.mFramesMap.containsKey(java.lang.Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(java.lang.Integer.valueOf(key.mTargetId), new java.util.ArrayList<>());
        }
        this.mFramesMap.get(java.lang.Integer.valueOf(key.mTargetId)).add(key);
    }

    public static java.lang.String name(int i, android.content.Context context) {
        return context.getResources().getResourceEntryName(i);
    }

    public void addFrames(androidx.constraintlayout.motion.widget.MotionController motionController) {
        java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> arrayList = this.mFramesMap.get(java.lang.Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            java.util.Iterator<androidx.constraintlayout.motion.widget.Key> it = arrayList2.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.motion.widget.Key next = it.next();
                if (next.matches(((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(next);
                }
            }
        }
    }

    public java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> getKeyFramesForView(int i) {
        return this.mFramesMap.get(java.lang.Integer.valueOf(i));
    }

    public java.util.Set<java.lang.Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
