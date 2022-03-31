#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void sort(int arr[], int length)
{
	int i, j, key;
	for (i = 0; i < length; i++)
	{
		j = i - 1;
		key = arr[i];

		while (j >= 0 && arr[j] > key)
		{
			arr[j + 1] = arr[j];
			j = j - 1;
		}
		arr[j + 1] = key;
	}
}

void printArray(int arr[], int length)
{
	int i;
	for (i = 0; i < length; i++)
	{
		printf("%d\n", arr[i]);
	}
}

int main(void)
{
	int size = 100000;

	FILE *in_file;
	char *in_filename;
	in_filename = "../../data.txt";
	in_file = fopen(in_filename, "r");

	FILE *out_file;
	char *out_filename;
	out_filename = "../../output.txt";

	int arr[size];

	int i = 0;
	int ctr = 0;
	while (!feof (in_file))
	{
		fscanf(in_file, "%d", &i);
		arr[ctr] = i;
		ctr++;
	}

	struct timespec start, end;
	double dif;
	for (int k = 0; k < 1; k++)
	{
		clock_gettime(CLOCK_MONOTONIC, &start);
		
		sort(arr, size);

		clock_gettime(CLOCK_MONOTONIC, &end);

		dif = (end.tv_sec - start.tv_sec) * 1e9;
		dif = (dif + (end.tv_nsec - start.tv_nsec)) * 1e-9;
	}
	printf("%f\n", dif);

	fclose(in_file);

	return 0;
}
