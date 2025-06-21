package org.apache.tools.ant.util.regexp;

/* loaded from: classes26.dex */
public class Jdk14RegexpRegexp extends org.apache.tools.ant.util.regexp.Jdk14RegexpMatcher implements org.apache.tools.ant.util.regexp.Regexp {
    public int getSubsOptions(int i) {
        return org.apache.tools.ant.util.regexp.RegexpUtil.hasFlag(i, 16) ? 16 : 1;
    }

    @Override // org.apache.tools.ant.util.regexp.Regexp
    public java.lang.String substitute(java.lang.String str, java.lang.String str2, int i) throws org.apache.tools.ant.BuildException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '$') {
                stringBuffer.append('\\');
                stringBuffer.append(kotlin.text.Typography.dollar);
            } else if (charAt == '\\') {
                i2++;
                if (i2 < str2.length()) {
                    char charAt2 = str2.charAt(i2);
                    int digit = java.lang.Character.digit(charAt2, 10);
                    if (digit > -1) {
                        stringBuffer.append("$");
                        stringBuffer.append(digit);
                    } else {
                        stringBuffer.append(charAt2);
                    }
                } else {
                    stringBuffer.append('\\');
                }
            } else {
                stringBuffer.append(charAt);
            }
            i2++;
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        int subsOptions = getSubsOptions(i);
        java.util.regex.Pattern compiledPattern = getCompiledPattern(i);
        java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
        java.util.regex.Matcher matcher = compiledPattern.matcher(str);
        if (org.apache.tools.ant.util.regexp.RegexpUtil.hasFlag(subsOptions, 16)) {
            stringBuffer3.append(matcher.replaceAll(stringBuffer2));
        } else if (matcher.find()) {
            matcher.appendReplacement(stringBuffer3, stringBuffer2);
            matcher.appendTail(stringBuffer3);
        } else {
            stringBuffer3.append(str);
        }
        return stringBuffer3.toString();
    }
}
