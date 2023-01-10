class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        adjlist={}
        for i in points:
            set=adjlist.pop(i[0],{})
            set.add(i[1])
            adjlist.add(i[0],set)

        maxrecall=0
        for i in range (len(points)):
            for j in range(i,len(points)):
                a=
                b=
                for(){
                    
                }
