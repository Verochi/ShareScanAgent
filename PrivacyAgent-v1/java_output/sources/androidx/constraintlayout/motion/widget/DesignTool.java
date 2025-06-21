package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class DesignTool implements androidx.constraintlayout.motion.widget.ProxyInterface {
    private static final boolean DEBUG = false;
    private static final java.lang.String TAG = "DesignTool";
    static final java.util.HashMap<android.util.Pair<java.lang.Integer, java.lang.Integer>, java.lang.String> allAttributes;
    static final java.util.HashMap<java.lang.String, java.lang.String> allMargins;
    private final androidx.constraintlayout.motion.widget.MotionLayout mMotionLayout;
    private androidx.constraintlayout.motion.widget.MotionScene mSceneCache;
    private java.lang.String mLastStartState = null;
    private java.lang.String mLastEndState = null;
    private int mLastStartStateId = -1;
    private int mLastEndStateId = -1;

    static {
        java.util.HashMap<android.util.Pair<java.lang.Integer, java.lang.Integer>, java.lang.String> hashMap = new java.util.HashMap<>();
        allAttributes = hashMap;
        java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
        allMargins = hashMap2;
        hashMap.put(android.util.Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(android.util.Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(android.util.Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(android.util.Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(android.util.Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(android.util.Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(android.util.Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(android.util.Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(android.util.Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(android.util.Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(android.util.Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(android.util.Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(android.util.Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(androidx.constraintlayout.motion.widget.MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private static void Connect(int i, androidx.constraintlayout.widget.ConstraintSet constraintSet, android.view.View view, java.util.HashMap<java.lang.String, java.lang.String> hashMap, int i2, int i3) {
        java.lang.String str = allAttributes.get(android.util.Pair.create(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3)));
        java.lang.String str2 = hashMap.get(str);
        if (str2 != null) {
            java.lang.String str3 = allMargins.get(str);
            constraintSet.connect(view.getId(), i2, java.lang.Integer.parseInt(str2), i3, str3 != null ? GetPxFromDp(i, hashMap.get(str3)) : 0);
        }
    }

    private static int GetPxFromDp(int i, java.lang.String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((java.lang.Integer.valueOf(str.substring(0, indexOf)).intValue() * i) / 160.0f);
    }

    private static void SetAbsolutePositions(int i, androidx.constraintlayout.widget.ConstraintSet constraintSet, android.view.View view, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        java.lang.String str = hashMap.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.setEditorAbsoluteX(view.getId(), GetPxFromDp(i, str));
        }
        java.lang.String str2 = hashMap.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.setEditorAbsoluteY(view.getId(), GetPxFromDp(i, str2));
        }
    }

    private static void SetBias(androidx.constraintlayout.widget.ConstraintSet constraintSet, android.view.View view, java.util.HashMap<java.lang.String, java.lang.String> hashMap, int i) {
        java.lang.String str = hashMap.get(i == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (i == 0) {
                constraintSet.setHorizontalBias(view.getId(), java.lang.Float.parseFloat(str));
            } else if (i == 1) {
                constraintSet.setVerticalBias(view.getId(), java.lang.Float.parseFloat(str));
            }
        }
    }

    private static void SetDimensions(int i, androidx.constraintlayout.widget.ConstraintSet constraintSet, android.view.View view, java.util.HashMap<java.lang.String, java.lang.String> hashMap, int i2) {
        java.lang.String str = hashMap.get(i2 == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int GetPxFromDp = !str.equalsIgnoreCase("wrap_content") ? GetPxFromDp(i, str) : -2;
            if (i2 == 0) {
                constraintSet.constrainWidth(view.getId(), GetPxFromDp);
            } else {
                constraintSet.constrainHeight(view.getId(), GetPxFromDp);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int i, java.lang.String str, java.lang.Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        androidx.constraintlayout.motion.widget.MotionController motionController;
        android.view.View view = (android.view.View) obj;
        if (i != 0) {
            androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null || view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            int duration = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildPath(fArr2, duration);
            return duration;
        }
        if (i == 2) {
            int duration2 = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildKeyFrames(fArr2, null);
            return duration2;
        }
        if (i != 3) {
            return -1;
        }
        int duration3 = this.mMotionLayout.mScene.getDuration() / 16;
        return motionController.getAttributeValues(str, fArr2, i3);
    }

    public void disableAutoTransition(boolean z) {
        this.mMotionLayout.disableAutoTransition(z);
    }

    public void dumpConstraintSet(java.lang.String str) {
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        java.lang.System.out.println(" dumping  " + str + " (" + lookUpConstraintId + ")");
        try {
            this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId).dump(this.mMotionLayout.mScene, new int[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(java.lang.Object obj, float[] fArr) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return -1;
        }
        int duration = motionScene.getDuration() / 16;
        androidx.constraintlayout.motion.widget.MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildKeyFrames(fArr, null);
        return duration;
    }

    public int getAnimationPath(java.lang.Object obj, float[] fArr, int i) {
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        androidx.constraintlayout.motion.widget.MotionController motionController = motionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildPath(fArr, i);
        return i;
    }

    public void getAnimationRectangles(java.lang.Object obj, float[] fArr) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return;
        }
        int duration = motionScene.getDuration() / 16;
        androidx.constraintlayout.motion.widget.MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return;
        }
        motionController.buildRectangles(fArr, duration);
    }

    public java.lang.String getEndState() {
        int endState = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == endState) {
            return this.mLastEndState;
        }
        java.lang.String constraintSetNames = this.mMotionLayout.getConstraintSetNames(endState);
        if (constraintSetNames != null) {
            this.mLastEndState = constraintSetNames;
            this.mLastEndStateId = endState;
        }
        return constraintSetNames;
    }

    public int getKeyFrameInfo(java.lang.Object obj, int i, int[] iArr) {
        androidx.constraintlayout.motion.widget.MotionController motionController = this.mMotionLayout.mFrameArrayList.get((android.view.View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i, iArr);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(java.lang.Object obj, int i, float f, float f2) {
        return this.mMotionLayout.mFrameArrayList.get((android.view.View) obj).getKeyFrameParameter(i, f, f2);
    }

    public int getKeyFramePositions(java.lang.Object obj, int[] iArr, float[] fArr) {
        androidx.constraintlayout.motion.widget.MotionController motionController = this.mMotionLayout.mFrameArrayList.get((android.view.View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getkeyFramePositions(iArr, fArr);
    }

    public java.lang.Object getKeyframe(int i, int i2, int i3) {
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        androidx.constraintlayout.motion.widget.MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getKeyFrame(motionLayout.getContext(), i, i2, i3);
    }

    public java.lang.Object getKeyframe(java.lang.Object obj, int i, int i2) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        int id = ((android.view.View) obj).getId();
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        return motionLayout.mScene.getKeyFrame(motionLayout.getContext(), i, id, i2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public java.lang.Object getKeyframeAtLocation(java.lang.Object obj, float f, float f2) {
        androidx.constraintlayout.motion.widget.MotionController motionController;
        android.view.View view = (android.view.View) obj;
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        if (view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
            return null;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        return motionController.getPositionKeyframe(viewGroup.getWidth(), viewGroup.getHeight(), f, f2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public java.lang.Boolean getPositionKeyframe(java.lang.Object obj, java.lang.Object obj2, float f, float f2, java.lang.String[] strArr, float[] fArr) {
        if (!(obj instanceof androidx.constraintlayout.motion.widget.KeyPositionBase)) {
            return java.lang.Boolean.FALSE;
        }
        android.view.View view = (android.view.View) obj2;
        this.mMotionLayout.mFrameArrayList.get(view).positionKeyframe(view, (androidx.constraintlayout.motion.widget.KeyPositionBase) obj, f, f2, strArr, fArr);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return java.lang.Boolean.TRUE;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public java.lang.String getStartState() {
        int startState = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == startState) {
            return this.mLastStartState;
        }
        java.lang.String constraintSetNames = this.mMotionLayout.getConstraintSetNames(startState);
        if (constraintSetNames != null) {
            this.mLastStartState = constraintSetNames;
            this.mLastStartStateId = startState;
        }
        return this.mMotionLayout.getConstraintSetNames(startState);
    }

    public java.lang.String getState() {
        if (this.mLastStartState != null && this.mLastEndState != null) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.mLastStartState;
            }
            if (progress >= 0.99f) {
                return this.mLastEndState;
            }
        }
        return this.mLastStartState;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        return (this.mLastStartState == null || this.mLastEndState == null) ? false : true;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int i, java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        android.view.View view = (android.view.View) obj;
        java.util.HashMap hashMap = (java.util.HashMap) obj2;
        int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
        androidx.constraintlayout.widget.ConstraintSet constraintSet = this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId);
        if (constraintSet == null) {
            return;
        }
        constraintSet.clear(view.getId());
        SetDimensions(i, constraintSet, view, hashMap, 0);
        SetDimensions(i, constraintSet, view, hashMap, 1);
        Connect(i, constraintSet, view, hashMap, 6, 6);
        Connect(i, constraintSet, view, hashMap, 6, 7);
        Connect(i, constraintSet, view, hashMap, 7, 7);
        Connect(i, constraintSet, view, hashMap, 7, 6);
        Connect(i, constraintSet, view, hashMap, 1, 1);
        Connect(i, constraintSet, view, hashMap, 1, 2);
        Connect(i, constraintSet, view, hashMap, 2, 2);
        Connect(i, constraintSet, view, hashMap, 2, 1);
        Connect(i, constraintSet, view, hashMap, 3, 3);
        Connect(i, constraintSet, view, hashMap, 3, 4);
        Connect(i, constraintSet, view, hashMap, 4, 3);
        Connect(i, constraintSet, view, hashMap, 4, 4);
        Connect(i, constraintSet, view, hashMap, 5, 5);
        SetBias(constraintSet, view, hashMap, 0);
        SetBias(constraintSet, view, hashMap, 1);
        SetAbsolutePositions(i, constraintSet, view, hashMap);
        this.mMotionLayout.updateState(lookUpConstraintId, constraintSet);
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(java.lang.Object obj, int i, java.lang.String str, java.lang.Object obj2) {
        androidx.constraintlayout.motion.widget.MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            motionScene.setKeyframe((android.view.View) obj, i, str, obj2);
            androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
            motionLayout.mTransitionGoalPosition = i / 100.0f;
            motionLayout.mTransitionLastPosition = 0.0f;
            motionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(java.lang.Object obj, int i, int i2, float f, float f2) {
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return false;
        }
        androidx.constraintlayout.motion.widget.MotionController motionController = motionLayout.mFrameArrayList.get(obj);
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout2 = this.mMotionLayout;
        int i3 = (int) (motionLayout2.mTransitionPosition * 100.0f);
        if (motionController == null) {
            return false;
        }
        android.view.View view = (android.view.View) obj;
        if (!motionLayout2.mScene.hasKeyFramePosition(view, i3)) {
            return false;
        }
        float keyFrameParameter = motionController.getKeyFrameParameter(2, f, f2);
        float keyFrameParameter2 = motionController.getKeyFrameParameter(5, f, f2);
        this.mMotionLayout.mScene.setKeyframe(view, i3, "motion:percentX", java.lang.Float.valueOf(keyFrameParameter));
        this.mMotionLayout.mScene.setKeyframe(view, i3, "motion:percentY", java.lang.Float.valueOf(keyFrameParameter2));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    }

    public void setKeyframe(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        if (obj instanceof androidx.constraintlayout.motion.widget.Key) {
            ((androidx.constraintlayout.motion.widget.Key) obj).setValue(str, obj2);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public void setState(java.lang.String str) {
        if (str == null) {
            str = "motion_base";
        }
        if (this.mLastStartState == str) {
            return;
        }
        this.mLastStartState = str;
        this.mLastEndState = null;
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        this.mLastStartStateId = lookUpConstraintId;
        if (lookUpConstraintId != 0) {
            if (lookUpConstraintId == this.mMotionLayout.getStartState()) {
                this.mMotionLayout.setProgress(0.0f);
            } else if (lookUpConstraintId == this.mMotionLayout.getEndState()) {
                this.mMotionLayout.setProgress(1.0f);
            } else {
                this.mMotionLayout.transitionToState(lookUpConstraintId);
                this.mMotionLayout.setProgress(1.0f);
            }
        }
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float f) {
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        motionLayout.setProgress(f);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(java.lang.String str, java.lang.String str2) {
        androidx.constraintlayout.motion.widget.MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        int lookUpConstraintId2 = this.mMotionLayout.lookUpConstraintId(str2);
        this.mMotionLayout.setTransition(lookUpConstraintId, lookUpConstraintId2);
        this.mLastStartStateId = lookUpConstraintId;
        this.mLastEndStateId = lookUpConstraintId2;
        this.mLastStartState = str;
        this.mLastEndState = str2;
    }

    public void setViewDebug(java.lang.Object obj, int i) {
        androidx.constraintlayout.motion.widget.MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController != null) {
            motionController.setDrawPath(i);
            this.mMotionLayout.invalidate();
        }
    }
}
