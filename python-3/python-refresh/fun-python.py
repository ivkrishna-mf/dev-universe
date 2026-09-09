# string operations
name = "Alice"
print(name.upper())  # Output: ALICE
print(name.lower())  # Output: alice

#count the each character in the string``
word = "spiderman home coming"
print(word.count("m"))  # Output: 2

# get the each letter count in word to a dictionary
letter_count = {}
for letter in word:
    if letter in letter_count:
        letter_count[letter] += 1
    else:
        letter_count[letter] = 1

print(letter_count)  # Output: {'s': 1, 'p': 1, 'i': 1, 'd': 1, 'e': 1, 'r': 1, 'a': 1, 'm': 2, ' ': 2, 'h': 1, 'o': 2, 'c': 1, 'n': 1, 'g': 1}
