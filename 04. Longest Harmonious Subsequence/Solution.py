class Solution(object):
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        d = collections.Counter(nums)
        res = 0
        for i in d:
            if i + 1 in d:
                res = max(res, d[i + 1] + d[i])
        return res

