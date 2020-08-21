#include <iostream>
#include <fstream>
#include <cstdlib>
using namespace std;
int *reverseArray(int a[], int size); //function prototype

/* ***************************************************
 IN TH MAIN FUNCTION:
  initialized the size of the array before the usersinput
  initialized the array
initialized the counter
user enters the size of the array
The for loop checks weather the input is between 0 and 50
 declaring the varibale for istream
  Opens the file
   To check if the file has been accessed
  The for loop accesses the content/numbers of the file and puts it into an array
  this for loop displays the content of the array
 passes  the array elements and the array size to the function

*********************************************************/
int main()
{
    int size = 0;
    int fileArray[size];
    int i;
    cout << "please enter size: ";
    cin >> size;
    if (size < 50 && size > 0)
    {
        ifstream infile;
        infile.open("data.txt");

        if (!infile)
            exit(1);

        for (i = 0; i < size; i++)
        {
            infile >> fileArray[i];
        }

        for (i = 0; i < size; i++)
        {
            cout << fileArray[i] << endl;
        }
        reverseArray(fileArray, size); // passes  the array elements and the array size to the function
    }

    return 0;
}

//********************************************
// This funtion takes the content of the array
// and reverses them and also returns a pointer
//*******************************************
int *reverseArray(int a[], int size)
{
    int i = 0;     //counter
    int *array;    // pointer
    array = &a[i]; //pointing to a new function
    cout << "The reverse if this array is: " << endl;
    for (i = size - 1; i >= 0; i--) // This for loop gets the contents passed to this function and reverses it
    {

        cout << a[i] << endl;
    }

    return a;
}
