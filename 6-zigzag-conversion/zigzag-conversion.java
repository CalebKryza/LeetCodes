//Read going down string changing row for each letter ArrayList? StringBuilder? 
//Once bottom is hit go back up doing same thing
//Add all rows of string together at end, return result
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean isGoingDown = false;

        for(char c : s.toCharArray()){
            rows[currRow].append(c);
            if(currRow == 0 || currRow == numRows - 1){
                isGoingDown = !isGoingDown;
            }
            currRow += isGoingDown ? 1 : -1;

        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();

    }
}