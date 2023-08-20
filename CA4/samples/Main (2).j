.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 128
.limit locals 128
		new Main
		invokespecial Main/<init>()V
		return
.end method
.method public <init>()V
.limit stack 128
.limit locals 128
		aload 0
		invokespecial java/lang/Object/<init>()V
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		astore 1
		new Array
		dup
		ldc 5
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokespecial Array/<init>(ILjava/lang/Object;)V
		astore 2
		ldc 2
		
		dup
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		putstatic Global/y Ljava/lang/Integer;
		pop
		ldc 0
		istore 3
	Label_0:
		iload 3
		aload 2
		getfield Array/elements Ljava/util/ArrayList;
		invokevirtual java/util/ArrayList/size()I
		if_icmpge Label_1
		aload 2
		iload 3
		invokevirtual Array/getElement(I)Ljava/lang/Object;
		checkcast java/lang/Integer
		astore 1
		iinc 3 1
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 1
		invokevirtual java/lang/Integer/intValue()I
		getstatic Global/y Ljava/lang/Integer;
		invokevirtual java/lang/Integer/intValue()I
		dup
		ldc 1
		iadd
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		putstatic Global/y Ljava/lang/Integer;
		iadd
		invokevirtual java/io/PrintStream/println(I)V
		goto Label_0
	Label_1:
		return
.end method
		 
