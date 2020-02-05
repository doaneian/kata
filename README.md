# kata
Requirements to run:
- Java 8
- Maven

To run:
1. Clone this repository
2. Checkout the develop branch
3. Run mvn clean package
4. Run the kata-1.0-SNAPSHOT.jar file
5. Post to /wordSearch

Post body:
 - First line is comma delimited list of words to search for
 - Following lines are comma delimited list of characters that consist of each row
 - Example of post body:
 
```
BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA
U,M,K,H,U,L,K,I,N,V,J,O,C,W,E
L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G
H,S,U,P,J,P,R,J,D,H,S,B,X,T,G
B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E
A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D
S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F
B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z
O,K,R,I,K,A,M,M,R,M,F,B,A,P,P
N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S
E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K
S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D
T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K
O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H
W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S
K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B
```

Response is a map, each key is the searched word, and the value is the list of coordinates that each letter appears in the puzzle.

Example response:

```
{
    "KIRK": [
        {
            "x": 4,
            "y": 7
        },
        {
            "x": 3,
            "y": 7
        },
        {
            "x": 2,
            "y": 7
        },
        {
            "x": 1,
            "y": 7
        }
    ],
    "BONES": [
        {
            "x": 0,
            "y": 6
        },
        {
            "x": 0,
            "y": 7
        },
        {
            "x": 0,
            "y": 8
        },
        {
            "x": 0,
            "y": 9
        },
        {
            "x": 0,
            "y": 10
        }
    ],
    "KHAN": [
        {
            "x": 5,
            "y": 9
        },
        {
            "x": 5,
            "y": 8
        },
        {
            "x": 5,
            "y": 7
        },
        {
            "x": 5,
            "y": 6
        }
    ],
    "SULU": [
        {
            "x": 3,
            "y": 3
        },
        {
            "x": 2,
            "y": 2
        },
        {
            "x": 1,
            "y": 1
        },
        {
            "x": 0,
            "y": 0
        }
    ],
    "SPOCK": [
        {
            "x": 2,
            "y": 1
        },
        {
            "x": 3,
            "y": 2
        },
        {
            "x": 4,
            "y": 3
        },
        {
            "x": 5,
            "y": 4
        },
        {
            "x": 6,
            "y": 5
        }
    ],
    "SCOTTY": [
        {
            "x": 0,
            "y": 5
        },
        {
            "x": 1,
            "y": 5
        },
        {
            "x": 2,
            "y": 5
        },
        {
            "x": 3,
            "y": 5
        },
        {
            "x": 4,
            "y": 5
        },
        {
            "x": 5,
            "y": 5
        }
    ],
    "UHURA": [
        {
            "x": 4,
            "y": 0
        },
        {
            "x": 3,
            "y": 1
        },
        {
            "x": 2,
            "y": 2
        },
        {
            "x": 1,
            "y": 3
        },
        {
            "x": 0,
            "y": 4
        }
    ]
}
```
