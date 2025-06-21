package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
final class MetadataUtil {

    @androidx.annotation.VisibleForTesting
    public static final java.lang.String[] a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", com.google.common.net.HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.CommentFrame a(int i, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            java.lang.String readNullTerminatedString = parsableByteArray.readNullTerminatedString(readInt - 16);
            return new com.google.android.exoplayer2.metadata.id3.CommentFrame("und", readNullTerminatedString, readNullTerminatedString);
        }
        java.lang.String valueOf = java.lang.String.valueOf(com.google.android.exoplayer2.extractor.mp4.Atom.a(i));
        com.google.android.exoplayer2.util.Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new java.lang.String("Failed to parse comment attribute: "));
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.ApicFrame b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() != 1684108385) {
            com.google.android.exoplayer2.util.Log.w("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int b = com.google.android.exoplayer2.extractor.mp4.Atom.b(parsableByteArray.readInt());
        java.lang.String str = b == 13 ? "image/jpeg" : b == 14 ? "image/png" : null;
        if (str == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(41);
            sb.append("Unrecognized cover art flags: ");
            sb.append(b);
            com.google.android.exoplayer2.util.Log.w("MetadataUtil", sb.toString());
            return null;
        }
        parsableByteArray.skipBytes(4);
        int i = readInt - 16;
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new com.google.android.exoplayer2.metadata.id3.ApicFrame(str, null, 3, bArr);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata.Entry c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
        int readInt = parsableByteArray.readInt();
        int i = (readInt >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & readInt;
                if (i2 == 6516084) {
                    return a(readInt, parsableByteArray);
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return h(readInt, "TIT2", parsableByteArray);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return h(readInt, "TCOM", parsableByteArray);
                }
                if (i2 == 6578553) {
                    return h(readInt, "TDRC", parsableByteArray);
                }
                if (i2 == 4280916) {
                    return h(readInt, "TPE1", parsableByteArray);
                }
                if (i2 == 7630703) {
                    return h(readInt, "TSSE", parsableByteArray);
                }
                if (i2 == 6384738) {
                    return h(readInt, "TALB", parsableByteArray);
                }
                if (i2 == 7108978) {
                    return h(readInt, "USLT", parsableByteArray);
                }
                if (i2 == 6776174) {
                    return h(readInt, "TCON", parsableByteArray);
                }
                if (i2 == 6779504) {
                    return h(readInt, "TIT1", parsableByteArray);
                }
            } else {
                if (readInt == 1735291493) {
                    return g(parsableByteArray);
                }
                if (readInt == 1684632427) {
                    return d(readInt, "TPOS", parsableByteArray);
                }
                if (readInt == 1953655662) {
                    return d(readInt, "TRCK", parsableByteArray);
                }
                if (readInt == 1953329263) {
                    return i(readInt, "TBPM", parsableByteArray, true, false);
                }
                if (readInt == 1668311404) {
                    return i(readInt, "TCMP", parsableByteArray, true, true);
                }
                if (readInt == 1668249202) {
                    return b(parsableByteArray);
                }
                if (readInt == 1631670868) {
                    return h(readInt, "TPE2", parsableByteArray);
                }
                if (readInt == 1936682605) {
                    return h(readInt, "TSOT", parsableByteArray);
                }
                if (readInt == 1936679276) {
                    return h(readInt, "TSO2", parsableByteArray);
                }
                if (readInt == 1936679282) {
                    return h(readInt, "TSOA", parsableByteArray);
                }
                if (readInt == 1936679265) {
                    return h(readInt, "TSOP", parsableByteArray);
                }
                if (readInt == 1936679791) {
                    return h(readInt, "TSOC", parsableByteArray);
                }
                if (readInt == 1920233063) {
                    return i(readInt, "ITUNESADVISORY", parsableByteArray, false, false);
                }
                if (readInt == 1885823344) {
                    return i(readInt, "ITUNESGAPLESS", parsableByteArray, false, true);
                }
                if (readInt == 1936683886) {
                    return h(readInt, "TVSHOWSORT", parsableByteArray);
                }
                if (readInt == 1953919848) {
                    return h(readInt, "TVSHOW", parsableByteArray);
                }
                if (readInt == 757935405) {
                    return e(parsableByteArray, position);
                }
            }
            java.lang.String valueOf = java.lang.String.valueOf(com.google.android.exoplayer2.extractor.mp4.Atom.a(readInt));
            com.google.android.exoplayer2.util.Log.d("MetadataUtil", valueOf.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf) : new java.lang.String("Skipped unknown metadata entry: "));
            parsableByteArray.setPosition(position);
            return null;
        } finally {
            parsableByteArray.setPosition(position);
        }
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame d(int i, java.lang.String str, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && readInt >= 22) {
            parsableByteArray.skipBytes(10);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (readUnsignedShort > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(11);
                sb.append(readUnsignedShort);
                java.lang.String sb2 = sb.toString();
                int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    java.lang.String valueOf = java.lang.String.valueOf(sb2);
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, sb2);
            }
        }
        java.lang.String valueOf2 = java.lang.String.valueOf(com.google.android.exoplayer2.extractor.mp4.Atom.a(i));
        com.google.android.exoplayer2.util.Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new java.lang.String("Failed to parse index/count attribute: "));
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        java.lang.String str = null;
        java.lang.String str2 = null;
        int i2 = -1;
        int i3 = -1;
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (readInt2 == 1835360622) {
                str = parsableByteArray.readNullTerminatedString(readInt - 12);
            } else if (readInt2 == 1851878757) {
                str2 = parsableByteArray.readNullTerminatedString(readInt - 12);
            } else {
                if (readInt2 == 1684108385) {
                    i2 = position;
                    i3 = readInt;
                }
                parsableByteArray.skipBytes(readInt - 12);
            }
        }
        if (str == null || str2 == null || i2 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i2);
        parsableByteArray.skipBytes(16);
        return new com.google.android.exoplayer2.metadata.id3.InternalFrame(str, str2, parsableByteArray.readNullTerminatedString(i3 - 16));
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry f(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, java.lang.String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i) {
                return null;
            }
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1684108385) {
                int readInt2 = parsableByteArray.readInt();
                int readInt3 = parsableByteArray.readInt();
                int i2 = readInt - 16;
                byte[] bArr = new byte[i2];
                parsableByteArray.readBytes(bArr, 0, i2);
                return new com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry(str, bArr, readInt3, readInt2);
            }
            parsableByteArray.setPosition(position + readInt);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.lang.String str;
        int j = j(parsableByteArray);
        if (j > 0) {
            java.lang.String[] strArr = a;
            if (j <= strArr.length) {
                str = strArr[j - 1];
                if (str == null) {
                    return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame("TCON", null, str);
                }
                com.google.android.exoplayer2.util.Log.w("MetadataUtil", "Failed to parse standard genre code");
                return null;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame h(int i, java.lang.String str, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, parsableByteArray.readNullTerminatedString(readInt - 16));
        }
        java.lang.String valueOf = java.lang.String.valueOf(com.google.android.exoplayer2.extractor.mp4.Atom.a(i));
        com.google.android.exoplayer2.util.Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new java.lang.String("Failed to parse text attribute: "));
        return null;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame i(int i, java.lang.String str, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int j = j(parsableByteArray);
        if (z2) {
            j = java.lang.Math.min(1, j);
        }
        if (j >= 0) {
            return z ? new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(str, null, java.lang.Integer.toString(j)) : new com.google.android.exoplayer2.metadata.id3.CommentFrame("und", str, java.lang.Integer.toString(j));
        }
        java.lang.String valueOf = java.lang.String.valueOf(com.google.android.exoplayer2.extractor.mp4.Atom.a(i));
        com.google.android.exoplayer2.util.Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new java.lang.String("Failed to parse uint8 attribute: "));
        return null;
    }

    public static int j(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        com.google.android.exoplayer2.util.Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata2, com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder, com.google.android.exoplayer2.Format.Builder builder) {
        if (i == 1) {
            if (gaplessInfoHolder.hasGaplessInfo()) {
                builder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
            }
            if (metadata != null) {
                builder.setMetadata(metadata);
                return;
            }
            return;
        }
        if (i != 2 || metadata2 == null) {
            return;
        }
        for (int i2 = 0; i2 < metadata2.length(); i2++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata2.get(i2);
            if (entry instanceof com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry) {
                com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry mdtaMetadataEntry = (com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry) entry;
                if ("com.android.capture.fps".equals(mdtaMetadataEntry.key)) {
                    builder.setMetadata(new com.google.android.exoplayer2.metadata.Metadata(mdtaMetadataEntry));
                }
            }
        }
    }
}
