package androidx.dynamicanimation.animation;

/* loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final java.lang.String mPropertyName;

    /* renamed from: androidx.dynamicanimation.animation.FloatPropertyCompat$1, reason: invalid class name */
    public static class AnonymousClass1 extends androidx.dynamicanimation.animation.FloatPropertyCompat<T> {
        final /* synthetic */ android.util.FloatProperty val$property;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, android.util.FloatProperty floatProperty) {
            super(str);
            this.val$property = floatProperty;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(T t) {
            java.lang.Object obj;
            obj = this.val$property.get(t);
            return ((java.lang.Float) obj).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(T t, float f) {
            this.val$property.setValue(t, f);
        }
    }

    public FloatPropertyCompat(java.lang.String str) {
        this.mPropertyName = str;
    }

    @androidx.annotation.RequiresApi(24)
    public static <T> androidx.dynamicanimation.animation.FloatPropertyCompat<T> createFloatPropertyCompat(android.util.FloatProperty<T> floatProperty) {
        java.lang.String name;
        name = floatProperty.getName();
        return new androidx.dynamicanimation.animation.FloatPropertyCompat.AnonymousClass1(name, floatProperty);
    }

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f);
}
