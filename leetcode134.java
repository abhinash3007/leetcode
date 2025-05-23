public class leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currTank = 0;
        int currGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }
        return (currGas >= 0) ? start : -1;
    }
}
