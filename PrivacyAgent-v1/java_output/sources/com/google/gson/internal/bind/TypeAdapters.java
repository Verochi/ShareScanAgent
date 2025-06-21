package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class TypeAdapters {
    public static final com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicBoolean> ATOMIC_BOOLEAN;
    public static final com.google.gson.TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicInteger> ATOMIC_INTEGER;
    public static final com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final com.google.gson.TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final com.google.gson.TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final com.google.gson.TypeAdapter<java.math.BigDecimal> BIG_DECIMAL;
    public static final com.google.gson.TypeAdapter<java.math.BigInteger> BIG_INTEGER;
    public static final com.google.gson.TypeAdapter<java.util.BitSet> BIT_SET;
    public static final com.google.gson.TypeAdapterFactory BIT_SET_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Boolean> BOOLEAN;
    public static final com.google.gson.TypeAdapter<java.lang.Boolean> BOOLEAN_AS_STRING;
    public static final com.google.gson.TypeAdapterFactory BOOLEAN_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Number> BYTE;
    public static final com.google.gson.TypeAdapterFactory BYTE_FACTORY;
    public static final com.google.gson.TypeAdapter<java.util.Calendar> CALENDAR;
    public static final com.google.gson.TypeAdapterFactory CALENDAR_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Character> CHARACTER;
    public static final com.google.gson.TypeAdapterFactory CHARACTER_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Class> CLASS;
    public static final com.google.gson.TypeAdapterFactory CLASS_FACTORY;
    public static final com.google.gson.TypeAdapter<java.util.Currency> CURRENCY;
    public static final com.google.gson.TypeAdapterFactory CURRENCY_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Number> DOUBLE;
    public static final com.google.gson.TypeAdapterFactory ENUM_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Number> FLOAT;
    public static final com.google.gson.TypeAdapter<java.net.InetAddress> INET_ADDRESS;
    public static final com.google.gson.TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Number> INTEGER;
    public static final com.google.gson.TypeAdapterFactory INTEGER_FACTORY;
    public static final com.google.gson.TypeAdapter<com.google.gson.JsonElement> JSON_ELEMENT;
    public static final com.google.gson.TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final com.google.gson.TypeAdapter<java.util.Locale> LOCALE;
    public static final com.google.gson.TypeAdapterFactory LOCALE_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Number> LONG;
    public static final com.google.gson.TypeAdapter<java.lang.Number> NUMBER;
    public static final com.google.gson.TypeAdapterFactory NUMBER_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.Number> SHORT;
    public static final com.google.gson.TypeAdapterFactory SHORT_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.String> STRING;
    public static final com.google.gson.TypeAdapter<java.lang.StringBuffer> STRING_BUFFER;
    public static final com.google.gson.TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final com.google.gson.TypeAdapter<java.lang.StringBuilder> STRING_BUILDER;
    public static final com.google.gson.TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final com.google.gson.TypeAdapterFactory STRING_FACTORY;
    public static final com.google.gson.TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final com.google.gson.TypeAdapter<java.net.URI> URI;
    public static final com.google.gson.TypeAdapterFactory URI_FACTORY;
    public static final com.google.gson.TypeAdapter<java.net.URL> URL;
    public static final com.google.gson.TypeAdapterFactory URL_FACTORY;
    public static final com.google.gson.TypeAdapter<java.util.UUID> UUID;
    public static final com.google.gson.TypeAdapterFactory UUID_FACTORY;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.gson.TypeAdapter<java.lang.Class> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Class read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Class cls) throws java.io.IOException {
            throw new java.lang.UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$10, reason: invalid class name */
    public class AnonymousClass10 extends com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicIntegerArray> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.concurrent.atomic.AtomicIntegerArray read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(java.lang.Integer.valueOf(jsonReader.nextInt()));
                } catch (java.lang.NumberFormatException e) {
                    throw new com.google.gson.JsonSyntaxException(e);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            java.util.concurrent.atomic.AtomicIntegerArray atomicIntegerArray = new java.util.concurrent.atomic.AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((java.lang.Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicIntegerArray atomicIntegerArray) throws java.io.IOException {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(atomicIntegerArray.get(i));
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$11, reason: invalid class name */
    public class AnonymousClass11 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Long.valueOf(jsonReader.nextLong());
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$12, reason: invalid class name */
    public class AnonymousClass12 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.lang.Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$13, reason: invalid class name */
    public class AnonymousClass13 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.lang.Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$14, reason: invalid class name */
    public class AnonymousClass14 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.stream.JsonToken peek = jsonReader.peek();
            int i = com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
            if (i == 1 || i == 3) {
                return new com.google.gson.internal.LazilyParsedNumber(jsonReader.nextString());
            }
            if (i == 4) {
                jsonReader.nextNull();
                return null;
            }
            throw new com.google.gson.JsonSyntaxException("Expecting number, got: " + peek);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$15, reason: invalid class name */
    public class AnonymousClass15 extends com.google.gson.TypeAdapter<java.lang.Character> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Character read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.lang.String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return java.lang.Character.valueOf(nextString.charAt(0));
            }
            throw new com.google.gson.JsonSyntaxException("Expecting character, got: " + nextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Character ch) throws java.io.IOException {
            jsonWriter.value(ch == null ? null : java.lang.String.valueOf(ch));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$16, reason: invalid class name */
    public class AnonymousClass16 extends com.google.gson.TypeAdapter<java.lang.String> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.lang.String read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.stream.JsonToken peek = jsonReader.peek();
            if (peek != com.google.gson.stream.JsonToken.NULL) {
                return peek == com.google.gson.stream.JsonToken.BOOLEAN ? java.lang.Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.String str) throws java.io.IOException {
            jsonWriter.value(str);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$17, reason: invalid class name */
    public class AnonymousClass17 extends com.google.gson.TypeAdapter<java.math.BigDecimal> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.math.BigDecimal read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new java.math.BigDecimal(jsonReader.nextString());
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.math.BigDecimal bigDecimal) throws java.io.IOException {
            jsonWriter.value(bigDecimal);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$18, reason: invalid class name */
    public class AnonymousClass18 extends com.google.gson.TypeAdapter<java.math.BigInteger> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.math.BigInteger read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new java.math.BigInteger(jsonReader.nextString());
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.math.BigInteger bigInteger) throws java.io.IOException {
            jsonWriter.value(bigInteger);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$19, reason: invalid class name */
    public class AnonymousClass19 extends com.google.gson.TypeAdapter<java.lang.StringBuilder> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.lang.StringBuilder read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return new java.lang.StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.StringBuilder sb) throws java.io.IOException {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.gson.TypeAdapter<java.util.BitSet> {
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        
            if (java.lang.Integer.parseInt(r1) != 0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
        
            if (r8.nextInt() != 0) goto L23;
         */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.util.BitSet read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            java.util.BitSet bitSet = new java.util.BitSet();
            jsonReader.beginArray();
            com.google.gson.stream.JsonToken peek = jsonReader.peek();
            int i = 0;
            while (peek != com.google.gson.stream.JsonToken.END_ARRAY) {
                int i2 = com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
                boolean z = true;
                if (i2 != 1) {
                    if (i2 == 2) {
                        z = jsonReader.nextBoolean();
                    } else {
                        if (i2 != 3) {
                            throw new com.google.gson.JsonSyntaxException("Invalid bitset value type: " + peek);
                        }
                        java.lang.String nextString = jsonReader.nextString();
                        try {
                        } catch (java.lang.NumberFormatException unused) {
                            throw new com.google.gson.JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + nextString);
                        }
                    }
                    if (z) {
                        bitSet.set(i);
                    }
                    i++;
                    peek = jsonReader.peek();
                }
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.BitSet bitSet) throws java.io.IOException {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(bitSet.get(i) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$20, reason: invalid class name */
    public class AnonymousClass20 extends com.google.gson.TypeAdapter<java.lang.StringBuffer> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.lang.StringBuffer read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return new java.lang.StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.StringBuffer stringBuffer) throws java.io.IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$21, reason: invalid class name */
    public class AnonymousClass21 extends com.google.gson.TypeAdapter<java.net.URL> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.net.URL read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.lang.String nextString = jsonReader.nextString();
            if (com.igexin.push.core.b.m.equals(nextString)) {
                return null;
            }
            return new java.net.URL(nextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.net.URL url) throws java.io.IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$22, reason: invalid class name */
    public class AnonymousClass22 extends com.google.gson.TypeAdapter<java.net.URI> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.net.URI read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                java.lang.String nextString = jsonReader.nextString();
                if (com.igexin.push.core.b.m.equals(nextString)) {
                    return null;
                }
                return new java.net.URI(nextString);
            } catch (java.net.URISyntaxException e) {
                throw new com.google.gson.JsonIOException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.net.URI uri) throws java.io.IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$23, reason: invalid class name */
    public class AnonymousClass23 extends com.google.gson.TypeAdapter<java.net.InetAddress> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.net.InetAddress read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.net.InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.net.InetAddress inetAddress) throws java.io.IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$24, reason: invalid class name */
    public class AnonymousClass24 extends com.google.gson.TypeAdapter<java.util.UUID> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.UUID read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.util.UUID.fromString(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.UUID uuid) throws java.io.IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$25, reason: invalid class name */
    public class AnonymousClass25 extends com.google.gson.TypeAdapter<java.util.Currency> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.Currency read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            return java.util.Currency.getInstance(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Currency currency) throws java.io.IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$26, reason: invalid class name */
    public class AnonymousClass26 implements com.google.gson.TypeAdapterFactory {

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$26$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.gson.TypeAdapter<java.sql.Timestamp> {
            final /* synthetic */ com.google.gson.TypeAdapter val$dateTypeAdapter;

            public AnonymousClass1(com.google.gson.TypeAdapter typeAdapter) {
                this.val$dateTypeAdapter = typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read, reason: avoid collision after fix types in other method */
            public java.sql.Timestamp read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                java.util.Date date = (java.util.Date) this.val$dateTypeAdapter.read2(jsonReader);
                if (date != null) {
                    return new java.sql.Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, java.sql.Timestamp timestamp) throws java.io.IOException {
                this.val$dateTypeAdapter.write(jsonWriter, timestamp);
            }
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.getRawType() != java.sql.Timestamp.class) {
                return null;
            }
            return new com.google.gson.internal.bind.TypeAdapters.AnonymousClass26.AnonymousClass1(gson.getAdapter(java.util.Date.class));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$27, reason: invalid class name */
    public class AnonymousClass27 extends com.google.gson.TypeAdapter<java.util.Calendar> {
        private static final java.lang.String DAY_OF_MONTH = "dayOfMonth";
        private static final java.lang.String HOUR_OF_DAY = "hourOfDay";
        private static final java.lang.String MINUTE = "minute";
        private static final java.lang.String MONTH = "month";
        private static final java.lang.String SECOND = "second";
        private static final java.lang.String YEAR = "year";

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.Calendar read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.peek() != com.google.gson.stream.JsonToken.END_OBJECT) {
                java.lang.String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if (YEAR.equals(nextName)) {
                    i = nextInt;
                } else if (MONTH.equals(nextName)) {
                    i2 = nextInt;
                } else if (DAY_OF_MONTH.equals(nextName)) {
                    i3 = nextInt;
                } else if (HOUR_OF_DAY.equals(nextName)) {
                    i4 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i5 = nextInt;
                } else if ("second".equals(nextName)) {
                    i6 = nextInt;
                }
            }
            jsonReader.endObject();
            return new java.util.GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Calendar calendar) throws java.io.IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(YEAR);
            jsonWriter.value(calendar.get(1));
            jsonWriter.name(MONTH);
            jsonWriter.value(calendar.get(2));
            jsonWriter.name(DAY_OF_MONTH);
            jsonWriter.value(calendar.get(5));
            jsonWriter.name(HOUR_OF_DAY);
            jsonWriter.value(calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value(calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28, reason: invalid class name */
    public class AnonymousClass28 extends com.google.gson.TypeAdapter<java.util.Locale> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.Locale read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(jsonReader.nextString(), "_");
            java.lang.String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            java.lang.String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            java.lang.String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new java.util.Locale(nextToken) : nextToken3 == null ? new java.util.Locale(nextToken, nextToken2) : new java.util.Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Locale locale) throws java.io.IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29, reason: invalid class name */
    public class AnonymousClass29 extends com.google.gson.TypeAdapter<com.google.gson.JsonElement> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public com.google.gson.JsonElement read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            switch (com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                case 1:
                    return new com.google.gson.JsonPrimitive(new com.google.gson.internal.LazilyParsedNumber(jsonReader.nextString()));
                case 2:
                    return new com.google.gson.JsonPrimitive(java.lang.Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new com.google.gson.JsonPrimitive(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return com.google.gson.JsonNull.INSTANCE;
                case 5:
                    com.google.gson.JsonArray jsonArray = new com.google.gson.JsonArray();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonArray.add(read2(jsonReader));
                    }
                    jsonReader.endArray();
                    return jsonArray;
                case 6:
                    com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        jsonObject.add(jsonReader.nextName(), read2(jsonReader));
                    }
                    jsonReader.endObject();
                    return jsonObject;
                default:
                    throw new java.lang.IllegalArgumentException();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, com.google.gson.JsonElement jsonElement) throws java.io.IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                com.google.gson.JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                java.util.Iterator<com.google.gson.JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (!jsonElement.isJsonObject()) {
                throw new java.lang.IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
            jsonWriter.beginObject();
            for (java.util.Map.Entry<java.lang.String, com.google.gson.JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                jsonWriter.name(entry.getKey());
                write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.gson.TypeAdapter<java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Boolean read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.stream.JsonToken peek = jsonReader.peek();
            if (peek != com.google.gson.stream.JsonToken.NULL) {
                return peek == com.google.gson.stream.JsonToken.STRING ? java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(jsonReader.nextString())) : java.lang.Boolean.valueOf(jsonReader.nextBoolean());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Boolean bool) throws java.io.IOException {
            jsonWriter.value(bool);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30, reason: invalid class name */
    public class AnonymousClass30 implements com.google.gson.TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            java.lang.Class<? super T> rawType = typeToken.getRawType();
            if (!java.lang.Enum.class.isAssignableFrom(rawType) || rawType == java.lang.Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter(rawType);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31, reason: invalid class name */
    public class AnonymousClass31 implements com.google.gson.TypeAdapterFactory {
        final /* synthetic */ com.google.gson.reflect.TypeToken val$type;
        final /* synthetic */ com.google.gson.TypeAdapter val$typeAdapter;

        public AnonymousClass31(com.google.gson.reflect.TypeToken typeToken, com.google.gson.TypeAdapter typeAdapter) {
            this.val$type = typeToken;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.equals(this.val$type)) {
                return this.val$typeAdapter;
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32, reason: invalid class name */
    public class AnonymousClass32 implements com.google.gson.TypeAdapterFactory {
        final /* synthetic */ java.lang.Class val$type;
        final /* synthetic */ com.google.gson.TypeAdapter val$typeAdapter;

        public AnonymousClass32(java.lang.Class cls, com.google.gson.TypeAdapter typeAdapter) {
            this.val$type = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.val$type) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public java.lang.String toString() {
            return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$33, reason: invalid class name */
    public class AnonymousClass33 implements com.google.gson.TypeAdapterFactory {
        final /* synthetic */ java.lang.Class val$boxed;
        final /* synthetic */ com.google.gson.TypeAdapter val$typeAdapter;
        final /* synthetic */ java.lang.Class val$unboxed;

        public AnonymousClass33(java.lang.Class cls, java.lang.Class cls2, com.google.gson.TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            java.lang.Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.val$unboxed || rawType == this.val$boxed) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public java.lang.String toString() {
            return "Factory[type=" + this.val$boxed.getName() + "+" + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$34, reason: invalid class name */
    public class AnonymousClass34 implements com.google.gson.TypeAdapterFactory {
        final /* synthetic */ java.lang.Class val$base;
        final /* synthetic */ java.lang.Class val$sub;
        final /* synthetic */ com.google.gson.TypeAdapter val$typeAdapter;

        public AnonymousClass34(java.lang.Class cls, java.lang.Class cls2, com.google.gson.TypeAdapter typeAdapter) {
            this.val$base = cls;
            this.val$sub = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
            java.lang.Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.val$base || rawType == this.val$sub) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public java.lang.String toString() {
            return "Factory[type=" + this.val$base.getName() + "+" + this.val$sub.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$35, reason: invalid class name */
    public class AnonymousClass35 implements com.google.gson.TypeAdapterFactory {
        final /* synthetic */ java.lang.Class val$clazz;
        final /* synthetic */ com.google.gson.TypeAdapter val$typeAdapter;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* renamed from: com.google.gson.internal.bind.TypeAdapters$35$1, reason: invalid class name */
        public class AnonymousClass1<T1> extends com.google.gson.TypeAdapter<T1> {
            final /* synthetic */ java.lang.Class val$requestedType;

            public AnonymousClass1(java.lang.Class cls) {
                this.val$requestedType = cls;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T1 read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                T1 t1 = (T1) com.google.gson.internal.bind.TypeAdapters.AnonymousClass35.this.val$typeAdapter.read2(jsonReader);
                if (t1 == null || this.val$requestedType.isInstance(t1)) {
                    return t1;
                }
                throw new com.google.gson.JsonSyntaxException("Expected a " + this.val$requestedType.getName() + " but was " + t1.getClass().getName());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, T1 t1) throws java.io.IOException {
                com.google.gson.internal.bind.TypeAdapters.AnonymousClass35.this.val$typeAdapter.write(jsonWriter, t1);
            }
        }

        public AnonymousClass35(java.lang.Class cls, com.google.gson.TypeAdapter typeAdapter) {
            this.val$clazz = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T2> com.google.gson.TypeAdapter<T2> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T2> typeToken) {
            java.lang.Class<? super T2> rawType = typeToken.getRawType();
            if (this.val$clazz.isAssignableFrom(rawType)) {
                return new com.google.gson.internal.bind.TypeAdapters.AnonymousClass35.AnonymousClass1(rawType);
            }
            return null;
        }

        public java.lang.String toString() {
            return "Factory[typeHierarchy=" + this.val$clazz.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[com.google.gson.stream.JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[com.google.gson.stream.JsonToken.NUMBER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.STRING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.NULL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.NAME.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$4, reason: invalid class name */
    public class AnonymousClass4 extends com.google.gson.TypeAdapter<java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Boolean read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return java.lang.Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Boolean bool) throws java.io.IOException {
            jsonWriter.value(bool == null ? com.igexin.push.core.b.m : bool.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$5, reason: invalid class name */
    public class AnonymousClass5 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Byte.valueOf((byte) jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$6, reason: invalid class name */
    public class AnonymousClass6 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Short.valueOf((short) jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$7, reason: invalid class name */
    public class AnonymousClass7 extends com.google.gson.TypeAdapter<java.lang.Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Integer.valueOf(jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$8, reason: invalid class name */
    public class AnonymousClass8 extends com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicInteger> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.concurrent.atomic.AtomicInteger read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            try {
                return new java.util.concurrent.atomic.AtomicInteger(jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e) {
                throw new com.google.gson.JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicInteger atomicInteger) throws java.io.IOException {
            jsonWriter.value(atomicInteger.get());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$9, reason: invalid class name */
    public class AnonymousClass9 extends com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicBoolean> {
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public java.util.concurrent.atomic.AtomicBoolean read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            return new java.util.concurrent.atomic.AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicBoolean atomicBoolean) throws java.io.IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    public static final class EnumTypeAdapter<T extends java.lang.Enum<T>> extends com.google.gson.TypeAdapter<T> {
        private final java.util.Map<java.lang.String, T> nameToConstant = new java.util.HashMap();
        private final java.util.Map<T, java.lang.String> constantToName = new java.util.HashMap();

        public EnumTypeAdapter(java.lang.Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    java.lang.String name = t.name();
                    com.google.gson.annotations.SerializedName serializedName = (com.google.gson.annotations.SerializedName) cls.getField(name).getAnnotation(com.google.gson.annotations.SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.value();
                        for (java.lang.String str : serializedName.alternate()) {
                            this.nameToConstant.put(str, t);
                        }
                    }
                    this.nameToConstant.put(name, t);
                    this.constantToName.put(t, name);
                }
            } catch (java.lang.NoSuchFieldException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() != com.google.gson.stream.JsonToken.NULL) {
                return this.nameToConstant.get(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            jsonWriter.value(t == null ? null : this.constantToName.get(t));
        }
    }

    static {
        com.google.gson.TypeAdapter<java.lang.Class> nullSafe = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass1().nullSafe();
        CLASS = nullSafe;
        CLASS_FACTORY = newFactory(java.lang.Class.class, nullSafe);
        com.google.gson.TypeAdapter<java.util.BitSet> nullSafe2 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass2().nullSafe();
        BIT_SET = nullSafe2;
        BIT_SET_FACTORY = newFactory(java.util.BitSet.class, nullSafe2);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass3 anonymousClass3 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass3();
        BOOLEAN = anonymousClass3;
        BOOLEAN_AS_STRING = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass4();
        BOOLEAN_FACTORY = newFactory(java.lang.Boolean.TYPE, java.lang.Boolean.class, anonymousClass3);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass5 anonymousClass5 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass5();
        BYTE = anonymousClass5;
        BYTE_FACTORY = newFactory(java.lang.Byte.TYPE, java.lang.Byte.class, anonymousClass5);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass6 anonymousClass6 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass6();
        SHORT = anonymousClass6;
        SHORT_FACTORY = newFactory(java.lang.Short.TYPE, java.lang.Short.class, anonymousClass6);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass7 anonymousClass7 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass7();
        INTEGER = anonymousClass7;
        INTEGER_FACTORY = newFactory(java.lang.Integer.TYPE, java.lang.Integer.class, anonymousClass7);
        com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicInteger> nullSafe3 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass8().nullSafe();
        ATOMIC_INTEGER = nullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(java.util.concurrent.atomic.AtomicInteger.class, nullSafe3);
        com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicBoolean> nullSafe4 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass9().nullSafe();
        ATOMIC_BOOLEAN = nullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(java.util.concurrent.atomic.AtomicBoolean.class, nullSafe4);
        com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicIntegerArray> nullSafe5 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass10().nullSafe();
        ATOMIC_INTEGER_ARRAY = nullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(java.util.concurrent.atomic.AtomicIntegerArray.class, nullSafe5);
        LONG = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass11();
        FLOAT = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass12();
        DOUBLE = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass13();
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass14 anonymousClass14 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass14();
        NUMBER = anonymousClass14;
        NUMBER_FACTORY = newFactory(java.lang.Number.class, anonymousClass14);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass15 anonymousClass15 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass15();
        CHARACTER = anonymousClass15;
        CHARACTER_FACTORY = newFactory(java.lang.Character.TYPE, java.lang.Character.class, anonymousClass15);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass16 anonymousClass16 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass16();
        STRING = anonymousClass16;
        BIG_DECIMAL = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass17();
        BIG_INTEGER = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass18();
        STRING_FACTORY = newFactory(java.lang.String.class, anonymousClass16);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass19 anonymousClass19 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass19();
        STRING_BUILDER = anonymousClass19;
        STRING_BUILDER_FACTORY = newFactory(java.lang.StringBuilder.class, anonymousClass19);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass20 anonymousClass20 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass20();
        STRING_BUFFER = anonymousClass20;
        STRING_BUFFER_FACTORY = newFactory(java.lang.StringBuffer.class, anonymousClass20);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass21 anonymousClass21 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass21();
        URL = anonymousClass21;
        URL_FACTORY = newFactory(java.net.URL.class, anonymousClass21);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass22 anonymousClass22 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass22();
        URI = anonymousClass22;
        URI_FACTORY = newFactory(java.net.URI.class, anonymousClass22);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass23 anonymousClass23 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass23();
        INET_ADDRESS = anonymousClass23;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(java.net.InetAddress.class, anonymousClass23);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass24 anonymousClass24 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass24();
        UUID = anonymousClass24;
        UUID_FACTORY = newFactory(java.util.UUID.class, anonymousClass24);
        com.google.gson.TypeAdapter<java.util.Currency> nullSafe6 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass25().nullSafe();
        CURRENCY = nullSafe6;
        CURRENCY_FACTORY = newFactory(java.util.Currency.class, nullSafe6);
        TIMESTAMP_FACTORY = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass26();
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass27 anonymousClass27 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass27();
        CALENDAR = anonymousClass27;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(java.util.Calendar.class, java.util.GregorianCalendar.class, anonymousClass27);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass28 anonymousClass28 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass28();
        LOCALE = anonymousClass28;
        LOCALE_FACTORY = newFactory(java.util.Locale.class, anonymousClass28);
        com.google.gson.internal.bind.TypeAdapters.AnonymousClass29 anonymousClass29 = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass29();
        JSON_ELEMENT = anonymousClass29;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(com.google.gson.JsonElement.class, anonymousClass29);
        ENUM_FACTORY = new com.google.gson.internal.bind.TypeAdapters.AnonymousClass30();
    }

    private TypeAdapters() {
        throw new java.lang.UnsupportedOperationException();
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactory(com.google.gson.reflect.TypeToken<TT> typeToken, com.google.gson.TypeAdapter<TT> typeAdapter) {
        return new com.google.gson.internal.bind.TypeAdapters.AnonymousClass31(typeToken, typeAdapter);
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactory(java.lang.Class<TT> cls, com.google.gson.TypeAdapter<TT> typeAdapter) {
        return new com.google.gson.internal.bind.TypeAdapters.AnonymousClass32(cls, typeAdapter);
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactory(java.lang.Class<TT> cls, java.lang.Class<TT> cls2, com.google.gson.TypeAdapter<? super TT> typeAdapter) {
        return new com.google.gson.internal.bind.TypeAdapters.AnonymousClass33(cls, cls2, typeAdapter);
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactoryForMultipleTypes(java.lang.Class<TT> cls, java.lang.Class<? extends TT> cls2, com.google.gson.TypeAdapter<? super TT> typeAdapter) {
        return new com.google.gson.internal.bind.TypeAdapters.AnonymousClass34(cls, cls2, typeAdapter);
    }

    public static <T1> com.google.gson.TypeAdapterFactory newTypeHierarchyFactory(java.lang.Class<T1> cls, com.google.gson.TypeAdapter<T1> typeAdapter) {
        return new com.google.gson.internal.bind.TypeAdapters.AnonymousClass35(cls, typeAdapter);
    }
}
