;
; Input/output examples
;
      .data
int:      .word 0xF9876543987625AA    ; a 64-bit integer
message:  .asciiz "Hello, World!\n"     ; the message
prompt:   .asciiz "Number of pixels [1,49]: "
key:      .asciiz "Press any key to exit\n"

double:   .double 32.786        ; a double	
x:        .byte 0               ; coordinates of a point
y:        .byte 0
color:    .byte 255,0,255,0     ; the colour magenta

CONTROL: .word32 0x10000
DATA:    .word32 0x10008
		
	.text
main:
	; Print an unsigned int
	ld     r4, int(r0)    ; Integer to print 
	jal    printUInt
	
	; Print a double
	l.d    f0, double(r0) ; Double to print
	jal    printDouble
	
	; Print a string
	daddi  r4, r0, message
	jal    printString
	
	; Read an integer
	daddi  r4, r0, prompt
	jal    printString
	jal    readInt	
	
	; Draw a diagonal on screen (r2 --> number of pixels)
	dadd   r16, r2, r0
	lwu    r6, color(r0)  ; the same color for all pixels
again:
	dadd   r4, r16, r0
	dadd   r5, r16, r0	
	jal    drawPixel
	daddi  r16, r16, -1
	bnez   r16, again

	; Clear the terminal screen
	jal    clearTerminalScreen
	
	; Finish
	daddi  r4, r0, key
	jal    printString
	jal    waitForKey
	
	; Clear the graphical screen
	jal    clearTerminalScreen
	jal    clearGraphicalScreen
	
	halt

	
printUInt:
	; Print r4 as integer
	lwu    r24, DATA(r0)	; r24 = address of DATA register
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 1        ; set 1 for unsigned integer output
	sd     r4, 0(r24)       ; write integer to DATA register
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	jr     r31              ; return
	
printDouble:
	; Print f0 as double
	lwu    r24, DATA(r0)	; r24 = address of DATA register
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 3        ; set 3 for double output
	s.d    f0, 0(r24)       ; write double to DATA register
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	jr     r31              ; return

printString:
	; Print the string pointed by r4
	lwu    r24, DATA(r0)	; r24 = address of DATA register
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 4        ; set 4 for string output
	sd     r4, 0(r24)       ; write address of message to DATA register
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	jr     r31              ; return

drawPixel:
	; Draw pixel (r4,r5) with color r6
	lwu    r24, DATA(r0)	; r24 = address of DATA register
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 5        ; set 4 for drawing a pixel
	sb     r4, 5(r24)       ; store x in DATA + 5
	sb     r5, 4(r24)       ; store y in DATA + 4
	sw     r6, 0(r24)	    ; store colour in DATA	
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	jr     r31              ; return

clearTerminalScreen:
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 6        ; set 6 for clearing the terminal
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	jr     r31

clearGraphicalScreen:
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 7        ; set 7 for clearing the graphical terminal
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	jr     r31

readInt:
	; Read an integer an return it in r2
	lwu    r24, DATA(r0)	; r24 = address of DATA register
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 8        ; set 8 for number input
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	ld     r2, 0(r24)       ; read the integer
	jr     r31

waitForKey:
	; Read a byte without echo an return the ascii code in r2
	lwu    r24, DATA(r0)	; r24 = address of DATA register
	lwu    r25, CONTROL(r0)	; r25 = address of CONTROL register
	
	daddi  r8, r0, 9        ; set 9 for byte input with no echo
	sd     r8, 0(r25)       ; write to CONTROL register and make it happen
	lb     r2, 0(r24)       ; read the integer
	jr     r31
