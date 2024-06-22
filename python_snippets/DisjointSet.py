class DisjointSet:
    def __init__(self, n):
        self.parent = list(range(n))

    def find(self, item):
        # if not reaching the root, we shrink parent
        if self.parent[item] !=item:
            self.parent[item]=self.find(self.parent[item])
        return self.parent[item]
    
    def union(self, set1, set2):
        # set parent of set 1 to set 2
        self.parent[self.find(set1)] = self.find(set2)

    def is_disjoint(self, set1, set2):
        return self.find(set1)!=self.find(set2)
    
    def _print_parents(self):
        print(self.parent)
  
# Example driver code
if __name__ == "__main__":
    ds = DisjointSet(5)
    print("Print all vertices in ")
    ds.union(1,2)
    ds._print_parents()
    ds.union(3,2)
    ds._print_parents()
    print(ds.find(3)) 
    ds.union(4,0)
    ds._print_parents()
    print(ds.is_disjoint(0,1)) 
    ds._print_parents()
    print(ds.is_disjoint(2,3)) 