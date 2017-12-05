;
; Search for the maximum of a list of positive integers
;
	.data

list:	.word 6,9,12,92,100,2,3,1 ; list of numbers
count:	.word 8                   ; item count
max:	.space 8                  ; maximum

	.code

main:
	xor    r8, r8, r8     ; temporary maximum (0 is the minimum)
	xor    r9, r9, r9     ; memory index of the current item
	ld     r10, count(r0) ; remaining items

loop: 
	ld     r11, list(r9)   ; next item
	daddi  r10, r10, -1    ; count--
	daddui r9, r9, 8       ; move index to next item (64 bits)
	sltu   r2, r8, r11     ; unsigned comparison
	movn   r8, r11, r2     ; update temporary maximum if greater
	beqz   r10, end        ; end of the list
	j      loop

end:
	sd     r8, max(r0)     ; maximum
	halt
