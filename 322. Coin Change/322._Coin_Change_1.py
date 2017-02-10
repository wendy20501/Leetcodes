class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 0
        elif amount < min(coins):
            return -1
        else:
            dp = [0] + [0x7ffffffe] * amount
            for i in xrange(amount + 1):
                for coin in coins:
                    if i+coin <= amount:
                        dp[i+coin] = min(dp[i+coin], dp[i] + 1)
            return dp[amount] if dp[amount]!=0x7ffffffe else -1