def horizontal_lines():
    print("-" * 13)

def display_board(board):
    horizontal_lines()
    for i in range(3):
        print("| ", end="")
        for j in range(3):
            print(board[i][j], end=" | ")
        print()
        horizontal_lines()

def check_row_wise(board):
    for i in range(3):
        if board[i][0] == board[i][1] and board[i][1] == board[i][2]:
            return i
    return -1

def check_col_wise(board):
    for i in range(3):
        if board[0][i] == board[1][i] and board[1][i] == board[2][i]:
            return i
    return -1

def check_diagonal(board):
    if board[0][0] == board[1][1] and board[1][1] == board[2][2]:
        return True
    if board[0][2] == board[1][1] and board[1][1] == board[2][0]:
        return True
    return False

def check_all_validations(board, player1, player2):
    which_row = check_row_wise(board)
    if which_row != -1:
        if board[which_row][0] == 'X':
            print(f"{player1} has Won the Game")
        else:
            print(f"{player2} has Won the Game")
        return True

    which_col = check_col_wise(board)
    if which_col != -1:
        if board[0][which_col] == 'X':
            print(f"{player1} has Won the Game")
        else:
            print(f"{player2} has Won the Game")
        return True

    if check_diagonal(board):
        if board[1][1] == 'X':
            print(f"{player1} has Won the Game")
        else:
            print(f"{player2} has Won the Game")
        return True

    return False

def is_draw(board):
    for i in range(3):
        for j in range(3):
            if board[i][j] >= '1' and board[i][j] <= '9':
                return False
    return True

def lets_play_tic_tac_toe(board):
    player1 = input("Enter Player1 Name: ")
    player2 = input("Enter Player2 Name: ")

    is_game_on = True
    is_player1_turn = True

    while is_game_on:
        if not check_all_validations(board, player1, player2):
            does_user_select_proper_block = False
            while not does_user_select_proper_block:
                if is_draw(board):
                    print("It's a Draw!")
                    is_game_on = False
                    break

                if is_player1_turn:
                    print(f"{player1}, which Block are you choosing?")
                else:
                    print(f"{player2}, which Block are you choosing?")

                try:
                    pick = int(input()) - 1
                    row = pick // 3
                    col = pick % 3
                    if board[row][col] >= '1' and board[row][col] <= '9':
                        board[row][col] = 'X' if is_player1_turn else 'O'
                        is_player1_turn = not is_player1_turn
                        does_user_select_proper_block = True
                        display_board(board)
                    else:
                        print("Block already taken or invalid. Try again.")
                except (ValueError, IndexError):
                    print("Invalid input. Please enter a number between 1-9.")
        else:
            break

def main():
    board = [['1', '2', '3'],
             ['4', '5', '6'],
             ['7', '8', '9']]
    
    display_board(board)
    lets_play_tic_tac_toe(board)

if __name__ == "__main__":
    main()
