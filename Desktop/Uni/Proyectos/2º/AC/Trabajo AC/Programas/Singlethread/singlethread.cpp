// Single thread application with SIMD extensions

#include <Windows.h>
#include <intrin.h>

// Include required header files

#include <stdio.h>

#define NTIMES               200  // Number of repetitions to get suitable times
#define SIZE		 (1024*1024)  // Number of elements in the array

void blurr2(double * u, double * r) {

	int i;
	double dos[2] = { 2.0, 2.0 };

	for (i = 0; i < SIZE - 1; i++) {
		r[i] = u[i] + u[i + 1];
	}

	/*
	for (i = 0; i < SIZE; i++) {
	printf("v[%d]=%f r[%d]=%f\n", i, u[i], i, r[i]);
	}
	*/
}

int contarNegativos(double * u) {

	int i;
	int contador = 0;

	for (i = 0; i < SIZE; i++) {
		if (u[i] < 0) {
			contador++;
		}
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

	int i;

	for (i = 0; i < SIZE; i += 2) {
		r[i] = *(__int64*)&(v[i]) | *(__int64*)&(u[i]);
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

	double * u = (double*)malloc(SIZE * sizeof(double));
	double * v = (double*)malloc(SIZE * sizeof(double));
	double * r = (double*)malloc(SIZE * sizeof(double));


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

	free(u);
}

int main() {
	medir();
}