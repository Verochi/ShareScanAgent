package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
abstract class BaseAnimatableValue<V, O> implements com.airbnb.lottie.model.animatable.AnimatableValue<V, O> {
    public final java.util.List<com.airbnb.lottie.value.Keyframe<V>> a;

    public BaseAnimatableValue(V v) {
        this(java.util.Collections.singletonList(new com.airbnb.lottie.value.Keyframe(v)));
    }

    public BaseAnimatableValue(java.util.List<com.airbnb.lottie.value.Keyframe<V>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public java.util.List<com.airbnb.lottie.value.Keyframe<V>> getKeyframes() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.a.isEmpty()) {
            return true;
        }
        return this.a.size() == 1 && this.a.get(0).isStatic();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(java.util.Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }
}
