package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class KeyTrigger extends androidx.constraintlayout.motion.widget.Key {
    public static final int KEY_TYPE = 5;
    static final java.lang.String NAME = "KeyTrigger";
    private static final java.lang.String TAG = "KeyTrigger";
    android.graphics.RectF mCollisionRect;
    private java.lang.reflect.Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private java.lang.reflect.Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private java.lang.reflect.Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private java.lang.String mNegativeCross;
    private java.lang.String mPositiveCross;
    private boolean mPostLayout;
    android.graphics.RectF mTargetRect;
    private int mTriggerCollisionId;
    private android.view.View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;
    private int mCurveFit = -1;
    private java.lang.String mCross = null;

    public static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static android.util.SparseIntArray mAttrMap;

        static {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(androidx.constraintlayout.widget.R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        private Loader() {
        }

        public static void read(androidx.constraintlayout.motion.widget.KeyTrigger keyTrigger, android.content.res.TypedArray typedArray, android.content.Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyTrigger.mNegativeCross = typedArray.getString(index);
                        continue;
                    case 2:
                        keyTrigger.mPositiveCross = typedArray.getString(index);
                        continue;
                    case 4:
                        keyTrigger.mCross = typedArray.getString(index);
                        continue;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        continue;
                    case 6:
                        keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        continue;
                    case 7:
                        if (androidx.constraintlayout.motion.widget.MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            keyTrigger.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyTrigger.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                continue;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTrigger.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            break;
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFramePosition = integer;
                        keyTrigger.mFireThreshold = (integer + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        continue;
                    case 10:
                        keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        continue;
                    case 11:
                        keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("unused attribute 0x");
                sb.append(java.lang.Integer.toHexString(index));
                sb.append("   ");
                sb.append(mAttrMap.get(index));
            }
        }
    }

    public KeyTrigger() {
        int i = androidx.constraintlayout.motion.widget.Key.UNSET;
        this.mTriggerReceiver = i;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i;
        this.mTriggerCollisionId = i;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new android.graphics.RectF();
        this.mTargetRect = new android.graphics.RectF();
        this.mType = 5;
        this.mCustomConstraints = new java.util.HashMap<>();
    }

    private void setUpRect(android.graphics.RectF rectF, android.view.View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.SplineSet> hashMap) {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void conditionallyFire(float f, android.view.View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (this.mTriggerCollisionId != androidx.constraintlayout.motion.widget.Key.UNSET) {
            if (this.mTriggerCollisionView == null) {
                this.mTriggerCollisionView = ((android.view.ViewGroup) view.getParent()).findViewById(this.mTriggerCollisionId);
            }
            setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
            setUpRect(this.mTargetRect, view, this.mPostLayout);
            if (this.mCollisionRect.intersect(this.mTargetRect)) {
                if (this.mFireCrossReset) {
                    this.mFireCrossReset = false;
                    z = true;
                } else {
                    z = false;
                }
                if (this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.mFireNegativeReset = true;
                z5 = z4;
                z3 = false;
            } else {
                if (this.mFireCrossReset) {
                    z = false;
                } else {
                    this.mFireCrossReset = true;
                    z = true;
                }
                if (this.mFireNegativeReset) {
                    this.mFireNegativeReset = false;
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mFirePositiveReset = true;
                z5 = false;
            }
        } else {
            if (this.mFireCrossReset) {
                float f2 = this.mFireThreshold;
                if ((f - f2) * (this.mFireLastPos - f2) < 0.0f) {
                    this.mFireCrossReset = false;
                    z = true;
                    if (!this.mFireNegativeReset) {
                        float f3 = this.mFireThreshold;
                        float f4 = f - f3;
                        if ((this.mFireLastPos - f3) * f4 < 0.0f && f4 < 0.0f) {
                            this.mFireNegativeReset = false;
                            z2 = true;
                            if (this.mFirePositiveReset) {
                                float f5 = this.mFireThreshold;
                                float f6 = f - f5;
                                if ((this.mFireLastPos - f5) * f6 >= 0.0f || f6 <= 0.0f) {
                                    z5 = false;
                                } else {
                                    this.mFirePositiveReset = false;
                                }
                                z3 = z2;
                            } else {
                                if (java.lang.Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                                    this.mFirePositiveReset = true;
                                }
                                z3 = z2;
                                z5 = false;
                            }
                        }
                    } else if (java.lang.Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                        this.mFireNegativeReset = true;
                    }
                    z2 = false;
                    if (this.mFirePositiveReset) {
                    }
                }
            } else if (java.lang.Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
            }
            z = false;
            if (!this.mFireNegativeReset) {
            }
            z2 = false;
            if (this.mFirePositiveReset) {
            }
        }
        this.mFireLastPos = f;
        if (z3 || z || z5) {
            ((androidx.constraintlayout.motion.widget.MotionLayout) view.getParent()).fireTrigger(this.mTriggerID, z5, f);
        }
        if (this.mTriggerReceiver != androidx.constraintlayout.motion.widget.Key.UNSET) {
            view = ((androidx.constraintlayout.motion.widget.MotionLayout) view.getParent()).findViewById(this.mTriggerReceiver);
        }
        if (z3 && this.mNegativeCross != null) {
            if (this.mFireNegativeCross == null) {
                try {
                    this.mFireNegativeCross = view.getClass().getMethod(this.mNegativeCross, new java.lang.Class[0]);
                } catch (java.lang.NoSuchMethodException unused) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Could not find method \"");
                    sb.append(this.mNegativeCross);
                    sb.append("\"on class ");
                    sb.append(view.getClass().getSimpleName());
                    sb.append(" ");
                    sb.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
                }
            }
            try {
                this.mFireNegativeCross.invoke(view, new java.lang.Object[0]);
            } catch (java.lang.Exception unused2) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Exception in call \"");
                sb2.append(this.mNegativeCross);
                sb2.append("\"on class ");
                sb2.append(view.getClass().getSimpleName());
                sb2.append(" ");
                sb2.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
            }
        }
        if (z5 && this.mPositiveCross != null) {
            if (this.mFirePositiveCross == null) {
                try {
                    this.mFirePositiveCross = view.getClass().getMethod(this.mPositiveCross, new java.lang.Class[0]);
                } catch (java.lang.NoSuchMethodException unused3) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("Could not find method \"");
                    sb3.append(this.mPositiveCross);
                    sb3.append("\"on class ");
                    sb3.append(view.getClass().getSimpleName());
                    sb3.append(" ");
                    sb3.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
                }
            }
            try {
                this.mFirePositiveCross.invoke(view, new java.lang.Object[0]);
            } catch (java.lang.Exception unused4) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("Exception in call \"");
                sb4.append(this.mPositiveCross);
                sb4.append("\"on class ");
                sb4.append(view.getClass().getSimpleName());
                sb4.append(" ");
                sb4.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
            }
        }
        if (!z || this.mCross == null) {
            return;
        }
        if (this.mFireCross == null) {
            try {
                this.mFireCross = view.getClass().getMethod(this.mCross, new java.lang.Class[0]);
            } catch (java.lang.NoSuchMethodException unused5) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append("Could not find method \"");
                sb5.append(this.mCross);
                sb5.append("\"on class ");
                sb5.append(view.getClass().getSimpleName());
                sb5.append(" ");
                sb5.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
            }
        }
        try {
            this.mFireCross.invoke(view, new java.lang.Object[0]);
        } catch (java.lang.Exception unused6) {
            java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
            sb6.append("Exception in call \"");
            sb6.append(this.mCross);
            sb6.append("\"on class ");
            sb6.append(view.getClass().getSimpleName());
            sb6.append(" ");
            sb6.append(androidx.constraintlayout.motion.widget.Debug.getName(view));
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(java.util.HashSet<java.lang.String> hashSet) {
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(android.content.Context context, android.util.AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.KeyTrigger.Loader.read(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.KeyTrigger), context);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(java.lang.String str, java.lang.Object obj) {
    }
}
