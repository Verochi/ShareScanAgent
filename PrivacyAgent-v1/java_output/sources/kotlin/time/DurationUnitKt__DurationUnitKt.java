package kotlin.time;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0001\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0001¨\u0006\t"}, d2 = {"durationUnitByIsoChar", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes14.dex */
class DurationUnitKt__DurationUnitKt extends kotlin.time.DurationUnitKt__DurationUnitJvmKt {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.time.DurationUnit.values().length];
            iArr[kotlin.time.DurationUnit.NANOSECONDS.ordinal()] = 1;
            iArr[kotlin.time.DurationUnit.MICROSECONDS.ordinal()] = 2;
            iArr[kotlin.time.DurationUnit.MILLISECONDS.ordinal()] = 3;
            iArr[kotlin.time.DurationUnit.SECONDS.ordinal()] = 4;
            iArr[kotlin.time.DurationUnit.MINUTES.ordinal()] = 5;
            iArr[kotlin.time.DurationUnit.HOURS.ordinal()] = 6;
            iArr[kotlin.time.DurationUnit.DAYS.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    public static final kotlin.time.DurationUnit durationUnitByIsoChar(char c, boolean z) {
        if (!z) {
            if (c == 'D') {
                return kotlin.time.DurationUnit.DAYS;
            }
            throw new java.lang.IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c);
        }
        if (c == 'H') {
            return kotlin.time.DurationUnit.HOURS;
        }
        if (c == 'M') {
            return kotlin.time.DurationUnit.MINUTES;
        }
        if (c == 'S') {
            return kotlin.time.DurationUnit.SECONDS;
        }
        throw new java.lang.IllegalArgumentException("Invalid duration ISO time unit: " + c);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    public static final kotlin.time.DurationUnit durationUnitByShortName(@org.jetbrains.annotations.NotNull java.lang.String shortName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shortName, "shortName");
        int hashCode = shortName.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && shortName.equals("us")) {
                                    return kotlin.time.DurationUnit.MICROSECONDS;
                                }
                            } else if (shortName.equals(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE)) {
                                return kotlin.time.DurationUnit.NANOSECONDS;
                            }
                        } else if (shortName.equals("ms")) {
                            return kotlin.time.DurationUnit.MILLISECONDS;
                        }
                    } else if (shortName.equals("s")) {
                        return kotlin.time.DurationUnit.SECONDS;
                    }
                } else if (shortName.equals(com.anythink.expressad.d.a.b.dH)) {
                    return kotlin.time.DurationUnit.MINUTES;
                }
            } else if (shortName.equals("h")) {
                return kotlin.time.DurationUnit.HOURS;
            }
        } else if (shortName.equals("d")) {
            return kotlin.time.DurationUnit.DAYS;
        }
        throw new java.lang.IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String shortName(@org.jetbrains.annotations.NotNull kotlin.time.DurationUnit durationUnit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(durationUnit, "<this>");
        switch (kotlin.time.DurationUnitKt__DurationUnitKt.WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE;
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return com.anythink.expressad.d.a.b.dH;
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new java.lang.IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }
}
