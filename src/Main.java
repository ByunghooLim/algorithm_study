import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static int test1() {
    	int[] A = {1,2,-3,4,5,-6};
    	int largestSum = 0;
    	int sum = 0;
    	
    	boolean isPositiveNumExist = false;
    	
    	for(int i = 0; i < A.length; i++ ) {
    		if(A[i] < 0) {
    			continue;
    		} else {
    			isPositiveNumExist = true;
    		    sum = A[i];
    			
    			for(int j = i; j < A.length; j++) {
    				int qValue = A[j];
    				
    				if(qValue < 0) {
    					break;
    				} else {
    					if(i == j) {
    						if(largestSum < qValue) {
    							largestSum = qValue;
    						}
    					} else {
    						sum += qValue;
    						
    						if(largestSum < sum) {
    							largestSum = sum;
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	if(isPositiveNumExist) {
    		return largestSum;
    	} else {
    		return -1;
    	}
	}
    
    public static int test3(String S) {
    	Stack<Integer> stack = new Stack<>();
    	
    	String[] splitedStr = S.split(" ");
    	
    	for(String token : splitedStr) {	
    		switch (token) {
				case "DUP":
					if(stack.isEmpty()) {
						return -1;
					} else {
						int prevElement = stack.lastElement();
						stack.push(prevElement);
					}
					break;
				case "POP":
					if(stack.isEmpty()) {
						return -1;
					} else {
						stack.pop();
					}
					break;
				case "+":
					if(stack.isEmpty()|| stack.size() < 2) {
						return -1;
					} else {
						int intValue1 = stack.pop();
						int intValue2 = stack.pop();
						
						if(intValue1 + intValue2 > Math.pow(2, 20) -1)
							return -1;
						else
							stack.push(intValue1 + intValue2);
					}
					break;
				case "-":
					if(stack.isEmpty() || stack.size() < 2) {
						return -1;
					} else {
						int intValue1 = stack.pop();
						int intValue2 = stack.pop();
						
						if(intValue1 - intValue2 < 0)
							return -1;
						else
							stack.push(intValue1 - intValue2);
					}
					break;
				default:
					try {
						int intValue = Integer.parseInt(token);
						stack.push(intValue);
					} catch (NumberFormatException e) {
						return -1;
					}
					break;
			}
    	}
    	
    	return stack.pop();
    }
      
    public static String test2(String S) {
    	  String result = "";
    	   int length = S.length();
    	   
    	   if (length == 0) {
    	       return S;
    	   }

    	   char oldChar = S.charAt(0);
    	   result += oldChar;
    	   
    	   for (int i= 1 ; i <length ; i++) {
    	       char newChar = S.charAt(i);
    	       
    	       if (newChar == oldChar) {
    	    	   result = result.substring(0, result.length() -1);
    	    	   
    	    	   if(result.length() == 0 ) {
    	    		   oldChar = 0;
    	    	   } else {
    	    		   oldChar = result.charAt(result.length() -1);
    	    	   }
    	    
    	       } else {
    	    	   result += newChar;
    	           oldChar = newChar;
    	       }
    	   }
    	   
    	   return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(test3("13 DUP 4 POP 5 DUP + DUP + -"));
	}
	
	public static int solution1(String S) {
		int open = 0;
		int close = 0;
		
		int leftCount = 0;
		int rightCount = 0;
		
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '(')
				open++;
			else if(S.charAt(i) == ')')
				close++;
			
			if(open == close) {
				leftCount += open;
				open = 0;
				close = 0;
			}
			
			if(i == S.length() -1)
				rightCount = close;
		}
	
		return leftCount + rightCount;
    }
	
	public static int[] solution2(int N) {
		Set<Integer> intSet = new HashSet<>();
		int[] arr = new int[N];
		int sum = 0;
		
		while(intSet.size() == 0 || !isSetSumZero(intSet)) {
			
			if(intSet.size() == N)
				break;
		}
		
		return setToArr(intSet);
    }
	
	public static boolean isSetSumZero(Set<Integer> input) {
		int sum = 0;
		
		for(int integer : input)
			sum += integer;
		
		return sum == 0;
	}
	
	public static int[] setToArr(Set<Integer> input) {
		int[] arr = new int[input.size()];
		
		Iterator<Integer> iter = input.iterator();
		
		for(int i = 0; iter.hasNext(); i++) {
			arr[i] = (int) iter.next();
		}
	
		return arr;	
	}
	
	int solution(int A[], int X, int Y, int Z) {
	    int num = A.length; // A의 길이
	    
	    int index = 0;
	    int watingX = 0, watingY = 0, watingZ = 0; // wating
	    int totalCarWating = 0;
	    int D = 0;
	    
	    boolean timeInc = false;
	    
	    while (true) {
	        if (timeInc) {
	            if (watingX > 0) {
	                watingX --;
	            }
	            if (watingY > 0) {
	                watingY --;
	            }
	            if (watingZ > 0) {
	                watingZ --;
	            }
	        }
	        
	        if (watingX > 0 && watingY > 0 && watingZ > 0) { // 빈 게 없음
	            totalCarWating ++;
	            timeInc = true;
	            continue;
	        }
	        
	        
	        
	        if (index >= num) { // 남은 차가 없음
	            break;
	        }
	        
	        if (timeInc == false) { // 다음 차
	            D = A[index];
	        }
	        
	        
	        if (X < D && Y < D && Z < D) { // 남은 기름이 모자람
	            return -1;
	        }
	        
	        // 지금 빈 것 중에 연료 채울 수 있으면
	        if (watingX == 0 && X >= D) {
	            X -= D;
	            watingX = D;
	        } else if (watingY == 0 && Y >= D) {
	            Y -= D;
	            watingY = D;
	        } else if (watingZ == 0 && Z >= D) {
	            Z -= D;
	            watingZ = D;
	        } else {// 현재는 채울 수 없으면
	            totalCarWating ++;
	            timeInc = true;
	            continue;
	        }
	        
	        timeInc = false;
	        index ++;
	    }
	    
	    return totalCarWating;
	}
}
