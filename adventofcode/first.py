from collections import defaultdict

with open("first.txt", "r+") as input:
    lines = input.readlines()

    list1 = []
    list2 = []
    for line in lines:
        first, second = line.split("   ")
        first = int(first)
        second = int(second)
        list1.append(first)
        list2.append(second)

    # list1.sort()
    # list2.sort()

    # total = 0
    # for i in range(0, len(list1)):
    #     num1 = list1[i]
    #     num2 = list2[i]

    #     total = total + abs(num1-num2)
    
    # print(total)

    counts = dict()
    for i in range(0, len(list2)):
        counts[list2[i]] = counts.get(list2[i], 0)+1

    ss = 0
    for num in list1:
        ss += num * counts.get(num, 0)
    
    print(ss)
