import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 합의 법칙
		// n(A U B)  = n(A) + n(B) - n(A N B)
		System.out.println("== 합의 법칙 ==");
		// 두 개의 주사위를 던졌을 때 합이 3 또는 4의 배수일 경우의 수
		
		int[] dice1 = {1, 2, 3, 4, 5, 6};
		int[] dice2 = {1, 2, 3, 4, 5, 6};
		
		int nA = 0; 	// 3의 배수 
		int nB = 0; 	// 4의 배수 
		int nAndB = 0;	// 공통 
		
		// 기본풀이
		for (int item1: dice1) {
			for(int item2 : dice2) {
				if ((item1 + item2) % 3 == 0) {
					nA += 1;
				}
				if ((item1 + item2) % 4 == 0) {
					nB += 1;
				}
				if ((item1 + item2) % 12 == 0) {
					nAndB += 1;
				}
			}
		}
		System.out.println("결과 :" + (nA + nB - nAndB));
		
		// HashSet 이용
		HashSet<ArrayList> allCase = new HashSet<>();
		for (int item1: dice1) {
			for(int item2 : dice2) {
				if ((item1 + item2) % 3 == 0 || (item1 + item2) % 4 == 0) {
					ArrayList list = new ArrayList(Arrays.asList(item1, item2));
					allCase.add(list);
				}
			}
		}
		
		System.out.println("결과 " + allCase.size());
		
		// 2.곱의 법칙 
		// n(A X B) = n(A) X n(B)
		System.out.println("== 곱의 법칙 ==");
		// 두 개의 주사위 a,b를 던졌을때 a는 3의배수, b는 4의 배수인 경우의 수
		nA = 0;
		nB = 0;
		for (int item1: dice1) {
			if (item1 % 3 == 0) {
				nA += 1;
			}
		}
		
		for(int item2 : dice2) {
			if (item2 % 4 == 0) {
				nB += 1;
			}
		}
		
		System.out.println("결과 " + (nA * nB));
	}

}
