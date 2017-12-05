#include <iostream>

using std::cout;
using std::endl;

// Funci�n: SumaDistintos
// Suma en destino[i] los elementos de origen que sean distintos de los de destino.
// Supone que los dos vectores son de la misma longitud
// Devuelve en sumados el n�mero de elementos sumados
//--- INICIO HUECO ---
// Definir la cabera de la funci�n SumaDistintos teniendo en cuenta los par�metros
// con los que se llama en la funci�n main y que el par�metro sumados tiene que modifcarse
// fuera de la funci�n

//--- FIN HUECO ---
{
  unsigned int i;

  sumados = 0;
  for (i = 0; i < longVectores; i++)
  {
    if (origen[i] != destino[i]) 
    {
      destino[i] = origen[i] + destino[i];
      sumados++;
    }
  }
}

// Funci�n: ImprimeVector
// Imprime en una l�nea el nombre del vector de enteros seguido de sus elementos
void ImprimeVector(char nombre[], int vector[], unsigned int longitud)
{
  unsigned int i;

  cout << nombre << ": ";

  for (i = 0; i < longitud; i++)
  {
    //--- INICIO HUECO ---
    // Imprimir el elemento i del vector y un espacio

    //--- FIN HUECO ---
  }
  cout << endl;
}

int main()
{
  unsigned int sumados;
  const unsigned int longVectores = 5;
  int vector1[longVectores] = {34, 12, 56, 17, 99};
  int vector2[longVectores] = {-8, 9, 56, 38, 99};

  //--- INICIO HUECO ---
  // Definir dos variables llamadas nombreVector1 y nombreVector2 que sean
  // arrays de caracteres y est�n inicializadas a "vector1" y "vector2"

  //--- FIN HUECO ---

  ImprimeVector(nombreVector1, vector1, longVectores);
  ImprimeVector(nombreVector2, vector2, longVectores);

  SumaDistintos(vector1, vector2, longVectores, sumados);
  cout << "Tras sumar distintos:" << endl;
  ImprimeVector(nombreVector2, vector2, longVectores);
  cout << "Se han sumado " << sumados << " elementos" << endl;

  return 0;
}
