package BestSequence;

public class BestSequence {
	
	private int[] comparisionArray = {1,2,3};
	private int[] bestSequenceArray;
	private int[][] bestSequencesArray;
	private int count;
	private int result = 0;
	
	public BestSequence(int[] bestSequenceArray, int count) {
		this.bestSequenceArray = bestSequenceArray;
		this.count = count;
	}

	public static void main(String[] args) {
		int n = 5;
		BestSequence bestSequence = new BestSequence(new int[n], n);
		bestSequence.findSequences(0);
	}
	
	private void findSequences(int index) {
		if (index < this.count) {
			for(int i = 0; i < this.comparisionArray.length; i++) {
				if (this.validateSequenceValue(index-1, i)) {
					this.bestSequenceArray[index] = this.comparisionArray[i];
					this.findSequences(index+1);
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
		if (index >= 0) {
			while(counting <= curComparisionIndex) {
				if (index-counting >= 0) {
					if (this.comparisionArray[curComparisionIndex] == this.bestSequenceArray[index-counting]) {
						return false;
					}
				}
				counting++;
			}
		}
		return true;
	}
}
