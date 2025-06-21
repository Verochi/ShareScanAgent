package com.alibaba.fastjson.annotation;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JSONField {
    java.lang.String[] alternateNames() default {};

    boolean deserialize() default true;

    java.lang.String format() default "";

    java.lang.String name() default "";

    int ordinal() default 0;

    com.alibaba.fastjson.parser.Feature[] parseFeatures() default {};

    boolean serialize() default true;

    com.alibaba.fastjson.serializer.SerializerFeature[] serialzeFeatures() default {};
}
