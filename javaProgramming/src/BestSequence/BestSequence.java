package BestSequence;

public class BestSequence {
	
	private int[] comparisionArray = {1,2,3};
	private int[] bestSequenceArray;
	private int count;
	private int result;
	private int sumCnt;
	
	public BestSequence(int[] bestSequenceArray, int count) {
		this.bestSequenceArray = bestSequenceArray;
		this.count = count;
		this.sumCnt = 0;
		this.result = 0;
	}

	public static void main(String[] args) {
		int n = 5;
		BestSequence bestSequence = new BestSequence(new int[n], n);
		bestSequence.findSequences(0);
	}
	
	private void findSequences(int index) {
		if (index < this.count) {
			for(int i = 1; i <= this.comparisionArray.length; i++) {
				this.bestSequenceArray[index] = this.comparisionArray[i-1];
				if (this.validateSequenceValue(index-1, index)) {
					this.findSequences(index+1);
				} else {
					this.bestSequenceArray[index] = 0;
				}
			}
		} else {
			for(int j = 0; j < this.bestSequenceArray.length; j++) {
				System.out.print(this.bestSequenceArray[j] + "  ");
			}
			System.out.println();
		}
	}
	
	private void findMinSequence() {
		
	}
	
	private boolean validateSequenceValue(int index, int curComparisionIndex) {
		int counting = 0;
		int success = 0;
		int fail = 0;
		int stopPoint = 0;
		
		if (index >= 0) {
			while(counting < this.comparisionArray.length) {
				if (index - counting >= 0) {
					if (this.bestSequenceArray[curComparisionIndex] != this.bestSequenceArray[index-counting]) {
						success++;
						
						if (curComparisionIndex < this.comparisionArray.length) {
							break;
						}
					} else {
						
						if (counting == 0) {
							return false;
						}
						
						stopPoint = index-counting;
						fail++;
						break;
					}
				}
				
				counting++;
			}
			
			if (curComparisionIndex <= this.comparisionArray.length) {
				if (success == 0) {
					return false;
				} else {
					if (stopPoint - success >= 0 ) {
						return this.validateSequenceValue(stopPoint-1, curComparisionIndex-1);
					}
				}
			} else {
				if (fail == 0) {
					return true;
				} else {
					if (stopPoint - success >= 0 ) {
						return this.validateSequenceValue(stopPoint-1, curComparisionIndex-1);
					}
				}
			}
		}
		return true;
	}
}
