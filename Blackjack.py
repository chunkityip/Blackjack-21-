import random

class Blackjack(object):
    def __init__(self):
        print('Weclome to The Blackjack game')
        self.balance = int(input('Enter how much you want to play?'))
        self.bit = int(input('How much token you want to bit? 100 or 500 or 1000:'))


    def game_card(self):
        player_card1 = random.randint(1, 11)
        player_card2 = random.randint(1, 11)
        computer_card1 = random.randint(1, 11)
        computer_card2 = random.randint(1, 11)
        self.computer_card = computer_card1 + computer_card2
        self.player_card = player_card1 + player_card2
        print(f'Your card: {player_card1},{player_card2} \nYour competitor card: {computer_card1}')
        answer = input('Hit or Stand?:')
        if answer == 'Hit':
            self.player_card  += random.randint(1, 11)
            print(self.player_card)
        else:
            print(self.player_card)

    def win_conuation(self):
        win = []
        if (self.player_card > 21 and self.computer_card > 21) or (21 - self.player_card < 21 - self.computer_card) or (self.player_card == 21):
            win == 'Player win'
            self.balance += self.bit
            print(f'You win! Your have {self.player_card} and Your competitor only have {self.computer_card} \nYou have {self.balance}')
        elif (self.computer_card > 21 and self.player_card > 21) or (21 - self.computer_card < 21 - self.player_card) or (self.computer_card == 21):
            win == 'Computer win'
            self.balance -= self.bit
            print(f'You lostt! Your only have {self.player_card} and Your competitor  have {self.computer_card} \nYou have {self.balance}')
        elif (self.player_card == self.computer_card):
            win =='Push'
            return win
        elif self.balance < self.bit:
            print('Sorry, you lose all the money')

    def replay(self):
        return input('Do you want to play again? Y or N').startswith('Y')

def main():
        while True:
            card_game = Blackjack()
            card_game.game_card()
            card_game.win_conuation()
            if card_game.replay() == False:
                break


if __name__ == "__main__":
    main()




