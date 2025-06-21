package com.getkeepsafe.relinker.elf;

/* loaded from: classes22.dex */
public class Elf32Header extends com.getkeepsafe.relinker.elf.Elf.Header {
    public final com.getkeepsafe.relinker.elf.ElfParser a;

    public Elf32Header(boolean z, com.getkeepsafe.relinker.elf.ElfParser elfParser) throws java.io.IOException {
        this.bigEndian = z;
        this.a = elfParser;
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(4);
        allocate.order(z ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        this.type = elfParser.readHalf(allocate, 16L);
        this.phoff = elfParser.readWord(allocate, 28L);
        this.shoff = elfParser.readWord(allocate, 32L);
        this.phentsize = elfParser.readHalf(allocate, 42L);
        this.phnum = elfParser.readHalf(allocate, 44L);
        this.shentsize = elfParser.readHalf(allocate, 46L);
        this.shnum = elfParser.readHalf(allocate, 48L);
        this.shstrndx = elfParser.readHalf(allocate, 50L);
    }

    @Override // com.getkeepsafe.relinker.elf.Elf.Header
    public com.getkeepsafe.relinker.elf.Elf.DynamicStructure getDynamicStructure(long j, int i) throws java.io.IOException {
        return new com.getkeepsafe.relinker.elf.Dynamic32Structure(this.a, this, j, i);
    }

    @Override // com.getkeepsafe.relinker.elf.Elf.Header
    public com.getkeepsafe.relinker.elf.Elf.ProgramHeader getProgramHeader(long j) throws java.io.IOException {
        return new com.getkeepsafe.relinker.elf.Program32Header(this.a, this, j);
    }

    @Override // com.getkeepsafe.relinker.elf.Elf.Header
    public com.getkeepsafe.relinker.elf.Elf.SectionHeader getSectionHeader(int i) throws java.io.IOException {
        return new com.getkeepsafe.relinker.elf.Section32Header(this.a, this, i);
    }
}
