  
import random

score = 0

def horizontalLine():
    print("-----------------")

def displayBoard(board):
    for i in range(4):
        horizontalLine()
        for j in range(4):
            if board[i][j] == 0:
                print("|   ", end="")
            else:
                print("|", board[i][j], end=" ")
        print("|")
    horizontalLine()
    print("\nScore:", score)

def initialSetup(board):
    row = random.randint(0, 3)
    col = random.randint(0, 3)
    board[row][col] = 2

    row = random.randint(0, 3)
    col = random.randint(0, 3)
    board[row][col] = 2

def computation(lst):
    global score
    result = []
    i = 0
    while i < len(lst) - 1:
        a = lst[i]
        b = lst[i + 1]
        if a == b:
            result.append(a + b)
            score += a + b
            i += 2
        else:
            result.append(a)
            i += 1
    if i < len(lst):
        result.append(lst[-1])
    return result

def movementLeftSide(board, row):
    lst = []
    for i in range(4):
        if board[row][i] != 0:
            lst.append(board[row][i])
    return computation(lst)

def movementRightSide(board, row):
    lst = []
    for i in range(3, -1, -1):
        if board[row][i] != 0:
            lst.append(board[row][i])
    return computation(lst)

def movementUpSide(board, col):
    lst = []
    for i in range(4):
        if board[i][col] != 0:
            lst.append(board[i][col])
    return computation(lst)

def movementDownSide(board, col):
    lst = []
    for i in range(3, -1, -1):
        if board[i][col] != 0:
            lst.append(board[i][col])
    return computation(lst)

def didPlayerWon(board):
    for i in range(4):
        for j in range(4):
            if board[i][j] == 2048:
                return True
    return False

def didPlayerLost(board):
    for i in range(4):
        for j in range(4):
            if board[i][j] == 0:
                return False
            if j != 3 and board[i][j] == board[i][j + 1]:
                return False
            if i != 3 and board[i][j] == board[i + 1][j]:
                return False
    return True

def randomPlace2(board):
    while True:
        row = random.randint(0, 3)
        col = random.randint(0, 3)
        if board[row][col] == 0:
            board[row][col] = 2
            break

def playGame2048():
    SIZE = 4
    board = [[0 for _ in range(SIZE)] for _ in range(SIZE)]
    displayBoard(board)
    initialSetup(board)
    displayBoard(board)

    while True:
        movement = input("Choose a-w-s-d:\n").strip()

        if movement == 'w':
            # Move Up
            for j in range(4):
                lst = movementUpSide(board, j)
                idx = 0
                for i in range(len(lst)):
                    board[idx][j] = lst[i]
                    idx += 1
                while idx < 4:
                    board[idx][j] = 0
                    idx += 1

        elif movement == 's':
            # Move Down
            for j in range(4):
                lst = movementDownSide(board, j)
                idx = 3
                for i in range(len(lst)):
                    board[idx][j] = lst[i]
                    idx -= 1
                while idx >= 0:
                    board[idx][j] = 0
                    idx -= 1

        elif movement == 'd':
            # Move Right
            for i in range(4):
                lst = movementRightSide(board, i)
                idx = 3
                for j in range(len(lst)):
                    board[i][idx] = lst[j]
                    idx -= 1
                while idx >= 0:
                    board[i][idx] = 0
                    idx -= 1

        else:
            # Move Left
            for i in range(4):
                lst = movementLeftSide(board, i)
                for j in range(len(lst)):
                    board[i][j] = lst[j]
                for j in range(len(lst), 4):
                    board[i][j] = 0

        randomPlace2(board)
        displayBoard(board)

        if didPlayerWon(board):
            print("Ayyayyaya Super ayyyy!!!!")
            return
        if didPlayerLost(board):
            print("Assalu taggedhele!!!")
            return

if __name__ == "__main__":
    playGame2048()

    
