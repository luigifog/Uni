;
; Gets the count of odd numbers in a string
;
	.data
string:  .asciiz "12345678"
result:  .word 0

	.text
main:
	xor    r16, r16, r16   ; odd numbers count
	xor    r17, r17, r17   ; index to current item
loop:
	lbu    r4, string(r17) ; load first digit (ascii code)
	beqz   r4, end         ; end of string?
	jal    procedure       ; call procedure
	dadd   r16, r16, r2    ; update odd numbers count
	daddui r17, r17, 1     ; move to next index
	j      loop
	
end:
	sd     r16, result(r0) ; save result
	halt

procedure:
	; Receives an ascii code in r4. Returns 1 in r2 if odd, 0 in r2 otherwise
	andi   r2, r4, 1       ; check the least significant bit (1 if even)
	jr     r31             ; return
