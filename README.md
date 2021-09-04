# Game-Of-Life
A Java Program that Implements the Game of Life by John Conway, with the following rules:

1. Any live cell with fewer than two live neighboors dies, as if caused by underpopulation
2. Any live cell with two or three live neighbors lives on to the next generation
3. Any live cell with more than three live neighbors dies, as if by overpopulation
4. Any dead cell with exactly the three live neighbors becomes a live cell, as if by reproduction.

The program accepts a 20X20 by grid to initialize the starting grid, similar to this 4X4 grid:

OOOO  
OXXO  
OXXO  
OOOO  

An 'X' indicates a live cell and 'O' indicates an empty space.
The program also accepts a positive integer value indicating the number of generations to compute,
and shows the final grid.

This program utilize threading (a thread for each cell in the grid) to calculate the next generation.

