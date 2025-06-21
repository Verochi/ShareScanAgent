package com.airbnb.lottie.parser.moshi;

/* loaded from: classes.dex */
final class JsonUtf8Reader extends com.airbnb.lottie.parser.moshi.JsonReader {
    public static final okio.ByteString F = okio.ByteString.encodeUtf8("'\\");
    public static final okio.ByteString G = okio.ByteString.encodeUtf8("\"\\");
    public static final okio.ByteString H = okio.ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final okio.ByteString I = okio.ByteString.encodeUtf8("\n\r");
    public static final okio.ByteString J = okio.ByteString.encodeUtf8("*/");
    public final okio.Buffer A;
    public int B = 0;
    public long C;
    public int D;

    @androidx.annotation.Nullable
    public java.lang.String E;
    public final okio.BufferedSource z;

    public JsonUtf8Reader(okio.BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        this.z = bufferedSource;
        this.A = bufferedSource.buffer();
        b(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginArray() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 3) {
            b(1);
            this.v[this.n - 1] = 0;
            this.B = 0;
        } else {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginObject() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 1) {
            b(3);
            this.B = 0;
            return;
        }
        throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.B = 0;
        this.t[0] = 8;
        this.n = 1;
        this.A.clear();
        this.z.close();
    }

    public final void e() throws java.io.IOException {
        if (!this.w) {
            throw d("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endArray() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i != 4) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
        }
        int i2 = this.n - 1;
        this.n = i2;
        int[] iArr = this.v;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.B = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endObject() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i != 2) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
        }
        int i2 = this.n - 1;
        this.n = i2;
        this.u[i2] = null;
        int[] iArr = this.v;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.B = 0;
    }

    public final int f() throws java.io.IOException {
        int[] iArr = this.t;
        int i = this.n;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int i3 = i(true);
            this.A.readByte();
            if (i3 != 44) {
                if (i3 != 59) {
                    if (i3 != 93) {
                        throw d("Unterminated array");
                    }
                    this.B = 4;
                    return 4;
                }
                e();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int i4 = i(true);
                    this.A.readByte();
                    if (i4 != 44) {
                        if (i4 != 59) {
                            if (i4 != 125) {
                                throw d("Unterminated object");
                            }
                            this.B = 2;
                            return 2;
                        }
                        e();
                    }
                }
                int i5 = i(true);
                if (i5 == 34) {
                    this.A.readByte();
                    this.B = 13;
                    return 13;
                }
                if (i5 == 39) {
                    this.A.readByte();
                    e();
                    this.B = 12;
                    return 12;
                }
                if (i5 != 125) {
                    e();
                    if (!h((char) i5)) {
                        throw d("Expected name");
                    }
                    this.B = 14;
                    return 14;
                }
                if (i2 == 5) {
                    throw d("Expected name");
                }
                this.A.readByte();
                this.B = 2;
                return 2;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int i6 = i(true);
                this.A.readByte();
                if (i6 != 58) {
                    if (i6 != 61) {
                        throw d("Expected ':'");
                    }
                    e();
                    if (this.z.request(1L) && this.A.getByte(0L) == 62) {
                        this.A.readByte();
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (i(false) == -1) {
                    this.B = 18;
                    return 18;
                }
                e();
            } else if (i2 == 8) {
                throw new java.lang.IllegalStateException("JsonReader is closed");
            }
        }
        int i7 = i(true);
        if (i7 == 34) {
            this.A.readByte();
            this.B = 9;
            return 9;
        }
        if (i7 == 39) {
            e();
            this.A.readByte();
            this.B = 8;
            return 8;
        }
        if (i7 != 44 && i7 != 59) {
            if (i7 == 91) {
                this.A.readByte();
                this.B = 3;
                return 3;
            }
            if (i7 != 93) {
                if (i7 == 123) {
                    this.A.readByte();
                    this.B = 1;
                    return 1;
                }
                int l = l();
                if (l != 0) {
                    return l;
                }
                int m = m();
                if (m != 0) {
                    return m;
                }
                if (!h(this.A.getByte(0L))) {
                    throw d("Expected value");
                }
                e();
                this.B = 10;
                return 10;
            }
            if (i2 == 1) {
                this.A.readByte();
                this.B = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw d("Unexpected value");
        }
        e();
        this.B = 7;
        return 7;
    }

    public final int g(java.lang.String str, com.airbnb.lottie.parser.moshi.JsonReader.Options options) {
        int length = options.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.a[i])) {
                this.B = 0;
                this.u[this.n - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean h(int i) throws java.io.IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        e();
        return false;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean hasNext() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.A.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        e();
        q();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r6.z.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
    
        e();
        r3 = r6.A.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r6.A.readByte();
        r6.A.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        if (p() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        throw d("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        r6.A.readByte();
        r6.A.readByte();
        q();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003b, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int i(boolean z) throws java.io.IOException {
        while (true) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (!this.z.request(i2)) {
                    if (z) {
                        throw new java.io.EOFException("End of input");
                    }
                    return -1;
                }
                byte b = this.A.getByte(i);
                if (b != 10 && b != 32 && b != 13 && b != 9) {
                    break;
                }
                i = i2;
            }
        }
    }

    public final java.lang.String j(okio.ByteString byteString) throws java.io.IOException {
        java.lang.StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.z.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw d("Unterminated string");
            }
            if (this.A.getByte(indexOfElement) != 92) {
                if (sb == null) {
                    java.lang.String readUtf8 = this.A.readUtf8(indexOfElement);
                    this.A.readByte();
                    return readUtf8;
                }
                sb.append(this.A.readUtf8(indexOfElement));
                this.A.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new java.lang.StringBuilder();
            }
            sb.append(this.A.readUtf8(indexOfElement));
            this.A.readByte();
            sb.append(n());
        }
    }

    public final java.lang.String k() throws java.io.IOException {
        long indexOfElement = this.z.indexOfElement(H);
        return indexOfElement != -1 ? this.A.readUtf8(indexOfElement) : this.A.readUtf8();
    }

    public final int l() throws java.io.IOException {
        java.lang.String str;
        java.lang.String str2;
        int i;
        byte b = this.A.getByte(0L);
        if (b == 116 || b == 84) {
            str = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (b == 102 || b == 70) {
            str = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
            str2 = "FALSE";
            i = 6;
        } else {
            if (b != 110 && b != 78) {
                return 0;
            }
            str = com.igexin.push.core.b.m;
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.z.request(i3)) {
                return 0;
            }
            byte b2 = this.A.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.z.request(length + 1) && h(this.A.getByte(length))) {
            return 0;
        }
        this.A.skip(length);
        this.B = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (h(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.C = r8;
        r16.A.skip(r5);
        r16.B = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.D = r5;
        r16.B = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m() throws java.io.IOException {
        boolean z = true;
        long j = 0;
        int i = 0;
        char c = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i2 = i + 1;
            if (!this.z.request(i2)) {
                break;
            }
            byte b = this.A.getByte(i);
            if (b != 43) {
                if (b == 69 || b == 101) {
                    if (c != 2 && c != 4) {
                        return 0;
                    }
                    c = 5;
                } else if (b != 45) {
                    if (b != 46) {
                        if (b < 48 || b > 57) {
                            break;
                        }
                        if (c == z || c == 0) {
                            j = -(b - 48);
                            c = 2;
                        } else if (c == 2) {
                            if (j == 0) {
                                return 0;
                            }
                            long j2 = (10 * j) - (b - 48);
                            z2 &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                            j = j2;
                        } else if (c == 3) {
                            c = 4;
                        } else if (c == 5 || c == 6) {
                            c = 7;
                        }
                    } else {
                        if (c != 2) {
                            return 0;
                        }
                        c = 3;
                    }
                } else if (c == 0) {
                    c = 1;
                    z3 = true;
                } else if (c != 5) {
                    return 0;
                }
                i = i2;
                z = true;
            } else if (c != 5) {
                return 0;
            }
            c = 6;
            i = i2;
            z = true;
        }
    }

    public final char n() throws java.io.IOException {
        int i;
        int i2;
        if (!this.z.request(1L)) {
            throw d("Unterminated escape sequence");
        }
        byte readByte = this.A.readByte();
        if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
            return (char) readByte;
        }
        if (readByte == 98) {
            return '\b';
        }
        if (readByte == 102) {
            return '\f';
        }
        if (readByte == 110) {
            return '\n';
        }
        if (readByte == 114) {
            return '\r';
        }
        if (readByte == 116) {
            return '\t';
        }
        if (readByte != 117) {
            if (this.w) {
                return (char) readByte;
            }
            throw d("Invalid escape sequence: \\" + ((char) readByte));
        }
        if (!this.z.request(4L)) {
            throw new java.io.EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte b = this.A.getByte(i3);
            char c2 = (char) (c << 4);
            if (b < 48 || b > 57) {
                if (b >= 97 && b <= 102) {
                    i = b - 97;
                } else {
                    if (b < 65 || b > 70) {
                        throw d("\\u" + this.A.readUtf8(4L));
                    }
                    i = b - 65;
                }
                i2 = i + 10;
            } else {
                i2 = b - 48;
            }
            c = (char) (c2 + i2);
        }
        this.A.skip(4L);
        return c;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean nextBoolean() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 5) {
            this.B = 0;
            int[] iArr = this.v;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i == 6) {
            this.B = 0;
            int[] iArr2 = this.v;
            int i3 = this.n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double nextDouble() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 16) {
            this.B = 0;
            int[] iArr = this.v;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.C;
        }
        if (i == 17) {
            this.E = this.A.readUtf8(this.D);
        } else if (i == 9) {
            this.E = j(G);
        } else if (i == 8) {
            this.E = j(F);
        } else if (i == 10) {
            this.E = k();
        } else if (i != 11) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.B = 11;
        try {
            double parseDouble = java.lang.Double.parseDouble(this.E);
            if (this.w || !(java.lang.Double.isNaN(parseDouble) || java.lang.Double.isInfinite(parseDouble))) {
                this.E = null;
                this.B = 0;
                int[] iArr2 = this.v;
                int i3 = this.n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseDouble;
            }
            throw new com.airbnb.lottie.parser.moshi.JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (java.lang.NumberFormatException unused) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a double but was " + this.E + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int nextInt() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 16) {
            long j = this.C;
            int i2 = (int) j;
            if (j == i2) {
                this.B = 0;
                int[] iArr = this.v;
                int i3 = this.n - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected an int but was " + this.C + " at path " + getPath());
        }
        if (i == 17) {
            this.E = this.A.readUtf8(this.D);
        } else if (i == 9 || i == 8) {
            java.lang.String j2 = i == 9 ? j(G) : j(F);
            this.E = j2;
            try {
                int parseInt = java.lang.Integer.parseInt(j2);
                this.B = 0;
                int[] iArr2 = this.v;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (java.lang.NumberFormatException unused) {
            }
        } else if (i != 11) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
        }
        this.B = 11;
        try {
            double parseDouble = java.lang.Double.parseDouble(this.E);
            int i5 = (int) parseDouble;
            if (i5 == parseDouble) {
                this.E = null;
                this.B = 0;
                int[] iArr3 = this.v;
                int i6 = this.n - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected an int but was " + this.E + " at path " + getPath());
        } catch (java.lang.NumberFormatException unused2) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected an int but was " + this.E + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public java.lang.String nextName() throws java.io.IOException {
        java.lang.String str;
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 14) {
            str = k();
        } else if (i == 13) {
            str = j(G);
        } else if (i == 12) {
            str = j(F);
        } else {
            if (i != 15) {
                throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            str = this.E;
        }
        this.B = 0;
        this.u[this.n - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public java.lang.String nextString() throws java.io.IOException {
        java.lang.String readUtf8;
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 10) {
            readUtf8 = k();
        } else if (i == 9) {
            readUtf8 = j(G);
        } else if (i == 8) {
            readUtf8 = j(F);
        } else if (i == 11) {
            readUtf8 = this.E;
            this.E = null;
        } else if (i == 16) {
            readUtf8 = java.lang.Long.toString(this.C);
        } else {
            if (i != 17) {
                throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
            }
            readUtf8 = this.A.readUtf8(this.D);
        }
        this.B = 0;
        int[] iArr = this.v;
        int i2 = this.n - 1;
        iArr[i2] = iArr[i2] + 1;
        return readUtf8;
    }

    public final void o(okio.ByteString byteString) throws java.io.IOException {
        while (true) {
            long indexOfElement = this.z.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw d("Unterminated string");
            }
            if (this.A.getByte(indexOfElement) != 92) {
                this.A.skip(indexOfElement + 1);
                return;
            } else {
                this.A.skip(indexOfElement + 1);
                n();
            }
        }
    }

    public final boolean p() throws java.io.IOException {
        long indexOf = this.z.indexOf(J);
        boolean z = indexOf != -1;
        okio.Buffer buffer = this.A;
        buffer.skip(z ? indexOf + r1.size() : buffer.size());
        return z;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public com.airbnb.lottie.parser.moshi.JsonReader.Token peek() throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        switch (i) {
            case 1:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.END_OBJECT;
            case 3:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.BOOLEAN;
            case 7:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.NAME;
            case 16:
            case 17:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER;
            case 18:
                return com.airbnb.lottie.parser.moshi.JsonReader.Token.END_DOCUMENT;
            default:
                throw new java.lang.AssertionError();
        }
    }

    public final void q() throws java.io.IOException {
        long indexOfElement = this.z.indexOfElement(I);
        okio.Buffer buffer = this.A;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    public final void r() throws java.io.IOException {
        long indexOfElement = this.z.indexOfElement(H);
        okio.Buffer buffer = this.A;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int selectName(com.airbnb.lottie.parser.moshi.JsonReader.Options options) throws java.io.IOException {
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return g(this.E, options);
        }
        int select = this.z.select(options.b);
        if (select != -1) {
            this.B = 0;
            this.u[this.n - 1] = options.a[select];
            return select;
        }
        java.lang.String str = this.u[this.n - 1];
        java.lang.String nextName = nextName();
        int g = g(nextName, options);
        if (g == -1) {
            this.B = 15;
            this.E = nextName;
            this.u[this.n - 1] = str;
        }
        return g;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipName() throws java.io.IOException {
        if (this.x) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
        int i = this.B;
        if (i == 0) {
            i = f();
        }
        if (i == 14) {
            r();
        } else if (i == 13) {
            o(G);
        } else if (i == 12) {
            o(F);
        } else if (i != 15) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.B = 0;
        this.u[this.n - 1] = com.igexin.push.core.b.m;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipValue() throws java.io.IOException {
        if (this.x) {
            throw new com.airbnb.lottie.parser.moshi.JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
        int i = 0;
        do {
            int i2 = this.B;
            if (i2 == 0) {
                i2 = f();
            }
            if (i2 == 3) {
                b(1);
            } else if (i2 == 1) {
                b(3);
            } else {
                if (i2 == 4) {
                    i--;
                    if (i < 0) {
                        throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.n--;
                } else if (i2 == 2) {
                    i--;
                    if (i < 0) {
                        throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.n--;
                } else if (i2 == 14 || i2 == 10) {
                    r();
                } else if (i2 == 9 || i2 == 13) {
                    o(G);
                } else if (i2 == 8 || i2 == 12) {
                    o(F);
                } else if (i2 == 17) {
                    this.A.skip(this.D);
                } else if (i2 == 18) {
                    throw new com.airbnb.lottie.parser.moshi.JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                }
                this.B = 0;
            }
            i++;
            this.B = 0;
        } while (i != 0);
        int[] iArr = this.v;
        int i3 = this.n;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.u[i3 - 1] = com.igexin.push.core.b.m;
    }

    public java.lang.String toString() {
        return "JsonReader(" + this.z + ")";
    }
}
