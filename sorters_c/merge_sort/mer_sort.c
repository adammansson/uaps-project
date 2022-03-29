#include <stdio.h>
#include <stdlib.h>

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

void sort(int input[], int helper[], int length, int first, int last)
{
	if (first < last)
	{
		int mid = first + (last - first) / 2;
		sort(input, helper, length, first, mid);
		sort(input, helper, length, mid + 1, last);
		merge(input, helper, length, first, mid, last);
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
	int helper[size];

	int i = 0;
	int ctr = 0;
	while (!feof (fp))
	{
		fscanf(fp, "%d", &i);
		arr[ctr] = i;
		ctr++;
	}

	sort(arr, helper, size, 0, size - 1);

	printArray(arr, size);

	return 0;
}
