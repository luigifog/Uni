    .data
string1:       .space 50    ; first string
string2:       .space 50    ; second string
max_length:    .word  49    ; 49 chars + end of stream

CONTROL:       .word32 0x10000
DATA:          .word32 0x10008

    .code
    ; Read first string
    daddi  r4, r0, string1    ; the address to store the first string
    ld     r5, max_length(r0) ; the maximum number of chars
    jal    readString

    ; TODO: Read second string
		daddi r4, r0, string2
        jal    readString
    ; TODO: Get the length of first string
		jal str1length
    ; TODO: Get the length of second string
		jal str2length
    ; TODO: Print on screen a message if equals/not equals
	;NCOMPARA SI SON IGUALES LOS DOS STRING
    halt


readString:
    ; Arguments:
    ;    r4: the address to store the string
    ;    r5: the maximum number of chars to read
    lwu    r24, DATA(r0)     ; r24 = address of DATA register
    lwu    r25, CONTROL(r0)  ; r25 = address of CONTROL register

    ; TODO: loop reading byte without echo until ascii=13 or maximum number of chars
    ;VA COMPARANDO CADA STRING HASTA QUE DE 13(SALTO DE LINEA)
    ; TODO: Add terminator char (0)

    j      r31
	
str1length:
	;Palabra completa
		ld r20,FFFFFFFFFFFFFFFF
	;calculo
		xor r19,r4,r20
		xor r19,r19,r20
		
str2length:
	;Palabra completa
		ld r20,FFFFFFFFFFFFFFFFh
	;calculo
		xor r6,r18,r20
		xor r18,r18,r20
	























