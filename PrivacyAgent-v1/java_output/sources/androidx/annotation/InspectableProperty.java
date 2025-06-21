package androidx.annotation;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.Deprecated
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface InspectableProperty {

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface EnumEntry {
        java.lang.String name();

        int value();
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FlagEntry {
        int mask() default 0;

        java.lang.String name();

        int target();
    }

    public enum ValueType {
        NONE,
        INFERRED,
        INT_ENUM,
        INT_FLAG,
        COLOR,
        GRAVITY,
        RESOURCE_ID
    }

    int attributeId() default 0;

    androidx.annotation.InspectableProperty.EnumEntry[] enumMapping() default {};

    androidx.annotation.InspectableProperty.FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    java.lang.String name() default "";

    androidx.annotation.InspectableProperty.ValueType valueType() default androidx.annotation.InspectableProperty.ValueType.INFERRED;
}
