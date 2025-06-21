package com.google.android.material.animation;

/* loaded from: classes22.dex */
public class MotionSpec {
    private static final java.lang.String TAG = "MotionSpec";
    private final androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.material.animation.MotionTiming> timings = new androidx.collection.SimpleArrayMap<>();
    private final androidx.collection.SimpleArrayMap<java.lang.String, android.animation.PropertyValuesHolder[]> propertyValues = new androidx.collection.SimpleArrayMap<>();

    private static void addInfoFromAnimator(@androidx.annotation.NonNull com.google.android.material.animation.MotionSpec motionSpec, android.animation.Animator animator) {
        if (animator instanceof android.animation.ObjectAnimator) {
            android.animation.ObjectAnimator objectAnimator = (android.animation.ObjectAnimator) animator;
            motionSpec.setPropertyValues(objectAnimator.getPropertyName(), objectAnimator.getValues());
            motionSpec.setTiming(objectAnimator.getPropertyName(), com.google.android.material.animation.MotionTiming.createFromAnimator(objectAnimator));
        } else {
            throw new java.lang.IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    @androidx.annotation.NonNull
    private android.animation.PropertyValuesHolder[] clonePropertyValuesHolder(@androidx.annotation.NonNull android.animation.PropertyValuesHolder[] propertyValuesHolderArr) {
        android.animation.PropertyValuesHolder[] propertyValuesHolderArr2 = new android.animation.PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i = 0; i < propertyValuesHolderArr.length; i++) {
            propertyValuesHolderArr2[i] = propertyValuesHolderArr[i].clone();
        }
        return propertyValuesHolderArr2;
    }

    @androidx.annotation.Nullable
    public static com.google.android.material.animation.MotionSpec createFromAttribute(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return createFromResource(context, resourceId);
    }

    @androidx.annotation.Nullable
    public static com.google.android.material.animation.MotionSpec createFromResource(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AnimatorRes int i) {
        try {
            android.animation.Animator loadAnimator = android.animation.AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof android.animation.AnimatorSet) {
                return createSpecFromAnimators(((android.animation.AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(loadAnimator);
            return createSpecFromAnimators(arrayList);
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Can't load animation resource ID #0x");
            sb.append(java.lang.Integer.toHexString(i));
            return null;
        }
    }

    @androidx.annotation.NonNull
    private static com.google.android.material.animation.MotionSpec createSpecFromAnimators(@androidx.annotation.NonNull java.util.List<android.animation.Animator> list) {
        com.google.android.material.animation.MotionSpec motionSpec = new com.google.android.material.animation.MotionSpec();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            addInfoFromAnimator(motionSpec, list.get(i));
        }
        return motionSpec;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.google.android.material.animation.MotionSpec) {
            return this.timings.equals(((com.google.android.material.animation.MotionSpec) obj).timings);
        }
        return false;
    }

    @androidx.annotation.NonNull
    public <T> android.animation.ObjectAnimator getAnimator(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull T t, @androidx.annotation.NonNull android.util.Property<T, ?> property) {
        android.animation.ObjectAnimator ofPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(t, getPropertyValues(str));
        ofPropertyValuesHolder.setProperty(property);
        getTiming(str).apply(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    @androidx.annotation.NonNull
    public android.animation.PropertyValuesHolder[] getPropertyValues(java.lang.String str) {
        if (hasPropertyValues(str)) {
            return clonePropertyValuesHolder(this.propertyValues.get(str));
        }
        throw new java.lang.IllegalArgumentException();
    }

    public com.google.android.material.animation.MotionTiming getTiming(java.lang.String str) {
        if (hasTiming(str)) {
            return this.timings.get(str);
        }
        throw new java.lang.IllegalArgumentException();
    }

    public long getTotalDuration() {
        int size = this.timings.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            com.google.android.material.animation.MotionTiming valueAt = this.timings.valueAt(i);
            j = java.lang.Math.max(j, valueAt.getDelay() + valueAt.getDuration());
        }
        return j;
    }

    public boolean hasPropertyValues(java.lang.String str) {
        return this.propertyValues.get(str) != null;
    }

    public boolean hasTiming(java.lang.String str) {
        return this.timings.get(str) != null;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public void setPropertyValues(java.lang.String str, android.animation.PropertyValuesHolder[] propertyValuesHolderArr) {
        this.propertyValues.put(str, propertyValuesHolderArr);
    }

    public void setTiming(java.lang.String str, @androidx.annotation.Nullable com.google.android.material.animation.MotionTiming motionTiming) {
        this.timings.put(str, motionTiming);
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return '\n' + getClass().getName() + '{' + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }
}
