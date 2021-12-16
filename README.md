# codingame-dungeon3D
Answer to https://www.codingame.com/ide/puzzle/dungeon-3d

>>"Object-oriented programming is an exceptionally bad idea which could only have originated in California.”
>
>Edsger DIJKSTRA (https://crypto.stanford.edu/~blynn/c/object.html)


### GAME

"Anya and her team of adventurers are battling in a multi-layered labyrinth beneath Waterdeep. Skeletons and Kobolds are lurking around every corner. Luckily Anya found the dungeon map which shows the structure of all layers of the dungeon including the location of a health-restoring Hot Spring."

"Anya identified the team's current location on the map. She has to find the path to the Hot Spring to rebuild the team's health for prolonged battles."

"All layers of the dungeon have the same rectangular dimension composed of cubic cells. The layers are connected by vertical ladders for climbing up or down."

### INPUT
"Three integers L R C
L is the number of levels making up the dungeon.
R and C are the number of rows and columns making up the plan of each level."

"ln calculated from L * (R+1), which is the total number of lines below it."

"The following ln lines: These are the floor plans of all levels, arranged in order from the surface layer to the deepest underground layer.
Each level floor plan starts with a blank line and then R lines of characters."

"Each character describes one cell of the dungeon. An accessible cell, a passage, is represented by a dot. An inaccessible cell, a wall, is represented by '#'."

"The current location of Anya is indicated by 'A' and the Hot Spring by the letter 'S'.
The boundary of the dungeon is hard rock, not drawn on the map."


### OUTPUT

"Write an integer, the shortest time in minutes for the team to arrive at the Spring."

"In case it is impossible, write a line:
NO PATH"