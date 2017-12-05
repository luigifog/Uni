// Single thread application with SIMD extensions

#include <Windows.h>
#include <intrin.h>

// Include required header files

#include <stdio.h>

#define NTIMES               200  // Number of repetitions to get suitable times
#define SIZE		 (1024*1024)  // Number of elements in the array

#define SOPORTA_MMX    (1 << 23)
#define SOPORTA_SSE    (1 << 25)
#define SOPORTA_SSE2   (1 << 26)
#define SOPORTA_SSE3   (1 << 0)
#define SOPORTA_SSSE3  (1 << 9)
#define SOPORTA_SSE4_1 (1 << 19)

int comprobarExtension(int mascara, int registro, char * extension) {
	if (registro & mascara) {
		printf("Soporta %s\n", extension);
		return TRUE;
	}
	else {
		printf("No soporta %s\n", extension);
		return FALSE;
	}
}

void blurr2(double * u, double * r) {

	__m128d rp2;
	__m128d rdos;
	__m128d rr;
	int i;
	int sizeAux = SIZE % 2 == 1 ? SIZE : SIZE - 1;
	double dos[2] = { 2.0, 2.0 };
	
	rdos = *(__m128d*)dos;

	for (i = 0; i < sizeAux; i += 2) {
		rp2 = *(__m128d*)&u[i + 1];
		rr = _mm_add_pd(*(__m128d*)&u[i], rp2);
		*((__m128d*)&r[i]) = _mm_div_pd(rr, rdos);
	}

	/*
	for (i = 0; i < SIZE; i++) {
		printf("v[%d]=%f r[%d]=%f\n", i, u[i], i, r[i]);
	}
	*/
}

int contarNegativos(double * u) {

	__m128d rcero;
	__m128d rr;
	int i;
	double cero[2] = { 0.0, 0.0 };
	int contador = 0;

	rcero = *(__m128d*)cero;

	for (i = 0; i < SIZE; i += 2) {
		rr = _mm_cmplt_pd(*(__m128d*)&u[i], rcero);
		if (((__int64 *)&rr)[0]) {
			contador++;
		};
		if (((__int64 *)&rr)[1]) {
			contador++;
		};
	}

	/*
	for (i = 0; i < SIZE; i++) {
		printf("u[%d]=%f\n", i, u[i]);
	}
	printf("Contador: %d\n", contador);
	*/

	return contador;
}

void ord(double * v, double * u, double * r) {

	__m128d rr;
	int i;

	for (i = 0; i < SIZE; i += 2) {
		*((__m128d*)&r[i]) = _mm_or_pd(*(__m128d*)&v[i], *(__m128d*)&u[i]);
	}

	/*
	for (i = 0; i < SIZE; i++) {
		printf("u[%d]=%llx v[%d]=%llx r[%d] = %llx\n", i, v[i], i, u[i], i, r[i]);
	}
	*/
}

void medir() {

	LARGE_INTEGER frequency;
	LARGE_INTEGER tStart;
	LARGE_INTEGER tEnd;
	double dElapsedTimeS;

	int i;

	double * u = (double*)_aligned_malloc(SIZE * sizeof(double), sizeof(__m128d));
	double * v = (double*)_aligned_malloc(SIZE * sizeof(double), sizeof(__m128d));
	double * r = (double*)_aligned_malloc(SIZE * sizeof(double), sizeof(__m128d));


	for (i = 0; i < SIZE; i++) {
		u[i] = ((double)rand() / RAND_MAX) - 0.5;
		v[i] = ((double)rand() / RAND_MAX) - 0.5;
	}

	// Get clock frequency in Hz
	QueryPerformanceFrequency(&frequency);
	
	// Get initial clock count
	QueryPerformanceCounter(&tStart);

	printf("Running task    : ");
	fflush(stdout);

	for (i = 0; i < NTIMES; i++) {
		blurr2(u, r);
	}

	printf("Finished\n");

	// Get final clock count
	QueryPerformanceCounter(&tEnd);  
	
	// Compute the elapsed time in seconds
	dElapsedTimeS = (tEnd.QuadPart - tStart.QuadPart) / (double)frequency.QuadPart; 

	// Print the elapsed time
	printf("Elapsed time in seconds (blurr2): %f\n", dElapsedTimeS);  

	// Get initial clock count
	QueryPerformanceCounter(&tStart);

	printf("Running task    : ");
	fflush(stdout);

	for (i = 0; i < NTIMES; i++) {
		contarNegativos(u);
	}

	printf("Finished\n");

	// Get final clock count
	QueryPerformanceCounter(&tEnd);

	// Compute the elapsed time in seconds
	dElapsedTimeS = (tEnd.QuadPart - tStart.QuadPart) / (double)frequency.QuadPart;

	// Print the elapsed time
	printf("Elapsed time in seconds (contarNegativos): %f\n", dElapsedTimeS);

	// Get initial clock count
	QueryPerformanceCounter(&tStart);

	printf("Running task    : ");
	fflush(stdout);

	for (i = 0; i < NTIMES; i++) {
		ord(v, u, r);
	}

	printf("Finished\n");

	// Get final clock count
	QueryPerformanceCounter(&tEnd);

	// Compute the elapsed time in seconds
	dElapsedTimeS = (tEnd.QuadPart - tStart.QuadPart) / (double)frequency.QuadPart;

	// Print the elapsed time
	printf("Elapsed time in seconds (ord): %f\n", dElapsedTimeS);

	_aligned_free(u);
	_aligned_free(v);
	_aligned_free(r);
}

int main() {

	int resultado[4];
	int eax, ebx, ecx, edx;

	__cpuid(resultado, 1);

	eax = resultado[0];
	ebx = resultado[1];
	ecx = resultado[2];
	edx = resultado[3];

	comprobarExtension(SOPORTA_MMX, edx, "MMX");
	comprobarExtension(SOPORTA_SSE, edx, "SSE");
	comprobarExtension(SOPORTA_SSE2, edx, "SSE2");
	comprobarExtension(SOPORTA_SSE3, ecx, "SSE3");
	comprobarExtension(SOPORTA_SSSE3, ecx, "SSSE3");
	comprobarExtension(SOPORTA_SSE4_1, ecx, "SSE4.1");

	medir();
}