#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void print_array(int arr[], int length)
{
	int i;
	for (i = 0; i < length; i++)
	{
		printf("%d\n", arr[i]);
	}
}

void insertion_sort(int arr[], int length)
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

void merge(int input[], int helper[], int length, int first, int mid, int last)
{
	for (int i = first; i <= last; i++)
	{
		helper[i] = input[i];
	}

	int inFirst = first;
	int inSecond = mid + 1;
	for (int inNew = first; inNew <= last; inNew++)
	{
		if (inFirst > mid)
		{
			input[inNew] = helper[inSecond];
			inSecond++;
		}
		else if (inSecond > last)
		{
			input[inNew] = helper[inFirst];
			inFirst++;
		}
		else
		{
			if (helper[inFirst] < helper[inSecond])
			{
				input[inNew] = helper[inFirst];
				inFirst++;
			}
			else
			{
				input[inNew] = helper[inSecond];
				inSecond++;
			}
		}
	}
}

void merge_sort(int input[], int helper[], int length, int first, int last)
{
	if (first < last)
	{
		int mid = first + (last - first) / 2;
		merge_sort(input, helper, length, first, mid);
		merge_sort(input, helper, length, mid + 1, last);
		merge(input, helper, length, first, mid, last);
	}
}

void load_array(FILE *in_file, int arr[])
{
	rewind(in_file);

	int i = 0;
	int ctr = 0;
	while (!feof(in_file))
	{
		fscanf(in_file, "%d", &i);
		arr[ctr] = i;
		ctr++;
	}
}

int main(void)
{
	int size = 100000;

	FILE *in_file;
	char *in_filename;
	in_filename = "../data.txt";
	in_file = fopen(in_filename, "r");

	FILE *out_file;
	char *out_filename;
	out_filename = "../output_c.txt";
	out_file = fopen(out_filename, "w");

	struct timespec start, end;
	int dif;

	int arr[size];

	fprintf(out_file, "nbr, time in ns\n");

	for (int k = 1; k <= 1; k++)
	{
		load_array(in_file, arr);

		clock_gettime(CLOCK_MONOTONIC, &start);
		
		insertion_sort(arr, size);
        
        	// int helper[size];
        	// merge_sort(arr, helper, size, 0, size - 1);

		clock_gettime(CLOCK_MONOTONIC, &end);
		dif = (end.tv_nsec - start.tv_nsec);
		fprintf(out_file, "%d, %d\n", k, dif);
	}

	fclose(in_file);
	fclose(out_file);

	return 0;
}
