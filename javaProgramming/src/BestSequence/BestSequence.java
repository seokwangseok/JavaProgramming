package BestSequence;

public class BestSequence {
	
	private int[] comparisionArray;
	private int[] bestSequenceArray;
	private int count;
	
	public BestSequence(int[] bestSequenceArray, int[] comparisionArray, int count) {
		this.bestSequenceArray = bestSequenceArray;
		this.comparisionArray = comparisionArray;
		this.count = count;
	}

	public static void main(String[] args) {
		int n = 7;
		BestSequence bestSequence = new BestSequence(new int[n], new int[1], n);
		bestSequence.findSequence();
	}
	
	private void findSequences() {
		
//		if (index < this.count) {
//			for(int i = 1; i <= this.comparisionArray.length; i++) {
//				this.bestSequenceArray[index] = this.comparisionArray[i-1];
//				if (this.validateSequenceValue(index-1, index)) {
//					this.findSequences(index+1);
//				} else {
//					this.bestSequenceArray[index] = 0;
//				}
//			}
//		} else {
//			for(int j = 0; j < this.bestSequenceArray.length; j++) {
//				System.out.print(this.bestSequenceArray[j] + "  ");
//			}
//			System.out.println();
//		}
	}
	
//	private boolean validateSequenceValue(int index, int curComparisionIndex) {
//		int counting = 0;
//		int success = 0;
//		int fail = 0;
//		int stopPoint = 0;
//		
//		if (index >= 0) {
//			while(counting < this.comparisionArray.length) {
//				if (index - counting >= 0) {
//					if (this.bestSequenceArray[curComparisionIndex] != this.bestSequenceArray[index-counting]) {
//						success++;
//						
//						if (curComparisionIndex < this.comparisionArray.length) {
//							break;
//						}
//					} else {
//						
//						if (counting == 0) {
//							return false;
//						}
//						
//						stopPoint = index-counting;
//						fail++;
//						break;
//					}
//				}
//				
//				counting++;
//			}
//			
//			if (curComparisionIndex <= this.comparisionArray.length) {
//				if (success == 0) {
//					return false;
//				} else {
//					if (stopPoint - success >= 0 ) {
//						return this.validateSequenceValue(stopPoint-1, curComparisionIndex-1);
//					}
//				}
//			} else {
//				if (fail == 0) {
//					return true;
//				} else {
//					if (stopPoint - success >= 0 ) {
//						return this.validateSequenceValue(stopPoint-1, curComparisionIndex-1);
//					}
//				}
//			}
//		}
//		return true;
//	}
	
	private void findSequence() {
		int[] inputArray = {1,2,3};
		for(int i=0; i < inputArray.length; i++) {
			this.comparisionArray = new int[1];
			this.comparisionArray[0] = i+1;
			rotateArray(i);
		}
	}
	
	private void rotateArray(int index) {
		int[] inputArray = {1,2,3};
		this.bestSequenceArray[index] = this.comparisionArray[this.comparisionArray.length-1];
		this.comparisionArray = new int[1];
		if (index < this.count-1) {
			for(int i : inputArray) {
				this.comparisionArray[0] = i;
				if (this.isValidValue(index, this.bestSequenceArray, this.comparisionArray)) {
//					this.bestSequenceArray[index] = this.comparisionArray[this.comparisionArray.length-1];
					
//					this.comparisionArray[0] = i;
					this.rotateArray(index+1);
				} else {
//					index++;
//					this.comparisionArray = new int[1];
//					this.comparisionArray[0] = i;
				}
			}
		} else {
			for(int i = 0; i < this.count; i++) {
				System.out.print(this.bestSequenceArray[i]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	private boolean isEquivalentArray(int index, int[] originArray, int[] compareArray) {
		if (compareArray.length <= this.count/2) {
			int count = 0;
			for(int i = 0; i < compareArray.length; i++) {
//				if (index == 0 || compareArray.length > 1) {
					if (originArray[index+i] == compareArray[i]) {
						count++;
					}
//				} else {
//					if (originArray[i-index] == compareArray[i-1]) {
//						count++;
//					}
//				}
			}
			
			if (count == compareArray.length) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidValue(int index, int[] originArray, int[] compareArray) {
		if (this.isEquivalentArray(index, originArray, compareArray)) {
			this.comparisionArray = new int[1];
			return false;
		}
		
		if (compareArray.length >= originArray.length/2) {
			this.comparisionArray = compareArray;
			return true;
		}
		
		// 여기 조건이 잘못됨 
		if (compareArray.length == 1 && index < 2) {
			this.comparisionArray = compareArray;
			return true;
		}
		
//		compareArray = new int[compareArray.length+1];
		int[] tempArray = this.insertFirstChildInArray(originArray[index], compareArray);
		compareArray = new int[tempArray.length];
		compareArray = tempArray;
		return this.isValidValue(index-compareArray.length, originArray, compareArray);
		
	}
	
	private int[] insertFirstChildInArray(int value, int[] compareArray) {
		int[] tempArray = new int[compareArray.length+1];
		for(int i = 0; i < tempArray.length; i++) {
			if (i == 0) {
				tempArray[i] = value;
			} else {
				tempArray[i] = compareArray[i-1];
			}
		}
		
		return tempArray;
	}
}
