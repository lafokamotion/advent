# was struggling with my grasp on Python and day 21 of Advent of code
# trying to learn this stuff, I copied the code from: https://github.com/SwampThingTom/AoC2021/blob/main/Python/21-DiracDice/DiracDice.py


#!/usr/bin/python3

# p1 = 7
# p2 = 5
# p1_tot = 7
# p2_tot = 5

# # die = range(1,100)
# # spots = range(1,10)

# # totals = {
# #     "p1": p1,
# #     "p2": p2
# # }

# roll_count = 0
# roll_hundreth = 0

class Die:
    # constructor!
    def __init__(self):
        self.num_rolls = 0
        self.last_roll = 0
        self.last_sum = -3

    # specific method for returning the class object Die as a string
    def __repr__(self):
        last_roll_1 = self.last_roll-2
        if last_roll_1 < 1:
            last_roll_1 += 100
        repr = '(' + str(last_roll_1) + '..' + str(self.last_roll) + ') ='
        return repr + str(self.last_sum)
    
    # method for handling the next sum
    def next_sum(self):
        self.num_rolls += 3
        self.last_roll += 3
        last_sum = self.last_sum + 9
        if self.last_roll > 100:
            self.last_roll -= 100
            last_sum -= 100 * self.last_roll
            self.last_sum = last_sum - 100
        else:
            self.last_sum = last_sum
        return last_sum

    # was headed in the right direction but without a constructor, it was hard to keep relevant values around
    # def roll_die_thrice():
    #     sum = 0
    #     global roll_count
    #     global roll_hundreth
    #     for i in range(1,3):
    #         roll_count+=1
    #         if roll_count > 100:
    #             roll_count = 1
    #             roll_hundreth+=100
    #         sum+=roll_count
    #     if sum%10 == 0:
    #         return 10
    #     return sum%10

def roll_die(position):
    die = Die()
    score = [0,0]
    player = 0
    while True:
        position[player] = (position[player] + die.next_sum()) % 10
        score[player] += position[player]+1
        if score[player] >= 1000:
            break
        player = 1 - player
    return score[1 - player] * die.num_rolls

# again, right direction but i should've had the mod 10 in here
# having a class object defined would've made my life much easier
# while True:
#     move = roll_die_thrice()
#     p1_tot+=move
#     if p1_tot >= 1000:
#         break
#     move = roll_die_thrice()
#     p2_tot+=move
#     if p2_tot >= 1000:
#         break
# print("Player scores after ", roll_count+roll_hundreth)
# print("rolls. Player scores: ", p1_tot, p2_tot)

# only takes in the input.txt file and read each line
def read_file(name):
    file = open(name)
    return [line.strip() for line in file.readlines()]

# grabs the pos of the player at a line, split on the colon and whitespace
def parse(player):
    _, pos = player.split(': ')
    return int(pos) - 1

input = read_file("input.txt")
# for each line in the input, parse
position = [parse(player) for player in input]

# starting the die magic
result = roll_die(position)
print(f"Part 1: {result}")
