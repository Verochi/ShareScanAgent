package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class ViewUtils {
    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String getXmlAttributeString(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.util.AttributeSet attributeSet, @androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.RecentlyNonNull boolean z2, @androidx.annotation.RecentlyNonNull java.lang.String str3) {
        java.lang.String attributeValue = attributeSet == null ? null : attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z) {
            java.lang.String substring = attributeValue.substring(8);
            java.lang.String packageName = context.getPackageName();
            android.util.TypedValue typedValue = new android.util.TypedValue();
            try {
                android.content.res.Resources resources = context.getResources();
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(packageName).length() + 8 + java.lang.String.valueOf(substring).length());
                sb.append(packageName);
                sb.append(":string/");
                sb.append(substring);
                resources.getValue(sb.toString(), typedValue, true);
            } catch (android.content.res.Resources.NotFoundException unused) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 30 + attributeValue.length());
                sb2.append("Could not find resource for ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(attributeValue);
            }
            java.lang.CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                attributeValue = charSequence.toString();
            } else {
                java.lang.String valueOf = java.lang.String.valueOf(typedValue);
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 28 + valueOf.length());
                sb3.append("Resource ");
                sb3.append(str2);
                sb3.append(" was not a string: ");
                sb3.append(valueOf);
            }
        }
        if (z2 && attributeValue == null) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 33);
            sb4.append("Required XML attribute \"");
            sb4.append(str2);
            sb4.append("\" missing");
        }
        return attributeValue;
    }
}
