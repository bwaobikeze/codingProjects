#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;
void chooseNumber(int loto);    // function prototype
int inputVal(int numberofnumb); // funtion prototype

int main()
{
    int answer;

    cout << "Please enter Your lucky 5 digit number: "; // Asks the user to input their number
    cin >> answer;
    inputVal(answer); /*passes the input to check if it
                       is a 5 digit number*/

    while (inputVal(answer) != 5 && inputVal(answer) != isalpha(inputVal(answer)))
    { // if the number is not five digits it will ask                                         again
        cout << "sorry must be a five digit number" << endl;
        cout << "Raffel Ticket is: ";
        cin >> answer;
    }

    if (inputVal(answer) == 5) // if the users input is 5 digits
        chooseNumber(answer);  // passes to the chooseNumber function

    return 0;
}

//*****************************************
// This function is to compare each element
//in the array to the users input
//*****************************************

void chooseNumber(int loto)
{
    bool flag = false; // initialzing the bool value
    int lotoNumber[] = {13579, 26791, 26792, 33445, 55555, 62483, 77777, 79422, 85647, 93121};
    for (int index = 0; index < 10; index++)
        if (loto == lotoNumber[index])
        {                // comparing the users input with the elements of the                             array
            flag = true; //setting it equal to true
            cout << "You Have won the The lucky raffle for this week" << endl;
            break; // it breaks out of the loop onces its true
        }

    if (!flag) // if not true displays try again
        cout << "Try again next week!!!" << endl;
};
//**************************************************
//THis function is used to validate if the user is
//inputting a 5 digit number
//**************************************************
int inputVal(int i)
{
    int len = 0; //counter

    if (i > 0)
        for (len = 0; i > 0; len++)
        {
            i = i / 10; // when the for loop is enacted it divides the number by 10 to see how       many numbers are in the set
        }
    return len;
}
