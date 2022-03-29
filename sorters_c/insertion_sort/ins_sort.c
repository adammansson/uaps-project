#include <stdio.h>
#include <stdlib.h>

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

int main()
{
	int size = 1000;

	char ch;
	char *file_name;
	FILE *fp;
	file_name = "../../data1.txt";

	fp = fopen(file_name, "r");
	int arr[size];

	int i = 0;
	int ctr = 0;
	while (!feof (fp))
	{
		fscanf(fp, "%d", &i);
		arr[ctr] = i;
		ctr++;
	}

	sort(arr, size);

	printArray(arr, size);

	return 0;
}
