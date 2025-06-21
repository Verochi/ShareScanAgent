package kotlin.time;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\bA\b\u0087@\u0018\u0000  \u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002 \u0001B\u0015\b\u0000\u0012\u0006\u0010f\u001a\u00020\rø\u0001\u0001¢\u0006\u0005\b\u009f\u0001\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u001e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0019H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u001aJ\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0019H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0004J\r\u0010$\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0004J\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b%\u0010\u0004J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u009d\u0001\u00106\u001a\u00028\u0000\"\u0004\b\u0000\u0010*2u\u00103\u001aq\u0012\u0013\u0012\u00110\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(2\u0012\u0004\u0012\u00028\u00000+H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b4\u00105J\u0088\u0001\u00106\u001a\u00028\u0000\"\u0004\b\u0000\u0010*2`\u00103\u001a\\\u0012\u0013\u0012\u00110\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(2\u0012\u0004\u0012\u00028\u000007H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b4\u00108Js\u00106\u001a\u00028\u0000\"\u0004\b\u0000\u0010*2K\u00103\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(2\u0012\u0004\u0012\u00028\u000009H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b4\u0010:J^\u00106\u001a\u00028\u0000\"\u0004\b\u0000\u0010*26\u00103\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(2\u0012\u0004\u0012\u00028\u00000;H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b4\u0010<J\u0015\u0010A\u001a\u00020\u00192\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0015\u0010D\u001a\u00020\r2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bB\u0010CJ\u0015\u0010G\u001a\u00020\u00142\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bE\u0010FJ\u000f\u0010I\u001a\u00020\rH\u0007¢\u0006\u0004\bH\u0010\u0007J\u000f\u0010K\u001a\u00020\rH\u0007¢\u0006\u0004\bJ\u0010\u0007J\u000f\u0010O\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ?\u0010W\u001a\u00020V*\u00060Pj\u0002`Q2\u0006\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\u00142\u0006\u0010>\u001a\u00020L2\u0006\u0010U\u001a\u00020\u0002H\u0002¢\u0006\u0004\bW\u0010XJ\u001f\u0010O\u001a\u00020L2\u0006\u0010>\u001a\u00020=2\b\b\u0002\u0010Y\u001a\u00020\u0014¢\u0006\u0004\bM\u0010ZJ\r\u0010\\\u001a\u00020L¢\u0006\u0004\b[\u0010NJ\u0010\u0010_\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b]\u0010^J\u001a\u0010c\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010`HÖ\u0003¢\u0006\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\u0007R\u0014\u0010k\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0017\u0010m\u001a\u00020\u00008Fø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u001a\u0004\bl\u0010\u0007R\u001a\u0010q\u001a\u00020\u00148@X\u0081\u0004¢\u0006\f\u0012\u0004\bo\u0010p\u001a\u0004\bn\u0010^R\u001a\u0010t\u001a\u00020\u00148@X\u0081\u0004¢\u0006\f\u0012\u0004\bs\u0010p\u001a\u0004\br\u0010^R\u001a\u0010w\u001a\u00020\u00148@X\u0081\u0004¢\u0006\f\u0012\u0004\bv\u0010p\u001a\u0004\bu\u0010^R\u001a\u0010z\u001a\u00020\u00148@X\u0081\u0004¢\u0006\f\u0012\u0004\by\u0010p\u001a\u0004\bx\u0010^R\u001a\u0010~\u001a\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b}\u0010p\u001a\u0004\b{\u0010|R\u001c\u0010\u0081\u0001\u001a\u00020\u00198FX\u0087\u0004¢\u0006\r\u0012\u0005\b\u0080\u0001\u0010p\u001a\u0004\b\u007f\u0010|R\u001d\u0010\u0084\u0001\u001a\u00020\u00198FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0083\u0001\u0010p\u001a\u0005\b\u0082\u0001\u0010|R\u001d\u0010\u0087\u0001\u001a\u00020\u00198FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0086\u0001\u0010p\u001a\u0005\b\u0085\u0001\u0010|R\u001d\u0010\u008a\u0001\u001a\u00020\u00198FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0089\u0001\u0010p\u001a\u0005\b\u0088\u0001\u0010|R\u001d\u0010\u008d\u0001\u001a\u00020\u00198FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008c\u0001\u0010p\u001a\u0005\b\u008b\u0001\u0010|R\u001d\u0010\u0090\u0001\u001a\u00020\u00198FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008f\u0001\u0010p\u001a\u0005\b\u008e\u0001\u0010|R\u0013\u0010\u0092\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010\u0007R\u0013\u0010\u0094\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010\u0007R\u0013\u0010\u0096\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\u0007R\u0013\u0010\u0098\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u0007R\u0013\u0010\u009a\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u0010\u0007R\u0013\u0010\u009c\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010\u0007R\u0013\u0010\u009e\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010\u0007\u0088\u0001f\u0092\u0001\u00020\rø\u0001\u0001\u0082\u0002\u000f\n\u0002\b!\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006¡\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "", "f", "(J)Z", "e", "unaryMinus-UwyO8pc", "(J)J", "unaryMinus", "other", "plus-LRDsOJo", "(JJ)J", "plus", "", "thisMillis", "otherNanos", "a", "(JJJ)J", "minus-LRDsOJo", "minus", "", "scale", "times-UwyO8pc", "(JI)J", "times", "", "(JD)J", "div-UwyO8pc", "div", "div-LRDsOJo", "(JJ)D", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "compareTo-LRDsOJo", "(JJ)I", "compareTo", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/time/DurationUnit;", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toDouble", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLong", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toInt", "toLongNanoseconds-impl", "toLongNanoseconds", "toLongMilliseconds-impl", "toLongMilliseconds", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "", "b", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString-impl", "toIsoString", "hashCode-impl", "(J)I", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "J", "rawValue", "d", "value", "c", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "getHoursComponent$annotations", "()V", "hoursComponent", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "getInDays-impl", "(J)D", "getInDays$annotations", "inDays", "getInHours-impl", "getInHours$annotations", "inHours", "getInMinutes-impl", "getInMinutes$annotations", "inMinutes", "getInSeconds-impl", "getInSeconds$annotations", "inSeconds", "getInMilliseconds-impl", "getInMilliseconds$annotations", "inMilliseconds", "getInMicroseconds-impl", "getInMicroseconds$annotations", "inMicroseconds", "getInNanoseconds-impl", "getInNanoseconds$annotations", "inNanoseconds", "getInWholeDays-impl", "inWholeDays", "getInWholeHours-impl", "inWholeHours", "getInWholeMinutes-impl", "inWholeMinutes", "getInWholeSeconds-impl", "inWholeSeconds", "getInWholeMilliseconds-impl", "inWholeMilliseconds", "getInWholeMicroseconds-impl", "inWholeMicroseconds", "getInWholeNanoseconds-impl", "inWholeNanoseconds", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.jvm.JvmInline
@kotlin.WasExperimental(markerClass = {kotlin.time.ExperimentalTime.class})
/* loaded from: classes14.dex */
public final class Duration implements java.lang.Comparable<kotlin.time.Duration> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.time.Duration.Companion INSTANCE = new kotlin.time.Duration.Companion(null);
    public static final long t = m630constructorimpl(0);
    public static final long u;
    public static final long v;

    /* renamed from: n, reason: from kotlin metadata */
    public final long rawValue;

    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u00100J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u001d\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000eJ\u001d\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000bJ\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000fJ\u001d\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\u001d\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u001d\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ\u001d\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u001d\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u001d\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u001d\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ\u001d\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ\u001d\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u001d\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u001d\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u000eJ\u001d\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u001cø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u001cø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u001eJ\u001d\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u001cø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u001cø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010#R\u001d\u0010'\u001a\u00020\t8\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001d\u0010+\u001a\u00020\t8\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R \u0010-\u001a\u00020\t8\u0000X\u0080\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u00061"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "", "Lkotlin/time/Duration;", "nanoseconds-UwyO8pc", "(I)J", "nanoseconds", "", "(J)J", "(D)J", "microseconds-UwyO8pc", "microseconds", "milliseconds-UwyO8pc", "milliseconds", "seconds-UwyO8pc", "seconds", "minutes-UwyO8pc", "minutes", "hours-UwyO8pc", "hours", "days-UwyO8pc", "days", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parse", "parseIsoString-UwyO8pc", "parseIsoString", "parseOrNull-FghU774", "(Ljava/lang/String;)Lkotlin/time/Duration;", "parseOrNull", "parseIsoStringOrNull-FghU774", "parseIsoStringOrNull", "ZERO", "J", "getZERO-UwyO8pc", "()J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m680getDaysUwyO8pc$annotations(double d) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m681getDaysUwyO8pc$annotations(int i) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m682getDaysUwyO8pc$annotations(long j) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m683getHoursUwyO8pc$annotations(double d) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m684getHoursUwyO8pc$annotations(int i) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m685getHoursUwyO8pc$annotations(long j) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m686getMicrosecondsUwyO8pc$annotations(double d) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m687getMicrosecondsUwyO8pc$annotations(int i) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m688getMicrosecondsUwyO8pc$annotations(long j) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m689getMillisecondsUwyO8pc$annotations(double d) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m690getMillisecondsUwyO8pc$annotations(int i) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m691getMillisecondsUwyO8pc$annotations(long j) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m692getMinutesUwyO8pc$annotations(double d) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m693getMinutesUwyO8pc$annotations(int i) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m694getMinutesUwyO8pc$annotations(long j) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m695getNanosecondsUwyO8pc$annotations(double d) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m696getNanosecondsUwyO8pc$annotations(int i) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m697getNanosecondsUwyO8pc$annotations(long j) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m698getSecondsUwyO8pc$annotations(double d) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m699getSecondsUwyO8pc$annotations(int i) {
        }

        @kotlin.internal.InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m700getSecondsUwyO8pc$annotations(long j) {
        }

        @kotlin.time.ExperimentalTime
        public final double convert(double value, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit sourceUnit, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit targetUnit) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m701daysUwyO8pc(double value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.DAYS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m702daysUwyO8pc(int value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.DAYS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m703daysUwyO8pc(long value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.DAYS);
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m704getINFINITEUwyO8pc() {
            return kotlin.time.Duration.u;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m705getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return kotlin.time.Duration.v;
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m706getZEROUwyO8pc() {
            return kotlin.time.Duration.t;
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m707hoursUwyO8pc(double value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.HOURS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m708hoursUwyO8pc(int value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.HOURS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m709hoursUwyO8pc(long value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.HOURS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m710microsecondsUwyO8pc(double value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MICROSECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m711microsecondsUwyO8pc(int value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MICROSECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m712microsecondsUwyO8pc(long value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MICROSECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m713millisecondsUwyO8pc(double value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MILLISECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m714millisecondsUwyO8pc(int value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MILLISECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m715millisecondsUwyO8pc(long value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MILLISECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m716minutesUwyO8pc(double value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MINUTES);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m717minutesUwyO8pc(int value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MINUTES);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m718minutesUwyO8pc(long value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.MINUTES);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m719nanosecondsUwyO8pc(double value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.NANOSECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m720nanosecondsUwyO8pc(int value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.NANOSECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m721nanosecondsUwyO8pc(long value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.NANOSECONDS);
        }

        /* renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m722parseUwyO8pc(@org.jetbrains.annotations.NotNull java.lang.String value) {
            long h;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                h = kotlin.time.DurationKt.h(value, false);
                return h;
            } catch (java.lang.IllegalArgumentException e) {
                throw new java.lang.IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m723parseIsoStringUwyO8pc(@org.jetbrains.annotations.NotNull java.lang.String value) {
            long h;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                h = kotlin.time.DurationKt.h(value, true);
                return h;
            } catch (java.lang.IllegalArgumentException e) {
                throw new java.lang.IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        @org.jetbrains.annotations.Nullable
        /* renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final kotlin.time.Duration m724parseIsoStringOrNullFghU774(@org.jetbrains.annotations.NotNull java.lang.String value) {
            long h;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                h = kotlin.time.DurationKt.h(value, true);
                return kotlin.time.Duration.m628boximpl(h);
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }

        @org.jetbrains.annotations.Nullable
        /* renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final kotlin.time.Duration m725parseOrNullFghU774(@org.jetbrains.annotations.NotNull java.lang.String value) {
            long h;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                h = kotlin.time.DurationKt.h(value, false);
                return kotlin.time.Duration.m628boximpl(h);
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m726secondsUwyO8pc(double value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.SECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m727secondsUwyO8pc(int value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.SECONDS);
        }

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
        @kotlin.Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
        @kotlin.time.ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m728secondsUwyO8pc(long value) {
            return kotlin.time.DurationKt.toDuration(value, kotlin.time.DurationUnit.SECONDS);
        }
    }

    static {
        long b;
        long b2;
        b = kotlin.time.DurationKt.b(kotlin.time.DurationKt.MAX_MILLIS);
        u = b;
        b2 = kotlin.time.DurationKt.b(-4611686018427387903L);
        v = b2;
    }

    public /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    public static final long a(long j, long j2, long j3) {
        long g;
        long coerceIn;
        long b;
        long f;
        long f2;
        long d;
        g = kotlin.time.DurationKt.g(j3);
        long j4 = j2 + g;
        if (!new kotlin.ranges.LongRange(-4611686018426L, 4611686018426L).contains(j4)) {
            coerceIn = kotlin.ranges.RangesKt___RangesKt.coerceIn(j4, -4611686018427387903L, kotlin.time.DurationKt.MAX_MILLIS);
            b = kotlin.time.DurationKt.b(coerceIn);
            return b;
        }
        f = kotlin.time.DurationKt.f(g);
        long j5 = j3 - f;
        f2 = kotlin.time.DurationKt.f(j4);
        d = kotlin.time.DurationKt.d(f2 + j5);
        return d;
    }

    public static final void b(long j, java.lang.StringBuilder sb, int i, int i2, int i3, java.lang.String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            java.lang.String padStart = kotlin.text.StringsKt__StringsKt.padStart(java.lang.String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((java.lang.CharSequence) padStart, 0, ((i6 + 2) / 3) * 3);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((java.lang.CharSequence) padStart, 0, i6);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ kotlin.time.Duration m628boximpl(long j) {
        return new kotlin.time.Duration(j);
    }

    public static final kotlin.time.DurationUnit c(long j) {
        return f(j) ? kotlin.time.DurationUnit.NANOSECONDS : kotlin.time.DurationUnit.MILLISECONDS;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m629compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return kotlin.jvm.internal.Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m658isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m630constructorimpl(long j) {
        if (kotlin.time.DurationJvmKt.getDurationAssertionsEnabled()) {
            if (f(j)) {
                if (!new kotlin.ranges.LongRange(-4611686018426999999L, kotlin.time.DurationKt.MAX_NANOS).contains(d(j))) {
                    throw new java.lang.AssertionError(d(j) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new kotlin.ranges.LongRange(-4611686018427387903L, kotlin.time.DurationKt.MAX_MILLIS).contains(d(j))) {
                    throw new java.lang.AssertionError(d(j) + " ms is out of milliseconds range");
                }
                if (new kotlin.ranges.LongRange(-4611686018426L, 4611686018426L).contains(d(j))) {
                    throw new java.lang.AssertionError(d(j) + " ms is denormalized");
                }
            }
        }
        return j;
    }

    public static final long d(long j) {
        return j >> 1;
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m631divLRDsOJo(long j, long j2) {
        java.lang.Comparable maxOf;
        maxOf = kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt.maxOf(c(j), c(j2));
        kotlin.time.DurationUnit durationUnit = (kotlin.time.DurationUnit) maxOf;
        return m668toDoubleimpl(j, durationUnit) / m668toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m632divUwyO8pc(long j, double d) {
        int roundToInt;
        roundToInt = kotlin.math.MathKt__MathJVMKt.roundToInt(d);
        if ((((double) roundToInt) == d) && roundToInt != 0) {
            return m633divUwyO8pc(j, roundToInt);
        }
        kotlin.time.DurationUnit c = c(j);
        return kotlin.time.DurationKt.toDuration(m668toDoubleimpl(j, c) / d, c);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m633divUwyO8pc(long j, int i) {
        long b;
        long f;
        long f2;
        long d;
        int sign;
        long d2;
        if (i == 0) {
            if (m659isPositiveimpl(j)) {
                return u;
            }
            if (m658isNegativeimpl(j)) {
                return v;
            }
            throw new java.lang.IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (f(j)) {
            d2 = kotlin.time.DurationKt.d(d(j) / i);
            return d2;
        }
        if (m657isInfiniteimpl(j)) {
            sign = kotlin.math.MathKt__MathJVMKt.getSign(i);
            return m663timesUwyO8pc(j, sign);
        }
        long j2 = i;
        long d3 = d(j) / j2;
        if (!new kotlin.ranges.LongRange(-4611686018426L, 4611686018426L).contains(d3)) {
            b = kotlin.time.DurationKt.b(d3);
            return b;
        }
        f = kotlin.time.DurationKt.f(d(j) - (d3 * j2));
        f2 = kotlin.time.DurationKt.f(d3);
        d = kotlin.time.DurationKt.d(f2 + (f / j2));
        return d;
    }

    public static final boolean e(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m634equalsimpl(long j, java.lang.Object obj) {
        return (obj instanceof kotlin.time.Duration) && j == ((kotlin.time.Duration) obj).getRawValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m635equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static final boolean f(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m636getAbsoluteValueUwyO8pc(long j) {
        return m658isNegativeimpl(j) ? m677unaryMinusUwyO8pc(j) : j;
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m637getHoursComponentimpl(long j) {
        if (m657isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m646getInWholeHoursimpl(j) % 24);
    }

    @kotlin.Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @kotlin.ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    /* renamed from: getInDays-impl, reason: not valid java name */
    public static final double m638getInDaysimpl(long j) {
        return m668toDoubleimpl(j, kotlin.time.DurationUnit.DAYS);
    }

    @kotlin.Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @kotlin.ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    /* renamed from: getInHours-impl, reason: not valid java name */
    public static final double m639getInHoursimpl(long j) {
        return m668toDoubleimpl(j, kotlin.time.DurationUnit.HOURS);
    }

    @kotlin.Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @kotlin.ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    /* renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final double m640getInMicrosecondsimpl(long j) {
        return m668toDoubleimpl(j, kotlin.time.DurationUnit.MICROSECONDS);
    }

    @kotlin.Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @kotlin.ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    /* renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final double m641getInMillisecondsimpl(long j) {
        return m668toDoubleimpl(j, kotlin.time.DurationUnit.MILLISECONDS);
    }

    @kotlin.Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @kotlin.ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    /* renamed from: getInMinutes-impl, reason: not valid java name */
    public static final double m642getInMinutesimpl(long j) {
        return m668toDoubleimpl(j, kotlin.time.DurationUnit.MINUTES);
    }

    @kotlin.Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @kotlin.ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    /* renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final double m643getInNanosecondsimpl(long j) {
        return m668toDoubleimpl(j, kotlin.time.DurationUnit.NANOSECONDS);
    }

    @kotlin.Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @kotlin.ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    /* renamed from: getInSeconds-impl, reason: not valid java name */
    public static final double m644getInSecondsimpl(long j) {
        return m668toDoubleimpl(j, kotlin.time.DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m645getInWholeDaysimpl(long j) {
        return m671toLongimpl(j, kotlin.time.DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m646getInWholeHoursimpl(long j) {
        return m671toLongimpl(j, kotlin.time.DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m647getInWholeMicrosecondsimpl(long j) {
        return m671toLongimpl(j, kotlin.time.DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m648getInWholeMillisecondsimpl(long j) {
        return (e(j) && m656isFiniteimpl(j)) ? d(j) : m671toLongimpl(j, kotlin.time.DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m649getInWholeMinutesimpl(long j) {
        return m671toLongimpl(j, kotlin.time.DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m650getInWholeNanosecondsimpl(long j) {
        long f;
        long d = d(j);
        if (f(j)) {
            return d;
        }
        if (d > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (d < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        f = kotlin.time.DurationKt.f(d);
        return f;
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m651getInWholeSecondsimpl(long j) {
        return m671toLongimpl(j, kotlin.time.DurationUnit.SECONDS);
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m652getMinutesComponentimpl(long j) {
        if (m657isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m649getInWholeMinutesimpl(j) % 60);
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m653getNanosecondsComponentimpl(long j) {
        if (m657isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (e(j) ? kotlin.time.DurationKt.f(d(j) % 1000) : d(j) % com.airbnb.lottie.utils.Utils.SECOND_IN_NANOS);
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m654getSecondsComponentimpl(long j) {
        if (m657isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m651getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m655hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m656isFiniteimpl(long j) {
        return !m657isInfiniteimpl(j);
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m657isInfiniteimpl(long j) {
        return j == u || j == v;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m658isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m659isPositiveimpl(long j) {
        return j > 0;
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m660minusLRDsOJo(long j, long j2) {
        return m661plusLRDsOJo(j, m677unaryMinusUwyO8pc(j2));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m661plusLRDsOJo(long j, long j2) {
        long c;
        long e;
        if (m657isInfiniteimpl(j)) {
            if (m656isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new java.lang.IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m657isInfiniteimpl(j2)) {
            return j2;
        }
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return e(j) ? a(j, d(j), d(j2)) : a(j, d(j2), d(j));
        }
        long d = d(j) + d(j2);
        if (f(j)) {
            e = kotlin.time.DurationKt.e(d);
            return e;
        }
        c = kotlin.time.DurationKt.c(d);
        return c;
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m662timesUwyO8pc(long j, double d) {
        int roundToInt;
        roundToInt = kotlin.math.MathKt__MathJVMKt.roundToInt(d);
        if (((double) roundToInt) == d) {
            return m663timesUwyO8pc(j, roundToInt);
        }
        kotlin.time.DurationUnit c = c(j);
        return kotlin.time.DurationKt.toDuration(m668toDoubleimpl(j, c) * d, c);
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m663timesUwyO8pc(long j, int i) {
        int sign;
        int sign2;
        long coerceIn;
        long b;
        long g;
        long f;
        long g2;
        int sign3;
        int sign4;
        long coerceIn2;
        long b2;
        long e;
        long d;
        if (m657isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m677unaryMinusUwyO8pc(j);
            }
            throw new java.lang.IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return t;
        }
        long d2 = d(j);
        long j2 = i;
        long j3 = d2 * j2;
        if (!f(j)) {
            if (j3 / j2 == d2) {
                coerceIn = kotlin.ranges.RangesKt___RangesKt.coerceIn(j3, (kotlin.ranges.ClosedRange<java.lang.Long>) new kotlin.ranges.LongRange(-4611686018427387903L, kotlin.time.DurationKt.MAX_MILLIS));
                b = kotlin.time.DurationKt.b(coerceIn);
                return b;
            }
            sign = kotlin.math.MathKt__MathJVMKt.getSign(d2);
            sign2 = kotlin.math.MathKt__MathJVMKt.getSign(i);
            return sign * sign2 > 0 ? u : v;
        }
        if (new kotlin.ranges.LongRange(-2147483647L, 2147483647L).contains(d2)) {
            d = kotlin.time.DurationKt.d(j3);
            return d;
        }
        if (j3 / j2 == d2) {
            e = kotlin.time.DurationKt.e(j3);
            return e;
        }
        g = kotlin.time.DurationKt.g(d2);
        f = kotlin.time.DurationKt.f(g);
        long j4 = g * j2;
        g2 = kotlin.time.DurationKt.g((d2 - f) * j2);
        long j5 = g2 + j4;
        if (j4 / j2 != g || (j5 ^ j4) < 0) {
            sign3 = kotlin.math.MathKt__MathJVMKt.getSign(d2);
            sign4 = kotlin.math.MathKt__MathJVMKt.getSign(i);
            return sign3 * sign4 > 0 ? u : v;
        }
        coerceIn2 = kotlin.ranges.RangesKt___RangesKt.coerceIn(j5, (kotlin.ranges.ClosedRange<java.lang.Long>) new kotlin.ranges.LongRange(-4611686018427387903L, kotlin.time.DurationKt.MAX_MILLIS));
        b2 = kotlin.time.DurationKt.b(coerceIn2);
        return b2;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m664toComponentsimpl(long j, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.mo5invoke(java.lang.Long.valueOf(m651getInWholeSecondsimpl(j)), java.lang.Integer.valueOf(m653getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m665toComponentsimpl(long j, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Long, ? super java.lang.Integer, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(java.lang.Long.valueOf(m649getInWholeMinutesimpl(j)), java.lang.Integer.valueOf(m654getSecondsComponentimpl(j)), java.lang.Integer.valueOf(m653getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m666toComponentsimpl(long j, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super java.lang.Long, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(java.lang.Long.valueOf(m646getInWholeHoursimpl(j)), java.lang.Integer.valueOf(m652getMinutesComponentimpl(j)), java.lang.Integer.valueOf(m654getSecondsComponentimpl(j)), java.lang.Integer.valueOf(m653getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m667toComponentsimpl(long j, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function5<? super java.lang.Long, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(java.lang.Long.valueOf(m645getInWholeDaysimpl(j)), java.lang.Integer.valueOf(m637getHoursComponentimpl(j)), java.lang.Integer.valueOf(m652getMinutesComponentimpl(j)), java.lang.Integer.valueOf(m654getSecondsComponentimpl(j)), java.lang.Integer.valueOf(m653getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m668toDoubleimpl(long j, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == u) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == v) {
            return Double.NEGATIVE_INFINITY;
        }
        return kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d(j), c(j), unit);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m669toIntimpl(long j, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit) {
        long coerceIn;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        coerceIn = kotlin.ranges.RangesKt___RangesKt.coerceIn(m671toLongimpl(j, unit), -2147483648L, 2147483647L);
        return (int) coerceIn;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final java.lang.String m670toIsoStringimpl(long j) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (m658isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append(com.igexin.assist.sdk.AssistPushConsts.MSG_VALUE_PAYLOAD);
        long m636getAbsoluteValueUwyO8pc = m636getAbsoluteValueUwyO8pc(j);
        long m646getInWholeHoursimpl = m646getInWholeHoursimpl(m636getAbsoluteValueUwyO8pc);
        int m652getMinutesComponentimpl = m652getMinutesComponentimpl(m636getAbsoluteValueUwyO8pc);
        int m654getSecondsComponentimpl = m654getSecondsComponentimpl(m636getAbsoluteValueUwyO8pc);
        int m653getNanosecondsComponentimpl = m653getNanosecondsComponentimpl(m636getAbsoluteValueUwyO8pc);
        if (m657isInfiniteimpl(j)) {
            m646getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = true;
        boolean z2 = m646getInWholeHoursimpl != 0;
        boolean z3 = (m654getSecondsComponentimpl == 0 && m653getNanosecondsComponentimpl == 0) ? false : true;
        if (m652getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m646getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m652getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            b(j, sb, m654getSecondsComponentimpl, m653getNanosecondsComponentimpl, 9, androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, true);
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m671toLongimpl(long j, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == u) {
            return Long.MAX_VALUE;
        }
        if (j == v) {
            return Long.MIN_VALUE;
        }
        return kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d(j), c(j), unit);
    }

    @kotlin.Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @kotlin.time.ExperimentalTime
    /* renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final long m672toLongMillisecondsimpl(long j) {
        return m648getInWholeMillisecondsimpl(j);
    }

    @kotlin.Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @kotlin.time.ExperimentalTime
    /* renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final long m673toLongNanosecondsimpl(long j) {
        return m650getInWholeNanosecondsimpl(j);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m674toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == u) {
            return "Infinity";
        }
        if (j == v) {
            return "-Infinity";
        }
        boolean m658isNegativeimpl = m658isNegativeimpl(j);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (m658isNegativeimpl) {
            sb.append('-');
        }
        long m636getAbsoluteValueUwyO8pc = m636getAbsoluteValueUwyO8pc(j);
        long m645getInWholeDaysimpl = m645getInWholeDaysimpl(m636getAbsoluteValueUwyO8pc);
        int m637getHoursComponentimpl = m637getHoursComponentimpl(m636getAbsoluteValueUwyO8pc);
        int m652getMinutesComponentimpl = m652getMinutesComponentimpl(m636getAbsoluteValueUwyO8pc);
        int m654getSecondsComponentimpl = m654getSecondsComponentimpl(m636getAbsoluteValueUwyO8pc);
        int m653getNanosecondsComponentimpl = m653getNanosecondsComponentimpl(m636getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m645getInWholeDaysimpl != 0;
        boolean z2 = m637getHoursComponentimpl != 0;
        boolean z3 = m652getMinutesComponentimpl != 0;
        boolean z4 = (m654getSecondsComponentimpl == 0 && m653getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m645getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m637getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m652getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (m654getSecondsComponentimpl != 0 || z || z2 || z3) {
                b(j, sb, m654getSecondsComponentimpl, m653getNanosecondsComponentimpl, 9, "s", false);
            } else if (m653getNanosecondsComponentimpl >= 1000000) {
                b(j, sb, m653getNanosecondsComponentimpl / 1000000, m653getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (m653getNanosecondsComponentimpl >= 1000) {
                b(j, sb, m653getNanosecondsComponentimpl / 1000, m653getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m653getNanosecondsComponentimpl);
                sb.append(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE);
            }
            i = i4;
        }
        if (m658isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static final java.lang.String m675toStringimpl(long j, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit, int i) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(i >= 0)) {
            throw new java.lang.IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        }
        double m668toDoubleimpl = m668toDoubleimpl(j, unit);
        if (java.lang.Double.isInfinite(m668toDoubleimpl)) {
            return java.lang.String.valueOf(m668toDoubleimpl);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, 12);
        sb.append(kotlin.time.DurationJvmKt.formatToExactDecimals(m668toDoubleimpl, coerceAtMost));
        sb.append(kotlin.time.DurationUnitKt__DurationUnitKt.shortName(unit));
        return sb.toString();
    }

    /* renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ java.lang.String m676toStringimpl$default(long j, kotlin.time.DurationUnit durationUnit, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m675toStringimpl(j, durationUnit, i);
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m677unaryMinusUwyO8pc(long j) {
        long a;
        a = kotlin.time.DurationKt.a(-d(j), ((int) j) & 1);
        return a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(kotlin.time.Duration duration) {
        return m678compareToLRDsOJo(duration.getRawValue());
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m678compareToLRDsOJo(long j) {
        return m629compareToLRDsOJo(this.rawValue, j);
    }

    public boolean equals(java.lang.Object obj) {
        return m634equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m655hashCodeimpl(this.rawValue);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return m674toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }
}
