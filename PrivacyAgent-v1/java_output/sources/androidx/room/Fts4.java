package androidx.room;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@androidx.annotation.RequiresApi(16)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Fts4 {
    java.lang.Class<?> contentEntity() default java.lang.Object.class;

    java.lang.String languageId() default "";

    androidx.room.FtsOptions.MatchInfo matchInfo() default androidx.room.FtsOptions.MatchInfo.FTS4;

    java.lang.String[] notIndexed() default {};

    androidx.room.FtsOptions.Order order() default androidx.room.FtsOptions.Order.ASC;

    int[] prefix() default {};

    java.lang.String tokenizer() default "simple";

    java.lang.String[] tokenizerArgs() default {};
}
