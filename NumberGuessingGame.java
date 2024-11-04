/*******************************************
 * NumberGuessingGame.java
 * Asks user to guess a number between 1-100
 * checks that guess against randomly generated
 * number and gives feedback until 7 tries or 
 * the user guesses the number correctly
********************************************/

import java.util.Scanner;

public class NumberGuessingGame
{
	public static void main (String[] args) 										//start main method
	{
	Scanner stdIn = new Scanner(System.in);
	int generatedRandomNum = randomNumGen();										//store random num
    int count = 1;																	//initialize count
    
	System.out.print("Guess a number between 1 and 100. \n\nWhat's your guess? ");	//input first user guess
	int intGuess = stdIn.nextInt();
	
	while (intGuess != generatedRandomNum && count <= 7)							//while guess not correct && guess count <= 7
	{
	System.out.print(findGeneratedNum(intGuess, generatedRandomNum, count));		//inform user high/low
    count++;
    
		if (count <= 7)
		{
		System.out.print("What's your guess? ");									//input next user guess
		intGuess = stdIn.nextInt();
		}
	}

    if (intGuess == generatedRandomNum && count <= 7)								//if user guesses correct && guess count <= 7
    {
        System.out.print(findGeneratedNum(intGuess, generatedRandomNum, count));
    }
	else
	{
    	System.out.print("Too bad so sad\n\n");										//else user guess count > 7 inform user
	}
	} 																				//end main method
//**********************************************
//This method calculates a random # from 1-100

public static int randomNumGen()													
	{
	return (int) (Math.random() * 100) + 1;											//generate random num from 1-100
	}
//**********************************************

//**********************************************
//This method tracks and compares user input to 
//generatedRandomNum() 

public static String findGeneratedNum(int guess, int randomNum, int count)			
    {
        if (guess < randomNum)														//test if user guess lower than random num
    		{
    		return "\nThat's too low\n\n";											//return msg
    		}
    	else if (guess > randomNum)													//test if user guesss higher than random num
    		{
    		return "\nThat's too high!\n\n";										//return msg
    		}
    	return "\nWow, you guessed it in " + count + " tries.\n\n";					//if user guess not higher or lower return msg
    }
//**********************************************
}//end class 