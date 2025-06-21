package com.google.common.net;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class MediaType {
    public final java.lang.String a;
    public final java.lang.String b;
    public final com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.String> c;

    @com.google.errorprone.annotations.concurrent.LazyInit
    public java.lang.String d;

    @com.google.errorprone.annotations.concurrent.LazyInit
    public int e;

    @com.google.errorprone.annotations.concurrent.LazyInit
    public com.google.common.base.Optional<java.nio.charset.Charset> f;
    public static final com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.String> g = com.google.common.collect.ImmutableListMultimap.of("charset", com.google.common.base.Ascii.toLowerCase(com.google.common.base.Charsets.UTF_8.name()));
    public static final com.google.common.base.CharMatcher h = com.google.common.base.CharMatcher.ascii().and(com.google.common.base.CharMatcher.javaIsoControl().negate()).and(com.google.common.base.CharMatcher.isNot(' ')).and(com.google.common.base.CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    public static final com.google.common.base.CharMatcher i = com.google.common.base.CharMatcher.ascii().and(com.google.common.base.CharMatcher.noneOf("\"\\\r"));
    public static final com.google.common.base.CharMatcher j = com.google.common.base.CharMatcher.anyOf(" \t\r\n");
    public static final java.util.Map<com.google.common.net.MediaType, com.google.common.net.MediaType> k = com.google.common.collect.Maps.newHashMap();
    public static final com.google.common.net.MediaType ANY_TYPE = f("*", "*");
    public static final com.google.common.net.MediaType ANY_TEXT_TYPE = f("text", "*");
    public static final com.google.common.net.MediaType ANY_IMAGE_TYPE = f("image", "*");
    public static final com.google.common.net.MediaType ANY_AUDIO_TYPE = f("audio", "*");
    public static final com.google.common.net.MediaType ANY_VIDEO_TYPE = f("video", "*");
    public static final com.google.common.net.MediaType ANY_APPLICATION_TYPE = f("application", "*");
    public static final com.google.common.net.MediaType CACHE_MANIFEST_UTF_8 = g("text", "cache-manifest");
    public static final com.google.common.net.MediaType CSS_UTF_8 = g("text", "css");
    public static final com.google.common.net.MediaType CSV_UTF_8 = g("text", "csv");
    public static final com.google.common.net.MediaType HTML_UTF_8 = g("text", com.baidu.mobads.sdk.internal.a.f);
    public static final com.google.common.net.MediaType I_CALENDAR_UTF_8 = g("text", "calendar");
    public static final com.google.common.net.MediaType PLAIN_TEXT_UTF_8 = g("text", org.apache.tools.ant.taskdefs.email.EmailTask.PLAIN);
    public static final com.google.common.net.MediaType TEXT_JAVASCRIPT_UTF_8 = g("text", "javascript");
    public static final com.google.common.net.MediaType TSV_UTF_8 = g("text", "tab-separated-values");
    public static final com.google.common.net.MediaType VCARD_UTF_8 = g("text", "vcard");
    public static final com.google.common.net.MediaType WML_UTF_8 = g("text", "vnd.wap.wml");
    public static final com.google.common.net.MediaType XML_UTF_8 = g("text", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML);
    public static final com.google.common.net.MediaType VTT_UTF_8 = g("text", "vtt");
    public static final com.google.common.net.MediaType BMP = f("image", "bmp");
    public static final com.google.common.net.MediaType CRW = f("image", "x-canon-crw");
    public static final com.google.common.net.MediaType GIF = f("image", "gif");
    public static final com.google.common.net.MediaType ICO = f("image", "vnd.microsoft.icon");
    public static final com.google.common.net.MediaType JPEG = f("image", com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG);
    public static final com.google.common.net.MediaType PNG = f("image", com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG);
    public static final com.google.common.net.MediaType PSD = f("image", "vnd.adobe.photoshop");
    public static final com.google.common.net.MediaType SVG_UTF_8 = g("image", "svg+xml");
    public static final com.google.common.net.MediaType TIFF = f("image", "tiff");
    public static final com.google.common.net.MediaType WEBP = f("image", "webp");
    public static final com.google.common.net.MediaType MP4_AUDIO = f("audio", "mp4");
    public static final com.google.common.net.MediaType MPEG_AUDIO = f("audio", "mpeg");
    public static final com.google.common.net.MediaType OGG_AUDIO = f("audio", "ogg");
    public static final com.google.common.net.MediaType WEBM_AUDIO = f("audio", "webm");
    public static final com.google.common.net.MediaType L16_AUDIO = f("audio", "l16");
    public static final com.google.common.net.MediaType L24_AUDIO = f("audio", "l24");
    public static final com.google.common.net.MediaType BASIC_AUDIO = f("audio", "basic");
    public static final com.google.common.net.MediaType AAC_AUDIO = f("audio", "aac");
    public static final com.google.common.net.MediaType VORBIS_AUDIO = f("audio", "vorbis");
    public static final com.google.common.net.MediaType WMA_AUDIO = f("audio", "x-ms-wma");
    public static final com.google.common.net.MediaType WAX_AUDIO = f("audio", "x-ms-wax");
    public static final com.google.common.net.MediaType VND_REAL_AUDIO = f("audio", "vnd.rn-realaudio");
    public static final com.google.common.net.MediaType VND_WAVE_AUDIO = f("audio", "vnd.wave");
    public static final com.google.common.net.MediaType MP4_VIDEO = f("video", "mp4");
    public static final com.google.common.net.MediaType MPEG_VIDEO = f("video", "mpeg");
    public static final com.google.common.net.MediaType OGG_VIDEO = f("video", "ogg");
    public static final com.google.common.net.MediaType QUICKTIME = f("video", "quicktime");
    public static final com.google.common.net.MediaType WEBM_VIDEO = f("video", "webm");
    public static final com.google.common.net.MediaType WMV = f("video", "x-ms-wmv");
    public static final com.google.common.net.MediaType FLV_VIDEO = f("video", "x-flv");
    public static final com.google.common.net.MediaType THREE_GPP_VIDEO = f("video", "3gpp");
    public static final com.google.common.net.MediaType THREE_GPP2_VIDEO = f("video", "3gpp2");
    public static final com.google.common.net.MediaType APPLICATION_XML_UTF_8 = g("application", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML);
    public static final com.google.common.net.MediaType ATOM_UTF_8 = g("application", "atom+xml");
    public static final com.google.common.net.MediaType BZIP2 = f("application", "x-bzip2");
    public static final com.google.common.net.MediaType DART_UTF_8 = g("application", "dart");
    public static final com.google.common.net.MediaType APPLE_PASSBOOK = f("application", "vnd.apple.pkpass");
    public static final com.google.common.net.MediaType EOT = f("application", "vnd.ms-fontobject");
    public static final com.google.common.net.MediaType EPUB = f("application", "epub+zip");
    public static final com.google.common.net.MediaType FORM_DATA = f("application", "x-www-form-urlencoded");
    public static final com.google.common.net.MediaType KEY_ARCHIVE = f("application", "pkcs12");
    public static final com.google.common.net.MediaType APPLICATION_BINARY = f("application", "binary");
    public static final com.google.common.net.MediaType GZIP = f("application", "x-gzip");
    public static final com.google.common.net.MediaType HAL_JSON = f("application", "hal+json");
    public static final com.google.common.net.MediaType JAVASCRIPT_UTF_8 = g("application", "javascript");
    public static final com.google.common.net.MediaType JOSE = f("application", "jose");
    public static final com.google.common.net.MediaType JOSE_JSON = f("application", "jose+json");
    public static final com.google.common.net.MediaType JSON_UTF_8 = g("application", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
    public static final com.google.common.net.MediaType MANIFEST_JSON_UTF_8 = g("application", "manifest+json");
    public static final com.google.common.net.MediaType KML = f("application", "vnd.google-earth.kml+xml");
    public static final com.google.common.net.MediaType KMZ = f("application", "vnd.google-earth.kmz");
    public static final com.google.common.net.MediaType MBOX = f("application", "mbox");
    public static final com.google.common.net.MediaType APPLE_MOBILE_CONFIG = f("application", "x-apple-aspen-config");
    public static final com.google.common.net.MediaType MICROSOFT_EXCEL = f("application", "vnd.ms-excel");
    public static final com.google.common.net.MediaType MICROSOFT_OUTLOOK = f("application", "vnd.ms-outlook");
    public static final com.google.common.net.MediaType MICROSOFT_POWERPOINT = f("application", "vnd.ms-powerpoint");
    public static final com.google.common.net.MediaType MICROSOFT_WORD = f("application", "msword");
    public static final com.google.common.net.MediaType WASM_APPLICATION = f("application", "wasm");
    public static final com.google.common.net.MediaType NACL_APPLICATION = f("application", "x-nacl");
    public static final com.google.common.net.MediaType NACL_PORTABLE_APPLICATION = f("application", "x-pnacl");
    public static final com.google.common.net.MediaType OCTET_STREAM = f("application", "octet-stream");
    public static final com.google.common.net.MediaType OGG_CONTAINER = f("application", "ogg");
    public static final com.google.common.net.MediaType OOXML_DOCUMENT = f("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final com.google.common.net.MediaType OOXML_PRESENTATION = f("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final com.google.common.net.MediaType OOXML_SHEET = f("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final com.google.common.net.MediaType OPENDOCUMENT_GRAPHICS = f("application", "vnd.oasis.opendocument.graphics");
    public static final com.google.common.net.MediaType OPENDOCUMENT_PRESENTATION = f("application", "vnd.oasis.opendocument.presentation");
    public static final com.google.common.net.MediaType OPENDOCUMENT_SPREADSHEET = f("application", "vnd.oasis.opendocument.spreadsheet");
    public static final com.google.common.net.MediaType OPENDOCUMENT_TEXT = f("application", "vnd.oasis.opendocument.text");
    public static final com.google.common.net.MediaType PDF = f("application", "pdf");
    public static final com.google.common.net.MediaType POSTSCRIPT = f("application", "postscript");
    public static final com.google.common.net.MediaType PROTOBUF = f("application", "protobuf");
    public static final com.google.common.net.MediaType RDF_XML_UTF_8 = g("application", "rdf+xml");
    public static final com.google.common.net.MediaType RTF_UTF_8 = g("application", "rtf");
    public static final com.google.common.net.MediaType SFNT = f("application", "font-sfnt");
    public static final com.google.common.net.MediaType SHOCKWAVE_FLASH = f("application", "x-shockwave-flash");
    public static final com.google.common.net.MediaType SKETCHUP = f("application", "vnd.sketchup.skp");
    public static final com.google.common.net.MediaType SOAP_XML_UTF_8 = g("application", "soap+xml");
    public static final com.google.common.net.MediaType TAR = f("application", "x-tar");
    public static final com.google.common.net.MediaType WOFF = f("application", "font-woff");
    public static final com.google.common.net.MediaType WOFF2 = f("application", "font-woff2");
    public static final com.google.common.net.MediaType XHTML_UTF_8 = g("application", "xhtml+xml");
    public static final com.google.common.net.MediaType XRD_UTF_8 = g("application", "xrd+xml");
    public static final com.google.common.net.MediaType ZIP = f("application", "zip");
    public static final com.google.common.base.Joiner.MapJoiner l = com.google.common.base.Joiner.on("; ").withKeyValueSeparator(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: com.google.common.net.MediaType$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.common.base.Function<java.util.Collection<java.lang.String>, com.google.common.collect.ImmutableMultiset<java.lang.String>> {
        public AnonymousClass1() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.ImmutableMultiset<java.lang.String> apply(java.util.Collection<java.lang.String> collection) {
            return com.google.common.collect.ImmutableMultiset.copyOf(collection);
        }
    }

    /* renamed from: com.google.common.net.MediaType$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.common.base.Function<java.lang.String, java.lang.String> {
        public AnonymousClass2() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String apply(java.lang.String str) {
            return com.google.common.net.MediaType.h.matchesAllOf(str) ? str : com.google.common.net.MediaType.h(str);
        }
    }

    public static final class Tokenizer {
        public final java.lang.String a;
        public int b = 0;

        public Tokenizer(java.lang.String str) {
            this.a = str;
        }

        public char a(char c) {
            com.google.common.base.Preconditions.checkState(e());
            com.google.common.base.Preconditions.checkState(f() == c);
            this.b++;
            return c;
        }

        public char b(com.google.common.base.CharMatcher charMatcher) {
            com.google.common.base.Preconditions.checkState(e());
            char f = f();
            com.google.common.base.Preconditions.checkState(charMatcher.matches(f));
            this.b++;
            return f;
        }

        public java.lang.String c(com.google.common.base.CharMatcher charMatcher) {
            int i = this.b;
            java.lang.String d = d(charMatcher);
            com.google.common.base.Preconditions.checkState(this.b != i);
            return d;
        }

        public java.lang.String d(com.google.common.base.CharMatcher charMatcher) {
            com.google.common.base.Preconditions.checkState(e());
            int i = this.b;
            this.b = charMatcher.negate().indexIn(this.a, i);
            return e() ? this.a.substring(i, this.b) : this.a.substring(i);
        }

        public boolean e() {
            int i = this.b;
            return i >= 0 && i < this.a.length();
        }

        public char f() {
            com.google.common.base.Preconditions.checkState(e());
            return this.a.charAt(this.b);
        }
    }

    public MediaType(java.lang.String str, java.lang.String str2, com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.String> immutableListMultimap) {
        this.a = str;
        this.b = str2;
        this.c = immutableListMultimap;
    }

    public static com.google.common.net.MediaType c(com.google.common.net.MediaType mediaType) {
        k.put(mediaType, mediaType);
        return mediaType;
    }

    public static com.google.common.net.MediaType create(java.lang.String str, java.lang.String str2) {
        com.google.common.net.MediaType e = e(str, str2, com.google.common.collect.ImmutableListMultimap.of());
        e.f = com.google.common.base.Optional.absent();
        return e;
    }

    public static com.google.common.net.MediaType e(java.lang.String str, java.lang.String str2, com.google.common.collect.Multimap<java.lang.String, java.lang.String> multimap) {
        com.google.common.base.Preconditions.checkNotNull(str);
        com.google.common.base.Preconditions.checkNotNull(str2);
        com.google.common.base.Preconditions.checkNotNull(multimap);
        java.lang.String j2 = j(str);
        java.lang.String j3 = j(str2);
        com.google.common.base.Preconditions.checkArgument(!"*".equals(j2) || "*".equals(j3), "A wildcard type cannot be used with a non-wildcard subtype");
        com.google.common.collect.ImmutableListMultimap.Builder builder = com.google.common.collect.ImmutableListMultimap.builder();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : multimap.entries()) {
            java.lang.String j4 = j(entry.getKey());
            builder.put((com.google.common.collect.ImmutableListMultimap.Builder) j4, i(j4, entry.getValue()));
        }
        com.google.common.net.MediaType mediaType = new com.google.common.net.MediaType(j2, j3, builder.build());
        return (com.google.common.net.MediaType) com.google.common.base.MoreObjects.firstNonNull(k.get(mediaType), mediaType);
    }

    public static com.google.common.net.MediaType f(java.lang.String str, java.lang.String str2) {
        com.google.common.net.MediaType c = c(new com.google.common.net.MediaType(str, str2, com.google.common.collect.ImmutableListMultimap.of()));
        c.f = com.google.common.base.Optional.absent();
        return c;
    }

    public static com.google.common.net.MediaType g(java.lang.String str, java.lang.String str2) {
        com.google.common.net.MediaType c = c(new com.google.common.net.MediaType(str, str2, g));
        c.f = com.google.common.base.Optional.of(com.google.common.base.Charsets.UTF_8);
        return c;
    }

    public static java.lang.String h(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 16);
        sb.append(kotlin.text.Typography.quote);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append(kotlin.text.Typography.quote);
        return sb.toString();
    }

    public static java.lang.String i(java.lang.String str, java.lang.String str2) {
        return "charset".equals(str) ? com.google.common.base.Ascii.toLowerCase(str2) : str2;
    }

    public static java.lang.String j(java.lang.String str) {
        com.google.common.base.Preconditions.checkArgument(h.matchesAllOf(str));
        return com.google.common.base.Ascii.toLowerCase(str);
    }

    public static com.google.common.net.MediaType parse(java.lang.String str) {
        java.lang.String c;
        com.google.common.base.Preconditions.checkNotNull(str);
        com.google.common.net.MediaType.Tokenizer tokenizer = new com.google.common.net.MediaType.Tokenizer(str);
        try {
            com.google.common.base.CharMatcher charMatcher = h;
            java.lang.String c2 = tokenizer.c(charMatcher);
            tokenizer.a('/');
            java.lang.String c3 = tokenizer.c(charMatcher);
            com.google.common.collect.ImmutableListMultimap.Builder builder = com.google.common.collect.ImmutableListMultimap.builder();
            while (tokenizer.e()) {
                com.google.common.base.CharMatcher charMatcher2 = j;
                tokenizer.d(charMatcher2);
                tokenizer.a(';');
                tokenizer.d(charMatcher2);
                com.google.common.base.CharMatcher charMatcher3 = h;
                java.lang.String c4 = tokenizer.c(charMatcher3);
                tokenizer.a(com.alipay.sdk.m.n.a.h);
                if ('\"' == tokenizer.f()) {
                    tokenizer.a(kotlin.text.Typography.quote);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while ('\"' != tokenizer.f()) {
                        if ('\\' == tokenizer.f()) {
                            tokenizer.a('\\');
                            sb.append(tokenizer.b(com.google.common.base.CharMatcher.ascii()));
                        } else {
                            sb.append(tokenizer.c(i));
                        }
                    }
                    c = sb.toString();
                    tokenizer.a(kotlin.text.Typography.quote);
                } else {
                    c = tokenizer.c(charMatcher3);
                }
                builder.put((com.google.common.collect.ImmutableListMultimap.Builder) c4, c);
            }
            return e(c2, c3, builder.build());
        } catch (java.lang.IllegalStateException e) {
            throw new java.lang.IllegalArgumentException("Could not parse '" + str + "'", e);
        }
    }

    public com.google.common.base.Optional<java.nio.charset.Charset> charset() {
        com.google.common.base.Optional<java.nio.charset.Charset> optional = this.f;
        if (optional == null) {
            optional = com.google.common.base.Optional.absent();
            com.google.common.collect.UnmodifiableIterator<java.lang.String> it = this.c.get((com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.String>) "charset").iterator();
            java.lang.String str = null;
            while (it.hasNext()) {
                java.lang.String next = it.next();
                if (str == null) {
                    optional = com.google.common.base.Optional.of(java.nio.charset.Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    throw new java.lang.IllegalStateException("Multiple charset values defined: " + str + ", " + next);
                }
            }
            this.f = optional;
        }
        return optional;
    }

    public final java.lang.String d() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a);
        sb.append('/');
        sb.append(this.b);
        if (!this.c.isEmpty()) {
            sb.append("; ");
            l.appendTo(sb, com.google.common.collect.Multimaps.transformValues((com.google.common.collect.ListMultimap) this.c, (com.google.common.base.Function) new com.google.common.net.MediaType.AnonymousClass2()).entries());
        }
        return sb.toString();
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.net.MediaType)) {
            return false;
        }
        com.google.common.net.MediaType mediaType = (com.google.common.net.MediaType) obj;
        return this.a.equals(mediaType.a) && this.b.equals(mediaType.b) && k().equals(mediaType.k());
    }

    public boolean hasWildcard() {
        return "*".equals(this.a) || "*".equals(this.b);
    }

    public int hashCode() {
        int i2 = this.e;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = com.google.common.base.Objects.hashCode(this.a, this.b, k());
        this.e = hashCode;
        return hashCode;
    }

    public boolean is(com.google.common.net.MediaType mediaType) {
        return (mediaType.a.equals("*") || mediaType.a.equals(this.a)) && (mediaType.b.equals("*") || mediaType.b.equals(this.b)) && this.c.entries().containsAll(mediaType.c.entries());
    }

    public final java.util.Map<java.lang.String, com.google.common.collect.ImmutableMultiset<java.lang.String>> k() {
        return com.google.common.collect.Maps.transformValues(this.c.asMap(), new com.google.common.net.MediaType.AnonymousClass1());
    }

    public com.google.common.collect.ImmutableListMultimap<java.lang.String, java.lang.String> parameters() {
        return this.c;
    }

    public java.lang.String subtype() {
        return this.b;
    }

    public java.lang.String toString() {
        java.lang.String str = this.d;
        if (str != null) {
            return str;
        }
        java.lang.String d = d();
        this.d = d;
        return d;
    }

    public java.lang.String type() {
        return this.a;
    }

    public com.google.common.net.MediaType withCharset(java.nio.charset.Charset charset) {
        com.google.common.base.Preconditions.checkNotNull(charset);
        com.google.common.net.MediaType withParameter = withParameter("charset", charset.name());
        withParameter.f = com.google.common.base.Optional.of(charset);
        return withParameter;
    }

    public com.google.common.net.MediaType withParameter(java.lang.String str, java.lang.String str2) {
        return withParameters(str, com.google.common.collect.ImmutableSet.of(str2));
    }

    public com.google.common.net.MediaType withParameters(com.google.common.collect.Multimap<java.lang.String, java.lang.String> multimap) {
        return e(this.a, this.b, multimap);
    }

    public com.google.common.net.MediaType withParameters(java.lang.String str, java.lang.Iterable<java.lang.String> iterable) {
        com.google.common.base.Preconditions.checkNotNull(str);
        com.google.common.base.Preconditions.checkNotNull(iterable);
        java.lang.String j2 = j(str);
        com.google.common.collect.ImmutableListMultimap.Builder builder = com.google.common.collect.ImmutableListMultimap.builder();
        com.google.common.collect.UnmodifiableIterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = this.c.entries().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<java.lang.String, java.lang.String> next = it.next();
            java.lang.String key = next.getKey();
            if (!j2.equals(key)) {
                builder.put((com.google.common.collect.ImmutableListMultimap.Builder) key, next.getValue());
            }
        }
        java.util.Iterator<java.lang.String> it2 = iterable.iterator();
        while (it2.hasNext()) {
            builder.put((com.google.common.collect.ImmutableListMultimap.Builder) j2, i(j2, it2.next()));
        }
        com.google.common.net.MediaType mediaType = new com.google.common.net.MediaType(this.a, this.b, builder.build());
        if (!j2.equals("charset")) {
            mediaType.f = this.f;
        }
        return (com.google.common.net.MediaType) com.google.common.base.MoreObjects.firstNonNull(k.get(mediaType), mediaType);
    }

    public com.google.common.net.MediaType withoutParameters() {
        return this.c.isEmpty() ? this : create(this.a, this.b);
    }
}
