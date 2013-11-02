package BestSequence;

public class BestSequence {
	
	private int[] comparisionArray;
	private int[] bestSequenceArray;
	private int count;
	private int totalCount;
	
	public BestSequence(int[] bestSequenceArray, int[] comparisionArray, int count) {
		this.bestSequenceArray = bestSequenceArray;
		this.comparisionArray = comparisionArray;
		this.count = count;
		this.totalCount = 0;
	}

	public static void main(String[] args) {
		int n = 7;
		BestSequence bestSequence = new BestSequence(new int[n], new int[1], n);
		bestSequence.findSequence();
		System.out.println("totalCount : " + bestSequence.totalCount);
	}
	
	private void findSequence() {
		int[] inputArray = {1,2,3};
		for(int i=0; i < inputArray.length; i++) {
			this.comparisionArray = new int[1];
			this.comparisionArray[0] = i+1;
			rotateArray(0);
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
					this.rotateArray(index+1);
				}
			}
		} else {
			for(int i = 0; i < this.count; i++) {
				System.out.print(this.bestSequenceArray[i]);
				System.out.print("  ");
			}
			System.out.println();
			this.totalCount++;
		}
	}
	
	private boolean isEquivalentArray(int index, int[] originArray, int[] compareArray) {
		if (compareArray.length <= this.count/2) {
			int count = 0;
			for(int i = 0; i < compareArray.length; i++) {
				if (originArray[index+i] == compareArray[i]) {
					count++;
				}
			}
			
			if (count == compareArray.length) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidValue(int index, int[] originArray, int[] compareArray) {
		// 더이상 조사할게 없을 때 
		if (index < 0 || compareArray.length > originArray.length/2) {
			this.comparisionArray = compareArray;
			return true;
		}
		
		if (this.isEquivalentArray(index, originArray, compareArray)) {
			this.comparisionArray = new int[1];
			return false;
		}
		
		int value = (compareArray.length > 1) ? originArray[index+compareArray.length-1] : originArray[index];
		int[] tempArray = this.insertFirstChildInArray(value, compareArray);
		compareArray = new int[tempArray.length];
		compareArray = tempArray;
		
		return this.isValidValue(index-2, originArray, compareArray);
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
