class Solution {
    public int numRescueBoats(int[] people, int limit) {
         Arrays.sort(people);

        int boat = 0;
        int i = 0;                 
        int j = people.length - 1;  

        while (i <= j) {
            int going = people[j];

            if (i != j && going + people[i] <= limit) {
                i++;    
            }
            j--;   
            boat++;
        }

        return boat;
    }
}