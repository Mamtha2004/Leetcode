class Solution {
    public String convert(String s, int numRows) {
      
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create a place to store each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;      // start at row 0
        int step = 1;     // direction: 1 = down, -1 = up

        // Go through each character in the string
        for (char c : s.toCharArray()) {
            rows[row].append(c); // put char in correct row

            // Change direction at top or bottom
            if (row == 0) step = 1;            // go down
            else if (row == numRows - 1) step = -1; // go up

            row += step; // move to next row
        }

        // Join all rows together
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}
        

