package wayfair;

import java.util.*;

/*
Given an array[]task_memory, representing the memory requirements for each task,
 and another array[]task_type, representing the type of each task, along with an
 integer[]max_memory which is the maximum memory the server can use to process
 two tasks concurrently, your function should calculate the minimum amount of time
  required to process all tasks. Each task requires 1 unit of time to process.
  The server can process two tasks at the same time only if:

They are of the same type.

Their combined memory usage does not exceed max_memory.

Example 1:

Input: n = 4, task_memory = [7, 2, 3, 9], task_type = [1, 2, 1, 3], max_memory = 10

Output: 3



Explanation:

- Tasks 0 (type 1, memory 7) and 2 (type 1, memory 3) can be processed together in 1 unit of time because their combined memory (10) matches the max_memory limit.

- Task 1 (type 2, memory 2) and Task 3 (type 3, memory 9) must be processed separately, taking 1 unit of time each due to differing types and exceeding memory constraints.

Thus, the total time required is 1 + 1 + 1 = 3 units.*/
public class MemoryTaskProblem {
    public static void main(String[] args) {
        int [] task_memory = {7, 2, 3, 9,3};
        int [] task_type = {1, 2, 1, 3, 1};
        int max_memory = 10;
        int minMemory=findMinMemoryReqForTasks(task_memory,task_type,max_memory);
        int minMemoryPrac=findMinMemoryReqForTasksPrac(task_memory,task_type,max_memory);
        System.out.println("minMemory: "+minMemory);
        System.out.println("minMemoryPrac: "+minMemoryPrac);

        // Additional test case: All tasks of the same type, all can be paired
        int n2 = 6;
        int[] task_memory2 = {1, 2, 3, 4, 5, 6};
        int[] task_type2 = {1, 1, 1, 1, 1, 1};
        int max_memory2 = 7;
        // Expected Output: 3
        // Explanation:
        // Type 1: [1,2,3,4,5,6] sorted.
        // - Pair (1,6) -> memory 7. Time: 1. Remaining: [2,3,4,5]
        // - Pair (2,5) -> memory 7. Time: 2. Remaining: [3,4]
        // - Pair (3,4) -> memory 7. Time: 3. Remaining: []
        // Total time = 3.
        System.out.println("Example 2 Output: " + findMinMemoryReqForTasks(task_memory2, task_type2, max_memory2));

        System.out.println("--------------------");

        // Additional test case: Mixed types, some pairs, some singles
        int n3 = 7;
        int[] task_memory3 = {1, 5, 10, 2, 8, 3, 6};
        int[] task_type3 = {1, 1, 2, 1, 2, 1, 3};
        int max_memory3 = 10;
        // Expected Output: 5
        // Explanation:
        // Type 1: [1,2,3,5] sorted. Max memory 10.
        //   - Pair (1,5) -> memory 6. Time: 1. Remaining: [2,3]
        //   - Pair (2,3) -> memory 5. Time: 2. Remaining: []
        // Type 2: [8,10] sorted. Max memory 10.
        //   - (8,10) -> memory 18 (>10). Task 10 processed alone. Time: 1. Remaining: [8]
        //   - Task 8 processed alone. Time: 2. Remaining: []
        // Type 3: [6] sorted. Max memory 10.
        //   - Task 6 processed alone. Time: 1. Remaining: []
        // Total time = 2 (for type 1) + 2 (for type 2) + 1 (for type 3) = 5.
        System.out.println("Example 3 Output: " + findMinMemoryReqForTasks(task_memory3, task_type3, max_memory3));

        System.out.println("--------------------");

        // Edge case: No tasks
        int n4 = 0;
        int[] task_memory4 = {};
        int[] task_type4 = {};
        int max_memory4 = 10;
        // Expected Output: 0
        System.out.println("Example 4 Output: " + findMinMemoryReqForTasks(task_memory4, task_type4, max_memory4));
    }
    private static int findMinMemoryReqForTasksPrac(int[] taskMemory, int[] taskType, int maxMemory) {
        int minMemory=0;
        Map<Integer,List<Integer>> map= new HashMap<Integer,List<Integer>>();
        for(int i=0;i<taskMemory.length;i++)
        {
            map.computeIfAbsent(taskType[i],k->new ArrayList<Integer>()).add(taskMemory[i]);
        }

        for(List<Integer> taskMem:map.values())
        {
            Collections.sort(taskMem);
            int i=0;
            int j=taskMem.size()-1;
            while(i<j)
            {
                if(taskMem.get(i) + taskMem.get(j) <=maxMemory)
                {
                    minMemory++;
                    i++;
                    j--;
                }else {
                    minMemory++;
                    j--;
                }
            }
            if(i==j)
            {
                minMemory++;
            }
        }
        return minMemory;
    }

    private static int findMinMemoryReqForTasks(int[] taskMemory, int[] taskType, int maxMemory) {
        //create a map of task and its corresponding memory
        Map<Integer, List<Integer>> map= new HashMap<>();

        for(int i=0;i<taskMemory.length;i++)
        {
            map.computeIfAbsent(taskType[i],k-> new ArrayList<Integer>()).add(taskMemory[i]);
        }
        //map.values().stream().mapToInt(m->m.size()).sum();

        int minMemory=0;
        for(List<Integer> memories:map.values())
        {
            Collections.sort(memories);
            int i=0;
            int j=memories.size()-1;
            while(i<j)
            {
                if(memories.get(i)+memories.get(j)<=maxMemory)
                {
                    minMemory++;
                    i++;
                    j--;
                }else
                {
                    minMemory++;
                    i++;
                }
            }
            if(i==j)
            {
                minMemory++;
            }
        }
        return minMemory;
    }


}



