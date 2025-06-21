package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "Lkotlin/text/Regex;", "b", "Lkotlin/text/Regex;", "value", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class ScreenFloatValueRegEx {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.text.ScreenFloatValueRegEx a = new kotlin.text.ScreenFloatValueRegEx();

    /* renamed from: b, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlin.text.Regex value;

    static {
        java.lang.String str = "[eE][+-]?(\\p{Digit}+)";
        value = new kotlin.text.Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
