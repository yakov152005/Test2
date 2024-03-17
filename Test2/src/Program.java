public class Program {
	public static void main(String[] args) {
		Ex1();
		Ex2();
		Ex3();
		Ex4A();
		Ex4C();
		Ex4D();
		Ex5();
	}
	//--------------------------------------------------------------------------------------
	public static void Ex1(){
		String[] strArr = {"apple", "kiwi", "banana", "yakov", "wow"};
		String[] result = getLongestStrings(strArr);
		printStrArr(result);
	}
	public static String[] getLongestStrings(String[] strings){
		int countAvg = 0;
		for (int i = 0; i < strings.length; i++) {
			countAvg += strings[i].length();
		}
		int avgLengthStrings = (countAvg/ strings.length);
		int count = 0;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].length() > avgLengthStrings){
				count++;
			}
		}
		String[] newStrArr = new String[count];
		int index = 0;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].length() > avgLengthStrings){
				newStrArr[index] = strings[i];
				index++;
			}
		}
		return newStrArr;
	}
	public static void printStrArr(String[] strArr){
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + ",");
		}
	}
	//--------------------------------------------------------------------------------------
	public static void Ex2(){
		int[] array = {5,1,8,6,10};
		int result = getSecondHighestNumber(array);
		System.out.println(result);
	}
	public static int getSecondHighestNumber(int[] array){
		int result = 0;
		if (array.length < 2){
			return result;
		}else {
			int highestNumber = array[0];
			for (int i = 0; i < array.length; i++) {
				if (array[i] > highestNumber){
					highestNumber = array[i];
				}
			}
			int secondHighestNumber = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > secondHighestNumber && array[i] < highestNumber){
					secondHighestNumber = array[i];
				}
			}
			result = secondHighestNumber;
		}
		return result;
	}
	//--------------------------------------------------------------------------------------
	public static void Ex3(){
		int[] array = {5,7,1,9,2,2};
		int[] result = multiplyArray(array);
		printArr(result);
	}
	public static int[] multiplyArray(int[] array){
		int[] newArr = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			newArr[i] = (array[i] *i);
		}
		return newArr;
	}
	public static void printArr(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
	//--------------------------------------------------------------------------------------
	public static void Ex4A(){
		int n1 = 5;
		int n2 = 3;
		int result = multiply(n1,n2);
		System.out.println(n1 + "*" + n2 +"=" +result);
	}
	public static int multiply(int n1, int n2){
		int highestNum = 0;
		int lowerNum = 0;
		if (n1 > n2){
			highestNum = n1;
			lowerNum = n2;
		}else {
			lowerNum = n1;
			highestNum = n2;
		}
		int sum = 0;
		for (int i = 1; i <= lowerNum; i++) {
			sum += highestNum;
		}
		return sum;
	}
	//--------------------------------------------------------------------------------------
	public static void Ex4C(){
		int dividend =17;
		int divisor = 3;
		int result = modulus(dividend,divisor);
		System.out.println(dividend + " % " + divisor + " = " + result);
	}
	public static int modulus(int dividend, int divisor) {
		int result = 0;
		for (int i = dividend; i >= divisor; i -= divisor) {
			result = i - divisor;
		}
		return result;
	}
	//--------------------------------------------------------------------------------------
	public static void Ex4D(){
		int n1 = -5;
		int result = absoluteValue(n1);
		System.out.println("|" + n1 +"|= " + result);
	}
	public static int absoluteValue(int n1){
		int result = 0;
		if (n1 >= 0){
			result = n1;
		}else {
			for (int i = n1; i <0 ; i++) {
				result++;
			}
		}
		return  result;
	}
	//--------------------------------------------------------------------------------------
	public static void Ex5(){
		int[] series = {4,1,8,6,2,9,1,5,9,7,1,9,6,11,16,21,22,10};
		int[] result = longestArithmeticProgression(series);
		System.out.print("Longest arithmetic sequence: ");
		for (int num : result) {
			System.out.print(num + " ");
		}
	}
	public static int[] longestArithmeticProgression(int[] series) {
		int maxLength = 0;
		int maxStartIndex = 0;

		for (int i = 0; i < series.length - 1; i++) {
			int currentLength = 1;
			int startIndex = i;
			int difference = series[i + 1] - series[i];

			for (int j = i + 1; j < series.length - 1; j++) {
				if (series[j + 1] - series[j] == difference) {
					currentLength++;
				} else {
					break;
				}
			}
			if (currentLength > maxLength) {
				maxLength = currentLength;
				maxStartIndex = startIndex;
			}
		}

		int[] result = new int[maxLength];
		for (int i = 0; i < maxLength; i++) {
			result[i] = series[maxStartIndex + i];
		}

		return result;
	}
}
