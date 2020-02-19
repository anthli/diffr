# Diffr
Just another diff tool.

Diffr is a web application to help visualize the diff between two bodies of
text.

### Introduction
Many have used (or will use) a diff tool at some point in their life as
a developer. However, not everyone asks themselves "how does it really work?".

This project started from wanting to learn what really happens behind the scenes
when running the command `git diff`. While not intended to be a clone, this
project serves as a learning experience into what constructs a diff.

### Diff Algorithm
The implementation of the diff algorithm used in this project is based on the
dynamic programming solution for the Longest Common Subsequence found
[here](https://en.wikipedia.org/wiki/Longest_common_subsequence_problem).