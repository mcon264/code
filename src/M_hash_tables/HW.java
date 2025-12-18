package M_hash_tables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class HashSetQuestions {
    public static int maxLength(Set<String> set) {
        int longestLength = 0;

        for (String s : set) {
            int length = s.length();

            if (length > longestLength) {
                longestLength = length;
            }
        }

        return longestLength;
    }

    public static int numUniqueValues(List<Integer> list) {
        return new HashSet<>(list).size();
    }

    public static int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        int count = 0;

        for (Integer element : set1) {
            if (set2.contains(element)) {
                count++;
            }
        }

        return count;
    }

    public static void removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        list.clear();

        for (Integer element : set) {
            list.add(element);
        }
    }

    public static Set<Integer> unionSets(Set<Set<Integer>> setOfSets) {
        Set<Integer> union = new HashSet<>();

        for (Set<Integer> set : setOfSets) {
            for (Integer element : set) {
                union.add(element);
            }
        }

        return union;
    }

    public static int wordCount(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        Set<String> words = new HashSet<>();

        while (fileScanner.hasNext()) {
            words.add(fileScanner.next());
        }

        return words.size();
    }

    public static boolean containsDuplicate_v1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size() != nums.length;
    }

    public boolean containsDuplicate_v2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}

class CountNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> nameCounts = new HashMap<>();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        while (!name.isEmpty()) {
            nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);

            System.out.print("Enter name: ");
            name = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            System.out.println("Entry [" + entry.getKey() + "] has count " + entry.getValue());
        }
    }
}

class HashMapQuestions {
    public static Map<Integer, Integer> counts(List<Integer> list, Set<Integer> set) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : set) {
            map.put(i, 0);
        }

        for (Integer i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }

        return map;
    }

    public static boolean hasDuplicateValue(Map<String, String> map) {
        // one approach:
        // Set<String> valueSet = new HashSet<>();
        // for (String value : map.values())
        //     if (!valueSet.add(value))
        //         return true;
        // return false;

        // another approach:
        return new HashSet<>(map.values()).size() != map.size();
    }

    public static boolean hasThree(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int count : map.values()) {
            if (count >= 3) {
                return true;
            }
        }

        return false;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // one way:
        Set<Integer> set = new HashSet<>();
        for (Integer i : occurrences.values()) {
            if (!set.add(i)) {
                return false;
            }
        }
        return true;

        // a different way:
        // return new HashSet<>(occurrences.values()).size() == occurrences.size();
    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        int sum = 0;

        for (int num : frequencies.keySet()) {
            if (frequencies.get(num) == 1) {
                sum += num;
            }
        }

        return sum;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // keys are the array elements; values are indexes

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    public static int frequencyCount(List<String> collection, int desiredFrequency) {
        Map<String, Integer> frequencies = new HashMap<>();

        for (String s : collection) {
            frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
        }

        int count = 0;

        for (int frequency : frequencies.values()) {
            if (frequency == desiredFrequency) {
                count++;
            }
        }

        return count;
    }

    public static int maxFrequency(List<String> collection) {
        Map<String, Integer> frequencies = new HashMap<>();

        for (String s : collection) {
            frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
        }

        int max = 0;

        for (int frequency : frequencies.values()) {
            if (frequency > max) {
                max = frequency;
            }
        }

        return max;
    }
}