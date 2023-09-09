public class FenwickTreeRangeSum {
    int[] fTree;
    int[] arr;
    public FenwickTreeRangeSum(int[] nums) {
        arr = nums;
        fTree = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            fTree[i+1] = nums[i];
        }
        createFenwickTree();
    }
    
    private void createFenwickTree() {
        for(int i = 1; i < fTree.length; i++) {
            int p = i + (i & -i);
            if(p < fTree.length) {
                fTree[p] += fTree[i];
            }
        }
    }
    
    public void update(int index, int val) {
        
        int valToAdd = val - arr[index];
        arr[index] = val;
        index++;
        while(index < fTree.length) {
            fTree[index] += valToAdd;
            index += (index & -index);
        }
    }
    
    private int findSum(int toIndex) {
        int sum = 0;
        while(toIndex > 0) {
            sum += fTree[toIndex];
            toIndex -= (toIndex & -toIndex);
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        
        int firstSum = findSum(right + 1);
        int secondSum = findSum(left);
        
        return firstSum - secondSum;
        
    }
}
