public class Methods {

	public int getStrengthScore(int length, int uppercaseLetters,
			int lowercaseLetters, int digits, int specialChars,
			boolean lettersOnly, boolean digitsOnly) {
		int strength = length * 4 + (length - uppercaseLetters) * 2
				+ (length - lowercaseLetters) * 2 + digits * 4 + specialChars
				* 6;
		if (lettersOnly)
			strength -= length;
		if (digitsOnly)
			strength -= length;

		return strength;
	}

	public int getNumOfUpperCaseLetters(String str) {
		int num = 0;

		for (int i = 0; i < str.length(); i++)
			if (Character.isUpperCase(str.charAt(i)))
				num++;

		return num;
	}

	public int getNumOfLowerCaseLetters(String str) {
		int num = 0;

		for (int i = 0; i < str.length(); i++)
			if (Character.isLowerCase(str.charAt(i)))
				num++;

		return num;
	}

	public int getNumOfDigits(String str) {
		int num = 0;

		for (int i = 0; i < str.length(); i++)
			if (Character.isDigit(str.charAt(i)))
				num++;

		return num;
	}

	public int getNumOfSpecialCharacters(String str) {
		return str.length() - getNumOfUpperCaseLetters(str)
				- getNumOfLowerCaseLetters(str) - getNumOfDigits(str);
	}

	public boolean isLettersOnly(String str) {
		return (str.length() - getNumOfUpperCaseLetters(str)
				- getNumOfLowerCaseLetters(str)) == 0;
	}
	
	public boolean isDigitsOnly(String str) {
		return (str.length() - getNumOfDigits(str)) == 0;
	}
}
