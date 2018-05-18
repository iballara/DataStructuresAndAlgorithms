import sys

input = sys.stdin.read()
print(input)
tokens = input.split()
print(tokens)
a = int(tokens[0])
b = int(tokens[1])
print(a+b)
