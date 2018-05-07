/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers
in such a way that each column, each row, and each of the nine 3 × 3 sub-grids
that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents
a valid Sudoku puzzle according to the layout rules described above.
Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column.
Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

Input/Output

[execution time limit] 4 seconds (py3)

[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9'
or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false.
*/

public class sudoku2 {
    boolean sudoku2(char[][] grid) {
        if(!validInRows(grid)) return false;
        if(!validInColumns(grid)) return false;
        if(!validInSubsquares(grid)) return false;
        return true;
    }

    boolean validInRows(char[][] puzzle){
        int n = puzzle.length;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(puzzle[r][c] != '.'){
                    for(int i=c+1; i<n; i++){
                        if(puzzle[r][c]==puzzle[r][i]) return false;
                    }
                }
            }
        }
        return true;
    }

    boolean validInColumns(char[][] puzzle){
        int n = puzzle.length;
        for(int c=0; c<n; c++){
            for(int r=0; r<n; r++){
                if(puzzle[r][c] != '.'){
                    for(int i=r+1; i<n; i++){
                        if(puzzle[r][c]==puzzle[i][c]) return false;
                    }
                }
            }
        }
        return true;
    }

    boolean validInSubsquares(char[][] puzzle){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!validInSquare(puzzle,i,j)) return false;
            }
        }
        return true;
    }

    boolean validInSquare(char[][] puzzle, int i, int j){
        char[] p = new char[9];
        int x = 0;
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                p[x++] = puzzle[i*3+r][j*3+c];
            }
        }
        int n = p.length;
        for(int y=0; y<n; y++){
            if(p[y] != '.'){
                for(int z=y+1; z<n; z++){
                    if(p[y]==p[z]) return false;
                }
            }
        }
        return true;
    }
}
