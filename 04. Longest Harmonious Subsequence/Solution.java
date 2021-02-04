class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
    	int LHS = 0;

	    for (int num : nums) {
		    int currLHS = 0;
		    if (map.containsKey(num - 1) || map.containsKey(num + 1)) {
			    currLHS = map.getOrDefault(num - 1, 0);
			    currLHS = Math.max(currLHS, map.getOrDefault(num + 1, 0));
			    currLHS += map.getOrDefault(num, 0);
    			LHS = Math.max(LHS, 1 + currLHS);
	    	}

		    map.put(num, map.getOrDefault(num, 0) + 1);
	    }
    	return LHS;
    }
}



/*
  In this approach, we make use of a hashmap map which stores the number of times an element occurs in the array along with the element's value in the form (num, count_num), where num refers to an element in the array and count_num refers to the number of times this num occurs in the numsnums array. 
  We traverse over the nums array, and while doing the traversals, we can determine the lengths of the harmonic subsequences possible till the current index of the nums array.
  For every key of the map considered, say key, we find out if the map contains the key+1 as well as key-1. This is needed because it could be possible that key has already been added to the map and later on key-1 is encountered. In this case, if we consider the presence of key+1 only, we'll go in the wrong direction. 
  Now, whenver we find that key+1 or key-1 exists in the keys of map, we determine the count of the current harmonic subsequence as count_{key} + count_{key+1}, where count_​i refers to the value corresponding to the key_i in map, which represents the number of times i occurs in the array nums. Thus, we consider the counts corresponding to both the cases separately for every key and determine the maximum out of them.

Complexity Analysis
    Time  complexity : O(n). Only one loop is required.
    Space complexity : O(n). In worst case map size grows upto size n.
*/
