#include <stdlib.h>
#include <stdio.h>

// Usage: generateInput seed nrIntegers maxInt
// Output: nrIntegers in interval [0,maxInt]

int main(int argc, char *argv[])
{
unsigned int seed;
long nrIntegers;
long maxInt;
long i;

sscanf(argv[1],"%d", &seed);
sscanf(argv[2],"%ld", &nrIntegers);
sscanf(argv[3],"%ld", &maxInt);

printf("%ld\n", nrIntegers);

srandom(seed);
for(i=0; i<nrIntegers; i++)
printf("%ld\n", (long)(maxInt * ((double)random()/(double)RAND_MAX)));
}
