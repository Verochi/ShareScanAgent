package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public class ProgramInformation {

    @androidx.annotation.Nullable
    public final java.lang.String copyright;

    @androidx.annotation.Nullable
    public final java.lang.String lang;

    @androidx.annotation.Nullable
    public final java.lang.String moreInformationURL;

    @androidx.annotation.Nullable
    public final java.lang.String source;

    @androidx.annotation.Nullable
    public final java.lang.String title;

    public ProgramInformation(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable java.lang.String str5) {
        this.title = str;
        this.source = str2;
        this.copyright = str3;
        this.moreInformationURL = str4;
        this.lang = str5;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation = (com.google.android.exoplayer2.source.dash.manifest.ProgramInformation) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.title, programInformation.title) && com.google.android.exoplayer2.util.Util.areEqual(this.source, programInformation.source) && com.google.android.exoplayer2.util.Util.areEqual(this.copyright, programInformation.copyright) && com.google.android.exoplayer2.util.Util.areEqual(this.moreInformationURL, programInformation.moreInformationURL) && com.google.android.exoplayer2.util.Util.areEqual(this.lang, programInformation.lang);
    }

    public int hashCode() {
        java.lang.String str = this.title;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.source;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.copyright;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        java.lang.String str4 = this.moreInformationURL;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        java.lang.String str5 = this.lang;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
